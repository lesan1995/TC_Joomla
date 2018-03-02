package page_action;

import interfaces.Elements;

public class BannersClientsNewPage extends BasePage{
	private static BannersClientsNewPage bannersClientsNewPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersClientsNewPage() {
		readInterface();
	}
	public static BannersClientsNewPage getInstance() {
		if(bannersClientsNewPage==null) {
			bannersClientsNewPage=new BannersClientsNewPage();
			bannersClientsNewPage.initAction();
		}
		return bannersClientsNewPage;
	}
	/**
	 * Init action click, enter, check for page
	 */
	public void initAction() {
		clickTo=new Click();
		enterTo=new Enter();
		check=new Check();
	}
	public class Click{
		/**
		 * Click to button save and close
		 */
		public void buttonSaveAndClose() {
			click(readElement(Elements.BannersClientsNewPage.toolBar,Elements.BannersClientsNewPage.btnSaveAndClose));
		}
		
	}
	public class Enter{	
		/**
		 * Enter name
		 * @param name
		 */
		public void name(String name) {
			type(readElement(Elements.BannersClientsNewPage.tbName), name);
		}
		/**
		 * Enter contact name
		 * @param contact name
		 */
		public void contactName(String contactName) {
			type(readElement(Elements.BannersClientsNewPage.tbContactName), contactName);
		}
		/**
		 * Enter contact email
		 * @param contact email
		 */
		public void contactEmail(String contactEmail) {
			type(readElement(Elements.BannersClientsNewPage.tbContactEmail), contactEmail);
		}
	}
	
	public class Check{
	}
}
