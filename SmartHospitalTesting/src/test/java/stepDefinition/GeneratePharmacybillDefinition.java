package stepDefinition;

import java.util.Map;
import java.util.Random;

import org.testng.Assert;
import actions.GeneratePharmacybillAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneratePharmacybillDefinition {

	GeneratePharmacybillAction generatePharmacyBillAction = new GeneratePharmacybillAction();

	// ===================== EXISTING =====================

	@When("user clicks Generate Bill button")
	public void user_clicks_generate_bill_button() {
		generatePharmacyBillAction.clickGenerateBillButton();
		System.out.println("Clicked Generate Bill button");
	}

	@When("the user enters pharmacy bill details")
	public void the_user_enters_pharmacy_bill_details(DataTable dataTable) {
		Map<String, String> pharmacyBillData = dataTable.asMap(String.class, String.class);
		if (pharmacyBillData.get("category") != null && !pharmacyBillData.get("category").isEmpty()) {
			generatePharmacyBillAction.selectCategory(pharmacyBillData.get("category"));
		}
		if (pharmacyBillData.get("medicine") != null && !pharmacyBillData.get("medicine").isEmpty()) {
			generatePharmacyBillAction.selectMedicine(pharmacyBillData.get("medicine"));
		}
	}

	@When("user clicks the Save button")
	public void user_clicks_the_save_button() {
		generatePharmacyBillAction.clickSaveButton();
		System.out.println("User clicked Save button");
	}

	@Then("the error message should be displayed")
	public void the_error_message_should_be_displayed() {
		boolean isErrorMessageDisplayed = generatePharmacyBillAction.isErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed");
		String errorMessage = generatePharmacyBillAction.getErrorMessageText();
		System.out.println("Error message: " + errorMessage);
	}

	// ===================== NEW =====================

	@When("the user clicks the New Patient button")
	public void the_user_clicks_the_new_patient_button() {
		generatePharmacyBillAction.clickNewPatientButton();
	}

	@Then("the Add Patient modal should be displayed")
	public void the_add_patient_modal_should_be_displayed() {
		Assert.assertTrue(generatePharmacyBillAction.isAddPatientModalDisplayed(),
				"Add Patient modal is not displayed");
	}

	@When("the user enters new patient details")
	public void the_user_enters_new_patient_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		generatePharmacyBillAction.enterPatientName(data.get("patientName"));

		generatePharmacyBillAction.enterAgeYear(data.get("ageYear"));

		generatePharmacyBillAction.enterAgeMonth(data.get("ageMonth"));

		generatePharmacyBillAction.enterAgeDay(data.get("ageDay"));
		Random random = new Random();

		String randomPhone =
		    "9" + (100000000 + random.nextInt(900000000));

		generatePharmacyBillAction.enterPhone(randomPhone);

		System.out.println("Generated Phone Number: " + randomPhone);
	}

	@When("the user clicks the Patient Save button")
	public void the_user_clicks_the_patient_save_button() {
		generatePharmacyBillAction.clickPatientSaveButton();
	}

	@Then("the record saved successfully message should be displayed")
	public void the_record_saved_successfully_message_should_be_displayed() {

		Assert.assertTrue(generatePharmacyBillAction.isSuccessMessageDisplayed(), "Success message not displayed");

		String actualMessage = generatePharmacyBillAction.getSuccessMessageText();

		System.out.println("Success Message: " + actualMessage);

		Assert.assertTrue(actualMessage.contains("Record Saved Successfully"), "Expected success message not matched");
	}
}