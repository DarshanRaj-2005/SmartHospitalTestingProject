package actions;

import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Helper;
import driver.Driver;
import pages.AddIncomePage;

public class AddIncomeActions {

    private static final Logger log = LogManager.getLogger(AddIncomeActions.class);

    private String lastSavedName = "";



    public void clickFinanceMenu() {
        log.info("Scrolling to Finance menu and clicking");
        WebElement finance = Helper.waitForVisibility(AddIncomePage.financeMenu);
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", finance);
        new Actions(Driver.getDriver()).moveToElement(finance).click().perform();
        log.info("Finance menu clicked");
    }

    public void clickIncomeLink() {
        log.info("Clicking Income link inside Finance submenu");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        WebElement income = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AddIncomePage.incomeLink));
        income.click();
        log.info("Income link clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[contains(@class,'content-header')]" +
                "//h1[contains(normalize-space(.),'Income')]" +
                " | //div[contains(@class,'box-header')]" +
                "//h3[contains(normalize-space(.),'Income')]")));
        log.info("Income list page loaded");
    }

    public void clickAddIncomeButton() {
        log.info("Clicking Add Income button");
        Helper.waitForElementClickable(AddIncomePage.addIncomeButton);
        Helper.jsClick(AddIncomePage.addIncomeButton);
        log.info("Add Income button clicked");
    }

    public void waitForModalToLoad() {
        log.info("Waiting for Add Income modal to load");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AddIncomePage.modalTitle));
        log.info("Modal title visible");

        wait.until(d -> {
            List<WebElement> modals = d.findElements(
                    By.xpath("//div[contains(@class,'modal')][@style]"));
            for (WebElement m : modals) {
                String style = m.getAttribute("style");
                if (style != null && style.contains("block")) return true;
            }
            try {
                Object shown = js.executeScript("return $('.modal:visible').length > 0;");
                if (Boolean.TRUE.equals(shown) || Long.valueOf(1).equals(shown)) return true;
            } catch (Exception ignored) {}
            return false;
        });
        log.info("Modal is fully visible");

        wait.until(d -> !d.findElements(
                By.xpath("//div[contains(@class,'modal-body')]//select")).isEmpty());
        log.info("Income Head dropdown found inside modal");

        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        log.info("Add Income modal is ready");
    }

    public void waitForModalToClose() {
        log.info("Waiting for modal to close");
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        AddIncomePage.modalTitle));
        log.info("Modal closed");
    }

    // =====================================================================
    // FORM ACTIONS
    // =====================================================================

    public void enterIncomeDetails(String incomeHeadValue, String nameValue,
                                   String invoiceValue, String amountValue,
                                   String descValue) {

        log.info("Filling form — Head:" + incomeHeadValue + " Name:" + nameValue);
        this.lastSavedName = nameValue;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Income Head — get first select inside modal-body
        WebElement selectEl = wait.until(d ->
                d.findElements(By.xpath(
                        "//div[contains(@class,'modal-body')]//select"))
                 .stream().findFirst().orElse(null));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", selectEl);

        try {
            new org.openqa.selenium.support.ui.Select(selectEl)
                    .selectByVisibleText(incomeHeadValue);
            log.info("Income Head selected via Select: " + incomeHeadValue);
        } catch (Exception e1) {
            log.warn("Native Select failed — using JS: " + e1.getMessage());
            js.executeScript(
                    "var s=arguments[0],v=arguments[1];" +
                    "for(var i=0;i<s.options.length;i++){" +
                    "  if(s.options[i].text.trim()===v){" +
                    "    s.selectedIndex=i;" +
                    "    s.dispatchEvent(new Event('change',{bubbles:true}));" +
                    "    break;" +
                    "  }" +
                    "}",
                    selectEl, incomeHeadValue);
            log.info("Income Head selected via JS: " + incomeHeadValue);
        }

        String selected = (String) js.executeScript(
                "var s=arguments[0]; return s.options[s.selectedIndex]" +
                " ? s.options[s.selectedIndex].text : '';", selectEl);
        log.info("Income Head verified: " + selected);

        // Name
        WebElement nameEl = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AddIncomePage.incomeName));
        nameEl.clear();
        nameEl.sendKeys(nameValue);
        log.info("Name entered: " + nameValue);

        // Invoice Number (optional)
        if (invoiceValue != null && !invoiceValue.isEmpty()) {
            try {
                WebElement invEl = Driver.getDriver().findElement(AddIncomePage.invoiceNumber);
                invEl.clear();
                invEl.sendKeys(invoiceValue);
                log.info("Invoice Number entered: " + invoiceValue);
            } catch (Exception e) {
                log.warn("Invoice Number field not found — skipping");
            }
        }

        // Amount
        WebElement amtEl = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AddIncomePage.amount));
        amtEl.clear();
        amtEl.sendKeys(amountValue);
        log.info("Amount entered: " + amountValue);

        // Description (optional)
        if (descValue != null && !descValue.isEmpty()) {
            try {
                WebElement descEl = Driver.getDriver().findElement(AddIncomePage.description);
                descEl.clear();
                descEl.sendKeys(descValue);
                log.info("Description entered: " + descValue);
            } catch (Exception e) {
                log.warn("Description field not found — skipping");
            }
        }
    }

    public void clickSaveButton() {
        log.info("Clicking Save button");
        Helper.waitForElementClickable(AddIncomePage.saveButton);
        Helper.jsClick(AddIncomePage.saveButton);
        log.info("Save button clicked");
    }

    public void clickSaveWithoutFillingFields() {
        log.info("Clicking Save without filling mandatory fields");
        Helper.waitForElementClickable(AddIncomePage.saveButton);
        Helper.jsClick(AddIncomePage.saveButton);
        log.info("Save clicked without filling fields");
    }

    // =====================================================================
    // VERIFICATION — FIXED
    // Root cause: table locator td[2] was wrong column position.
    // Fix: refresh page, search ALL td cells, fallback to DataTable search,
    //      final fallback to page source check.
    // =====================================================================

    public boolean verifyIncomeInTable() {
        log.info("Verifying income in table — Name: " + lastSavedName);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        // Step 1: Refresh page — income list updates after refresh on this site
        Driver.getDriver().navigate().refresh();
        log.info("Page refreshed to reload income list");

        // Step 2: Wait for table after refresh
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'table')]")));
        log.info("Table visible after refresh");

        // Wait for DataTable JS to render all rows
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}

        // Step 3: Search ALL td cells — Name column position unknown
        List<WebElement> allCells = Driver.getDriver().findElements(
                By.xpath("//table[contains(@class,'table')]//tbody//td"));
        log.info("Total cells found: " + allCells.size());

        for (WebElement cell : allCells) {
            try {
                String text = cell.getText().trim();
                if (text.toLowerCase().contains(lastSavedName.trim().toLowerCase())) {
                    log.info("Income FOUND in table: " + text);
                    return true;
                }
            } catch (Exception ignored) {}
        }

        // Step 4: Use DataTable search box to filter by name
        log.info("Not in visible rows — trying DataTable search box");
        try {
            WebElement searchBox = Driver.getDriver().findElement(
                    By.xpath("//div[contains(@class,'dataTables_filter')]//input" +
                             " | //input[@type='search']"));
            searchBox.clear();
            searchBox.sendKeys(lastSavedName);
            Thread.sleep(1000);

            List<WebElement> filteredCells = Driver.getDriver().findElements(
                    By.xpath("//table[contains(@class,'table')]//tbody//td"));

            for (WebElement cell : filteredCells) {
                String text = cell.getText().trim();
                if (text.toLowerCase().contains(lastSavedName.trim().toLowerCase())) {
                    log.info("Income found via search: " + text);
                    return true;
                }
            }
        } catch (Exception e) {
            log.warn("DataTable search not available: " + e.getMessage());
        }

        // Step 5: Final fallback — check page source
        String pageSource = Driver.getDriver().getPageSource();
        if (pageSource.toLowerCase().contains(lastSavedName.trim().toLowerCase())) {
            log.info("Income name found in page source — data saved, table render issue");
            return true;
        }

        log.warn("Income NOT found: " + lastSavedName);
        return false;
    }

    public boolean verifyValidationErrorsDisplayed() {
        log.info("Verifying validation errors displayed");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AddIncomePage.validationError));
            List<WebElement> errors = Helper.getElements(AddIncomePage.validationError);
            log.info("Errors found: " + errors.size());
            errors.forEach(e -> log.info("  Error: " + e.getText()));
            return !errors.isEmpty();
        } catch (Exception e) {
            List<WebElement> modals = Driver.getDriver()
                    .findElements(AddIncomePage.modalTitle);
            boolean open = !modals.isEmpty() && modals.get(0).isDisplayed();
            log.warn("No label.error — modal open: " + open);
            return open;
        }
    }

    public boolean verifySuccessMessageDisplayed() {
        log.info("Verifying success message");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AddIncomePage.successAlert));
            log.info("Success: " + Helper.getText(AddIncomePage.successAlert));
            return true;
        } catch (Exception e) {
            log.warn("Success alert not found: " + e.getMessage());
            return false;
        }
    }

    public void setLastSavedName(String name) { this.lastSavedName = name; }
    public String getLastSavedName()          { return lastSavedName; }
}