package actions;

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

    public static void launchPage() {
        Driver.getDriver().get("https://demo.smart-hospital.in/");
    }

    public static void clickComplaint() {
        Helper.waitForVisibility(ComplaintPage.complaintBtn);
        Helper.click(ComplaintPage.complaintBtn);
    }

    // 🔥 ONLY FILL DATA (NO SUBMIT HERE)
    public static void fillDetails(String sheetName) throws IOException {

        String path = "src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";
        String[][] data = Data_Provider.getData(path, sheetName);

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
        Helper.waitForVisibility(ComplaintPage.submit);
        Helper.click(ComplaintPage.submit);
    }

    public static void verifySuccess() {
        Helper.waitForVisibility(ComplaintPage.successMsg);
        boolean isPresent = Driver.getDriver().findElement(ComplaintPage.successMsg).isDisplayed();
        Assert.assertTrue(isPresent, "❌ Success message is NOT present");
    }

    public static void verifyError() {
        Helper.waitForVisibility(ComplaintPage.errorMsg);
        boolean isPresent = Driver.getDriver().findElement(ComplaintPage.errorMsg).isDisplayed();
        Assert.assertTrue(isPresent, "❌ Error message is NOT present");
    }
}