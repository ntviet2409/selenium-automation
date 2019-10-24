package com.vn.pom.facebook.homePage;

import com.vn.utils.AbstractBasePage;
import com.vn.utils.web.WebElementVerification;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

import static com.vn.pom.commonPage.CommonPageConstants.INT_FIVE;
import static com.vn.pom.commonPage.CommonPageConstants.INT_TWO;
import static com.vn.pom.facebook.loginPage.LoginPageConstants.FB_STATUS_FAILURE_MSG;

public class HomePageHelper extends AbstractBasePage {
    private final HomePageLocators homePageLocators;
    private final static Logger LOGGER = Logger.getLogger(WebElementVerification.class.getName());

    @Autowired
    public HomePageHelper(final WebDriver driver) {
        super(driver);
        homePageLocators = PageFactory.initElements(driver, HomePageLocators.class);
    }

    public void verifyHomePageIsDisplayed() {
        waitForLoadingIconIsComplete();
        LOGGER.info("If notification popup is shown, hit ESCAPE key");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void enterStatus(final String status) throws Throwable{

        LOGGER.info(String.format("Enter status: %s", status));
        clickAndSendKeyToTextBox(homePageLocators.statusTextBox, status);
        LOGGER.info("Pause the execution in 2s");
        staticWait(INT_TWO);
        LOGGER.info("Then click submit status button");
        clickElement(homePageLocators.submitStatusButton);
    }

    public void verifyStatusIsDisplayed(String statusMsg) {
        LOGGER.info("Verify the status is displayed after being created");
        verifyElementIsVisible(homePageLocators.getStatusByValue(statusMsg), FB_STATUS_FAILURE_MSG);
    }

    public void waitForLoadingIconIsComplete() {
        waitForElementNotVisibleWithCustomTimeout(homePageLocators.loadingIcon, INT_FIVE);
    }
}
