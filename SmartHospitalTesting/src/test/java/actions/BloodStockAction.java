package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Utilities.Helper;
import pages.BloodStockPage;

public class BloodStockAction {


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
	            Helper.click(BloodStockPage.addIcon);
	        }

	        public static boolean isBloodDonorPopupDisplayed() {
	            Helper.waitForVisibility(BloodStockPage.saveButton);
	            return Helper.isDisplayed(BloodStockPage.saveButton);
	        }

	        public static void selectBloodDonor(String donor) {
	            Helper.moveToElementAndClick(BloodStockPage.bloodDonor);
	            Helper.type(BloodStockPage.searchBox,donor);
	            Helper.waitForVisibility(BloodStockPage.dynamicOption(donor));
	            Helper.click(BloodStockPage.dynamicOption(donor));
	        }

	        public static void enterDonateDate(String donateDate) {

	            Helper.type(
	            		BloodStockPage.donateDateField,
	                    donateDate);

	            Helper.getElement(BloodStockPage.donateDateField).sendKeys(Keys.TAB);
	        }

	        public static void enterBag(String bag) {

	            Helper.type(BloodStockPage.bagField,bag);
	        }



	        public static void selectChargeCategory(String chargecategory) {

	            Helper.moveToElementAndClick(
	            		BloodStockPage.chargeCategory);

	            Helper.type(BloodStockPage.searchBox,chargecategory);

	            Helper.waitForVisibility(BloodStockPage.dynamicOption(chargecategory));

	            Helper.click(BloodStockPage.dynamicOption(chargecategory));
	        }

	        public static void selectChargeName(String chargename) {

	            Helper.moveToElementAndClick(BloodStockPage.chargeName);

	            Helper.type(BloodStockPage.searchBox,chargename);

	            Helper.waitForVisibility(BloodStockPage.dynamicOption(chargename));

	            Helper.click(BloodStockPage.dynamicOption(chargename));
	        }

	        public void clickSaveButton() {

	            Helper.click(BloodStockPage.saveButton);
	        }

	        public static boolean isBloodDonorAddedSuccessfully() {

	            Helper.waitForVisibility(BloodStockPage.successMessage);

	            String message = Helper.getText(BloodStockPage.successMessage);


	            return message.toLowerCase().contains("success");
	        }
}


