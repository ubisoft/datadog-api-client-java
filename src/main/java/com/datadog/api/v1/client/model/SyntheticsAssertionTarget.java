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
import com.datadog.api.v1.client.model.SyntheticsAssertionOperator;
import com.datadog.api.v1.client.model.SyntheticsAssertionType;
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
 * An assertion which uses a simple target.
 */
@ApiModel(description = "An assertion which uses a simple target.")
@JsonPropertyOrder({
  SyntheticsAssertionTarget.JSON_PROPERTY_OPERATOR,
  SyntheticsAssertionTarget.JSON_PROPERTY_PROPERTY,
  SyntheticsAssertionTarget.JSON_PROPERTY_TARGET,
  SyntheticsAssertionTarget.JSON_PROPERTY_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyntheticsAssertionTarget {
  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private SyntheticsAssertionOperator operator;

  public static final String JSON_PROPERTY_PROPERTY = "property";
  private String property;

  public static final String JSON_PROPERTY_TARGET = "target";
  private any target;

  public static final String JSON_PROPERTY_TYPE = "type";
  private SyntheticsAssertionType type;


  public SyntheticsAssertionTarget operator(SyntheticsAssertionOperator operator) {
    this.operator = operator;
    return this;
  }

   /**
   * Get operator
   * @return operator
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SyntheticsAssertionOperator getOperator() {
    return operator;
  }


  public void setOperator(SyntheticsAssertionOperator operator) {
    this.operator = operator;
  }


  public SyntheticsAssertionTarget property(String property) {
    this.property = property;
    return this;
  }

   /**
   * The associated assertion property.
   * @return property
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The associated assertion property.")
  @JsonProperty(JSON_PROPERTY_PROPERTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProperty() {
    return property;
  }


  public void setProperty(String property) {
    this.property = property;
  }


  public SyntheticsAssertionTarget target(any target) {
    this.target = target;
    return this;
  }

   /**
   * Value used by the operator.
   * @return target
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value used by the operator.")
  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public any getTarget() {
    return target;
  }


  public void setTarget(any target) {
    this.target = target;
  }


  public SyntheticsAssertionTarget type(SyntheticsAssertionType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SyntheticsAssertionType getType() {
    return type;
  }


  public void setType(SyntheticsAssertionType type) {
    this.type = type;
  }


  /**
   * Return true if this SyntheticsAssertionTarget object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntheticsAssertionTarget syntheticsAssertionTarget = (SyntheticsAssertionTarget) o;
    return Objects.equals(this.operator, syntheticsAssertionTarget.operator) &&
        Objects.equals(this.property, syntheticsAssertionTarget.property) &&
        Objects.equals(this.target, syntheticsAssertionTarget.target) &&
        Objects.equals(this.type, syntheticsAssertionTarget.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operator, property, target, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntheticsAssertionTarget {\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    property: ").append(toIndentedString(property)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

