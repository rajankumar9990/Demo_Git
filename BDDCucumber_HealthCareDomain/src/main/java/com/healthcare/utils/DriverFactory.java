package com.healthcare.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
        	 // Suppress ChromeDriver and Selenium logs 
        	//connection reset  warning getting in HealthyAgingForm
            System.setProperty("webdriver.chrome.silentOutput", "true");
            java.util.logging.Logger.getLogger("org.openqa.selenium")
                    .setLevel(java.util.logging.Level.OFF);
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Only Chrome is supported right now.");
        }

        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
