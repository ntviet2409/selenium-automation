package com.web.ui.pom.facebook.homepage;

import static com.web.ui.pom.common.CommonPageConstants.INT_FIVE;
import static com.web.ui.pom.common.CommonPageConstants.INT_TWO;
import static com.web.ui.pom.facebook.loginpage.LoginPageConstants.FB_STATUS_FAILURE_MSG;

import com.web.ui.helpers.WebElementHelpers;
import com.web.ui.helpers.WebElementVerifications;
import java.util.logging.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageHelpers extends WebElementHelpers {
    private final HomePageLocators homePageLocators;
    private final static Logger LOGGER = Logger.getLogger(WebElementVerifications.class.getName());

    @Autowired
    public HomePageHelpers(final WebDriver driver) {
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
