package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import driver.Driver;

import Utilities.*;
public class AddNewStockPage {
	//buttons 
	public  By InventoryBar =
	        By.xpath("//span[contains(text(),'Inventory')]");
	public  By Addnewstock = By.xpath("//a[@class='btn btn-primary btn-sm additemstock']");		
	// select 
	public  By itemCategory = By.xpath("//select[@id='item_category_id']");
	public  By item =By.xpath("//select[@id='item_id']");
	public  By store = By.xpath("//select[@id='store_id']");
	public  By supplier =By.xpath("//select[@id='supplier_id']");
     
    // INPUT FIELDS
	public  By quantity =By.xpath("//input[@id='quantity']");
	public  By purchasePrice =By.xpath("//input[@id='purchase_price']");
	public  By description = By.xpath("//textarea[@id='description']");
	public  By saveButton = By.xpath("//button[@type= 'submit' and @id='form1btn']");
    
    //pop up alerts
    public By toastMessage = By.xpath("//div[contains(@class,'toast-message')]");
    
    
    
        
	
}
	
	
	
	
	
	
	
	
