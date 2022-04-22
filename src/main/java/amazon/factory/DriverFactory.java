package amazon.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> t1driver = new ThreadLocal<>();
	
	public WebDriver initializeDriver(String browser) {
		System.out.println("Browser value is : " +browser);
		if(browser.equals( "chrome")) {
			WebDriverManager.chromedriver().setup();
			t1driver.set( new ChromeDriver());
		}
		
		else if(browser.equals( "edge")) {
			WebDriverManager.edgedriver().setup();
			t1driver.set( new EdgeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return t1driver.get();
	}
}
