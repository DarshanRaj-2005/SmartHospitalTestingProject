package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchPatientPage {

    WebDriver driver;

    public SearchPatientPage(WebDriver driver) {
        this.driver = driver;
    }

    By patientSidebarLink =
            By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                   + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']");

    By searchBox =
            By.xpath("//div[contains(@class,'dataTables_filter')]//input"
                   + " | //input[@placeholder='Search...' or @placeholder='Search']");

    By tableRows =
            By.xpath("//table[contains(@class,'table')]//tbody//tr");

    By noDataRow =
            By.xpath("//table[contains(@class,'table')]//tbody//tr//td[@class='dataTables_empty']"
                   + " | //table[contains(@class,'table')]//tbody//tr//td[contains(text(),'No data available')]"
                   + " | //table[contains(@class,'table')]//tbody//tr//td[contains(text(),'No matching records')]");

    public void clickPatientSidebarLink() {
        WebElement el = driver.findElement(patientSidebarLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void waitForPatientListToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
    }

    public void enterSearchText(String patientName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        WebElement el = driver.findElement(searchBox);
        // click + clear + sendKeys — triggers DataTable keyup listener naturally
        el.click();
        el.clear();
        el.sendKeys(patientName);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for DataTable processing overlay to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[contains(@class,'dataTables_processing')]")));
        // Wait for AJAX + DOM re-render
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

    public boolean verifyMatchingPatientDisplayed(String patientName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0));

        List<WebElement> rows = driver.findElements(tableRows);
        String firstRowText = rows.get(0).getText().toLowerCase();

        boolean isNoDataRow = firstRowText.contains("no data")
                           || firstRowText.contains("no matching")
                           || firstRowText.contains("no records")
                           || firstRowText.trim().isEmpty();

        if (rows.size() == 1 && isNoDataRow) {
            return false;
        }

        // Page source check — works regardless of HTML nesting depth
        String pageSource = driver.getPageSource().toLowerCase();
        return pageSource.contains(patientName.toLowerCase());
    }

    public boolean verifyNoRecordsFound() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(noDataRow),
                        ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0)
                ));

        List<WebElement> noDataElements = driver.findElements(noDataRow);
        if (!noDataElements.isEmpty()) {
            return noDataElements.get(0).isDisplayed();
        }

        List<WebElement> rows = driver.findElements(tableRows);
        if (rows.isEmpty()) return true;

        String rowText = rows.get(0).getText().toLowerCase();
        return rowText.contains("no data")
                || rowText.contains("no matching")
                || rowText.contains("no records")
                || rowText.trim().isEmpty();
    }
}