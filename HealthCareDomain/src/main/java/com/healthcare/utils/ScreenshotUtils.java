package com.healthcare.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Add timestamp to avoid overwriting
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshot to "screenshots" folder inside project
            File destFile = new File("screenshots/" + fileName + "_" + timestamp + ".png");
            destFile.getParentFile().mkdirs(); // create folder if not exists

            Files.copy(srcFile.toPath(), destFile.toPath());

            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());

            return destFile.getAbsolutePath(); 
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
