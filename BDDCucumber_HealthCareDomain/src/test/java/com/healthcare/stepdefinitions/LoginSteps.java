package com.healthcare.stepdefinitions;

import com.healthcare.pages.LoginPage;
import com.healthcare.utils.ConfigReader;
import com.healthcare.utils.DriverFactory;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

public class LoginSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.get(ConfigReader.getProperty("loginUrl"));
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException {

		String username = ConfigReader.getProperty("username");

		String password = ConfigReader.getProperty("password");
		Thread.sleep(2000);
		loginPage.enterUsername(username);
		Thread.sleep(2000);
		loginPage.enterPassword(password);

	}

	@And("clicks login button")

	public void clicks_login_button() throws InterruptedException {
		Thread.sleep(10000);
		loginPage.clickLogin();
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		assert loginPage.isLoginSuccessful();
	}

	@Then("user close the browser")
	public void user_close_rhe_browser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
