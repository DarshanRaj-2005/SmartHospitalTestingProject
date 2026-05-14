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

    public void enterPatientDetails(
            List<Map<String, String>> patientData) {

        addPatientPage.enterPatientName(
                patientData.get(0).get("PatientName"));

        addPatientPage.enterGuardianName(
                patientData.get(0).get("GuardianName"));

        addPatientPage.selectGender(
                patientData.get(0).get("Gender"));

        addPatientPage.enterPhoneNumber(
                patientData.get(0).get("Phone"));

        addPatientPage.enterAddress(
                patientData.get(0).get("Address"));
    }

    public void clickSaveButton() {

        addPatientPage.clickSaveButton();
    }

    public boolean verifyPatientAdded() {

        return addPatientPage.verifySuccessMessage();
    }
}