package com.utilities.environment;

import com.utilities.methods.InitSystemProperties;

public class DriverManagerFactory {
    private static final InitSystemProperties systemProperties = new InitSystemProperties();

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
