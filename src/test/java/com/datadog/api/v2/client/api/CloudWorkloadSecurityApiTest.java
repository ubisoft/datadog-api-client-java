/*
 * Unless explicitly stated otherwise all files in this repository are licensed under the Apache-2.0 License.
 * This product includes software developed at Datadog (https://www.datadoghq.com/).
 * Copyright 2019-Present Datadog, Inc.
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.datadog.api.v2.client.api;

import com.datadog.api.v2.client.*;
import com.datadog.api.v2.client.auth.*;
import org.junit.Test;

/** API tests for CloudWorkloadSecurityApi */
public class CloudWorkloadSecurityApiTest {

  private final CloudWorkloadSecurityApi api = new CloudWorkloadSecurityApi();

  /**
   * Create a Cloud Workload Security Agent rule
   *
   * <p>Create a new Agent rule with the given parameters.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void createCloudWorkloadSecurityAgentRuleTest() throws ApiException {
    // CloudWorkloadSecurityAgentRuleCreateRequest body = null;
    // CloudWorkloadSecurityAgentRuleResponse response = api.createCloudWorkloadSecurityAgentRule()
    //        .body(body)
    //        .execute();
    // TODO: test validations
  }

  /**
   * Delete a Cloud Workload Security Agent rule
   *
   * <p>Delete a specific Agent rule.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void deleteCloudWorkloadSecurityAgentRuleTest() throws ApiException {
    // String agentRuleId = null;
    // api.deleteCloudWorkloadSecurityAgentRule(agentRuleId)
    //        .execute();
    // TODO: test validations
  }

  /**
   * Get the latest Cloud Workload Security policy
   *
   * <p>The download endpoint generates a Cloud Workload Security policy file from your currently
   * active Cloud Workload Security rules, and downloads them as a .policy file. This file can then
   * be deployed to your agents to update the policy running in your environment.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void downloadCloudWorkloadPolicyFileTest() throws ApiException {
    // File response = api.downloadCloudWorkloadPolicyFile()
    //        .execute();
    // TODO: test validations
  }

  /**
   * Get a Cloud Workload Security Agent rule
   *
   * <p>Get the details of a specific Agent rule.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void getCloudWorkloadSecurityAgentRuleTest() throws ApiException {
    // String agentRuleId = null;
    // CloudWorkloadSecurityAgentRuleResponse response =
    // api.getCloudWorkloadSecurityAgentRule(agentRuleId)
    //        .execute();
    // TODO: test validations
  }

  /**
   * Get all Cloud Workload Security Agent rules
   *
   * <p>Get the list of Agent rules.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void listCloudWorkloadSecurityAgentRulesTest() throws ApiException {
    // CloudWorkloadSecurityAgentRulesListResponse response =
    // api.listCloudWorkloadSecurityAgentRules()
    //        .execute();
    // TODO: test validations
  }

  /**
   * Update a Cloud Workload Security Agent rule
   *
   * <p>Update a specific Agent rule. Returns the Agent rule object when the request is successful.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void updateCloudWorkloadSecurityAgentRuleTest() throws ApiException {
    // String agentRuleId = null;
    // CloudWorkloadSecurityAgentRuleUpdateRequest body = null;
    // CloudWorkloadSecurityAgentRuleResponse response =
    // api.updateCloudWorkloadSecurityAgentRule(agentRuleId)
    //        .body(body)
    //        .execute();
    // TODO: test validations
  }
}
