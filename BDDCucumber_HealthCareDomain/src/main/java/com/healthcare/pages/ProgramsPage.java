package com.healthcare.pages;

import com.healthcare.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProgramsPage {
    private WebDriver driver;

    private By programsDropdown = By.xpath("//*[@id='menu-item-264']/a/span[1]");
    private By programLinks = By.xpath("//*[@id='menu-item-264']//ul/li/a");

    public ProgramsPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void openProgramsDropdown() {
        driver.findElement(programsDropdown).click();
    }

    public List<WebElement> getAllProgramLinks() {
        return driver.findElements(programLinks);
    }

    public void clickProgramLink(WebElement link) {
    	sleep(2000);
        link.click();
    }

    public void goHome(String baseUrl) {
    	sleep(2000);
        driver.get(baseUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
