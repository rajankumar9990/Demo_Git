package com.selenium_testng.day28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Test1 {
	WebDriver driver;
	// Read parameters from testng.xml (or command line)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void setup(String browser,String url) {
        System.out.println("Browser = " + browser);
        System.out.println("URL = " + url);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.get(url);
    }
    
    @Test
    public void checkTitle() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public void exit() {
        driver.quit();
    }

}
