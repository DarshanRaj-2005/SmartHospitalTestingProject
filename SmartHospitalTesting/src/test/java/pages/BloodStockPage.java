package pages;

import org.openqa.selenium.By;

public class BloodStockPage {

	public static By bloodBankStatus = By.xpath("//h3[contains(text(),'Blood Bank Status')]");
	public static By bloodBagTable = By.xpath("(//table)[1]");
	public static By componentTable = By.xpath("(//table)[2]");

	public static By bloodGroupOption(String bloodGroup) {
		return By.xpath("//li[normalize-space()='" + bloodGroup + "']");
	}

	public static By dynamicOption(String option) {

	    return By.xpath(
	        "//li[contains(@class,'select2-results__option') " +
	        "and contains(normalize-space(),'" + option + "')]"
	    );
	}

	public static By searchBox = By.xpath("//input[@class='select2-search__field']");
	public static By addIcon = By.xpath("(//button[contains(@class,'btn-primary')])[1]");
	public static By popup = By.xpath("//h4[contains(text(),'Blood Donor Details')]");
	public static By bloodDonor = By.xpath("//span[@id='select2-blood_donor_id-container']");
	public static By donateDateField = By.xpath("//input[@name='donate_date']");
	public static By bagField = By.xpath("//input[@name='bag_no']");
	public static By chargeCategory = By.xpath("//span[@id='select2-charge_category-container']");
	public static By chargeName = By.xpath("//span[@id='select2-code-container']");
	public static By calculate = By.xpath("//button[normalize-space()='Calculate']");
	public static By saveButton = By.xpath("(//button[text()=' Save']/self::button)[1]");
	public static By successMessage = By.xpath("//div[contains(@class,'toast-message')]");

	public static By addedBagNumber(String bagField) {
		return By.xpath("(//table//td[normalize-space()='" + bagField + "'])[1]");
	}

	public static By issueButton(String bagNumber) {
		return By.xpath("//td[normalize-space()='" + bagNumber + "']/parent::tr//button[contains(text(),'Issue')]");
	}

	public static By issueDate = By.xpath("//label[contains(text(),'Issue Date')]");
	public static By validationMessages =By.xpath("//div[contains(@class,'toast-message')]");
	
}