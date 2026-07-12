package stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import actions.ComponentIssueAction;
import actions.DonorManagementAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComponentIssueStepDefinition {

    ComponentIssueAction componentIssueAction = new ComponentIssueAction();
    DonorManagementAction donorManagementAction = new DonorManagementAction();

    String searchValue;

    @When("the user clicks on Blood Bank Status")
    public void the_user_clicks_on_blood_bank_status() {

        donorManagementAction.clickBloodBankMenu();
        componentIssueAction.clickBloodComponentDetails();
    }

    @Then("the Blood Bank Status page should be displayed")
    public void the_blood_bank_status_page_should_be_displayed() {

        Assert.assertTrue(componentIssueAction.verifyBloodIssuePage(),
                "Component Issue page is not displayed");
    }

    @When("the user searches blood issue details")
    public void the_user_searches_blood_issue_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        searchValue = data.get(0).values().iterator().next();

        componentIssueAction.searchBloodIssue(searchValue);
    }

    @Then("the corresponding blood issue record should be displayed")
    public void the_corresponding_blood_issue_record_should_be_displayed() {

        Assert.assertTrue(componentIssueAction.verifySearchResult(searchValue),
                "Search result is not displayed");
    }

    @When("the user clicks on Component Issue button")
    public void the_user_clicks_on_component_issue_button() {

        componentIssueAction.clickBloodComponentDetails();
    }

    @Then("the Component Issue Detail Status page should be displayed")
    public void the_component_issue_detail_status_page_should_be_displayed() {

        Assert.assertTrue(componentIssueAction.verifyBloodIssuePage(),
                "Component Issue Detail Status page is not displayed");
    }

    @Then("the Component Issue Details page should be displayed")
    public void the_component_issue_details_page_should_be_displayed() {

        Assert.assertTrue(componentIssueAction.verifyBloodIssuePage(),
                "Component Issue Details page is not displayed");
    }
}