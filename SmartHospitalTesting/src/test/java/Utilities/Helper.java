package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;

public class Helper {

	Actions actions = new Actions(Driver.getDriver());

	public static void click(By locator) {
		Driver.getDriver().findElement(locator).click();
	}
	public static void clear(By locator) {
		Driver.getDriver().findElement(locator).clear();
	}

	public static void type(By locator, String value) {
		Driver.getDriver().findElement(locator).sendKeys(value);
	}
	
	public static String getText(By locator) {
		return Driver.getDriver().findElement(locator).getText();
	}
	public static List<WebElement> getElements(By locator) {
	    return Driver.getDriver().findElements(locator);
	}

	public static boolean isDisplayed(By locator) {
		return Driver.getDriver().findElement(locator).isDisplayed();
	}

	public static WebElement getElement(By locator) {
		return Driver.getDriver().findElement(locator);
	}

	public static WebElement waitForVisibility(By locator) {

		WebDriverWait wait =
				new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementClickable(By locator) {

		WebDriverWait wait =
				new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void moveToElementAndClick(By locator) {

	    WebDriver driver = Driver.getDriver();

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement element =
	            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView(true);", element);

	    wait.until(ExpectedConditions.elementToBeClickable(element));

	    new Actions(driver)
	            .moveToElement(element)
	            .click()
	            .perform();
	}
	public static void waitForElementsPresent(By locator, int timeoutSeconds) {

	    new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutSeconds))
	            .until(driver -> driver.findElements(locator).size() > 0);
	}
}