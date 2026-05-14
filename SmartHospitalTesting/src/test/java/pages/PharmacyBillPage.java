package pages;

import org.openqa.selenium.By;

public class PharmacyBillPage {

    // Pharmacy menu
    public static By pharmacyMenu =
            By.xpath("//span[normalize-space()='Pharmacy']");

    // Pharmacy Bill page heading
    public static By pharmacyBillPageHeader =
            By.xpath("//h3[contains(text(),'Pharmacy Bill')]");
}