package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class AddPatientPage {

    WebDriver driver;

    public AddPatientPage(WebDriver driver) {
        this.driver = driver;
    }

    By patientCategory =
            By.xpath("//a[contains(@href,'patient') and .//span[contains(text(),'Patient')]]"
                   + " | //a[normalize-space(text())='Patient']"
                   + " | //span[normalize-space(text())='Patient']/parent::a");

    By addNewPatientButton =
            By.xpath("//a[contains(@class,'addpatient')]"
                   + " | //a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"
                   + " | //button[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]");
    By Title =
            By.xpath("//h4[contains(text(),'Add Patient')] | //h5[contains(text(),'Add Patient')]"
                   + " | //*[contains(@class,'modal-title') and contains(text(),'Add Patient')]");
    // ==================== Modal Wait Locator ====================

    By modalNameInput =
            By.xpath(" //input[@id='name']");
    // ==================== Form Field Locators ====================

    By patientName  = By.id("name");
    By guardianName = By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6']//input[@name='guardian_name']");
    By gender       = By.xpath("//select[@id='addformgender']");
    By bloodGroup   = By.xpath("//div[@class='col-sm-3']//select[@name='blood_group']");

    By dobYear  = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//div[@class='col-md-6 col-sm-12']//div[@class='row']//div[@id='calculate']//div[@class='form-group']//div//input[@id='age_year']");
    By dobMonth = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//div[@class='col-md-6 col-sm-12']//div[@class='row']//div[@id='calculate']//div[@class='form-group']//div//input[@id='age_month']");
    By dobDay   = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//div[@class='col-md-6 col-sm-12']//div[@class='row']//div[@id='calculate']//div[@class='form-group']//div//input[@id='age_day']");
    By dob      = By.xpath("//input[@id='birth_date']");

    By phone   = By.xpath("//input[@id='number']");
    By email   = By.xpath("//input[@id='addformemail']");
    By address = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']//input[@name='address']");
    By saveButton = By.xpath("//button[@id='formaddpabtn']//i[@class='fa fa-check-circle']");

    
    By patientListTable =
            By.xpath("//div[@class='box-body']");

    By validationErrorText =
            By.xpath("//div[contains(@class,'modal-body')]"
                   + "//*[contains(text(),'required') or contains(text(),'Required')"
                   + " or contains(text(),'field is required') or contains(text(),'This field')"
                   + " or contains(@class,'error') or contains(@class,'invalid-feedback')"
                   + " or contains(@class,'help-block') or contains(@class,'text-danger')]");

    // Red border / error class on the Name input (has-error wrapper)
    By nameFieldError =
            By.xpath("//div[contains(@class,'has-error') or contains(@class,'is-invalid')]"
                   + " | //div[contains(@class,'modal-body')]//input[contains(@class,'error') or contains(@class,'is-invalid')]");
    By Message =
            By.xpath("//*[contains(@class,'iziToast-message') or contains(@class,'toast-message')"
                   + " or contains(@class,'alert-success') or contains(@class,'alert alert-success')]");
    public void clickPatientCategory() {
        WebElement el = driver.findElement(patientCategory);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void clickAddNewPatientButton() {
        WebElement el = driver.findElement(addNewPatientButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    // =====================================================================
    // MODAL WAIT
    // =====================================================================

    public void waitForModalToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated( Title));
        wait.until(ExpectedConditions.elementToBeClickable(patientName));
    }

    // =====================================================================
    // MANDATORY FIELDS — Leave all empty (do nothing)
    // The Name * field is already empty when modal opens.
    // This method ensures all inputs are cleared just in case.
    // =====================================================================

    public void leaveMandatoryFieldsEmpty() {
        // Clear the Name field (mandatory) using JS
        try {
            WebElement el = driver.findElement(patientName);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        } catch (Exception ignored) {}
    }

    // =====================================================================
    // FORM METHODS
    // =====================================================================

    public void enterPatientName(String value) {
        WebElement el = driver.findElement(patientName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        el.sendKeys(value);
    }

    public void enterGuardianName(String value) {
        WebElement el = driver.findElement(guardianName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        el.sendKeys(value);
    }

    public void selectGender(String value) {
        Select sel = new Select(driver.findElement(gender));
        sel.selectByVisibleText(value);
    }

    public void enterDOB(String value) {
        String[] parts = value.split("-");
        String day   = parts[0];
        String month = parts[1];
        String year  = parts[2];

        try {
            WebElement el = driver.findElement(dob);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
            el.sendKeys(value);
        } catch (Exception ignored) {}

        try {
            WebElement el = driver.findElement(dobYear);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
            el.sendKeys(year);
        } catch (Exception ignored) {}

        try {
            WebElement el = driver.findElement(dobMonth);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
            el.sendKeys(month);
        } catch (Exception ignored) {}

        try {
            WebElement el = driver.findElement(dobDay);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
            el.sendKeys(day);
        } catch (Exception ignored) {}
    }

    public void selectBloodGroup(String value) {
        Select sel = new Select(driver.findElement(bloodGroup));
        sel.selectByVisibleText(value);
    }

    public void enterPhoneNumber(String value) {
        WebElement el = driver.findElement(phone);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        el.sendKeys(value);
    }

    public void enterEmail(String value) {
        WebElement el = driver.findElement(email);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        el.sendKeys(value);
    }

    public void enterAddress(String value) {
        WebElement el = driver.findElement(address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        el.sendKeys(value);
    }

    public void clickSaveButton() {
        WebElement el = driver.findElement(saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    // =====================================================================
    // SUCCESS VERIFICATION — 3-Strategy
    // =====================================================================

    public boolean verifyPatientSavedSuccessfully(String savedPatientName) {

        // Strategy 1 — Toast message
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(Message));
            return true;
        } catch (TimeoutException ignored) {}

        // Strategy 2 — Modal closes + patient list table reappears
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(Title));
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientListTable));
            return true;
        } catch (TimeoutException ignored) {}

        // Strategy 3 — Find patient name in the table (names shown as "Ramya (363)")
        try {
            By patientRow = By.xpath(
                    "//table[contains(@class,'table')]//td[contains(text(),'"
                    + savedPatientName + "')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientRow));
            List<WebElement> rows = driver.findElements(patientRow);
            return !rows.isEmpty();
        } catch (TimeoutException ignored) {}

        return false;
    }

 
    public boolean verifyValidationMessageDisplayed() {

        // Strategy 1 — Validation error text inside the modal
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(validationErrorText));
            return true;
        } catch (TimeoutException ignored) {}

        // Strategy 2 — Red border / error class on the Name field
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldError));
            return true;
        } catch (TimeoutException ignored) {}

        // Strategy 3 — Modal is still open (save was rejected)
        // If modal title is still visible after clicking Save = validation prevented save
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
            return true;
        } catch (TimeoutException ignored) {}

        return false;
    }
}
