package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	private WebElement emailTextField;
	
	public void clickOnEmailTextField(String email) {
		elementUtils.typeTextInotElement(emailTextField, email, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement passwordTextField;
	
	public void clickOnPasswordTextfield(String password) {
		elementUtils.typeTextInotElement(passwordTextField, password, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement submitButton;
	
	public void clickOnSubmitButton() {
		elementUtils.clickOnElement(submitButton, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_TIME);
	}



}
