package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import pages.SearchPatientPage;
import Utilities.Helper;

public class SearchPatientActions {

    static Logger logger = LogManager.getLogger(SearchPatientActions.class);

    private String lastSearchedName = "";

    public SearchPatientActions(WebDriver driver) {
    }

    public void clickPatientSidebarLink() {
        Helper.waitForElementClickable(SearchPatientPage.patientSidebarLink);
        Helper.jsClick(SearchPatientPage.patientSidebarLink);
    }

    public void waitForPatientListToLoad() {
        Helper.waitForVisibility(SearchPatientPage.searchBox);
        Helper.waitForVisibility(SearchPatientPage.tableRows);
    }

    public void enterValidPatientName() {
        Helper.waitForElementClickable(SearchPatientPage.searchBox);
        Helper.click(SearchPatientPage.searchBox);
        Helper.clear(SearchPatientPage.searchBox);
        Helper.type(SearchPatientPage.searchBox, lastSearchedName);
        logger.info("Name Entered: " + lastSearchedName);
    }

    public void enterInvalidPatientName() {
        Helper.waitForElementClickable(SearchPatientPage.searchBox);
        Helper.click(SearchPatientPage.searchBox);
        Helper.clear(SearchPatientPage.searchBox);
        Helper.type(SearchPatientPage.searchBox, lastSearchedName);
        logger.info("Invalid Name Entered: " + lastSearchedName);
    }

    public void searchByName(String patientName) {
        lastSearchedName = patientName;
        Helper.waitForElementClickable(SearchPatientPage.searchBox);
        Helper.click(SearchPatientPage.searchBox);
        Helper.clear(SearchPatientPage.searchBox);
        Helper.type(SearchPatientPage.searchBox, patientName);
        logger.info("Searched for patient: " + patientName);
    }

    public void clickSearchButton() {
        
        Helper.waitForInvisibility(SearchPatientPage.processingSpinner);

        Helper.waitForElementsPresent(
                By.xpath("//table[contains(@class,'table')]//tbody//tr"),
                10);
    }

    public boolean verifyMatchingPatientDisplayed() {
     
        Helper.waitForElementsPresent(SearchPatientPage.tableRows, 15);

        List<WebElement> rows = Helper.getElements(SearchPatientPage.tableRows);
        if (rows.isEmpty()) return false;

        String firstRowText = rows.get(0).getText().toLowerCase();
        boolean isNoDataRow = firstRowText.contains("no data")
                           || firstRowText.contains("no matching")
                           || firstRowText.contains("no records")
                           || firstRowText.trim().isEmpty();

        if (rows.size() == 1 && isNoDataRow) return false;
        String bodyText = Helper.getElement(By.tagName("body"))
                                .getAttribute("innerHTML")
                                .toLowerCase();
        return bodyText.contains(lastSearchedName.toLowerCase());
    }

    public boolean verifyNoRecordsFound() {
     
        Helper.waitForInvisibility(SearchPatientPage.processingSpinner);

        Helper.waitForElementsPresent(
                By.xpath("//td[contains(@class,'dataTables_empty')]"
                       + " | //table[contains(@class,'table')]//tbody//tr"),
                10);
        List<WebElement> emptyElements = Helper.getElements(SearchPatientPage.emptyTd);
        if (!emptyElements.isEmpty() && emptyElements.get(0).isDisplayed()) {
            return true;
        }
        if (Helper.isDisplayed(SearchPatientPage.noDataRow)) {
            return true;
        }
        List<WebElement> rows = Helper.getElements(SearchPatientPage.tableRows);
        if (rows.isEmpty()) return true;

        for (WebElement row : rows) {
            String rowText = row.getText().toLowerCase().trim();
            if (rowText.contains("no data")
             || rowText.contains("no matching")
             || rowText.contains("no records")
             || rowText.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
