package pages;

import org.openqa.selenium.By;


public class SearchPatientPage {

    public static By patientSidebarLink =
            By.xpath("//ul[contains(@class,'sidebar-menu') or contains(@class,'nav-sidebar') or contains(@class,'side-menu')]"
                   + "//a[normalize-space(.)='Patient' or normalize-space(text())='Patient']");

    public static By searchBox =
            By.xpath("//div[contains(@class,'dataTables_filter')]//input"
                   + " | //input[@placeholder='Search...' or @placeholder='Search']"
                   + " | //input[contains(@aria-controls,'patient')]");

    public static By tableRows =
            By.xpath("//table[contains(@class,'table')]//tbody//tr");

    public static By noDataRow =
            By.xpath("//table[contains(@class,'table')]//tbody//tr//td[contains(@class,'dataTables_empty')]"
                   + " | //table[contains(@class,'table')]//tbody//tr[td[contains(text(),'No data available')]]"
                   + " | //table[contains(@class,'table')]//tbody//tr[td[contains(text(),'No matching records')]]"
                   + " | //table[contains(@class,'table')]//tbody//tr[td[contains(text(),'No records found')]]"
                   + " | //td[contains(@class,'dataTables_empty')]");

    public static By processingSpinner =
            By.xpath("//*[contains(@class,'dataTables_processing')]");

    public static By emptyTd =
            By.xpath("//td[contains(@class,'dataTables_empty')]");
}
