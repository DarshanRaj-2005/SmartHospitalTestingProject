package pages;

import org.openqa.selenium.By;

public class MedicinestockPage {
	public static By pharmacyBillPageHeader = By.xpath("//h3[contains(text(),'Pharmacy Bill')]");
	public static By medicinebutton = By.xpath("//div[@class=\"box-tools pull-right\"]/a");
	public static By medicineSearchbar = By.xpath("//input[@placeholder='Search...']");
	// here used dynamic xpath because if medicine change the xpath of checkbox also change.
	public static By medicineCheckbox(String medicine) {
		return By.xpath("//tr[td[normalize-space()='" + medicine + "']]//input[@type='checkbox']");
	}

	public static By medicinetext(String searchedmedicine) {
		return By.xpath("//tr[td[contains(normalize-space(),'" + searchedmedicine + "')]]/td[2]");
	}

	public static By deleteButton = By.xpath("//button[@id='load']");
	public static By deleteConfirmation = By.xpath("//div[contains(text(),'Record Deleted Successfully')]");
}
