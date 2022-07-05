package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
              "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "src/test/resources_cydeo/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@crm"
)
public class CukesRunner {
}