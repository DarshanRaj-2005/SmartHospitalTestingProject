package pages;

import org.openqa.selenium.By;

public class BloodIssuePage {
    public static By bloodIssuedetails    = By.xpath("//a[normalize-space()='Blood Issue Details']");
    public static By issueBloodbutton     = By.xpath("//button[contains(text(),'Issue Blood')]");
    public static By patientdropdown      = By.xpath("(//span[contains(@class,'select2-selection--single')])[4]");
    public static By issuedate            = By.xpath("(//input[@name='date_of_issue'])[2]");
    public static By doctorDropdown       = By.xpath("(//span[contains(@class,'select2-selection--single')])[2]");
    public static By bloodgroupField      = By.xpath("//span[contains(@class,'select2-selection__rendered') and contains(@id,'blood_group')]");
    public static By referenceNamefield   = By.xpath("//input[@id='reference']");
    public static By bloodBagdropdown     = By.xpath("(//span[@role='combobox']/following::span[text()='Select'])[4]");
    public static By chargecategorydropdown = By.xpath("(//span[contains(@class,'select2-selection--single')])[8]");
    public static By chargenameDropdown   = By.xpath("(//span[@class='select2-selection__rendered'])[9]");
    public static By saveButton           = By.xpath("//button[@id='formaddbtn']");
    public static By paymentfield         = By.xpath("//input[@id='payment_amount']");
    public static By searchBox            = By.xpath("//input[@class='select2-search__field']");
    public static By successMessage       = By.xpath("//div[contains(@class,'toast-message')]");
   // public static By loadingText          = By.xpath("//li[contains(text(),'Loading')]");
    public static By firstRow             = By.xpath("(//table/tbody/tr)[1]");
    public static By deleteButton         = By.xpath("(//i[@class='fa fa-trash'])[1]");
    public static By deleteMessage        = By.xpath("//div[contains(text(),'Record Deleted Successfully')]");
    public static By validationMessage    = By.xpath("//div[@class='toast toast-error']");
    public static By successToast        = By.xpath("//div[contains(@class,'toast-success')]");
    public static By firstOption = By.xpath("//li[text()='Select']/following-sibling::li[1]");
    public static By dynamicOption(String option) {
        return By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + option + "')]");
    }
    public static By name=By.xpath("//label[text()='Name']/following-sibling::input");
    public static By newPatient=By.xpath("//span[contains(text(),'New Patient')]");
    public static By ageYear=By.cssSelector("input[placeholder='Year']");
    public static By ageMonth=By.cssSelector  ("input[placeholder='Month']");
    public static By ageDay=By.cssSelector ("input[placeholder='Day']");
    public static By patientSave=By.xpath("(//button[normalize-space()='Save'])[3]");
    public static By addPatientPopup =By.xpath("//h4[contains(text(),'Add Patient')]");
}