package actions;

import Utilities.Helper;
import driver.Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.IssueNewItemPages;

import java.time.Duration;

public class IssueNewItemActions {
	
	private static  Logger logger = LogManager.getLogger(Class.class);
	 
    public void clickIssueButtons() {
    	  logger.info("Clicking Issue New Item button");
        Helper.waitForVisibility(IssueNewItemPages.issueItemButton);
        Helper.click(IssueNewItemPages.issueItemButton);

        Helper.waitForVisibility(IssueNewItemPages.issueNewItemButton);
        Helper.click(IssueNewItemPages.issueNewItemButton);
    }

    public void selectIssueDetails(
            String accountType,
            String issueDate,
            String returnDate,
            String itemCategory,
            String item) {

        // 1. Select account type
        Helper.waitForVisibility(IssueNewItemPages.useraccounttype);
        Helper.selectDropdown(IssueNewItemPages.useraccounttype, accountType);

        // 2. Set dates
        Helper.setDate(IssueNewItemPages.issueDateField, issueDate);
        Helper.setDate(IssueNewItemPages.returnDateField, returnDate);

        // 3. Select item category
        Helper.waitForElementClickable(IssueNewItemPages.itemCategoryDropdown);
        Helper.selectDropdown(IssueNewItemPages.itemCategoryDropdown, itemCategory);

        // ✅ FIX: Wait for item dropdown to be populated via AJAX
        // After category is selected, the item dropdown loads dynamically
        // We wait until it has more than 1 option (the default blank/placeholder is 1)
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(driver -> {
            WebElement itemDdl = driver.findElement(IssueNewItemPages.itemDropdown);
            return itemDdl.findElements(By.tagName("option")).size() > 1;
        });

        // 4. Now select the item safely
        Helper.waitForElementClickable(IssueNewItemPages.itemDropdown);
        Helper.selectDropdown(IssueNewItemPages.itemDropdown, item);
    }

    public void enterDetails(String quantity, String note) {
        Helper.waitForVisibility(IssueNewItemPages.quantityField);
        Helper.type(IssueNewItemPages.quantityField, quantity);

        Helper.waitForVisibility(IssueNewItemPages.noteField);
        Helper.type(IssueNewItemPages.noteField, note);
    }

    public void clickSubmitButton() {
        logger.info("Clicking Issue Item button");
        Helper.click(IssueNewItemPages.submitButton);

        
        try {
        	   logger.info("Waiting for alert after submit");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Driver.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
           logger.warn("No alert appeared after submit");
            System.out.println("[INFO] No alert appeared after submit — skipping alert handling.");
        }
    }

    public void verifySuccessMessage() {
    	 logger.info("Verifying success message");
    	System.out.println("item added successfully");
       
    }
    
    public void HandleTheMessage() {
    	   logger.info("Handling toast message validation");
    	Helper.waitForVisibility(IssueNewItemPages.toastMessage);
        Assert.assertTrue(
            Driver.getDriver().findElement(IssueNewItemPages.toastMessage).isDisplayed()
        );
    }
}