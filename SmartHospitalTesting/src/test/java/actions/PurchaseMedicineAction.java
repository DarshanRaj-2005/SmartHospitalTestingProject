package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Utilities.Helper;
import pages.PurchaseMedicinePage;

public class PurchaseMedicineAction {

    Logger logger = LogManager.getLogger(PurchaseMedicineAction.class);

    public void clickPurchaseMedicineButton() {
        logger.info("Clicking Purchase nav menu link");
        Helper.click(PurchaseMedicinePage.purchaseMedicineButton);
    }

    // NEW: clicks the "Add Purchase" button to open the form
    public void clickAddPurchaseButton() {
        logger.info("Clicking Add Purchase button to open form");
        Helper.waitForVisibility(PurchaseMedicinePage.addPurchaseButton);
        Helper.click(PurchaseMedicinePage.addPurchaseButton);
    }

    public void selectSupplier(String supplier) {
        logger.info("Selecting supplier: " + supplier);
        Helper.moveToElementAndClick(PurchaseMedicinePage.supplierDropdown);
        Helper.waitForVisibility(PurchaseMedicinePage.supplierSearchBox);
        Helper.clearAndEnterText(PurchaseMedicinePage.supplierSearchBox, supplier);
        Helper.waitForVisibility(PurchaseMedicinePage.supplierOption(supplier));
        Helper.jsClick(PurchaseMedicinePage.supplierOption(supplier));
    }

    public void selectMedicineCategory(String category) {
        logger.info("Selecting medicine category: " + category);
        Helper.selectValue(PurchaseMedicinePage.medicineCategoryDropdown, category);
    }

    public void selectMedicine(String medicine) {
        logger.info("Selecting medicine: " + medicine);
        Helper.waitForDropdownEnabled(PurchaseMedicinePage.medicineDropdown);
        Helper.selectValue(PurchaseMedicinePage.medicineDropdown, medicine);
    }

    public void enterBatchNo(String batchNo) {
        logger.info("Entering batch no: " + batchNo);
        Helper.type(PurchaseMedicinePage.batchNoField, batchNo);
    }

    public void enterExpiryMonth(String expiryMonth) {
        logger.info("Entering expiry month: " + expiryMonth);
        Helper.setDate(PurchaseMedicinePage.expiryMonthField, expiryMonth);
    }

    public void enterMrp(String mrp) {
        logger.info("Entering MRP: " + mrp);
        Helper.type(PurchaseMedicinePage.mrpField, mrp);
    }

    public void enterBatchAmount(String batchAmount) {
        logger.info("Entering batch amount: " + batchAmount);
        Helper.type(PurchaseMedicinePage.batchAmountField, batchAmount);
    }

    public void enterSalePrice(String salePrice) {
        logger.info("Entering sale price: " + salePrice);
        Helper.type(PurchaseMedicinePage.salePriceField, salePrice);
    }

    public void enterPackingQty(String packingQty) {
        logger.info("Entering packing qty: " + packingQty);
        Helper.type(PurchaseMedicinePage.packingQtyField, packingQty);
    }

    public void enterQuantity(String quantity) {
        logger.info("Entering quantity: " + quantity);
        Helper.type(PurchaseMedicinePage.quantityField, quantity);
    }

    public void enterPurchasePrice(String purchasePrice) {
        logger.info("Entering purchase price: " + purchasePrice);
        Helper.type(PurchaseMedicinePage.purchasePriceField, purchasePrice);
    }

    public void enterTax(String tax) {
        logger.info("Entering tax: " + tax);
        Helper.type(PurchaseMedicinePage.taxField, tax);
    }

    public void selectPaymentMode(String paymentMode) {
        logger.info("Selecting payment mode: " + paymentMode);
        Helper.selectValue(PurchaseMedicinePage.paymentModeDropdown, paymentMode);
    }

    public void enterPaymentNote(String paymentNote) {
        logger.info("Entering payment note");
        Helper.type(PurchaseMedicinePage.paymentNoteField, paymentNote);
    }

    public void clickSaveButton() {
        logger.info("Clicking Save button");
        Helper.click(PurchaseMedicinePage.saveButton);
    }
}