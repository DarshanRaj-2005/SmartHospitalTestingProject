package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Helper;
import pages.AddambulancePage;
import driver.Driver;

public class AddambulanceAction {
	public static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

	public static void clickAddambulance() {
		Helper.click(AddambulancePage.addAmbulance);
	}

	public static void clickAddambulanceCall() {
		Helper.click(AddambulancePage.addAmbulanceCall);
	}

	public static void enterAmbulanceDetail(String patient, String vehicleModel, String date, String chargeCategory,
			String chargeName, String note, String paymentMode) throws InterruptedException {

		Helper.click(AddambulancePage.patient);
		Helper.type(AddambulancePage.patientInput, patient);

		Helper.waitForElementClickable(AddambulancePage.dynamicOption("Ashok (1185)"));

		Helper.click(AddambulancePage.dynamicOption("Ashok (1185)"));

		Select s = new Select(Helper.getElement(AddambulancePage.vehicleModal));
		s.selectByVisibleText(vehicleModel);
		
		//Used Javascript for setting date
		Helper.setDate(AddambulancePage.date, date);

		Select s2 = new Select(Helper.getElement(AddambulancePage.chargeCategory));
		s2.selectByVisibleText(chargeCategory);
		
		Helper.waitForElementClickable(AddambulancePage.chargeName);
		Helper.click(AddambulancePage.chargeName);
		Helper.waitForVisibility(AddambulancePage.chargeInput);
		Helper.type(AddambulancePage.chargeInput, chargeName);
		Helper.waitForElementClickable(AddambulancePage.selectOption(chargeName));
		Helper.click(AddambulancePage.selectOption(chargeName));
	
		Helper.type(AddambulancePage.note, note);
	}

	public static void enterAmbulanceDetail(String patient, String vehicleModel, String date, String chargeCategory,
			String note) {

		Helper.click(AddambulancePage.patient);
		Helper.type(AddambulancePage.patientInput, patient);
		Helper.waitForElementClickable(AddambulancePage.dynamicOption("Ashok (1185)"));
		Helper.click(AddambulancePage.dynamicOption("Ashok (1185)"));

		Select s = new Select(Helper.getElement(AddambulancePage.vehicleModal));
		s.selectByVisibleText(vehicleModel);
		
		//Used Javascript for setting date
		Helper.setDate(AddambulancePage.date, date);

		Select s2 = new Select(Helper.getElement(AddambulancePage.chargeCategory));
		s2.selectByVisibleText(chargeCategory);

		Helper.type(AddambulancePage.note, note);
	}

	public static void clickSave() {
		Helper.click(AddambulancePage.saveButton);
	}

	public static boolean checkTitle() {
		Helper.waitForVisibility(AddambulancePage.title);
		String title = Helper.getText(AddambulancePage.title);
		Assert.assertEquals(title, "Ambulance Call List");
		return true;
	}

	public static boolean checkmodelText() {
		Helper.waitForVisibility(AddambulancePage.modelText);
		String title = Helper.getText(AddambulancePage.modelText);
		Assert.assertEquals(title, "Vehicle Model");
		return true;
	}

	public static boolean checkerror() {
		Helper.waitForVisibility(AddambulancePage.errtext);
		String title = Helper.getText(AddambulancePage.errtext);
		Assert.assertEquals(title, "Vehicle Model field is required");
		return true;
	}

	public static boolean checksuccess() {
		Helper.waitForVisibility(AddambulancePage.successMessage);
		String text = Helper.getText(AddambulancePage.successMessage);
		Assert.assertEquals(text, "Record Saved Successfully");
		return true;
	}

	public static boolean checkInvalidAmount() {
		Helper.waitForVisibility(AddambulancePage.invalidamountmess);
		String text = Helper.getText(AddambulancePage.invalidamountmess);
		Assert.assertEquals(text, "Charge Name field is required");
		return true;
	}
}


//*[@id="formadd"]/div[2]/div/div[1]/div[8]/div/span[1]/span[1]/span
