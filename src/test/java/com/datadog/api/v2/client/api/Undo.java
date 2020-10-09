package com.datadog.api.v2.client.api;

import com.datadog.api.v2.client.model.UserResponse;

public class Undo {
    public static void createUser(UsersApi api, Object response) throws com.datadog.api.v2.client.ApiException {
        UserResponse ur = (UserResponse) response;
        api.disableUser(ur.getData().getId());
    }

    public static void disableUser(UsersApi api, Object response) {
    }

    public static void getUser(UsersApi api, Object response) {
    }

    public static void listUsers(UsersApi api, Object response) {
    }

    public static void updateUser(UsersApi api, Object response) {
    }

    public static void sendInvitations(UsersApi api, Object response) {
    }

    public static void listUserPermissions(UsersApi api, Object response) {
    }
}
