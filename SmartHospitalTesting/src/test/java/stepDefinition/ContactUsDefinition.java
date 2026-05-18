package stepDefinition;

import actions.ContactUsAction;
import driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;




public class ContactUsDefinition {
	@When("the user clicks on contactUS")
	public void the_user_clicks_on_contact_us() {
		 ContactUsAction.clickContactUs();
	}

	@When("the user enters {string} {string} {string} {string}")
	public void the_user_enters(String name, String email, String subject, String description) {

	    ContactUsAction.enterdetails(name, email, subject, description);
	}
	
	@Then("the contatus  should be submitted successfully")
	public void the_contatus_should_be_submitted_successfully() {
		  ContactUsAction.check();
	}



   
    
}