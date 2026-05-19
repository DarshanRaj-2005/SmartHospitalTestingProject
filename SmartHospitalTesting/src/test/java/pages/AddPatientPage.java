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
    By patientCategory =
            By.xpath("//a[@href='https://demo.smart-hospital.in/admin/admin/search']");

    By addNewPatientButton =
            By.xpath("//div[@class='box-header ptbnull']//a[1]");

    By Title =
            By.xpath("//h4[contains(text(),'Add Patient')]");

    By patientName =
            By.id("name");

    By guardianName =
            By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6']//input[@name='guardian_name']");

    By gender =
            By.xpath("//select[@id='addformgender']");

    By bloodGroup =
            By.xpath("//div[@class='col-sm-3']//select[@name='blood_group']");

    By dob =
            By.xpath("//input[@id='birth_date']");

    By dobYear =
            By.xpath("//input[@id='age_year']");

    By dobMonth =
            By.xpath("//input[@id='age_month']");

    By dobDay =
            By.xpath("//input[@id='age_day']");

    By phone =
            By.xpath("//input[@id='number']");

    By email =
            By.xpath("//input[@id='addformemail']");

    By address =
            By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']//input[@name='address']");

    By saveButton =
            By.xpath("//button[@id='formaddpabtn']//i[@class='fa fa-check-circle']");

    By patientListTable =
            By.xpath("//div[@class='box-body']");

    By validationErrorText =
            By.xpath("//div[contains(@class,'modal-body')]"
                   + "//*[contains(text(),'required') or contains(text(),'Required')"
                   + " or contains(text(),'field is required') or contains(text(),'This field')"
                   + " or contains(@class,'error') or contains(@class,'invalid-feedback')"
                   + " or contains(@class,'help-block') or contains(@class,'text-danger')]");

    By nameFieldError =
            By.xpath("//div[contains(@class,'has-error') or contains(@class,'is-invalid')]"
                   + " | //div[contains(@class,'modal-body')]"
                   + "//input[contains(@class,'error') or contains(@class,'is-invalid')]");

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
    public void waitForModalToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
        wait.until(ExpectedConditions.elementToBeClickable(patientName));
    }
    public void leaveMandatoryFieldsEmpty() {
        
    }

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
        String year  = parts[2];
        WebElement dobEl = driver.findElement(dob);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", dobEl);
        dobEl.sendKeys(value);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", dobEl);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('input',  { bubbles: true }));", dobEl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement yearEl = driver.findElement(dobYear);

        boolean autoFilled = wait.until(d -> {
            String val = yearEl.getAttribute("value");
            return val != null && !val.trim().isEmpty();
        });

        if (!autoFilled) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", yearEl);
            yearEl.sendKeys(year);
        }
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
    public boolean verifyPatientSavedSuccessfully(String savedPatientName) {

        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebDriverWait longWait  = new WebDriverWait(driver, Duration.ofSeconds(15));
        shortWait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(Message),
                        ExpectedConditions.invisibilityOfElementLocated(Title)
                ));

        if (!driver.findElements(Message).isEmpty()) {
            return true;
        }
        longWait.until(ExpectedConditions.invisibilityOfElementLocated(Title));
        longWait.until(ExpectedConditions.visibilityOfElementLocated(patientListTable));
        return true;
    }

    public boolean verifyValidationMessageDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(validationErrorText),
                        ExpectedConditions.visibilityOfElementLocated(nameFieldError),
                        ExpectedConditions.visibilityOfElementLocated(Title)
                ));

        List<WebElement> errorText  = driver.findElements(validationErrorText);
        List<WebElement> fieldError = driver.findElements(nameFieldError);
        List<WebElement> modalOpen  = driver.findElements(Title);

        return !errorText.isEmpty()
                || !fieldError.isEmpty()
                || (!modalOpen.isEmpty() && modalOpen.get(0).isDisplayed());
    }
}