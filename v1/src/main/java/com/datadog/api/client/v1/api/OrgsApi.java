package com.datadog.api.client.v1.api;

import com.datadog.api.client.v1.ApiException;
import com.datadog.api.client.v1.ApiClient;
import com.datadog.api.client.v1.ApiResponse;
import com.datadog.api.client.v1.Configuration;
import com.datadog.api.client.v1.Pair;

import javax.ws.rs.core.GenericType;

import com.datadog.api.client.v1.model.Error400;
import com.datadog.api.client.v1.model.Error403;
import com.datadog.api.client.v1.model.Error415;
import com.datadog.api.client.v1.model.IdpResponse;
import com.datadog.api.client.v1.model.InlineObject;
import com.datadog.api.client.v1.model.Org;
import com.datadog.api.client.v1.model.OrgPostBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrgsApi {
  private ApiClient apiClient;

  public OrgsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public OrgsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create child-organization.
   * ## Overview This endpoint requires the [multi-org account](https://docs.datadoghq.com/account_management/multi_organization/) feature and must be enabled by [contacting support](https://docs.datadoghq.com/help/). ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: The name of the new child-organization, limited to 32 characters. * **&#x60;subscription&#x60;** [*required*]: A JSON array of subscription type. Types available are **trial**, **free**, and **pro**. * **&#x60;billing&#x60;** [*required*]: A JSON array of billing type. Note that only **parent_billing** is supported.  Once a new child-organization is created, you can interact with it by using the **org.public_id**, **api_key.key**, and **application_key.hash** provided in the response.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param orgPostBody Org object that needs to be created (required)
   * @return Org
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public Org createChildOrg(String apiKey, String applicationKey, OrgPostBody orgPostBody) throws ApiException {
    return createChildOrgWithHttpInfo(apiKey, applicationKey, orgPostBody).getData();
      }

  /**
   * Create child-organization.
   * ## Overview This endpoint requires the [multi-org account](https://docs.datadoghq.com/account_management/multi_organization/) feature and must be enabled by [contacting support](https://docs.datadoghq.com/help/). ### ARGUMENTS * **&#x60;name&#x60;** [*required*]: The name of the new child-organization, limited to 32 characters. * **&#x60;subscription&#x60;** [*required*]: A JSON array of subscription type. Types available are **trial**, **free**, and **pro**. * **&#x60;billing&#x60;** [*required*]: A JSON array of billing type. Note that only **parent_billing** is supported.  Once a new child-organization is created, you can interact with it by using the **org.public_id**, **api_key.key**, and **application_key.hash** provided in the response.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param orgPostBody Org object that needs to be created (required)
   * @return ApiResponse&lt;Org&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Org> createChildOrgWithHttpInfo(String apiKey, String applicationKey, OrgPostBody orgPostBody) throws ApiException {
    Object localVarPostBody = orgPostBody;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling createChildOrg");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling createChildOrg");
    }
    
    // verify the required parameter 'orgPostBody' is set
    if (orgPostBody == null) {
      throw new ApiException(400, "Missing the required parameter 'orgPostBody' when calling createChildOrg");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/org";

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

    GenericType<Org> localVarReturnType = new GenericType<Org>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get the organization
   * ## Overview Gets information about your organization
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return Org
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public Org getOrg(String apiKey, String applicationKey) throws ApiException {
    return getOrgWithHttpInfo(apiKey, applicationKey).getData();
      }

  /**
   * Get the organization
   * ## Overview Gets information about your organization
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @return ApiResponse&lt;Org&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Org> getOrgWithHttpInfo(String apiKey, String applicationKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling getOrg");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling getOrg");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/org";

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

    GenericType<Org> localVarReturnType = new GenericType<Org>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update the organization
   * ## Overview Updates the organization ### ARGUMENTS * **&#x60;name&#x60;** [*optional*]: The organization name. * **&#x60;settings&#x60;** [*optional*]: A JSON array of settings. Settings include:   * **&#x60;saml&#x60;**: Set the boolean property **enabled** to enable or disable single sign on with SAML. See the [SAML documentation](https://docs.datadoghq.com/account_management/saml) for more information about all SAML settings.   * **&#x60;saml_idp_initiated_login&#x60;**: has one property **enabled** (boolean).   * **&#x60;saml_strict_mode&#x60;**: has one property **enabled** (boolean).   * **&#x60;saml_autocreate_users_domains&#x60;**: has two properties: **enabled** (boolean) and **domains** which is a list of domains without the @ symbol.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param publicId The public_id of the org you are operating with (required)
   * @param inlineObject  (optional)
   * @return Org
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public Org updateOrg(String apiKey, String applicationKey, String publicId, InlineObject inlineObject) throws ApiException {
    return updateOrgWithHttpInfo(apiKey, applicationKey, publicId, inlineObject).getData();
      }

  /**
   * Update the organization
   * ## Overview Updates the organization ### ARGUMENTS * **&#x60;name&#x60;** [*optional*]: The organization name. * **&#x60;settings&#x60;** [*optional*]: A JSON array of settings. Settings include:   * **&#x60;saml&#x60;**: Set the boolean property **enabled** to enable or disable single sign on with SAML. See the [SAML documentation](https://docs.datadoghq.com/account_management/saml) for more information about all SAML settings.   * **&#x60;saml_idp_initiated_login&#x60;**: has one property **enabled** (boolean).   * **&#x60;saml_strict_mode&#x60;**: has one property **enabled** (boolean).   * **&#x60;saml_autocreate_users_domains&#x60;**: has two properties: **enabled** (boolean) and **domains** which is a list of domains without the @ symbol.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param publicId The public_id of the org you are operating with (required)
   * @param inlineObject  (optional)
   * @return ApiResponse&lt;Org&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Org> updateOrgWithHttpInfo(String apiKey, String applicationKey, String publicId, InlineObject inlineObject) throws ApiException {
    Object localVarPostBody = inlineObject;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling updateOrg");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling updateOrg");
    }
    
    // verify the required parameter 'publicId' is set
    if (publicId == null) {
      throw new ApiException(400, "Missing the required parameter 'publicId' when calling updateOrg");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/org/{public_id}"
      .replaceAll("\\{" + "public_id" + "\\}", apiClient.escapeString(publicId.toString()));

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

    GenericType<Org> localVarReturnType = new GenericType<Org>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Upload IdP metadata
   * ## Overview There are a couple of options for updating the Identity Provider (IdP) metadata from your SAML IdP. * **Multipart Form-Data**: Post the IdP metadata file using a form post. * **XML Body**: Post the IdP metadata file as the body of the request. ### Multipart Form-Data #### Headers * **&#x60;Content-Type: multipart/form-data&#x60;** #### Arguments * **&#x60;name&#x60;** [*required*]: The path to the XML metadata file you wish to upload. ### XML Body #### Headers * **&#x60;Content-Type: application/xml&#x60;** #### Arguments * The body must contain the contents of your IdP metadata XML file.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param publicId The public_id of the org you are operating with (required)
   * @param body  (optional)
   * @return IdpResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
     </table>
   */
  public IdpResponse uploadIdPForOrg(String apiKey, String applicationKey, String publicId, String body) throws ApiException {
    return uploadIdPForOrgWithHttpInfo(apiKey, applicationKey, publicId, body).getData();
      }

  /**
   * Upload IdP metadata
   * ## Overview There are a couple of options for updating the Identity Provider (IdP) metadata from your SAML IdP. * **Multipart Form-Data**: Post the IdP metadata file using a form post. * **XML Body**: Post the IdP metadata file as the body of the request. ### Multipart Form-Data #### Headers * **&#x60;Content-Type: multipart/form-data&#x60;** #### Arguments * **&#x60;name&#x60;** [*required*]: The path to the XML metadata file you wish to upload. ### XML Body #### Headers * **&#x60;Content-Type: application/xml&#x60;** #### Arguments * The body must contain the contents of your IdP metadata XML file.
   * @param apiKey The API Key used to authenticate the request (required)
   * @param applicationKey The APP Key used to authenticate the request (required)
   * @param publicId The public_id of the org you are operating with (required)
   * @param body  (optional)
   * @return ApiResponse&lt;IdpResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 415 </td><td> Unsupported Media Type </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<IdpResponse> uploadIdPForOrgWithHttpInfo(String apiKey, String applicationKey, String publicId, String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(400, "Missing the required parameter 'apiKey' when calling uploadIdPForOrg");
    }
    
    // verify the required parameter 'applicationKey' is set
    if (applicationKey == null) {
      throw new ApiException(400, "Missing the required parameter 'applicationKey' when calling uploadIdPForOrg");
    }
    
    // verify the required parameter 'publicId' is set
    if (publicId == null) {
      throw new ApiException(400, "Missing the required parameter 'publicId' when calling uploadIdPForOrg");
    }
    
    // create path and map variables
    String localVarPath = "/api/v1/org/{public_id}/idp_metadata"
      .replaceAll("\\{" + "public_id" + "\\}", apiClient.escapeString(publicId.toString()));

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
      "application/xml", "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "apiKeyAuth", "appKeyAuth" };

    GenericType<IdpResponse> localVarReturnType = new GenericType<IdpResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
