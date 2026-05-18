package pages;

import org.openqa.selenium.By;

public class  ComplaintPage	 {

    public static By complaintBtn = By.xpath("//a[normalize-space()='Complain']");

    public static By name = By.id("name");
    public static By email = By.id("email");
    public static By contact = By.id("contact");
    public static By description = By.id("description");

    public static By submit = By.xpath("//input[@name='submit']");

    public static By successMsg = By.xpath("//div[contains(@class,'alert-success')]");
    public static By errorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
}