package com.web.configuration;

public class YmlReaders {

    private YmlReaders() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String getCurrentEnvironment() {
        return System.getProperty("ENV", "default");
    }

    public static String getBaseUrl(String env) {
        String url = YmlConfigReader.getTestConfig(env).getApi().getBaseUrl();
        if (url.endsWith("/")) {
            url = url.substring(url.length() - 1);
        }
        return url;
    }

    public static String getBaseUrl() {
        return getBaseUrl(getCurrentEnvironment());
    }

    public static String getToken(String env) {
        return YmlConfigReader.getTestConfig(env).getApi().getToken();
    }

    public static String getKey(String env) {
        return YmlConfigReader.getTestConfig(env).getApi().getKey();
    }
}
