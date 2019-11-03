package com.web.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.web.api.models.TestConfig;

import java.io.File;
import java.io.IOException;

public final class YmlConfigReader {
    private static String filename;
    private static TestConfig config;

    static TestConfig getTestConfig(String env) {
        try {
            if (config != null && filename.contains(env)) {
                return config;
            } else {
                if (!env.isEmpty() && !env.equalsIgnoreCase("default")) {
                    filename = "application." + env + ".yml";
                } else {
                    filename = "application.yml";
                }

                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                config = new TestConfig();

                try {
                    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                    config = (TestConfig)mapper.readValue(new File(classLoader.getResource(filename).getFile()), TestConfig.class);
                } catch (IOException var3) {
                    throw (IOException)(new IOException("Test config file not found exception.")).initCause(var3);
                }

                return config;
            }
        } catch (Throwable var4) {
            var4.printStackTrace();
        }
        return config;
    }

    private YmlConfigReader() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
