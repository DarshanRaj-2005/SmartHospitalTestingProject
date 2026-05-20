package actions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.InventorySearchPage;
import Utilities.Helper;
import Utilities.Data_Provider;
import driver.Driver;

public class InventorySearchActions {
	 private static final Logger logger = LogManager.getLogger(InventorySearchActions.class);

    public static boolean Zero = true;
    public static boolean notmatch = true;
 
    
    public static void searchValidItems() throws Exception {

    	
        notmatch = true;
        Zero = true;
        logger.info("Starting valid inventory search test");

        String path = System.getProperty("user.dir") +
                "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getExcelData(path, "Sheet1");

        for (int i = 0; i < data.length; i++) {

            String searchItem = data[i][0];

            System.out.println("🔍 Searching for: " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);
            Helper.getElements(InventorySearchPage.searchBox);
            Helper.clear(InventorySearchPage.searchBox);
            Helper.type(InventorySearchPage.searchBox, searchItem);
            logger.info("Waiting for search results");

           // Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(InventorySearchPage.itemNames));
			 logger.info("Validating search results for: " + searchItem);
            validateSearchResults(searchItem);
        }
    }

    // 🔥 VALIDATION METHOD
    public static void validateSearchResults(String searchItem) {

        Helper.waitForVisibility(InventorySearchPage.itemNames);

        List<WebElement> elements =
                Driver.getDriver().findElements(InventorySearchPage.itemNames);
        

        if (elements.size() == 0) {
            Zero = false;
        }

        ArrayList<String> itemList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {

            List<WebElement> freshElements =
                    Driver.getDriver().findElements(InventorySearchPage.itemNames);

            String name = freshElements.get(i).getText().trim();
            itemList.add(name);
        }

        System.out.println("Items displayed: " + itemList);

        for (String item : itemList) {

            String itemText = item.toLowerCase();
            String searchText = searchItem.toLowerCase();

            if (itemText.contains(searchText) || searchText.contains(itemText)) {
                logger.info("MATCH FOUND: " + item);
                System.out.println("✅ Match: " + item);
            } else {
            	 logger.error("NOT MATCHED ITEM: " + item);
                System.out.println("❌ Not Match: " + item);
                notmatch = false;
            }
        }
    }

    // 🔥 INVALID SEARCH (ONLY SEARCH)
    public void searchInvalidItems() throws IOException {

        String path = System.getProperty("user.dir") +
                "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getExcelData(path, "Sheet2");

        for (int i = 0; i < data.length; i++) {

            String searchItem = data[i][0];

            System.out.println("🔍 Searching invalid: " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);
            Helper.getElements(InventorySearchPage.searchBox);
            Helper.clear(InventorySearchPage.searchBox);
            Helper.type(InventorySearchPage.searchBox, searchItem);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(InventorySearchPage.itemNames));
			
        }
    }

    // 🔥 ERROR MESSAGE VALIDATION
    public boolean isNoDataMessageDisplayed() {

        Helper.waitForVisibility(InventorySearchPage.noDataText);

        String text = Helper.getText(InventorySearchPage.noDataText);

        return text.contains("No data available in table");
    }
}