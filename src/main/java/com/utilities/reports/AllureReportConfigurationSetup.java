package com.utilities.reports;

import com.utilities.logger.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AllureReportConfigurationSetup {

    // folders params
    private static final String allureReportResultsFolder = "allure-results";
    private static final String allureReportPropertiesFileName = "environment.properties";
    private static final String allureReportPropertiesFilePath = allureReportResultsFolder + "/" + allureReportPropertiesFileName;
    private static final String allureReportScreenshotsFolder = "Screenshots";

    private static final File allureReportPropertiesFile = new File(allureReportPropertiesFilePath);

    public static void prepareAllureResultsFolder() {

        // step 1. delete allure results folder
        File allureResultsFolder = new File(allureReportResultsFolder);
        deleteAllureResultsFolder(allureResultsFolder);

        // step 2. create allure results folder
        createAllureResultsFolder(allureResultsFolder);

        // step 3. delete allure screenshots folder
        File allureSnapshotsFolder = new File(allureReportScreenshotsFolder);
        deleteAllureResultsFolder(allureSnapshotsFolder);

        // step 4. create allure screenshots folder
        createAllureResultsFolder(allureSnapshotsFolder);

        // step 5. create and populate allure report properties file
        writeToAllureConfigFile("ENVIRONMENT", "");
    }

    // UTILS
    private static void writeToAllureConfigFile(String propName, String propValue) {

        try {
            if (allureReportPropertiesFile.createNewFile()) {
                Log.INFO("File: " + allureReportPropertiesFilePath + " is created");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // load config file
        Properties props = null;
        try {
            FileInputStream in = new FileInputStream(allureReportPropertiesFilePath);
            props = new Properties();
            props.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // edit config file
        try {
            FileOutputStream out = new FileOutputStream(allureReportPropertiesFilePath);
            props.setProperty(propName, propValue);
            props.store(out, null);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteAllureResultsFolder(File allureResultsFolder) {

        if (allureResultsFolder.isDirectory()) {

            // directory is empty, then delete it
            if (allureResultsFolder.list().length == 0) {

                allureResultsFolder.delete();
                Log.INFO("Folder is deleted : " + allureResultsFolder.getAbsolutePath());

            } else {

                // list all the directory contents
                String files[] = allureResultsFolder.list();

                for (String temp : files) {
                    // construct the file structure
                    File fileDelete = new File(allureResultsFolder, temp);

                    // recursive delete
                    deleteAllureResultsFolder(fileDelete);
                }

                // check the directory again, if empty then delete it
                if (allureResultsFolder.list().length == 0) {
                    allureResultsFolder.delete();
                    Log.INFO("Directory is deleted : " + allureResultsFolder.getAbsolutePath());
                }
            }

        } else {
            // if file, then delete it
            allureResultsFolder.delete();
            Log.INFO("File is deleted : " + allureResultsFolder.getAbsolutePath());
        }
    }

    private static void createAllureResultsFolder(File allureResultsFolder) {

        if (!allureResultsFolder.exists()) {
            if (allureResultsFolder.mkdir()) {
                Log.INFO("Directory is created!");
            } else {
                Log.ERROR("Failed to create directory!");
            }
        }
    }

    public static void createAllureHistoryFolder(File allureHistoryFolder) {

        if (!allureHistoryFolder.exists()) {
            if (allureHistoryFolder.mkdir()) {
                Log.INFO("Directory is created!");
            } else {
                Log.ERROR("Failed to create directory!");
            }
        }
    }
}
