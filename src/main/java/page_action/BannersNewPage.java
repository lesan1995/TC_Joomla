package page_action;

import org.openqa.selenium.Keys;

import common.Drivers;
import interfaces.Elements;

public class BannersNewPage extends BasePage{
	private static BannersNewPage bannersNewPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersNewPage() {
		readInterface();
	}
	public static BannersNewPage getInstance() {
		if(bannersNewPage==null) {
			bannersNewPage=new BannersNewPage();
			bannersNewPage.initAction();
		}
		return bannersNewPage;
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
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnSaveAndClose));
		}
		/**
		 * Click to button save and close
		 */
		public void buttonSaveAndNew() {
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnSaveAndNew));
		}
		/**
		 * Click to button save as copy
		 */
		public void buttonSaveAsCopy() {
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnSaveAsCopy));
		}
		/**
		 * Click to button save
		 */
		public void buttonSave() {
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnSave));
		}
		/**
		 * Click to button cancel
		 */
		public void buttonCancel() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnCancel));
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnCancel));
		}
		/**
		 * Click to button help
		 */
		public void buttonHelp() {
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersNewPage.btnHelp));
		}
		/**
		 * Click button category
		 */
		public void buttonCategory() {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.BannersNewPage.btnCategory));
			click(readElement(Elements.BannersNewPage.btnCategory));
		}
		/**
		 * Click list box category
		 * @param item
		 */
		public void listBoxCategory(String item) {
			click(readElement(Elements.BannersNewPage.lbCategory,item));
		}
		/**
		 * Click tab banner details
		 * 
		 */
		public void tabBannerDetails() {
			click(readElement(Elements.BannersNewPage.tabBannerDetails));
		}
		/**
		 * Click tab  details
		 * 
		 */
		public void tabDetails() {
			click(readElement(Elements.BannersNewPage.tabDetails));
		}
		/**
		 * Click button client
		 */
		public void buttonClient() {
			click(readElement(Elements.BannersNewPage.btnClient));
		}
		/**
		 * Click list box client
		 * @param item
		 */
		public void listBoxClient(String item) {
			click(readElement(Elements.BannersNewPage.lbClient,item));
		}
		/**
		 * Click button category
		 */
		public void buttonStatus() {
			click(readElement(Elements.BannersNewPage.btnStatus));
		}
		/**
		 * Click list box category
		 * @param item
		 */
		public void listBoxStatus(String item) {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.BannersNewPage.lbStatus,item));
			click(readElement(Elements.BannersNewPage.lbStatus,item));
		}
		
	}
	public class Enter{	
		/**
		 * Enter name
		 * @param name
		 */
		public void name(String name) {
			type(readElement(Elements.BannersNewPage.tbName), name);
		}
		/**
		 * Enter client
		 * @param name
		 */
		public void tbClient(String name) {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.BannersNewPage.tbClient));
			type(readElement(Elements.BannersNewPage.tbClient), name);
		}
		/**
		 * Enter client
		 * @param key
		 */
		public void tbClient(Keys name) {
			type(readElement(Elements.BannersNewPage.tbClient), name);
		}
		/**
		 * Enter client
		 * @param name
		 */
		public void tbCategory(String name) {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.BannersNewPage.tbCategory));
			type(readElement(Elements.BannersNewPage.tbCategory), name);
		}
		/**
		 * Enter client
		 * @param key
		 */
		public void tbCategory(Keys name) {
			type(readElement(Elements.BannersNewPage.tbCategory), name);
		}
		
		
	}
	
	public class Check{
		/**
		 * check button client
		 */
		public boolean buttonClient() {
			return isElementDisplay(readElement(Elements.BannersNewPage.btnClient));
		}
		/**
		 * check button category
		 */
		public boolean buttonCategory() {
			return isElementDisplay(readElement(Elements.BannersNewPage.btnCategory));
		}
		/**
		 * Check title edit page
		 * @param title
		 * @return
		 */
		public boolean pageEditShow(String title) {
			return Drivers.getInstance().getDriver().getTitle().equals(title);
		}
		/**
		 * Check message article saved
		 * @return
		 */
		public boolean messageBanner(String content) {
			return read(readElement(Elements.BannersNewPage.messageBanner)).equals(content);
		}
		/**
		 * Check textbox name to red
		 * @return
		 */
		public boolean textBoxNameToRed() {
			return getColorValue(readElement(Elements.BannersNewPage.tbName)).equals("rgba(242, 222, 222, 1)");
		}
		/**
		 * Check help page display
		 * @return
		 */
		public boolean titleHelpPage() {
			swithTo.popUp();
			if(Drivers.getInstance().browser.equals("ie")) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Drivers.getInstance().waitTo.pageLoad();
			}
			boolean result=Drivers.getInstance().getDriver().getTitle().contains("Joomla! Help Screens");
			swithTo.Default();
			return result;
		}
	}
	/**
	 * Select item category
	 * @param item
	 */
	public void selectItemCategory(String item) {
		check.buttonCategory();
		focus(readElement(Elements.BannersNewPage.btnCategory));
		clickTo.buttonCategory();
		enterTo.tbCategory(item);
		enterTo.tbCategory(Keys.ENTER);
	}
	/**
	 * Select item client
	 * @param item
	 */
	public void selectItemClient(String item) {
		scrollToTop();
		clickTo.tabBannerDetails();
		check.buttonClient();
		focus(readElement(Elements.BannersNewPage.btnClient));
		clickTo.buttonClient();
		enterTo.tbClient(item);
		enterTo.tbClient(Keys.ENTER);
		clickTo.tabDetails();
		
	}
	/**
	 * Select item status
	 * @param item
	 */
	public void selectItemStatus(String item) {
		//scrollToTop();
		clickTo.tabDetails();
		clickTo.buttonStatus();
		clickTo.listBoxStatus(item);
	}
}
