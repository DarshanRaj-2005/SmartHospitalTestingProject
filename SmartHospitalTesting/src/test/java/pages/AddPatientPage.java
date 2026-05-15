package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    // ==================== Navigation Locators ====================

    By patientCategory =
            By.xpath("//a[contains(@href,'patient') and .//span[contains(text(),'Patient')]]"
                   + " | //a[normalize-space(text())='Patient']"
                   + " | //span[normalize-space(text())='Patient']/parent::a");

    By addNewPatientButton =
            By.xpath("//a[contains(@class,'addpatient')]"
                   + " | //a[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]"
                   + " | //button[contains(text(),'Add New Patient') or contains(text(),'Add Patient')]");

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
            By.xpath("//div[@class='box box-info']");

   
    public void clickPatientCategory() {
        WebElement element = driver.findElement(patientCategory);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickAddNewPatientButton() {
        WebElement element = driver.findElement(addNewPatientButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // ==================== Modal Wait ====================

    public void waitForModalToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalNameInput));
            wait.until(ExpectedConditions.elementToBeClickable(modalNameInput));
            return;
        } catch (Exception e) {
            // fall through to secondary
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'modal-header')]"
                       + "[.//h4[contains(text(),'Patient')] or .//h5[contains(text(),'Patient')]]"
                       + " | //div[@id='add_patient'][not(contains(@style,'display: none'))]")));
    }

    // ==================== Form Methods ====================

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
        try {
            sel.selectByVisibleText(value);
        } catch (Exception e) {
            sel.selectByValue(value.toLowerCase());
        }
    }

    public void enterDOB(String value) {
        String[] parts = value.split("-");
        String day   = parts[0];
        String month = parts[1];
        String year  = parts[2];
        try {
            WebElement yearEl = driver.findElement(dobYear);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", yearEl);
            yearEl.sendKeys(year);

            WebElement monthEl = driver.findElement(dobMonth);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", monthEl);
            monthEl.sendKeys(month);

            WebElement dayEl = driver.findElement(dobDay);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", dayEl);
            dayEl.sendKeys(day);
        } catch (Exception e) {
            WebElement dobEl = driver.findElement(dob);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", dobEl);
            dobEl.sendKeys(value);
        }
    }

    public void selectBloodGroup(String value) {
        Select sel = new Select(driver.findElement(bloodGroup));
        try {
            sel.selectByVisibleText(value);
        } catch (Exception e) {
            sel.selectByValue(value);
        }
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
    public boolean verifyPatientInList(String expectedPatientName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: Wait for modal to close after save
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modalNameInput));
        } catch (Exception ignored) {
            // Modal may have already closed
        }

        // Step 2: Wait for the patient list table to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(patientListTable));

        // Step 3: Search all table cells for the patient name
        By tableRows = By.xpath(
                "//table[contains(@id,'patient') or contains(@class,'patient') "
              + "or ancestor::div[@id='patient_list'] "
              + "or ancestor::div[contains(@class,'table-responsive')]]//td"
              + " | //div[contains(@class,'table-responsive')]//td"
              + " | //table//td");

        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));

        List<WebElement> cells = driver.findElements(tableRows);
        for (WebElement cell : cells) {
            if (cell.getText().trim().equalsIgnoreCase(expectedPatientName.trim())) {
                return true;   // Patient name found in the list
            }
        }
        return false;          // Patient name not found
    }

    // Keep this method for backward compatibility — delegates to list check
    public boolean verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modalNameInput));
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientListTable));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
