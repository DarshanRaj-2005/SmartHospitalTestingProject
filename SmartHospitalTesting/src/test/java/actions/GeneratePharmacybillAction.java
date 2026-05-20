package actions;

import Utilities.Helper;
import pages.GeneratePharmacybillPage;
import pages.PharmacyBillPage;

public class GeneratePharmacybillAction {

	public void clickPharmacy() {
		Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);
		Helper.click(PharmacyBillPage.pharmacyMenu);
	}

	public void clickGenerateBillButton() {
		Helper.waitForElementClickable(GeneratePharmacybillPage.generateBillButton);
		Helper.click(GeneratePharmacybillPage.generateBillButton);
	}

	public void enterPatientName(String patientName) {
		Helper.waitForElementClickable(GeneratePharmacybillPage.patientDropdown);
		Helper.click(GeneratePharmacybillPage.patientDropdown);

		Helper.waitForElementsPresent(GeneratePharmacybillPage.patientSearchBox, 10);
		Helper.type(GeneratePharmacybillPage.patientSearchBox, patientName);

		Helper.waitForElementsPresent(GeneratePharmacybillPage.dropdownOption(patientName), 10);
		Helper.click(GeneratePharmacybillPage.dropdownOption(patientName));
	}

	public void selectCategory(String category) {
		Helper.selectSelect2(
				GeneratePharmacybillPage.categoryDropdown,
				GeneratePharmacybillPage.categorySearchBox,
				GeneratePharmacybillPage.categoryOption(category),
				category
		);
	}

	public void selectMedicine(String medicine) {
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
		Helper.click(GeneratePharmacybillPage.saveButton);
	}

	public boolean isSuccessMessageDisplayed() {
		return Helper.isDisplayed(GeneratePharmacybillPage.successMessage);
	}

	public String getSuccessMessageText() {
		return Helper.getText(GeneratePharmacybillPage.successMessage);
	}

	public boolean isErrorMessageDisplayed() {
		return Helper.isDisplayed(GeneratePharmacybillPage.errorMessage);
	}

	public String getErrorMessageText() {
		return Helper.getText(GeneratePharmacybillPage.errorMessage);
	}
}