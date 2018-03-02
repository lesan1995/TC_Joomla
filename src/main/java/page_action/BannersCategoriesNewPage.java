package page_action;

import interfaces.Elements;

public class BannersCategoriesNewPage extends BasePage{
	private static BannersCategoriesNewPage bannersCategoriesNewPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersCategoriesNewPage() {
		readInterface();
	}
	public static BannersCategoriesNewPage getInstance() {
		if(bannersCategoriesNewPage==null) {
			bannersCategoriesNewPage=new BannersCategoriesNewPage();
			bannersCategoriesNewPage.initAction();
		}
		return bannersCategoriesNewPage;
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
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersCategoriesNewPage.btnSaveAndClose));
		}
		
	}
	public class Enter{	
		/**
		 * Enter title
		 * @param title
		 */
		public void nameCategory(String title) {
			type(readElement(Elements.BannersCategoriesNewPage.tbTitle), title);
		}
	}
	
	public class Check{
	}
}
