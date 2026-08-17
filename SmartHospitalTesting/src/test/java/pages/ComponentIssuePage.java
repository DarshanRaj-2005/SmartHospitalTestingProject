package pages;

import org.openqa.selenium.By;

public class ComponentIssuePage {

    public static By componentIssue =
            By.xpath("//a[normalize-space()='Component Issue']");

    public static By componentIssueHeading =
            By.xpath("//h3[@class='card-title titlefix']");  
    public static By searchBox =
            By.xpath("//input[@type='search']");

    public static By componentIssueTable =
            By.xpath("//table[@id='DataTables_Table_0']");

    public static By noMatchingRecords =
            By.xpath("//td[@class='dataTables_empty']");

    public static By searchedRecord(String value) {
        return By.xpath("//table[@id='DataTables_Table_0']//td[contains(normalize-space(),'" + value + "')]");
    }
}