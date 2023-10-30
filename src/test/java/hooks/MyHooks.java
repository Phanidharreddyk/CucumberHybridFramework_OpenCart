package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.ConfigLoader;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	WebDriver driver;
	
	@Before
	public void setup() throws IOException {
		
		Properties prop = ConfigLoader.initializeProperties();
		
		driver = DriverFactory.intializeDriver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenorioName = scenario.getName().replace(" ","_");
		if(scenario.isFailed()) {
			
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenorioName);
		}
		driver.quit();
	}
}
