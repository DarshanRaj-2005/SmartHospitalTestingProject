package stepDefinition;

import org.testng.Assert;

import actions.MedicinestockAction;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MedicinestockDefinition {

    MedicinestockAction medicineAction = new MedicinestockAction();

    @Given("the user is on the Pharmacy Bill page")
    public void the_user_is_on_the_pharmacy_bill_page() {
        String expectedURL = "https://demo.smart-hospital.in/admin/pharmacy/bill";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("the user is on the Pharmacy Bill page");
    }

    @When("the user clicks the Medicines button")
    public void the_user_clicks_the_medicines_button() {
        medicineAction.clickmedicinebutton();
    }

    @Given("the user is on the medicine stock page")
    public void the_user_is_on_the_medicine_stock_page() {
        String expectedURL = "https://demo.smart-hospital.in/admin/pharmacy/search";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("the user moved to the medicine stock page");
    }

    @When("the user searches medicine {string}")
    public void the_user_searches_medicine(String medicine) {
        medicineAction.searchMedicine(medicine);
    }

    @Then("the searched medicine {string} should be displayed in the table")
    public void the_searched_medicine_should_be_displayed_in_the_table(String searchedmedicine) {
        String actualMedicine = medicineAction.verifySearchedMedicine(searchedmedicine);
        Assert.assertTrue(actualMedicine.contains(searchedmedicine),
                "Medicine not found in the table");
    }

    @When("the user selects the medicine {string} from the medicine stock list")
    public void the_user_selects_the_medicine_from_the_medicine_stock_list(String medicine) {
        medicineAction.selectMedicine(medicine);
    }

    @When("clicks the delete Selected button")
    public void clicks_the_delete_selected_button() {
        medicineAction.clickDeleteButton();
    }

    @When("the user confirms the alert displayed")
    public void the_user_confirms_the_alert_displayed() {
        medicineAction.clickdeleteConfirm();
    }

    @Then("the message displayed as medicine deleteted successfully")
    public void the_message_displayed_as_medicine_deleteted_successfully() {
        String actualMessage = medicineAction.verifyDeleteConfirmation();
        String expectedMessage = "Record Deleted Successfully";

        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage + " \nActual message: " + actualMessage);
    }
}