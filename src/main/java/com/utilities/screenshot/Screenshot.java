package com.utilities.screenshot;

import com.utilities.logger.Log;
import com.utilities.selector.SelectElementByType;
import com.utilities.webdriver.BaseTest;
import com.utilities.webdriver.InitDriver;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot extends SelectElementByType implements BaseTest {
    private static Screenshot instance = null;
    private WebDriver driver = InitDriver.getInstance().getDriver();

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

    private Screenshot() {}

    public static Screenshot getInstance() {
        if (instance == null) {
            instance = new Screenshot();
        }
        return instance;
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
        if (scenario.isFailed()) {
            try {
                String screenshotName = getInstance().takeScreenShot();
                Log.INFO("Scenario: " + scenario.getName() + ", failed. Then taking snapshot - " + screenshotName);
                byte[] screenshot = embedScreenshotInReport();
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
