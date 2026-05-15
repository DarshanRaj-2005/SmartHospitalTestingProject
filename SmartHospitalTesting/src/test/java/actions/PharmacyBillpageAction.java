package actions;

import Utilities.Helper;
import pages.PharmacyBillPage;

public class PharmacyBillpageAction {

    public void clickPharmacy() {

        Helper.waitForElementClickable(PharmacyBillPage.pharmacyMenu);

        Helper.click(PharmacyBillPage.pharmacyMenu);
    }
}