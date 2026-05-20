package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import Utilities.Helper;
import driver.Driver;

public class AddPatientPage {

    public static By patientCategory =
            By.xpath("//a[contains(@href,'patient') and .//span[contains(text(),'Patient')]]"
                   + " | //a[normalize-space(text())='Patient']"
                   + " | //span[normalize-space(text())='Patient']/parent::a");

    public static By addNewPatientButton =
            By.xpath("//a[contains(@class,'addpatient')]"
                   + " | //a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"
                   + " | //button[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]");
    public static By modalNameInput =
            By.xpath("//input[@id='name' or @name='name']"
                   + " | //div[@id='add_patient']//input[@placeholder='Name']");

    public static By patientName  = By.id("name");
    public static By guardianName = By.id("guardian_name");
    public static By gender       = By.id("gender");
    public static By bloodGroup   = By.id("blood_group");

    public static By dobYear  = By.xpath("//input[@placeholder='Year'  or @name='dob_year'  or @id='dob_year']");
    public static By dobMonth = By.xpath("//input[@placeholder='Month' or @name='dob_month' or @id='dob_month']");
    public static By dobDay   = By.xpath("//input[@placeholder='Day'   or @name='dob_day'   or @id='dob_day']");
    public static By dob      = By.xpath("//input[@id='dob' or @name='dob' or @placeholder='Date of Birth']");

    public static By phone   = By.xpath("//input[@id='phone' or @name='phone' or @id='mobile']");
    public static By email   = By.xpath("//input[@id='email' or @name='email']");
    public static By address = By.xpath("//input[@id='address' or @name='address']"
                                      + " | //textarea[@id='address' or @name='address']");

    public static By saveButton =
            By.xpath("//button[@type='submit' and contains(text(),'Save')]"
                   + " | //button[contains(@class,'btn-primary') and contains(text(),'Save')]"
                   + " | //button[contains(text(),'Save')]");

    public static By patientListTable =
            By.xpath("//table[contains(@id,'patient') or contains(@class,'patient')]"
                   + " | //div[@id='patient_list']"
                   + " | //div[contains(@class,'table-responsive')]//table");

    public static By tableCells =
            By.xpath("//div[contains(@class,'table-responsive')]//td"
                   + " | //table//td");

    public static By validationMessage =
            By.xpath("//*[contains(@class,'invalid-feedback') ")
                   + " | //*[contains(@class,'help-block') and contains(text(),'required')]"
                   + " | //*[contains(@class,'error') and string-length(text()) > 0]");
}
