package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.opencart.pages.AccountPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.utils.Utilities;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	  
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		loginpage = homepage.navigateToLoginPage();
		
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
	  
		accountpage = loginpage.clickOnLogin();
	}

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
		
		Assert.assertTrue(accountpage.verifyEditAccountInfo());
			   
	}

	@When("the user enters a invalid email into email field")
	public void the_user_enters_a_invalid_email_into_email_field() {
	   loginpage.enterEmail(Utilities.generateEmail());
	}

	@When("the user enters a invalid password {string} into password field")
	public void the_user_enters_a_invalid_password_into_password_field(String pass) {
	
		loginpage.enterPassword(pass);
	}

	@Then("the user should see an warning message {string}")
	public void the_user_should_see_an_warning_message(String string) {
	  
		Assert.assertEquals(loginpage.getWarningMessageText(),string);
		
	}

	@When("the user leaves both email and password fields empty")
	public void the_user_leaves_both_email_and_password_fields_empty() {
		loginpage.enterEmail("");
		loginpage.enterPassword("");
		
	}
	
	@When("^the user enters a valid email (.+) into email field$")
	public void the_user_enters_a_valid_email_into_email_field(String emailText) {
	
		loginpage.enterEmail(emailText);
	}

	@And("^the user enters a valid password (.+) into password field$")
	public void the_user_enters_a_valid_password_into_password_field(String string) {
	  
		loginpage.enterPassword(string);
	}
}

