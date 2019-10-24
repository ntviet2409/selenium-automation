package com.vn.pom.wallethub.profilePage;

import com.utilities.methods.SelectorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.utilities.methods.SelectElementByType.getElementByType;

public class ProfilePageLocators {
    @FindBy(className = "profile-name")
    public WebElement profileName;
    @FindBy(css = "[data-testid='royal_login_button']")
    public WebElement firstStar;
    @FindBy(css = ".review-action svg:nth-child(2) path[stroke='#4ae0e1'")
    public WebElement secondStar;
    @FindBy(css = ".review-action svg:nth-child(3) path[stroke='#4ae0e1'")
    public WebElement thirdStar;
    @FindBy(css = ".review-action svg:nth-child(4) path[stroke='#4ae0e1'")
    public WebElement forthStar;
    @FindBy(css = ".md-write-a-review svg:nth-child(4) path[stroke='#4ae0e1']")
    public WebElement selectedForthStar;
    @FindBy(xpath = "//span[normalize-space(text())='Select...']")
    public WebElement policyDropdown;
    @FindBy(xpath = "//li[normalize-space(text())='Health Insurance']")
    public WebElement healthInsuranceItem;
    @FindBy(css = ".wrev-user-input")
    public WebElement reviewTextBox;
    @FindBy(xpath = "//div[normalize-space(text())='Submit']")
    public WebElement submitButton;
    @FindBy(css = ".review-action svg:nth-child(4)")
    public WebElement forthStarIcon;
    @FindBy(xpath = "//h4[normalize-space(text())='Your review has been posted.']")
    public WebElement postReviewHeaderFour;

    @Autowired
    public ProfilePageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By forthStarRatingLocator() {
        return getElementByType(SelectorType.CSS, ".review-action svg:nth-child(4)");
    }

}
