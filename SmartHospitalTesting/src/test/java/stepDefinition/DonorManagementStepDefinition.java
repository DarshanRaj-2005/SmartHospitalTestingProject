package stepDefinition;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Utilities.CsvReader;
import Utilities.Helper;
import actions.DonorManagementAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DonorManagementPage;

public class DonorManagementStepDefinition {
	Logger logger = LogManager.getLogger(DonorManagementStepDefinition.class);
	DonorManagementAction donor = new DonorManagementAction();
	String donorName;
	@When("the user clicks on the Blood Bank menu")
	public void the_user_clicks_on_the_blood_bank_menu() {
		Helper.waitForElementClickable(DonorManagementPage.bloodBankMenu);
		donor.clickBloodBankMenu();
	}
	
	@When("the user clicks on Donor Details")
	public void the_user_clicks_on_donor_details() {
		Helper.waitForElementClickable(DonorManagementPage.donorDetails);
		donor.clickDonorDetails();
	}

	@Then("the donor details page should be displayed")
	public void the_donor_details_page_should_be_displayed() {
	    Helper.waitForVisibility(DonorManagementPage.addBloodDonor);
	    Assert.assertTrue(Helper.isDisplayed(DonorManagementPage.addBloodDonor));
	}
	@Then("the user should be able to view all donor records")
	public void the_user_should_be_able_to_view_all_donor_records() {
		Assert.assertTrue(Helper.isDisplayed(DonorManagementPage.addBloodDonor));
	}

	@When("the user clicks on Add Blood Donor")
	public void the_user_clicks_on_add_blood_donor() {
		Helper.waitForElementClickable(DonorManagementPage.addBloodDonor);
		donor.clickAddBloodDonor();
	}

	@Then("the Add Donor Details popup should be displayed")
	public void the_add_donor_details_popup_should_be_displayed() {
		Helper.waitForVisibility(DonorManagementPage.addDonorPopup);
		Assert.assertTrue(Helper.isDisplayed(DonorManagementPage.addDonorPopup));
	}
	@When("the user enters donor name {string} and date of birth {string} and blood group {string} and gender {string} and father name {string} and contact number {string} and address {string}")
	public void the_user_enters_complete_donor_details(String donorName,
	                                                   String dob,
	                                                   String bloodGroup,
	                                                   String gender,
	                                                   String fatherName,
	                                                   String contactNumber,
	                                                   String address) {
		logger.info("Enter the new Donor details");
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
		logger.info("Enter the details");
	    donor.enterDonorName(donorName);
	    donor.enterDateOfBirth(dob);
	    donor.enterBloodGroup(bloodGroup);
	    donor.enterGender(gender);
	}

	


	@Then("the newly added donor record should be visible in donor details list")
	public void the_newly_added_donor_record_should_be_visible_in_donor_details_list() {
		logger.info("The Record is added Succefully.");
		Assert.assertTrue(Helper.isDisplayed(DonorManagementPage.donorName));
	}
	@Then("the donor validation messages should be displayed")
	public void the_donor_validation_messages_should_be_displayed(DataTable dataTable) {
		logger.info("New Donor is not added.");
	    List<String> expectedMessages = dataTable.asList(String.class);
	    List<String> actualMessages = donor.getValidationMessages();
	    Assert.assertEquals(actualMessages, expectedMessages);
	}
	@When("the user enters valid donor details")
	public void the_user_enters_valid_donor_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    String donorName = data.get(0).get("DonorName");
	    String dateOfBirth =data.get(0).get("DateOfBirth");
	    String bloodGroup =data.get(0).get("BloodGroup");
	    String gender =data.get(0).get("Gender");
	    String fatherName =data.get(0).get("FatherName");
	    String contactNumber =data.get(0).get("ContactNumber");
	    String address = data.get(0).get("Address");
	    donor.enterDonorName(donorName);
	    donor.enterDateOfBirth(dateOfBirth);
	    donor.enterBloodGroup(bloodGroup);
	    donor.enterGender(gender);
	    donor.enterFatherName(fatherName);
	    donor.enterContactNumber(contactNumber);
	    donor.enterAddress(address);
	}
	@When("the user enters mandatory donor details")
	public void the_user_enters_mandatory_donor_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    String donorName = data.get(0).get("DonorName");
	    String dateOfBirth =data.get(0).get("DateOfBirth");
	    String bloodGroup =data.get(0).get("BloodGroup");
	    String gender =data.get(0).get("Gender");
	    donor.enterDonorName(donorName);
	    donor.enterDateOfBirth(dateOfBirth);
	    donor.enterBloodGroup(bloodGroup);
	    donor.enterGender(gender);	   
	}
	@When("the user enters mandatory donor details from csv")
	public void the_user_enters_mandatory_donor_details_from_csv() {
		List<String[]> donorData =
	            CsvReader.readCsv("src/test/resources/test_datas/donorData.csv");

	    for (String[] data : donorData) {

	        String donorName = data[0];
	        String dob = data[1];
	        String bloodGroup = data[2];
	        String gender = data[3];

	        donor.enterDonorName(donorName);
	        donor.enterDateOfBirth(dob);
	        donor.enterBloodGroup(bloodGroup);
	        donor.enterGender(gender);
	}
}
	@When("the user clicks on Save")
	public void the_user_clicks_on_save() {
		donor.clickSaveButton();

	}
	@When("User searches donor name")
	public void user_searches_donor_name(DataTable dataTable) {

	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    donorName = data.get(0).get("DonorName");

	    donor.searchDonorName(donorName);
	}


	@Then("Donor details should be displayed")
	public void donor_details_should_be_displayed() {
		Assert.assertTrue(donor.verifyDonorNameInList(donorName),"Donor name not found" );
	}


}
	