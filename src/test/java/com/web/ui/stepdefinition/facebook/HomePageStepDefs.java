package com.web.ui.stepdefinition.facebook;

import com.utilities.webdriver.InitDriver;
import com.web.ui.pom.facebook.homepage.HomePageHelpers;
import com.utilities.exception.ScumberException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class HomePageStepDefs {
    private final static Logger Log = Logger.getLogger(HomePageStepDefs.class.getName());
    private WebDriver driver;
    private HomePageHelpers homePage;

    public HomePageStepDefs() {
        Log.info("Constructor: HomePageStepDefs");
        driver = InitDriver.getInstance().getDriver();
        homePage = PageFactory.initElements(driver, HomePageHelpers.class);
    }

    @Then("^Facebook home page is displayed$")
    public void verifyFacebookHomePageIsDisplayed() throws Throwable  {
        homePage.verifyHomePageIsDisplayed();
    }

    @When("^User input status message: \"([^\"]*)\"$")
    public void userInputStatusMessage(String status) throws Throwable {
        homePage.enterStatus(status);
    }

    @Then("^Status message: \"([^\"]*)\" is created$")
    public void statusMessageIsCreated(String msg) {
        homePage.verifyStatusIsDisplayed(msg);
    }
}
