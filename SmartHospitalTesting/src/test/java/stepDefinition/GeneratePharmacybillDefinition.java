package stepDefinition;

import java.util.Map;
import org.testng.Assert;
import actions.GeneratePharmacybillAction;
import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PharmacyBillPage;

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
        if (pharmacyBillData.containsKey("patient") && !pharmacyBillData.get("patient").isEmpty()) {
            String patient = pharmacyBillData.get("patient");
            generatePharmacyBillAction.enterPatientName(patient);
            System.out.println("Entered patient: " + patient);
        }
        if (pharmacyBillData.containsKey("category") && !pharmacyBillData.get("category").isEmpty()) {
            String category = pharmacyBillData.get("category");
            generatePharmacyBillAction.selectCategory(category);
            System.out.println("Selected category: " + category);
        }
        if (pharmacyBillData.containsKey("medicine") && !pharmacyBillData.get("medicine").isEmpty()) {
            String medicine = pharmacyBillData.get("medicine");
            generatePharmacyBillAction.enterMedicineName(medicine);
            System.out.println("Entered medicine: " + medicine);
        }

        if (pharmacyBillData.containsKey("batch") && !pharmacyBillData.get("batch").isEmpty()) {
            String batch = pharmacyBillData.get("batch");
            generatePharmacyBillAction.enterBatchNumber(batch);
            System.out.println("Entered batch: " + batch);
        }
        if (pharmacyBillData.containsKey("quantity") && !pharmacyBillData.get("quantity").isEmpty()) {
            String quantity = pharmacyBillData.get("quantity");
            generatePharmacyBillAction.enterQuantity(quantity);
            System.out.println("Entered quantity: " + quantity);
        }
        if (pharmacyBillData.containsKey("doctor") && !pharmacyBillData.get("doctor").isEmpty()) {
            String doctor = pharmacyBillData.get("doctor");
            generatePharmacyBillAction.enterDoctorName(doctor);
            System.out.println("Entered doctor: " + doctor);
        }
        if (pharmacyBillData.containsKey("paymentMode") && !pharmacyBillData.get("paymentMode").isEmpty()) {
            String paymentMode = pharmacyBillData.get("paymentMode");
            generatePharmacyBillAction.selectPaymentMode(paymentMode);
            System.out.println("Selected payment mode: " + paymentMode);
        }
        if (pharmacyBillData.containsKey("amount") && !pharmacyBillData.get("amount").isEmpty()) {
            String amount = pharmacyBillData.get("amount");
            generatePharmacyBillAction.enterAmount(amount);
            System.out.println("Entered amount: " + amount);
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
        System.out.println("Success message displayed: " + successMessage);
        System.out.println("Pharmacy bill generated successfully");
    }

    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {
        boolean isErrorMessageDisplayed = generatePharmacyBillAction.isErrorMessageDisplayed();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed");
        
        String errorMessage = generatePharmacyBillAction.getErrorMessageText();
        System.out.println("Error message displayed: " + errorMessage);
        System.out.println("Validation error shown for mandatory fields");
    }
}
