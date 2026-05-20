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

    public void enterValidPatientName() {
        lastSearchedName = "John Marshall";
        searchPatientPage.enterSearchText(lastSearchedName);
    }

    public void enterInvalidPatientName() {
        lastSearchedName = "XYZ123InvalidPatient";
        searchPatientPage.enterSearchText(lastSearchedName);
    }

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
