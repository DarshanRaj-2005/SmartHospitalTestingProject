package actions;
import java.util.Arrays;
import java.util.List;
import Utilities.Helper;
import driver.Driver;
import pages.DonorManagementPage;

public class DonorManagementAction {
	public void clickBloodBankMenu() {
		Helper.click(DonorManagementPage.bloodBankMenu);
	}
	public void clickDonorDetails() {
		Helper.click(DonorManagementPage.donorDetails);
	}
	public void clickAddBloodDonor() {
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
		Helper.click(DonorManagementPage.saveButton);
	}
	public List<String> getValidationMessages() {

	    Helper.waitForVisibility(DonorManagementPage.validationMessages);
	    String text = Driver.getDriver().findElement(DonorManagementPage.validationMessages).getText();
	    return Arrays.asList(text.split("\\n"));
	}
	}
