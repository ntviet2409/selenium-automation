package com.web.ui.helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class WebElementVerifications extends WebElementWaits {
    private final static Logger LOGGER = Logger.getLogger(WebElementVerifications.class.getName());

    WebElementVerifications(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Check if element is visible or not
     *
     * @param webElement
     * @param message
     */
    protected void verifyElementIsVisible(final WebElement webElement, final String message) {
        waitForElementToBeVisible(webElement);
        LOGGER.info("Verify element to be visible");
        Assert.assertTrue(message, webElement.isDisplayed());
    }

    protected void verifyElementIsVisible(final By elementLocator, final String message) {
        waitForElementToBeVisible(elementLocator);
        verifyElementIsVisible(driver.findElement(elementLocator), message);
    }

    /**
     * Check if text is present for selected object
     *
     * @param webElement
     * @param message
     * @param text
     */
    protected void verifyTextIsVisible(final WebElement webElement, final String message, final String text) {
        waitForElementToBeVisible(webElement);
        final String elementText = webElement.getText();
        LOGGER.info(String.format("Verify text: %s is visible", text));
        Assert.assertTrue(message + elementText, elementText.contains(text));
    }

    /**
     * Check count of objects
     *
     * @param webElements
     * @param message
     * @param expectedCount
     */
    protected void verifyCountOfElements(final List<WebElement> webElements, final String message, final int expectedCount) {
        final int count = webElements.size();
        LOGGER.info(String.format("Verify number of elements is: %s", expectedCount));
        Assert.assertEquals(message, expectedCount, count);
    }
}
