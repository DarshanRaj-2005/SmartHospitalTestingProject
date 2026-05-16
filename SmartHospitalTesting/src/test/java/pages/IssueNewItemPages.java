package pages;

import org.openqa.selenium.By;

public class IssueNewItemPages {
	
	
	//button When the user clicks the Issue Item button and the Issue New Item button
    public static By issueItemButton = By.xpath("//a[@href='https://demo.smart-hospital.in/admin/issueitem']");
    
    public static By issueNewItemButton =
            By.xpath("//a[contains(@class,'addissueitem')]");
    
    //selecting fields And the user select the userountacctype issuedate and retrundate  and itemcategory and item 
    public static By useraccounttype = By.xpath("//select[@name='account_type']");    
    public static By issueDateField = By.xpath("//input[@name='issue_date']");   
    public static By returnDateField = By.xpath("//input[@name='return_date']");  
    public static By itemCategoryDropdown = By.xpath("//select[@id='item_category_id']");  
    public static By itemDropdown = By.xpath("//select[@id='item_id']");
    
    
    
  
    //enter the details And  the user Enters the <"quality"> and <"note">
    public static By quantityField = By.xpath("//input[@name='quantity']");
    public static By noteField = By.xpath("//textarea[@name='note']");
    
    //button 
    public static By submitButton = By.xpath("//button[@type='submit' and @id='form1btn']");
    
    //toemessage 
    public static By toastMessage = By.xpath("//div[contains(@class,'toast-message')]");
}



