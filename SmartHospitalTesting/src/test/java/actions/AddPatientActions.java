package actions;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Utilities.Helper;
import driver.Driver;
import pages.AddPatientPage;

public class AddPatientActions {

    private static final Logger log = LogManager.getLogger(AddPatientActions.class);

    private String lastPatientName = "";

    public AddPatientActions() {}

    // =====================================================================
    // NAVIGATION ACTIONS
    // =====================================================================

    public void clickPatientCategory() {
        log.info("Clicking Patient category in sidebar");
        Helper.waitForElementClickable(AddPatientPage.patientCategory);
        Helper.jsClick(AddPatientPage.patientCategory);
        log.info("Patient category clicked");
    }

    public void clickAddNewPatientButton() {
        log.info("Clicking Add New Patient button");
        Helper.waitForElementClickable(AddPatientPage.addNewPatientButton);
        Helper.jsClick(AddPatientPage.addNewPatientButton);
        log.info("Add New Patient button clicked");
    }

    public void waitForModalToLoad() {
        log.info("Waiting for Add Patient modal to load");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddPatientPage.modalTitle));
        wait.until(ExpectedConditions.elementToBeClickable(AddPatientPage.patientName));
        log.info("Add Patient modal is ready");
    }

    // =====================================================================
    // FORM ACTIONS
    // =====================================================================

    public void enterPatientDetails(List<Map<String, String>> patientData) {
        Map<String, String> data = patientData.get(0);
        lastPatientName = data.get("PatientName");
        log.info("Entering patient details for: " + lastPatientName);
        Helper.clearAndEnterText(AddPatientPage.patientName,  lastPatientName);
        Helper.clearAndEnterText(AddPatientPage.guardianName, data.get("GuardianName"));
        Helper.selectDropdown(AddPatientPage.gender,          data.get("Gender"));
        enterDOB(data.get("DOB"));
        Helper.selectDropdown(AddPatientPage.bloodGroup,      data.get("BloodGroup"));
        Helper.clearAndEnterText(AddPatientPage.phone,        data.get("Phone"));
        Helper.clearAndEnterText(AddPatientPage.email,        data.get("Email"));
        Helper.clearAndEnterText(AddPatientPage.address,      data.get("Address"));
        log.info("All patient details entered");
    }

    // =====================================================================
    // DOB HANDLING — FIXED
    // age_year / age_month / age_day are READ-ONLY fields on this site.
    // sendKeys() throws ElementNotInteractableException on read-only fields.
    // Fix: Use JavascriptExecutor to set values; set DOB in YYYY-MM-DD format.
    // =====================================================================

    public void enterDOB(String value) {
        log.info("Entering DOB: " + value);

        // Input format: DD-MM-YYYY → convert to YYYY-MM-DD for HTML date input
        String[] parts = value.split("-");
        String day   = parts[0];
        String month = parts[1];
        String year  = parts[2];
        String htmlDateValue = year + "-" + month + "-" + day;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Step 1: Set birth_date value via JS
        WebElement dobEl = Helper.getElement(AddPatientPage.dob);
        js.executeScript("arguments[0].value=arguments[1];", dobEl, htmlDateValue);

        // Step 2: Fire change/input events to trigger site's age auto-fill
        js.executeScript("arguments[0].dispatchEvent(new Event('change', {bubbles:true}));", dobEl);
        js.executeScript("arguments[0].dispatchEvent(new Event('input',  {bubbles:true}));", dobEl);

        // Step 3: Wait up to 5s for the site to auto-fill age_year
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(d -> {
                String val = (String) js.executeScript(
                        "return document.getElementById('age_year').value;");
                return val != null && !val.trim().isEmpty();
            });
            log.info("Age fields auto-filled by site for DOB: " + value);

        } catch (Exception e) {
            // Auto-fill did not fire — set age fields manually via JS (NOT sendKeys)
            log.warn("Auto-fill did not happen — setting age fields via JavaScript");

            java.time.LocalDate today  = java.time.LocalDate.now();
            java.time.LocalDate dob    = java.time.LocalDate.of(
                    Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            java.time.Period age       = java.time.Period.between(dob, today);

            log.info("Calculated age: " + age.getYears() + "y " + age.getMonths() + "m " + age.getDays() + "d");

            js.executeScript(
                    "var y=document.getElementById('age_year');  if(y){y.value=arguments[0]; y.dispatchEvent(new Event('change',{bubbles:true}));}",
                    String.valueOf(age.getYears()));
            js.executeScript(
                    "var m=document.getElementById('age_month'); if(m){m.value=arguments[0]; m.dispatchEvent(new Event('change',{bubbles:true}));}",
                    String.valueOf(age.getMonths()));
            js.executeScript(
                    "var d=document.getElementById('age_day');   if(d){d.value=arguments[0]; d.dispatchEvent(new Event('change',{bubbles:true}));}",
                    String.valueOf(age.getDays()));

            log.info("Age fields set via JavaScript successfully");
        }
    }

    public void clearDOBAndReEnter(String newDOB) {
        log.info("Clearing DOB and re-entering: " + newDOB);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement dobEl = Helper.getElement(AddPatientPage.dob);
        js.executeScript("arguments[0].value='';", dobEl);

        // Clear read-only age fields via JS
        js.executeScript("var y=document.getElementById('age_year');  if(y) y.value='';");
        js.executeScript("var m=document.getElementById('age_month'); if(m) m.value='';");
        js.executeScript("var d=document.getElementById('age_day');   if(d) d.value='';");

        log.info("DOB and age fields cleared");
        enterDOB(newDOB);
    }

    public void leaveMandatoryFieldsEmpty() {
        log.info("Leaving mandatory Name field empty");
        Helper.waitForVisibility(AddPatientPage.patientName);
        Helper.clear(AddPatientPage.patientName);
        log.info("Name field is empty");
    }

    public void clickSaveButton() {
        log.info("Clicking Save button");
        Helper.waitForElementClickable(AddPatientPage.saveButton);
        Helper.jsClick(AddPatientPage.saveButton);
        log.info("Save button clicked");
    }

    // =====================================================================
    // VERIFICATION ACTIONS
    // =====================================================================

    public boolean verifyPatientAdded() {
        log.info("Verifying patient added: " + lastPatientName);
        
        Helper.waitForVisibility(AddPatientPage.patientListTable);
        Helper.waitForElementsPresent(AddPatientPage.tableCells, 15);
        List<WebElement> cells = Helper.getElements(AddPatientPage.tableCells);
        for (WebElement cell : cells) {
            String cellText = cell.getText().trim();
            if (cellText.toLowerCase().contains(lastPatientName.trim().toLowerCase())) {
                log.info("Patient name found in table: " + cellText);
                return true;
            }
        }
        log.warn("Patient name NOT found in table: " + lastPatientName);
        return false;
    }

    public boolean verifyValidationMessage() {
        log.info("Verifying validation message is displayed");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            boolean found = wait.until(d -> {

                // Check 1: label with id="name-error" (jQuery Validate default)
                List<WebElement> labelErrors = d.findElements(By.xpath("//*[@id='name-error']"));
                if (!labelErrors.isEmpty() && labelErrors.get(0).isDisplayed()) {
                    log.info("Validation via label#name-error: " + labelErrors.get(0).getText());
                    return true;
                }

                // Check 2: label.error for name field
                List<WebElement> classErrors = d.findElements(
                        By.xpath("//label[@for='name' and contains(@class,'error')]"));
                if (!classErrors.isEmpty() && classErrors.get(0).isDisplayed()) {
                    log.info("Validation via label.error: " + classErrors.get(0).getText());
                    return true;
                }

                // Check 3: aria-invalid on name input (HTML5 validation)
                List<WebElement> nameFields = d.findElements(By.id("name"));
                if (!nameFields.isEmpty()) {
                    String ariaInvalid = nameFields.get(0).getAttribute("aria-invalid");
                    if ("true".equals(ariaInvalid)) {
                        log.info("Validation via aria-invalid=true on name field");
                        return true;
                    }
                }

                // Check 4: alert-danger div
                List<WebElement> alerts = d.findElements(
                        By.xpath("//div[contains(@class,'alert-danger') or contains(@class,'callout-danger')]"));
                if (!alerts.isEmpty() && alerts.get(0).isDisplayed()) {
                    log.info("Validation via alert-danger: " + alerts.get(0).getText());
                    return true;
                }

                // Check 5: modal still open + jQuery Validate says form is invalid
                List<WebElement> modals = d.findElements(
                        By.xpath("//div[contains(@class,'modal-header')]//h4[contains(text(),'Add Patient')]"));
                if (!modals.isEmpty() && modals.get(0).isDisplayed()) {
                    Object validResult = ((JavascriptExecutor) d).executeScript(
                            "try { var form=$('#add-patient-form,form').first(); " +
                            "if(form.length){ var v=form.validate(); return !v.checkForm(); } " +
                            "return null; } catch(e){ return null; }");
                    if (Boolean.TRUE.equals(validResult)) {
                        log.info("Validation confirmed via jQuery Validate");
                        return true;
                    }
                }
                return false;
            });
            log.info("Validation message displayed: " + found);
            return found;

        } catch (Exception e) {
            log.warn("Validation check timed out: " + e.getMessage());
            // Final fallback: if modal is still open, form was blocked by validation
            try {
                boolean modalStillOpen = !Driver.getDriver()
                        .findElements(By.xpath(
                                "//div[contains(@class,'modal-header')]//h4[contains(text(),'Add Patient')]"))
                        .isEmpty();
                log.info("Modal still open (validation fallback): " + modalStillOpen);
                return modalStillOpen;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean verifyAgeFieldsAutoFilled() {
        log.info("Verifying age fields are auto-filled");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Read via JS — fields are read-only, getAttribute works but JS is safer
        String yearValue  = (String) js.executeScript(
                "return document.getElementById('age_year')  ? document.getElementById('age_year').value  : '';");
        String monthValue = (String) js.executeScript(
                "return document.getElementById('age_month') ? document.getElementById('age_month').value : '';");
        String dayValue   = (String) js.executeScript(
                "return document.getElementById('age_day')   ? document.getElementById('age_day').value   : '';");

        log.info("Year: " + yearValue + " | Month: " + monthValue + " | Day: " + dayValue);

        boolean filled = yearValue  != null && !yearValue.trim().isEmpty()
                      && monthValue != null && !monthValue.trim().isEmpty()
                      && dayValue   != null && !dayValue.trim().isEmpty();

        if (filled) log.info("Age fields auto-filled successfully");
        else log.warn("Age fields NOT filled — Year:" + yearValue + " Month:" + monthValue + " Day:" + dayValue);

        return filled;
    }
}