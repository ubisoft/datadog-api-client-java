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
import com.datadog.api.v1.client.model.UsageCustomReportsAttributes;
import com.datadog.api.v1.client.model.UsageReportsType;
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
 * The response containing the date and type for custom reports.
 */
@ApiModel(description = "The response containing the date and type for custom reports.")
@JsonPropertyOrder({
  UsageCustomReportsData.JSON_PROPERTY_ATTRIBUTES,
  UsageCustomReportsData.JSON_PROPERTY_ID,
  UsageCustomReportsData.JSON_PROPERTY_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsageCustomReportsData {
  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private UsageCustomReportsAttributes attributes;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  private UsageReportsType type = UsageReportsType.REPORTS;


  public UsageCustomReportsData attributes(UsageCustomReportsAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UsageCustomReportsAttributes getAttributes() {
    return attributes;
  }


  public void setAttributes(UsageCustomReportsAttributes attributes) {
    this.attributes = attributes;
  }


  public UsageCustomReportsData id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The date for specified custom reports.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date for specified custom reports.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public UsageCustomReportsData type(UsageReportsType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UsageReportsType getType() {
    return type;
  }


  public void setType(UsageReportsType type) {
    this.type = type;
  }


  /**
   * Return true if this UsageCustomReportsData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsageCustomReportsData usageCustomReportsData = (UsageCustomReportsData) o;
    return Objects.equals(this.attributes, usageCustomReportsData.attributes) &&
        Objects.equals(this.id, usageCustomReportsData.id) &&
        Objects.equals(this.type, usageCustomReportsData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, id, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsageCustomReportsData {\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

