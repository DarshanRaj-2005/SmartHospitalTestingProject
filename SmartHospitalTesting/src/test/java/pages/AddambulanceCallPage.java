package pages;

import org.openqa.selenium.By;

public class AddambulanceCallPage {
	public static By addAmbulance = By.xpath("//ul[@class='sidebar-menu verttop']/li[11]/a");

	public static By addAmbulanceCall = By.xpath("//div[@class='box-tools pull-right']/a[1]");

	public static By vehicleModal = By.id("vehicle_no");

	public static By drivername = By.id("driver_search");

	public static By date = By.xpath("//*[@id=\"formcall\"]/div[1]/div/div/div[1]/div[3]/div/input");

	public static By standardCharge = By.id("standard_charge");

	public static By note = By.id("note");

	public static By saveButton = By.id("formcallbtn");

	public static By title = By.xpath("/html/body/div[1]/div/section/div/div/div/div[1]/h3");

	public static By modelText = By.xpath("//*[@id=\"formcall\"]/div[1]/div/div/div[1]/div[1]/div/label");

	public static By errtext = By.xpath("//*[@id=\"toast-container\"]/div/div/p[1]");

	public static By patient = By.xpath("//*[@id=\"myModal\"]/div/div/div/div/div[1]/div/span[1]/span[1]/span");

	public static By patientInput = By.xpath("/html/body/span/span/span[1]/input");

	public static By successMessage = By.xpath("//*[@id=\"toast-container\"]/div/div");

	public static By invalidamountmess = By.xpath("//*[@id=\"toast-container\"]/div/div/p[2]");

	public static By option = By.xpath("//*[@id=\"code\"]/option[2]");

	public static By chargeCategory = By.xpath("(//span[@class='select2-selection__rendered'])[2]");

	public static By chargeName = By.xpath("(//span[@class='select2-selection__rendered'])[3]");

	public static By searchBox = By.xpath("//input[@class='select2-search__field']");
	
//	public static By helloField = By.id("//input[contains(@id,'custom_fields[ambulance_call][11]')]");
	
	public static By paymentOption = By.xpath("//label[contains(text(),\"Payment Mode\")]/following::select[contains(@class,'payment_mode')][1]");

	public static By dynamicOption(String string) {
		return By.xpath("//li[contains(text(),'" + string + "')]");
	}

	public static By selectOption(String option) {
		return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + option + "')]");
	}
}