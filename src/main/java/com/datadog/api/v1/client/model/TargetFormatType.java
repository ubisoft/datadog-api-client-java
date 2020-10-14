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
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.datadog.api.v1.client.JSON;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * If the &#x60;target_type&#x60; of the remapper is &#x60;attribute&#x60;, try to cast the value to a new specific type. If the cast is not possible, the original type is kept. &#x60;string&#x60;, &#x60;integer&#x60;, or &#x60;double&#x60; are the possible types. If the &#x60;target_type&#x60; is &#x60;tag&#x60;, this parameter may not be specified.
 */
public enum TargetFormatType {
  
  AUTO("auto"),
  
  STRING("string"),
  
  INTEGER("integer"),
  
  DOUBLE("double");

  private String value;

  TargetFormatType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TargetFormatType fromValue(String value) {
    for (TargetFormatType b : TargetFormatType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

