package page_action;

import interfaces.Elements;

public class LoginPage extends BasePage{
	private static LoginPage loginPage=null;
	public Click clickTo;
	public Enter enterTo;
	private LoginPage() {
		readInterface();
	}
	public static LoginPage getInstance() {
		if(loginPage==null) {
			loginPage=new LoginPage();
			loginPage.initAction();
		}
		return loginPage;
	}
	/**
	 * Init action click, enter
	 */
	public void initAction() {
		clickTo=new Click();
		enterTo=new Enter();
	}
	public class Click{
		/**
		 * Click button login
		 */
		public void buttonLogin() {
			click(readElement(Elements.LoginPage.btnLogin));
		}
	}
	public class Enter{
		/**
		 * Enter username to login
		 * @param userName
		 */
		public void userName(String userName) {
			type(readElement(Elements.LoginPage.tbUserName), userName);
		}
		/**
		 * Enter password to login
		 * @param password
		 */
		public void password(String password) {
			type(readElement(Elements.LoginPage.tbPassword), password);
		}
	}

	/**
	 * Login to page
	 */
	public void login(String userName, String password) {
		enterTo.userName(userName);
		enterTo.password(password);
		clickTo.buttonLogin();
	}

}
