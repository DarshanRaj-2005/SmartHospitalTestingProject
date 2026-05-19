package pages;

import org.openqa.selenium.By;

public class GeneratePharmacybillPage {
	public static By generatePharmacyBillPageHeader = By.xpath("//h1[contains(text(), 'Pharmacy Bill')]");
	public static By generateBillButton = By.xpath("//button[contains(text(),'Generate') or contains(text(),'Add') or contains(text(),'Bill')]");
	public static By patientInputField = By.xpath("//input[@placeholder='Search patient' or @name='patient']");
	public static By patientSearchDropdown = By.xpath("//div[@class='dropdown-menu show']//a");
	
	public static By categoryDropdown = By.xpath("//select[@name='category' or @id='category']");
	public static By medicineInputField = By.xpath("//input[@placeholder='Search medicine' or @name='medicine']");

	public static By medicineSearchDropdown = By.xpath("//div[@class='dropdown-menu show']//a");
	public static By batchInputField = By.xpath("//input[@name='batch' or @placeholder='Batch']");
	public static By quantityInputField = By.xpath("//input[@name='quantity' or @placeholder='Quantity']");
	public static By doctorInputField = By.xpath("//input[@placeholder='Search doctor' or @name='doctor']");
	public static By doctorSearchDropdown = By.xpath("//div[@class='dropdown-menu show']//a");
	public static By paymentModeDropdown = By.xpath("//select[@name='paymentMode' or @id='paymentMode']");
	public static By amountInputField = By.xpath("//input[@name='amount' or @placeholder='Amount']");

	public static By saveButton = By.xpath("//button[contains(text(), 'Save') or contains(text(), 'SAVE')]");
	public static By successMessage = By.xpath("//div[@class='alert alert-success' or contains(@class, 'success')]");
	public static By errorMessage = By.xpath("//div[@class='alert alert-danger' or contains(@class, 'error')]");
	public static By categoryErrorMessage = By
			.xpath("//span[@class='error' or @class='help-block'][contains(text(), 'category')]");
	public static By medicineErrorMessage = By
			.xpath("//span[@class='error' or @class='help-block'][contains(text(), 'medicine')]");

	public static By successNotification = By
			.xpath("//div[@class='alert alert-success' or contains(@class, 'success')]");
	public static By errorNotification = By.xpath("//div[@class='alert alert-danger' or contains(@class, 'error')]");
}