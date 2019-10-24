package com.vn.pom.facebook.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageLocators {
    @FindBy(name = "email")
    public WebElement emailTextBox;
    @FindBy(name = "pass")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//*[@data-testid='royal_login_button' or @name='login' or @type='submit']")
    public WebElement loginButton;

    @Autowired
    public LoginPageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
