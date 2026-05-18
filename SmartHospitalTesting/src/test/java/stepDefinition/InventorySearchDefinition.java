package stepDefinition;

import org.testng.Assert;

import actions.InventorySearchActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InventorySearchDefinition {

    InventorySearchActions actions = new InventorySearchActions();

    @When("the user searches items from excel")
    public void the_user_searches_items_from_excel() throws Exception {

        InventorySearchActions.searchValidItems();
    }

    @Then("the items should display successfully")
    public void the_items_should_display_successfully() {

        Assert.assertTrue(InventorySearchActions.notmatch,
                "Some items are not matching search text");

        System.out.println("✅ Search validation successful");
    }

    @When("the user searches the invalid data")
    public void the_user_searches_the_invalid_data() throws Exception {

        actions.searchInvalidItems();
    }

    @Then("show No data available in table")
    public void show_no_data_available_in_table() {

        boolean result = actions.isNoDataMessageDisplayed();

        Assert.assertTrue(result,
                "No data message not displayed correctly");

        System.out.println("✅ No data validation successful");
    }
}