package com.datadog.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Scenario;

public class World {
    // Client information
    Class<?> clientClass;
    public Object client; // ApiClient

    // Specific API information
    Class<?> apiClass;
    public Object api;

    // Templating context
    public Map<String, Object> context;

    // Request information
    Class<?> requestClass;
    Method requestBuilder;
    Map<String, Object> requestParams;

    // Response information
    Class<?> responseClass;
    Object response; // ApiResponse<?>

    // Name control
    Scenario scenario;
    OffsetDateTime now;

    static String[] noUndo = { "add", "aggregateLogs", "delete", "disable", "get", "list", "remove", "sendInvitations",
            "update", };

    public World() {
        context = new HashMap<>();
        now = OffsetDateTime.now();
    }

    public void setupClient(String apiVersion)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // import com.datadog.api.{{ apiVersion }}.client.ApiClient
        clientClass = Class.forName("com.datadog.api." + apiVersion + ".client.ApiClient");
        // client = new ApiClient()
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

    public void setupAPI(String apiVersion, String apiName) throws java.lang.ClassNotFoundException,
            java.lang.NoSuchFieldException, java.lang.InstantiationException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        // import com.datadog.api.{{ apiVersion }}.client.api.{{ apiName }}Api
        apiClass = Class.forName("com.datadog.api." + apiVersion + ".client.api." + apiName + "Api");
        // api = new {{ apiName }}Api(client)
        api = apiClass.getConstructor(clientClass).newInstance(client);
    }

    public void setUnstableOperationEnabled(String operationId)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // client.setUnstableOperationEnabled(operationId, true)
        clientClass.getMethod("setUnstableOperationEnabled", String.class, boolean.class).invoke(client, operationId,
                true);
    }

    public void configureApiKeys(HashMap<String, String> secrets)
            throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException,
            java.lang.InstantiationException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        // client.configureApiKeys(secrets)
        clientClass.getMethod("configureApiKeys", HashMap.class).invoke(client, secrets);
    }

    public void newRequest(String methodName) {
        requestParams = new HashMap<String, Object>();
        for (Method method : apiClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                requestBuilder = method;
                requestClass = method.getReturnType();
                break;
            }
        }
    }

    public Method getRequestUndo() throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException {
        String actionName = requestBuilder.getName();
        if (Stream.of(noUndo).anyMatch(u -> actionName.startsWith(u))) {
            return null;
        }

        Class<?> undoClass = Class.forName(apiClass.getPackageName() + ".Undo");
        Method dataMethod = responseClass.getMethod("getData");
        return undoClass.getMethod(actionName, apiClass, dataMethod.getReturnType());
    }

    public void sendRequest() throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException {
        Object request;
        if (requestBuilder.getParameterCount() > 0) {
            Object[] parameters = new Object[requestBuilder.getParameterCount()];
            request = requestBuilder.invoke(api, parameters);
        } else {
            request = requestBuilder.invoke(api);
        }

        for (Field f : requestClass.getDeclaredFields()) {
            if (requestParams.containsKey(f.getName())) {
                f.setAccessible(true);
                f.set(request, requestParams.get(f.getName()));
            }
        }

        Method responseMethod = requestClass.getMethod("executeWithHttpInfo");
        responseClass = responseMethod.getReturnType();

        Method undoMethod = getRequestUndo();

        response = responseMethod.invoke(request);

        if (undoMethod != null) {
            // TODO append to undo list
            Method dataMethod = responseClass.getMethod("getData");
            undoMethod.invoke(null, apiClass.cast(api), dataMethod.invoke(response));
        }
    }

    public <T> T fromJSON(Class<T> clazz, String data)
            throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException, com.fasterxml.jackson.core.JsonProcessingException {
        Method getJSON = clientClass.getMethod("getJSON");
        Object json = getJSON.invoke(client);
        Class<?> jsonClass = getJSON.getReturnType();
        ObjectMapper mapper = (ObjectMapper) jsonClass.getMethod("getMapper").invoke(json);
        return mapper.readValue(data, clazz);
    }

    public String getUniqueEntityName() {
        // NOTE: some endpoints have limits on certain fields (e.g. Roles V2 names can
        // only be 55 chars long),
        // so we need to keep this short
        String name = Pattern.compile("[^A-Za-z0-9]+").matcher(scenario.getName()).replaceAll("_");
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
}
