package pages;

import org.openqa.selenium.By;

public class GeneratePharmacybillPage {

	// ===================== EXISTING =====================

	public static By generateBillButton = By
			.xpath("//a[contains(text(),'Generate Bill')] | //button[contains(text(),'Generate Bill')]");

	public static By categoryDropdown = By.xpath("(//span[contains(@id,'medicine_category')])[1]");
	public static By categorySearchBox = By.xpath("//input[@class='select2-search__field']");

	public static By categoryOption(String value) {
		return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");
	}

	public static By medicineInputField = By.xpath("(//span[@role='combobox'])[2]");
	public static By medicineSearchBox = By.xpath("//input[@class='select2-search__field']");

	public static By medicineOption(String value) {
		return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");
	}

	public static By saveButton = By.xpath("//button[@id='billsave']");
	public static By errorMessage = By.xpath("//*[@id=\"toast-container\"]/div/div/p[1]");

	// ===================== NEW =====================
	// New Patient button on the bill page

	public static By newPatientButton = By.id("add");

	// Add Patient modal
	public static By addPatientModal = By.xpath(
			"//h4[contains(text(),'Add Patient')] | //div[contains(@class,'modal-title') and contains(text(),'Add Patient')]");

	// Patient form fields
	public static By patientNameField = By.xpath("//input[@id='name'] | //input[@placeholder='Name']");
	public static By ageYearField = By.xpath("(//input[contains(@name,'age') or contains(@id,'age')])[1]");
	public static By ageMonthField = By.xpath("(//input[contains(@name,'age') or contains(@id,'age')])[2]");
	public static By ageDayField = By.xpath("(//input[contains(@name,'age') or contains(@id,'age')])[3]");
	public static By phoneField = By.xpath("//input[@id='number']");

	// Patient Save button inside modal
	public static By patientSaveButton = By.id("formaddpabtn");

	// Success toast message
	public static By successMessage =
			By.xpath("//div[contains(@class,'toast-message')]");

	// Modal closed — verify modal is gone
	public static By modalContainer = By.xpath("//div[contains(@class,'modal-backdrop')]");
}