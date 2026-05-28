package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Utilities.Data_Provider;
import actions.AddambulanceCallAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddambulanceCallStepDefinition {

    Logger logger =
            LogManager.getLogger(AddambulanceCallStepDefinition.class);

    @When("the user clicks Ambulance link")
    public void the_user_clicks_ambulance_link() {

        logger.info("User trying to click Ambulance link");

        try {

            logger.debug("Calling clickAddambulance()");

            AddambulanceCallAction.clickAddambulance();

            logger.info("Ambulance link clicked successfully");

        } catch (Exception e) {

            logger.error("Failed to click Ambulance link", e);

            throw e;
        }
    }

    @Then("the user redirected to ambulance page")
    public void the_user_redirected_to_ambulance_page() {

        logger.info("Validating Ambulance page");

        try {

            logger.debug("Fetching Ambulance page title");

            String actualTitle =
                    AddambulanceCallAction.checkTitle();

            logger.debug("Actual title : " + actualTitle);

            Assert.assertEquals(
                    actualTitle,
                    "Ambulance Call List"
            );

            logger.info("Successfully redirected to Ambulance page");

        } catch (Exception e) {

            logger.error("Ambulance page validation failed", e);

            throw e;
        }
    }

    @Then("the user clicks the add ambulance link")
    public void the_user_clicks_the_add_ambulance_link() {

        logger.info("User trying to click Add Ambulance link");

        try {

            logger.debug("Calling clickAddambulanceCall()");

            AddambulanceCallAction.clickAddambulanceCall();

            logger.info("Add Ambulance link clicked successfully");

        } catch (Exception e) {

            logger.error("Failed to click Add Ambulance link", e);

            throw e;
        }
    }

    @Then("the user redirected to getcallambulance page")
    public void the_user_redirected_to_getcallambulance_page() {

        logger.info("Validating Get Call Ambulance page");

        try {

            String actualText =
                    AddambulanceCallAction.checkmodelText();

            logger.debug("Actual model text : " + actualText);

            Assert.assertEquals(actualText, "Vehicle Model");

            logger.info("Successfully redirected to Get Call Ambulance page");

        } catch (Exception e) {

            logger.error("Get Call Ambulance page validation failed", e);

            throw e;
        }
    }

    @Then("the user enters ambulance call details")
    public void the_user_enters_ambulance_call_details(
            DataTable dataTable) throws InterruptedException {

        logger.info("Entering ambulance call details using DataTable");

        try {

            List<Map<String, String>> data =
                    dataTable.asMaps(String.class, String.class);

            Map<String, String> ambulance = data.get(0);

            logger.debug("Fetching ambulance test data");

            String patient = ambulance.get("patient");
            String name = ambulance.get("name");
            String vehicleModel = ambulance.get("vehicleModel");
            String date = ambulance.get("date");
            String chargeCategory = ambulance.get("chargeCategory");
            String chargeName = ambulance.getOrDefault("chargeName", "");
            String note = ambulance.get("note");
            String paymentMode = ambulance.get("paymentMode");

            logger.debug("Patient : " + patient);
            logger.debug("Vehicle Model : " + vehicleModel);

            AddambulanceCallAction.enterAmbulanceDetail(
                    patient,
                    name,
                    vehicleModel,
                    date,
                    chargeCategory,
                    chargeName,
                    note,
                    paymentMode
            );

            logger.info("Ambulance details entered successfully");

        } catch (Exception e) {

            logger.error("Failed to enter ambulance details", e);

            throw e;
        }
    }

    @Then("the user enters ambulance call details from excel")
    public void the_user_enters_ambulance_call_details_from_excel()
            throws Exception {

        logger.info("Entering ambulance details from Excel");

        try {

            logger.debug("Reading Excel data");

            String[][] data = Data_Provider.getExcelData(
                    "src/test/resources/test_datas/TestData.xlsx",
                    "Sheet1"
            );

            String patient = data[0][0];
            String vehicleModel = data[0][1];
            String date = data[0][2];
            String note = data[0][3];

            logger.debug("Excel Data Loaded Successfully");

            AddambulanceCallAction.enterAmbulanceDetail(
                    patient,
                    vehicleModel,
                    date,
                    note
            );

            logger.info("Excel ambulance details entered successfully");

        } catch (Exception e) {

            logger.error("Failed to enter ambulance details from Excel", e);

            throw e;
        }
    }

    @Then("the user clicks save button")
    public void the_user_clicks_save_button() {

        logger.info("User clicking Save button");

        try {

            logger.debug("Calling clickSave()");

            AddambulanceCallAction.clickSave();

            logger.info("Save button clicked successfully");

        } catch (Exception e) {

            logger.error("Failed to click Save button", e);

            throw e;
        }
    }

    @Then("the ambulance call should be added successfully")
    public void the_ambulance_call_should_be_added_successfully() {

        logger.info("Validating ambulance success message");

        try {

            String actualMessage =
                    AddambulanceCallAction.checksuccess();

            logger.debug("Actual Success Message : " + actualMessage);

            Assert.assertEquals(
                    actualMessage,
                    "Record Saved Successfully"
            );

            logger.info("Ambulance call added successfully");

        } catch (Exception e) {

            logger.error("Ambulance success validation failed", e);

            throw e;
        }
    }

    @Then("the system should show validation error messages")
    public void the_system_should_show_validation_error_messages() {

        logger.info("Validating mandatory field error message");

        try {

            String actualError =
                    AddambulanceCallAction.checkerror();

            logger.debug("Actual Error Message : " + actualError);

            Assert.assertEquals(
                    actualError,
                    "Vehicle Model field is required"
            );

            logger.info("Validation error displayed successfully");

        } catch (Exception e) {

            logger.error("Validation error check failed", e);

            throw e;
        }
    }

    @Then("the system should show invalid charge name field required message")
    public void the_system_should_show_invalid_standard_charge_message() {

        logger.info("Validating invalid charge category message");

        try {

            String actualMessage =
                    AddambulanceCallAction.checkInvalidAmount();

            logger.debug("Actual Invalid Message : " + actualMessage);

            Assert.assertEquals(
                    actualMessage,
                    "Charge Category field is required"
            );

            logger.info("Invalid charge category message validated");

        } catch (Exception e) {

            logger.error("Invalid charge category validation failed", e);

            throw e;
        }
    }
}