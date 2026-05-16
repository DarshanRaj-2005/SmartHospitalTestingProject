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

	    Helper.waitForVisibility(DonorManagementPages.addBloodDonor);

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
	@When("the user enters donor name {string} and date of birth {string} and blood group {string} and gender {string} and father name {string} and contact number {string} and address {string}")
	public void the_user_enters_complete_donor_details(String donorName,
	                                                   String dob,
	                                                   String bloodGroup,
	                                                   String gender,
	                                                   String fatherName,
	                                                   String contactNumber,
	                                                   String address) {

	    donor.enterDonorName(donorName);
	    donor.enterDateOfBirth(dob);
	    donor.enterBloodGroup(bloodGroup);
	    donor.enterGender(gender);
	    donor.enterFatherName(fatherName);
	    donor.enterContactNumber(contactNumber);
	    donor.enterAddress(address);
	}

	@When("the user enters donor name {string} and date of birth {string} and blood group {string} and gender {string}")
	public void the_user_enters_mandatory_donor_details(String donorName,
	                                                    String dob,
	                                                    String bloodGroup,
	                                                    String gender) {

	    donor.enterDonorName(donorName);
	    donor.enterDateOfBirth(dob);
	    donor.enterBloodGroup(bloodGroup);
	    donor.enterGender(gender);
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
	