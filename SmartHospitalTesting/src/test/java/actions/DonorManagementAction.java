package actions;
import java.util.Arrays;
import java.util.List;

import Utilities.Helper;
import driver.Driver;
import pages.DonorManagementPages;

public class DonorManagementAction {

	public void clickBloodBankMenu() {
		Helper.click(DonorManagementPages.bloodBankMenu);
	}
	public void clickDonorDetails() {
		Helper.click(DonorManagementPages.donorDetails);
	}
	public void clickAddBloodDonor() {
		Helper.click(DonorManagementPages.addBloodDonor);
	}
	public void enterDonorName(String donorname) {
		Helper.type(DonorManagementPages.donorName, donorname);
	}
	public void enterDateOfBirth(String dob) {
		Helper.type(DonorManagementPages.dateOfBirth, dob);
	}
	public void enterBloodGroup(String bloodgroup) {
		Helper.type(DonorManagementPages.bloodGroup, bloodgroup);
	}
	public void enterGender(String gender) {
		Helper.type(DonorManagementPages.gender, gender);
	}
	public void enterFatherName(String fathername) {
		Helper.type(DonorManagementPages.fatherName, fathername);
	}
	public void enterContactNumber(String contactnumber) {
		Helper.type(DonorManagementPages.contactNumber, contactnumber);
	}
	public void enterAddress(String address) {
		Helper.type(DonorManagementPages.address, address);
	}
	public void clickSaveButton() {
		Helper.click(DonorManagementPages.saveButton);
	}
	public List<String> getValidationMessages() {

	    Helper.waitForVisibility(DonorManagementPages.validationMessages);

	    String text = Driver.getDriver()
	            .findElement(DonorManagementPages.validationMessages)
	            .getText();

	    return Arrays.asList(text.split("\\n"));
	}}
