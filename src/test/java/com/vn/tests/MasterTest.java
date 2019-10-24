package com.vn.tests;

import com.utilities.methods.BrowserUtils;
import com.utilities.reports.AllureReportConfigurationSetup;
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
        features = {"classpath:feature_files/"},
        glue = {"com.vn.stepdefs"})

@RunWith(Cucumber.class)
public class MasterTest {
    @BeforeClass()
    public static void runTomcat() throws Exception {
        AllureReportConfigurationSetup.prepareAllureResultsFolder();
    }

    @AfterClass()
    public static void tearDown() {
        BrowserUtils.getInstance().getDriver().quit();
    }
}
