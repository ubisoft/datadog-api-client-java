// Get all processes returns "OK" response

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiException;
import com.datadog.api.v2.client.Configuration;
import com.datadog.api.v2.client.api.ProcessesApi;
import com.datadog.api.v2.client.api.ProcessesApi.ListProcessesOptionalParameters;
import com.datadog.api.v2.client.model.ProcessSummariesResponse;
import java.time.*;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ProcessesApi apiInstance = new ProcessesApi(defaultClient);

    try {
      ProcessSummariesResponse result =
          apiInstance.listProcesses(
              new ListProcessesOptionalParameters()
                  .search("process-agent")
                  .tags("testing:true")
                  .pageLimit(2));
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProcessesApi#listProcesses");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
