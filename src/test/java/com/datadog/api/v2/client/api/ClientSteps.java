package com.datadog.api.v2.client.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import java.lang.reflect.Method;
import java.util.HashMap;
import static org.junit.Assert.*;

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiResponse;

public class ClientSteps extends V2APITest {

    private static ApiClient client;
    private Class apiClass;
    private static Object api;
    private static Object request;
    private static String body;
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
        apiClass = Class.forName("com.datadog.api.v2.client.api." + toClassName(apiName) + "Api");
        api = apiClass.getConstructor(ApiClient.class).newInstance(client);
    }

    @Given("operation {string} enabled")
    public void operationEnabled(String operationId) {
        client.setUnstableOperationEnabled(toMethodName(operationId), true);
    }

    @Given("a valid \"apiKeyAuth\" key in the system")
    public void aValidApiKeyInTheSystem() {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("apiKeyAuth", System.getenv(TEST_API_KEY_NAME));
        client.configureApiKeys(secrets);
    }

    @Given("a valid \"appKeyAuth\" key in the system")
    public void aValidAppKeyInTheSystem() {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("appKeyAuth", System.getenv(TEST_APP_KEY_NAME));
        client.configureApiKeys(secrets);
    }

    @Given("new {string} request")
    public void newRequest(String methodName) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        requestBuilder = apiClass.getMethod(toMethodName(methodName));
    }

    @Given("request contains {string} parameter from {string}")
    public void requestContainsParameterFrom(String parameterName, String fixturePath) {
        System.out.println(parameterName);
        System.out.println(fixturePath);
    }

    @Given("request contains {string} parameter with value {}")
    public void requestContainsParameterWithValue(String parameterName, String value) {
        System.out.println(parameterName);
        System.out.println(value);
    }

    @Given("body {}")
    public void setBody(String data) {
        body = data;
    }

    @Given("there is a valid {string} in the system")
    public void thereIsAValidInTheSystem(String name) {
        System.out.println(name);
    }

    @When("the request is sent")
    public void theRequestIsSent() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        Class requestClass = requestBuilder.getReturnType();
        // response = (ApiResponse<?>) requestClass.getMethod("executeWithHttpInfo").invoke(requestBuilder.invoke(api));
    }

    @Then("the response status is {int} {}")
    public void theResponseStatusIsOK(Integer statusCode, String _) {
        assertTrue(statusCode == response.getStatusCode());
    }

    @Then("the response {string} is equal to {}")
    public void theResponseIsEqualTo(String responsePath, String value) {
        System.out.println(responsePath);
        System.out.println(value);
    }

    @Then("the response {string} is false")
    public void theResponseIsFalse(String responsePath) {
        System.out.println(responsePath);
    }

    @Then("the response {string} has the same value as {string}")
    public void theResponseHasTheSameValueAs(String responsePath, String fixturePath) {
        assertEquals(fixturePath, responsePath);
    }

    // specific v2 objects
    @Given("the {string} is granted to the {string}")
    public void theIsGrantedToThe(String string, String string2) {

    }

    @Given("the {string} has the {string}")
    public void theHasThe(String string, String string2) {

    }

    @Given("the {string} has a {string}")
    public void theHasA(String string, String string2) {

    }
}
