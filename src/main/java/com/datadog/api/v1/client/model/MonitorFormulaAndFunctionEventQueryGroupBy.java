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

/** List of objects used to group by. */
@ApiModel(description = "List of objects used to group by.")
@JsonPropertyOrder({
  MonitorFormulaAndFunctionEventQueryGroupBy.JSON_PROPERTY_FACET,
  MonitorFormulaAndFunctionEventQueryGroupBy.JSON_PROPERTY_LIMIT,
  MonitorFormulaAndFunctionEventQueryGroupBy.JSON_PROPERTY_SORT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MonitorFormulaAndFunctionEventQueryGroupBy {
  @JsonIgnore public boolean unparsed = false;
  public static final String JSON_PROPERTY_FACET = "facet";
  private String facet;

  public static final String JSON_PROPERTY_LIMIT = "limit";
  private Long limit;

  public static final String JSON_PROPERTY_SORT = "sort";
  private MonitorFormulaAndFunctionEventQueryGroupBySort sort;

  public MonitorFormulaAndFunctionEventQueryGroupBy() {}

  @JsonCreator
  public MonitorFormulaAndFunctionEventQueryGroupBy(
      @JsonProperty(required = true, value = JSON_PROPERTY_FACET) String facet) {
    this.facet = facet;
  }

  public MonitorFormulaAndFunctionEventQueryGroupBy facet(String facet) {
    this.facet = facet;
    return this;
  }

  /**
   * Event facet.
   *
   * @return facet
   */
  @ApiModelProperty(example = "status", required = true, value = "Event facet.")
  @JsonProperty(JSON_PROPERTY_FACET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getFacet() {
    return facet;
  }

  public void setFacet(String facet) {
    this.facet = facet;
  }

  public MonitorFormulaAndFunctionEventQueryGroupBy limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Number of groups to return.
   *
   * @return limit
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "10", value = "Number of groups to return.")
  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public MonitorFormulaAndFunctionEventQueryGroupBy sort(
      MonitorFormulaAndFunctionEventQueryGroupBySort sort) {
    this.sort = sort;
    this.unparsed |= sort.unparsed;
    return this;
  }

  /**
   * Get sort
   *
   * @return sort
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MonitorFormulaAndFunctionEventQueryGroupBySort getSort() {
    return sort;
  }

  public void setSort(MonitorFormulaAndFunctionEventQueryGroupBySort sort) {
    this.sort = sort;
  }

  /** Return true if this MonitorFormulaAndFunctionEventQueryGroupBy object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorFormulaAndFunctionEventQueryGroupBy monitorFormulaAndFunctionEventQueryGroupBy =
        (MonitorFormulaAndFunctionEventQueryGroupBy) o;
    return Objects.equals(this.facet, monitorFormulaAndFunctionEventQueryGroupBy.facet)
        && Objects.equals(this.limit, monitorFormulaAndFunctionEventQueryGroupBy.limit)
        && Objects.equals(this.sort, monitorFormulaAndFunctionEventQueryGroupBy.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facet, limit, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorFormulaAndFunctionEventQueryGroupBy {\n");
    sb.append("    facet: ").append(toIndentedString(facet)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
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
