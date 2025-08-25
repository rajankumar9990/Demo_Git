package com.selenium_testng.day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ECommerce1 {
    WebDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        System.out.println("Launching browser.....");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    // multiple login details
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "standard_user", "secret_sauce", true },   // valid
            { "visual_user", "abcdef", false }           // invalid
        };
    }

    // Test1 - Login Validation
    @Test(priority = 1, dataProvider = "loginData")
    public void loginPage(String username, String pass, boolean expectedResult) throws Exception {
        driver.get("https://www.saucedemo.com/"); // reset before each run
        Thread.sleep(1000);

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pass);
        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        boolean loginSuccess;
        try {
            WebElement productsTitle = driver.findElement(By.className("title"));
            loginSuccess = productsTitle.isDisplayed();
            if (loginSuccess) {
                driver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("logout_sidebar_link")).click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            loginSuccess = false;
        }
        Assert.assertEquals(loginSuccess, expectedResult, "Login Validation Failed!");
    }

    // Test2 - Search product
    @Test(priority = 2)
    public void searchProduct() throws Exception {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        WebElement firstProduct = driver.findElement(By.className("inventory_item"));
        Assert.assertTrue(firstProduct.isDisplayed(), "Product list not visible!");
    }

    // Test3 - Add items into cart
    @Test(priority = 3)
    public void addItemsCart() throws Exception {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        int itemCart = driver.findElements(By.className("cart_item")).size();
        Assert.assertEquals(itemCart, 2, "Cart count is not same.");
    }

    @AfterClass
    public void teardown() throws Exception {
        System.out.println("Closing browser...");
        driver.quit();
    }
}
