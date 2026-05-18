package stepDefinition;

import org.testng.annotations.Parameters;

import actions.Additemaction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemdefition {
	
	@Given("the user clicks the Add new item button and click add item")
	public void the_user_clicks_the_add_new_item_button_and_click_add_item() {
	   Additemaction.Userclick_item();
	}
	@When("the user enters item details {string} {string} {string} {string}")
	public void the_user_enters_item_details(String name, String category, String unit, String description) {

	    Additemaction.Enteringdetails(name, category, unit, description);
	}

	
	@When("the user clicks the save button")
	public void the_user_clicks_the_save_button() {
		
		Additemaction.save();
	   
	}

	@Then("the item should be added successfully")
	public void the_item_should_be_added_successfully() {
	    Additemaction.assertfor();
	}
	
	

}
