package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Ignore;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonUtils;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	
	@Before
	public void setup() throws IOException {
		Properties prop = ConfigReader.initializeProperties();
		driver = DriverFactory.initilizeBrowser(prop.getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replace(" ", "_");
		if(scenario.isFailed()) {
			byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src,"image/png", scenarioName);
		}
		driver.quit();
		
	}

}
