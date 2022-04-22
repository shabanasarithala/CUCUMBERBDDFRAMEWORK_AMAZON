package amazonhooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import amazon.factory.DriverFactory;
import amazon.utils.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private DriverFactory driverfactory;
	private WebDriver driver;
	private configReader configreader;
	Properties properties;

	@Before(order = 0)
	public void getProperty() {
		configreader = new configReader();
		properties = configreader.initializeProperties();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = properties.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeDriver(browserName);
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);

		}

	}
}
