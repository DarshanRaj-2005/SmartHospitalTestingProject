package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utilities.Helper;
import driver.Driver;
import pages.SearchAmbulanceRecordPages;

public class SearchAmbulanceRecordAction {
	
	public static void typeInput(String value) {
		Helper.type(SearchAmbulanceRecordPages.searchBox,value);
	}
	
	public static String getMatchingValue(String value) {
		Helper.waitForTextToBePresentInElementLocated(By.xpath("//table/tbody/tr[1]/td[2]"),
				value);
		String actualValue = Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[2]"))
		        .getText();
		return actualValue;
	}
	
	public static String getErrorMessage() {
		Helper.waitForVisibility(SearchAmbulanceRecordPages.errMessage);
		WebElement errMess = Driver.getDriver().findElement(SearchAmbulanceRecordPages.errMessage);
		String message = errMess.getText().split("\n")[0].trim();
		System.out.println(message);
		return message;
	}
}
