package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.Helper;
import pages.ComponentIssuePage;

public class ComponentIssueAction {

    Logger logger = LogManager.getLogger(ComponentIssueAction.class);

    public void clickBloodComponentDetails() {

        logger.info("Navigating to Component Issue Details");
        Helper.waitForElementClickable(ComponentIssuePage.componentIssue);
        Helper.jsClick(ComponentIssuePage.componentIssue);
    }

    public boolean verifyBloodIssuePage() {

        logger.info("Verifying Component Issue page");
        Helper.waitForVisibility(ComponentIssuePage.componentIssueHeading);
        return Helper.isDisplayed(ComponentIssuePage.componentIssueHeading);
    }

    public void searchBloodIssue(String searchText) {

        logger.info("Searching blood issue: " + searchText);
        Helper.waitForVisibility(ComponentIssuePage.searchBox);
        Helper.clearAndEnterText(ComponentIssuePage.searchBox, searchText);
    }

    public boolean verifySearchResult(String searchText) {

        logger.info("Verifying search result: " + searchText);
        Helper.waitForVisibility(ComponentIssuePage.searchedRecord(searchText));
        return Helper.isDisplayed(ComponentIssuePage.searchedRecord(searchText));
    }

    public boolean verifyNoMatchingRecords() {

        logger.info("Verifying no matching records found");
        Helper.waitForVisibility(ComponentIssuePage.noMatchingRecords);
        return Helper.isDisplayed(ComponentIssuePage.noMatchingRecords);
    }
}