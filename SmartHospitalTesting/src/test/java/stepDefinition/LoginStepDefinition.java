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
	    String url = Driver.getDriver().getCurrentUrl();
	    Assert.assertEquals(url, "https://demo.smart-hospital.in/admin/admin/dashboard");
	}

}