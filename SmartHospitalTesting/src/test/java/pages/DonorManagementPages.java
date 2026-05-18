package pages;

import org.openqa.selenium.By;

public class DonorManagementPages {

	public static By bloodBankMenu =By.xpath("//span[text()='Blood Bank']");
	public static By donorDetails =By.xpath("//a[contains(text(),'Donor Details')]");
	public static By addBloodDonor =By.xpath("//a[contains(@onclick,'myModal')]");
	public static By addDonorPopup =By.xpath("//h4[text()='Add Donor Details']");
	public static By donorName =By.xpath("(//input[@name='donor_name'])[1]");
	public static By dateOfBirth =By.xpath("(//input[@name='date_of_birth'])[1]");
	public static By bloodGroup =By.xpath("(//select[@name='blood_group'])[1]");
	public static By gender =By.xpath("(//select[@name='gender'])[1]");
	public static By fatherName =By.name("father_name");
	public static By contactNumber =By.name("contact_no");
	public static By address =By.name("address");
	public static By saveButton =By.xpath("//button[@id='formaddbtn']");
	public static By validationMessages =By.xpath("//div[contains(@class,'toast-message')]");
}



