package stepDefinition;

import org.testng.Assert;

import actions.AddPaymentAction;
import io.cucumber.java.en.Then;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddPaymentStepDefinition {

	Logger logger = LogManager.getLogger(AddPaymentStepDefinition.class);

	@Then("the user clicks the add payment link")
	public void the_user_clicks_the_add_payment_link() {
		logger.info("User trying to click Add Payment link");
		try {
			logger.debug("Calling clickAddPayment()");
			AddPaymentAction.clickAddPayment();
			logger.info("Add Payment link clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to click Add Payment link", e);
			throw e;
		}
	}

	@Then("the user redirected to add payment page")
	public void the_user_redirected_to_add_payment_page() {
		logger.info("Validating Add Payment page");
		try {
			logger.debug("Fetching payment page title");
			String actualTitle = AddPaymentAction.checkPaymentTitle();
			logger.debug("Actual Title : " + actualTitle);
			Assert.assertEquals(actualTitle, "Payments");
			logger.info("Successfully redirected to Add Payment page");
		} catch (Exception e) {
			logger.error("Add Payment page validation failed", e);
			throw e;
		}
	}

	@Then("the user enters the add payment detials")
	public void the_user_enters_the_add_payment_detials() {
		logger.info("Entering payment details");
		try {
			logger.debug("Calling enterPaymentDetails()");
			AddPaymentAction.enterPaymentDetails();
			logger.info("Payment details entered successfully");
		} catch (Exception e) {
			logger.error("Failed to enter payment details", e);
			throw e;
		}
	}

	@Then("the payment transaction should be added successfully")
	public void the_payment_transaction_should_be_added_successfully() {
		logger.info("Validating payment success message");
		try {
			String actualMessage = AddPaymentAction.checkSavemessage();
			logger.debug("Actual Success Message : " + actualMessage);
			Assert.assertEquals(actualMessage, "Record Saved Successfully");
			logger.info("Payment added successfully");
		} catch (Exception e) {
			logger.error("Payment success validation failed", e);
			throw e;
		}
	}

	@Then("the user clicks the delete button")
	public void the_user_clicks_the_delete_button() {
		logger.info("User trying to delete payment");
		try {
			logger.debug("Calling deletePayment()");
			AddPaymentAction.deletePayment();
			logger.info("Delete button clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to delete payment", e);
			throw e;
		}
	}

	@Then("the payment transaction should be deleted successfully")
	public void the_payment_transaction_should_be_deleted_successfully() {
		logger.info("Validating delete success message");
		try {
			String actualMessage = AddPaymentAction.deletemessage();
			logger.debug("Actual Delete Message : " + actualMessage);
			Assert.assertEquals(actualMessage, "Record Deleted Successfully");
			logger.info("Payment deleted successfully");
		} catch (Exception e) {
			logger.error("Delete validation failed", e);
			throw e;
		}
	}

	@Then("the system should show error message")
	public void the_system_should_show_error_message() {
		logger.info("Validating error message for empty fields");
		try {
			String actualError = AddPaymentAction.saveEmptyCheck();
			logger.debug("Actual Error Message : " + actualError);
			Assert.assertEquals(actualError, "Date field is required");
			logger.info("Validation message displayed successfully");
		} catch (Exception e) {
			logger.error("Validation error message check failed", e);
			throw e;
		}
	}

	@Then("the user clicks on the save button")
	public void the_user_clicks_on_the_save_button() {
		logger.info("User clicking Save button");
		try {
			logger.debug("Calling clickSave()");
			AddPaymentAction.clickSave();
			logger.info("Save button clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to click Save button", e);
			throw e;
		}
	}
}