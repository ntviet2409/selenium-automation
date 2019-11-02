package com.web.configuration;

import com.utilities.webdriver.InitDriver;
import com.utilities.report.AllureReportSetup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = {
        "pretty",
        "html:target/cucumber/cucumber-html-report",
        "json:target/cucumber/cucumber-json-report.json"},
        monochrome = true,
        features = {"classpath:featurefiles/"},
        glue = {"com.web.ui.stepdefinition", "com.web.api.stepdefinition"})

@RunWith(Cucumber.class)
public class MasterTest {

    @BeforeClass()
    public static void runTomcat() throws Exception {
        AllureReportSetup.prepareAllureResultsFolder();
    }

    @AfterClass()
    public static void tearDown() {
        InitDriver.getInstance().getDriver().quit();
    }
}
