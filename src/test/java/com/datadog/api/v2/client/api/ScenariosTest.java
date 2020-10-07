package com.datadog.api.v2.client.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = { "pretty", "summary" },
    snippets = CAMELCASE,
    tags = "@v2 and not @skip",
    glue = {"com.datadog.api.v2.client.api"},
    features="src/test/resources/com/datadog/api/v2/client/api/"
)
public class ScenariosTest {
}