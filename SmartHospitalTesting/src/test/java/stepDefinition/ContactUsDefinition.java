package stepDefinition;

import actions.ContactUsAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsDefinition {

    ContactUsAction action = new ContactUsAction();

    @When("the user enters contact details from csv file")
    public void enter_contact_details_from_csv_file() throws Exception {

        action.enterDetailsFromCSV();
    }

    @When("the user clicks submit button in the contact us")
    public void click_submit_button_in_contact_us() {

        action.submit();
    }

    @Then("the contact us should be submitted successfully")
    public void verify_contact_us_successfully() {

        action.verifySuccess();
    }
}