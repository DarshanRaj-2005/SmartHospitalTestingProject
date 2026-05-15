package stepDefinition;

import org.testng.Assert;

import actions.PharmacyBillpageAction;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PharmacyBillPage;

public class PharmacyBillpageDefinition {

	PharmacyBillpageAction pharmacyAction = new PharmacyBillpageAction();

	@When("the user clicks the Pharmacy")
	public void the_user_clicks_the_pharmacy() {

		pharmacyAction.clickPharmacy();
	}

	@Then("it should move to the Pharmacy Bill page successfully")
	public void it_should_move_to_the_pharmacy_bill_page_successfully() {

		boolean isDisplayed = Driver.getDriver().findElement(PharmacyBillPage.pharmacyBillPageHeader).isDisplayed();

		Assert.assertTrue(isDisplayed);
		System.out.println("successfully moved to the pharmacy bill page");
	}

	@Given("the user is on the Pharmacy Bill page")
	public void the_user_is_on_the_pharmacy_bill_page() {
	    // Write code here that turns the phrase above into concrete actions
		pharmacyAction.clickPharmacy();
		public static String expectedURL="https://demo.smart-hospital.in/admin/pharmacy/bill";
		Boolean ispharmacybillpage=Driver.getDriver().findElement()
	}

	@When("the user clicks the show button")
	public void the_user_clicks_the_show_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the patient details should display")
	public void the_patient_details_should_display() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}