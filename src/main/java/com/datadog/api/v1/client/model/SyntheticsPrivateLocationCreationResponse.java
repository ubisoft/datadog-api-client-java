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

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.datadog.api.v1.client.model.SyntheticsPrivateLocation;
import com.datadog.api.v1.client.model.SyntheticsPrivateLocationCreationResponseResultEncryption;
import com.datadog.api.v1.client.model.any;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.datadog.api.v1.client.JSON;


/**
 * Object that contains the new private location, the public key for result encryption, and the configuration skeleton.
 */
@ApiModel(description = "Object that contains the new private location, the public key for result encryption, and the configuration skeleton.")
@JsonPropertyOrder({
  SyntheticsPrivateLocationCreationResponse.JSON_PROPERTY_CONFIG,
  SyntheticsPrivateLocationCreationResponse.JSON_PROPERTY_PRIVATE_LOCATION,
  SyntheticsPrivateLocationCreationResponse.JSON_PROPERTY_RESULT_ENCRYPTION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyntheticsPrivateLocationCreationResponse {
  public static final String JSON_PROPERTY_CONFIG = "config";
  private any config;

  public static final String JSON_PROPERTY_PRIVATE_LOCATION = "private_location";
  private SyntheticsPrivateLocation privateLocation;

  public static final String JSON_PROPERTY_RESULT_ENCRYPTION = "result_encryption";
  private SyntheticsPrivateLocationCreationResponseResultEncryption resultEncryption;


  public SyntheticsPrivateLocationCreationResponse config(any config) {
    this.config = config;
    return this;
  }

   /**
   * Configuration skeleton for the private location. See installation instructions of the private location on how to use this configuration.
   * @return config
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Configuration skeleton for the private location. See installation instructions of the private location on how to use this configuration.")
  @JsonProperty(JSON_PROPERTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public any getConfig() {
    return config;
  }


  public void setConfig(any config) {
    this.config = config;
  }


  public SyntheticsPrivateLocationCreationResponse privateLocation(SyntheticsPrivateLocation privateLocation) {
    this.privateLocation = privateLocation;
    return this;
  }

   /**
   * Get privateLocation
   * @return privateLocation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PRIVATE_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SyntheticsPrivateLocation getPrivateLocation() {
    return privateLocation;
  }


  public void setPrivateLocation(SyntheticsPrivateLocation privateLocation) {
    this.privateLocation = privateLocation;
  }


  public SyntheticsPrivateLocationCreationResponse resultEncryption(SyntheticsPrivateLocationCreationResponseResultEncryption resultEncryption) {
    this.resultEncryption = resultEncryption;
    return this;
  }

   /**
   * Get resultEncryption
   * @return resultEncryption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESULT_ENCRYPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SyntheticsPrivateLocationCreationResponseResultEncryption getResultEncryption() {
    return resultEncryption;
  }


  public void setResultEncryption(SyntheticsPrivateLocationCreationResponseResultEncryption resultEncryption) {
    this.resultEncryption = resultEncryption;
  }


  /**
   * Return true if this SyntheticsPrivateLocationCreationResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntheticsPrivateLocationCreationResponse syntheticsPrivateLocationCreationResponse = (SyntheticsPrivateLocationCreationResponse) o;
    return Objects.equals(this.config, syntheticsPrivateLocationCreationResponse.config) &&
        Objects.equals(this.privateLocation, syntheticsPrivateLocationCreationResponse.privateLocation) &&
        Objects.equals(this.resultEncryption, syntheticsPrivateLocationCreationResponse.resultEncryption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, privateLocation, resultEncryption);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntheticsPrivateLocationCreationResponse {\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    privateLocation: ").append(toIndentedString(privateLocation)).append("\n");
    sb.append("    resultEncryption: ").append(toIndentedString(resultEncryption)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

