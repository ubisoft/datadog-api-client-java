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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** The GCS archive&#39;s integration destination. */
@ApiModel(description = "The GCS archive's integration destination.")
@JsonPropertyOrder({
  LogsArchiveIntegrationGCS.JSON_PROPERTY_CLIENT_EMAIL,
  LogsArchiveIntegrationGCS.JSON_PROPERTY_PROJECT_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LogsArchiveIntegrationGCS {
  public static final String JSON_PROPERTY_CLIENT_EMAIL = "client_email";
  private String clientEmail;

  public static final String JSON_PROPERTY_PROJECT_ID = "project_id";
  private String projectId;

  public LogsArchiveIntegrationGCS clientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
    return this;
  }

  /**
   * A client email.
   *
   * @return clientEmail
   */
  @ApiModelProperty(example = "youremail@example.com", required = true, value = "A client email.")
  @JsonProperty(JSON_PROPERTY_CLIENT_EMAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getClientEmail() {
    return clientEmail;
  }

  public void setClientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
  }

  public LogsArchiveIntegrationGCS projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * A project ID.
   *
   * @return projectId
   */
  @ApiModelProperty(example = "project-id", required = true, value = "A project ID.")
  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  /** Return true if this LogsArchiveIntegrationGCS object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogsArchiveIntegrationGCS logsArchiveIntegrationGCS = (LogsArchiveIntegrationGCS) o;
    return Objects.equals(this.clientEmail, logsArchiveIntegrationGCS.clientEmail)
        && Objects.equals(this.projectId, logsArchiveIntegrationGCS.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientEmail, projectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogsArchiveIntegrationGCS {\n");
    sb.append("    clientEmail: ").append(toIndentedString(clientEmail)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
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
