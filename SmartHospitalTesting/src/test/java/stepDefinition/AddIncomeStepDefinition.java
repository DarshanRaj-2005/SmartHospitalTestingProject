package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import Utilities.Data_Provider;
import actions.AddIncomeActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class AddIncomeStepDefinition {

    private static final Logger log = LogManager.getLogger(AddIncomeStepDefinition.class);

    // Excel file path — relative to project working directory
    private static final String EXCEL_PATH =
            System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "test"
            + File.separator + "resources"
            + File.separator + "test_datas"
            + File.separator + "IncomeData.xlsx";

    // Sheet name inside Excel
    private static final String SHEET_NAME = "IncomeData";

    // Column indices (0-based) — must match Excel header order:
    // IncomeHead | Name | InvoiceNumber | Amount | Description
    private static final int COL_HEAD        = 0;
    private static final int COL_NAME        = 1;
    private static final int COL_INVOICE     = 2;
    private static final int COL_AMOUNT      = 3;
    private static final int COL_DESCRIPTION = 4;

    private AddIncomeActions action;

    private AddIncomeActions getAction() {
        if (action == null) action = new AddIncomeActions();
        return action;
    }

    // NOTE: "Given Admin is on the Dashboard page" is defined in
    // AddPatientStepDefinition — Background reuses it automatically.
    // Do NOT redefine here — causes DuplicateStepDefinitionException.

    // ── Scenario 1 : Add income records from Excel ────────────────────────

    @Then("Admin clicks a Finance Category")
    public void admin_clicks_a_finance_category() {
        log.info("Step: Admin clicks Finance category");
        getAction().clickFinanceMenu();
    }

    @And("Admin clicks Income Category")
    public void admin_clicks_income_category() {
        log.info("Step: Admin clicks Income category");
        getAction().clickIncomeLink();
    }

    @And("Admin clicks Add Income button")
    public void admin_clicks_add_income_button() {
        log.info("Step: Admin clicks Add Income button");
        getAction().clickAddIncomeButton();
        getAction().waitForModalToLoad();
    }

    @When("Admin adds all income records from Excel")
    public void admin_adds_all_income_records_from_excel() {

        log.info("Step: Reading Excel using Data_Provider: " + EXCEL_PATH);

        // Validate file before reading
        File excelFile = new File(EXCEL_PATH);
        if (!excelFile.exists()) {
            Assert.fail("Excel file not found: " + EXCEL_PATH);
        }
        if (excelFile.length() == 0) {
            Assert.fail("Excel file is empty (0 bytes): " + EXCEL_PATH);
        }

        // Read all data rows using team's Data_Provider
        // Returns String[][] — row 0 = first data row (header is skipped internally)
        String[][] data;
        try {
            data = Data_Provider.getExcelData(EXCEL_PATH, SHEET_NAME);
        } catch (Exception e) {
            log.error("Data_Provider failed: " + e.getMessage());
            Assert.fail("Failed to read Excel: " + e.getMessage());
            return;
        }

        log.info("Total data rows from Excel: " + data.length);

        if (data.length == 0) {
            Assert.fail("No data rows found in Excel sheet: " + SHEET_NAME);
        }

        for (int i = 0; i < data.length; i++) {

            String head    = data[i][COL_HEAD].trim();
            String name    = data[i][COL_NAME].trim();
            String invoice = data[i][COL_INVOICE].trim();
            String amount  = data[i][COL_AMOUNT].trim();
            String desc    = data[i][COL_DESCRIPTION].trim();

            // Data_Provider uses cell.toString() — numeric cells become "5000.0"
            // Convert "5000.0" → "5000" for Amount field
            amount = cleanNumericValue(amount);

            log.info("Row " + (i + 1) + ": " + name + " | " + head + " | " + amount);

            // From row 2 onward — re-open modal for next record
            if (i > 0) {
                getAction().clickAddIncomeButton();
                getAction().waitForModalToLoad();
            }

            getAction().enterIncomeDetails(head, name, invoice, amount, desc);
            getAction().clickSaveButton();
            getAction().waitForModalToClose();

            log.info("Row " + (i + 1) + " saved: " + name);
        }
    }

    @Then("income record should be created successfully")
    public void income_record_should_be_created_successfully() {
        log.info("Step: Verifying income record in table");
        Assert.assertTrue(
                getAction().verifyIncomeInTable(),
                "Income record NOT found in table after saving.");
        log.info("Income record verified successfully");
    }

    // ── Scenario 2 : Save without mandatory fields ─────────────────────────

    @When("Admin clicks Save without filling mandatory fields")
    public void admin_clicks_save_without_filling_mandatory_fields() {
        log.info("Step: Clicking Save without filling mandatory fields");
        getAction().clickSaveWithoutFillingFields();
    }

    @Then("income validation errors should be displayed")
    public void income_validation_errors_should_be_displayed() {
        log.info("Step: Verifying validation errors displayed");
        Assert.assertTrue(
                getAction().verifyValidationErrorsDisplayed(),
                "Validation errors NOT shown when mandatory fields were empty.");
        log.info("Validation errors verified");
    }

    // ── Scenario 3 : Single inline income record ───────────────────────────

    @When("Admin fills income details with Head {string} Name {string} Amount {string}")
    public void admin_fills_income_details(String head, String name, String amount) {
        log.info("Step: Filling income — Head:" + head + " Name:" + name);
        getAction().enterIncomeDetails(head, name, "", amount, "Test income entry");
    }

    @Then("income success message should be displayed")
    public void income_success_message_should_be_displayed() {
        log.info("Step: Verifying success message");
        Assert.assertTrue(
                getAction().verifySuccessMessageDisplayed(),
                "Success message NOT displayed after saving income.");
        log.info("Success message verified");
    }

    // ── Scenario 4 : Mandatory fields only ────────────────────────────────

    @When("Admin fills only mandatory income fields with Head {string} Name {string} Amount {string}")
    public void admin_fills_only_mandatory_income_fields(String head, String name, String amount) {
        log.info("Step: Filling mandatory fields only — no Invoice, no Description");
        getAction().enterIncomeDetails(head, name, "", amount, "");
    }

    // ── Shared Save + close step ──────────────────────────────────────────

    @And("clicks on Income Save button")
    public void clicks_on_income_save_button() {
        log.info("Step: Clicks Income Save button");
        getAction().clickSaveButton();
        getAction().waitForModalToClose();
    }

    // ── Utility ──────────────────────────────────────────────────────────

    // Data_Provider uses cell.toString() which converts numeric 5000 → "5000.0"
    // This strips the trailing .0 so the Amount field receives "5000" not "5000.0"
    private String cleanNumericValue(String value) {
        if (value != null && value.endsWith(".0")) {
            return value.substring(0, value.length() - 2);
        }
        return value;
    }
}