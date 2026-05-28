package pages;

import org.openqa.selenium.By;

public class AddIncomePage {

    // Finance menu — at bottom of sidebar, requires scroll
    public static final By financeMenu = By.xpath(
            "//ul[contains(@class,'sidebar-menu')]" +
            "//li[.//span[normalize-space(text())='Finance']]//a");

    // Income link inside Finance submenu — following-sibling + descendant axes
    public static final By incomeLink = By.xpath(
            "//ul[contains(@class,'treeview-menu')]" +
            "//a[.//span[normalize-space(text())='Income']]" +
            " | " +
            "//ul[contains(@class,'sidebar-menu')]" +
            "//a[contains(@href,'income') and not(contains(@href,'expense'))]");

    // Add Income button on Income list page — child axis of box-header
    public static final By addIncomeButton = By.xpath(
            "//div[contains(@class,'box-header')]" +
            "/descendant::a[contains(@class,'btn')]" +
            "[contains(normalize-space(.),'Add Income') " +
            " or contains(normalize-space(.),'Add') " +
            " or contains(@href,'add')]");

    // ── Modal ─────────────────────────────────────────────────────────────

    // Modal title — wait for this to confirm modal is open
    public static final By modalTitle = By.xpath(
            "//div[contains(@class,'modal') and contains(@style,'display: block')]" +
            "//h4[contains(normalize-space(.),'Income')" +
            " or contains(normalize-space(.),'income')]" +
            " | " +
            "//div[contains(@class,'modal-header')]" +
            "//h4[contains(normalize-space(.),'Income')]");

    // Income Head — ANY select inside the visible modal
    // Real attribute unknown — use broadest possible locator
    public static final By incomeHead = By.xpath(
            "//div[contains(@class,'modal') and contains(@style,'display: block')]" +
            "//select[1]" +
            " | " +
            "//div[contains(@class,'modal-body')]//select[1]");

    // Name input — first text input inside modal body
    public static final By incomeName = By.xpath(
            "//div[contains(@class,'modal-body')]" +
            "//input[@type='text' and " +
            "(@name='name' or @id='name' or @placeholder='Name')]" +
            " | " +
            "//div[contains(@class,'modal-body')]//input[@type='text'][1]");

    // Invoice Number input
    public static final By invoiceNumber = By.xpath(
            "//div[contains(@class,'modal-body')]" +
            "//input[@name='invoice_number' " +
            " or @id='invoice_number' " +
            " or @placeholder='Invoice Number'" +
            " or contains(@name,'invoice')]");

    // Amount input — mandatory field
    public static final By amount = By.xpath(
            "//div[contains(@class,'modal-body')]" +
            "//input[@name='amount' " +
            " or @id='amount' " +
            " or @placeholder='Amount'" +
            " or @placeholder='Amount ($)']");

    // Description textarea
    public static final By description = By.xpath(
            "//div[contains(@class,'modal-body')]" +
            "//textarea[@name='description' or @id='description']");

    // Save button — submit inside modal footer or modal body
    public static final By saveButton = By.xpath(
            "//div[contains(@class,'modal')]" +
            "//button[@type='submit']" +
            " | " +
            "//div[contains(@class,'modal-footer')]" +
            "//button[contains(normalize-space(.),'Save')]" +
            " | " +
            "//div[contains(@class,'modal')]" +
            "//button[contains(normalize-space(.),'Save')]");

    // jQuery Validate label.error — appears below each invalid field
    public static final By validationError = By.xpath(
            "//div[contains(@class,'modal-body')]" +
            "//label[contains(@class,'error') and string-length(normalize-space(.)) > 0]");

    // Success toast/alert after save
    public static final By successAlert = By.xpath(
            "//*[contains(@class,'alert-success')" +
            " or contains(@class,'toast-success')" +
            " or contains(@class,'swal2-success')" +
            " or (contains(@class,'alert') " +
            "     and contains(normalize-space(.),'success'))]");

    // ── Income List table ─────────────────────────────────────────────────

    // Income list table — parent of Name column header
    public static final By incomeListTable = By.xpath(
            "//table[contains(@class,'table')]" +
            "[.//th[contains(normalize-space(.),'Name')" +
            "  or contains(normalize-space(.),'Head')]]");

    // Name cells — 2nd td in each row (Name column)
    public static final By nameCells = By.xpath(
            "//table[contains(@class,'table')]" +
            "//tbody/tr/td[2]");
}