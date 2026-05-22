package pages;

import org.openqa.selenium.By;

public class GeneratePharmacybillPage {

	public static By generatePharmacyBillPageHeader = By.xpath("//h1[contains(text(),'Pharmacy Bill')]");

	public static By generateBillButton = By
			.xpath("//a[contains(text(),'Generate Bill')] | //button[contains(text(),'Generate Bill')]");

	public static By patientDropdown = By.xpath("//span[@id='select2-addpatient_id-container']/parent::span");

	public static By patientSearchBox = By.xpath("//input[@class='select2-search__field']");

	public static By dropdownOption(String value) {
		return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");
	}

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

	public static By batchInputField = By.xpath("(//input[contains(@name,'batch_no')])[1]");

	public static By quantityInputField = By.xpath("(//input[contains(@name,'quantity')])[1]");

	public static By doctorDropdown = By.xpath("(//span[@role='combobox'])[3]");

	public static By doctorSearchBox = By.xpath("//input[@class='select2-search__field']");

	public static By doctorOption(String value) {
		return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");
	}

	public static By paymentModeDropdown = By.xpath("//select[@name='payment_mode']");

	public static By amountInputField = By.xpath("//input[@name='payment_amount']");

	public static By saveButton = By.id("billsave");

	public static By successMessage = By.xpath("//div[contains(@class,'alert-success')]");

	public static By errorMessage = By.cssSelector(".toast-message");
}