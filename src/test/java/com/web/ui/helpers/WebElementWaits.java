package com.web.ui.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public abstract class WebElementWaits {
    protected final WebDriver driver;
    private final static Logger LOGGER = Logger.getLogger(WebElementWaits.class.getName());
    private final static int WAIT_TIMEOUT_DEFAULT = 5;
    private static final int MILLISECOND_VALUE = 1000;
    final WebDriverWait wait;

    WebElementWaits(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = createWebWaitDriver(WAIT_TIMEOUT_DEFAULT);
    }

    WebDriver getDriver() {
        return driver;
    }

    /**
     *
     * @param timeOutInSeconds
     * @return
     */
    private WebDriverWait createWebWaitDriver(final long timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    /**
     * Waits for element to be visible within 30 sec
     *
     * @param webElement
     */
    protected void waitForElementToBeVisible(final WebElement webElement) {
        try {
            LOGGER.info("Try to Wait for element to be visible");
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not visible");
        }
    }

    /**
     * Waits for element to be visible within 30 sec
     *
     * @param elementLocator
     */
    protected void waitForElementToBeVisible(final By elementLocator) {
        try {
            LOGGER.info("Try to Wait for element to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not visible");
        }
    }

    /**
     * Waits for element to be contain given text
     *
     * @param webElement, text
     */
    protected void waitForElementToContainText(final WebElement webElement, final String text) {
        try {
            LOGGER.info("Try to Wait for element to have the text presented");
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not visible");
        }
    }

    /**
     * This method waits until the element is NOT visible
     */
    protected void waitForElementNotVisibleWithCustomTimeout(final WebElement webElement, int timeout) {
        try {
            WebDriverWait localWait = new WebDriverWait(driver, timeout);
            LOGGER.info("Try to Wait for element to be invisible");
            localWait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not invisible");
        }
    }

    /**
     * Method to wait
     *
     * @param seconds : Integer : Time to wait
     * @throws NumberFormatException
     * @throws InterruptedException
     */
    public void staticWait(int seconds) throws NumberFormatException, InterruptedException {
        LOGGER.info("Static wait in: " + seconds + " sec...");
        Thread.sleep(seconds * MILLISECOND_VALUE);
    }

    /**
     * This method waits until the element is presented in DOM
     */
    public WebElement waitForElementToBePresented(final By elementLocator) {
        try {
            LOGGER.info("Try to Wait for element to be presented in DOM");
            return wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Element is not invisible");
        }
        return null;
    }
}
