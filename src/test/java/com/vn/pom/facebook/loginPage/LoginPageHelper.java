package com.vn.pom.facebook.loginPage;

import com.vn.utils.AbstractBasePage;
import com.vn.utils.web.WebElementVerification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;

import static com.vn.pom.commonPage.CommonPageConstants.LOGIN_FAILURE_MSG;

public class LoginPageHelper extends AbstractBasePage {
    private final LoginPageLocators loginPageLocators;
    private final static Logger LOGGER = Logger.getLogger(WebElementVerification.class.getName());

    @Autowired
    public LoginPageHelper(final WebDriver driver) {
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
