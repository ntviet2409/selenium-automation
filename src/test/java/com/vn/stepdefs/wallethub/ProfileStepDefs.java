package com.vn.stepdefs.wallethub;

import com.utilities.methods.BrowserUtils;
import com.vn.pom.wallethub.profilePage.ProfilePageHelper;
import com.vn.utils.ScumberException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class ProfileStepDefs {
    private final static Logger Log = Logger.getLogger(ProfileStepDefs.class.getName());

    private WebDriver driver;
    private ProfilePageHelper ProfilePage;

    public ProfileStepDefs() {
        Log.info("Constructor: LoginStepDefs");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        driver = BrowserUtils.getInstance().getDriver();
        ProfilePage = PageFactory.initElements(driver, ProfilePageHelper.class);
    }

    @When("^User hovers over the stars$")
    public void userHoversOverTheStarts() {
        ProfilePage.scrollAndHoverForthStar();
    }

    @Then("^Profile name is displayed$")
    public void profileNameIsDisplayed() {
        ProfilePage.verifyProfilePageIsDisplayed();
    }

    @Then("^The first four stars inside get lit up when you hover over them$")
    public void theStarsInsideGetLitUpWhenYouHoverOverThem() {
        ProfilePage.verifyHighlightedRatingStar();
    }

    @When("^User clicks on the forth star$")
    public void userClicksOnTheForthStar() {
        ProfilePage.clickForthStar();
    }

    @Then("^The forth star is selected with the Policy dropdown$")
    public void theForthStarIsSelectedWithThePolicyDropdown() {
        ProfilePage.verifySelectedForthRatingStarIsVisible();
        ProfilePage.verifyPolicyDropdownIsDisplayed();
    }

    @When("^User clicks on the Policy dropdown$")
    public void userClicksOnThePolicyDropdown() {
        ProfilePage.clickPolicyDropdown();
    }

    @When("^User changes the value to “Health Insurance”$")
    public void userChangesTheValueToHealthInsurance() {
        ProfilePage.clickHealthInsuranceItem();
    }

    @When("^User clicks on the link “Write a review” to write some random text at minimum of \"([^\"]*)\" characters$")
    public void userClicksOnTheLinkWriteAReviewToWriteRandomText(String size) {
        ProfilePage.writeRandomComment(Integer.parseInt(size));
    }

    @When("^Press submit button$")
    public void pressSubmitButton() {
        ProfilePage.clickSubmitButton();
    }

    @Then("^User should see a confirmation screen saying you have reviewed the institution$")
    public void userShouldSeeAConfirmationScreenAboutReviewedInstitution() {
        ProfilePage.verifyConfirmationScreenIsDisplayed();
    }
}
