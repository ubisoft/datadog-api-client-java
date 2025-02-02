# HostMapWidgetDefinition

The host map widget graphs any metric across your hosts using the same visualization available from the main Host Map page.

## Properties

| Name              | Type                                                                      | Description                                          | Notes      |
| ----------------- | ------------------------------------------------------------------------- | ---------------------------------------------------- | ---------- |
| **customLinks**   | [**List&lt;WidgetCustomLink&gt;**](WidgetCustomLink.md)                   | List of custom links.                                | [optional] |
| **group**         | **List&lt;String&gt;**                                                    | List of tag prefixes to group by.                    | [optional] |
| **noGroupHosts**  | **Boolean**                                                               | Whether to show the hosts that don’t fit in a group. | [optional] |
| **noMetricHosts** | **Boolean**                                                               | Whether to show the hosts with no metrics.           | [optional] |
| **nodeType**      | **WidgetNodeType**                                                        |                                                      | [optional] |
| **notes**         | **String**                                                                | Notes on the title.                                  | [optional] |
| **requests**      | [**HostMapWidgetDefinitionRequests**](HostMapWidgetDefinitionRequests.md) |                                                      |
| **scope**         | **List&lt;String&gt;**                                                    | List of tags used to filter the map.                 | [optional] |
| **style**         | [**HostMapWidgetDefinitionStyle**](HostMapWidgetDefinitionStyle.md)       |                                                      | [optional] |
| **title**         | **String**                                                                | Title of the widget.                                 | [optional] |
| **titleAlign**    | **WidgetTextAlign**                                                       |                                                      | [optional] |
| **titleSize**     | **String**                                                                | Size of the title.                                   | [optional] |
| **type**          | **HostMapWidgetDefinitionType**                                           |                                                      |
