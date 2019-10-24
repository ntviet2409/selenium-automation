package com.vn.utils;

import com.vn.utils.web.WebElementHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class AbstractBasePage extends WebElementHelpers {
    private final static Logger Log = Logger.getLogger(AbstractBasePage.class.getName());

    protected AbstractBasePage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Get element text or attribute value
     */
    protected String getElementText(final WebElement element) {
        waitForElementToBeVisible(element);
        final String buttonText = element.getAttribute("value");
        return !buttonText.equals("") ? buttonText : element.getText();
    }

    /**
     * Returns the value of the attribute for that element
     *
     * @param attribute = "class", "id" etc.
     */
    protected String getElementAttribute(final WebElement element, final String attribute) {
        return element.getAttribute(attribute);
    }
}
