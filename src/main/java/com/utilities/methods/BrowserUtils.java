package com.utilities.methods;

import static com.utilities.environment.DriverType.CHROME;

import com.utilities.environment.BaseTest;
import com.utilities.environment.DriverManager;
import com.utilities.environment.DriverManagerFactory;
import com.utilities.logger.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.ClassRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BrowserUtils extends SelectElementByType implements BaseTest {
    private final DriverManager driverManager = DriverManagerFactory.getManager(CHROME);
    private static SecureRandom random = new SecureRandom();
    private static BrowserUtils instance = null;
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private WebDriver driver;

    @ClassRule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        byte[] makeScreenshotOnFailure() {
            Log.INFO("Taking screenshot");
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    // private constructor restricted to this class itself
    private BrowserUtils() {}

    // static method to create instance of Singleton class
    public static BrowserUtils getInstance() {
        if (instance == null)
            instance = new BrowserUtils();

        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = driverManager.getDriver();
            this.maximizeBrowser();
        }
        return driver;
    }

    /**
     * Method to maximize browser
     */
    private void maximizeBrowser() {
        Log.INFO("Maximize browser");
        driver.manage().window().maximize();
    }

    private String getSnapshotFolderPath() {
        File currentDirFile = new File("Screenshots");

        return currentDirFile.getAbsolutePath();
    }

    /**
     * Method to take screen shot and save in ./Screenshots folder
     *
     * @return
     */
    private String takeScreenShot() throws IOException {
        Log.INFO("Taking snapshot");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        String snapshotFileName = "screenshot" + dateFormat.format(cal.getTime()) + ".png";
        String pathToSnapshot = getSnapshotFolderPath() + "/" + snapshotFileName;
        FileUtils.copyFile(scrFile, new File(pathToSnapshot));
        return snapshotFileName;
    }

    /**
     * Method to take screen shot to allure report
     *
     * @returns screen shot bytes
     */
    private byte[] embedScreenshotInReport() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void tearDown(Scenario scenario) {
        Log.INFO("Scenario: " + scenario + ", failed taking snapshot");
        if (scenario.isFailed()) {
            // Take a screenshot if for failed scenario
            byte[] screenshot = embedScreenshotInReport();
            scenario.embed(screenshot, "image/png");
        }
    }

    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
