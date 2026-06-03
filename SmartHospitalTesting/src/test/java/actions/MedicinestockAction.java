package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Helper;
import pages.MedicinestockPage;

public class MedicinestockAction {

    Logger logger = LogManager.getLogger(MedicinestockAction.class);

    public void clickmedicinebutton() {
        Helper.waitForElementClickable(MedicinestockPage.medicinebutton);
        Helper.click(MedicinestockPage.medicinebutton);
    }

    public void searchMedicine(String medicine) {

        logger.info("Searching medicine: " + medicine);

        Helper.waitForElementClickable(MedicinestockPage.medicineSearchbar);
        Helper.click(MedicinestockPage.medicineSearchbar);
        Helper.clear(MedicinestockPage.medicineSearchbar);
        Helper.type(MedicinestockPage.medicineSearchbar, medicine);
    }

    public String verifySearchedMedicine(String searchedmedicine) {

        By loc = MedicinestockPage.medicinetext(searchedmedicine);

        Helper.waitForVisibility(loc);

        String actualMedicine = Helper.getText(loc);

        logger.info("Medicine found: " + actualMedicine);

        return actualMedicine;
    }

    public String verifyMedicineNotFoundMessage() {

        Helper.waitForVisibility(MedicinestockPage.medicinenotfoundtxt);

        String actualMessage = Helper.getText(MedicinestockPage.medicinenotfoundtxt);

        logger.info("No medicine found message displayed");

        return actualMessage;
    }

    public void selectMedicine(String medicine) {

        By locator = MedicinestockPage.medicineCheckbox(medicine);
        WebElement element = Helper.getClickableElement(locator);

        if (!element.isSelected()) {
            logger.info("Selecting medicine: " + medicine);
            element.click();
        }
    }

    public void clickDeleteButton() {
        Helper.waitForElementClickable(MedicinestockPage.deleteButton);
        Helper.click(MedicinestockPage.deleteButton);
    }

    public void clickdeleteConfirm() {
        Helper.acceptAlert();
    }

    public String verifyDeleteConfirmation() {

        Helper.waitForVisibility(MedicinestockPage.deleteConfirmation);

        String confirmation = Helper.getText(MedicinestockPage.deleteConfirmation);

        logger.info("Delete confirmation message displayed");

        return confirmation;
    }
    public void clickShowButtonOnAnyMedicine() {
        Helper.moveToElement(By.xpath("//tbody/tr[1]"));
        logger.info("Hovered over first medicine row");
        Helper.moveToElementAndClick(MedicinestockPage.firstRowShowButton);
        logger.info("Clicked Show button on first available medicine");
    }

    public boolean isMedicineDetailsPageDisplayed() {
        return Helper.isDisplayed(MedicinestockPage.stockTab) 
            && Helper.isDisplayed(MedicinestockPage.badStockTab);
    }

    public boolean isStockEntryVisible() {
        Helper.waitForVisibility(MedicinestockPage.stockEntryTable);
        return Helper.isDisplayed(MedicinestockPage.stockEntryTable);
    }
}