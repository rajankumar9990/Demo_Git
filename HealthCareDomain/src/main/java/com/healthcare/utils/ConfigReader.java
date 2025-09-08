package com.healthcare.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    // Load config once
    public static void loadConfig() {
        if (props.isEmpty()) {
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                props.load(fis);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load config.properties file!");
            }
        }
    }

    public static String get(String key) {
        if (props.isEmpty()) {
            loadConfig(); // ensure it's loaded
        }
        return props.getProperty(key);
    }
}
