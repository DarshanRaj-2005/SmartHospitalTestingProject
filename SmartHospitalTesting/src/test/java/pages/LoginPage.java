package pages;

import org.openqa.selenium.By;

public class LoginPage {
	public static By superAdmin = By.xpath("//*[contains(text(),'Super Admin')]");
	public static By signin = By.xpath("//button[text()='Sign In']");
	public static By email = By.id("email");
	public static By text = By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[1]");
	public static By texts = By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/form/div[1]/span/p");
	public static By dashboard = By.xpath("//*[@id=\"alert\"]/nav/div[1]/span");
	public static By password = By.id("password");
}
