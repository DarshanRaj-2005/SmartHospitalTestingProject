package stepDefinition;

import org.testng.Assert;

import actions.SearchAmbulanceRecordAction;
import io.cucumber.java.en.Then;

public class SearchAmbulanceRecordStepDefinition {
	
	@Then("the user enters {string} in the search field")
	public void the_user_enters_valid_details_in_the_search_field(String string) {
		SearchAmbulanceRecordAction.typeInput(string);
	}

	@Then("the system should show the {string}")
	public void the_system_should_show_the_matching_data(String string) {
		Assert.assertEquals(SearchAmbulanceRecordAction.getMatchingValue(string),string);
	}

	@Then("the system should show the no data available error message")
	public void the_system_should_show_the_no_data_available_error_message() {
	    Assert.assertEquals(SearchAmbulanceRecordAction.getErrorMessage(),"No data available in table");
	}

}
