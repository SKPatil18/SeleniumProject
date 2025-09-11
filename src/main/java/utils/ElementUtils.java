package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webElement.click();
		
	}
	
	public void typeTextInotElement(WebElement element,String text, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);;
		
	}	
	
	public void selectOptionInDropDown(WebElement element, String dropDownOption, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		Select select = new Select(element);
		select.deselectByVisibleText(dropDownOption);
	}
	
	public void acceptalert(long duration) {
		Alert alert = waitForAlert(duration);
		alert.accept();
	}
	
	public void dismissAlert(long duration) {
		Alert alert = waitForAlert(duration);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long duration) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			alert  = wait.until(ExpectedConditions.alertIsPresent());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
		
	}
	
	public void mouseHoverAndClickOnElement(WebElement element, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public void javaScriptClick(WebElement element, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptType(WebElement element, long duration,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+text+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element, long duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		return webElement.getText();	
		
	}
	
	public boolean displayStatusOfElement(WebElement element, long duration) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
			return webElement.isDisplayed();
		}
		catch (Exception e) {
			return false;
		}
		
	}

}
