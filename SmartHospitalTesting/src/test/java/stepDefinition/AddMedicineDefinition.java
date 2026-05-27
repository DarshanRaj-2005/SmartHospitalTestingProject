package stepDefinition;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import Utilities.Data_Provider;
import actions.AddMedicineAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddMedicineDefinition {

	AddMedicineAction addMedicineAction = new AddMedicineAction();

	@Then("the medicine stock page should be displayed")
	public void the_medicine_stock_page_should_be_displayed() {

		Assert.assertTrue(addMedicineAction.isMedicineStockPageDisplayed());
	}

	@When("the user clicks the Add Medicines button")
	public void the_user_clicks_the_add_medicines_button() {

		addMedicineAction.clickAddMedicineButton();

		System.out.println("Clicked Add Medicines button");
	}

	@Then("the Add Medicine tab should be displayed")
	public void the_add_medicine_tab_should_be_displayed() {

		Assert.assertTrue(addMedicineAction.isAddMedicineTabDisplayed());
	}
	@When("the user enters valid add medicine details")
	public void the_user_enters_valid_add_medicine_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		addMedicineAction.enterMedicineName(data.get("medicineName"));

		addMedicineAction.selectMedicineCategory(data.get("medicineCategory"));

		addMedicineAction.selectMedicineCompany(data.get("medicineCompany"));

		addMedicineAction.enterMedicineComposition(data.get("medicineComposition"));

		addMedicineAction.selectMedicineGroup(data.get("medicineGroup"));

		addMedicineAction.selectUnit(data.get("unit"));

		addMedicineAction.enterMinLevel(data.get("minLevel"));

		addMedicineAction.enterReorderLevel(data.get("reorderLevel"));

		addMedicineAction.enterTax(data.get("tax"));

		addMedicineAction.enterBoxPacking(data.get("boxPacking"));

		addMedicineAction.enterVat(data.get("vat"));

		addMedicineAction.enterRackNumber(data.get("rackNumber"));

		addMedicineAction.enterNote(data.get("note"));
	}

	@When("the user enters add medicine details from excel")
	public void the_user_enters_add_medicine_details_from_excel() throws IOException {

		String path = System.getProperty("user.dir")
		        + "/src/test/resources/test_datas/AddMedicineData.xlsx";

		String[][] data =
		        Data_Provider.getExcelData(path, "MedicineData");

		addMedicineAction.enterMedicineName(data[0][0]);

		addMedicineAction.selectMedicineCategory(data[0][1]);

		addMedicineAction.selectMedicineCompany(data[0][2]);

		addMedicineAction.enterMedicineComposition(data[0][3]);

		addMedicineAction.selectMedicineGroup(data[0][4]);

		addMedicineAction.selectUnit(data[0][5]);

		addMedicineAction.enterMinLevel(data[0][6]);

		addMedicineAction.enterReorderLevel(data[0][7]);

		addMedicineAction.enterTax(data[0][8]);

		addMedicineAction.enterBoxPacking(data[0][9]);

		addMedicineAction.enterVat(data[0][10]);

		addMedicineAction.enterRackNumber(data[0][11]);

		addMedicineAction.enterNote(data[0][12]);
	}

	@When("the user clicks on Add Medicine Save button")
	public void the_user_clicks_on_add_medicine_save_button() {

		addMedicineAction.clickSaveButton();

		System.out.println("Clicked Save button");
	}

	@Then("the medicine details should be added successfully")
	public void the_medicine_details_should_be_added_successfully() {

		Assert.assertTrue(
				addMedicineAction.verifyMedicineAdded(),
				"Medicine details are not added successfully");

		System.out.println("Medicine added successfully");
	}

	@Then("the medicine name required validation message should be displayed")
	public void the_medicine_name_required_validation_message_should_be_displayed() {

	    String actualMessage =
	            addMedicineAction.getMedicineNameValidationMessage();

	    Assert.assertEquals(
	            actualMessage,
	            "Medicine Name field is required");

	    System.out.println(actualMessage);
	}
}