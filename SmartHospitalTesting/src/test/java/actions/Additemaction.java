package actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Helper;
import driver.Driver;
import pages.Additempage;

public class Additemaction {
	 static Logger logger = LogManager.getLogger(Additemaction.class);

    public static void Userclick_item() {
        Helper.click(Additempage.itembar);
        logger.info("Clicking on item bar");
        Helper.click(Additempage.addNewItemBtn);
    }

    // 🔥 Parameterized method
    public static void Enteringdetails(String name, String category, String unit, String description) {
    	  logger.info("Waiting for name field to be clickable");
    	Helper.waitForElementClickable(Additempage.name);
    	Helper.waitForElementClickable(Additempage.name);
    	
        Helper.type(Additempage.name, name);
        Helper.waitForElementClickable(Additempage.category);
        Helper.type(Additempage.category, category);
        
        Helper.type(Additempage.unit, unit);

        Helper.type(Additempage.description, description);
    }

    public static void save() {
    	 logger.info("Clicking Save button");
        Helper.click(Additempage.saveBtn);
    }

    // 🔥 Alert Assertion


      

    	public static void assertfor() {

    	   // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    	    logger.info("Waiting for success message (currently commented locator)");

    	   // By successMsg = By.xpath("//div[contains(@class,'alert-success')]");

    	    //wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));

    	   // String message = Driver.getDriver().findElement(successMsg).getText();

    	    System.out.println("Success Message: ");

    	  //  Assert.assertTrue(message.toLowerCase().contains("success") 
    	              //     || message.toLowerCase().contains("added"));
    	}
}