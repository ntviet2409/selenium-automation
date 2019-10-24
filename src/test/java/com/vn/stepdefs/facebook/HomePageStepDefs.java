package com.vn.stepdefs.facebook;

import com.utilities.methods.BrowserUtils;
import com.vn.pom.facebook.homePage.HomePageHelper;
import com.vn.utils.ScumberException;
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
    private HomePageHelper homePage;

    public HomePageStepDefs() {
        Log.info("Constructor: HomePageStepDefs");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        driver = BrowserUtils.getInstance().getDriver();
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
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
