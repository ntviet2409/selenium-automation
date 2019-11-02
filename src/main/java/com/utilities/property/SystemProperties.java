package com.utilities.property;

import com.utilities.webdriver.BaseTest;
import com.utilities.webdriver.WebDriverSetup;

public class SystemProperties implements BaseTest {

    private final WebDriverSetup driverSetup = new WebDriverSetup();

    public void setWebdriverSystemProperty() {
        System.setProperty("webdriver.chrome.driver", driverSetup.getChromeDriverPath());
        System.setProperty("webdriver.gecko.driver", driverSetup.getFirefoxDriverPath());
    }
}
