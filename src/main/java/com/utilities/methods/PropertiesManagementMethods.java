package com.utilities.methods;

import com.utilities.environment.BaseTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;

public class PropertiesManagementMethods implements BaseTest {

    private static final String propertiesFilePath = "src/main/resources/config.properties";
    private static final String seleniumPropertiesFilePath = "src/main/resources/selenium.properties";

    private static String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }

    public String loadPropertyFile(String propName, String filePath) {
        Properties prop = new Properties();
        InputStream is;
        try {
            is = new FileInputStream(filePath);
            prop.load(is);
            String property = prop.getProperty(propName);
            is.close();
            return property;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getProperty(String propName) {
        return loadPropertyFile(propName, propertiesFilePath);
    }

    public String getSeleniumProperty(String propName) {
        return loadPropertyFile(propName, seleniumPropertiesFilePath);
    }

    public boolean isWindows() {
        String OS = getOS();
        return (OS.contains("win"));
    }

    public boolean isMac() {
        String OS = getOS();
        return (OS.contains("mac"));
    }
}
