package stepDefinition;
import actions.MedicinestockAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MedicinestockDefinition {
	MedicinestockAction medicine = new MedicinestockAction();
	@Given("the user is on the Pharmacy Bill page")
	public void the_user_is_on_the_pharmacy_bill_page() {
	    
	}

	@When("the user clicks the Medicines button")
	public void the_user_clicks_the_medicines_button() {
	    
	}

	@Given("the user is on the medicine stock page")
	public void the_user_is_on_the_medicine_stock_page() {
	    
	}

	@When("the user searches for a medicine by name")
	public void the_user_searches_for_a_medicine_by_name() {
	    
	}

	@Then("the searched medicine should be displayed in the table")
	public void the_searched_medicine_should_be_displayed_in_the_table() {
	    
	}

	@When("the user selects a medicine from the medicine stock list")
	public void the_user_selects_a_medicine_from_the_medicine_stock_list() {
	   
	}

	@When("clicks the delete Selected button")
	public void clicks_the_delete_selected_button() {
	   
	}

	@When("the pop up appears for the deleting the medicine for confirmation")
	public void the_pop_up_appears_for_the_deleting_the_medicine_for_confirmation() {
	    
	}

	@When("the user clicks ok")
	public void the_user_clicks_ok() {
	    
	}

	@Then("the message appears as medicine deleted successfully")
	public void the_message_appears_as_medicine_deleted_successfully() {
	    
	}

}
