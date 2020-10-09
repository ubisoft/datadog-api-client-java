package com.datadog.api;

import java.util.HashMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.fasterxml.jackson.databind.ObjectMapper;

public class World {
    // Client information
    Class<?> clientClass;
    Object client; // ApiClient

    // Specific API information
    Class<?> apiClass;
    Object api;

    // Templating context
    HashMap<String, Object> context;

    // Request information
    Class requestClass;
    Method requestBuilder;
    HashMap<String, Object> requestParams;

    // Response information
    Class<?> responseClass;
    Object response; // ApiResponse<?>

    public World() {
        context = new HashMap<String, Object>();
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

    public void undoRequest() throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException,
            java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Class undoClass = Class.forName(apiClass.getPackageName() + ".Undo");
        Method dataMethod = responseClass.getMethod("getData");
        System.out.println(dataMethod.getReturnType());
        Method undoMethod = undoClass.getMethod(requestBuilder.getName(), apiClass, dataMethod.getReturnType());
        System.out.println(undoMethod.getName());
        undoMethod.invoke(null, apiClass.cast(api), dataMethod.invoke(response));
    }

    public void sendRequest() throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException,
            java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException,
            com.fasterxml.jackson.core.JsonProcessingException, java.lang.InstantiationException {
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
        response = responseMethod.invoke(request);

        undoRequest();
    }

    public <T> T fromJSON(Class<T> clazz, String data)
            throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException,
            java.lang.reflect.InvocationTargetException, com.fasterxml.jackson.core.JsonProcessingException {
        Method getJSON = clientClass.getMethod("getJSON");
        Object json = getJSON.invoke(client);
        Class jsonClass = getJSON.getReturnType();
        ObjectMapper mapper = (ObjectMapper) jsonClass.getMethod("getMapper").invoke(json);
        return mapper.readValue(data, clazz);
    }
}
