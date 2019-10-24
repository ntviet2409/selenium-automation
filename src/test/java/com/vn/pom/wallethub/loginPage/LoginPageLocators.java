package com.vn.pom.wallethub.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageLocators {
    @FindBy(name = "em")
    public WebElement emailTextBox;
    @FindBy(name = "pw")
    public WebElement passwordTextBox;
    @FindBy(css = "[data-hm-tap*='doLogin']")
    public WebElement loginButton;

    @Autowired
    public LoginPageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
