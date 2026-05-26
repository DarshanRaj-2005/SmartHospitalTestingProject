package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.IOException;
import Utilities.Data_Provider;
import Utilities.Helper;
import driver.Driver;
import pages.ComplaintPage;
import org.testng.Assert;

public class Complaintaction {

    static Logger logger = LogManager.getLogger(Complaintaction.class);

    public static void launchPage() {
        Driver.getDriver().get("https://demo.smart-hospital.in/");
        logger.info("Smart Hospital demo site launched");
    }

    public static void clickComplaint() {
        logger.info("Waiting for complaint button");
        Helper.waitForVisibility(ComplaintPage.complaintBtn);
        Helper.click(ComplaintPage.complaintBtn);
        logger.info("Complaint button clicked");
    }

    public static void fillDetails(String sheetName) throws IOException {
        logger.info("Reading Excel data sheet: " + sheetName);

        String path = "src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";
        String[][] data = Data_Provider.getExcelData(path, sheetName);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ComplaintPage.name));

        Helper.type(ComplaintPage.name, data[0][0]);
        Helper.type(ComplaintPage.email, data[0][1]);
        Helper.type(ComplaintPage.contact, data[0][2]);
        Helper.type(ComplaintPage.description, data[0][3]);

        logger.info("Complaint form filled successfully");
    }

    public static void submit() {
        logger.info("Clicking submit button");
        Helper.waitForVisibility(ComplaintPage.submit);
        Helper.click(ComplaintPage.submit);
        logger.info("Submit action completed");
    }
    public static void verifySuccess() {

        logger.info("Verifying success message");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(driver ->
            driver.getPageSource().toLowerCase().contains("success")
            || driver.getPageSource().toLowerCase().contains("successfully")
        );

        Assert.assertTrue(true, "Success message verified");
    }

    public static void verifyError() {
        logger.info("Verifying error message");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        boolean isPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(ComplaintPage.errorMsg)).isDisplayed();

        Assert.assertTrue(isPresent, "❌ Error message not displayed properly");
    }
}