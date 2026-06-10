package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Utilities.Helper;
import pages.GeneratePharmacybillPage;

public class GeneratePharmacybillAction {

	Logger logger = LogManager.getLogger(GeneratePharmacybillAction.class);

	// ===================== EXISTING =====================

	public void clickGenerateBillButton() {
		Helper.waitForElementClickable(GeneratePharmacybillPage.generateBillButton);
		Helper.click(GeneratePharmacybillPage.generateBillButton);
	}

	public void selectCategory(String category) {
		logger.info("Selecting category: " + category);
		Helper.selectSelect2(GeneratePharmacybillPage.categoryDropdown, GeneratePharmacybillPage.categorySearchBox,
				GeneratePharmacybillPage.categoryOption(category), category);
	}

	public void selectMedicine(String medicine) {
		logger.info("Selecting medicine: " + medicine);
		Helper.selectSelect2(GeneratePharmacybillPage.medicineInputField, GeneratePharmacybillPage.medicineSearchBox,
				GeneratePharmacybillPage.medicineOption(medicine), medicine);
	}

	public void clickSaveButton() {
		logger.info("Clicking Save button");
		Helper.click(GeneratePharmacybillPage.saveButton);
	}

	public boolean isErrorMessageDisplayed() {
		Helper.waitForVisibility(GeneratePharmacybillPage.errorMessage);
		return Helper.isDisplayed(GeneratePharmacybillPage.errorMessage);
	}

	public String getErrorMessageText() {
		String errorMessage = Helper.getText(GeneratePharmacybillPage.errorMessage);
		logger.error("Error message displayed: " + errorMessage);
		return errorMessage;
	}

	// ===================== NEW =====================

	public void clickNewPatientButton() {
		logger.info("Clicking New Patient button");
		Helper.waitForElementClickable(GeneratePharmacybillPage.newPatientButton);
		Helper.click(GeneratePharmacybillPage.newPatientButton);
	}

	public boolean isAddPatientModalDisplayed() {
		logger.info("Checking if Add Patient modal is displayed");
		Helper.waitForVisibility(GeneratePharmacybillPage.addPatientModal);
		return Helper.isDisplayed(GeneratePharmacybillPage.addPatientModal);
	}

	public void enterPatientName(String name) {
		logger.info("Entering patient name: " + name);
		Helper.waitForVisibility(GeneratePharmacybillPage.patientNameField);
		Helper.clearAndEnterText(GeneratePharmacybillPage.patientNameField, name);
	}

	public void enterAgeYear(String year) {
		logger.info("Entering age year: " + year);
		Helper.clearAndEnterText(GeneratePharmacybillPage.ageYearField, year);
	}

	public void enterAgeMonth(String month) {
		logger.info("Entering age month: " + month);
		Helper.clearAndEnterText(GeneratePharmacybillPage.ageMonthField, month);
	}

	public void enterAgeDay(String day) {
		logger.info("Entering age day: " + day);
		Helper.clearAndEnterText(GeneratePharmacybillPage.ageDayField, day);
	}

	public void enterPhone(String phone) {
		logger.info("Entering phone: " + phone);
		Helper.clearAndEnterText(GeneratePharmacybillPage.phoneField, phone);
	}

	public void clickPatientSaveButton() {
		logger.info("Clicking Patient Save button");
		Helper.waitForElementClickable(GeneratePharmacybillPage.patientSaveButton);
		Helper.click(GeneratePharmacybillPage.patientSaveButton);
	}

	public boolean isSuccessMessageDisplayed() {

		logger.info("Checking success toast message");

		try {

			Helper.waitForVisibility(GeneratePharmacybillPage.successMessage);

			return Helper.isDisplayed(GeneratePharmacybillPage.successMessage);

		} catch (Exception e) {

			logger.error("Success message not displayed");

			return false;
		}
	}

	public String getSuccessMessageText() {

		Helper.waitForVisibility(GeneratePharmacybillPage.successMessage);

		String message = Helper.getText(GeneratePharmacybillPage.successMessage);

		logger.info("Success message is: " + message);

		return message.trim();
	}
}