package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[text()=\"My Account\"]")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	@FindBy(xpath = "//a[text()=\"Login\"]")
	private WebElement loginOption;
	
	public void clickOnlogin() {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//a[text()=\"Register\"]")
	private WebElement registerOption;
	
	public void clickOnRegister() {
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchField;
	
	public void enterProductIntosearchField(String productName) {
		elementUtils.typeTextInotElement(searchField, productName, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//span[@class=\"input-group-btn\"]/button")
	private WebElement clickOnEnter;
	
	public void clickOnSearch() {
		elementUtils.clickOnElement(clickOnEnter, CommonUtils.EXPLICIT_WAIT_TIME);
	}

}






