package actions;

import java.util.Arrays;
import java.util.List;
import Utilities.Helper;
import driver.Driver;
import pages.DonorManagementPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

public class DonorManagementAction {
	Logger logger = LogManager.getLogger(DonorManagementAction.class);

	public void clickBloodBankMenu() {

	    logger.info("Navigated to Blood Bank module");
	    Helper.waitForVisibility( DonorManagementPage.bloodBankMenu);
	    Helper.click(DonorManagementPage.bloodBankMenu);
	}
	

	public void clickDonorDetails() {

	    Helper.waitForElementClickable(DonorManagementPage.donorDetails);
	    Helper.jsClick(DonorManagementPage.donorDetails);
	}

	public void clickAddBloodDonor() {
		logger.info("Blood Donor popup is opened.");
		Helper.click(DonorManagementPage.addBloodDonor);
	}

	public void enterDonorName(String donorname) {
		Helper.type(DonorManagementPage.donorName, donorname);
	}

	public void enterDateOfBirth(String dob) {
		Helper.type(DonorManagementPage.dateOfBirth, dob);
	}

	public void enterBloodGroup(String bloodgroup) {
		Helper.type(DonorManagementPage.bloodGroup, bloodgroup);
	}

	public void enterGender(String gender) {
		Helper.type(DonorManagementPage.gender, gender);
	}

	public void enterFatherName(String fathername) {
		Helper.type(DonorManagementPage.fatherName, fathername);
	}

	public void enterContactNumber(String contactnumber) {
		Helper.type(DonorManagementPage.contactNumber, contactnumber);
	}

	public void enterAddress(String address) {
		Helper.type(DonorManagementPage.address, address);
	}

	public void clickSaveButton() {
		logger.info("Clicked Save Button");
		Helper.click(DonorManagementPage.saveButton);
	}

	public List<String> getValidationMessages() {
		Helper.waitForVisibility(DonorManagementPage.validationMessages);
		String text = Driver.getDriver().findElement(DonorManagementPage.validationMessages).getText();
		return Arrays.asList(text.split("\\n"));
	}
	public void searchDonorName(String donorName) {
	    logger.info("Searching donor name: " + donorName);
	    Helper.click(DonorManagementPage.searchDonor);
	    Helper.clearAndEnterText(DonorManagementPage.searchDonor, donorName);
	    Helper.getElement(DonorManagementPage.searchDonor).sendKeys(Keys.ENTER);
	}
	public boolean verifyDonorNameInList(String donorName) {
	    Helper.waitForVisibility(DonorManagementPage.searchResult);
	    return Helper.getText(DonorManagementPage.searchResult).contains(donorName);
	}

}
