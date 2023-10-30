package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.opencart.pages.AccountSuccessPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegistrationPage;
import com.opencart.utils.Utilities;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Register {
	
	WebDriver driver;
	HomePage homepage;
	RegistrationPage registerpage;
	AccountSuccessPage accsucpage;

	@Given("the user is on the registration page")
	public void the_user_is_on_the_registration_page() {
	    driver = DriverFactory.getDriver();
	    homepage = new HomePage(driver);
	    registerpage = homepage.navigateToRegisterPage();
	}

	@When("the user enters the following information:")
	public void the_user_enters_the_following_information(io.cucumber.datatable.DataTable dataTable) {
	   Map<String, String> mapData = dataTable.asMap();
	   registerpage.enterFirstname(mapData.get("first-name"));
	   registerpage.enterLastname(mapData.get("last-name"));
	   //registerpage.enterEmail(mapData.get("email"));
	   registerpage.enterEmail(Utilities.generateEmail());
	   registerpage.eneterMobileNo(mapData.get("mobile"));
	   registerpage.eneterPass(mapData.get("password"));
	   registerpage.confirmPass(mapData.get("password"));
	   registerpage.clickYes();
	   registerpage.clickOnAgree();
	}
	
	@When("the user enters the mandatory fields")
	public void the_user_enters_the_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
	   Map<String, String> mapData = dataTable.asMap();
	   registerpage.enterFirstname(mapData.get("first-name"));
	   registerpage.enterLastname(mapData.get("last-name"));
	   //registerpage.enterEmail(mapData.get("email"));
	   registerpage.enterEmail(Utilities.generateEmail());
	   registerpage.eneterMobileNo(mapData.get("mobile"));
	   registerpage.eneterPass(mapData.get("password"));
	   registerpage.confirmPass(mapData.get("password"));
	   registerpage.clickOnAgree();
	}
	
	@When("the user enters the information with existing email:")
	public void the_user_enters_the_information_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
	   Map<String, String> mapData = dataTable.asMap();
	   registerpage.enterFirstname(mapData.get("first-name"));
	   registerpage.enterLastname(mapData.get("last-name"));
	   registerpage.enterEmail(mapData.get("email"));
	   //registerpage.enterEmail(Utilities.generateEmail());
	   registerpage.eneterMobileNo(mapData.get("mobile"));
	   registerpage.eneterPass(mapData.get("password"));
	   registerpage.confirmPass(mapData.get("password"));
	   registerpage.clickOnAgree();
	}

	@And("the user clicks the Register button")
	public void the_user_clicks_the_button() {
		
		accsucpage = registerpage.clickOnSubmit();
	}

	@Then("the user should be successfully registered")
	public void the_user_should_be_successfully_registered() {
	 
		//System.out.println(accsucpage.getAccountSuccessText());
		Assert.assertEquals(accsucpage.getAccountSuccessText(), "Your Account Has Been Created!");
	}

	
	  
	@Then("the registration should fail with an error {string} message")
	public void the_registration_should_fail_with_an_error_message(String string) {
		
		Assert.assertEquals(registerpage.getWarningMessageText(),string);
	}


	@Then("the registration should fail with an error messages")
	public void the_registration_should_fail_with_an_error_message() {
	    
		Assert.assertTrue(registerpage.getPrivacyWarningText().contains("Warning: You must agree to the Privacy Policy!"));
		
		Assert.assertTrue(registerpage.getFirstnameWarningText().contains("First Name must be between 1 and 32 characters!"));

		Assert.assertTrue(registerpage.getLastnameWarningText().contains("Last Name must be between 1 and 32 characters!"));

		Assert.assertTrue(registerpage.getemailWarningText().contains("E-Mail Address does not appear to be valid!"));

		Assert.assertTrue(registerpage.getMobileWarningText().contains("Telephone must be between 3 and 32 characters!"));

		Assert.assertTrue(registerpage.getPasswordWarningText().contains("Password must be between 4 and 20 characters!"));
	}
}
