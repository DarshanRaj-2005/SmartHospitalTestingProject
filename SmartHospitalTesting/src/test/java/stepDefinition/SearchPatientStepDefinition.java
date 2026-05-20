package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import actions.SearchPatientActions;
import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;
import Utilities.Helper;

public class SearchPatientStepDefinition {

    private SearchPatientActions searchPatientAction;

    private WebDriver driver() {
        return Driver.getDriver();
    }

    @Given("User is on Patient List page")
    public void user_is_on_patient_list_page() {
        searchPatientAction = new SearchPatientActions(driver());

        driver().get(ConfigReader.getUrl());

        Helper.waitForElementClickable(
                By.xpath("//*[contains(text(),'Super Admin')]"));
        driver().findElement(
                By.xpath("//*[contains(text(),'Super Admin')]")).click();

        Helper.waitForElementClickable(
                By.xpath("//button[text()='Sign In']"));
        driver().findElement(
                By.xpath("//button[text()='Sign In']")).click();

        searchPatientAction.clickPatientSidebarLink();
        searchPatientAction.waitForPatientListToLoad();
    }

    // Scenario Outline step — handles both valid and invalid names
    @When("User searches for patient name {string}")
    public void user_searches_for_patient_name(String patientName) {
        searchPatientAction.searchByName(patientName);
    }

    // Old scenario steps kept for backward compatibility
    @When("User enters patient name in search box")
    public void user_enters_patient_name_in_search_box() {
        searchPatientAction.enterValidPatientName();
    }

    @When("User enters invalid patient name")
    public void user_enters_invalid_patient_name() {
        searchPatientAction.enterInvalidPatientName();
    }

    @And("clicks on Search button")
    public void clicks_on_search_button() {
        searchPatientAction.clickSearchButton();
    }

    // Scenario Outline assertion — "valid" or "invalid" from Examples table
    @Then("{string} result should be displayed")
    public void result_should_be_displayed(String resultType) {
        if (resultType.equalsIgnoreCase("valid")) {
            Assert.assertTrue(
                    searchPatientAction.verifyMatchingPatientDisplayed(),
                    "Matching patient details were not displayed after valid search.");
        } else if (resultType.equalsIgnoreCase("invalid")) {
            Assert.assertTrue(
                    searchPatientAction.verifyNoRecordsFound(),
                    "No records found message was not displayed for invalid search.");
        } else {
            Assert.fail("Unknown result type: '" + resultType
                      + "'. Expected 'valid' or 'invalid'.");
        }
    }

    // Old scenario assertions kept for backward compatibility
    @Then("matching patient details should be displayed")
    public void matching_patient_details_should_be_displayed() {
        Assert.assertTrue(
                searchPatientAction.verifyMatchingPatientDisplayed(),
                "Matching patient details were not displayed after search.");
    }

    @Then("no records found message should be displayed")
    public void no_records_found_message_should_be_displayed() {
        Assert.assertTrue(
                searchPatientAction.verifyNoRecordsFound(),
                "No records found message was not displayed for invalid search.");
    }
}
