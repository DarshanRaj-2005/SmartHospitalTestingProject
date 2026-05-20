package pages;

import org.openqa.selenium.By;

import driver.Driver;

public class PharmacyBillPage {
	public static By pharmacyMenu = By.xpath("//span[normalize-space()='Pharmacy']");
	public static By pharmacyBillPageHeader = By.xpath("//h3[@class='box-title titlefix']");
	public static By searchInputbar = By.xpath("//input[@type=\"search\"]");
	public static By searchnamerow = By.xpath("//tbody/tr/td[4]");
	public static By noDataMessage = By.xpath("//td[@class='dataTables_empty']");
}