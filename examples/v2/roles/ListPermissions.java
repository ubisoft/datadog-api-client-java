// List permissions returns "OK" response

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiException;
import com.datadog.api.v2.client.Configuration;
import com.datadog.api.v2.client.api.RolesApi;
import com.datadog.api.v2.client.model.PermissionsResponse;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    RolesApi apiInstance = new RolesApi(defaultClient);

    try {
      PermissionsResponse result = apiInstance.listPermissions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#listPermissions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
