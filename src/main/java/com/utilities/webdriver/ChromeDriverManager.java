package com.utilities.webdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
