package pages;

import org.openqa.selenium.By;

public class AddPaymentPage {
	
	public static By addPaymentDiv = By.xpath("//tbody/child::tr[1][contains(@class,'odd')]");
	
	public static By addPayment = By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]/div/a[1]/i");
	
	public static By paymentPageTitle = By.xpath("//div[contains(@class,'modal-media-header')]/child::h4[contains(text(),'Payments')]");
	
	public static By date = By.xpath("//input[@id=\"date\"]");
	
	public static By amount = By.xpath("//*[@id=\"add_partial_payment\"]/div[2]/div/div/select");
	
	public static By note = By.xpath("//label[contains(text(),'Note')]//following::textarea[3]");
	
	public static By saveButton = By.xpath("//*[@id=\"add_partial_payment\"]/button");
	
	public static By saveSuccessMessage = By.xpath("//*[@id=\"toast-container\"]/div/div");
	
	public static By saveemptyMessage = By.xpath("//*[@id=\"toast-container\"]/div/div/p");
	
	public static By deleteDiv = By.xpath("//*[@id=\"addPaymentModal\"]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]");
	
	public static By deleteButton = By.xpath("//*[@id=\"addPaymentModal\"]/div/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[6]/div/a[2]/i");
	
	public static By deleteMessage = By.xpath("//*[@id=\"toast-container\"]/div/div");
	
}
