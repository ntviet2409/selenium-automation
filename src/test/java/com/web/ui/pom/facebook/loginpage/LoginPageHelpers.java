package com.web.ui.pom.facebook.loginpage;

import com.web.ui.helpers.WebElementHelpers;
import com.web.ui.helpers.WebElementVerifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;

import static com.web.ui.pom.common.CommonPageConstants.LOGIN_FAILURE_MSG;

public class LoginPageHelpers extends WebElementHelpers {
    private final LoginPageLocators loginPageLocators;
    private final static Logger LOGGER = Logger.getLogger(WebElementVerifications.class.getName());

    @Autowired
    public LoginPageHelpers(final WebDriver driver) {
        super(driver);
        loginPageLocators = PageFactory.initElements(driver, LoginPageLocators.class);
    }

    public void enterEmail(final String email) {
        LOGGER.info(String.format("Enter email: %s", email));
        sendKeyToTextBox(loginPageLocators.emailTextBox, email);
    }

    public void enterPassword(final String password) {
        LOGGER.info(String.format("Enter password: %s", password));
        sendKeyToTextBox(loginPageLocators.passwordTextBox, password);
    }

    public void clickLoginButton() {
        LOGGER.info("Click login button");
        clickElement(loginPageLocators.loginButton);
    }

    public void verifyLoginPageDisplayed() {
        LOGGER.info("Verify login page is displayed");
        verifyElementIsVisible(loginPageLocators.loginButton, LOGIN_FAILURE_MSG);
    }
}
