/*
 * Unless explicitly stated otherwise all files in this repository are licensed under the Apache-2.0 License.
 * This product includes software developed at Datadog (https://www.datadoghq.com/).
 * Copyright 2019-Present Datadog, Inc.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.datadog.api.v1.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Object to handle &#x60;SIGV4&#x60; authentication when performing the test. */
@ApiModel(description = "Object to handle `SIGV4` authentication when performing the test.")
@JsonPropertyOrder({
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_ACCESS_KEY,
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_REGION,
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_SECRET_KEY,
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_SERVICE_NAME,
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_SESSION_TOKEN,
  SyntheticsBasicAuthSigv4.JSON_PROPERTY_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyntheticsBasicAuthSigv4 {
  @JsonIgnore public boolean unparsed = false;
  public static final String JSON_PROPERTY_ACCESS_KEY = "accessKey";
  private String accessKey;

  public static final String JSON_PROPERTY_REGION = "region";
  private String region;

  public static final String JSON_PROPERTY_SECRET_KEY = "secretKey";
  private String secretKey;

  public static final String JSON_PROPERTY_SERVICE_NAME = "serviceName";
  private String serviceName;

  public static final String JSON_PROPERTY_SESSION_TOKEN = "sessionToken";
  private String sessionToken;

  public static final String JSON_PROPERTY_TYPE = "type";
  private SyntheticsBasicAuthSigv4Type type = SyntheticsBasicAuthSigv4Type.SIGV4;

  public SyntheticsBasicAuthSigv4() {}

  @JsonCreator
  public SyntheticsBasicAuthSigv4(
      @JsonProperty(required = true, value = JSON_PROPERTY_ACCESS_KEY) String accessKey,
      @JsonProperty(required = true, value = JSON_PROPERTY_SECRET_KEY) String secretKey,
      @JsonProperty(required = true, value = JSON_PROPERTY_TYPE)
          SyntheticsBasicAuthSigv4Type type) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
    this.type = type;
    this.unparsed |= !type.isValid();
  }

  public SyntheticsBasicAuthSigv4 accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

  /**
   * Access key for the &#x60;SIGV4&#x60; authentication.
   *
   * @return accessKey
   */
  @ApiModelProperty(
      example = "AKIAIOSFODNN7EXAMPLE",
      required = true,
      value = "Access key for the `SIGV4` authentication.")
  @JsonProperty(JSON_PROPERTY_ACCESS_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public SyntheticsBasicAuthSigv4 region(String region) {
    this.region = region;
    return this;
  }

  /**
   * Region for the &#x60;SIGV4&#x60; authentication.
   *
   * @return region
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "us-east-1", value = "Region for the `SIGV4` authentication.")
  @JsonProperty(JSON_PROPERTY_REGION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public SyntheticsBasicAuthSigv4 secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

  /**
   * Secret key for the &#x60;SIGV4&#x60; authentication.
   *
   * @return secretKey
   */
  @ApiModelProperty(
      example = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYzEXAMPLEKEY",
      required = true,
      value = "Secret key for the `SIGV4` authentication.")
  @JsonProperty(JSON_PROPERTY_SECRET_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public SyntheticsBasicAuthSigv4 serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

  /**
   * Service name for the &#x60;SIGV4&#x60; authentication.
   *
   * @return serviceName
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "execute-api", value = "Service name for the `SIGV4` authentication.")
  @JsonProperty(JSON_PROPERTY_SERVICE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public SyntheticsBasicAuthSigv4 sessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
    return this;
  }

  /**
   * Session token for the &#x60;SIGV4&#x60; authentication.
   *
   * @return sessionToken
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      example =
          "AQoEXAMPLEH4aoAH0gNCAPyJxz4BlCFFxWNE1OPTgk5TthT+FvwqnKwRcOIfrRh3c/L"
              + " To6UDdyJwOOvEVPvLXCrrrUtdnniCEXAMPLE/IvU1dYUg2RVAJBanLiHb4IgRmpRV3z"
              + " rkuWJOgQs8IZZaIv2BXIa2R4OlgkBN9bkUDNCJiBeb/AXlzBBko7b15fjrBs2+cTQtp"
              + " Z3CYWFXG8C5zqx37wnOE49mRl/+OtkIKGO7fAE ",
      value = "Session token for the `SIGV4` authentication.")
  @JsonProperty(JSON_PROPERTY_SESSION_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSessionToken() {
    return sessionToken;
  }

  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }

  public SyntheticsBasicAuthSigv4 type(SyntheticsBasicAuthSigv4Type type) {
    this.type = type;
    this.unparsed |= !type.isValid();
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public SyntheticsBasicAuthSigv4Type getType() {
    return type;
  }

  public void setType(SyntheticsBasicAuthSigv4Type type) {
    if (!type.isValid()) {
      this.unparsed = true;
    }
    this.type = type;
  }

  /** Return true if this SyntheticsBasicAuthSigv4 object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntheticsBasicAuthSigv4 syntheticsBasicAuthSigv4 = (SyntheticsBasicAuthSigv4) o;
    return Objects.equals(this.accessKey, syntheticsBasicAuthSigv4.accessKey)
        && Objects.equals(this.region, syntheticsBasicAuthSigv4.region)
        && Objects.equals(this.secretKey, syntheticsBasicAuthSigv4.secretKey)
        && Objects.equals(this.serviceName, syntheticsBasicAuthSigv4.serviceName)
        && Objects.equals(this.sessionToken, syntheticsBasicAuthSigv4.sessionToken)
        && Objects.equals(this.type, syntheticsBasicAuthSigv4.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessKey, region, secretKey, serviceName, sessionToken, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntheticsBasicAuthSigv4 {\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    sessionToken: ").append(toIndentedString(sessionToken)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
