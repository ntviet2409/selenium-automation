package com.vn.pom.facebook.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageLocators {
    @FindBy(css = "textarea[name*='message']")
    public WebElement statusTextBox;

    @FindBy(css = "[data-testid='react-composer-post-button']")
    public WebElement submitStatusButton;

    @FindBy(className = "_3ixn")
    public WebElement loadingIcon;

    private String statusXpath = "//div[@role='article']//p[normalize-space(text())='%s']";

    @Autowired
    public HomePageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By getStatusByValue(String value) {
        return By.xpath(String.format(statusXpath, value));
    }
}
