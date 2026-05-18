package stepDefinition;

import actions.AddNewStock;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewItemStock {

    AddNewStock addNewStockActions =new AddNewStock();

    @When("the user clicks on Inventory")
    public void the_user_clicks_on_inventory() {

        addNewStockActions.clickInventory();
    }

    @When("the user clicks the Add Item Stock button")
    public void the_user_clicks_the_add_item_stock_button() {
        addNewStockActions.clickAddItemStock();
    }

    @When("the user selects Item Category, Item, Supplier, and Store")
    public void the_user_selects_item_category_item_supplier_and_store() {

    	addNewStockActions.selecttheitems();;
    }

    @When("the user fills the details such as Quantity {string} and Purchase Price {string} and Description {string}")
    public void the_user_fills_the_details_such_as_quantity_and_purchase_price_and_description(String quantity,String purchasePrice, String description) {

        addNewStockActions.fillStockDetails(quantity,purchasePrice,description);
    }

        

    @When("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {

        addNewStockActions.clickSaveButton();
    }

    @Then("the item stock should be added successfully")
    public void the_item_stock_should_be_added_successfully() {

        System.out.println(
                "Item stock added successfully");
    }
    @Then("the item stock should not  be added  successfully")
    public void the_item_stock_should_not_be_added_successfully() {
    	addNewStockActions.HandleTheMessage();
    	
    }
}