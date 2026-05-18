package actions;

import Utilities.Helper;
import pages.ContactUsPage;

public class ContactUsAction {

    public static void clickContactUs() {
        Helper.waitForVisibility(ContactUsPage.contactUsBtn);
        Helper.click(ContactUsPage.contactUsBtn);
    }

    // ✅ Enter Details Method
    public static void enterdetails(String name, String email, String subject, String description) {

        Helper.waitForVisibility(ContactUsPage.name);
        Helper.type(ContactUsPage.name, name);

        Helper.type(ContactUsPage.email, email);
        Helper.type(ContactUsPage.subject, subject);
        Helper.type(ContactUsPage.description, description);
    }

    public static void submit() {
        Helper.waitForVisibility(ContactUsPage.submit);
        Helper.click(ContactUsPage.submit);
    }
    

    public static void check() {

        // Wait for success message
        Helper.waitForVisibility(ContactUsPage.successMessage);
        Helper.waitForVisibility(ContactUsPage.successMessage);
        

        // Get actual text
        String actualText = Helper.getText(ContactUsPage.successMessage);

        System.out.println("Actual Message: " + actualText); // 🔥 Debug

        // Assertion
        org.testng.Assert.assertTrue(
            actualText.contains("We will contact you soon"),
            "❌ Message not matching. Actual: " + actualText
        );
    }
}