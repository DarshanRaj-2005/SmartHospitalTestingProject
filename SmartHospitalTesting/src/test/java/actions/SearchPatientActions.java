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

    // Receives name from Scenario Outline Examples table
    public void enterSearchName(String name) {
        lastSearchedName = name;
        searchPatientPage.enterSearchText(name);
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