package pages;



import org.openqa.selenium.By;

public class Additempage {

  
    public static By itembar = By.xpath(" //h3[normalize-space(text())=\"Item Stock List\"]/following::a[normalize-space(text())=\"Item\"]");
    public static By addNewItemBtn = By.xpath("//a[@class='btn btn-primary btn-sm additem']/child::i");
 
    public static By name = By.xpath("//input[@id='name']");

    public static By category = By.xpath("//select[@id = 'item_category_id']");
    
    public static By unit = By.xpath("//input[@id='unit']");

    public static By description = By.xpath("//textarea[@id='description']");

    public static By saveBtn = By.xpath("//button[normalize-space()='Save']");
    
   
}