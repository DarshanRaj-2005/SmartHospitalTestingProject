package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import pages.InventorySearchPage;
import Utilities.Helper;
import Utilities.Data_Provider;
import driver.Driver;

public class InventorySearchActions {

    public static boolean Zero = true;
    public static boolean notmatch = true;

    
    public static void searchValidItems() throws Exception {

      
        notmatch = true;
        Zero = true;

        String path = System.getProperty("user.dir") +
                "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getData(path, "Sheet1");

        for (int i = 0; i < data.length; i++) {

            String searchItem = data[i][0];

            System.out.println("🔍 Searching for: " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);
            Helper.getElement(InventorySearchPage.searchBox).clear();
            Helper.type(InventorySearchPage.searchBox, searchItem);

            Thread.sleep(2000);

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
                System.out.println("✅ Match: " + item);
            } else {
                System.out.println("❌ Not Match: " + item);
                notmatch = false;
            }
        }
    }

    // 🔥 INVALID SEARCH (ONLY SEARCH)
    public void searchInvalidItems() throws IOException {

        String path = System.getProperty("user.dir") +
                "/src/test/resources/test_datas/Tamilarasu_data/Search_item_data.xlsx";

        String[][] data = Data_Provider.getData(path, "Sheet2");

        for (int i = 0; i < data.length; i++) {

            String searchItem = data[i][0];

            System.out.println("🔍 Searching invalid: " + searchItem);

            Helper.waitForVisibility(InventorySearchPage.searchBox);
            Helper.getElements(InventorySearchPage.searchBox).clear();
            Helper.type(InventorySearchPage.searchBox, searchItem);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 🔥 ERROR MESSAGE VALIDATION
    public boolean isNoDataMessageDisplayed() {

        Helper.waitForVisibility(InventorySearchPage.noDataText);

        String text = Helper.getText(InventorySearchPage.noDataText);

        return text.contains("No data available in table");
    }
}