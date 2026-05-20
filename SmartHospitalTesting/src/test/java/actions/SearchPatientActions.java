package actions;

import org.openqa.selenium.WebDriver;
import pages.SearchPatientPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPatientActions {
       static Logger logger = LogManager.getLogger(SearchPatientActions.class);

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
       
        searchPatientPage.enterSearchText(lastSearchedName);
        logger.info("Name Entered ");
    }

    public void enterInvalidPatientName() {
    
        searchPatientPage.enterSearchText(lastSearchedName);
         logger.info("Invalid Name Entered ");
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
