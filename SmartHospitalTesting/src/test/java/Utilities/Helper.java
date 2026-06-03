package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;

public class Helper {

	public static void click(By locator) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
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

	public static WebElement getElement(By locator) {
		return Driver.getDriver().findElement(locator);
	}

	public static boolean isDisplayed(By locator) {
		try {
			return Driver.getDriver().findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static WebElement waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement getClickableElement(By locator) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void selectValue(By locator, String value) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			return;
		} catch (Exception ignored) {
		}

		try {
			element.click();

			By searchBoxLocator = By.xpath("//span[contains(@class,'select2-container--open')]//input");

			WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator));

			searchBox.clear();
			searchBox.sendKeys(value);

			By optionLocator = By
					.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");

			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
			option.click();

			return;

		} catch (Exception ignored) {
		}

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

		js.executeScript("for (let i=0; i<arguments[0].options.length; i++) {"
				+ "if (arguments[0].options[i].text.trim() === arguments[1]) {" + "arguments[0].selectedIndex = i;"
				+ "arguments[0].dispatchEvent(new Event('change'));" + "break;" + "}}", element, value);
	}

	public static void moveToElementAndClick(By locator) {

		WebDriver driver = Driver.getDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		new Actions(driver).moveToElement(element).click().perform();
	}

	public static void selectSelect2(By dropdown, By searchBox, By optionLocator, String value) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dd.click();

		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		input.clear();
		input.sendKeys(value);

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();
	}

	public static void moveToElement(By locator) {

		WebDriver driver = Driver.getDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		new Actions(driver).moveToElement(element).perform();
	}

	public static void jsClick(By locator) {

		WebElement element = waitForVisibility(locator);

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

		js.executeScript("arguments[0].click();", element);
	}

	public static void clearAndEnterText(By locator, String value) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.clear();
		element.sendKeys(value);
	}

	public static void selectDropdown(By locator, String value) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));

		Select select = new Select(dropdown);

		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

			js.executeScript("for (let i=0; i<arguments[0].options.length; i++) {"
					+ "if (arguments[0].options[i].text.trim() === arguments[1]) {" + "arguments[0].selectedIndex = i;"
					+ "arguments[0].dispatchEvent(new Event('change'));" + "break;" + "}}", dropdown, value);
		}
	}

	public static void waitForElementsPresent(By locator, int timeoutSeconds) {

		new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutSeconds))
				.until(driver -> driver.findElements(locator).size() > 0);
	}

	public static void waitForModal(WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog")));
	}

	public static void waitForOverlay(WebDriver driver) {

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
	}

	public static void setDate(By locator, String value) {

		WebElement el = Driver.getDriver().findElement(locator);

		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value='" + value + "';", el);
	}

	public static Alert waitForAlert() {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void acceptAlert() {
		waitForAlert().accept();
	}

	public static void dismissAlert() {
		waitForAlert().dismiss();
	}

	public static String getAlertText() {
		return waitForAlert().getText();
	}

	public static void waitForDropdownEnabled(By locator) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		wait.until(driver -> {
			WebElement dropdown = driver.findElement(locator);
			String disabled = dropdown.getAttribute("disabled");
			return disabled == null || !disabled.equals("true");
		});
	}

	public static boolean isFieldHasError(By fieldLocator) {

		try {
			WebElement field = Driver.getDriver().findElement(fieldLocator);

			String ariaInvalid = field.getAttribute("aria-invalid");

			return ariaInvalid != null && ariaInvalid.equals("true");

		} catch (Exception e) {
			return false;
		}
	}

	public static String getFieldErrorText(By fieldLocator) {

		try {

			WebElement field = Driver.getDriver().findElement(fieldLocator);

			String ariaDescribedBy = field.getAttribute("aria-describedby");

			if (ariaDescribedBy != null && !ariaDescribedBy.isEmpty()) {

				WebElement errorElement = Driver.getDriver().findElement(By.id(ariaDescribedBy));

				return errorElement.getText();
			}

		} catch (Exception e) {

			System.out.println("Error retrieving field error message: " + e.getMessage());
		}

		return null;
	}

	public static void waitForFieldEnabled(By fieldLocator) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		wait.until(driver -> driver.findElement(fieldLocator).isEnabled());
	}

	public static void waitForSuccessNotification(By locator) {

		new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForErrorNotification(By locator) {

		new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static boolean isFieldRequired(By fieldLocator) {

		try {

			WebElement field = Driver.getDriver().findElement(fieldLocator);

			String requiredAttr = field.getAttribute("required");

			return requiredAttr != null && requiredAttr.equals("true");

		} catch (Exception e) {
			return false;
		}
	}

	public static void newmoveToElementAndClick(By locator) {

		WebDriver driver = Driver.getDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		try {

			new Actions(driver).moveToElement(element).click().perform();

		} catch (Exception e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public static void waitForInvisibility(By locator) {

		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void waitForPresence(By locator, int timeoutSeconds) {

	    new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutSeconds))
	            .until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static String getToastText(By locator) {

	    try {

	        WebDriverWait wait =
	                new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

	        WebElement element =
	                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        return element.getText().trim();

	    } catch (Exception e) {

	        return "";
	    }
	}
	
	public static void waitForTextToBePresentInElementLocated(By locator, String value) {
		new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20)).
		until(ExpectedConditions.textToBePresentInElementLocated(locator,value));
	}
}
