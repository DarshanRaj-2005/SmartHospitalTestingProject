package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import actions.BloodStockAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BloodStockStepDefinition {
	BloodStockAction StockAction = new BloodStockAction();
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
		 Assert.assertTrue(
	                BloodStockAction.isBloodDonorPopupDisplayed());
	    }
	

	@When("the user enters valid blood donor details")
	public void the_user_enters_valid_blood_donor_details(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> data =
	                dataTable.asMaps(String.class, String.class); 
		String bloodDonor =
	                data.get(0).get("BloodDonor");

	        String donateDate =
	                data.get(0).get("DonateDate");

	        String bag =
	                data.get(0).get("Bag");

	        String volume =
	                data.get(0).get("Volume");

	        String chargeCategory =
	                data.get(0).get("ChargeCategory");

	        String chargeName =
	                data.get(0).get("ChargeName");

	        BloodStockAction.selectBloodDonor(bloodDonor);

	        BloodStockAction.enterDonateDate(donateDate);

	        BloodStockAction.enterBag(bag);


	        BloodStockAction.selectChargeCategory(chargeCategory);

	        BloodStockAction.selectChargeName(chargeName);
	}

	@Then("the blood donor details should be added successfully")
	public void the_blood_donor_details_should_be_added_successfully() {
		 Assert.assertTrue(BloodStockAction.isBloodDonorAddedSuccessfully());
	}


}
