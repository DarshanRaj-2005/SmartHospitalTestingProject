package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import actions.AddambulanceAction;

public class AddambulanceStepDefinition {

	@When("the user clicks Ambulance link")
	public void the_user_clicks_ambulance_link() {
		AddambulanceAction.clickAddambulance();
	}

	@Then("the user redirected to ambulance page")
	public void the_user_redirected_to_ambulance_page() {

		AddambulanceAction.checkTitle();
	}

	@Then("the user clicks the add ambulance link")
	public void the_user_clicks_the_add_ambulance_link() {
		AddambulanceAction.clickAddambulanceCall();
	}

	@Then("the user redirected to getcallambulance page")
	public void the_user_redirected_to_getcallambulance_page() {
		AddambulanceAction.checkmodelText();
	}

	@Then("the user enters ambulance call details")
	public void the_user_enters_ambulance_call_details(DataTable dataTable){

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		Map<String, String> ambulance = data.get(0);

		AddambulanceAction.enterAmbulanceDetail(

				ambulance.get("patient"), ambulance.get("vehicleModel"), ambulance.get("date"),
				ambulance.get("chargeCategory"), ambulance.get("chargeName"), ambulance.get("note"),
				ambulance.get("paymentMode"));
	}

	@Then("the user clicks save button")
	public void the_user_clicks_save_button() {
		AddambulanceAction.clickSave();
	}

	@Then("the ambulance call should be added successfully")
	public void the_ambulance_call_should_be_added_successfully() {
		AddambulanceAction.checksuccess();
	}

	@Then("the system should show validation error messages")
	public void the_system_should_show_validation_error_messages() {
		AddambulanceAction.checkerror();
	}

	@Then("the system should show invalid charge name field required message")
	public void the_system_should_show_invalid_standard_charge_message() {
		AddambulanceAction.checkInvalidAmount();
	}

}