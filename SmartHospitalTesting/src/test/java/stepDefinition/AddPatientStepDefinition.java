package stepDefinition;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    WebDriver driver = Driver.getDriver();

    AddPatientActions addPatientAction =
            new AddPatientActions(driver);
   
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

        Helper.waitForVisibility(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
    }

    @Then("admin clicks the patient category")
    public void admin_clicks_the_patient_category() {

        Helper.waitForElementClickable(
                By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                       + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']"));
        addPatientAction.clickPatientCategory();
    }

    @And("Admin Clicks the Add new Patient")
    public void admin_clicks_the_add_new_patient() {

        Helper.waitForElementClickable(
                By.xpath("//a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"));
        addPatientAction.clickAddNewPatientButton();
        addPatientAction.waitForModalToLoad();
    }

    @When("Admin enters patient details")
    public void admin_enters_patient_details(DataTable dataTable) {

        List<Map<String, String>> patientData =
                dataTable.asMaps(String.class, String.class);
        addPatientAction.enterPatientDetails(patientData);
    }
    @And("clicks on Save button")
    public void clicks_on_save_button() {
        addPatientAction.clickSaveButton();
    }

    @Then("patient record should be created successfully")
    public void patient_record_should_be_created_successfully() {

        Assert.assertTrue(
                addPatientAction.verifyPatientAdded(),
                "Patient record was not created successfully.");
    }

    
    @Given("Admin is on the Add Patient page")
    public void admin_is_on_the_add_patient_page() {

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
        addPatientAction.clickPatientCategory();

        Helper.waitForElementClickable(
                By.xpath("//a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"));
        addPatientAction.clickAddNewPatientButton();

        addPatientAction.waitForModalToLoad();
    }

    @When("Admin leaves mandatory fields empty")
    public void admin_leaves_mandatory_fields_empty() {

        addPatientAction.leaveMandatoryFieldsEmpty();
    }

 
    @Then("validation message should be displayed")
    public void validation_message_should_be_displayed() {

        Assert.assertTrue(
                addPatientAction.verifyValidationMessage(),
                "Validation message was not displayed after clicking Save with empty mandatory fields.");
    }
}
