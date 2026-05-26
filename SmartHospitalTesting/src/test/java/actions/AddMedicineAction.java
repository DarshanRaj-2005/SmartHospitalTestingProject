package actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import Utilities.Helper;
import pages.AddMedicinePage;

public class AddMedicineAction {

	Logger logger =
			LogManager.getLogger(AddMedicineAction.class);
	private String lastMedicineName = "";
	public boolean isMedicineStockPageDisplayed() {

		Helper.waitForVisibility(
				AddMedicinePage.addMedicineButton);

		return Helper.isDisplayed(
				AddMedicinePage.addMedicineButton);
	}

	public boolean isAddMedicineTabDisplayed() {

		Helper.waitForVisibility(
				AddMedicinePage.medicineTab);

		return Helper.isDisplayed(
				AddMedicinePage.medicineTab);
	}

	public void clickAddMedicineButton() {

		logger.info("Clicking Add Medicine button");

		Helper.click(
				AddMedicinePage.addMedicineButton);
	}

	public void clickSaveButton() {

		logger.info("Clicking save button");

		Helper.click(
				AddMedicinePage.saveButton);
	}
	public void enterMedicineName(String medicineName) {

		lastMedicineName = medicineName;

		logger.info("Entering medicine name : " + medicineName);

		Helper.clearAndEnterText(
				AddMedicinePage.medicineNameField,
				medicineName);
	}

	public void enterMedicineComposition(String composition) {

		logger.info("Entering medicine composition : " + composition);

		Helper.clearAndEnterText(
				AddMedicinePage.compositionField,
				composition);
	}

	public void enterMinLevel(String minLevel) {

		logger.info("Entering minimum level : " + minLevel);

		Helper.clearAndEnterText(
				AddMedicinePage.minLevelField,
				minLevel);
	}

	public void enterReorderLevel(String reorderLevel) {

		logger.info("Entering reorder level : " + reorderLevel);

		Helper.clearAndEnterText(
				AddMedicinePage.reorderLevelField,
				reorderLevel);
	}

	public void enterTax(String tax) {

		logger.info("Entering tax : " + tax);

		Helper.clearAndEnterText(
				AddMedicinePage.taxField,
				tax);
	}

	public void enterBoxPacking(String boxPacking) {

		logger.info("Entering box packing : " + boxPacking);

		Helper.clearAndEnterText(
				AddMedicinePage.boxPackingField,
				boxPacking);
	}

	public void enterVat(String vat) {

		logger.info("Entering vat : " + vat);

		Helper.clearAndEnterText(
				AddMedicinePage.vatField,
				vat);
	}

	public void enterRackNumber(String rackNumber) {

		logger.info("Entering rack number : " + rackNumber);

		Helper.clearAndEnterText(
				AddMedicinePage.rackNumberField,
				rackNumber);
	}

	public void enterNote(String note) {

		logger.info("Entering note");

		Helper.clearAndEnterText(
				AddMedicinePage.noteField,
				note);
	}

	public void selectMedicineCategory(String category) {

		logger.info("Selecting medicine category : " + category);

		Helper.selectValue(
				AddMedicinePage.categoryDropdown,
				category);
	}

	public void selectMedicineCompany(String company) {

		logger.info("Selecting medicine company : " + company);

		Helper.selectValue(
				AddMedicinePage.companyDropdown,
				company);
	}

	public void selectMedicineGroup(String medicineGroup) {

		logger.info("Selecting medicine group : " + medicineGroup);

		Helper.selectValue(
				AddMedicinePage.groupDropdown,
				medicineGroup);
	}

	public void selectUnit(String unit) {

		logger.info("Selecting unit : " + unit);

		Helper.selectValue(
				AddMedicinePage.unitDropdown,
				unit);
	}

	public boolean isSuccessMessageDisplayed() {

		return Helper.isToastMessageDisplayed(
				AddMedicinePage.successMessage);
	}

	public String getSuccessMessageText() {

		return Helper.getToastMessage(
				AddMedicinePage.successMessage);
	}

	public boolean isMedicineNameValidationDisplayed() {

		return Helper.isDisplayed(
				AddMedicinePage.medicineNameValidationMessage);
	}

	public String getMedicineNameValidationMessage() {

		return Helper.getText(
				AddMedicinePage.medicineNameValidationMessage);
	}

	public boolean isAddMedicineModalClosed() {

		try {

			return !Helper.isDisplayed(
					AddMedicinePage.addMedicineModal);

		} catch (Exception e) {

			return true;
		}
	}
	public boolean verifyMedicineAdded() {
		Helper.waitForVisibility(
				AddMedicinePage.medicineTable);

		Helper.waitForElementsPresent(
				AddMedicinePage.tableCells, 15);

		List<WebElement> cells =
				Helper.getElements(
						AddMedicinePage.tableCells);

		for (WebElement cell : cells) {

			if (cell.getText().trim()
					.equalsIgnoreCase(lastMedicineName.trim())) {

				return true;
			}
		}

		return false;
	}
}