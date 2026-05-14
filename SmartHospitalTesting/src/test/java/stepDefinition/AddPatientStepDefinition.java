package stepDefinition;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import actions.AddPatientAction;
import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPatientStepDefinition {

    WebDriver driver = Driver.getDriver();

    AddPatientAction addPatientAction =
            new AddPatientAction(driver);

    @Given("Admin is on the Add Patient page")
    public void admin_is_on_the_add_patient_page() {

        driver.get("https://yourapplicationurl.com/add-patient");
    }

    @When("Admin enters patient details")
    public void admin_enters_patient_details(DataTable dataTable) {

        List<Map<String, String>> patientData =
                dataTable.asMaps(String.class, String.class);

        addPatientAction.enterPatientDetails(patientData);
    }

    @When("clicks on Save button")
    public void clicks_on_save_button() {

        addPatientAction.clickSaveButton();
    }

    @Then("patient record should be created successfully")
    public void patient_record_should_be_created_successfully() {

        Assert.assertTrue(
                addPatientAction.verifyPatientAdded());
    }
}