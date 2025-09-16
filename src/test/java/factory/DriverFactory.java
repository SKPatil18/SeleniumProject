package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	static WebDriver driver = null;
	

	
	public static WebDriver initilizeBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
<<<<<<< HEAD

=======
			
>>>>>>> 51367e4 (Updated)
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();	
		}
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}



 