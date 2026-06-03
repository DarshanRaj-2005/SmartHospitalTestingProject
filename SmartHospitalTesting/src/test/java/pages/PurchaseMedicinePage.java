package pages;

import org.openqa.selenium.By;

public class PurchaseMedicinePage {


	public static By purchaseMedicineButton = By.xpath("//a[normalize-space()='Purchase']");
	public static By addPurchaseButton = By.xpath("//a[contains(@class,'addpurchase')]");
	public static By supplierDropdown = By.xpath("(//span[contains(@class,'select2-selection--single')])[1]");

	public static By supplierSearchBox = By
			.xpath("//span[contains(@class,'select2-container--open')]//input[@type='search']");
	public static By supplierOption(String supplier) {
		return By.xpath("//li[contains(@class,'select2-results__option') and normalize-space()='" + supplier + "']");
	}
	public static By medicineCategoryDropdown = By.name("medicine_category_id[]");
	public static By medicineDropdown = By.name("medicine_name[]");
	public static By batchNoField = By.id("batchno");
	public static By expiryMonthField = By.id("expiry");
	public static By mrpField = By.id("mrp");
	public static By batchAmountField = By.id("batch_amount");
	public static By salePriceField = By.id("sale_price");
	public static By packingQtyField = By.id("packing_qty");
	public static By quantityField = By.id("quantity0");
	public static By purchasePriceField = By.id("purchase_price0");
	public static By taxField = By.id("purchase_tax0");
	public static By paymentModeDropdown = By.name("payment_mode");
	public static By paymentNoteField = By.name("payment_note");
	public static By saveButton = By.xpath("//button[contains(text(),'Save')]");
	public static By successMessage = By.xpath("//*[contains(@class,'toast-success')] | "
			+ "//*[contains(@class,'alert-success')] | " + "//*[contains(@class,'swal2-success')] | "
			+ "//*[contains(text(),'successfully')] | " + "//*[contains(text(),'Successfully')]");
	public static By purchaseListIndicator = By.xpath("//a[contains(@class,'addpurchase')]");

}