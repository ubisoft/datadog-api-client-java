# OrgsApi

All URIs are relative to *https://api.datadoghq.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createChildOrg**](OrgsApi.md#createChildOrg) | **POST** /api/v1/org | Create child-organization.
[**getOrg**](OrgsApi.md#getOrg) | **GET** /api/v1/org | Get the organization
[**updateOrg**](OrgsApi.md#updateOrg) | **PUT** /api/v1/org/{public_id} | Update the organization
[**uploadIdPForOrg**](OrgsApi.md#uploadIdPForOrg) | **POST** /api/v1/org/{public_id}/idp_metadata | Upload IdP metadata



## createChildOrg

> Org createChildOrg(apiKey, applicationKey, orgPostBody)

Create child-organization.

## Overview
This endpoint requires the [multi-org account](https://docs.datadoghq.com/account_management/multi_organization/) feature and must be enabled by [contacting support](https://docs.datadoghq.com/help/).
### ARGUMENTS
* **`name`** [*required*]: The name of the new child-organization, limited to 32 characters.
* **`subscription`** [*required*]: A JSON array of subscription type. Types available are **trial**, **free**, and **pro**.
* **`billing`** [*required*]: A JSON array of billing type. Note that only **parent_billing** is supported.

Once a new child-organization is created, you can interact with it by using the **org.public_id**, **api_key.key**, and **application_key.hash** provided in the response.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.OrgsApi;

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

        OrgsApi apiInstance = new OrgsApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        OrgPostBody orgPostBody = new OrgPostBody(); // OrgPostBody | Org object that needs to be created
        try {
            Org result = apiInstance.createChildOrg(apiKey, applicationKey, orgPostBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrgsApi#createChildOrg");
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
 **orgPostBody** | [**OrgPostBody**](OrgPostBody.md)| Org object that needs to be created |

### Return type

[**Org**](Org.md)

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


## getOrg

> Org getOrg(apiKey, applicationKey)

Get the organization

## Overview
Gets information about your organization

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.OrgsApi;

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

        OrgsApi apiInstance = new OrgsApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        try {
            Org result = apiInstance.getOrg(apiKey, applicationKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrgsApi#getOrg");
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

[**Org**](Org.md)

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


## updateOrg

> Org updateOrg(apiKey, applicationKey, publicId, inlineObject)

Update the organization

## Overview
Updates the organization
### ARGUMENTS
* **`name`** [*optional*]: The organization name.
* **`settings`** [*optional*]: A JSON array of settings. Settings include:
  * **`saml`**: Set the boolean property **enabled** to enable or disable single sign on with SAML. See the [SAML documentation](https://docs.datadoghq.com/account_management/saml) for more information about all SAML settings.
  * **`saml_idp_initiated_login`**: has one property **enabled** (boolean).
  * **`saml_strict_mode`**: has one property **enabled** (boolean).
  * **`saml_autocreate_users_domains`**: has two properties: **enabled** (boolean) and **domains** which is a list of domains without the @ symbol.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.OrgsApi;

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

        OrgsApi apiInstance = new OrgsApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String publicId = abc123; // String | The public_id of the org you are operating with
        InlineObject inlineObject = new InlineObject(); // InlineObject | 
        try {
            Org result = apiInstance.updateOrg(apiKey, applicationKey, publicId, inlineObject);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrgsApi#updateOrg");
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
 **publicId** | **String**| The public_id of the org you are operating with |
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

[**Org**](Org.md)

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


## uploadIdPForOrg

> IdpResponse uploadIdPForOrg(apiKey, applicationKey, publicId, body)

Upload IdP metadata

## Overview
There are a couple of options for updating the Identity Provider (IdP) metadata from your SAML IdP.
* **Multipart Form-Data**: Post the IdP metadata file using a form post.
* **XML Body**: Post the IdP metadata file as the body of the request.
### Multipart Form-Data
#### Headers
* **`Content-Type: multipart/form-data`**
#### Arguments
* **`name`** [*required*]: The path to the XML metadata file you wish to upload.
### XML Body
#### Headers
* **`Content-Type: application/xml`**
#### Arguments
* The body must contain the contents of your IdP metadata XML file.

### Example

```java
// Import classes:
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.auth.*;
import com.datadog.api.client.v1.models.*;
import com.datadog.api.client.v1.api.OrgsApi;

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

        OrgsApi apiInstance = new OrgsApi(defaultClient);
        String apiKey = "apiKey_example"; // String | The API Key used to authenticate the request
        String applicationKey = "applicationKey_example"; // String | The APP Key used to authenticate the request
        String publicId = abc123; // String | The public_id of the org you are operating with
        String body = "body_example"; // String | 
        try {
            IdpResponse result = apiInstance.uploadIdPForOrg(apiKey, applicationKey, publicId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrgsApi#uploadIdPForOrg");
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
 **publicId** | **String**| The public_id of the org you are operating with |
 **body** | **String**|  | [optional]

### Return type

[**IdpResponse**](IdpResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [appKeyAuth](../README.md#appKeyAuth)

### HTTP request headers

- **Content-Type**: application/xml, multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **403** | Forbidden |  -  |
| **415** | Unsupported Media Type |  -  |

