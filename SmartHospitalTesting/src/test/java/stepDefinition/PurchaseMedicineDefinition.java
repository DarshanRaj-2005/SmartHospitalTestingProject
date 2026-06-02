package stepDefinition;

import java.util.List;
import org.testng.Assert;
import Utilities.CsvReader;
import Utilities.Helper;
import actions.PurchaseMedicineAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PurchaseMedicinePage;

public class PurchaseMedicineDefinition {

	PurchaseMedicineAction purchase = new PurchaseMedicineAction();

	@When("the user clicks the Purchase Medicine button")
	public void the_user_clicks_the_purchase_medicine_button() {
		// Clicks Purchase nav link, then Add Purchase to open the form
		purchase.clickPurchaseMedicineButton();
		purchase.clickAddPurchaseButton();
	}

	@Then("the Purchase Medicine page should be displayed")
	public void the_purchase_medicine_page_should_be_displayed() {
		// Supplier dropdown visible = form is fully loaded and ready
		Helper.waitForVisibility(PurchaseMedicinePage.supplierDropdown);
		Assert.assertTrue(Helper.isDisplayed(PurchaseMedicinePage.supplierDropdown),
				"Purchase Medicine form did not load — supplier dropdown not visible");
	}

	@When("the user enters purchase medicine details from csv")
	public void the_user_enters_purchase_medicine_details_from_csv() {
		List<String[]> purchaseData = CsvReader.readCsv("src/test/resources/test_datas/purchaseMedicineData.csv");

		for (String[] data : purchaseData) {
			String supplier = data[0];
			String category = data[1];
			String medicine = data[2];
			String batchNo = data[3];
			String expiryMonth = data[4];
			String mrp = data[5];
			String batchAmount = data[6];
			String salePrice = data[7];
			String packingQty = data[8];
			String quantity = data[9];
			String purchasePrice = data[10];
			String tax = data[11];
			String paymentMode = data[12];
			String paymentNote = data[13];

			purchase.selectSupplier(supplier);
			purchase.selectMedicineCategory(category);
			purchase.selectMedicine(medicine);
			purchase.enterBatchNo(batchNo);
			purchase.enterExpiryMonth(expiryMonth);
			purchase.enterMrp(mrp);
			purchase.enterBatchAmount(batchAmount);
			purchase.enterSalePrice(salePrice);
			purchase.enterPackingQty(packingQty);
			purchase.enterQuantity(quantity);
			purchase.enterPurchasePrice(purchasePrice);
			purchase.enterTax(tax);
			purchase.selectPaymentMode(paymentMode);
			purchase.enterPaymentNote(paymentNote);
		}
	}

	@When("the user clicks Purchase Save button")
	public void the_user_clicks_purchase_save_button() {
		purchase.clickSaveButton();
	}

	@Then("the medicine purchase should be successful")
	public void the_medicine_purchase_should_be_successful() {
		Helper.waitForVisibility(PurchaseMedicinePage.addPurchaseButton);
		Assert.assertTrue(Helper.isDisplayed(PurchaseMedicinePage.addPurchaseButton), "Purchase not done successfully");
	}
}