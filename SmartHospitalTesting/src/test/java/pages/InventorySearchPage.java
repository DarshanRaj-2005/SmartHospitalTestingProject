package pages;

import org.openqa.selenium.By;

public class InventorySearchPage {
 
	public static By itemNames =By.xpath("//table[@id='DataTables_Table_0']//tbody//tr//td[1]");
	public static By searchBox =By.xpath("//input[@type='search']");
	public static  By noDataText = By.xpath("//div[contains(text(),'No data available in table')]");
		
}