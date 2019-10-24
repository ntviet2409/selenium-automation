package com.utilities.methods;

import com.utilities.environment.BaseTest;
import com.utilities.environment.WebDriverSetup;

public class InitSystemProperties implements BaseTest {

    private final WebDriverSetup chromeDriverSetup = new WebDriverSetup();

    public void setWebdriverSystemProperty() {
        System.setProperty("webdriver.chrome.driver", chromeDriverSetup.getChromeDriverPath());
        System.setProperty("webdriver.gecko.driver", chromeDriverSetup.getFirefoxDriverPath());
    }
}
