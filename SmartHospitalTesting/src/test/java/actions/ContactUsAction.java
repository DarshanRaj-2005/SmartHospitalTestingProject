package actions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.CsvReader;
import Utilities.Helper;
import pages.ContactUsPage;

public class ContactUsAction {
	 static Logger logger = LogManager.getLogger(ContactUsAction.class);

    public static void clickContactUs() {
    	 logger.info("Waiting for Contact Us button");
        Helper.waitForVisibility(ContactUsPage.contactUsBtn);
        Helper.click(ContactUsPage.contactUsBtn);
    }

    public static void enterDetails(String name, String email, String subject, String description) {

        Helper.waitForVisibility(ContactUsPage.name);

        Helper.type(ContactUsPage.name, name);
        Helper.type(ContactUsPage.email, email);
        Helper.type(ContactUsPage.subject, subject);
        Helper.type(ContactUsPage.description, description);
    }

    // ⭐ CSV-driven execution moved inside ACTION class
    public static void enterDetailsFromCSV() throws Exception {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/test_datas/Tamilarasu_data/contactus.csv";
        logger.info("Reading CSV file from: " + path);
        List<String[]> data = CsvReader.readCsv(path);

        for (String[] row : data) {

            String name = row[0];
            String email = row[1];
            String subject = row[2];
            String description = row[3];

            System.out.println("Submitting Contact Us for: " + name);

            clickContactUs();
            enterDetails(name, email, subject, description);
        }
    }

    public static void submit() {
    	logger.info("Waiting for submit button");
        Helper.waitForVisibility(ContactUsPage.submit);
        Helper.click(ContactUsPage.submit);
    }

    public static void verifySuccess() {

        Helper.waitForVisibility(ContactUsPage.successMessage);

        String actual = Helper.getText(ContactUsPage.successMessage);

        System.out.println("Success Message: " + actual);

        org.testng.Assert.assertTrue(
                actual.contains("We will contact you soon"),
                "Contact Us submission failed"
        );
    }
}