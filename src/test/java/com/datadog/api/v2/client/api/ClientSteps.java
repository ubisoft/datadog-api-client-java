package com.datadog.api.v2.client.api;

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

import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.ApiResponse;
import com.datadog.api.RecordingMode;
import com.datadog.api.TestUtils;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;


public class ClientSteps extends V2APITest {

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

    @SuppressWarnings("unchecked")
    public static <T> T getPropertyValue(Object obj, String field) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        Field f = clazz.getDeclaredField(field);
        f.setAccessible(true);
        Object ret = f.get(obj);

        return (T) ret;
    }

    public Object lookup(String path) {
        Object result = context;
        System.out.printf("%s\n", Arrays.asList(path.split("(?<=\\.)")));
        for (String dotPart: Arrays.asList(path.split("(?<=\\.)"))) {
            dotPart = dotPart.replaceAll("\\.", "");
            System.out.println(dotPart);
            for (String part: Arrays.asList(dotPart.split("(?<=\\[)"))) {
                System.out.printf("%s -> %s\n", result, part);
                if (part.indexOf("]") != -1) {
                    Integer index = Integer.parseInt(part.replaceAll("]", ""));
                    result = List.class.cast(result).get(index);
                } else {
                    result = HashMap.class.cast(result).get(part);
                }
            }
        }
        return result;
    }

    public String templated(String source) {
        return Pattern.compile("\\{\\{ ?([^ }]+) ?\\}\\}").matcher(source).replaceAll(m -> {
            return lookup(m.group(1)).toString();
        });
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
        System.out.println(data);
        body = templated(data);
        System.out.println(body);
    }

    @Given("there is a valid {string} in the system")
    public void thereIsAValidInTheSystem(String name) {
        System.out.println(name);
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
