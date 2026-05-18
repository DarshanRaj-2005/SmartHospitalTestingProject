package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import actions.Complaintaction;
public class Complaintdefinition {
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
	   Complaintaction.launchPage();
	}

	@When("the user clicks on complaint")
	public void the_user_clicks_on_complaint() {
		 Complaintaction.clickComplaint();
	}

	@When("the user enters complaint details")
	public void the_user_enters_complaint_details() throws Exception {
		 Complaintaction.fillDetails("sheet3");
	}

	@When("the user clicks submit button")
	public void the_user_clicks_submit_button() {
	   Complaintaction.submit();
	}

	@Then("the complaint should be submitted successfully")
	public void the_complaint_should_be_submitted_successfully() {
	   Complaintaction.verifySuccess();
	}

	@When("the user submits the form without entering details")
	public void the_user_submits_the_form_without_entering_details() {
	    Complaintaction.submit();  // directly submit empty form
	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
	    Complaintaction.verifyError();
	}


}
