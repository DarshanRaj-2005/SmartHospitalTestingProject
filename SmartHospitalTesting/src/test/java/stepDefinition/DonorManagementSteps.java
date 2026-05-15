package stepDefinition;

import org.testng.Assert;

import Utilities.Helper;
import actions.DonorManagementAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DonorManagementPages;

public class DonorManagementSteps {

	DonorManagementAction donor = new DonorManagementAction();

	@When("the user clicks on the Blood Bank menu")
	public void the_user_clicks_on_the_blood_bank_menu() {

		Helper.waitForElementClickable(DonorManagementPages.bloodBankMenu);

		donor.clickBloodBankMenu();
	}

	@When("the user clicks on Donor Details")
	public void the_user_clicks_on_donor_details() {

		Helper.waitForElementClickable(DonorManagementPages.donorDetails);

		donor.clickDonorDetails();
	}

	@Then("the donor details page should be displayed")
	public void the_donor_details_page_should_be_displayed() {

		Assert.assertTrue(
				Helper.isDisplayed(DonorManagementPages.addBloodDonor));
	}

	@Then("the user should be able to view all donor records")
	public void the_user_should_be_able_to_view_all_donor_records() {

		Assert.assertTrue(
				Helper.isDisplayed(DonorManagementPages.addBloodDonor));
	}

	@When("the user clicks on Add Blood Donor")
	public void the_user_clicks_on_add_blood_donor() {

		Helper.waitForElementClickable(DonorManagementPages.addBloodDonor);

		donor.clickAddBloodDonor();
	}

	@Then("the Add Donor Details popup should be displayed")
	public void the_add_donor_details_popup_should_be_displayed() {

		Helper.waitForVisibility(DonorManagementPages.addDonorPopup);

		Assert.assertTrue(
				Helper.isDisplayed(DonorManagementPages.addDonorPopup));
	}
	@When("the user enters donor name {string}")
	public void the_user_enters_donor_name(String donorName) {

		donor.enterDonorName(donorName);
	}

	@When("the user enters date of birth {string}")
	public void the_user_enters_date_of_birth(String dob) {

		donor.enterDateOfBirth(dob);
	}

	@When("the user enters blood group {string}")
	public void the_user_enters_blood_group(String bloodGroup) {

		donor.enterBloodGroup(bloodGroup);
	}

	@When("the user enters gender {string}")
	public void the_user_enters_gender(String gender) {

		donor.enterGender(gender);
	}

	@When("the user enters father name {string}")
	public void the_user_enters_father_name(String fatherName) {

		donor.enterFatherName(fatherName);
	}

	@When("the user enters contact number {string}")
	public void the_user_enters_contact_number(String contactNumber) {

		donor.enterContactNumber(contactNumber);
	}

	@When("the user enters address {string}")
	public void the_user_enters_address(String address) {

		donor.enterAddress(address);
	}

	@When("the user clicks on Save button")
	public void the_user_clicks_on_save_button() {

		donor.clickSaveButton();
	}

	@Then("the newly added donor record should be visible in donor details list")
	public void the_newly_added_donor_record_should_be_visible_in_donor_details_list() {

		Assert.assertTrue(
				Helper.isDisplayed(DonorManagementPages.donorName));
	}
}