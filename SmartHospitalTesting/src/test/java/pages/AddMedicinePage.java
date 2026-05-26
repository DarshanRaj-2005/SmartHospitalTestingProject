package pages;

import org.openqa.selenium.By;

public class AddMedicinePage {

	public static By medicineTab = By.className("modal-content");

	public static By addMedicineButton = By.xpath("//a[@class='btn btn-primary btn-sm addmedicine']");

	public static By saveButton = By.id("formaddbtn");
	public static By medicineNameField = By.id("medicine_name");

	public static By compositionField = By.name("medicine_composition");

	public static By minLevelField = By.xpath("//form[@id='formadd']//input[@name='min_level']");

	public static By reorderLevelField = By.xpath("//form[@id='formadd']//input[@name='reorder_level']");
	public static By taxField = By.name("vat");

	public static By boxPackingField = By.xpath("//form[@id='formadd']//input[@name='unit_packing']");

	public static By vatField = By.xpath("//form[@id='formadd']//input[@name='vat_ac']");

	public static By rackNumberField = By.xpath("//form[@id='formadd']//input[@name='rack_number']");

	public static By noteField = By.name("note");
	public static By categoryDropdown = By.name("medicine_category_id");

	public static By companyDropdown = By.name("medicine_company");

	public static By groupDropdown = By.name("medicine_group");

	public static By unitDropdown = By.name("unit");

	public static By medicineNameValidationMessage = By.xpath("//div[contains(@class,'toast-message')]//p");
	public static By medicineRows = By.xpath("//table[@id='DataTables_Table_0']//tr");
	public static By medicineTable = By.id("DataTables_Table_0");
}