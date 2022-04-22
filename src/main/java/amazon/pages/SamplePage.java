package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamplePage {

	private WebDriver driver;

	private By LOGO = By.id("nav-logo-sprites");
	private By INPUT_FIELD = By.xpath("//input[@id='twotabsearchtextbox']");
	private By PRODUCT_NAME = By.xpath("//span[text()='Apple iPhone 13 (128GB) - Green']/parent::span");
	private By SEARCH_ICON = By.xpath("//input[@type='submit']");
	private By ADD_TO_CART = By.cssSelector("#add-to-cart-button");
	private By GO_TO_CART = By.cssSelector("a[class='a-button-text']");
	private By PROCEED_TO_BUY = By.cssSelector("input[value='Proceed to checkout']");

	public SamplePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();

	}

	public void searchItem(String itemName) {
		driver.findElement(INPUT_FIELD).sendKeys(itemName);
	}

	public void clickOnSearch() {
		driver.findElement(SEARCH_ICON).click();
	}

	public boolean checkLogoIsPresent() {
		return driver.findElement(LOGO).isDisplayed();
	}

	public void clickOnProduct() {
		driver.findElement(PRODUCT_NAME).click();

	}

	public void clickOnAddToCart() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(ADD_TO_CART).click();

	}

	public void clickOnGoToCart() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(GO_TO_CART).click();

	}

	public void clickOnProceedToBuy() throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(PROCEED_TO_BUY).click();

	}

}
