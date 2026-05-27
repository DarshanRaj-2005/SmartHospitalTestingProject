package actions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.CsvReader;
import Utilities.Helper;
import driver.Driver;
import pages.AddPaymentPage;


public class AddPaymentAction {

	public static void clickAddPayment() {
		WebElement element = Driver.getDriver().findElement(AddPaymentPage.addPaymentDiv);
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(element).perform();
		Helper.click(AddPaymentPage.addPayment);
	}
	
	public static String checkPaymentTitle() {
		Helper.waitForVisibility(AddPaymentPage.paymentPageTitle);
		String title = Helper.getText(AddPaymentPage.paymentPageTitle);
		return title;
	}
	
	public static void clickSave() {
		Helper.click(AddPaymentPage.saveButton);
	}
	
	public static String checkSavemessage() {
		Helper.waitForVisibility(AddPaymentPage.saveSuccessMessage);
		String message = Helper.getText(AddPaymentPage.saveSuccessMessage);
		return message;
	}
	
	public static void enterPaymentDetails() {

	    List<String[]> data =
	            CsvReader.readCsv("src\\test\\resources\\test_datas\\payment.csv");

	    String[] row = data.get(0);

	    Helper.setDate(AddPaymentPage.date, row[0]);

	    Helper.type(AddPaymentPage.note, row[1]);
	}
	
	public static String saveEmptyCheck() {
		Helper.waitForVisibility(AddPaymentPage.saveemptyMessage);
		String message = Helper.getText(AddPaymentPage.saveemptyMessage);
		return message;
	}
	
	public static void deletePayment() {
		WebElement element = Driver.getDriver().findElement(AddPaymentPage.deleteDiv);
		Actions action = new Actions(Driver.getDriver());
		action.moveToElement(element).perform();
		Helper.click(AddPaymentPage.deleteButton);
		Helper.waitForAlert();
		Alert alert = Driver.getDriver().switchTo().alert();
		alert.accept();
	}
	
	public static String deletemessage() {
		Helper.waitForVisibility(AddPaymentPage.deleteMessage);
		String message = Helper.getText(AddPaymentPage.deleteMessage);
		return message;
	}

}
