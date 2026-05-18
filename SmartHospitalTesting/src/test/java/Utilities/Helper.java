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
    // Click (with wait)
    public static void click(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Clear
    public static void clear(By locator) {
        Driver.getDriver().findElement(locator).clear();
    }

    // Type
    public static void type(By locator, String value) {
        Driver.getDriver().findElement(locator).sendKeys(value);
    }

    // Get Text
    public static String getText(By locator) {
        return Driver.getDriver().findElement(locator).getText();
    }

    // Get Elements
    public static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }
    
    public static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    // Is Displayed
    public static boolean isDisplayed(By locator) {
        return Driver.getDriver().findElement(locator).isDisplayed();
    }

    // Wait for visibility
    public static WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for clickable
    public static void waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Move and click
    public static void moveToElementAndClick(By locator) {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        new Actions(driver)
                .moveToElement(element)
                .click()
                .perform();
    }

    // Move only
    public static void moveToElement(By locator) {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        new Actions(driver).moveToElement(element).perform();
    }

    // JS Click
    public static void jsClick(By locator) {
        WebElement element = waitForVisibility(locator);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    // Dropdown select
    public static void selectDropdown(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));

        Select select = new Select(dropdown);

        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript(
                    "for (let i=0; i<arguments[0].options.length; i++) {" +
                            "if (arguments[0].options[i].text.trim() === arguments[1]) {" +
                            "arguments[0].selectedIndex = i;" +
                            "arguments[0].dispatchEvent(new Event('change'));" +
                            "break;}}",
                    dropdown, value);
        }
    }

    // Wait for elements present
    public static void waitForElementsPresent(By locator, int timeoutSeconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutSeconds))
                .until(driver -> driver.findElements(locator).size() > 0);
    }

    // Modal wait
    public static void waitForModal(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog")));
    }

    // Overlay wait
    public static void waitForOverlay(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
    }

    // Set Date
    public static void setDate(By locator, String value) {
        WebElement el = Driver.getDriver().findElement(locator);
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].value='" + value + "';", el);
    }

    // Alert Handling
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

}