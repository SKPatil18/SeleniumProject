package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//input[@id=\"input-firstname\"]")
	private WebElement firstName;
	
	public void firstNameField(String fname) {
		elementUtils.typeTextInotElement(firstName, fname, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@id=\"input-lastname\"]")
	private WebElement lastName;
	
	public void lastNameField(String lname) {
		elementUtils.typeTextInotElement(lastName, lname, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@id=\"input-email\"]")
	private WebElement emailName;
	
	public void emailField(String email) {
		elementUtils.typeTextInotElement(emailName, email, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@id=\"input-telephone\"]")
	private WebElement telephone;
	
	public void telephoneField(String tele) {
		elementUtils.typeTextInotElement(telephone, tele, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@id=\"input-password\"]")
	private WebElement password;
	
	public void passwordField(String pass) {
		elementUtils.typeTextInotElement(password, pass, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@id=\"input-confirm\"]")
	private WebElement confirmPassword;
	
	public void confirmPasswordField(String pass) {
		elementUtils.typeTextInotElement(confirmPassword, pass, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement checkBox;
	
	public void checkTheCheckBox() {
		elementUtils.clickOnElement(checkBox, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement submit;
	
	public void submitButton() {
		elementUtils.clickOnElement(submit, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//div[@id=\"content\"]/h1")
	private WebElement accCreatedText;
	
	public String accountCreatedtext() {
		return elementUtils.getTextFromElement(accCreatedText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//input[@value=1][@name=\"newsletter\"]")
	private WebElement newsLetter;
	
	public void checkNewsLetter() {
		elementUtils.clickOnElement(newsLetter, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//div[contains(@class,\"alert-dismissible\")]")
	private WebElement duplicateEmailWarning;
	
	public String duplicateEmailWarningtext() {
		return elementUtils.getTextFromElement(duplicateEmailWarning, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	
	
	

}
