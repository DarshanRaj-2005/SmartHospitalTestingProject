package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.Helper;
import pages.GeneratePharmacybillPage;
import pages.PharmacyBillPage;

public class GeneratePharmacybillAction {

	Logger logger = LogManager.getLogger(GeneratePharmacybillAction.class);

	public void clickPharmacy() {
		Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);
		Helper.click(PharmacyBillPage.pharmacyMenu);
	}

	public void clickGenerateBillButton() {
		Helper.waitForElementClickable(GeneratePharmacybillPage.generateBillButton);
		Helper.click(GeneratePharmacybillPage.generateBillButton);
	}

	public void enterPatientName(String patientName) {

		logger.info("Entering patient name: " + patientName);

		Helper.waitForElementClickable(GeneratePharmacybillPage.patientDropdown);
		Helper.click(GeneratePharmacybillPage.patientDropdown);

		Helper.waitForElementsPresent(GeneratePharmacybillPage.patientSearchBox, 10);
		Helper.type(GeneratePharmacybillPage.patientSearchBox, patientName);

		Helper.waitForElementsPresent(GeneratePharmacybillPage.dropdownOption(patientName), 10);
		Helper.click(GeneratePharmacybillPage.dropdownOption(patientName));
	}

	public void selectCategory(String category) {

		logger.info("Selecting category: " + category);

		Helper.selectSelect2(
				GeneratePharmacybillPage.categoryDropdown,
				GeneratePharmacybillPage.categorySearchBox,
				GeneratePharmacybillPage.categoryOption(category),
				category
		);
	}

	public void selectMedicine(String medicine) {

		logger.info("Selecting medicine: " + medicine);

		Helper.selectSelect2(
				GeneratePharmacybillPage.medicineInputField,
				GeneratePharmacybillPage.medicineSearchBox,
				GeneratePharmacybillPage.medicineOption(medicine),
				medicine
		);
	}

	public void enterBatchNumber(String batchNumber) {
		Helper.clearAndEnterText(GeneratePharmacybillPage.batchInputField, batchNumber);
	}

	public void enterQuantity(String quantity) {
		Helper.clearAndEnterText(GeneratePharmacybillPage.quantityInputField, quantity);
	}

	public void selectDoctor(String doctor) {

		logger.info("Selecting doctor: " + doctor);

		Helper.selectSelect2(
				GeneratePharmacybillPage.doctorDropdown,
				GeneratePharmacybillPage.doctorSearchBox,
				GeneratePharmacybillPage.doctorOption(doctor),
				doctor
		);
	}

	public void selectPaymentMode(String paymentMode) {
		Helper.selectDropdown(GeneratePharmacybillPage.paymentModeDropdown, paymentMode);
	}

	public void enterAmount(String amount) {
		Helper.clearAndEnterText(GeneratePharmacybillPage.amountInputField, amount);
	}

	public void clickSaveButton() {

		logger.info("Clicking Save button");

		Helper.click(GeneratePharmacybillPage.saveButton);
	}

	public boolean isSuccessMessageDisplayed() {
		return Helper.isDisplayed(GeneratePharmacybillPage.successMessage);
	}

	public String getSuccessMessageText() {

		String successMessage = Helper.getText(GeneratePharmacybillPage.successMessage);

		logger.info("Success message displayed: " + successMessage);

		return successMessage;
	}

	public boolean isErrorMessageDisplayed() {
		return Helper.isDisplayed(GeneratePharmacybillPage.errorMessage);
	}

	public String getErrorMessageText() {
		

		String errorMessage = Helper.getText(GeneratePharmacybillPage.errorMessage);

		logger.error("Error message displayed: " + errorMessage);

		return errorMessage;
	}
}