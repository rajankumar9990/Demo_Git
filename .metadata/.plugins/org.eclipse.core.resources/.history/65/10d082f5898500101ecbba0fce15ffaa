package com.healthcare.pages;

import com.healthcare.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
