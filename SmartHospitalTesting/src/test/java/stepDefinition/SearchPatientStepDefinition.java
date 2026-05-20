package stepDefinition;

import org.openqa.selenium.By;
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

    private SearchPatientActions getAction() {
        return new SearchPatientActions(Driver.getDriver());
    }

    @Given("User is on Patient List page")
    public void user_is_on_patient_list_page() {

        Driver.getDriver().get(ConfigReader.getUrl());

        // Wait for page to fully load before checking login state
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

       
        boolean isLoginPage = !Driver.getDriver()
                .findElements(By.xpath("//*[contains(text(),'Super Admin')]"))
                .isEmpty();

        if (isLoginPage) {
            Driver.getDriver().findElement(
                    By.xpath("//*[contains(text(),'Super Admin')]")).click();
            Driver.getDriver().findElement(
                    By.xpath("//button[text()='Sign In']")).click();
        }

        // Wait for sidebar — confirms dashboard loaded
        Helper.waitForVisibility(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));

        Helper.waitForElementClickable(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));

        getAction().clickPatientSidebarLink();
        getAction().waitForPatientListToLoad();
    }

    // Single step receives SearchName from Examples table
    @When("User searches for patient name {string}")
    public void user_searches_for_patient_name(String searchName) {
        getAction().enterSearchName(searchName);
    }

    @And("clicks on Search button")
    public void clicks_on_search_button() {
        getAction().clickSearchButton();
    }

    // Single step handles both valid and invalid using ExpectedResult from Examples
    @Then("{string} result should be displayed")
    public void result_should_be_displayed(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("valid")) {
            Assert.assertTrue(
                    getAction().verifyMatchingPatientDisplayed(),
                    "Matching patient details were not displayed after search.");

        } else if (expectedResult.equalsIgnoreCase("invalid")) {
            Assert.assertTrue(
                    getAction().verifyNoRecordsFound(),
                    "No records found message was not displayed for invalid search.");
        }
    }
}