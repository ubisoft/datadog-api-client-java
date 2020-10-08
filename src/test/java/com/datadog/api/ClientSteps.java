package com.datadog.api;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientSteps extends TestUtils.APITest {

    private static String apiVersion;

    private Class<?> clientClass;
    private static Object client; // ApiClient
    private Class<?> apiClass;
    private static Object api;
    private static Object request;
    private static String body;
    private static Class requestClass;
    private static Method requestBuilder;
    private HashMap<String, Object> requestParams;
    private Class<?> responseClass;
    private static Object response; // ApiResponse<?>

    private HashMap<String, Object> context;

    @Before
    public void setupVersion(Scenario scenario) {
        String[] parts = scenario.getUri().toString().split("/");
        // get version
        // src/test/resources/com/datadog/api/>>>v2<<</client/api/teams.feature
        apiVersion = parts[parts.length - 4];
        // TODO scenario.getSourceTagNames();
    }

    @Before
    public void setupClient() throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // import com.datadog.api.{{ apiVersion }}.client.ApiClient;
        clientClass = Class.forName("com.datadog.api." + apiVersion + ".client.ApiClient");
        // client = new ApiClient();
        client = clientClass.getConstructor().newInstance();

        // client.setServerIndex(0);

        // Set debugging based on env
        // client.setDebugging("true".equals(System.getenv("DEBUG")));

        // Set proxy to the mockServer for recording
        /*
         * if (!TestUtils.getRecordingMode().equals(RecordingMode.MODE_REPLAYING)) { if
         * (!(TestUtils.isIbmJdk() ||
         * TestUtils.getRecordingMode().equals(RecordingMode.MODE_IGNORE))) {
         * ClientConfig config = (ClientConfig)
         * client.getHttpClient().getConfiguration(); config.connectorProvider(new
         * HttpUrlConnectorProvider().connectionFactory(new
         * TestUtils.MockServerProxyConnectionFactory())); } } else { // Set base path
         * to the mock server for replaying client.setBasePath("https://" +
         * TestUtils.MOCKSERVER_HOST + ":" + TestUtils.MOCKSERVER_PORT);
         * client.setServerIndex(null); }
         */

        // client.addDefaultHeader("JAVA-TEST-NAME", name.getMethodName());
    }

    @Before
    public void setupContext() {
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
    public static <T> T getPropertyValue(Object obj, String field)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        Field f = clazz.getDeclaredField(field);
        f.setAccessible(true);
        Object ret = f.get(obj);

        return (T) ret;
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromClass(Class<T> clazz, Object obj)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        return (T) obj;
    }

    public Object lookup(Object data, String path)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        Object result = data;
        for (String dotPart : Arrays.asList(path.split("(?<=\\.)"))) {
            dotPart = dotPart.replaceAll("\\.", "");
            for (String part : Arrays.asList(dotPart.split("(?<=\\[)"))) {
                System.out.printf("- %s\n", part);
                if (part.indexOf("]") != -1) {
                    Integer index = Integer.parseInt(part.replaceAll("]", ""));
                    result = List.class.cast(result).get(index);
                } else {
                    try {
                        result = HashMap.class.cast(result).get(part);
                    } catch (Exception e) {
                        System.out.printf("\n\n%s\n\n", result.toString());
                        result = getPropertyValue(result, part);
                    }

                }
            }
        }
        return result;
    }

    public String templated(String source) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        return Pattern.compile("\\{\\{ ?([^ }]+) ?\\}\\}").matcher(source).replaceAll(m -> {
            try {
                return lookup(context, m.group(1)).toString();
            } catch (Exception e) {
                return null;
            }

        });
    }

    public <T> T fromJSON(Class<T> clazz, String data)
            throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException, com.fasterxml.jackson.core.JsonProcessingException {
        Object json = clientClass.getMethod("getJSON").invoke(client);
        Class jsonClass = Class.forName("com.datadog.api." + apiVersion + ".client.JSON");
        ObjectMapper mapper = (ObjectMapper) jsonClass.getMethod("getMapper").invoke(json);
        System.out.printf("JSON.decode(%s) -> %s", data, clazz.getName());
        return mapper.readValue(data, clazz);
    }

    @Given("an instance of {string} API")
    public void anInstanceOfAPI(String apiName) throws java.lang.ClassNotFoundException, java.lang.NoSuchFieldException,
            java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException {
        // import com.datadog.api.{{ apiVersion }}.client.api.{{ apiName }}Api;
        apiClass = Class.forName("com.datadog.api." + apiVersion + ".client.api." + toClassName(apiName) + "Api");
        // api = new {{ apiName }}Api(client);
        api = apiClass.getConstructor(clientClass).newInstance(client);
    }

    @Given("operation {string} enabled")
    public void operationEnabled(String operationId)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // client.setUnstableOperationEnabled(operationId, true);
        clientClass.getMethod("setUnstableOperationEnabled", String.class, boolean.class).invoke(client,
                toMethodName(operationId), true);
    }

    @Given("a valid \"apiKeyAuth\" key in the system")
    public void aValidApiKeyInTheSystem()
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("apiKeyAuth", System.getenv(TEST_API_KEY_NAME));
        // client.configureApiKeys(secrets);
        clientClass.getMethod("configureApiKeys", HashMap.class).invoke(client, secrets);
    }

    @Given("a valid \"appKeyAuth\" key in the system")
    public void aValidAppKeyInTheSystem()
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("appKeyAuth", System.getenv(TEST_APP_KEY_NAME));
        // client.configureApiKeys(secrets);
        clientClass.getMethod("configureApiKeys", HashMap.class).invoke(client, secrets);
    }

    @Given("new {string} request")
    public void newRequest(String methodName) throws java.lang.IllegalAccessException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        requestParams = new HashMap<String, Object>();
        methodName = toMethodName(methodName);
        for (Method method : apiClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                requestBuilder = method;
                requestClass = method.getReturnType();
                break;
            }
        }
    }

    @Given("request contains {string} parameter from {string}")
    public void requestContainsParameterFrom(String parameterName, String fixturePath)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        requestParams.put(toPropertyName(parameterName), lookup(context, fixturePath));
    }

    @Given("request contains {string} parameter with value {}")
    public void requestContainsParameterWithValue(String parameterName, String value)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException {
        String propertyName = toPropertyName(parameterName);
        Field field = requestClass.getDeclaredField(propertyName);
        requestParams.put(propertyName, fromJSON(field.getType(), value));
    }

    @Given("body {}")
    public void setBody(String data) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException,
            java.lang.ClassNotFoundException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException, com.fasterxml.jackson.core.JsonProcessingException {
        Field field = requestClass.getDeclaredField("body");
        requestParams.put("body", fromJSON(field.getType(), templated(data)));
    }

    @Given("there is a valid {string} in the system")
    public void thereIsAValidInTheSystem(String name) {
        System.out.println(name);
        context.put(name, new Object());
    }

    @When("the request is sent")
    public void theRequestIsSent() throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException, java.lang.InstantiationException {
        responseClass = Class.forName("com.datadog.api." + apiVersion + ".client.ApiResponse");

        Object request;
        if (requestBuilder.getParameterCount() > 0) {
            List<Object> parameters = new ArrayList<>();
            for (Parameter p : requestBuilder.getParameters()) {
                parameters.add(p.getType().newInstance()); // requestParams.get(p.getName())
                System.out.println(p.getName());
            }
            System.out.println(parameters);
            request = requestBuilder.invoke(api, "");
        } else {
            request = requestBuilder.invoke(api);
        }

        System.out.printf("request before %s\n", request);

        for (Field f : requestClass.getDeclaredFields()) {
            System.out.printf("%s : %s\n", f.getName(), f.getType());
            if (requestParams.containsKey(f.getName())) {
                System.out.printf("%s %s\n", f.getName(), requestParams.get(f.getName()));
                f.setAccessible(true);
                f.set(request, requestParams.get(f.getName()));
            }
        }
        System.out.printf("request after %s\n", request);

        response = requestClass.getMethod("executeWithHttpInfo").invoke(request);
        // System.out.printf("%s\n",
        // responseClass.getMethod("getStatusCode").invoke(response));
    }

    @Then("the response status is {int} {}")
    public void theResponseStatusIsOK(Integer statusCode, String _)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Integer responseStatusCode = (Integer) responseClass.getMethod("getStatusCode").invoke(response);
        assertEquals(statusCode, responseStatusCode);
    }

    @Then("the response {string} is equal to {}")
    public void theResponseIsEqualTo(String responsePath, String value)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException,
            java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Object responseData = responseClass.getMethod("getData").invoke(response);
        System.out.println(lookup(responseData, responsePath));
        System.out.println(value);
    }

    @Then("the response {string} is false")
    public void theResponseIsFalse(String responsePath)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
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
