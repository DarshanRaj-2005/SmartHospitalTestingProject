package stepDefinition;

import actions.AddMedicineaction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddMedicineDefinition {

    AddMedicineaction action = new AddMedicineaction();

    @When("the user clicks the Add Medicine button")
    public void click_add_medicine() {
        action.clickAddMedicine();
    }

    @When("the user enters medicine details from row {int}")
    public void enter_medicine_from_excel_row(Integer rowNum) {
        action.enterMedicineFromExcelRow(rowNum);
    }

    @When("the user clicks the Save button")
    public void click_save() {
        action.clickSave();
    }

    @Then("the medicine should be added successfully")
    public void verify_success() {
        Assert.assertTrue(action.getSuccessMessage().length() > 0);
    }

    @Then("the success message should display {string}")
    public void verify_success_message(String expected) {
        Assert.assertEquals(action.getSuccessMessage(), expected);
    }

    @Then("the medicine {string} should appear in the medicine list")
    public void verify_medicine_present(String name) {
        Assert.assertTrue(action.isMedicinePresent(name));
    }

    @Then("the error message should display {string}")
    public void verify_error_message(String expected) {
        Assert.assertEquals(action.getErrorMessage(), expected);
    }
}