package com.datadog.api.v2.client.api;

import com.datadog.api.v2.client.model.RoleCreateResponse;
import com.datadog.api.v2.client.model.ServiceResponse;
import com.datadog.api.v2.client.model.TeamResponse;
import com.datadog.api.v2.client.model.UserResponse;

public class Undo {
    public static void createUser(UsersApi api, Object response) throws com.datadog.api.v2.client.ApiException {
        UserResponse r = (UserResponse) response;
        api.disableUser(r.getData().getId());
    }

    public static void createRole(RolesApi api, Object response) throws com.datadog.api.v2.client.ApiException {
        RoleCreateResponse r = (RoleCreateResponse) response;
        api.deleteRole(r.getData().getId());
    }

    public static void createTeam(TeamsApi api, Object response) throws com.datadog.api.v2.client.ApiException {
        TeamResponse r = (TeamResponse) response;

        api.getApiClient().setUnstableOperationEnabled("deleteTeam", true);
        api.deleteTeam(r.getData().getId());
        api.getApiClient().setUnstableOperationEnabled("deleteTeam", false);
    }

    public static void createService(ServicesApi api, Object response) throws com.datadog.api.v2.client.ApiException {
        ServiceResponse r = (ServiceResponse) response;

        api.getApiClient().setUnstableOperationEnabled("deleteService", true);
        api.deleteService(r.getData().getId());
        api.getApiClient().setUnstableOperationEnabled("deleteService", false);
    }
}
