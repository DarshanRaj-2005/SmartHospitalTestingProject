package actions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Helper;
import driver.Driver;
import pages.GeneratePharmacybillPage;
import pages.PharmacyBillPage;

public class GeneratePharmacybillAction {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void clickPharmacy() {
        Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);
        Helper.click(PharmacyBillPage.pharmacyMenu);
    }
    public void clickGenerateBillButton() {
        Helper.waitForElementClickable(GeneratePharmacybillPage.generateBillButton);
        Helper.click(GeneratePharmacybillPage.generateBillButton);
    }

    public void enterPatientName(String patientName) {
        Helper.waitForVisibility(GeneratePharmacybillPage.patientInputField);
        Helper.click(GeneratePharmacybillPage.patientInputField);
        Helper.clear(GeneratePharmacybillPage.patientInputField);
        Helper.type(GeneratePharmacybillPage.patientInputField, patientName);
        Helper.waitForElementsPresent(GeneratePharmacybillPage.patientSearchDropdown, 10);

        List<WebElement> patientOptions = Helper.getElements(GeneratePharmacybillPage.patientSearchDropdown);
        if (!patientOptions.isEmpty()) {
            Helper.click(GeneratePharmacybillPage.patientSearchDropdown);
        }
    }

    public void selectCategory(String category) {
        Helper.waitForElementClickable(GeneratePharmacybillPage.categoryDropdown);
        Helper.selectDropdown(GeneratePharmacybillPage.categoryDropdown, category);
    }

    public void enterMedicineName(String medicineName) {
        Helper.waitForVisibility(GeneratePharmacybillPage.medicineInputField);
        Helper.click(GeneratePharmacybillPage.medicineInputField);
        Helper.clear(GeneratePharmacybillPage.medicineInputField);
        Helper.type(GeneratePharmacybillPage.medicineInputField, medicineName);
        Helper.waitForElementsPresent(GeneratePharmacybillPage.medicineSearchDropdown, 10);

        List<WebElement> medicineOptions = Helper.getElements(GeneratePharmacybillPage.medicineSearchDropdown);
        if (!medicineOptions.isEmpty()) {
            Helper.click(GeneratePharmacybillPage.medicineSearchDropdown);
        }
    }

    public void enterBatchNumber(String batchNumber) {
        Helper.waitForVisibility(GeneratePharmacybillPage.batchInputField);
        Helper.click(GeneratePharmacybillPage.batchInputField);
        Helper.clear(GeneratePharmacybillPage.batchInputField);
        Helper.type(GeneratePharmacybillPage.batchInputField, batchNumber);
    }

    public void enterQuantity(String quantity) {
        Helper.waitForVisibility(GeneratePharmacybillPage.quantityInputField);
        Helper.click(GeneratePharmacybillPage.quantityInputField);
        Helper.clear(GeneratePharmacybillPage.quantityInputField);
        Helper.type(GeneratePharmacybillPage.quantityInputField, quantity);
    }

    public void enterDoctorName(String doctorName) {
        Helper.waitForVisibility(GeneratePharmacybillPage.doctorInputField);
        Helper.click(GeneratePharmacybillPage.doctorInputField);
        Helper.clear(GeneratePharmacybillPage.doctorInputField);
        Helper.type(GeneratePharmacybillPage.doctorInputField, doctorName);
        Helper.waitForElementsPresent(GeneratePharmacybillPage.doctorSearchDropdown, 10);

        List<WebElement> doctorOptions = Helper.getElements(GeneratePharmacybillPage.doctorSearchDropdown);
        if (!doctorOptions.isEmpty()) {
            Helper.click(GeneratePharmacybillPage.doctorSearchDropdown);
        }
    }

    public void selectPaymentMode(String paymentMode) {
        Helper.waitForElementClickable(GeneratePharmacybillPage.paymentModeDropdown);
        Helper.selectDropdown(GeneratePharmacybillPage.paymentModeDropdown, paymentMode);
    }

    public void enterAmount(String amount) {
        Helper.waitForVisibility(GeneratePharmacybillPage.amountInputField);
        Helper.click(GeneratePharmacybillPage.amountInputField);
        Helper.clear(GeneratePharmacybillPage.amountInputField);
        Helper.type(GeneratePharmacybillPage.amountInputField, amount);
    }

    public void clickSaveButton() {
        Helper.waitForElementClickable(GeneratePharmacybillPage.saveButton);
        Helper.click(GeneratePharmacybillPage.saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        Helper.waitForVisibility(GeneratePharmacybillPage.successMessage);
        return Helper.isDisplayed(GeneratePharmacybillPage.successMessage);
    }

    public String getSuccessMessageText() {
        Helper.waitForVisibility(GeneratePharmacybillPage.successMessage);
        return Helper.getText(GeneratePharmacybillPage.successMessage);
    }

    public boolean isErrorMessageDisplayed() {
        try {
            Helper.waitForErrorNotification(GeneratePharmacybillPage.errorNotification);
            return Helper.isDisplayed(GeneratePharmacybillPage.errorNotification);
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        Helper.waitForVisibility(GeneratePharmacybillPage.errorMessage);
        return Helper.getText(GeneratePharmacybillPage.errorMessage);
    }

    public boolean isPageDisplayed() {
        Helper.waitForVisibility(GeneratePharmacybillPage.generatePharmacyBillPageHeader);
        return Helper.isDisplayed(GeneratePharmacybillPage.generatePharmacyBillPageHeader);
    }
}