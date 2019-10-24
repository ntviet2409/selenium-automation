package com.vn.stepdefs.wallethub;

import com.utilities.methods.BrowserUtils;
import com.vn.pom.wallethub.loginPage.LoginPageHelper;
import com.vn.utils.ScumberException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginStepDefs {
    private final static Logger Log = Logger.getLogger(LoginStepDefs.class.getName());

    private WebDriver driver;
    private LoginPageHelper loginPage;

    public LoginStepDefs() {
        Log.info("Constructor: LoginStepDefs");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        driver = BrowserUtils.getInstance().getDriver();
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    @When("^User navigates to WalletHub url: \"([^\"]*)\"$")
    public void navigateAdminUI(final String url) {
        driver.navigate().to(url);
    }

    @When("^User signs in WalletHub with user email: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void loginToWalletHubWithUserEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
