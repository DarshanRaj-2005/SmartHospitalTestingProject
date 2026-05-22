package actions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
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

        String path = System.getProperty("user.dir") + "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getExcelData(path,"Sheet1");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

        for(int i = 0; i < data.length; i++){

            String searchItem = data[i][0];

            System.out.println("🔍 Searching for : " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);

            Helper.clear(InventorySearchPage.searchBox);

            Helper.type(InventorySearchPage.searchBox,searchItem);

            try{

                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("DataTables_Table_0_processing")));

            }catch(Exception e){

                System.out.println("Processing popup not displayed");
            }

            wait.until(driver -> driver.findElements(InventorySearchPage.itemNames).size() > 0);

            logger.info("Validating search results for : " + searchItem);

            validateSearchResults(searchItem);
        }
    }

    public static void validateSearchResults(String searchItem){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        wait.until(driver -> driver.findElements(InventorySearchPage.itemNames).size() > 0);

        int size = Driver.getDriver().findElements(InventorySearchPage.itemNames).size();

        if(size == 0){

            Zero = false;

            System.out.println("No items found");

            return;
        }

        ArrayList<String> itemList = new ArrayList<>();

        for(int i = 0; i < size; i++){

            try{

                String itemName = Driver.getDriver().findElements(InventorySearchPage.itemNames).get(i).getText().trim();

                itemList.add(itemName);

            }catch(Exception e){

                System.out.println("Stale element skipped");
            }
        }

        System.out.println("Displayed Items : " + itemList);

        for(String item : itemList){

            String itemText = item.toLowerCase();

            String searchText = searchItem.toLowerCase();

            if(itemText.contains(searchText) || searchText.contains(itemText)){

                logger.info("MATCH FOUND : " + item);

                System.out.println("✅ MATCH : " + item);

            }else{

                logger.error("NOT MATCHED : " + item);

                System.out.println("❌ NOT MATCH : " + item);

                notmatch = false;
            }
        }
    }

    public void searchInvalidItems() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getExcelData(path,"Sheet2");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        for(int i = 0; i < data.length; i++){

            String searchItem = data[i][0];

            System.out.println("🔍 Searching invalid : " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);

            Helper.clear(InventorySearchPage.searchBox);

            Helper.type(InventorySearchPage.searchBox,searchItem);

            try{

                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("DataTables_Table_0_processing")));

            }catch(Exception e){

                System.out.println("Processing popup not displayed");
            }
        }
    }

    public boolean isNoDataMessageDisplayed(){

        Helper.waitForVisibility(InventorySearchPage.noDataText);

        String text = Helper.getText(InventorySearchPage.noDataText);

        return text.contains("No data available in table");
    }
}