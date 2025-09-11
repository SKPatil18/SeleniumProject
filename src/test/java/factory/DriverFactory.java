package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	static WebDriver driver = null;
	

	
	public static WebDriver initilizeBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();	
		}
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
