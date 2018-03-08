package page_action;

import common.Drivers;
import interfaces.Elements;

public class BannersClientsPage extends BasePage{
	private static BannersClientsPage bannersClientsPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersClientsPage() {
		readInterface();
	}
	public static BannersClientsPage getInstance() {
		if(bannersClientsPage==null) {
			bannersClientsPage=new BannersClientsPage();
			bannersClientsPage.initAction();
		}
		return bannersClientsPage;
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
		 * Click button new
		 */
		public void buttonNew() {
			click(readElement(Elements.BannersClientsPage.toolBar,Elements.BannersClientsPage.btnNew));
		}
		/**
		 * Click button search
		 */
		public void buttonSearch() {
			click(readElement(Elements.BannersClientsPage.btnSearch));
		}
		/**
		 * Click button clear input search
		 */
		public void buttonClear() {
			click(readElement(Elements.BannersClientsPage.btnClear));
		}
		
	}
	public class Enter{	
		/**
		 * Type content to textbox search
		 * @param content
		 */
		public void textBoxSearch(String content) {
			type(readElement(Elements.BannersClientsPage.tbSearch), content);
		}
	}
	
	public class Check{
		/**
		 * Check message article saved
		 * @return
		 */
		public boolean messageClient(String content) {
			return read(readElement(Elements.BannersClientsPage.messageClient)).equals(content);
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultSearch(String content) {
			enterTo.textBoxSearch(content);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.BannersClientsPage.resultSearch));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check title client page
		 * @param title
		 * @return
		 */
		public boolean pageClientShow(String title) {
			return Drivers.getInstance().getDriver().getTitle().equals(title);
		}
	}
}
