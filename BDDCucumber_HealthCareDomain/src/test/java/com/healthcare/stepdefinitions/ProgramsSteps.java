package com.healthcare.stepdefinitions;

import com.healthcare.pages.ProgramsPage;
import com.healthcare.utils.ConfigReader;
import com.healthcare.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProgramsSteps {
    private WebDriver driver;
    private ProgramsPage programsPage;

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        programsPage = new ProgramsPage();
    }

    @When("the user navigates through each program")
    public void the_user_navigates_through_each_program() {
        List<WebElement> links = programsPage.getAllProgramLinks();

        for (int i = 0; i < links.size(); i++) {
            // Open dropdown fresh each time
            programsPage.openProgramsDropdown();

            // Re-fetch links (avoid stale element)
            links = programsPage.getAllProgramLinks();

            WebElement link = links.get(i);
            System.out.println("Navigating to: " + link.getText());

            // Click program
            programsPage.clickProgramLink(link);

            // Navigate back home
            programsPage.goHome(ConfigReader.getProperty("baseUrl"));
        }
    }

    @Then("the user should be able to access all programs")
    public void the_user_should_be_able_to_access_all_programs() {
        System.out.println("Successfully navigated through all programs!");
    }
    @Then("user close browser")
    public void user_close_browser() {
        DriverFactory.quitDriver();  
    }

}
