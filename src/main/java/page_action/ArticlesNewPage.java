package page_action;
import org.openqa.selenium.Keys;

import common.Drivers;
import interfaces.Elements;

public class ArticlesNewPage extends BasePage {
	private static ArticlesNewPage articlesNewPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private ArticlesNewPage() {
		readInterface();
	}
	public static ArticlesNewPage getInstance() {
		if(articlesNewPage==null) {
			articlesNewPage=new ArticlesNewPage();
			articlesNewPage.initAction();
		}
		return articlesNewPage;
	}
	/**
	 * Init action click, enter of page
	 */
	public void initAction() {
		clickTo=new Click();
		enterTo=new Enter();
		check=new Check();
	}
	public class Click{
		/**
		 * Click button category
		 */
		public void buttonCategory() {
			click(readElement(Elements.ArticlesNewPage.btnCategory));
		}
		/**
		 * Click list box category
		 * @param item
		 */
		public void listBoxCategory(String item) {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesNewPage.lbCategory,item));
			click(readElement(Elements.ArticlesNewPage.lbCategory,item));
		}

		/**
		 * Click to button save and close
		 */
		public void buttonSaveAndClose() {
			click(readElement(Elements.ArticlesNewPage.btnSaveAndClose));
		}
		/**
		 * Click to button save
		 */
		public void buttonSave() {
			click(readElement(Elements.ArticlesNewPage.btnSave));
		}
		/**
		 * Click button category
		 */
		public void buttonStatus() {
			click(readElement(Elements.ArticlesNewPage.btnStatus));
		}
		/**
		 * Click list box category
		 * @param item
		 */
		public void listBoxStatus(String item) {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesNewPage.lbStatus,item));
			click(readElement(Elements.ArticlesNewPage.lbStatus,item));
		}
		/**
		 * Click button category
		 */
		public void buttonAccess() {
			click(readElement(Elements.ArticlesNewPage.btnAccess));
		}
		/**
		 * Click list box category
		 * @param item
		 */
		public void listBoxAccess(String item) {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesNewPage.lbAccess,item));
			click(readElement(Elements.ArticlesNewPage.lbAccess,item));
		}
		/**
		 * Click to button image
		 */
		public void buttonImage() {
			click(readElement(Elements.ArticlesNewPage.btnImage));
		}
		/**
		 * Click to button insert
		 */
		public void buttonInsert() {
			focus(readElement(Elements.ArticlesNewPage.ifImage));
			swithTo.frame(readElement(Elements.ArticlesNewPage.ifImage));
			scrollToTop();
			click(readElement(Elements.ArticlesNewPage.btnInsertImage));
			swithTo.Default();
		}
//		/**
//		 * Click to image with title image
//		 */
//		public void imageInsert(String title) {
//			focus(readElement(Elements.ArticlesNewPage.ifImage));
//			click(readElement(Elements.ArticlesNewPage.ifImage));
//			focus(readElement(Elements.ArticlesNewPage.ifImage));
//			click(readElement(Elements.ArticlesNewPage.ifImage));
//			swithTo.frame(readElement(Elements.ArticlesNewPage.ifImage));
//			
//			swithTo.Default();
//			
//			focus(readElement(Elements.ArticlesNewPage.ifImage));
//			click(readElement(Elements.ArticlesNewPage.ifImage));
//			focus(readElement(Elements.ArticlesNewPage.ifImage));
//			click(readElement(Elements.ArticlesNewPage.ifImage));
//			swithTo.frame(readElement(Elements.ArticlesNewPage.ifImage));
//
//			
//			focus(readElement(Elements.ArticlesNewPage.fsUpload));
//			swithTo.frame(readElement(Elements.ArticlesNewPage.fsUpload));
//			
//			click(readElement(Elements.ArticlesNewPage.selectImage,title));
//			swithTo.Default();
//		}
		/**
		 * Click to image with title image
		 */
		public void imageInsert(String title) {
			focus(readElement(Elements.ArticlesNewPage.ifImage));
			click(readElement(Elements.ArticlesNewPage.ifImage));
			focus(readElement(Elements.ArticlesNewPage.ifImage));
			click(readElement(Elements.ArticlesNewPage.ifImage));
			swithTo.frame(readElement(Elements.ArticlesNewPage.ifImage));
			
			swithTo.Default();
			
			focus(readElement(Elements.ArticlesNewPage.ifImage));
			click(readElement(Elements.ArticlesNewPage.ifImage));
			focus(readElement(Elements.ArticlesNewPage.ifImage));
			click(readElement(Elements.ArticlesNewPage.ifImage));
			swithTo.frame(readElement(Elements.ArticlesNewPage.ifImage));

			
			focus(readElement(Elements.ArticlesNewPage.fsUpload));
			swithTo.frame(readElement(Elements.ArticlesNewPage.fsUpload));
			
			click(readElement(Elements.ArticlesNewPage.selectImage,title));
			swithTo.Default();
		}
	}
	public class Enter{
		/**
		 * Enter title
		 * @param title
		 */
		public void title(String title) {
			type(readElement(Elements.ArticlesNewPage.tbTitle), title);
		}
		/**
		 * Enter content to create new article
		 * @param content
		 */
		public void content(String content) {
			click(readElement(Elements.ArticlesNewPage.ifContent));
			swithTo.frame(readElement(Elements.ArticlesNewPage.ifContent));
			type(readElement(Elements.ArticlesNewPage.tbContent), content);
			swithTo.Default();
		}
		/**
		 * Enter client
		 * @param name
		 */
		public void tbCategory(String name) {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.ArticlesNewPage.tbCategory));
			type(readElement(Elements.ArticlesNewPage.tbCategory), name);
		}
		/**
		 * Enter client
		 * @param key
		 */
		public void tbCategory(Keys name) {
			type(readElement(Elements.ArticlesNewPage.tbCategory), name);
		}

	}
	public class Check{
		/**
		 * Click button category
		 */
		public void buttonCategory() {
			isElementDisplay(readElement(Elements.ArticlesNewPage.btnCategory));
		}
	}
	
	
//	/**
//	 * Select item category
//	 * @param item
//	 */
//	public void selectItemCategorys(String item) {
//		clickTo.buttonCategory();
//		clickTo.listBoxCategory(item);
//	}
	/**
	 * Select item category
	 * @param item
	 */
	public void selectItemCategory(String item) {
		check.buttonCategory();
		focus(readElement(Elements.ArticlesNewPage.btnCategory));
		clickTo.buttonCategory();
		enterTo.tbCategory(item);
		enterTo.tbCategory(Keys.ENTER);
	}
	/**
	 * Select item status
	 * @param item
	 */
	public void selectItemStatus(String item) {
		clickTo.buttonStatus();
		clickTo.listBoxStatus(item);
	}
	/**
	 * Select item access
	 * @param item
	 */
	public void selectItemAccess(String item) {
		clickTo.buttonAccess();
		clickTo.listBoxAccess(item);
	}

}
