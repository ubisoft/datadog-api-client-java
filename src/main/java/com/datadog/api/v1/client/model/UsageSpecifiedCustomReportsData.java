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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Response containing date and type for specified custom reports. */
@ApiModel(description = "Response containing date and type for specified custom reports.")
@JsonPropertyOrder({
  UsageSpecifiedCustomReportsData.JSON_PROPERTY_ATTRIBUTES,
  UsageSpecifiedCustomReportsData.JSON_PROPERTY_ID,
  UsageSpecifiedCustomReportsData.JSON_PROPERTY_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UsageSpecifiedCustomReportsData {
  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private UsageSpecifiedCustomReportsAttributes attributes;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  private UsageReportsType type = UsageReportsType.REPORTS;

  public UsageSpecifiedCustomReportsData attributes(
      UsageSpecifiedCustomReportsAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * Get attributes
   *
   * @return attributes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public UsageSpecifiedCustomReportsAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(UsageSpecifiedCustomReportsAttributes attributes) {
    this.attributes = attributes;
  }

  public UsageSpecifiedCustomReportsData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The date for specified custom reports.
   *
   * @return id
   */
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

  public UsageSpecifiedCustomReportsData type(UsageReportsType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
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

  /** Return true if this UsageSpecifiedCustomReportsData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsageSpecifiedCustomReportsData usageSpecifiedCustomReportsData =
        (UsageSpecifiedCustomReportsData) o;
    return Objects.equals(this.attributes, usageSpecifiedCustomReportsData.attributes)
        && Objects.equals(this.id, usageSpecifiedCustomReportsData.id)
        && Objects.equals(this.type, usageSpecifiedCustomReportsData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, id, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsageSpecifiedCustomReportsData {\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
