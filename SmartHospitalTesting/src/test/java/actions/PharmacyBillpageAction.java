package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Helper;
import driver.Driver;
import pages.PharmacyBillPage;

public class PharmacyBillpageAction {

	WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

	public void clickPharmacy() {

		Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);
		Helper.click(PharmacyBillPage.pharmacyMenu);
	}

	public void clickPatientsearchbar() {

		Helper.waitForElementClickable(PharmacyBillPage.searchInputbar);
		Helper.click(PharmacyBillPage.searchInputbar);
	}

	public void searchName(String patient) {

	    Helper.waitForVisibility(PharmacyBillPage.searchInputbar);

	    Helper.click(PharmacyBillPage.searchInputbar);
	    Helper.clear(PharmacyBillPage.searchInputbar);
	    Helper.type(PharmacyBillPage.searchInputbar, patient);
	    Helper.waitForElementsPresent(PharmacyBillPage.searchnamerow, 10);
	}
	public String isPatientPresent(String patient) {

		List<WebElement> names = Helper.getElements(PharmacyBillPage.searchnamerow);

		for (WebElement name : names) {

			String actual = name.getText().trim();

			if (actual.toLowerCase().contains(patient.toLowerCase())) {
			    actual = actual.replaceAll("\\(.*\\)", "").trim();
				return actual;
			}
		}

		return null;
	}
}