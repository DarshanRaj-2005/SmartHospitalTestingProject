package pages;

import org.openqa.selenium.By;

public class SearchAmbulanceRecordPages {
	
	public static By searchBox = By.xpath("//div[@id=\"DataTables_Table_0_filter\"]/label/child::input");
	public static By errMessage = By.xpath("//div[contains(text(),'No data available in table')]");
	public static By tableValue = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]");
}
