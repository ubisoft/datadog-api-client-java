// Create a new dashboard with alert_graph widget

import com.datadog.api.v1.client.ApiClient;
import com.datadog.api.v1.client.ApiException;
import com.datadog.api.v1.client.Configuration;
import com.datadog.api.v1.client.api.DashboardsApi;
import com.datadog.api.v1.client.model.AlertGraphWidgetDefinition;
import com.datadog.api.v1.client.model.AlertGraphWidgetDefinitionType;
import com.datadog.api.v1.client.model.Dashboard;
import com.datadog.api.v1.client.model.DashboardLayoutType;
import com.datadog.api.v1.client.model.DashboardTemplateVariable;
import com.datadog.api.v1.client.model.Widget;
import com.datadog.api.v1.client.model.WidgetDefinition;
import com.datadog.api.v1.client.model.WidgetLayout;
import com.datadog.api.v1.client.model.WidgetTextAlign;
import com.datadog.api.v1.client.model.WidgetTime;
import com.datadog.api.v1.client.model.WidgetVizType;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    DashboardsApi apiInstance = new DashboardsApi(defaultClient);

    // there is a valid "monitor" in the system
    Long MONITOR_ID = Long.parseLong(System.getenv("MONITOR_ID"));

    Dashboard body =
        new Dashboard()
            .title("Example-Create_a_new_dashboard_with_alert_graph_widget")
            .description("")
            .widgets(
                new ArrayList<Widget>() {
                  {
                    add(
                        new Widget()
                            .layout(new WidgetLayout().x(0L).y(0L).width(47L).height(15L))
                            .definition(
                                new WidgetDefinition(
                                    new AlertGraphWidgetDefinition()
                                        .title("")
                                        .titleSize("16")
                                        .titleAlign(WidgetTextAlign.LEFT)
                                        .time(new WidgetTime())
                                        .type(AlertGraphWidgetDefinitionType.ALERT_GRAPH)
                                        .alertId("1")
                                        .vizType(WidgetVizType.TIMESERIES))));
                  }
                })
            .templateVariables(
                new ArrayList<DashboardTemplateVariable>() {
                  {
                    ;
                  }
                })
            .layoutType(DashboardLayoutType.FREE)
            .isReadOnly(false)
            .notifyList(
                new ArrayList<String>() {
                  {
                    ;
                  }
                });

    try {
      Dashboard result = apiInstance.createDashboard(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DashboardsApi#createDashboard");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
