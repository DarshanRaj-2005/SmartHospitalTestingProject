package actions;

import pages.AddNewStockPage;

public class AddNewStock {

    AddNewStockPage addNewStockPage =
            new AddNewStockPage();

    public void clickInventory() {

        addNewStockPage.clickInventory();
    }

    public void clickAddItemStockButton() {

        addNewStockPage.clickAddItemStock();
    }

    public void fillStockDetails(
            String qty,
            String price,
            String desc) {

        addNewStockPage.enterQuantity(qty);
        addNewStockPage.enterPurchasePrice(price);
        addNewStockPage.enterDescription(desc);
    }
    
    public void selectDropdown() {
    	addNewStockPage.selecttheitems();
    	
    	
    }

    public void clickSaveButton() {
        addNewStockPage.clickSaveButton();
    }
}