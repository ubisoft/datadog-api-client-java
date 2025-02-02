# SyntheticsTestConfig

Configuration object for a Synthetic test.

## Properties

| Name                | Type                                                                      | Description                                                           | Notes      |
| ------------------- | ------------------------------------------------------------------------- | --------------------------------------------------------------------- | ---------- |
| **assertions**      | [**List&lt;SyntheticsAssertion&gt;**](SyntheticsAssertion.md)             | Array of assertions used for the test. Required for single API tests. | [optional] |
| **configVariables** | [**List&lt;SyntheticsConfigVariable&gt;**](SyntheticsConfigVariable.md)   | Array of variables used for the test.                                 | [optional] |
| **request**         | [**SyntheticsTestRequest**](SyntheticsTestRequest.md)                     |                                                                       | [optional] |
| **variables**       | [**List&lt;SyntheticsBrowserVariable&gt;**](SyntheticsBrowserVariable.md) | Browser tests only - array of variables used for the test steps.      | [optional] |
