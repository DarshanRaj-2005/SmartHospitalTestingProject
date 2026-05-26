package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.Helper;
import pages.GeneratePharmacybillPage;
import pages.PharmacyBillPage;

public class GeneratePharmacybillAction {

	Logger logger = LogManager.getLogger(GeneratePharmacybillAction.class);
	
	public void clickGenerateBillButton() {
		Helper.waitForElementClickable(GeneratePharmacybillPage.generateBillButton);
		Helper.click(GeneratePharmacybillPage.generateBillButton);
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
}