package com.utilities.webdriver;

import static com.utilities.webdriver.DriverType.CHROME;

import com.utilities.logger.Log;
import com.utilities.selector.SelectElementByType;
import org.openqa.selenium.WebDriver;

public class InitDriver extends SelectElementByType implements BaseTest {
    private final DriverManager driverManager = DriverManagerFactory.getManager(CHROME);
    private static InitDriver instance = null;
    private WebDriver driver;

    private InitDriver() {}

    public static InitDriver getInstance() {
        if (instance == null)
            instance = new InitDriver();
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = driverManager.getDriver();
            this.maximizeBrowser();
        }
        return driver;
    }

    private void maximizeBrowser() {
        Log.INFO("Maximize browser");
        driver.manage().window().maximize();
    }
}
