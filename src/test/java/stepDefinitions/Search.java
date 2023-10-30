package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Search {

	WebDriver driver;
	HomePage homepage;
	SearchPage searchpage;
	
	@Given("the user is on the search page")
	public void the_user_is_on_the_search_page() {
	    driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
	}

	@When("the user enters the valid product name {string}")
	public void the_user_enters_the_valid_product_name(String string) {
		
		homepage.enterProductName(string);
	}

	@When("the user clicks the Search button")
	public void the_user_clicks_the_search_button() {
	    searchpage = homepage.clickonSearch();
	}

	@Then("the search results for product should be displayed")
	public void the_search_results_for_product_should_be_displayed() {

		Assert.assertTrue(searchpage.isProductDisplayed());
		
	}

	@When("the user enters an invalid product name {string}")
	public void the_user_enters_an_invalid_product_name(String string) {
	    
		homepage.enterProductName(string);
	}

	@Then("the search results should show {string}")
	public void the_search_results_should_show(String string) {
	    
		Assert.assertEquals(searchpage.getNoProductText(), string);
	}

	@When("the user leaves the search field empty")
	public void the_user_leaves_the_search_field_empty() {
		homepage.enterProductName("");
		//Assert.fail();
	}


}
