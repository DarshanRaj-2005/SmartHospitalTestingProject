package pages;

import org.openqa.selenium.By;

public class GeneratePharmacybillPage {

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

	public static By saveButton = By.id("billsave");

	public static By errorMessage = By.xpath("//*[@id=\"toast-container\"]/div/div/p[1]");
}

