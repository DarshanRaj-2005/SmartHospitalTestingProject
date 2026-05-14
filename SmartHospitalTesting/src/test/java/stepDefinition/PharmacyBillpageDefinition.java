package stepDefinition;

import org.testng.Assert;

import actions.PharmacyBillpageAction;
import driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PharmacyBillPage;

public class PharmacyBillpageDefinition {

    PharmacyBillpageAction pharmacyAction =
            new PharmacyBillpageAction();

    @When("the user clicks the Pharmacy")
    public void the_user_clicks_the_pharmacy() {

        pharmacyAction.clickPharmacy();
    }

    @Then("it should move to the Pharmacy Bill page successfully")
    public void it_should_move_to_the_pharmacy_bill_page_successfully() {

        boolean isDisplayed =
                Driver.getDriver()
                .findElement(PharmacyBillPage.pharmacyBillPageHeader)
                .isDisplayed();

        Assert.assertTrue(isDisplayed);
        System.out.println("successfully moved to the pharmacy bill page");
    }
}