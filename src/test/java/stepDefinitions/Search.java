package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	HomePage homePage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	

	}

	@When("User enters valid product {string} into the search field")
	public void user_enters_valid_product_into_the_search_field(String product) {
		homePage.enterProductIntosearchField(product);

	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		homePage.clickOnSearch();

	}

	@Then("User should get a valid product displayed on the results")
	public void user_should_get_a_valid_product_displayed_on_the_results() {
		SearchPage searchPage = new SearchPage(driver);
		String productName = searchPage.validProductName();
		Assert.assertEquals(productName, "HP LP3065");

	}



	@When("User enters invalid product {string} into the search box field")
	public void user_enters_invalid_product_into_the_search_box_field(String product) {
		homePage = new HomePage(driver);
		homePage.enterProductIntosearchField(product);

	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		SearchPage searchPage = new SearchPage(driver);
		String text =searchPage.invalidProductWarningMessage();
		Assert.assertEquals(text, "There is no product that matches the search criteria.");
	}

	@When("User do not enter any product into search box")
	public void user_do_not_enter_any_product_into_search_box() {
		homePage = new HomePage(driver);
		homePage.enterProductIntosearchField("");


	}

}
