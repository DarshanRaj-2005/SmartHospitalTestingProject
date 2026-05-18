package pages;



import org.openqa.selenium.By;

public class Additempage {

  
    public static By itembar = By.xpath("//a[@href='https://demo.smart-hospital.in/admin/item']");
    public static By addNewItemBtn = By.xpath("//a[@data-target='#myModal']");

    public static By name = By.xpath("//input[@id='name']");

    public static By category = By.xpath("//select[@id = 'item_category_id']");
    
    public static By unit = By.xpath("//input[@id='unit']");

    public static By description = By.xpath("//textarea[@id='description']");

    public static By saveBtn = By.xpath("//button[normalize-space()='Save']");
    
   
}