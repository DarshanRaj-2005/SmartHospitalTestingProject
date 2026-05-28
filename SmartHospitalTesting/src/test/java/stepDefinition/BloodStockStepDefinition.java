package stepDefinition;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import actions.BloodStockAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BloodStockStepDefinition {

	BloodStockAction StockAction = new BloodStockAction();

	Logger logger = LogManager.getLogger(BloodStockStepDefinition.class);

	String bag;

	@Then("the Blood Stock Status page should be displayed")
	public void the_blood_stock_status_page_should_be_displayed() {
		Assert.assertTrue(StockAction.isBloodStockStatusPageDisplayed());
	}

	@When("the user selects blood group {string}")
	public void the_user_selects_blood_group(String bloodGroup) {
		StockAction.selectBloodGroup(bloodGroup);
	}

	@Then("the corresponding blood bag details should be displayed and the corresponding blood component details should be displayed")
	public void the_corresponding_blood_bag_details_should_be_displayed_and_the_corresponding_blood_component_details_should_be_displayed() {
		Assert.assertTrue(StockAction.isBloodBagDetailsDisplayed());
		Assert.assertTrue(StockAction.isBloodComponentDetailsDisplayed());
	}

	@When("the user clicks on add icon")
	public void the_user_clicks_on_add_icon() {
		BloodStockAction.clickAddIcon();
	}

	@Then("the Blood Donor Details popup should be displayed")
	public void the_blood_donor_details_popup_should_be_displayed() {
		Assert.assertTrue(BloodStockAction.isBloodDonorPopupDisplayed());
	}

	@When("the user enters valid blood donor details")
	public void the_user_enters_valid_blood_donor_details(io.cucumber.datatable.DataTable dataTable) {

		logger.info("Enter Blood Donor Details");

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		String bloodDonor = data.get(0).get("BloodDonor");
		String donateDate = data.get(0).get("DonateDate");
		bag = data.get(0).get("Bag");
		String chargeCategory = data.get(0).get("ChargeCategory");
		String chargeName = data.get(0).get("ChargeName");
		BloodStockAction.selectBloodDonor(bloodDonor);
		BloodStockAction.enterDonateDate(donateDate);
		BloodStockAction.enterBag(bag);
		BloodStockAction.selectChargeCategory(chargeCategory);
		BloodStockAction.selectChargeName(chargeName);
	}

	@When("the user clicks on donor Save button")
	public void the_user_clicks_on_donor_save_button() {
		BloodStockAction.clickCalculateButton();
		BloodStockAction.clickSaveButton();
	}

	@Then("the blood donor details should be added successfully")
	public void the_blood_donor_details_should_be_added_successfully() {
		Assert.assertTrue(BloodStockAction.isBagNumberDisplayed(bag));
		logger.info("Donor Details added.");
	}

	@Then("the Blood Issue page should be displayed")
	public void the_blood_issue_page_should_be_displayed() {
		Assert.assertTrue(BloodStockAction.isBloodIssuePageDisplayed());
		logger.info("Blood Issue Page is displayed.");

	}

	@When("the user clicks issue button for bag number {string}")
	public void the_user_clicks_issue_button_for_bag_number(String bag) {
		BloodStockAction.clickIssueButton(bag);
	}
	@When("the user clicks issue button for below bag number")
	public void the_user_clicks_issue_button_for_below_bag_number(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> data =dataTable.asMaps(String.class, String.class);
		    String bag =data.get(0).get("Bag");
		    BloodStockAction.clickIssueButton(bag);
	}
	@Then("the donor details validation messages should be displayed")
	public void the_donor_details_validation_messages_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
		logger.info("New Donor is not added.");
	    List<String> expectedMessages = dataTable.asList(String.class);
	    List<String> actualMessages = StockAction.getValidationMessages();
	    Assert.assertEquals(actualMessages, expectedMessages);
	}
	@Then("the user clicks Save button without entering donor details")
	public void the_user_clicks_save_button_without_entering_donor_details() {
		BloodStockAction.clickSaveButton();
	}




}
