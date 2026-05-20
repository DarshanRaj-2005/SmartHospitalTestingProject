package pages;

import org.openqa.selenium.By;

public class Addmedicine {

    public static By addMedicineBtn = By.xpath("//button[contains(text(),'Add Medicine')]");
    public static By saveBtn = By.xpath("//button[contains(text(),'Save')]");

    public static By medicineName = By.name("medicineName");
    public static By category = By.name("category");
    public static By batch = By.name("batch");
    public static By expiryDate = By.name("expiryDate");
    public static By quantity = By.name("quantity");
    public static By rate = By.name("rate");
    public static By manufacturer = By.name("manufacturer");
    public static By successMsg = By.xpath("//div[contains(@class,'alert-success')]");
    public static By errorMsg = By.xpath("//div[contains(@class,'alert-danger')]");
    public static By tableRows = By.xpath("//table//tr");
}