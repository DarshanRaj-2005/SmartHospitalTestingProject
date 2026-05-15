package stepDefinition;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import actions.AddPatientAction;
import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;
import Utilities.Helper;

public class AddPatientStepDefinition {

    WebDriver driver = Driver.getDriver();

    AddPatientAction addPatientAction =
            new AddPatientAction(driver);

    // Stores the patient name entered in Step 4 for use in Step 6
    private String enteredPatientName = "";

    // =====================================================================
    // Step 1 : Given Admin is on the Dashboard page
    // Action  : Login → click Super Admin → Sign In → wait for sidebar
    // =====================================================================
    @Given("Admin is on the Dashboard page")
    public void admin_is_on_the_dashboard_page() {

        driver.get(ConfigReader.getUrl());

        Helper.waitForElementClickable(
                By.xpath("//*[contains(text(),'Super Admin')]"));
        driver.findElement(
                By.xpath("//*[contains(text(),'Super Admin')]")).click();

        Helper.waitForElementClickable(
                By.xpath("//button[text()='Sign In']"));
        driver.findElement(
                By.xpath("//button[text()='Sign In']")).click();

        // Confirm dashboard loaded by waiting for sidebar Patient link
        Helper.waitForVisibility(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
    }

    // =====================================================================
    // Step 2 : Then admin clicks the patient category
    // Action  : Click "Patient" in the left sidebar using JS click
    // =====================================================================
    @Then("admin clicks the patient category")
    public void admin_clicks_the_patient_category() {

        Helper.waitForElementClickable(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
        addPatientAction.clickPatientCategory();
    }

    // =====================================================================
    // Step 3 : And Admin Clicks the Add new Patient
    // Action  : Click "+ Add New Patient" button → wait for modal to open
    // =====================================================================
    @And("Admin Clicks the Add new Patient")
    public void admin_clicks_the_add_new_patient() {

        Helper.waitForElementClickable(
                By.xpath("//a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"));
        addPatientAction.clickAddNewPatientButton();

        // Wait for the modal popup to be fully loaded before proceeding
        // This is critical — the form is inside a MODAL, not a new page
        addPatientAction.waitForModalToLoad();
    }

    // =====================================================================
    // Step 4 : When Admin enters patient details (DataTable)
    // Note    : Modal is already confirmed open in Step 3
    //           All form locators are scoped inside the modal container
    // =====================================================================
    @When("Admin enters patient details")
    public void admin_enters_patient_details(DataTable dataTable) {

        List<Map<String, String>> patientData =
                dataTable.asMaps(String.class, String.class);

        // Store patient name so Step 6 can verify it in the list
        enteredPatientName = patientData.get(0).get("PatientName");

        addPatientAction.enterPatientDetails(patientData);
    }

    // =====================================================================
    // Step 5 : And clicks on Save button
    // =====================================================================
    @And("clicks on Save button")
    public void clicks_on_save_button() {

        addPatientAction.clickSaveButton();
    }

    // =====================================================================
    // Step 6 : Then patient record should be created successfully
    // Assert  : Search the patient list table for the entered patient name
    // =====================================================================
    @Then("patient record should be created successfully")
    public void patient_record_should_be_created_successfully() {

        Assert.assertTrue(
                addPatientAction.verifyPatientInList(enteredPatientName),
                "Patient '" + enteredPatientName + "' was not found in the patient list after saving.");
    }
}
