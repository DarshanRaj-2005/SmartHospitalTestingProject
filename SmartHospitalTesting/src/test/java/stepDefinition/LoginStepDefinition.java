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

public class LoginStepDefinition {
	
	LoginAction la = new LoginAction();
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		Driver.getDriver().get(ConfigReader.getUrl());
	}

	@When("the user clicks Super Admin button")
	public void the_user_clicks_super_admin_button() {
		Helper.waitForElementClickable(LoginPage.superAdmin);
		la.clicksuperAdmin();
	}

	@Then("the user clicks the Sign in button")
	public void the_user_clicks_the_sign_in_button() {
	   la.clicksignIn();
	}

	@Then("the user should be redirected to super admin dashboard")
	public void the_user_should_be_redirected_to_super_admin_dashboard() {
		Assert.assertTrue(la.isDashboardDisplayed());
	}
	
	@When("the user enters invalid {string} and valid password")
	public void the_user_enters_invalid_and_valid_password(String string) {
	    Helper.type(LoginPage.email, string);
	}

	@Then("the system should show a message {string}")
	public void the_system_should_show_a_message(String string) {
		Helper.waitForVisibility(LoginPage.text);
		String text = la.message();
	    Assert.assertEquals(text, "Invalid Username or Password");
	}

	@Then("the system should show username and password required messages")
	public void the_system_should_show_username_and_password_required_messages() {
		Helper.waitForVisibility(LoginPage.texts);
	    String texts = la.messages();
	    Assert.assertEquals(texts,"Username field is required");
	}

}