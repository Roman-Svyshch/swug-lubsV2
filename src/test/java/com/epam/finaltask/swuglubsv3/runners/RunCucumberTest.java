package com.epam.finaltask.swuglubsv3.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports/cucumber.html")
@ConfigurationParameter(key = "cucumber.glue", value = "com.epam.finaltask.swuglubsv3.stepDefinitions")
public class RunCucumberTest {
}
