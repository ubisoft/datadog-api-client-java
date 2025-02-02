// Edit an app key owned by this service account returns "OK" response

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiException;
import com.datadog.api.v2.client.Configuration;
import com.datadog.api.v2.client.api.ServiceAccountsApi;
import com.datadog.api.v2.client.model.ApplicationKeyUpdateAttributes;
import com.datadog.api.v2.client.model.ApplicationKeyUpdateData;
import com.datadog.api.v2.client.model.ApplicationKeyUpdateRequest;
import com.datadog.api.v2.client.model.ApplicationKeysType;
import com.datadog.api.v2.client.model.PartialApplicationKeyResponse;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ServiceAccountsApi apiInstance = new ServiceAccountsApi(defaultClient);

    // there is a valid "service_account_user" in the system
    String SERVICE_ACCOUNT_USER_DATA_ID = System.getenv("SERVICE_ACCOUNT_USER_DATA_ID");

    // there is a valid "service_account_application_key" for "service_account_user"
    String SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ATTRIBUTES_NAME =
        System.getenv("SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ATTRIBUTES_NAME");
    String SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ID =
        System.getenv("SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ID");

    ApplicationKeyUpdateRequest body =
        new ApplicationKeyUpdateRequest()
            .data(
                new ApplicationKeyUpdateData()
                    .id(SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ID)
                    .type(ApplicationKeysType.APPLICATION_KEYS)
                    .attributes(
                        new ApplicationKeyUpdateAttributes()
                            .name("Application Key for managing dashboards-updated")));

    try {
      PartialApplicationKeyResponse result =
          apiInstance.updateServiceAccountApplicationKey(
              SERVICE_ACCOUNT_USER_DATA_ID, SERVICE_ACCOUNT_APPLICATION_KEY_DATA_ID, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println(
          "Exception when calling ServiceAccountsApi#updateServiceAccountApplicationKey");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
