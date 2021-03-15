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

/**
 * Parser options to use for retrieving a Synthetics global variable from a Synthetics Test. Used in
 * conjunction with &#x60;parse_test_public_id&#x60;.
 */
@ApiModel(
    description =
        "Parser options to use for retrieving a Synthetics global variable from a Synthetics Test."
            + " Used in conjunction with `parse_test_public_id`.")
@JsonPropertyOrder({
  SyntheticsGlobalVariableParseTestOptions.JSON_PROPERTY_FIELD,
  SyntheticsGlobalVariableParseTestOptions.JSON_PROPERTY_PARSER,
  SyntheticsGlobalVariableParseTestOptions.JSON_PROPERTY_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SyntheticsGlobalVariableParseTestOptions {
  public static final String JSON_PROPERTY_FIELD = "field";
  private String field;

  public static final String JSON_PROPERTY_PARSER = "parser";
  private SyntheticsVariableParser parser;

  public static final String JSON_PROPERTY_TYPE = "type";
  private SyntheticsGlobalVariableParseTestOptionsType type;

  public SyntheticsGlobalVariableParseTestOptions field(String field) {
    this.field = field;
    return this;
  }

  /**
   * When type is &#x60;http_header&#x60;, name of the header to use to extract the value.
   *
   * @return field
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      example = "content-type",
      value = "When type is `http_header`, name of the header to use to extract the value.")
  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public SyntheticsGlobalVariableParseTestOptions parser(SyntheticsVariableParser parser) {
    this.parser = parser;
    return this;
  }

  /**
   * Get parser
   *
   * @return parser
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PARSER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public SyntheticsVariableParser getParser() {
    return parser;
  }

  public void setParser(SyntheticsVariableParser parser) {
    this.parser = parser;
  }

  public SyntheticsGlobalVariableParseTestOptions type(
      SyntheticsGlobalVariableParseTestOptionsType type) {
    this.type = type;
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
  public SyntheticsGlobalVariableParseTestOptionsType getType() {
    return type;
  }

  public void setType(SyntheticsGlobalVariableParseTestOptionsType type) {
    this.type = type;
  }

  /** Return true if this SyntheticsGlobalVariable_parse_test_options object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyntheticsGlobalVariableParseTestOptions syntheticsGlobalVariableParseTestOptions =
        (SyntheticsGlobalVariableParseTestOptions) o;
    return Objects.equals(this.field, syntheticsGlobalVariableParseTestOptions.field)
        && Objects.equals(this.parser, syntheticsGlobalVariableParseTestOptions.parser)
        && Objects.equals(this.type, syntheticsGlobalVariableParseTestOptions.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, parser, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyntheticsGlobalVariableParseTestOptions {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    parser: ").append(toIndentedString(parser)).append("\n");
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
