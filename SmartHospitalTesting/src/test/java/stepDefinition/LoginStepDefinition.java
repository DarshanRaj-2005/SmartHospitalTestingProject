package stepDefinition;

import org.testng.Assert;

import Utilities.ConfigReader;
import Utilities.Helper;
import actions.LoginAction;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDefinition {

    Logger logger =
            LogManager.getLogger(LoginStepDefinition.class);

    LoginAction la = new LoginAction();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        logger.info("Launching application URL");

        try {

            logger.debug("Opening URL from ConfigReader");

            Driver.getDriver().get(ConfigReader.getUrl());

            logger.info("Application launched successfully");

        } catch (Exception e) {

            logger.error("Failed to launch application URL", e);

            throw e;
        }
    }

    @When("the user clicks Super Admin button")
    public void the_user_clicks_super_admin_button() {

        logger.info("User trying to click Super Admin button");

        try {

            logger.debug("Waiting for Super Admin button");

            Helper.waitForElementClickable(LoginPage.superAdmin);

            logger.debug("Calling clicksuperAdmin()");

            la.clicksuperAdmin();

            logger.info("Super Admin button clicked successfully");

        } catch (Exception e) {

            logger.error("Failed to click Super Admin button", e);

            throw e;
        }
    }

    @Then("the user clicks the Sign in button")
    public void the_user_clicks_the_sign_in_button() {

        logger.info("User trying to click Sign In button");

        try {

            logger.debug("Calling clicksignIn()");

            la.clicksignIn();

            logger.info("Sign In button clicked successfully");

        } catch (Exception e) {

            logger.error("Failed to click Sign In button", e);

            throw e;
        }
    }

    @Then("the user should be redirected to super admin dashboard")
    public void the_user_should_be_redirected_to_super_admin_dashboard() {

        logger.info("Validating dashboard redirection");

        try {

            logger.debug("Checking dashboard visibility");

            Assert.assertTrue(la.isDashboardDisplayed());

            logger.info("Dashboard displayed successfully");

        } catch (Exception e) {

            logger.error("Dashboard validation failed", e);

            throw e;
        }
    }

    @When("the user enters invalid username and valid password")
    public void the_user_enters_invalid_and_valid_password() {

        logger.info("Entering invalid username");

        try {

            logger.debug("Typing invalid username");

            Helper.type(
                    LoginPage.email,
                    ConfigReader.getUsername()
            );

            logger.info("Invalid username entered successfully");

        } catch (Exception e) {

            logger.error("Failed to enter invalid username", e);

            throw e;
        }
    }

    @Then("the system should show a message {string}")
    public void the_system_should_show_a_message(String string) {

        logger.info("Validating invalid credential message");

        try {

            logger.debug("Waiting for validation message");

            Helper.waitForVisibility(LoginPage.text);

            String text = la.message();

            logger.debug("Actual Message : " + text);

            Assert.assertEquals(
                    text,
                    "Invalid Username or Password"
            );

            logger.info("Validation message displayed successfully");

        } catch (Exception e) {

            logger.error("Validation message check failed", e);

            throw e;
        }
    }

    @Then("the system should show username and password required messages")
    public void the_system_should_show_username_and_password_required_messages() {

        logger.info("Validating mandatory field messages");

        try {

            logger.debug("Waiting for required field message");

            Helper.waitForVisibility(LoginPage.texts);

            String texts = la.messages();

            logger.debug("Actual Message : " + texts);

            Assert.assertEquals(
                    texts,
                    "Username field is required"
            );

            logger.info("Required field validation successful");

        } catch (Exception e) {

            logger.error("Required field validation failed", e);

            throw e;
        }
    }

    @Given("the user enter invalid {string} and {string}")
    public void the_user_enter_invalid_and(
            String string,
            String string2) {

        logger.info("Entering invalid login credentials");

        try {

            logger.debug("Typing invalid username and password");

            Helper.type(LoginPage.email, string);

            Helper.type(LoginPage.password, string2);

            logger.info("Invalid credentials entered successfully");

        } catch (Exception e) {

            logger.error("Failed to enter invalid credentials", e);

            throw e;
        }
    }

    @When("the user enters valid username and invalid password")
    public void the_user_enters_valid_username_and_invalid() {

        logger.info("Entering invalid password");

        try {

            logger.debug("Typing invalid password");

            Helper.type(
                    LoginPage.password,
                    ConfigReader.getPassword()
            );

            logger.info("Invalid password entered successfully");

        } catch (Exception e) {

            logger.error("Failed to enter invalid password", e);

            throw e;
        }
    }
}