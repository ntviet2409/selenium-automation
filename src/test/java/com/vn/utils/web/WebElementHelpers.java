package com.vn.utils.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public abstract class WebElementHelpers extends WebElementVerification {
    private final static Logger LOGGER = Logger.getLogger(WebElementHelpers.class.getName());
    private final Actions action = new Actions(driver);

    public WebElementHelpers(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    protected void sendKeyToTextBox(final WebElement editBox, final String valueToType) {
        waitForElementToBeVisible(editBox);
        LOGGER.info("Clear text in text box");
        editBox.clear();
        LOGGER.info(String.format("Send keys: %s into text box", valueToType));
        editBox.sendKeys(valueToType);
    }


    protected void clickAndSendKeyToTextBox(final WebElement editBox, final String valueToType) {
        clickElement(editBox);
        sendKeyToTextBox(editBox, valueToType);
    }

    protected void clickElement(final WebElement webElement) {
        waitForElementToBeVisible(webElement);
        LOGGER.info("Click on the element");
        webElement.click();
    }

    protected void scrollToElement(By elementLocator) {
        WebElement element = waitForElementToBePresented(elementLocator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        LOGGER.info("Scroll to element by Javascript");
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void hoverOverElement(By elementLocator) {
        WebElement element = waitForElementToBePresented(elementLocator);
        LOGGER.info("Hover mouse on the element");
        action.moveToElement(element).perform();
    }
}
