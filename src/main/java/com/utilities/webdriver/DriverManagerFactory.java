package com.utilities.webdriver;

import com.utilities.property.SystemProperties;

public class DriverManagerFactory {
    private static final SystemProperties systemProperties = new SystemProperties();

    public static DriverManager getManager(DriverType type) {
        systemProperties.setWebdriverSystemProperty();
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
