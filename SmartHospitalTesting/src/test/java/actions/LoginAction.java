package actions;

import Utilities.Helper;
import pages.LoginPage;

public class LoginAction {
	public void clicksuperAdmin() {
		Helper.click(LoginPage.superAdmin);
	}
	
	public void clicksignIn() {
		Helper.click(LoginPage.signin);
	}
	
	public String message() {
		return Helper.getText(LoginPage.text);
	}
	public String messages() {
		return Helper.getText(LoginPage.texts);
	}
}
