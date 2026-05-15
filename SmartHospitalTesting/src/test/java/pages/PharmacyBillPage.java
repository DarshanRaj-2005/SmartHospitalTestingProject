package pages;

import org.openqa.selenium.By;

public class PharmacyBillPage {
    public static By pharmacyMenu = By.xpath("//span[normalize-space()='Pharmacy']");
    public static By pharmacyBillPageHeader = By.xpath("//h3[contains(text(),'Pharmacy Bill')]");
}
