package com.utilities.webdriver;

import com.utilities.property.PropertyLoader;

public class WebDriverSetup {
    private static final PropertyLoader props = new PropertyLoader();

    private static String getProperty(String propName) {
        return props.getSeleniumProperty(propName);
    }

    public String getChromeDriverPath() {
        String chromeDriverPath = getProperty("chromeDriverPath");
        if (props.isWindows()) {
            chromeDriverPath = chromeDriverPath + ".exe";
        }
        return chromeDriverPath;
    }

    public String getFirefoxDriverPath() {
        String firefoxDriverPath = getProperty("firefoxDriverPath");
        if (props.isWindows()) {
            firefoxDriverPath = firefoxDriverPath + ".exe";
        }
        return firefoxDriverPath;
    }
}
