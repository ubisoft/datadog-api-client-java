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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** A formula and functions events query. */
@ApiModel(description = "A formula and functions events query.")
@JsonPropertyOrder({
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_COMPUTE,
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_DATA_SOURCE,
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_GROUP_BY,
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_INDEXES,
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_NAME,
  MonitorFormulaAndFunctionEventQueryDefinition.JSON_PROPERTY_SEARCH
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MonitorFormulaAndFunctionEventQueryDefinition {
  @JsonIgnore public boolean unparsed = false;
  public static final String JSON_PROPERTY_COMPUTE = "compute";
  private MonitorFormulaAndFunctionEventQueryDefinitionCompute compute;

  public static final String JSON_PROPERTY_DATA_SOURCE = "data_source";
  private MonitorFormulaAndFunctionEventsDataSource dataSource;

  public static final String JSON_PROPERTY_GROUP_BY = "group_by";
  private List<MonitorFormulaAndFunctionEventQueryGroupBy> groupBy = null;

  public static final String JSON_PROPERTY_INDEXES = "indexes";
  private List<String> indexes = null;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_SEARCH = "search";
  private MonitorFormulaAndFunctionEventQueryDefinitionSearch search;

  public MonitorFormulaAndFunctionEventQueryDefinition() {}

  @JsonCreator
  public MonitorFormulaAndFunctionEventQueryDefinition(
      @JsonProperty(required = true, value = JSON_PROPERTY_COMPUTE)
          MonitorFormulaAndFunctionEventQueryDefinitionCompute compute,
      @JsonProperty(required = true, value = JSON_PROPERTY_DATA_SOURCE)
          MonitorFormulaAndFunctionEventsDataSource dataSource,
      @JsonProperty(required = true, value = JSON_PROPERTY_NAME) String name) {
    this.compute = compute;
    this.unparsed |= compute.unparsed;
    this.dataSource = dataSource;
    this.unparsed |= !dataSource.isValid();
    this.name = name;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition compute(
      MonitorFormulaAndFunctionEventQueryDefinitionCompute compute) {
    this.compute = compute;
    this.unparsed |= compute.unparsed;
    return this;
  }

  /**
   * Get compute
   *
   * @return compute
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COMPUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public MonitorFormulaAndFunctionEventQueryDefinitionCompute getCompute() {
    return compute;
  }

  public void setCompute(MonitorFormulaAndFunctionEventQueryDefinitionCompute compute) {
    this.compute = compute;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition dataSource(
      MonitorFormulaAndFunctionEventsDataSource dataSource) {
    this.dataSource = dataSource;
    this.unparsed |= !dataSource.isValid();
    return this;
  }

  /**
   * Get dataSource
   *
   * @return dataSource
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DATA_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public MonitorFormulaAndFunctionEventsDataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(MonitorFormulaAndFunctionEventsDataSource dataSource) {
    if (!dataSource.isValid()) {
      this.unparsed = true;
    }
    this.dataSource = dataSource;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition groupBy(
      List<MonitorFormulaAndFunctionEventQueryGroupBy> groupBy) {
    this.groupBy = groupBy;
    for (MonitorFormulaAndFunctionEventQueryGroupBy item : groupBy) {
      this.unparsed |= item.unparsed;
    }
    return this;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition addGroupByItem(
      MonitorFormulaAndFunctionEventQueryGroupBy groupByItem) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList<>();
    }
    this.groupBy.add(groupByItem);
    this.unparsed |= groupByItem.unparsed;
    return this;
  }

  /**
   * Group by options.
   *
   * @return groupBy
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Group by options.")
  @JsonProperty(JSON_PROPERTY_GROUP_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<MonitorFormulaAndFunctionEventQueryGroupBy> getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(List<MonitorFormulaAndFunctionEventQueryGroupBy> groupBy) {
    this.groupBy = groupBy;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition indexes(List<String> indexes) {
    this.indexes = indexes;
    return this;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition addIndexesItem(String indexesItem) {
    if (this.indexes == null) {
      this.indexes = new ArrayList<>();
    }
    this.indexes.add(indexesItem);
    return this;
  }

  /**
   * An array of index names to query in the stream. Omit or use &#x60;[]&#x60; to query all indexes
   * at once.
   *
   * @return indexes
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      example = "[\"days-3\",\"days-7\"]",
      value =
          "An array of index names to query in the stream. Omit or use `[]` to query all indexes"
              + " at once.")
  @JsonProperty(JSON_PROPERTY_INDEXES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getIndexes() {
    return indexes;
  }

  public void setIndexes(List<String> indexes) {
    this.indexes = indexes;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the query for use in formulas.
   *
   * @return name
   */
  @ApiModelProperty(
      example = "query_errors",
      required = true,
      value = "Name of the query for use in formulas.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MonitorFormulaAndFunctionEventQueryDefinition search(
      MonitorFormulaAndFunctionEventQueryDefinitionSearch search) {
    this.search = search;
    this.unparsed |= search.unparsed;
    return this;
  }

  /**
   * Get search
   *
   * @return search
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SEARCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MonitorFormulaAndFunctionEventQueryDefinitionSearch getSearch() {
    return search;
  }

  public void setSearch(MonitorFormulaAndFunctionEventQueryDefinitionSearch search) {
    this.search = search;
  }

  /** Return true if this MonitorFormulaAndFunctionEventQueryDefinition object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorFormulaAndFunctionEventQueryDefinition monitorFormulaAndFunctionEventQueryDefinition =
        (MonitorFormulaAndFunctionEventQueryDefinition) o;
    return Objects.equals(this.compute, monitorFormulaAndFunctionEventQueryDefinition.compute)
        && Objects.equals(this.dataSource, monitorFormulaAndFunctionEventQueryDefinition.dataSource)
        && Objects.equals(this.groupBy, monitorFormulaAndFunctionEventQueryDefinition.groupBy)
        && Objects.equals(this.indexes, monitorFormulaAndFunctionEventQueryDefinition.indexes)
        && Objects.equals(this.name, monitorFormulaAndFunctionEventQueryDefinition.name)
        && Objects.equals(this.search, monitorFormulaAndFunctionEventQueryDefinition.search);
  }

  @Override
  public int hashCode() {
    return Objects.hash(compute, dataSource, groupBy, indexes, name, search);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitorFormulaAndFunctionEventQueryDefinition {\n");
    sb.append("    compute: ").append(toIndentedString(compute)).append("\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    groupBy: ").append(toIndentedString(groupBy)).append("\n");
    sb.append("    indexes: ").append(toIndentedString(indexes)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    search: ").append(toIndentedString(search)).append("\n");
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
