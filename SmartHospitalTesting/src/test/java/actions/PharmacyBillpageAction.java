package actions;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Helper;
import driver.Driver;
import pages.PharmacyBillPage;

public class PharmacyBillpageAction {

	WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

	Logger logger = LogManager.getLogger(PharmacyBillpageAction.class);

	public void clickPharmacy() {

		Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);
		Helper.click(PharmacyBillPage.pharmacyMenu);
	}

	public void clickPatientsearchbar() {

		Helper.waitForElementClickable(PharmacyBillPage.searchInputbar);
		Helper.click(PharmacyBillPage.searchInputbar);
	}

	public void searchName(String patient) {

		logger.info("Searching patient name: " + patient);

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

				logger.info("Patient found: " + actual);

				return actual;
			}
		}

		logger.warn("Patient not found: " + patient);

		return null;
	}

	public boolean pageisDisplayed() {

		Helper.waitForVisibility(PharmacyBillPage.pharmacyBillPageHeader);

		return Helper.isDisplayed(PharmacyBillPage.pharmacyBillPageHeader);
	}

	public boolean isNoDataMessageDisplayed() {

		try {

			WebElement message = wait
					.until(ExpectedConditions.visibilityOfElementLocated(PharmacyBillPage.noDataMessage));

			return message.getText().contains("No data available in table");

		} catch (Exception e) {

			logger.error("No Data message not displayed");

			return false;
		}
	}
}