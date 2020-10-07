package com.datadog.api.v1.client.api;

import com.datadog.api.v1.client.ApiClient;
import com.datadog.api.v1.client.ApiResponse;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import java.lang.reflect.Method;


public class ClientSteps extends V1ApiTest {

    private static ApiClient client;
    private Class apiClass;
    private static Object api;
    private static Object request;
    private static Method requestBuilder;
    private static ApiResponse<?> response;

    @Before
    public void single_argument(Scenario scenario) {
        client = new ApiClient();
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
