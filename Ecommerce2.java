package com.selenium_testng.day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ecommerce2 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
    }

    @Test(groups = {"smoke"})
    public void testTitle() {
        System.out.println("Smoke Test - Title Check");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Test(groups = {"regression"})
    public void testSearch() {
        System.out.println("Regression Test - Search");

        // Enter product in Amazon search box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");

        // Click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println("Search completed.");
    }
    @Test(groups= {"sanity"})
    public void testSearch2() {
        System.out.println("Regression Test - Search");

        // Enter product in Amazon search box
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Keyboard");

        // Click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println("Search completed.");
    }
    @Test(groups = {"sanity", "regression"})
    public void testCart() {
        System.out.println("Sanity + Regression - Cart Test");
        System.out.println("Cart functionality test placeholder");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
