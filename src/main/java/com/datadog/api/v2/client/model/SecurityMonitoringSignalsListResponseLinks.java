/*
 * Unless explicitly stated otherwise all files in this repository are licensed under the Apache-2.0 License.
 * This product includes software developed at Datadog (https://www.datadoghq.com/).
 * Copyright 2019-Present Datadog, Inc.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.datadog.api.v2.client.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.datadog.api.v2.client.JSON;


/**
 * Links attributes.
 */
@ApiModel(description = "Links attributes.")
@JsonPropertyOrder({
  SecurityMonitoringSignalsListResponseLinks.JSON_PROPERTY_NEXT
})

public class SecurityMonitoringSignalsListResponseLinks {
  public static final String JSON_PROPERTY_NEXT = "next";
  private String next;


  public SecurityMonitoringSignalsListResponseLinks next(String next) {
    this.next = next;
    return this;
  }

   /**
   * Link for the next set of results. Note that the request can also be made using the POST endpoint.
   * @return next
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://app.datadoghq.com/api/v2/security_monitoring/signals?filter[query]=foo&page[cursor]=eyJzdGFydEF0IjoiQVFBQUFYS2tMS3pPbm40NGV3QUFBQUJCV0V0clRFdDZVbG8zY3pCRmNsbHJiVmxDWlEifQ==", value = "Link for the next set of results. Note that the request can also be made using the POST endpoint.")
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNext() {
    return next;
  }


  public void setNext(String next) {
    this.next = next;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityMonitoringSignalsListResponseLinks securityMonitoringSignalsListResponseLinks = (SecurityMonitoringSignalsListResponseLinks) o;
    return Objects.equals(this.next, securityMonitoringSignalsListResponseLinks.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(next);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityMonitoringSignalsListResponseLinks {\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

