package amazon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtil {

	WebDriver driver;

	public CommonUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement get_element(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void actionsClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = get_element(locator);
		action.click(element).build().perform();
	}

	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public String get_text(By locator) {
		return get_element(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		return get_element(locator).isDisplayed();
	}

	public void waitForElement(By by, int attempts) {
		int counter = 0;
		while (counter < attempts) {
			try {
				Thread.sleep(3000);
				driver.findElement(by).getText();
				break;
			} catch (Exception e) {
			}
			counter++;
		}
	}

	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
