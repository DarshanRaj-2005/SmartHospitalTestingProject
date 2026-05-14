package pages;

import org.openqa.selenium.By;
import Utilities.*;
public class AddNewStockPage {
	//buttons 
	By InventoryBar =
	        By.xpath("//a[contains(@href,'itemstock') and .//span[text()='Inventory']]");
	By Addnewstock = By.xpath("//a[@class='btn btn-primary btn-sm additemstock']");		
	// select 
    By itemCategory = By.xpath("//select[@id='item_category_id']");
    By item =By.xpath("//select[@id='item_id']");
    By store = By.xpath("//select[@id='store_id']");
    By supplier =By.xpath("//select[@id='supplier_id']");
     
    // INPUT FIELDS
    By quantity =By.xpath("//input[@id='quantity']");
    By purchasePrice =By.xpath("//input[@id='purchase_price']");
    By description = By.xpath("//textarea[@id='description']");
    By saveButton = By.xpath("//button[@type= 'submit' and @id='form1btn']");
    
    
   //click  
    public void clickInventory() {
    	Helper.waitForElementClickable(InventoryBar);

    	 Helper.click(InventoryBar);
    }

    public void clickAddItemStock() {
    	
    	Helper.waitForElementClickable(Addnewstock);
        Helper.click(Addnewstock);
    }

    //enter input fields
    public void enterQuantity(String qty) {

        Helper.type(quantity, qty);
    }

    public void enterPurchasePrice(String price) {

        Helper.type(purchasePrice, price);
    }

    public void enterDescription(String desc) {

        Helper.type(description, desc);
    }

    public void clickSaveButton() {

        Helper.click(saveButton);
    }
    
    // select  input 
    
    public void selecttheitems() {

        Helper.waitForVisibility(itemCategory);
        Helper.type(itemCategory, "Syringe Packs");

        Helper.waitForVisibility(item);
        Helper.type(item, "Syringe");

        Helper.waitForVisibility(store);
        Helper.type(store, "VK Supplier");

        Helper.waitForVisibility(supplier);
        Helper.type(supplier, "SK Pharma");
    }
    
	
}
	
	
	
	
	
	
	
	
