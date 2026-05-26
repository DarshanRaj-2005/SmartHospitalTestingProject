package pages;

import org.openqa.selenium.By;

public class AddPatientPage {

    // =====================================================================
    // NAVIGATION LOCATORS
    // =====================================================================

    // Patient link in the left sidebar menu
    // Using child axis: finds <a> that is a child of <li> containing 'Patient' span
    public static By patientCategory =
            By.xpath("//ul[contains(@class,'sidebar-menu')]"
                   + "//li/a[.//span[normalize-space(text())='Patient']]");

    // Add New Patient button on Patient List page (top right of box-header)
    // Using ancestor axis: <a> whose ancestor is div with class box-header
    public static By addNewPatientButton =
            By.xpath("//div[contains(@class,'box-header')]"
                   + "//a[contains(@class,'addpatient') "
                   + "or contains(text(),'Add New Patient') "
                   + "or contains(text(),'Add Patient')]");

    // =====================================================================
    // MODAL LOCATORS
    // =====================================================================

    // Modal title — "Add Patient" heading inside modal-header
    public static By modalTitle =
            By.xpath("//div[contains(@class,'modal-header')]"
                   + "//h4[contains(text(),'Add Patient')]");

    // Name input — first mandatory field (id='name')
    public static By patientName =
            By.xpath("//div[contains(@class,'modal-body')]//input[@id='name']");

    // Guardian Name — sibling input inside same row as Name
    // Using following-sibling axis inside the form row
    public static By guardianName =
            By.xpath("//input[@id='name']"
                   + "/following::input[@name='guardian_name'][1]");

    // Gender — select dropdown, identified by its id
    public static By gender =
            By.xpath("//select[@id='addformgender']");

    // Date Of Birth — single date input field (id='birth_date')
    public static By dob =
            By.xpath("//input[@id='birth_date']");

    // Age Year — input with placeholder='Year' inside the age calculate div
    // Using descendant axis from the calculate div
    public static By dobYear =
            By.xpath("//div[@id='calculate']//descendant::input[@id='age_year']");

    // Age Month — sibling of Year input inside calculate div
    public static By dobMonth =
            By.xpath("//div[@id='calculate']//descendant::input[@id='age_month']");

    // Age Day — sibling of Month input inside calculate div
    public static By dobDay =
            By.xpath("//div[@id='calculate']//descendant::input[@id='age_day']");

    // Blood Group — select dropdown, 2nd select inside modal-body
    public static By bloodGroup =
            By.xpath("//div[contains(@class,'col-sm-3')]"
                   + "//select[@name='blood_group']");

    // Phone — input with id='number'
    public static By phone =
            By.xpath("//input[@id='number']");

    // Email — input with id='addformemail'
    public static By email =
            By.xpath("//input[@id='addformemail']");

    // Address — input with name='address' inside the last full-width col
    public static By address =
            By.xpath("//div[contains(@class,'col-lg-12')]"
                   + "//input[@name='address']");

    // Save button — button with id='formaddpabtn' inside modal-footer
    public static By saveButton =
            By.xpath("//button[@id='formaddpabtn']");

    // =====================================================================
    // PATIENT LIST LOCATORS (after modal closes)
    // =====================================================================

    // Patient List box body — visible after modal closes on successful save
    public static By patientListTable =
            By.xpath("//div[@class='box-body']");

    // All table cells in Patient List table — used to search for saved name
    public static By tableCells =
            By.xpath("//div[contains(@class,'box-body')]//table//tbody//td");

    // =====================================================================
    // VALIDATION LOCATORS
    // =====================================================================

    // Validation error text shown when Name is empty and Save clicked
    // Using parent axis: finds error element that is sibling/near the name field
    public static By validationMessage =
            By.xpath("//*[@id='name-error' or @id='name_error']"
                   + " | //label[@for='name' and contains(@class,'error')]"
                   + " | //div[contains(@class,'alert-danger')]");
}