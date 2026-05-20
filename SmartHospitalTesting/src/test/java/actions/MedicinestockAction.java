package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Helper;
import pages.MedicinestockPage;

public class MedicinestockAction {

	public void clickmedicinebutton() {
		Helper.waitForElementClickable(MedicinestockPage.medicinebutton);
		Helper.click(MedicinestockPage.medicinebutton);
	}

	public void searchMedicine(String medicine) {
		Helper.waitForElementClickable(MedicinestockPage.medicineSearchbar);
		Helper.click(MedicinestockPage.medicineSearchbar);
		Helper.clear(MedicinestockPage.medicineSearchbar);
		Helper.type(MedicinestockPage.medicineSearchbar, medicine);

	}

	public String verifySearchedMedicine(String searchedmedicine) {
		By loc=MedicinestockPage.medicinetext(searchedmedicine);
		WebElement element=Helper.get;
		Helper.waitForVisibility(MedicinestockPage.searchedmedicine);
		return Helper.getText(MedicinestockPage.searchedmedicine);
		
	}
	
	public void selectMedicine(String medicine) {

	    By locator = MedicinestockPage.medicineCheckbox(medicine);

	    WebElement element = Helper.getClickableElement(locator);

	    if (!element.isSelected()) {
	        element.click();
	    }
	}
	public void clickDeleteButton() {
		Helper.waitForElementClickable(MedicinestockPage.deleteButton);
		Helper.click(MedicinestockPage.deleteButton);
	}
	public void clickdeleteConfirm(){
		Helper.acceptAlert();
	}
	public String verifyDeleteConfirmation() {
		Helper.waitForVisibility(MedicinestockPage.deleteConfirmation);
		return Helper.getText(MedicinestockPage.deleteConfirmation);
		
	}
}
