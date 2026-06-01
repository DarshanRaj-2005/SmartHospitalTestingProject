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
	}

	@When("the user searches medicine {string}")
	public void the_user_searches_medicine(String medicine) {
		medicineAction.searchMedicine(medicine);
	}

	@Then("the medicine {string} status be {string}")
	public void the_medicine_status_be(String medicineName, String status) {

		if (status.equalsIgnoreCase("present")) {

			String actualMedicine = medicineAction.verifySearchedMedicine(medicineName);

			Assert.assertTrue(actualMedicine.contains(medicineName), "Medicine not found in the table");

		} else if (status.equalsIgnoreCase("not present")) {

			String actualMessage = medicineAction.verifyMedicineNotFoundMessage();

			Assert.assertTrue(actualMessage.contains("No data available in table"),
					"Expected no data message but got: " + actualMessage);
		}
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

	@Then("the message displayed as medicine deleted successfully")
	public void the_message_displayed_as_medicine_deleted_successfully() {

		String actualMessage = medicineAction.verifyDeleteConfirmation();
		String expectedMessage = "Record Deleted Successfully";

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Expected message: " + expectedMessage + " \nActual message: " + actualMessage);
	}

	@When("the user clicks the Show button on any available medicine")
	public void the_user_clicks_the_show_button_on_any_available_medicine() {
		medicineAction.clickShowButtonOnAnyMedicine();
	}

	@Then("the medicine details page should be displayed")
	public void the_medicine_details_page_should_be_displayed() {
		Assert.assertTrue(medicineAction.isMedicineDetailsPageDisplayed(), "Medicine details page is not displayed");
	}

	@Then("the stock entry details should be visible")
	public void the_stock_entry_details_should_be_visible() {
		Assert.assertTrue(medicineAction.isStockEntryVisible(), "Stock entry details are not visible");
	}

}
