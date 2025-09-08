package com.healthcare.tests;

import com.healthcare.pages.ProgramsPage;
import com.healthcare.utils.ConfigReader;
import com.healthcare.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class ProgramsTests {
    private WebDriver driver;
    private ProgramsPage programsPage;

    @BeforeClass
    public void setup() {
        DriverFactory.initDriver(ConfigReader.get("browser"));
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("baseUrl"));
        programsPage = new ProgramsPage();
    }

    @Test
    public void verifyProgramsSequentiallyInSameTab() throws InterruptedException {
        // Get all links under Programs dropdown
        programsPage.openProgramsDropdown();
        List<WebElement> links = programsPage.getAllProgramLinks();

        // Visit each link one by one in the same tab
        for (WebElement link : links) {
            String programName = link.getText().trim();

            link.click(); // opens in same tab
            Thread.sleep(3000); // wait for page to load

            System.out.println("Verified Program Page: " + programName + " | Title: " + driver.getTitle());

            // Navigate back to reopen dropdown before next click
            driver.navigate().back();
            Thread.sleep(2000);
            programsPage.openProgramsDropdown();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
