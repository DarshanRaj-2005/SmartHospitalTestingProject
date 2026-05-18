package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import actions.SearchPatientAction;
import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;
import Utilities.Helper;

public class SearchPatientStepDefinition {

    WebDriver driver = Driver.getDriver();

    SearchPatientAction searchPatientAction =
            new SearchPatientAction(driver);

   
    @Given("User is on Patient List page")
    public void user_is_on_patient_list_page() {

        driver.get(ConfigReader.getUrl());

        Helper.waitForElementClickable(
                By.xpath("//*[contains(text(),'Super Admin')]"));
        driver.findElement(
                By.xpath("//*[contains(text(),'Super Admin')]")).click();

        Helper.waitForElementClickable(
                By.xpath("//button[text()='Sign In']"));
        driver.findElement(
                By.xpath("//button[text()='Sign In']")).click();

        Helper.waitForVisibility(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));

        Helper.waitForElementClickable(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
        searchPatientAction.clickPatientSidebarLink();

   
        searchPatientAction.waitForPatientListToLoad();
    }

    @When("User enters patient name in search box")
    public void user_enters_patient_name_in_search_box() {
        searchPatientAction.enterValidPatientName();
    }

    @And("clicks on Search button")
    public void clicks_on_search_button() {
        searchPatientAction.clickSearchButton();
    }

    @Then("matching patient details should be displayed")
    public void matching_patient_details_should_be_displayed() {

        Assert.assertTrue(
                searchPatientAction.verifyMatchingPatientDisplayed(),
                "Matching patient details were not displayed after search.");
    }

    @When("User enters invalid patient name")
    public void user_enters_invalid_patient_name() {
        searchPatientAction.enterInvalidPatientName();
    }

    @Then("no records found message should be displayed")
    public void no_records_found_message_should_be_displayed() {

        Assert.assertTrue(
                searchPatientAction.verifyNoRecordsFound(),
                "No records found message was not displayed for invalid search.");
    }
}
