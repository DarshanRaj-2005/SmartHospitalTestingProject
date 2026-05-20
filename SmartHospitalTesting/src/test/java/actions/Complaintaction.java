package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Utilities.Data_Provider;
import java.io.IOException;
import Utilities.Helper;
import driver.Driver;
import pages.ComplaintPage;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class Complaintaction {
	 static Logger logger = LogManager.getLogger(Complaintaction.class);

    public static void launchPage() {
        Driver.getDriver().get("https://demo.smart-hospital.in/");
        logger.info("Launching Smart Hospital demo site");
    }

    public static void clickComplaint() {
    	 logger.info("Waiting for complaint button");
        Helper.waitForVisibility(ComplaintPage.complaintBtn);
        Helper.click(ComplaintPage.complaintBtn);
        logger.info("Clicking complaint button");
    }

    // 🔥 ONLY FILL DATA (NO SUBMIT HERE)
    public static void fillDetails(String sheetName) throws IOException {
    	 logger.info("Reading Excel data for sheet: " + sheetName);
        String path = "src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";
        String[][] data = Data_Provider.getExcelData(path, sheetName);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(ComplaintPage.name));

        // 👉 Take only first row (since one scenario = one submission)
        Helper.type(ComplaintPage.name, data[0][0]);
        Helper.type(ComplaintPage.email, data[0][1]);
        Helper.type(ComplaintPage.contact, data[0][2]);
        Helper.type(ComplaintPage.description, data[0][3]);
    }

    // 🔥 SUBMIT METHOD
    public static void submit() {
    	  logger.info("Waiting for submit button");
        Helper.waitForVisibility(ComplaintPage.submit);
        Helper.click(ComplaintPage.submit);
    }

    public static void verifySuccess() {
    	  logger.info("Verifying success message");
        Helper.waitForVisibility(ComplaintPage.successMsg);
        boolean isPresent = Driver.getDriver().findElement(ComplaintPage.successMsg).isDisplayed();
        Assert.assertTrue(isPresent, "❌ Success message is NOT present");
    }

    public static void verifyError() {
    	  logger.info("Verifying success message");
        Helper.waitForVisibility(ComplaintPage.errorMsg);
        boolean isPresent = Driver.getDriver().findElement(ComplaintPage.errorMsg).isDisplayed();
        Assert.assertTrue(isPresent, "❌ Error message is NOT present");
    }
}