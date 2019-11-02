package com.web.ui.stepdefinition.facebook;

import com.utilities.webdriver.InitDriver;
import com.web.ui.pom.facebook.loginpage.LoginPageHelpers;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginStepDefs {
    private final static Logger LOGGER = Logger.getLogger(LoginStepDefs.class.getName());

    private WebDriver driver;
    private LoginPageHelpers loginPage;

    public LoginStepDefs(final Scenario scenario) {
        LOGGER.info("Constructor: LoginStepDefs");
        driver = InitDriver.getInstance().getDriver();
        loginPage = PageFactory.initElements(driver, LoginPageHelpers.class);
    }

    @Given("^User navigates to url: \"([^\"]*)\"$")
    public void navigateAdminUI(final String url) {
        driver.navigate().to(url);
    }

    @Given("^Login page is loaded$")
    public void loginPageIsLoaded() {
        loginPage.verifyLoginPageDisplayed();
    }

    @When("^Login to Facebook with user email: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void loginToFacebookWithUserEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Given("^Generic logout$")
    public void genericLogout() {
        driver.manage().deleteAllCookies();
    }
}
