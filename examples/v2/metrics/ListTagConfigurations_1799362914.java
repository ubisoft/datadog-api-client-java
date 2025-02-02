// List tag configurations with a tag filter returns "Success" response

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiException;
import com.datadog.api.v2.client.Configuration;
import com.datadog.api.v2.client.api.MetricsApi;
import com.datadog.api.v2.client.api.MetricsApi.ListTagConfigurationsOptionalParameters;
import com.datadog.api.v2.client.model.MetricsAndMetricTagConfigurationsResponse;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setUnstableOperationEnabled("listTagConfigurations", true);
    MetricsApi apiInstance = new MetricsApi(defaultClient);

    try {
      MetricsAndMetricTagConfigurationsResponse result =
          apiInstance.listTagConfigurations(
              new ListTagConfigurationsOptionalParameters()
                  .filterTags("ExampleListtagconfigurationswithatagfilterreturnsSuccessresponse"));
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MetricsApi#listTagConfigurations");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
