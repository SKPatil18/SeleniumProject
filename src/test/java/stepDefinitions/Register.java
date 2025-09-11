package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.RegisterPage;

public class Register {
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();

//		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
//		driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();

	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		registerPage = new RegisterPage(driver);
		registerPage.firstNameField(data.get("firstName"));
		registerPage.lastNameField(data.get("lastName"));
		registerPage.emailField(getEmailWithTimeStamp());
		registerPage.telephoneField(data.get("number"));
		registerPage.passwordField(data.get("password"));
		registerPage.confirmPasswordField(data.get("confirmPassword"));
//		driver.findElement(By.xpath("")).sendKeys(data.get("firstName"));
//		driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys(data.get("lastName"));
//		driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(getEmailWithTimeStamp());
//		driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys(data.get("number"));
//		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(data.get("password"));
//		driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys(data.get("confirmPassword"));
	}
	
	@When("User enters the below fields with duplicate email")
	public void user_enters_the_below_fields_with_duplicate_email(DataTable dataTable) {
		registerPage = new RegisterPage(driver);
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		registerPage.firstNameField(data.get("firstName"));
		registerPage.lastNameField(data.get("lastName"));
		registerPage.emailField(data.get("email"));
		registerPage.telephoneField(data.get("number"));
		registerPage.passwordField(data.get("password"));
		registerPage.confirmPasswordField(data.get("confirmPassword"));
//		driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys(data.get("firstName"));
//		driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys(data.get("lastName"));
//		driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(data.get("email"));
//		driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys(data.get("number"));
//		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(data.get("password"));
//		driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys(data.get("confirmPassword"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.checkTheCheckBox();
//		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	
	}

	@When("User clicks on create button")
	public void user_clicks_on_create_button() {
		registerPage.submitButton();
//		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		String actualText = registerPage.accountCreatedtext();
		Assert.assertEquals(actualText, "Your Account Has Been Created!");
	}

	@When("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.checkNewsLetter();
//		driver.findElement(By.xpath("//input[@value=1][@name=\"newsletter\"]")).click();
	
	}

	@When("User do not enter any fields")
	public void user_do_not_enter_any_fields() {
		registerPage.firstNameField("");
		registerPage.lastNameField("");
		registerPage.emailField("");
		registerPage.telephoneField("");
		registerPage.passwordField("");
		registerPage.confirmPasswordField("");
//		driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys("");
//		driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys("");
//		driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys("");
//		driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys("");
//		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys("");
//		driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys("");

	}

	@When("User clicks on create account")
	public void user_clicks_on_create_account() {
		registerPage.submitButton();
//		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();


	}

	@Then("User should get a warning message")
	public void user_should_get_a_warning_message() {
		String warningtext = registerPage.duplicateEmailWarningtext();
//		String warningtext = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]")).getText();
		Assert.assertEquals(warningtext, "Warning: E-Mail Address is already registered!");
	
	}
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "tutorial"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}


}
