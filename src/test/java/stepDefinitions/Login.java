package stepDefinitions;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnlogin();
		
		
	}
	

	@When("^User enters  valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String email) {
		loginPage = new LoginPage(driver);
		loginPage.clickOnEmailTextField(email);
		
	}
	
	
	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String password) {
		loginPage.clickOnPasswordTextfield(password);

	}
	
	
	
//	
//	@When("^User enters  valid email address (.+) into email field$")
//	public void user_enters_valid_email_address_into_email_field1(String email) {
//		loginPage = new LoginPage(driver);
//		loginPage.clickOnEmailTextField(email);
//		
//	}
//	
//	
//	@When("^User enters valid password (.+) into password field$")
//	public void user_enters_valid_password_into_password_field1(String password) {
//		loginPage.clickOnPasswordTextfield(password);
//
//	}
	

	
	@When("User clicks on login button")
	public void User_clicks_on_login_button() {
		loginPage.clickOnSubmitButton();
		
	}
	
	@Then("User should get successfully logged in")
	public void User_should_get_successfully_logged_in() {
		AccountPage accountPage = new AccountPage(driver);
		String actualText = accountPage.getAccSuccessText();
		Assert.assertEquals(actualText, "Edit your account information");
		
	}
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		loginPage = new LoginPage(driver);
		loginPage.clickOnEmailTextField(getEmailWithTimeStamp());


	}
	
	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String password) {
		loginPage.clickOnPasswordTextfield(password);

	}
	
	@Then("User should get a proper warning message")
	public void User_should_get_a_proper_warning_message() {
		String warningMessage = loginPage.getWarningMessageText();
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		loginPage = new LoginPage(driver);
		loginPage.clickOnEmailTextField("");


	}

	@When("User do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
		loginPage.clickOnPasswordTextfield("");


	}
	
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "tutorial"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}
	
	

}
