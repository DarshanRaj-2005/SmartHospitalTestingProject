package actions;

import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Helper;
import driver.Driver;
import pages.AddambulanceCallPage;

public class AddambulanceCallAction {
	public static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

	public static void clickAddambulance() {
		Helper.waitForVisibility(AddambulanceCallPage.addAmbulance);
		Helper.click(AddambulanceCallPage.addAmbulance);
	}

	public static void clickAddambulanceCall() {
		Helper.waitForVisibility(AddambulanceCallPage.addAmbulanceCall);
		Helper.click(AddambulanceCallPage.addAmbulanceCall);
	}

	public static void enterAmbulanceDetail(String patient, String name, String vehicleModel, String date, String chargeCategory,
			String chargeName, String note, String paymentMode) throws InterruptedException {

		Helper.click(AddambulanceCallPage.patient);
		Helper.type(AddambulanceCallPage.patientInput, patient);

		Helper.waitForElementClickable(AddambulanceCallPage.dynamicOption(name));

		Helper.click(AddambulanceCallPage.dynamicOption(name));

		Select s = new Select(Helper.getElement(AddambulanceCallPage.vehicleModal));
		s.selectByVisibleText(vehicleModel);
		
		//Used Javascript for setting date
		Helper.setDate(AddambulanceCallPage.date, date);
		
		Helper.moveToElementAndClick(AddambulanceCallPage.chargeCategory);
		Helper.type(AddambulanceCallPage.searchBox,chargeCategory);
		Helper.waitForVisibility(AddambulanceCallPage.selectOption(chargeCategory));
		Helper.click(AddambulanceCallPage.selectOption(chargeCategory));
		
		Helper.moveToElementAndClick(AddambulanceCallPage.chargeName);
		Helper.type(AddambulanceCallPage.searchBox, chargeName);
		Helper.waitForElementsPresent(AddambulanceCallPage.selectOption(chargeName), 20);
		Helper.click(AddambulanceCallPage.selectOption(chargeName));
		
//		Helper.type(AddambulancePage.helloField, hello);

		Helper.type(AddambulanceCallPage.note, note);
		
		Select s2 = new Select(Helper.getElement(AddambulanceCallPage.paymentOption));
		s2.selectByVisibleText(paymentMode);
	}

	public static void enterAmbulanceDetail(String patient, String vehicleModel, String date,
			String note) {

		Helper.click(AddambulanceCallPage.patient);
		Helper.type(AddambulanceCallPage.patientInput, patient);
		Helper.waitForElementClickable(AddambulanceCallPage.dynamicOption("Ashok (1185)"));
		Helper.click(AddambulanceCallPage.dynamicOption("Ashok (1185)"));

		Select s = new Select(Helper.getElement(AddambulanceCallPage.vehicleModal));
		s.selectByVisibleText(vehicleModel);
		
		//Used Javascript for setting date
		Helper.setDate(AddambulanceCallPage.date, date);

		Helper.type(AddambulanceCallPage.note, note);
	}

	public static void clickSave() {
		Helper.click(AddambulanceCallPage.saveButton);
	}

	public static String  checkTitle() {
		Helper.waitForVisibility(AddambulanceCallPage.title);
		String title = Helper.getText(AddambulanceCallPage.title);
		return title;
	}

	public static String checkmodelText() {
		Helper.waitForVisibility(AddambulanceCallPage.modelText);
		String title = Helper.getText(AddambulanceCallPage.modelText);
		return title;
	}

	public static String checkerror() {
		Helper.waitForVisibility(AddambulanceCallPage.errtext);
		String title = Helper.getText(AddambulanceCallPage.errtext);
		return title;
	}

	public static String checksuccess() {
		Helper.waitForVisibility(AddambulanceCallPage.successMessage);
		String text = Helper.getText(AddambulanceCallPage.successMessage);
		return text;
	}

	public static String checkInvalidAmount() {
		Helper.waitForVisibility(AddambulanceCallPage.invalidamountmess);
		String text = Helper.getText(AddambulanceCallPage.invalidamountmess);
		return text;
	}
}
