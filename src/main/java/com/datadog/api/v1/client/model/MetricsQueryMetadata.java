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
import java.util.List;
import java.util.Objects;

/** Object containing all metric names returned and their associated metadata. */
@ApiModel(
    description = "Object containing all metric names returned and their associated metadata.")
@JsonPropertyOrder({
  MetricsQueryMetadata.JSON_PROPERTY_AGGR,
  MetricsQueryMetadata.JSON_PROPERTY_DISPLAY_NAME,
  MetricsQueryMetadata.JSON_PROPERTY_END,
  MetricsQueryMetadata.JSON_PROPERTY_EXPRESSION,
  MetricsQueryMetadata.JSON_PROPERTY_INTERVAL,
  MetricsQueryMetadata.JSON_PROPERTY_LENGTH,
  MetricsQueryMetadata.JSON_PROPERTY_METRIC,
  MetricsQueryMetadata.JSON_PROPERTY_POINTLIST,
  MetricsQueryMetadata.JSON_PROPERTY_QUERY_INDEX,
  MetricsQueryMetadata.JSON_PROPERTY_SCOPE,
  MetricsQueryMetadata.JSON_PROPERTY_START,
  MetricsQueryMetadata.JSON_PROPERTY_TAG_SET,
  MetricsQueryMetadata.JSON_PROPERTY_UNIT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MetricsQueryMetadata {
  public static final String JSON_PROPERTY_AGGR = "aggr";
  private String aggr;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";
  private String displayName;

  public static final String JSON_PROPERTY_END = "end";
  private Long end;

  public static final String JSON_PROPERTY_EXPRESSION = "expression";
  private String expression;

  public static final String JSON_PROPERTY_INTERVAL = "interval";
  private Long interval;

  public static final String JSON_PROPERTY_LENGTH = "length";
  private Long length;

  public static final String JSON_PROPERTY_METRIC = "metric";
  private String metric;

  public static final String JSON_PROPERTY_POINTLIST = "pointlist";
  private List<List<Double>> pointlist = null;

  public static final String JSON_PROPERTY_QUERY_INDEX = "query_index";
  private Long queryIndex;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  private String scope;

  public static final String JSON_PROPERTY_START = "start";
  private Long start;

  public static final String JSON_PROPERTY_TAG_SET = "tag_set";
  private List<String> tagSet = null;

  public static final String JSON_PROPERTY_UNIT = "unit";
  private List<MetricsQueryUnit> unit = null;

  /**
   * Aggregation type.
   *
   * @return aggr
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "avg", value = "Aggregation type.")
  @JsonProperty(JSON_PROPERTY_AGGR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAggr() {
    return aggr;
  }

  /**
   * Display name of the metric.
   *
   * @return displayName
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "system.cpu.idle", value = "Display name of the metric.")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDisplayName() {
    return displayName;
  }

  /**
   * End of the time window, milliseconds since Unix epoch.
   *
   * @return end
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "End of the time window, milliseconds since Unix epoch.")
  @JsonProperty(JSON_PROPERTY_END)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getEnd() {
    return end;
  }

  /**
   * Metric expression.
   *
   * @return expression
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "system.cpu.idle{host:foo,env:test}", value = "Metric expression.")
  @JsonProperty(JSON_PROPERTY_EXPRESSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExpression() {
    return expression;
  }

  /**
   * Number of seconds between data samples.
   *
   * @return interval
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of seconds between data samples.")
  @JsonProperty(JSON_PROPERTY_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getInterval() {
    return interval;
  }

  /**
   * Number of data samples.
   *
   * @return length
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of data samples.")
  @JsonProperty(JSON_PROPERTY_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getLength() {
    return length;
  }

  /**
   * Metric name.
   *
   * @return metric
   */
  @javax.annotation.Nullable
  @ApiModelProperty(example = "system.cpu.idle", value = "Metric name.")
  @JsonProperty(JSON_PROPERTY_METRIC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMetric() {
    return metric;
  }

  /**
   * List of points of the time series.
   *
   * @return pointlist
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of points of the time series.")
  @JsonProperty(JSON_PROPERTY_POINTLIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<List<Double>> getPointlist() {
    return pointlist;
  }

  /**
   * The index of the series&#39; query within the request.
   *
   * @return queryIndex
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The index of the series' query within the request.")
  @JsonProperty(JSON_PROPERTY_QUERY_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getQueryIndex() {
    return queryIndex;
  }

  /**
   * Metric scope, comma separated list of tags.
   *
   * @return scope
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      example = "host:foo,env:test",
      value = "Metric scope, comma separated list of tags.")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getScope() {
    return scope;
  }

  /**
   * Start of the time window, milliseconds since Unix epoch.
   *
   * @return start
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Start of the time window, milliseconds since Unix epoch.")
  @JsonProperty(JSON_PROPERTY_START)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getStart() {
    return start;
  }

  /**
   * Unique tags identifying this series.
   *
   * @return tagSet
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unique tags identifying this series.")
  @JsonProperty(JSON_PROPERTY_TAG_SET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getTagSet() {
    return tagSet;
  }

  /**
   * Detailed information about the metric unit. First element describes the \&quot;primary
   * unit\&quot; (for example, &#x60;bytes&#x60; in &#x60;bytes per second&#x60;), second describes
   * the \&quot;per unit\&quot; (for example, &#x60;second&#x60; in &#x60;bytes per second&#x60;).
   *
   * @return unit
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      value =
          "Detailed information about the metric unit. First element describes the \"primary"
              + " unit\" (for example, `bytes` in `bytes per second`), second describes the \"per"
              + " unit\" (for example, `second` in `bytes per second`).")
  @JsonProperty(JSON_PROPERTY_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<MetricsQueryUnit> getUnit() {
    return unit;
  }

  /** Return true if this MetricsQueryMetadata object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetricsQueryMetadata metricsQueryMetadata = (MetricsQueryMetadata) o;
    return Objects.equals(this.aggr, metricsQueryMetadata.aggr)
        && Objects.equals(this.displayName, metricsQueryMetadata.displayName)
        && Objects.equals(this.end, metricsQueryMetadata.end)
        && Objects.equals(this.expression, metricsQueryMetadata.expression)
        && Objects.equals(this.interval, metricsQueryMetadata.interval)
        && Objects.equals(this.length, metricsQueryMetadata.length)
        && Objects.equals(this.metric, metricsQueryMetadata.metric)
        && Objects.equals(this.pointlist, metricsQueryMetadata.pointlist)
        && Objects.equals(this.queryIndex, metricsQueryMetadata.queryIndex)
        && Objects.equals(this.scope, metricsQueryMetadata.scope)
        && Objects.equals(this.start, metricsQueryMetadata.start)
        && Objects.equals(this.tagSet, metricsQueryMetadata.tagSet)
        && Objects.equals(this.unit, metricsQueryMetadata.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        aggr,
        displayName,
        end,
        expression,
        interval,
        length,
        metric,
        pointlist,
        queryIndex,
        scope,
        start,
        tagSet,
        unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetricsQueryMetadata {\n");
    sb.append("    aggr: ").append(toIndentedString(aggr)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
    sb.append("    pointlist: ").append(toIndentedString(pointlist)).append("\n");
    sb.append("    queryIndex: ").append(toIndentedString(queryIndex)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    tagSet: ").append(toIndentedString(tagSet)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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
