package com.healthcare.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getReporter() {
        if (extent == null) {
            // Set the location and name of the report file
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report.html");
            
            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Optional: add system info or configuration here
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Automation Team");
        }
        return extent;
    }
}
