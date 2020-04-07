/*
 * Unless explicitly stated otherwise all files in this repository are licensed under the Apache-2.0 License.
 * This product includes software developed at Datadog (https://www.datadoghq.com/).
 * Copyright 2019-Present Datadog, Inc.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.datadog.api.v2.client.api;

import com.datadog.api.v1.client.model.User;
import com.datadog.api.v2.client.ApiException;
import com.datadog.api.v2.client.model.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UsersApi
 */
public class UsersApiTest extends V2APITest {

    private static UsersApi api = new UsersApi();
    private final String testingUserName = "Testing User";
    private final String testingUserTitle = "Bigboss";
    private ArrayList<String> disableUsers = null;

    @Before
    public void resetDisableUsers() {
        disableUsers = new ArrayList<String>();
    }

    @BeforeClass
    public static void initApi() {
        api = new UsersApi(generalApiClient);
    }

    @After
    public void disableUsers() throws ApiException {
        if (disableUsers != null) {
            for (String id: disableUsers) {
                UserResponsePayload urp = api.getUser(id).execute();
                if (!urp.getData().getAttributes().getDisabled()) {
                    api.disableUser(id).execute();
                }
            }
        }
    }

    public String generateUserHandle() {
        return "testinguser" + new Timestamp(System.currentTimeMillis()).getTime() + "@datadoghq.com";
    }

    @Test
    public void userLifecycleTest() throws ApiException {
        // TODO: test roles, permissions when we can
        // first, test creating a user
        final String testingUserHandle = generateUserHandle();
        UserCreateAttributes uca = new UserCreateAttributes()
                .email(testingUserHandle)
                .name(testingUserName)
                .title(testingUserTitle);
        UserCreateData ucd = new UserCreateData().attributes(uca);
        UserCreatePayload ucp = new UserCreatePayload().data(ucd);
        UserResponsePayload ur = api.createUser().body(ucp).execute();
        String uid = ur.getData().getId();
        disableUsers.add(uid);

        assertEquals(testingUserHandle, ur.getData().getAttributes().getEmail());
        assertEquals(testingUserName, ur.getData().getAttributes().getName());
        assertEquals(testingUserTitle, ur.getData().getAttributes().getTitle());

        // now, test updating it
        UserUpdateAttributes uua = new UserUpdateAttributes().disabled(false).name("Joe Doe");
        UserUpdateData uud = new UserUpdateData().attributes(uua).id(uid);
        UserUpdatePayload uup = new UserUpdatePayload().data(uud);
        // no response payload; we're ok if it didn't throw exception
        api.updateUser(uid).body(uup).execute();

        // now, test getting it
        UserResponsePayload urp = api.getUser(uid).execute();
        assertEquals(testingUserHandle, urp.getData().getAttributes().getEmail());
        assertEquals("Joe Doe", urp.getData().getAttributes().getName());
        assertFalse(urp.getData().getAttributes().getDisabled());

        // now, test disabling it
        // no response payload; we're of it it didn't throw exception
        api.disableUser(uid).execute();

        // now, test filtering for it in the list call
        UsersResponsePayload usrp = api.listUsers().filter(testingUserHandle).pageSize(1L).pageNumber(0L).execute();
        assertEquals(1, usrp.getData().size());
        assertEquals(testingUserHandle, usrp.getData().get(0).getAttributes().getHandle());

        // NOTE: to test getting a user organization, we'd need to have a "whoami" API endpoint
        // to get the UUID of the current user, but there's no such stable endpoint right now
        // (a user can only get organization for itself, never for a different user)
    }

    @Test
    public void userInvitationTest() throws ApiException {
        final String testingUserHandle = generateUserHandle();
        UserCreateAttributes uca = new UserCreateAttributes()
                .email(testingUserHandle)
                .name(testingUserName)
                .title(testingUserTitle);
        UserCreateData ucd = new UserCreateData().attributes(uca);
        UserCreatePayload ucp = new UserCreatePayload().data(ucd);
        UserResponsePayload ur = api.createUser().body(ucp).execute();
        String id = ur.getData().getId();

        // first, create the user invitation
        RelationshipToUserData rtud = new RelationshipToUserData().id(id);
        RelationshipToUser rtu = new RelationshipToUser().data(rtud);
        UserInvitationRelationships uir = new UserInvitationRelationships().user(rtu);
        UserInvitationData uid = new UserInvitationData().relationships(uir);
        List<UserInvitationData> luid = new ArrayList<>();
        luid.add(uid);
        UserInvitationPayload uip = new UserInvitationPayload().data(luid);

        UserInvitationsResponse resp = api.sendInvitations().body(uip).execute();
        String respId = resp.getData().get(0).getId();

        // now, test getting the invitation
        UserInvitationResponse oneresp = api.getInvitation(respId).execute();
        assertEquals(respId, oneresp.getData().getId());
    }
}
