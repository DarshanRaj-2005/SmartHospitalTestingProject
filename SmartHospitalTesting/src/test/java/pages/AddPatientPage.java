package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPatientPage {

    WebDriver driver;

    public AddPatientPage(WebDriver driver) {

        this.driver = driver;
    }
    By patientName =
            By.id("patient_name");

    By guardianName =
            By.id("guardian_name");

    By gender =
            By.id("gender");

    By phone =
            By.id("phone");

    By address =
            By.id("address");

    By saveButton =
            By.xpath("//button[contains(text(),'Save')]");

    By successMessage =
            By.xpath("//*[contains(text(),'successfully')]");

    // Methods

    public void enterPatientName(String value) {

        driver.findElement(patientName).sendKeys(value);
    }

    public void enterGuardianName(String value) {

        driver.findElement(guardianName).sendKeys(value);
    }

    public void selectGender(String value) {

        driver.findElement(gender).sendKeys(value);
    }

    public void enterPhoneNumber(String value) {

        driver.findElement(phone).sendKeys(value);
    }

    public void enterAddress(String value) {

        driver.findElement(address).sendKeys(value);
    }

    public void clickSaveButton() {

        driver.findElement(saveButton).click();
    }

    public boolean verifySuccessMessage() {

        return driver.findElement(successMessage)
                     .isDisplayed();
    }
}