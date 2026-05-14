package Utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

public class Helper {
	
	public static void click(By locator) {
		Driver.getDriver().findElement(locator).click();
	}

	public static void type(By locator, String value) {
		Driver.getDriver().findElement(locator).sendKeys(value);
	}

	public static String getText(By locator) {
		return Driver.getDriver().findElement(locator).getText();
	}

	public static boolean isDisplayed(By locator) {
		return Driver.getDriver().findElement(locator).isDisplayed();
	}

	public static WebElement getElement(By locator) {
		return Driver.getDriver().findElement(locator);
	}

	public static void waitForVisibility(By locator) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementClickable(By locator) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}


