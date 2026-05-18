package pages;

import org.openqa.selenium.By;

public class AddambulancePage {
	public static By addAmbulance = By.xpath("//ul[@class='sidebar-menu verttop']/li[11]/a");
	public static By addAmbulanceCall = By.xpath("//div[@class='box-tools pull-right']/a[1]");
	public static By vehicleModal = By.id("vehicle_no");
	public static By drivername = By.id("driver_search");
	public static By date = By.xpath("//*[@id=\"formcall\"]/div[1]/div/div/div[1]/div[3]/div/input");
	public static By chargeCategory = By.xpath("//*[@id=\"formcall\"]/div[1]/div/div/div[1]/div[4]/div/div/select");
	public static By chargeName = By.xpath("//select[@id='code']");
	public static By standardCharge = By.id("standard_charge");
	public static By note = By.id("note");
	public static By saveButton = By.id("formcallbtn");
	public static By title = By.xpath("/html/body/div[1]/div/section/div/div/div/div[1]/h3");
	public static By modelText = By.xpath("//*[@id=\"formcall\"]/div[1]/div/div/div[1]/div[1]/div/label");
	public static By errtext = By.xpath("//*[@id=\"toast-container\"]/div/div/p[1]");
	public static By patient = By.xpath("//*[@id=\"myModal\"]/div/div/div/div/div[1]/div/span[1]/span[1]/span");
	public static By patientInput = By.xpath("/html/body/span/span/span[1]/input");
	public static By successMessage = By.xpath("//*[@id=\"toast-container\"]/div/div");
	public static By chargeNameOption = By.xpath("//*[@id=\"select2-code-result-vmxq-17\"]");
	public static By invalidamountmess = By.xpath("//*[@id=\"toast-container\"]/div/div/p[2]");
	
	public static By dynamicOption(String option) {
		return By.xpath("//li[contains(text(),'"+option+"')]");
	}
}