package actions;

import org.openqa.selenium.WebDriver;
import pages.SearchPatientPage;

public class SearchPatientAction {

    SearchPatientPage searchPatientPage;
    private static final String VALID_PATIENT_NAME   = "John Marshall";
    private static final String INVALID_PATIENT_NAME = "XYZ123InvalidPatient";

    private String lastSearchedName = "";

    public SearchPatientAction(WebDriver driver) {
        searchPatientPage = new SearchPatientPage(driver);
    }

    public void clickPatientSidebarLink() {
        searchPatientPage.clickPatientSidebarLink();
    }

    public void waitForPatientListToLoad() {
        searchPatientPage.waitForPatientListToLoad();
    }
    public void enterValidPatientName() {
        lastSearchedName = VALID_PATIENT_NAME;
        searchPatientPage.enterSearchText(VALID_PATIENT_NAME);
    }

    public void enterInvalidPatientName() {
        lastSearchedName = INVALID_PATIENT_NAME;
        searchPatientPage.enterSearchText(INVALID_PATIENT_NAME);
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
