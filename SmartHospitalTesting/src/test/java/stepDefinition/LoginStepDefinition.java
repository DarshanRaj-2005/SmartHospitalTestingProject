package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	   System.out.println("hello");
	}

	@When("the user clicks Admin Login link")
	public void the_user_clicks_admin_login_link() {
		 System.out.println("hello");
	}

	@Then("the user is redirected to the Admin Login page")
	public void the_user_is_redirected_to_the_admin_login_page() {
		 System.out.println("hello");
	}

	@Then("the user clicks the Super Admin button")
	public void the_user_clicks_the_super_admin_button() {
		 System.out.println("hello");
	}

	@Then("the user clicks the Sign in button")
	public void the_user_clicks_the_sign_in_button() {
		 System.out.println("hello");
	}

	@Then("the user is redirected to the Super Admin dashboard")
	public void the_user_is_redirected_to_the_super_admin_dashboard() {
		 System.out.println("hello");
	}

}
