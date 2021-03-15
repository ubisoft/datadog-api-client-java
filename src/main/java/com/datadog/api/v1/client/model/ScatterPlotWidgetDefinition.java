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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The scatter plot visualization allows you to graph a chosen scope over two different metrics with
 * their respective aggregation.
 */
@ApiModel(
    description =
        "The scatter plot visualization allows you to graph a chosen scope over two different"
            + " metrics with their respective aggregation.")
@JsonPropertyOrder({
  ScatterPlotWidgetDefinition.JSON_PROPERTY_COLOR_BY_GROUPS,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_CUSTOM_LINKS,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_REQUESTS,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_TIME,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_TITLE,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_TITLE_ALIGN,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_TITLE_SIZE,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_TYPE,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_XAXIS,
  ScatterPlotWidgetDefinition.JSON_PROPERTY_YAXIS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ScatterPlotWidgetDefinition {
  public static final String JSON_PROPERTY_COLOR_BY_GROUPS = "color_by_groups";
  private List<String> colorByGroups = null;

  public static final String JSON_PROPERTY_CUSTOM_LINKS = "custom_links";
  private List<WidgetCustomLink> customLinks = null;

  public static final String JSON_PROPERTY_REQUESTS = "requests";
  private ScatterPlotWidgetDefinitionRequests requests;

  public static final String JSON_PROPERTY_TIME = "time";
  private WidgetTime time;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_TITLE_ALIGN = "title_align";
  private WidgetTextAlign titleAlign;

  public static final String JSON_PROPERTY_TITLE_SIZE = "title_size";
  private String titleSize;

  public static final String JSON_PROPERTY_TYPE = "type";
  private ScatterPlotWidgetDefinitionType type = ScatterPlotWidgetDefinitionType.SCATTERPLOT;

  public static final String JSON_PROPERTY_XAXIS = "xaxis";
  private WidgetAxis xaxis;

  public static final String JSON_PROPERTY_YAXIS = "yaxis";
  private WidgetAxis yaxis;

  public ScatterPlotWidgetDefinition colorByGroups(List<String> colorByGroups) {
    this.colorByGroups = colorByGroups;
    return this;
  }

  public ScatterPlotWidgetDefinition addColorByGroupsItem(String colorByGroupsItem) {
    if (this.colorByGroups == null) {
      this.colorByGroups = new ArrayList<>();
    }
    this.colorByGroups.add(colorByGroupsItem);
    return this;
  }

  /**
   * List of groups used for colors.
   *
   * @return colorByGroups
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of groups used for colors.")
  @JsonProperty(JSON_PROPERTY_COLOR_BY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getColorByGroups() {
    return colorByGroups;
  }

  public void setColorByGroups(List<String> colorByGroups) {
    this.colorByGroups = colorByGroups;
  }

  public ScatterPlotWidgetDefinition customLinks(List<WidgetCustomLink> customLinks) {
    this.customLinks = customLinks;
    return this;
  }

  public ScatterPlotWidgetDefinition addCustomLinksItem(WidgetCustomLink customLinksItem) {
    if (this.customLinks == null) {
      this.customLinks = new ArrayList<>();
    }
    this.customLinks.add(customLinksItem);
    return this;
  }

  /**
   * List of custom links.
   *
   * @return customLinks
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of custom links.")
  @JsonProperty(JSON_PROPERTY_CUSTOM_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<WidgetCustomLink> getCustomLinks() {
    return customLinks;
  }

  public void setCustomLinks(List<WidgetCustomLink> customLinks) {
    this.customLinks = customLinks;
  }

  public ScatterPlotWidgetDefinition requests(ScatterPlotWidgetDefinitionRequests requests) {
    this.requests = requests;
    return this;
  }

  /**
   * Get requests
   *
   * @return requests
   */
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_REQUESTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public ScatterPlotWidgetDefinitionRequests getRequests() {
    return requests;
  }

  public void setRequests(ScatterPlotWidgetDefinitionRequests requests) {
    this.requests = requests;
  }

  public ScatterPlotWidgetDefinition time(WidgetTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   *
   * @return time
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WidgetTime getTime() {
    return time;
  }

  public void setTime(WidgetTime time) {
    this.time = time;
  }

  public ScatterPlotWidgetDefinition title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of your widget.
   *
   * @return title
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Title of your widget.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ScatterPlotWidgetDefinition titleAlign(WidgetTextAlign titleAlign) {
    this.titleAlign = titleAlign;
    return this;
  }

  /**
   * Get titleAlign
   *
   * @return titleAlign
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE_ALIGN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WidgetTextAlign getTitleAlign() {
    return titleAlign;
  }

  public void setTitleAlign(WidgetTextAlign titleAlign) {
    this.titleAlign = titleAlign;
  }

  public ScatterPlotWidgetDefinition titleSize(String titleSize) {
    this.titleSize = titleSize;
    return this;
  }

  /**
   * Size of the title.
   *
   * @return titleSize
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Size of the title.")
  @JsonProperty(JSON_PROPERTY_TITLE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTitleSize() {
    return titleSize;
  }

  public void setTitleSize(String titleSize) {
    this.titleSize = titleSize;
  }

  public ScatterPlotWidgetDefinition type(ScatterPlotWidgetDefinitionType type) {
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
  public ScatterPlotWidgetDefinitionType getType() {
    return type;
  }

  public void setType(ScatterPlotWidgetDefinitionType type) {
    this.type = type;
  }

  public ScatterPlotWidgetDefinition xaxis(WidgetAxis xaxis) {
    this.xaxis = xaxis;
    return this;
  }

  /**
   * Get xaxis
   *
   * @return xaxis
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_XAXIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WidgetAxis getXaxis() {
    return xaxis;
  }

  public void setXaxis(WidgetAxis xaxis) {
    this.xaxis = xaxis;
  }

  public ScatterPlotWidgetDefinition yaxis(WidgetAxis yaxis) {
    this.yaxis = yaxis;
    return this;
  }

  /**
   * Get yaxis
   *
   * @return yaxis
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_YAXIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public WidgetAxis getYaxis() {
    return yaxis;
  }

  public void setYaxis(WidgetAxis yaxis) {
    this.yaxis = yaxis;
  }

  /** Return true if this ScatterPlotWidgetDefinition object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScatterPlotWidgetDefinition scatterPlotWidgetDefinition = (ScatterPlotWidgetDefinition) o;
    return Objects.equals(this.colorByGroups, scatterPlotWidgetDefinition.colorByGroups)
        && Objects.equals(this.customLinks, scatterPlotWidgetDefinition.customLinks)
        && Objects.equals(this.requests, scatterPlotWidgetDefinition.requests)
        && Objects.equals(this.time, scatterPlotWidgetDefinition.time)
        && Objects.equals(this.title, scatterPlotWidgetDefinition.title)
        && Objects.equals(this.titleAlign, scatterPlotWidgetDefinition.titleAlign)
        && Objects.equals(this.titleSize, scatterPlotWidgetDefinition.titleSize)
        && Objects.equals(this.type, scatterPlotWidgetDefinition.type)
        && Objects.equals(this.xaxis, scatterPlotWidgetDefinition.xaxis)
        && Objects.equals(this.yaxis, scatterPlotWidgetDefinition.yaxis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        colorByGroups,
        customLinks,
        requests,
        time,
        title,
        titleAlign,
        titleSize,
        type,
        xaxis,
        yaxis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScatterPlotWidgetDefinition {\n");
    sb.append("    colorByGroups: ").append(toIndentedString(colorByGroups)).append("\n");
    sb.append("    customLinks: ").append(toIndentedString(customLinks)).append("\n");
    sb.append("    requests: ").append(toIndentedString(requests)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    titleAlign: ").append(toIndentedString(titleAlign)).append("\n");
    sb.append("    titleSize: ").append(toIndentedString(titleSize)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    xaxis: ").append(toIndentedString(xaxis)).append("\n");
    sb.append("    yaxis: ").append(toIndentedString(yaxis)).append("\n");
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
