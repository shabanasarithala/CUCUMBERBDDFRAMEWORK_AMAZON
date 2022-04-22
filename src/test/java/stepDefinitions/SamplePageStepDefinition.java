package stepDefinitions;

import org.junit.Assert;

import amazon.factory.DriverFactory;
import amazon.pages.SamplePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamplePageStepDefinition {
	private static String title;
	private static String itemName;
	private SamplePage samplepage = new SamplePage(DriverFactory.getDriver());

	@Given("user is in the landing page")
	public void user_is_in_landing_page() {
		DriverFactory.getDriver().get("https://www.amazon.in/");
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() throws InterruptedException {
		 title = samplepage.getPageTitle();
		System.out.println("landing page title is: " + title);
	}

	@Then("the title of page should be {string}")
	public void the_title_of_page_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("amazon logo should be there")
	public void amazon_logo_should_be_there() {
		Assert.assertTrue(samplepage.checkLogoIsPresent());

	}

	@Then("Having search field on the amazon")
	public void Having_search_field_on_the_amazon() {

	}

	@When("I search for the product {string}")
	public void I_search_for_the_product(String itemName) {
		samplepage.searchItem(itemName);
		samplepage.clickOnSearch();
	}

	@Then("Product should be displayed {string}")
	public void Product_should_be_displayed(String itemName) {
	}
	
	@When("click on one of the product")
	public void click_on_one_of_the_product() {
		samplepage.clickOnProduct();
 	}

	@When("clicked on add to cart")
	public void clicked_on_add_to_cart() throws InterruptedException {
		samplepage.clickOnAddToCart();
 	}

	@When("clicked on go to cart")
	public void clicked_on_go_to_cart() throws InterruptedException {
		samplepage.clickOnGoToCart();
 	}

	@Then("clicked on proceed to buy")
	public void clicked_on_proceed_to_buy() throws InterruptedException {
		samplepage.clickOnProceedToBuy();
 	}


}
