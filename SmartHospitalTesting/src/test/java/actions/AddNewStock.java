package actions;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Utilities.Helper;
import driver.Driver;
import pages.AddNewStockPage;

public class AddNewStock {
	 Logger logger = LogManager.getLogger(AddNewStock.class);
	AddNewStockPage element = new AddNewStockPage();

	//click  
    public void clickInventory() {
    	   logger.info("Clicking Inventory");
    	Helper.newmoveToElementAndClick(element.InventoryBar);
    }

    public void clickAddItemStock() {
    	 logger.info("Clicking Add Item Stock");
    	
    	Helper.waitForElementClickable(element.Addnewstock);
        Helper.click(element.Addnewstock);
    }

    //enter input fields
    public void enterQuantity(String qty) {
        logger.info("Entering Quantity: " + qty);

        Helper.type(element.quantity, qty);
    }

    public void enterPurchasePrice(String price) {
    	  logger.info("Entering Purchase Price: " + price);
        Helper.type(element.purchasePrice, price);
    }

    public void enterDescription(String desc) {

        Helper.type(element.description, desc);
    }
    
    
    //single funtion
    public void fillStockDetails(
            String qty,
            String price,
            String desc) {

        enterQuantity(qty);
        enterPurchasePrice(price);
        enterDescription(desc);
    }

    public void clickSaveButton() {
    	 logger.info("Clicking Save Button");

        Helper.click(element.saveButton);
    }
    
    // select  input 
    
    public void selecttheitems() {
    	   logger.info("Filling Stock Details");

        Helper.waitForVisibility(element.itemCategory);
        Helper.type(element.itemCategory, "Syringe Packs");

        Helper.waitForVisibility(element.item);
        Helper.type(element.item, "Syringe");

        Helper.waitForVisibility(element.store);
        Helper.type(element.store, "VK Supplier");

        Helper.waitForVisibility(element.supplier);
        Helper.type(element.supplier, "SK Pharma");
    }
    
    //error message for the missing field
    public void HandleTheMessage() {
    	Helper.waitForVisibility(element.toastMessage);
        Assert.assertTrue(
            Driver.getDriver().findElement(element.toastMessage).isDisplayed()
        );
       
    }
}