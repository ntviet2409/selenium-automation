package com.vn.stepdefs.facebook;

import com.utilities.methods.BrowserUtils;
import com.vn.pom.facebook.loginPage.LoginPageHelper;
import com.vn.utils.ScumberException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginStepDefs {
    private final static Logger LOGGER = Logger.getLogger(LoginStepDefs.class.getName());

    private WebDriver driver;
    private LoginPageHelper loginPage;

    public LoginStepDefs() {
        LOGGER.info("Constructor: LoginStepDefs");
    }

    @Before
    public void before(final Scenario scenario) {
        driver = BrowserUtils.getInstance().getDriver();
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    @Given("^User navigates to url: \"([^\"]*)\"$")
    public void navigateAdminUI(final String url) {
        driver.get(url);
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
