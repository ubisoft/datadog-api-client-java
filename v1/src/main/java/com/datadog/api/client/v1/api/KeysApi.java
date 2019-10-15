package com.datadog.api.client.v1.api;

import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiResponse;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.Pair;

import javax.ws.rs.core.GenericType;

import com.datadog.api.client.v1.model.CreateAndEditBody;
import com.datadog.api.client.v1.model.Error400;
import com.datadog.api.client.v1.model.Error403;
import com.datadog.api.client.v1.model.Error404;
import com.datadog.api.client.v1.model.Error409;
import com.datadog.api.client.v1.model.InlineResponse200;
import com.datadog.api.client.v1.model.InlineResponse2001;
import com.datadog.api.client.v1.model.InlineResponse2002;
import com.datadog.api.client.v1.model.InlineResponse2003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KeysApi {
  private ApiClient apiClient;

  public KeysApi() {
    this(Configuration.getDefaultApiClient());
  }

  public KeysApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create an API key with a given name.
   * ## Overview Creates an API key ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your API key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param createAndEditBody  (optional)
   * @return InlineResponse2001
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2001 createAPIKey(String apiKey, String applicationKey, CreateAndEditBody createAndEditBody) throws ApiException {
    return createAPIKeyWithHttpInfo(apiKey, applicationKey, createAndEditBody).getData();
      }

  /**
   * Create an API key with a given name.
   * ## Overview Creates an API key ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your API key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param createAndEditBody  (optional)
   * @return ApiResponse&lt;InlineResponse2001&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2001> createAPIKeyWithHttpInfo(String apiKey, String applicationKey, CreateAndEditBody createAndEditBody) throws ApiException {
    Object localVarPostBody = createAndEditBody;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling createAPIKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling createAPIKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/api_key";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2001> localVarReturnType = new GenericType<InlineResponse2001>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create an application key with a given name.
   * ## Overview Create an application key with a given name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param createAndEditBody  (optional)
   * @return InlineResponse2003
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2003 createApplicationKey(String apiKey, String applicationKey, CreateAndEditBody createAndEditBody) throws ApiException {
    return createApplicationKeyWithHttpInfo(apiKey, applicationKey, createAndEditBody).getData();
      }

  /**
   * Create an application key with a given name.
   * ## Overview Create an application key with a given name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param createAndEditBody  (optional)
   * @return ApiResponse&lt;InlineResponse2003&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2003> createApplicationKeyWithHttpInfo(String apiKey, String applicationKey, CreateAndEditBody createAndEditBody) throws ApiException {
    Object localVarPostBody = createAndEditBody;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling createApplicationKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling createApplicationKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/application_key";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2003> localVarReturnType = new GenericType<InlineResponse2003>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a given API key.
   * ## Overview Delete a given API key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @return InlineResponse2001
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2001 deleteAPIKey(String apiKey, String applicationKey, String apiKey2) throws ApiException {
    return deleteAPIKeyWithHttpInfo(apiKey, applicationKey, apiKey2).getData();
      }

  /**
   * Delete a given API key.
   * ## Overview Delete a given API key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @return ApiResponse&lt;InlineResponse2001&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2001> deleteAPIKeyWithHttpInfo(String apiKey, String applicationKey, String apiKey2) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling deleteAPIKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling deleteAPIKey");
    }
    
    // verify the required parameter 'apiKey2' is set
    if (apiKey2 == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey2' when calling deleteAPIKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/api_key/{api_key}"
      .replaceAll("\\{" + "api_key" + "\\}", apiClient.escapeString(apiKey2.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2001> localVarReturnType = new GenericType<InlineResponse2001>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete a given application key.
   * ## Overview Delete a given application key. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @return InlineResponse2003
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2003 deleteApplicationKey(String apiKey, String applicationKey, String appKey) throws ApiException {
    return deleteApplicationKeyWithHttpInfo(apiKey, applicationKey, appKey).getData();
      }

  /**
   * Delete a given application key.
   * ## Overview Delete a given application key. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @return ApiResponse&lt;InlineResponse2003&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2003> deleteApplicationKeyWithHttpInfo(String apiKey, String applicationKey, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling deleteApplicationKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling deleteApplicationKey");
    }
    
    // verify the required parameter 'appKey' is set
    if (appKey == null) {
      throw new ApiException(400, "Missing the required parameter 'appKey' when calling deleteApplicationKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/application_key/{app_key}"
      .replaceAll("\\{" + "app_key" + "\\}", apiClient.escapeString(appKey.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2003> localVarReturnType = new GenericType<InlineResponse2003>() {};
    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Edit an API key name.
   * ## Overview Edit an API key name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your API key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @param createAndEditBody  (optional)
   * @return InlineResponse2001
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2001 editAPIKey(String apiKey, String applicationKey, String apiKey2, CreateAndEditBody createAndEditBody) throws ApiException {
    return editAPIKeyWithHttpInfo(apiKey, applicationKey, apiKey2, createAndEditBody).getData();
      }

  /**
   * Edit an API key name.
   * ## Overview Edit an API key name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your API key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @param createAndEditBody  (optional)
   * @return ApiResponse&lt;InlineResponse2001&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2001> editAPIKeyWithHttpInfo(String apiKey, String applicationKey, String apiKey2, CreateAndEditBody createAndEditBody) throws ApiException {
    Object localVarPostBody = createAndEditBody;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling editAPIKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling editAPIKey");
    }
    
    // verify the required parameter 'apiKey2' is set
    if (apiKey2 == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey2' when calling editAPIKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/api_key/{api_key}"
      .replaceAll("\\{" + "api_key" + "\\}", apiClient.escapeString(apiKey2.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2001> localVarReturnType = new GenericType<InlineResponse2001>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Edit an application key name.
   * ## Overview Edit an application key name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @param createAndEditBody  (optional)
   * @return InlineResponse2003
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2003 editApplicationKey(String apiKey, String applicationKey, String appKey, CreateAndEditBody createAndEditBody) throws ApiException {
    return editApplicationKeyWithHttpInfo(apiKey, applicationKey, appKey, createAndEditBody).getData();
      }

  /**
   * Edit an application key name.
   * ## Overview Edit an application key name. ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: Name of your application key.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @param createAndEditBody  (optional)
   * @return ApiResponse&lt;InlineResponse2003&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2003> editApplicationKeyWithHttpInfo(String apiKey, String applicationKey, String appKey, CreateAndEditBody createAndEditBody) throws ApiException {
    Object localVarPostBody = createAndEditBody;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling editApplicationKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling editApplicationKey");
    }
    
    // verify the required parameter 'appKey' is set
    if (appKey == null) {
      throw new ApiException(400, "Missing the required parameter 'appKey' when calling editApplicationKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/application_key/{app_key}"
      .replaceAll("\\{" + "app_key" + "\\}", apiClient.escapeString(appKey.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2003> localVarReturnType = new GenericType<InlineResponse2003>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a given API key.
   * ## Overview Get a given API key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @return InlineResponse2001
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2001 getAPIKey(String apiKey, String applicationKey, String apiKey2) throws ApiException {
    return getAPIKeyWithHttpInfo(apiKey, applicationKey, apiKey2).getData();
      }

  /**
   * Get a given API key.
   * ## Overview Get a given API key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param apiKey2 The specific API key you are working with (required)
   * @return ApiResponse&lt;InlineResponse2001&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2001> getAPIKeyWithHttpInfo(String apiKey, String applicationKey, String apiKey2) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling getAPIKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling getAPIKey");
    }
    
    // verify the required parameter 'apiKey2' is set
    if (apiKey2 == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey2' when calling getAPIKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/api_key/{api_key}"
      .replaceAll("\\{" + "api_key" + "\\}", apiClient.escapeString(apiKey2.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2001> localVarReturnType = new GenericType<InlineResponse2001>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all API keys available for your account.
   * ## Overview Get all API keys available for your account. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return InlineResponse200
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse200 getAllAPIKeys(String apiKey, String applicationKey) throws ApiException {
    return getAllAPIKeysWithHttpInfo(apiKey, applicationKey).getData();
      }

  /**
   * Get all API keys available for your account.
   * ## Overview Get all API keys available for your account. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return ApiResponse&lt;InlineResponse200&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse200> getAllAPIKeysWithHttpInfo(String apiKey, String applicationKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling getAllAPIKeys");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling getAllAPIKeys");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/api_key";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse200> localVarReturnType = new GenericType<InlineResponse200>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all application keys available for your account.
   * ## Overview Get all application keys available for your account. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return InlineResponse2002
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2002 getAllApplicationKeys(String apiKey, String applicationKey) throws ApiException {
    return getAllApplicationKeysWithHttpInfo(apiKey, applicationKey).getData();
      }

  /**
   * Get all application keys available for your account.
   * ## Overview Get all application keys available for your account. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return ApiResponse&lt;InlineResponse2002&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2002> getAllApplicationKeysWithHttpInfo(String apiKey, String applicationKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling getAllApplicationKeys");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling getAllApplicationKeys");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/application_key";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2002> localVarReturnType = new GenericType<InlineResponse2002>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get a given application key.
   * ## Overview Get a given application key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @return InlineResponse2003
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public InlineResponse2003 getApplicationKey(String apiKey, String applicationKey, String appKey) throws ApiException {
    return getApplicationKeyWithHttpInfo(apiKey, applicationKey, appKey).getData();
      }

  /**
   * Get a given application key.
   * ## Overview Get a given application key. ### ARGUMENTS This endpoint takes no JSON arguments.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param appKey The specific APP key you are working with (required)
   * @return ApiResponse&lt;InlineResponse2003&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InlineResponse2003> getApplicationKeyWithHttpInfo(String apiKey, String applicationKey, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling getApplicationKey");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling getApplicationKey");
    }
    
    // verify the required parameter 'appKey' is set
    if (appKey == null) {
      throw new ApiException(400, "Missing the required parameter 'appKey' when calling getApplicationKey");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/application_key/{app_key}"
      .replaceAll("\\{" + "app_key" + "\\}", apiClient.escapeString(appKey.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_key", apiKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "application_key", applicationKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<InlineResponse2003> localVarReturnType = new GenericType<InlineResponse2003>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
