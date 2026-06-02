package stepDefinition;

import org.testng.Assert;

import actions.ContactUsAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsDefinition {


ContactUsAction contactUsAction =
        new ContactUsAction();

@When("click on the contactus button")
public void click_on_the_contactus_button() {

    contactUsAction.clickContactUsButton();
}

@When("the user enters valid contacts details {string} {string} {string} and {string}")
public void the_user_enters_valid_contacts_details_and(
        String name,
        String email,
        String subject,
        String description) {

    contactUsAction.enterContactDetails(
            name,
            email,
            subject,
            description);
}

@When("the user clicks submit button in the contact us")
public void the_user_clicks_submit_button_in_the_contact_us() {

    contactUsAction.clickSubmitButton();
}

@Then("the contact us should be submitted successfully")
public void the_contact_us_should_be_submitted_successfully() {

    Assert.assertTrue(
            contactUsAction.isContactSubmittedSuccessfully(),
            "Contact form submission failed");
}

@Then("the contact us submission should fail")
public void the_contact_us_submission_should_fail() {

    Assert.assertFalse(
            contactUsAction.isContactSubmittedSuccessfully(),
            "Contact form was submitted unexpectedly");
}


}
