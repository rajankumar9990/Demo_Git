package com.selenium_testng.day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Exclusion_Groups_amazon {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");
    }

    // This test is currently broken
    @Test(groups = {"broken"})
    public void testTitle() {
        System.out.println("Page Title: " + driver.getTitle());
    }

    // Functional test, part of checkintest group
    @Test(groups = {"checkintest"})
    public void testSearch() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("Search completed.");
    }

    // Test belongs to both checkintest and broken
    @Test(groups = {"checkintest", "broken"})
    public void testCart() {
        System.out.println("Cart functionality test placeholder");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
