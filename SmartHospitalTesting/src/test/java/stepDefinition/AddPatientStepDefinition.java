package stepDefinition;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import actions.AddPatientActions;
import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;
import Utilities.Helper;

public class AddPatientStepDefinition {

    private static final Logger log = LogManager.getLogger(AddPatientStepDefinition.class);

    private AddPatientActions action;

    private AddPatientActions getAction() {
        if (action == null) action = new AddPatientActions();
        return action;
    }

    // =====================================================================
    // BACKGROUND STEP — runs before every scenario in both feature files
    // =====================================================================

    @Given("Admin is on the Dashboard page")
    public void admin_is_on_the_dashboard_page() {
        log.info("Given: Admin is on the Dashboard page");
        loginAsAdmin();
    }

    private void loginAsAdmin() {
        log.info("Navigating to login page: " + ConfigReader.getUrl());
        Driver.getDriver().get(ConfigReader.getUrl());

        Helper.waitForElementClickable(By.xpath("//*[contains(text(),'Super Admin')]"));
        Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Super Admin')]")).click();

        Helper.waitForElementClickable(By.xpath("//button[text()='Sign In']"));
        Driver.getDriver().findElement(By.xpath("//button[text()='Sign In']")).click();

        Helper.waitForVisibility(By.xpath(
                "//ul[contains(@class,'sidebar-menu')]"
              + "//li/a[.//span[normalize-space(text())='Patient']]"));

        log.info("Login successful — dashboard loaded");
    }

    // =====================================================================
    // SCENARIO 1 — Add patient with valid details
    // =====================================================================

    @Then("admin clicks the patient category")
    public void admin_clicks_the_patient_category() {
        log.info("Step: Admin clicks Patient category");
        Helper.waitForElementClickable(By.xpath(
                "//ul[contains(@class,'sidebar-menu')]"
              + "//li/a[.//span[normalize-space(text())='Patient']]"));
        getAction().clickPatientCategory();
    }

    @And("Admin Clicks the Add new Patient")
    public void admin_clicks_the_add_new_patient() {
        log.info("Step: Admin clicks Add New Patient button");
        Helper.waitForElementClickable(By.xpath(
                "//div[contains(@class,'box-header')]"
              + "//a[contains(@class,'addpatient') "
              + "or contains(text(),'Add New Patient') "
              + "or contains(text(),'Add Patient')]"));
        getAction().clickAddNewPatientButton();
        getAction().waitForModalToLoad();
    }

    @When("Admin enters patient details")
    public void admin_enters_patient_details(DataTable dataTable) {
        log.info("Step: Admin enters patient details from DataTable");
        List<Map<String, String>> patientData = dataTable.asMaps(String.class, String.class);
        getAction().enterPatientDetails(patientData);
    }

    @And("clicks on Save button")
    public void clicks_on_save_button() {
        log.info("Step: Clicks Save button");
        getAction().clickSaveButton();
    }

    @Then("patient record should be created successfully")
    public void patient_record_should_be_created_successfully() {
        log.info("Step: Verifying patient record created");
        Assert.assertTrue(getAction().verifyPatientAdded(),
                "Patient record was not created successfully.");
        log.info("Patient record verified successfully");
    }

    // =====================================================================
    // SCENARIO 2 — Mandatory field validation
    // =====================================================================

    @When("Admin leaves mandatory fields empty")
    public void admin_leaves_mandatory_fields_empty() {
        log.info("Step: Admin leaves mandatory Name field empty");
        getAction().leaveMandatoryFieldsEmpty();
    }

    @Then("validation message should be displayed")
    public void validation_message_should_be_displayed() {
        log.info("Step: Verifying validation message is displayed");
        Assert.assertTrue(getAction().verifyValidationMessage(),
                "Validation message was not displayed after Save with empty Name.");
        log.info("Validation message verified");
    }

    // =====================================================================
    // SCENARIO 3 + 4 — DOB auto-fill and re-entry
    // =====================================================================

    @When("Admin enters only DOB as {string}")
    public void admin_enters_only_dob_as(String dob) {
        log.info("Step: Admin enters DOB: " + dob);
        getAction().enterDOB(dob);
    }

    @Then("age fields Year Month Day should be auto filled")
    public void age_fields_year_month_day_should_be_auto_filled() {
        log.info("Step: Verifying age fields are auto-filled");
        Assert.assertTrue(getAction().verifyAgeFieldsAutoFilled(),
                "Age fields (Year/Month/Day) were not auto-filled after entering DOB.");
        log.info("Age fields auto-fill verified");
    }

    @And("Admin clears DOB and re-enters {string}")
    public void admin_clears_dob_and_re_enters(String newDOB) {
        log.info("Step: Admin clears DOB and re-enters: " + newDOB);
        getAction().clearDOBAndReEnter(newDOB);
    }
}