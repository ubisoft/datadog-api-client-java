package com.datadog.api;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.OffsetDateTime;
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
import com.datadog.api.v2.client.api.Undo;
import com.datadog.api.v2.client.api.UsersApi;
import com.datadog.api.v2.client.ApiClient;
import com.datadog.api.v2.client.model.UserCreateAttributes;
import com.datadog.api.v2.client.model.UserCreateData;
import com.datadog.api.v2.client.model.UserCreateRequest;
import com.datadog.api.v2.client.model.UserResponse;

public class ClientSteps {
    protected static final String TEST_API_KEY_NAME = "DD_TEST_CLIENT_API_KEY";
    protected static final String TEST_APP_KEY_NAME = "DD_TEST_CLIENT_APP_KEY";

    private static String apiVersion;

    private Scenario currentScenario;

    protected OffsetDateTime now;

    private World world;

    public ClientSteps(World world) {
        this.world = world;
    }

    @Before(order = 0)
    public void setupVersion(Scenario scenario) throws java.io.IOException {
        currentScenario = scenario;
        // setupClock();
        now = OffsetDateTime.now();
        String[] parts = scenario.getUri().toString().split("/");
        // get version
        // src/test/resources/com/datadog/api/>>>v2<<</client/api/teams.feature
        apiVersion = parts[parts.length - 4];
        // TODO scenario.getSourceTagNames();
    }

    public String getUniqueEntityName() {
        // NOTE: some endpoints have limits on certain fields (e.g. Roles V2 names can
        // only be 55 chars long),
        // so we need to keep this short
        String name = Pattern.compile("[^A-Za-z0-9]+").matcher(currentScenario.getName()).replaceAll("_");
        String result = String.format("java-%s-%d", name.substring(0, 20), now.toEpochSecond());
        // In case this is used in URL, make sure we replace potential slash
        return result;
    }

    public String getUniqueEntityName(int maxLen) {
        String result = getUniqueEntityName();
        if (result.length() > maxLen) {
            result = result.substring(0, maxLen);
        }
        return result;
    }

    @Before(order = 1)
    public void setupClient() throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        world.setupClient(apiVersion);
    }

    @Before(order = 2)
    public void setupContext() {
        String unique = getUniqueEntityName();
        world.context.put("unique", unique);
        world.context.put("unique_lower", unique.toLowerCase());
    }

    @Given("an instance of {string} API")
    public void anInstanceOfAPI(String apiName) throws java.lang.ClassNotFoundException, java.lang.NoSuchFieldException,
            java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException {
        world.setupAPI(apiVersion, toClassName(apiName));
    }

    @Given("operation {string} enabled")
    public void operationEnabled(String operationId)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // client.setUnstableOperationEnabled(operationId, true);
        world.setUnstableOperationEnabled(toMethodName(operationId));
    }

    @Given("a valid \"apiKeyAuth\" key in the system")
    public void aValidApiKeyInTheSystem()
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("apiKeyAuth", System.getenv(TEST_API_KEY_NAME));
        world.configureApiKeys(secrets);
    }

    @Given("a valid \"appKeyAuth\" key in the system")
    public void aValidAppKeyInTheSystem()
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("appKeyAuth", System.getenv(TEST_APP_KEY_NAME));
        world.configureApiKeys(secrets);
    }

    @Given("new {string} request")
    public void newRequest(String methodName) throws java.lang.IllegalAccessException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        world.newRequest(toMethodName(methodName));
    }

    @Given("request contains {string} parameter from {string}")
    public void requestContainsParameterFrom(String parameterName, String fixturePath)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        world.requestParams.put(toPropertyName(parameterName), lookup(world.context, fixturePath));
    }

    @Given("request contains {string} parameter with value {}")
    public void requestContainsParameterWithValue(String parameterName, String value)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException {
        String propertyName = toPropertyName(parameterName);
        Field field = world.requestClass.getDeclaredField(propertyName);
        world.requestParams.put(propertyName, world.fromJSON(field.getType(), value));
    }

    @Given("body {}")
    public void setBody(String data) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException,
            java.lang.ClassNotFoundException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException, com.fasterxml.jackson.core.JsonProcessingException {
        Field field = world.requestClass.getDeclaredField("body");
        world.requestParams.put("body", world.fromJSON(field.getType(), templated(world.context, data)));
    }

    @When("the request is sent")
    public void theRequestIsSent() throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException, java.lang.InstantiationException {
        world.sendRequest();
    }

    @Then("the response status is {int} {}")
    public void theResponseStatusIsOK(Integer statusCode, String _)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        Integer responseStatusCode = (Integer) world.responseClass.getMethod("getStatusCode").invoke(world.response);
        assertEquals(statusCode, responseStatusCode);
    }

    @Then("the response {string} is equal to {}")
    public void theResponseIsEqualTo(String responsePath, String value)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException,
            java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException,
            com.fasterxml.jackson.core.JsonProcessingException {
        Object responseData = world.responseClass.getMethod("getData").invoke(world.response);
        Object responseValue = lookup(responseData, responsePath);
        assertEquals(world.fromJSON(responseValue.getClass(), templated(world.context, value)), responseValue);
    }

    @Then("the response {string} is false")
    public void theResponseIsFalse(String responsePath) throws java.lang.reflect.InvocationTargetException,
            java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.NoSuchMethodException,
            java.lang.ClassNotFoundException, java.lang.NoSuchFieldException {
        Object responseData = world.responseClass.getMethod("getData").invoke(world.response);
        assertFalse((Boolean) lookup(responseData, responsePath));
    }

    @Then("the response {string} has the same value as {string}")
    public void theResponseHasTheSameValueAs(String responsePath, String fixturePath)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException,
            java.lang.NoSuchFieldException {
        Object responseData = world.responseClass.getMethod("getData").invoke(world.response);
        assertEquals(lookup(world.context, fixturePath), lookup(responseData, responsePath));
    }

    // specific actions
    @Given("there is a valid {string} in the system")
    public void thereIsAValidInTheSystem(String name) throws com.datadog.api.v2.client.ApiException {
        if (name.equals("user")) {
            final String testingUserName = getUniqueEntityName().toLowerCase();
            final String testingUserHandle = testingUserName + "@datadoghq.com";
            UserCreateAttributes uca = new UserCreateAttributes().email(testingUserHandle).name(testingUserName);
            UserCreateData ucd = new UserCreateData().attributes(uca);
            UserCreateRequest ucr = new UserCreateRequest().data(ucd);
            UsersApi usersAPI = new UsersApi((ApiClient) world.client);
            UserResponse ur = usersAPI.createUser().body(ucr).execute();
            world.context.put(name, ur);
            Undo.createUser(usersAPI, (Object) ur);
        } else {
            throw new RuntimeException(name);
        }
    }

    @Given("the {string} is granted to the {string}")
    public void theIsGrantedToThe(String string, String string2) {
        assertTrue(false);
    }

    @Given("the {string} has the {string}")
    public void theHasThe(String string, String string2) {
        assertTrue(false);
    }

    @Given("the {string} has a {string}")
    public void theHasA(String string, String string2) {
        assertTrue(false);
    }

    /*
     * Convert an identifier to class name.
     */
    public static String toClassName(String identifier) {
        return Pattern.compile("([A-Z])([A-Z]+)([A-Z][a-z])").matcher(identifier).replaceAll(m -> {
            return m.group(1) + m.group(2).toLowerCase() + m.group(3);
        });
    }

    /*
     * Convert an identifier to method name.
     */
    public static String toMethodName(String identifier) {
        return Pattern.compile("^([A-Z])").matcher(identifier).replaceAll(m -> {
            return m.group(1).toLowerCase();
        });
    }

    /*
     * Convert an identifier to property name.
     */
    public static String toPropertyName(String identifier) {
        identifier = Pattern.compile("_(.)").matcher(identifier).replaceAll(m -> {
            return m.group(1).toUpperCase();
        });
        return Pattern.compile("\\[(.)([^]]*)\\]").matcher(identifier).replaceAll(m -> {
            return m.group(1).toUpperCase() + m.group(2);
        });
    }

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

    public static Object lookup(Object data, String path)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        Object result = data;
        for (String dotPart : Arrays.asList(path.split("(?<=\\.)"))) {
            dotPart = dotPart.replaceAll("\\.", "");
            for (String part : Arrays.asList(dotPart.split("(?<=\\[)"))) {
                if (part.indexOf("]") != -1) {
                    Integer index = Integer.parseInt(part.replaceAll("]", ""));
                    result = List.class.cast(result).get(index);
                } else {
                    part = part.replaceAll("\\[", "");
                    try {
                        result = HashMap.class.cast(result).get(part);
                    } catch (Exception e) {
                        result = getPropertyValue(result, toPropertyName(part));
                    }

                }
            }
        }
        return result;
    }

    public static String templated(Object context, String source)
            throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        return Pattern.compile("\\{\\{ ?([^ }]+) ?\\}\\}").matcher(source).replaceAll(m -> {
            try {
                return lookup(context, m.group(1)).toString();
            } catch (Exception e) {
                return null;
            }

        });
    }

}
