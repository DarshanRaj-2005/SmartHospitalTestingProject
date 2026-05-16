package actions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import pages.AddPatientPage;

public class AddPatientAction {

    AddPatientPage addPatientPage;

    public AddPatientAction(WebDriver driver) {
        addPatientPage = new AddPatientPage(driver);
    }

    // ==================== Navigation Actions ====================

    public void clickPatientCategory() {
        addPatientPage.clickPatientCategory();
    }

    public void clickAddNewPatientButton() {
        addPatientPage.clickAddNewPatientButton();
    }

    public void waitForModalToLoad() {
        addPatientPage.waitForModalToLoad();
    }

    public void enterPatientDetails(List<Map<String, String>> patientData) {

        addPatientPage.enterPatientName(
                patientData.get(0).get("PatientName"));

        addPatientPage.enterGuardianName(
                patientData.get(0).get("GuardianName"));

        addPatientPage.selectGender(
                patientData.get(0).get("Gender"));

        addPatientPage.enterDOB(
                patientData.get(0).get("DOB"));

        addPatientPage.selectBloodGroup(
                patientData.get(0).get("BloodGroup"));

        addPatientPage.enterPhoneNumber(
                patientData.get(0).get("Phone"));

        addPatientPage.enterEmail(
                patientData.get(0).get("Email"));

        addPatientPage.enterAddress(
                patientData.get(0).get("Address"));
    }

    public void clickSaveButton() {
        addPatientPage.clickSaveButton();
    }

    public boolean verifyPatientAdded() {
        return addPatientPage.verifySuccessMessage();
    }

    public boolean verifyPatientInList(String patientName) {
        return addPatientPage.verifyPatientInList(patientName);
    }
}