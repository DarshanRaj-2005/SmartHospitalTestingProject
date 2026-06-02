package actions;

import Utilities.Helper;
import pages.ContactUsPage;

public class ContactUsAction {


public void clickContactUsButton() {

    Helper.click(ContactUsPage.contactUsBtn);

    Helper.waitForPresence(ContactUsPage.name, 30);
}

public void enterContactDetails(String name,
                                String email,
                                String subject,
                                String description) {

    Helper.waitForPresence(ContactUsPage.name, 30);
    Helper.waitForPresence(ContactUsPage.email, 30);
    Helper.waitForPresence(ContactUsPage.subject, 30);
    Helper.waitForPresence(ContactUsPage.description, 30);

    Helper.clearAndEnterText(ContactUsPage.name, name);
    Helper.clearAndEnterText(ContactUsPage.email, email);
    Helper.clearAndEnterText(ContactUsPage.subject, subject);
    Helper.clearAndEnterText(ContactUsPage.description, description);
}

public void clickSubmitButton() {

    Helper.waitForPresence(ContactUsPage.submit, 30);

    Helper.click(ContactUsPage.submit);
}

public boolean isContactSubmittedSuccessfully() {

    try {

        Helper.waitForSuccessNotification(
                ContactUsPage.successMessage);

        return Helper.isDisplayed(
                ContactUsPage.successMessage);

    } catch (Exception e) {

        return false;
    }
}

public String getSuccessMessage() {

    try {

        return Helper.getText(
                ContactUsPage.successMessage);

    } catch (Exception e) {

        return "";
    }
}


}
