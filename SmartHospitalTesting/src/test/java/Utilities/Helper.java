package Utilities;

import java.time.Duration;

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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void moveToElementAndClick(By locator) {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).moveToElement(element).click().perform();
    }

    
    public static void selectDropdown(By locator, String value) {
        selectDropdown(Driver.getDriver(), locator, value);
    }

 
    public static void selectDropdown(WebDriver driver, By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "for (let i=0; i<arguments[0].options.length; i++) {" +
                "  if (arguments[0].options[i].text.trim() === arguments[1]) {" +
                "    arguments[0].selectedIndex = i;" +
                "    arguments[0].dispatchEvent(new Event('change'));" +
                "    break;" +
                "  }" +
                "}",
                dropdown, value
            );
        }
    }

    public static void waitForModal(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog")));
    }

    public static void waitForOverlay(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
    }

    public static void setDate(By locator, String value) {
        WebElement el = Driver.getDriver().findElement(locator);
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].value='" + value + "';", el);
    }

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
    }
}
