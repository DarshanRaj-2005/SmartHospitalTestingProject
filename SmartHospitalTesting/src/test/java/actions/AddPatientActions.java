package actions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import pages.AddPatientPage;

public class AddPatientActions{
    static Logger logger = LogManager.getLogger(AddPatientActions.class);

    AddPatientPage addPatientPage;
    private String lastPatientName = "";

    public AddPatientActions(WebDriver driver) {
        addPatientPage = new AddPatientPage(driver);
    }
    public void clickPatientCategory() {
        addPatientPage.clickPatientCategory();
    }

    public void clickAddNewPatientButton() {
        addPatientPage.clickAddNewPatientButton();
    }

    public void waitForModalToLoad() {
        logger.info("Page Loaded");
        addPatientPage.waitForModalToLoad();
    }
    public void enterPatientDetails(List<Map<String, String>> patientData) {

        lastPatientName = patientData.get(0).get("PatientName");

        addPatientPage.enterPatientName(lastPatientName);
        addPatientPage.enterGuardianName(patientData.get(0).get("GuardianName"));
        addPatientPage.selectGender(patientData.get(0).get("Gender"));
        addPatientPage.enterDOB(patientData.get(0).get("DOB"));
        addPatientPage.selectBloodGroup(patientData.get(0).get("BloodGroup"));
        addPatientPage.enterPhoneNumber(patientData.get(0).get("Phone"));
        addPatientPage.enterEmail(patientData.get(0).get("Email"));
        addPatientPage.enterAddress(patientData.get(0).get("Address"));
         logger.info("Patient Details Added");
        
        
    }
    public void leaveMandatoryFieldsEmpty() {
        addPatientPage.leaveMandatoryFieldsEmpty();
        
    }
    public void clickSaveButton() {
        addPatientPage.clickSaveButton();
         logger.info("Clicked Save Button");
    }
    public boolean verifyPatientAdded() {
        return addPatientPage.verifyPatientSavedSuccessfully(lastPatientName);
    }

    public boolean verifyValidationMessage() {
        return addPatientPage.verifyValidationMessageDisplayed();
    }
}
