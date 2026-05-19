package stepDefinition;

import java.util.Map;
import org.testng.Assert;
import actions.GeneratePharmacybillAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneratePharmacybillDefinition {

    GeneratePharmacybillAction generatePharmacyBillAction = new GeneratePharmacybillAction();

    @When("user clicks Generate Bill button")
    public void user_clicks_generate_bill_button() {
        generatePharmacyBillAction.clickGenerateBillButton();
        System.out.println("Clicked Generate Bill button");
    }

    @When("the user enters pharmacy bill details")
    public void the_user_enters_pharmacy_bill_details(DataTable dataTable) {

        Map<String, String> pharmacyBillData = dataTable.asMap(String.class, String.class);

        if (pharmacyBillData.get("patient") != null && !pharmacyBillData.get("patient").isEmpty()) {
            generatePharmacyBillAction.enterPatientName(pharmacyBillData.get("patient"));
        }

        if (pharmacyBillData.get("category") != null && !pharmacyBillData.get("category").isEmpty()) {
            generatePharmacyBillAction.selectCategory(pharmacyBillData.get("category"));
        }

        if (pharmacyBillData.get("medicine") != null && !pharmacyBillData.get("medicine").isEmpty()) {
            generatePharmacyBillAction.enterMedicineName(pharmacyBillData.get("medicine"));
        }

        if (pharmacyBillData.get("batch") != null && !pharmacyBillData.get("batch").isEmpty()) {
            generatePharmacyBillAction.enterBatchNumber(pharmacyBillData.get("batch"));
        }

        if (pharmacyBillData.get("quantity") != null && !pharmacyBillData.get("quantity").isEmpty()) {
            generatePharmacyBillAction.enterQuantity(pharmacyBillData.get("quantity"));
        }

        if (pharmacyBillData.get("doctor") != null && !pharmacyBillData.get("doctor").isEmpty()) {
            generatePharmacyBillAction.enterDoctorName(pharmacyBillData.get("doctor"));
        }

        if (pharmacyBillData.get("paymentMode") != null && !pharmacyBillData.get("paymentMode").isEmpty()) {
            generatePharmacyBillAction.selectPaymentMode(pharmacyBillData.get("paymentMode"));
        }

        if (pharmacyBillData.get("amount") != null && !pharmacyBillData.get("amount").isEmpty()) {
            generatePharmacyBillAction.enterAmount(pharmacyBillData.get("amount"));
        }
    }

    @When("user clicks the Save button")
    public void user_clicks_the_save_button() {
        generatePharmacyBillAction.clickSaveButton();
        System.out.println("User clicked Save button");
    }

    @Then("the pharmacy bill should be generated successfully")
    public void the_pharmacy_bill_should_be_generated_successfully() {

        boolean isSuccessMessageDisplayed = generatePharmacyBillAction.isSuccessMessageDisplayed();
        Assert.assertTrue(isSuccessMessageDisplayed, "Success message is not displayed");

        String successMessage = generatePharmacyBillAction.getSuccessMessageText();
        System.out.println("Success message: " + successMessage);
    }

    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {

        boolean isErrorMessageDisplayed = generatePharmacyBillAction.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed");

        String errorMessage = generatePharmacyBillAction.getErrorMessageText();
        System.out.println("Error message: " + errorMessage);
    }
}