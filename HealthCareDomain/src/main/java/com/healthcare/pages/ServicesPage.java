package com.healthcare.pages;

import com.healthcare.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ServicesPage {
    private WebDriver driver;

    private By servicesDropdown = By.xpath("//*[@id=\"menu-item-331\"]/a/span[1]");
    private By subMenuLinks = By.xpath("//*[@id=\"menu-item-331\"]//ul//li//a");

    public ServicesPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void openServicesDropdown() {
        driver.findElement(servicesDropdown).click();
    }

    public List<WebElement> getAllServiceLinks() {
        return driver.findElements(subMenuLinks);
    }
}
