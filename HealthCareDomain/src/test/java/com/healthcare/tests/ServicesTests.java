package com.healthcare.tests;

import com.healthcare.pages.ServicesPage;
import com.healthcare.utils.ConfigReader;
import com.healthcare.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class ServicesTests {
    private WebDriver driver;
    private ServicesPage servicesPage;

    @BeforeClass
    public void setup() {
        DriverFactory.initDriver(ConfigReader.get("browser"));
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("baseUrl"));
        servicesPage = new ServicesPage();
    }

    @Test
    public void verifyServices() throws InterruptedException {
        // Get all links under Services dropdown
        servicesPage.openServicesDropdown();
        List<WebElement> links = servicesPage.getAllServiceLinks();

        // Visit each link one by one in same tab
        for (WebElement link : links) {
            String serviceName = link.getText().trim();

            link.click(); // opens in same tab
            Thread.sleep(3000); // wait for page to load

            System.out.println("Verified Service Page: " + serviceName + " | Title: " + driver.getTitle());

            // Navigate back to main page
            driver.navigate().back();
            Thread.sleep(2000);
            servicesPage.openServicesDropdown();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
