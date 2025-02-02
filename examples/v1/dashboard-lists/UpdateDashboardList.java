// Update a dashboard list returns "OK" response

import com.datadog.api.v1.client.ApiClient;
import com.datadog.api.v1.client.ApiException;
import com.datadog.api.v1.client.Configuration;
import com.datadog.api.v1.client.api.DashboardListsApi;
import com.datadog.api.v1.client.model.DashboardList;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    DashboardListsApi apiInstance = new DashboardListsApi(defaultClient);

    // there is a valid "dashboard_list" in the system
    Long DASHBOARD_LIST_ID = Long.parseLong(System.getenv("DASHBOARD_LIST_ID"));

    DashboardList body =
        new DashboardList().name("updated Example-Update_a_dashboard_list_returns_OK_response");

    try {
      DashboardList result = apiInstance.updateDashboardList(DASHBOARD_LIST_ID, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DashboardListsApi#updateDashboardList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
