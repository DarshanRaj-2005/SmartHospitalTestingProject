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

        // Navigate to the login page URL
        Driver.getDriver().get(ConfigReader.getUrl());

        // Check if already logged in — if Super Admin button is NOT present,
        // user is already on dashboard (previous scenario left session active)
        boolean isLoginPage = !Driver.getDriver()
                .findElements(By.xpath("//*[contains(text(),'Super Admin')]"))
                .isEmpty();

        if (isLoginPage) {

            // Click Super Admin
            Driver.getDriver().findElement(
                    By.xpath("//*[contains(text(),'Super Admin')]")).click();

            // Click Sign In — no Helper.waitForElementClickable needed
            // because page is already loaded
            Driver.getDriver().findElement(
                    By.xpath("//button[text()='Sign In']")).click();
        }

        // Wait for sidebar Patient link — confirms dashboard is loaded
        Helper.waitForVisibility(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));

        // Click Patient in sidebar
        Helper.waitForElementClickable(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
        getAction().clickPatientSidebarLink();

        // Wait for Patient List page to fully load
        getAction().waitForPatientListToLoad();
    }

    @When("User enters patient name in search box")
    public void user_enters_patient_name_in_search_box() {
        getAction().enterValidPatientName();
    }

    @And("clicks on Search button")
    public void clicks_on_search_button() {
        getAction().clickSearchButton();
    }

    @Then("matching patient details should be displayed")
    public void matching_patient_details_should_be_displayed() {

        Assert.assertTrue(
                getAction().verifyMatchingPatientDisplayed(),
                "Matching patient details were not displayed after search.");
    }

    @When("User enters invalid patient name")
    public void user_enters_invalid_patient_name() {
        getAction().enterInvalidPatientName();
    }

    @Then("no records found message should be displayed")
    public void no_records_found_message_should_be_displayed() {

        Assert.assertTrue(
                getAction().verifyNoRecordsFound(),
                "No records found message was not displayed for invalid search.");
    }

}