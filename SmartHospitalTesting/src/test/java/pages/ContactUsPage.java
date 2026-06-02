package pages;



import org.openqa.selenium.By;

public class ContactUsPage {

    public static By contactUsBtn = By.xpath("//a[normalize-space()='Contact Us']");
    ////li[contains(@class,'active')]//a[normalize-space()='Contact Us']

    public static By name = By.xpath("//input[@id='name']");
    public static By email = By.xpath("//input[@id='email']");
    public static By subject = By.xpath("//input[@id='subject']");
    public static By description = By.xpath("//textarea[@id='description']");

    public static By submit = By.xpath("//input[@name='submit']");
    
    public static By successMessage =By.xpath("//div[@class='alert alert-success']");
}
