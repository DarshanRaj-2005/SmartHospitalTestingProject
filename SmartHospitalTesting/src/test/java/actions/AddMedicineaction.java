package actions;

import java.util.Map;

import Utilities.Helper;
import pages.Addmedicine;

public class AddMedicineaction {

    String path = "src/test/resources/testdata/medicine.xlsx";
    String sheet = "Sheet1";

    public void clickAddMedicine() {
        Helper.click(MedicineStockPage.addMedicineBtn);
    }

    public void enterMedicineFromExcelRow(int rowNum) {

        Map<String, String> data = ExcelReader.getRowData(path, sheet, rowNum);

        Helper.type(MedicineStockPage.medicineName, data.get("medicineName"));
        Helper.type(MedicineStockPage.category, data.get("category"));
        Helper.type(MedicineStockPage.batch, data.get("batch"));
        Helper.type(MedicineStockPage.expiryDate, data.get("expiryDate"));
        Helper.type(MedicineStockPage.quantity, data.get("quantity"));
        Helper.type(MedicineStockPage.rate, data.get("rate"));
        Helper.type(MedicineStockPage.manufacturer, data.get("manufacturer"));
    }

    public void clickSave() {
        Helper.click(MedicineStockPage.saveBtn);
    }

    public String getSuccessMessage() {
        return Helper.getText(MedicineStockPage.successMsg);
    }

    public String getErrorMessage() {
        return Helper.getText(MedicineStockPage.errorMsg);
    }

    public boolean isMedicinePresent(String name) {
        return Helper.isTextPresent(name);
    }
}