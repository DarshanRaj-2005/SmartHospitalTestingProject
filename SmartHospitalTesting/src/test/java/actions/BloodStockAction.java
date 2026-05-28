package actions;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Utilities.Helper;
import driver.Driver;
import pages.BloodIssuePage;
import pages.BloodStockPage;
import pages.DonorManagementPage;

public class BloodStockAction {

	static Logger logger = LogManager.getLogger(BloodStockAction.class);

	public boolean isBloodStockStatusPageDisplayed() {
		Helper.waitForVisibility(BloodStockPage.bloodBankStatus);
		return Helper.isDisplayed(BloodStockPage.bloodBankStatus);
	}

	public void selectBloodGroup(String bloodGroup) {
		By bloodGroupOption = BloodStockPage.bloodGroupOption(bloodGroup);
		Helper.waitForVisibility(bloodGroupOption);
		Helper.click(bloodGroupOption);
	}

	public boolean isBloodBagDetailsDisplayed() {
		Helper.waitForVisibility(BloodStockPage.bloodBagTable);
		return Helper.isDisplayed(BloodStockPage.bloodBagTable);
	}

	public boolean isBloodComponentDetailsDisplayed() {
		Helper.waitForVisibility(BloodStockPage.componentTable);
		return Helper.isDisplayed(BloodStockPage.componentTable);
	}

	public static void clickAddIcon() {
		logger.info("Clicked Add Icon");
		Helper.click(BloodStockPage.addIcon);
	}

	public static boolean isBloodDonorPopupDisplayed() {
		Helper.waitForVisibility(BloodStockPage.saveButton);
		return Helper.isDisplayed(BloodStockPage.saveButton);
	}

	public static void selectBloodDonor(String donor) {

	    Helper.moveToElementAndClick(BloodStockPage.bloodDonor);

	    Helper.waitForVisibility(BloodStockPage.searchBox);

	    Helper.type(BloodStockPage.searchBox, donor);

	    By option = BloodStockPage.dynamicOption(donor);

	    Helper.waitForVisibility(option);

	    Helper.click(option);
	}

	public static void enterDonateDate(String donateDate) {
		Helper.type(BloodStockPage.donateDateField, donateDate);
		Helper.getElement(BloodStockPage.donateDateField).sendKeys(Keys.TAB);
	}

	public static void enterBag(String bag) {
		Helper.type(BloodStockPage.bagField, bag);
	}

	public static void selectChargeCategory(String chargecategory) {
	    Helper.moveToElementAndClick(BloodStockPage.chargeCategory);
	    Helper.waitForVisibility(BloodStockPage.searchBox);
	    Helper.type(BloodStockPage.searchBox, chargecategory);
	    By option = BloodStockPage.dynamicOption(chargecategory);
	    Helper.waitForVisibility(option);
	    Helper.click(option);
	}

    public static void selectChargeName(String charge) {

        Helper.moveToElementAndClick(BloodStockPage.chargeName);

        Helper.waitForVisibility(BloodStockPage.searchBox);

        Helper.type(BloodStockPage.searchBox, charge);

        Helper.waitForElementsPresent(
                BloodStockPage.dynamicOption(charge), 20);

        Helper.click(BloodStockPage.dynamicOption(charge));
    }
	public static void clickSaveButton() {
		logger.info("Clicked Save Button");
		Helper.click(BloodStockPage.saveButton);
		
	}

	public static boolean isBloodDonorAddedSuccessfully() {
		Helper.waitForVisibility(BloodStockPage.successMessage);
		String message = Helper.getText(BloodStockPage.successMessage);
		return message.toLowerCase().contains("success");
	}

	public static void clickCalculateButton() {
		Helper.click(BloodStockPage.calculate);
	}

	public static boolean isBagNumberDisplayed(String bagField) {
		Helper.waitForVisibility(BloodStockPage.addedBagNumber(bagField));
		return Helper.isDisplayed(BloodStockPage.addedBagNumber(bagField));
	}

	public static boolean isBloodIssuePageDisplayed() {
		Helper.waitForVisibility(BloodStockPage.issueDate);
		return Helper.isDisplayed(BloodStockPage.issueDate);
	}

	public static void clickIssueButton(String bag) {
		logger.info("Clicked Issue Button");
		Helper.click(BloodStockPage.issueButton(bag));
	}
	public List<String> getValidationMessages() {
	    Helper.waitForVisibility(BloodStockPage.validationMessages);
	    String text = Driver.getDriver().findElement(BloodStockPage.validationMessages).getText();
	    return Arrays.asList(text.split("\\n"));
	}
}
