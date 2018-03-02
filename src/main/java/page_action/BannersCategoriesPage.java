package page_action;

import interfaces.Elements;

public class BannersCategoriesPage extends BasePage{
	private static BannersCategoriesPage bannersCategoriesPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersCategoriesPage() {
		readInterface();
	}
	public static BannersCategoriesPage getInstance() {
		if(bannersCategoriesPage==null) {
			bannersCategoriesPage=new BannersCategoriesPage();
			bannersCategoriesPage.initAction();
		}
		return bannersCategoriesPage;
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
			click(readElement(Elements.BannersCategoriesPage.toolBar,Elements.BannersCategoriesPage.btnNew));
		}
		/**
		 * Click button search
		 */
		public void buttonSearch() {
			click(readElement(Elements.BannersCategoriesPage.btnSearch));
		}
		/**
		 * Click button clear input search
		 */
		public void buttonClear() {
			click(readElement(Elements.BannersCategoriesPage.btnClear));
		}
		
	}
	public class Enter{
		/**
		 * Type content to textbox search
		 * @param content
		 */
		public void textBoxSearch(String content) {
			type(readElement(Elements.BannersCategoriesPage.tbSearch), content);
		}
	}
	
	public class Check{
		/**
		 * Check message article saved
		 * @return
		 */
		public boolean messageCategory(String content) {
			return read(readElement(Elements.BannersCategoriesPage.messageCategory)).contains(content);
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultSearch(String content) {
			enterTo.textBoxSearch(content);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.BannersCategoriesPage.resultSearch));
			clickTo.buttonClear();
			return result;
		}
	}
}
