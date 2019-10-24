package com.utilities.environment;

import com.utilities.methods.PropertiesManagementMethods;

public class WebDriverSetup {
    private static final PropertiesManagementMethods props = new PropertiesManagementMethods();

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
