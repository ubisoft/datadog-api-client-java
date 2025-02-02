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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Has two properties, &#x60;enabled&#x60; (boolean) and &#x60;domains&#x60;, which is a list of
 * domains without the @ symbol.
 */
@ApiModel(
    description =
        "Has two properties, `enabled` (boolean) and `domains`, which is a list of domains without"
            + " the @ symbol.")
@JsonPropertyOrder({
  OrganizationSettingsSamlAutocreateUsersDomains.JSON_PROPERTY_DOMAINS,
  OrganizationSettingsSamlAutocreateUsersDomains.JSON_PROPERTY_ENABLED
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OrganizationSettingsSamlAutocreateUsersDomains {
  @JsonIgnore public boolean unparsed = false;
  public static final String JSON_PROPERTY_DOMAINS = "domains";
  private List<String> domains = null;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  private Boolean enabled;

  public OrganizationSettingsSamlAutocreateUsersDomains domains(List<String> domains) {
    this.domains = domains;
    return this;
  }

  public OrganizationSettingsSamlAutocreateUsersDomains addDomainsItem(String domainsItem) {
    if (this.domains == null) {
      this.domains = new ArrayList<>();
    }
    this.domains.add(domainsItem);
    return this;
  }

  /**
   * List of domains where the SAML automated user creation is enabled.
   *
   * @return domains
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of domains where the SAML automated user creation is enabled.")
  @JsonProperty(JSON_PROPERTY_DOMAINS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getDomains() {
    return domains;
  }

  public void setDomains(List<String> domains) {
    this.domains = domains;
  }

  public OrganizationSettingsSamlAutocreateUsersDomains enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Whether or not the automated user creation based on SAML domain is enabled.
   *
   * @return enabled
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
      example = "false",
      value = "Whether or not the automated user creation based on SAML domain is enabled.")
  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Return true if this Organization_settings_saml_autocreate_users_domains object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationSettingsSamlAutocreateUsersDomains organizationSettingsSamlAutocreateUsersDomains =
        (OrganizationSettingsSamlAutocreateUsersDomains) o;
    return Objects.equals(this.domains, organizationSettingsSamlAutocreateUsersDomains.domains)
        && Objects.equals(this.enabled, organizationSettingsSamlAutocreateUsersDomains.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domains, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationSettingsSamlAutocreateUsersDomains {\n");
    sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
