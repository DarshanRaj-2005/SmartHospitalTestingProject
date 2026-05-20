package actions;

import org.openqa.selenium.WebDriver;
import pages.SearchPatientPage;

public class SearchPatientActions {

    SearchPatientPage searchPatientPage;
    private String lastSearchedName = "";

    public SearchPatientActions(WebDriver driver) {
        searchPatientPage = new SearchPatientPage(driver);
    }

    public void clickPatientSidebarLink() {
        searchPatientPage.clickPatientSidebarLink();
    }

    public void waitForPatientListToLoad() {
        searchPatientPage.waitForPatientListToLoad();
    }

    // Old step: "User enters patient name in search box"
    public void enterValidPatientName() {
        lastSearchedName = "John Marshall";
        searchPatientPage.enterSearchText(lastSearchedName);
    }

    // Old step: "User enters invalid patient name"
    public void enterInvalidPatientName() {
        lastSearchedName = "XYZ123InvalidPatient";
        searchPatientPage.enterSearchText(lastSearchedName);
    }

    // New Scenario Outline step: "User searches for patient name {string}"
    public void searchByName(String patientName) {
        lastSearchedName = patientName;
        searchPatientPage.enterSearchText(patientName);
    }

    public void clickSearchButton() {
        searchPatientPage.clickSearchButton();
    }

    public boolean verifyMatchingPatientDisplayed() {
        return searchPatientPage.verifyMatchingPatientDisplayed(lastSearchedName);
    }

    public boolean verifyNoRecordsFound() {
        return searchPatientPage.verifyNoRecordsFound();
    }
}
