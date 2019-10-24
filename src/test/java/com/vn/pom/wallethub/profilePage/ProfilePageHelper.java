package com.vn.pom.wallethub.profilePage;

import com.utilities.methods.BrowserUtils;
import com.vn.utils.AbstractBasePage;
import com.vn.utils.web.WebElementVerification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

import static com.vn.pom.wallethub.profilePage.ProfileConstants.POLICY_DROPDOWN_FAILURE_MSG;
import static com.vn.pom.wallethub.profilePage.ProfileConstants.PROFILE_FAILURE_MSG;
import static com.vn.pom.wallethub.profilePage.ProfileConstants.RATING_STAR_FAILURE_MSG;

public class ProfilePageHelper extends AbstractBasePage {
    private final ProfilePageLocators profilePageLocators;
    private final static Logger LOGGER = Logger.getLogger(WebElementVerification.class.getName());

    @Autowired
    public ProfilePageHelper(final WebDriver driver) {
        super(driver);
        profilePageLocators = PageFactory.initElements(driver, ProfilePageLocators.class);
    }

    public void verifyProfilePageIsDisplayed() {
        LOGGER.info("Verify profile page is displayed");
        verifyElementIsVisible(profilePageLocators.profileName, PROFILE_FAILURE_MSG);
    }

    public void scrollAndHoverForthStar() {
        LOGGER.info("Scrolling to the forth star");
        scrollToElement(profilePageLocators.forthStarRatingLocator());
        LOGGER.info("Hover the mouse over the forth star");
        hoverOverElement(profilePageLocators.forthStarRatingLocator());
    }

    public void verifyHighlightedRatingStar() {
        LOGGER.info("Verify the first start is highlighted");
        verifyElementIsVisible(profilePageLocators.firstStar, RATING_STAR_FAILURE_MSG);
        LOGGER.info("Verify the first second is highlighted");
        verifyElementIsVisible(profilePageLocators.secondStar, RATING_STAR_FAILURE_MSG);
        LOGGER.info("Verify the first third is highlighted");
        verifyElementIsVisible(profilePageLocators.thirdStar, RATING_STAR_FAILURE_MSG);
        LOGGER.info("Verify the first forth is highlighted");
        verifyElementIsVisible(profilePageLocators.forthStar, RATING_STAR_FAILURE_MSG);
    }

    public void verifySelectedForthRatingStarIsVisible() {
        LOGGER.info("Verify forth star is selected and highlighted");
        verifyElementIsVisible(profilePageLocators.selectedForthStar, RATING_STAR_FAILURE_MSG);
    }

    public void verifyPolicyDropdownIsDisplayed() {
        LOGGER.info("Verify Policy dropdown is displayed");
        verifyElementIsVisible(profilePageLocators.policyDropdown, POLICY_DROPDOWN_FAILURE_MSG);
    }

    public void clickForthStar() {
        LOGGER.info("Click on the forth start");
        clickElement(profilePageLocators.forthStarIcon);
    }


    public void clickPolicyDropdown() {
        LOGGER.info("Click on the policy dropdown");
        clickElement(profilePageLocators.policyDropdown);
    }

    public void clickHealthInsuranceItem() {
        LOGGER.info("Click on Health Insurance item");
        clickElement(profilePageLocators.healthInsuranceItem);
    }

    public void writeRandomComment(int size) {
        LOGGER.info(String.format("Write the random comment on the custom size: ", size));
        sendKeyToTextBox(profilePageLocators.reviewTextBox, BrowserUtils.generateRandomString(size));
    }

    public void clickSubmitButton() {
        LOGGER.info("Click on submit button");
        clickElement(profilePageLocators.submitButton);
    }

    public void verifyConfirmationScreenIsDisplayed() {
        LOGGER.info("Verify confirmation screen is displayed");
        verifyElementIsVisible(profilePageLocators.postReviewHeaderFour, RATING_STAR_FAILURE_MSG);
    }
}
