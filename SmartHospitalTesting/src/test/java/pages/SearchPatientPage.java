package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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
        el.click();
        el.clear();

      
        el.sendKeys(patientName);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'dataTables_processing')]")));
        } catch (Exception ignored) {}
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

   
    public boolean verifyMatchingPatientDisplayed(String patientName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0));

            List<WebElement> rows = driver.findElements(tableRows);

            if (rows.size() == 1) {
                String rowText = rows.get(0).getText().toLowerCase();
                if (rowText.contains("no data")
                        || rowText.contains("no matching")
                        || rowText.contains("no records")
                        || rowText.trim().isEmpty()) {
                    return false;
                }
            }

          
            String pageSource = driver.getPageSource().toLowerCase();
            return pageSource.contains(patientName.toLowerCase());

        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean verifyNoRecordsFound() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(noDataRow));
            return driver.findElement(noDataRow).isDisplayed();
        } catch (TimeoutException e) {
         
            try {
                List<WebElement> rows = driver.findElements(tableRows);
                if (rows.isEmpty()) return true;
                String rowText = rows.get(0).getText().toLowerCase();
                return rowText.contains("no data")
                        || rowText.contains("no matching")
                        || rowText.contains("no records")
                        || rowText.trim().isEmpty();
            } catch (Exception ex) {
                return false;
            }
        }
    }
}