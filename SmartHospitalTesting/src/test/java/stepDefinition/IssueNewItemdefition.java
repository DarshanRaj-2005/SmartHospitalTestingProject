package stepDefinition;

import actions.IssueNewItemActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.testng.Assert;

public class IssueNewItemdefition {

    IssueNewItemActions issueNewItemActions = new IssueNewItemActions();

    @When("the user clicks the Issue Item button and the Issue New Item button")
    public void the_user_clicks_the_issue_item_button_and_the_issue_new_item_button() {
        issueNewItemActions.clickIssueButtons();
    }

    @When("the user select the usertype issuedate and retrundate and itemcategory and item")
    public void the_user_select_the_usertype_issuedate_and_retrundate_and_itemcategory_and_item(
            DataTable dataTable) {

        List<List<String>> data = dataTable.asLists(String.class);
        String accountType  = data.get(0).get(0);
        String issueDate    = data.get(0).get(1);
        String returnDate   = data.get(0).get(2);
        String itemCategory = data.get(0).get(3);
        String item         = data.get(0).get(4);

        // ✅ FIX 5: Removed Thread.sleep(9000) — replaced by explicit waits inside Actions
        issueNewItemActions.selectIssueDetails(accountType, issueDate, returnDate, itemCategory, item);
    }

    @When("the user Enters the quality and note")
    public void the_user_enters_the_quality_and_note(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String quantity = data.get(0).get(0);
        String note     = data.get(0).get(1);
        issueNewItemActions.enterDetails(quantity, note);
        issueNewItemActions.clickSubmitButton();
    }

    @Then("the issue item should be added successfully")
    public void the_issue_item_should_be_added_successfully() {
      issueNewItemActions.verifySuccessMessage();
    }
    
    @And("the user skips entering mandatory issue item details")
    public void the_user_skips_entering_mandatory_issue_item_details() {

        System.out.println("Skipping mandatory fields for negative test case");

        // Do NOT call any select methods
    }
    
    @Then("the issue item should not be added and show missing field details")
    public void the_issue_item_should_not_be_added_and_show_missing_field_details() {
    	issueNewItemActions
    	.HandleTheMessage();
       
    }
}