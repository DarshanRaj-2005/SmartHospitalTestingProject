package stepDefinition;

import java.util.List;

import org.testng.Assert;

import actions.PharmacyBillpageAction;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PharmacyBillPage;

public class PharmacyBillpageDefinition {

	PharmacyBillpageAction pharmacyAction = new PharmacyBillpageAction();

	List<String> expectedPatient;

	@When("the user clicks the Pharmacy")
	public void the_user_clicks_the_pharmacy() {

		pharmacyAction.clickPharmacy();
	}

	@Then("it should move to the Pharmacy Bill page successfully")
	public void it_should_move_to_the_pharmacy_bill_page_successfully() {

		boolean isDisplayed = pharmacyAction.pageisDisplayed();

		Assert.assertTrue(isDisplayed);

		System.out.println("successfully moved to the pharmacy bill page");
	}

	@Given("the user is on the Pharmacy bill page")
	public void the_user_is_on_the_pharmacy_bill_page() {

		pharmacyAction.clickPharmacy();

		String expectedURL = "https://demo.smart-hospital.in/admin/pharmacy/bill";

		String actualURL = Driver.getDriver().getCurrentUrl();

		Assert.assertEquals(actualURL, expectedURL);

		System.out.println("the user is on the Pharmacy Bill page");
	}

	@When("the user searches for patient {string}")
	public void the_user_searches_for_patient(String patient) {

		pharmacyAction.clickPatientsearchbar();

		pharmacyAction.searchName(patient);
	}

	@Then("the system should display result as {string}")
	public void the_system_should_display_result_as(String result) {

		String searchedPatient = Driver.getDriver().findElement(PharmacyBillPage.searchInputbar).getAttribute("value");

		if (result.equalsIgnoreCase("present")) {

			String actualPatient = pharmacyAction.isPatientPresent(searchedPatient);

			Assert.assertNotNull(actualPatient);

			System.out.println("Patient is present");

		}

		else if (result.equalsIgnoreCase("not found")) {

			boolean noData = pharmacyAction.isNoDataMessageDisplayed();

			Assert.assertTrue(noData);

			System.out.println("Patient not found");
		}
	}

	@When("the user clicks the CSV button on the pharmacy bill page")
	public void the_user_clicks_the_csv_button_on_the_pharmacy_bill_page() {

		pharmacyAction.clickCSVButton();
	}

	@Then("the CSV file should be downloaded successfully")
	public void the_csv_file_should_be_downloaded_successfully() {

		Assert.assertTrue(pharmacyAction.isCSVFileDownloaded(), "CSV file was not downloaded successfully");
	}
}