package com.datadog.api.v1.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import static org.junit.Assert.*;

import com.datadog.api.v1.client.ApiClient;
import com.datadog.api.v1.client.ApiResponse;
import com.datadog.api.RecordingMode;
import com.datadog.api.TestUtils;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;


public class ClientSteps extends V1ApiTest {

    private static ApiClient client;
    private Class apiClass;
    private static Object api;
    private static Object request;
    private static String body;
    private static Method requestBuilder;
    private static ApiResponse<?> response;

    private HashMap<String, Object> context;

    @Before
    public void setupClient(Scenario scenario) {
        client = new ApiClient();

        client.setServerIndex(0);

        // Set debugging based on env
        client.setDebugging("true".equals(System.getenv("DEBUG")));

        // Set proxy to the mockServer for recording
        /*
        if (!TestUtils.getRecordingMode().equals(RecordingMode.MODE_REPLAYING)) {
            if (!(TestUtils.isIbmJdk() || TestUtils.getRecordingMode().equals(RecordingMode.MODE_IGNORE))) {
                ClientConfig config = (ClientConfig) client.getHttpClient().getConfiguration();
                config.connectorProvider(new HttpUrlConnectorProvider().connectionFactory(new TestUtils.MockServerProxyConnectionFactory()));
            }
        } else {
            // Set base path to the mock server for replaying
            client.setBasePath("https://" + TestUtils.MOCKSERVER_HOST + ":" + TestUtils.MOCKSERVER_PORT);
            client.setServerIndex(null);
        }
        */

        client.addDefaultHeader("JAVA-TEST-NAME", name.getMethodName());
    }

    @Before
    public void setupContext(Scenario scenario) {
        context = new HashMap<String, Object>();
        String unique = "java-unique"; // getUniqueEntityName();
        context.put("unique", unique);
        context.put("unique_lower", unique.toLowerCase());
    }

    @Override
    public String getTracingEndpoint() {
        return "features";
    }

    @Given("an instance of {string} API")
    public void anInstanceOfAPI(String apiName) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        apiClass = Class.forName("com.datadog.api.v1.client.api." + toClassName(apiName) + "Api");
        api = apiClass.getConstructor(ApiClient.class).newInstance(client);
    }

    @Given("new {string} request")
    public void newRequest(String methodName) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        requestBuilder = apiClass.getMethod(toMethodName(methodName));
    }

    @When("the request is sent")
    public void theRequestIsSent() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        Class requestClass = requestBuilder.getReturnType();
        response = (ApiResponse<?>) requestClass.getMethod("executeWithHttpInfo").invoke(requestBuilder.invoke(api));
    }

    @Then("the response status is {int} {}")
    public void theResponseStatusIsOK(Integer statusCode, String _) {
        assertTrue(statusCode == response.getStatusCode());
    }
}
