package actions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import pages.AddPatientPage;
import Utilities.Helper;
import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AddPatientAction {
   static Logger logger = LogManager.getLogger(AddPatientActions.class);
    private String lastPatientName = "";

    public AddPatientAction(WebDriver driver) {
    }

    public void clickPatientCategory() {
        Helper.waitForElementClickable(AddPatientPage.patientCategory);
        Helper.jsClick(AddPatientPage.patientCategory);
    }

    public void clickAddNewPatientButton() {
        Helper.waitForElementClickable(AddPatientPage.addNewPatientButton);
        Helper.jsClick(AddPatientPage.addNewPatientButton);
    }

    public void waitForModalToLoad() {
        try {
            Helper.waitForVisibility(AddPatientPage.modalNameInput);
            Helper.waitForElementClickable(AddPatientPage.modalNameInput);
            return;
        } catch (Exception e) {
         
        }
        Helper.waitForVisibility(
                org.openqa.selenium.By.xpath(
                        "//div[contains(@class,'modal-header')]" + " | //div[@id='add_patient'][not(contains(@style,'display: none'))]"));
    }

    public void enterPatientDetails(List<Map<String, String>> patientData) {
        lastPatientName = patientData.get(0).get("PatientName");

        Helper.clearAndEnterText(AddPatientPage.patientName,  lastPatientName);
        Helper.clearAndEnterText(AddPatientPage.guardianName, patientData.get(0).get("GuardianName"));
        Helper.selectDropdown(AddPatientPage.gender,          patientData.get(0).get("Gender"));
        enterDOB(patientData.get(0).get("DOB"));
        Helper.selectDropdown(AddPatientPage.bloodGroup,      patientData.get(0).get("BloodGroup"));
        Helper.clearAndEnterText(AddPatientPage.phone,        patientData.get(0).get("Phone"));
        Helper.clearAndEnterText(AddPatientPage.email,        patientData.get(0).get("Email"));
        Helper.clearAndEnterText(AddPatientPage.address,      patientData.get(0).get("Address"));
       
    }
    private void enterDOB(String value) {
        String[] parts = value.split("-");
        String day   = parts[0];
        String month = parts[1];
        String year  = parts[2];
        try {
            Helper.clearAndEnterText(AddPatientPage.dobYear,  year);
            Helper.clearAndEnterText(AddPatientPage.dobMonth, month);
            Helper.clearAndEnterText(AddPatientPage.dobDay,   day);
        } catch (Exception e) {
            Helper.setDate(AddPatientPage.dob, value);
        }
    }

    public void leaveMandatoryFieldsEmpty() {
        Helper.waitForVisibility(AddPatientPage.patientName);
        Helper.clear(AddPatientPage.patientName);
    }

    public void clickSaveButton() {
        Helper.waitForElementClickable(AddPatientPage.saveButton);
        Helper.jsClick(AddPatientPage.saveButton);
    }

    public boolean verifyPatientAdded() {
        Helper.waitForInvisibility(AddPatientPage.modalNameInput);

        Helper.waitForVisibility(AddPatientPage.patientListTable);

   
        Helper.waitForElementsPresent(AddPatientPage.tableCells, 15);

        List<WebElement> cells = Helper.getElements(AddPatientPage.tableCells);
        for (WebElement cell : cells) {
            if (cell.getText().trim().equalsIgnoreCase(lastPatientName.trim())) {
                return true;
                 logger.info("Patient Details Added");
            }
        }
        return false;
    }

    public boolean verifyValidationMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddPatientPage.validationMessage));
            return Helper.isDisplayed(AddPatientPage.validationMessage);
        } catch (Exception e) {
            return Helper.isFieldHasError(AddPatientPage.patientName);
        }
    }
}
