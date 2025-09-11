package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath = "//div[@class=\"caption\"]//a")
	private WebElement productName;
	
	public String validProductName() {
		return elementUtils.getTextFromElement(productName, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath = "//div[@id=\"content\"]//p[2]")
	private WebElement invalidProductMessage;
	
	public String invalidProductWarningMessage() {
		return elementUtils.getTextFromElement(invalidProductMessage, CommonUtils.EXPLICIT_WAIT_TIME);
	}

}
