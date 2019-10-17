# KeysApi

All URIs are relative to *https://api.datadoghq.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAPIKey**](KeysApi.md#createAPIKey) | **POST** /api/v1/api_key | Create an API key with a given name.
[**createApplicationKey**](KeysApi.md#createApplicationKey) | **POST** /api/v1/application_key | Create an application key with a given name.
[**deleteAPIKey**](KeysApi.md#deleteAPIKey) | **DELETE** /api/v1/api_key/{api_key} | Delete a given API key.
[**deleteApplicationKey**](KeysApi.md#deleteApplicationKey) | **DELETE** /api/v1/application_key/{app_key} | Delete a given application key.
[**editAPIKey**](KeysApi.md#editAPIKey) | **PUT** /api/v1/api_key/{api_key} | Edit an API key name.
[**editApplicationKey**](KeysApi.md#editApplicationKey) | **PUT** /api/v1/application_key/{app_key} | Edit an application key name.
[**getAPIKey**](KeysApi.md#getAPIKey) | **GET** /api/v1/api_key/{api_key} | Get a given API key.
[**getAllAPIKeys**](KeysApi.md#getAllAPIKeys) | **GET** /api/v1/api_key | Get all API keys available for your account.
[**getAllApplicationKeys**](KeysApi.md#getAllApplicationKeys) | **GET** /api/v1/application_key | Get all application keys available for your account.
[**getApplicationKey**](KeysApi.md#getApplicationKey) | **GET** /api/v1/application_key/{app_key} | Get a given application key.



## createAPIKey

> InlineResponse2001 createAPIKey(apiKey, applicationKey, createAndEditBody)

Create an API key with a given name.

## Overview
Creates an API key
### ARGUMENTS
* **`name`** [*required*]: Name of your API key.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        CreateAndEditBody createAndEditBody = new CreateAndEditBody(); // CreateAndEditBody | 
        try {
            InlineResponse2001 result = apiInstance.createAPIKey(apiKey, applicationKey, createAndEditBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#createAPIKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **createAndEditBody** | [**CreateAndEditBody**](CreateAndEditBody.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **409** | Conflict |  -  |


## createApplicationKey

> InlineResponse2003 createApplicationKey(apiKey, applicationKey, createAndEditBody)

Create an application key with a given name.

## Overview
Create an application key with a given name.
### ARGUMENTS
* **`name`** [*required*]: Name of your application key.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        CreateAndEditBody createAndEditBody = new CreateAndEditBody(); // CreateAndEditBody | 
        try {
            InlineResponse2003 result = apiInstance.createApplicationKey(apiKey, applicationKey, createAndEditBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#createApplicationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **createAndEditBody** | [**CreateAndEditBody**](CreateAndEditBody.md)|  | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **409** | Conflict |  -  |


## deleteAPIKey

> InlineResponse2001 deleteAPIKey(apiKey, applicationKey, apiKey2)

Delete a given API key.

## Overview
Delete a given API key.
### ARGUMENTS
This endpoint takes no JSON arguments.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String apiKey2 = "apiKey_example"; // String | The specific API key you are working with
        try {
            InlineResponse2001 result = apiInstance.deleteAPIKey(apiKey, applicationKey, apiKey2);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#deleteAPIKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **apiKey2** | **String**| The specific API key you are working with |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## deleteApplicationKey

> InlineResponse2003 deleteApplicationKey(apiKey, applicationKey, appKey)

Delete a given application key.

## Overview
Delete a given application key.
### ARGUMENTS
* **`name`** [*required*]: Name of your application key.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String appKey = "appKey_example"; // String | The specific APP key you are working with
        try {
            InlineResponse2003 result = apiInstance.deleteApplicationKey(apiKey, applicationKey, appKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#deleteApplicationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **appKey** | **String**| The specific APP key you are working with |

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## editAPIKey

> InlineResponse2001 editAPIKey(apiKey, applicationKey, apiKey2, createAndEditBody)

Edit an API key name.

## Overview
Edit an API key name.
### ARGUMENTS
* **`name`** [*required*]: Name of your API key.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String apiKey2 = "apiKey_example"; // String | The specific API key you are working with
        CreateAndEditBody createAndEditBody = new CreateAndEditBody(); // CreateAndEditBody | 
        try {
            InlineResponse2001 result = apiInstance.editAPIKey(apiKey, applicationKey, apiKey2, createAndEditBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#editAPIKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **apiKey2** | **String**| The specific API key you are working with |
 **createAndEditBody** | [**CreateAndEditBody**](CreateAndEditBody.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## editApplicationKey

> InlineResponse2003 editApplicationKey(apiKey, applicationKey, appKey, createAndEditBody)

Edit an application key name.

## Overview
Edit an application key name.
### ARGUMENTS
* **`name`** [*required*]: Name of your application key.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String appKey = "appKey_example"; // String | The specific APP key you are working with
        CreateAndEditBody createAndEditBody = new CreateAndEditBody(); // CreateAndEditBody | 
        try {
            InlineResponse2003 result = apiInstance.editApplicationKey(apiKey, applicationKey, appKey, createAndEditBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#editApplicationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **appKey** | **String**| The specific APP key you are working with |
 **createAndEditBody** | [**CreateAndEditBody**](CreateAndEditBody.md)|  | [optional]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getAPIKey

> InlineResponse2001 getAPIKey(apiKey, applicationKey, apiKey2)

Get a given API key.

## Overview
Get a given API key.
### ARGUMENTS
This endpoint takes no JSON arguments.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String apiKey2 = "apiKey_example"; // String | The specific API key you are working with
        try {
            InlineResponse2001 result = apiInstance.getAPIKey(apiKey, applicationKey, apiKey2);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#getAPIKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **apiKey2** | **String**| The specific API key you are working with |

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getAllAPIKeys

> InlineResponse200 getAllAPIKeys(apiKey, applicationKey)

Get all API keys available for your account.

## Overview
Get all API keys available for your account.
### ARGUMENTS
This endpoint takes no JSON arguments.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        try {
            InlineResponse200 result = apiInstance.getAllAPIKeys(apiKey, applicationKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#getAllAPIKeys");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |


## getAllApplicationKeys

> InlineResponse2002 getAllApplicationKeys(apiKey, applicationKey)

Get all application keys available for your account.

## Overview
Get all application keys available for your account.
### ARGUMENTS
This endpoint takes no JSON arguments.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        try {
            InlineResponse2002 result = apiInstance.getAllApplicationKeys(apiKey, applicationKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#getAllApplicationKeys");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |


## getApplicationKey

> InlineResponse2003 getApplicationKey(apiKey, applicationKey, appKey)

Get a given application key.

## Overview
Get a given application key.
### ARGUMENTS
This endpoint takes no JSON arguments.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.KeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.datadoghq.com");
        
        // Configure API key authorization: apiKeyAuth
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKeyAuth.setApiKeyPrefix("Token");

        // Configure API key authorization: appKeyAuth
        ApiKeyAuth appKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("appKeyAuth");
        appKeyAuth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //appKeyAuth.setApiKeyPrefix("Token");

        KeysApi apiInstance = new KeysApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String appKey = "appKey_example"; // String | The specific APP key you are working with
        try {
            InlineResponse2003 result = apiInstance.getApplicationKey(apiKey, applicationKey, appKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling KeysApi#getApplicationKey");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| The API Key used to authenticate the request |
 **applicationKey** | **String**| The APP Key used to authenticate the request |
 **appKey** | **String**| The specific APP key you are working with |

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

