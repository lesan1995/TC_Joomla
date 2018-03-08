package page_action;

import org.openqa.selenium.Keys;
import common.Contant;
import common.Drivers;
import interfaces.Elements;

public class BannersPage extends BasePage{
	private static BannersPage bannersPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	private BannersPage() {
		readInterface();
	}
	public static BannersPage getInstance() {
		if(bannersPage==null) {
			bannersPage=new BannersPage();
			bannersPage.initAction();
		}
		return bannersPage;
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
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnNew));
		}
		/**
		 * Click button new
		 */
		public void buttonUnpublish() {
			if(Drivers.getInstance().getBrowser().equals("ie"))
				focus(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnUnpublish));
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnUnpublish));
		}
		/**
		 * Click button archive
		 */
		public void buttonArchive() {
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnArchive));
		}
		/**
		 * Click button trash
		 */
		public void buttonTrash() {
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnTrash));
		}
		/**
		 * Click button help
		 */
		public void buttonHelp() {
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnHelp));
		}
		/**
		 * Click button checkin
		 */
		public void buttonCheckIn() {
			click(readElement(Elements.BannersPage.toolBar,Elements.BannersPage.btnCheckIn));
		}
		/**
		 * Click button search
		 */
		public void buttonSearch() {
			if(Drivers.getInstance().getBrowser().equals("ie"))
				focus(readElement(Elements.BannersPage.btnSearch));
			click(readElement(Elements.BannersPage.btnSearch));
		}
		/**
		 * Click button clear input search
		 */
		public void buttonClear() {
			click(readElement(Elements.BannersPage.btnClear));
		}
		/**
		 * Click checkbox with title in table
		 * @param title
		 * @return
		 */
		public void checkBoxTitle(String title) {
//			while(true) {
//				if(check.bannerWithTitle(title)) {
//					clickTo.checkBoxBannerInTable(title);
//					return true;
//				}
//				if(check.buttonNextEnable()) clickTo.buttonNext();
//				else return false;
//			}
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			clickTo.checkBoxBannerInTable(title);
		}
		/**
		 * Click checkbox with title in table
		 * @param title
		 */
		public void checkBoxBannerInTable(String title) {
			click(readElement(Elements.BannersPage.cbBannerInTable,title));
		}
		/**
		 * Click button next page
		 */
		public void buttonNext() {
			click(readElement(Elements.BannersPage.btnNext));
		}
		/**
		 * Click button search tool
		 */
		public void buttonSearchTools() {
			//isElementDisplay(readElement(Elements.BannersPage.btnSearchTools));
			//focus(readElement(Elements.BannersPage.btnSearchTools));
			click(readElement(Elements.BannersPage.btnSearchTools));
		}
		/**
		 * Click button to display drop status
		 */
		public void buttonStatus() {
	;
			isElementDisplay(readElement(Elements.BannersPage.btnStatus));
			focus(readElement(Elements.BannersPage.btnStatus));
			click(readElement(Elements.BannersPage.btnStatus));
		}
		/**
		 * Click item in dropdow status
		 * @param item
		 */
		public void listBoxStatus(String item) {
			if(Drivers.getInstance().getBrowser().equals("ie")) 
				focus(readElement(Elements.BannersPage.lbStatus,item));
			click(readElement(Elements.BannersPage.lbStatus,item));
		}
		/**
		 * Click button to display dropdown category
		 */
		public void buttonCategory() {
			click(readElement(Elements.BannersPage.btnCategory));
		}
		/**
		 * Click item in dropdown categoy
		 * @param item
		 */
		public void listBoxCategory(String item) {
			click(readElement(Elements.BannersPage.lbCategory,item));
		}
		/**
		 * Click button to display dropdown category
		 */
		public void buttonClient() {
			click(readElement(Elements.BannersPage.btnClient));
		}
		/**
		 * Click item in dropdown categoy
		 * @param item
		 */
		public void listBoxClient(String item) {
			click(readElement(Elements.BannersPage.lbClient,item));
		}
		/**
		 * Click button to display dropdown list limit
		 */
		public void buttonListLimit() {
			click(readElement(Elements.BannersPage.btnListLimit));
		}
		/**
		 * Click to link ID in header of table
		 */
		public void linkIDColumn() {
			if(Drivers.getInstance().getBrowser().equals("ie")) scrollToTop();
			isElementDisplay(readElement(Elements.BannersPage.linkIDColumn));
			click(readElement(Elements.BannersPage.linkIDColumn));
		}
		/**
		 * Click link client
		 */
		public void linkClient() {
			click(readElement(Elements.BannersPage.menuTopLeft,Elements.BannersPage.linkClient));
		}
		
	}
	public class Enter{	
		/**
		 * Type content to textbox search
		 * @param content
		 */
		public void textBoxSearch(String content) {
			type(readElement(Elements.BannersPage.tbSearch), content);
		}
		/**
		 * Enter client
		 * @param name
		 */
		public void tbClient(String name) {
			if(Drivers.getInstance().getBrowser().equals("ie")) 
				focus(readElement(Elements.BannersPage.tbClient));
			type(readElement(Elements.BannersPage.tbClient), name);
		}
		/**
		 * Enter client
		 * @param key
		 */
		public void tbClient(Keys name) {
			type(readElement(Elements.BannersPage.tbClient), name);
		}
		/**
		 * Enter client
		 * @param name
		 */
		public void tbCategory(String name) {
			if(Drivers.getInstance().getBrowser().equals("ie")) 
				focus(readElement(Elements.BannersPage.tbCategory));
			type(readElement(Elements.BannersPage.tbCategory), name);
		}
		/**
		 * Enter client
		 * @param key
		 */
		public void tbCategory(Keys name) {
			type(readElement(Elements.BannersPage.tbCategory), name);
		}
		/**
		 * Type content to textbox list limit
		 */
		public void listLimit(String content) {
			type(readElement(Elements.BannersPage.inputListLimit), content);
		}
		/**
		 * Type key to textbox list limit
		 * @param content
		 */
		public void listLimit(Keys content) {
			type(readElement(Elements.BannersPage.inputListLimit), content);
		}
	}
	
	public class Check{
		/**
		 * Check message article saved
		 * @return
		 */
		public boolean messageBanner(String content) {
			return read(readElement(Elements.BannersPage.messageBanner)).equals(content);
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultSearch(String title,String category,String client) {
			clickTo.buttonClear();
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.BannersPage.resultSearch));
			result=result&&categoryBannerWithTitle(title,category);
			result=result&&clientBannerWithTitle(title,client);
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultSearch(String title,String category,String client,String status) {
			clickTo.buttonClear();
			selectItemStatus(status);
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.BannersPage.resultSearch));
			result=result&&categoryBannerWithTitle(title,category);
			result=result&&clientBannerWithTitle(title,client);
			result=result&&statusBannerWithTitle(title,status);
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultAfterSearch(String title,String category,String client) {
			boolean result= isElementDisplay(readElement(Elements.BannersPage.resultSearch));
			result=result&&categoryBannerWithTitle(title,category);
			result=result&&clientBannerWithTitle(title,client);
			return result;
		}
		/**
		 * Two banner not replace
		 * @param title1
		 * @param title2
		 * @param category
		 * @param client
		 * @return
		 */
		public boolean notReplaceTwoBanner(String title1,String title2,String category,String client) {
			BannersNewPage.getInstance().clickTo.buttonCancel();
			boolean result=BannersPage.getInstance().check.resultSearch(Contant.TCBANNER013.bannerName,Contant.TCBANNER013.categoryName,Contant.TCBANNER013.clientsName);
			result=result&&BannersPage.getInstance().check.resultSearch(Contant.TCBANNER013.bannerName2,Contant.TCBANNER013.categoryName,Contant.TCBANNER013.clientsName);
			return result;
		}
		/**
		 * Check name right in title
		 * @param row
		 * @param access
		 * @return
		 */
		public boolean bannerWithTitle(String title) {
			return isElementDisplay(readElement(Elements.BannersPage.nameInTable,title));
		}
		/**
		 * Check category right in title
		 * @param row
		 * @param access
		 * @return
		 */
		public boolean categoryBannerWithTitle(String title,String category) {
			return read(readElement(Elements.BannersPage.categoryInTable,title)).contains(category);
		}
		/**
		 * Check status right in title
		 * @param title
		 * @param status
		 * @return
		 */
		public boolean statusBannerWithTitle(String title,String status) {
			if(status.equals("Archived")) status="archive";
			else status=status.substring(0,status.length()-2).toLowerCase();
			return isElementDisplay(readElement(Elements.BannersPage.icStatusInTable,title,status));
		}
		/**
		 * Check client right in title
		 * @param row
		 * @param access
		 * @return
		 */
		public boolean clientBannerWithTitle(String title,String client) {
			return read(readElement(Elements.BannersPage.clientInTable,title)).contains(client);
		}
		/**
		 * Check icon unpublic article with title article in table
		 * @param title
		 * @return
		 */
		public boolean iconUnpublicArticleInTable(String title) {
			boolean result= isElementDisplay(readElement(Elements.BannersPage.icUnpublishArticleInTable,title));
			return result;
		}
		/**
		 * Check button next page enable
		 * @return
		 */
		public boolean buttonNextEnable() {
			return isElementDisplay(readElement(Elements.BannersPage.btnNext));
		}
		/**
		 * Swith to help page
		 */
		public void switchHelpPage() {
			Switch swith=new Switch();
			swith.popUp();
		}
		/**
		 * Check help page display
		 * @return
		 */
		public boolean titleHelpPage() {
			swithTo.popUp();
			if(Drivers.getInstance().getBrowser().equals("ie")) {
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
		/**
		 * check button category
		 */
		public boolean buttonCategory() {
			return isElementDisplay(readElement(Elements.BannersPage.btnCategory));
		}
		/**
		 * check button client
		 */
		public boolean buttonClient() {
			return isElementDisplay(readElement(Elements.BannersPage.btnClient));
		}
		/**
		 * Check in icon lock behind banner 
		 * @param title
		 * @return
		 */
		public boolean icLockHasInBanner(String title,String category,String client) {
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.BannersPage.resultSearch));
			result=result&&categoryBannerWithTitle(title,category);
			result=result&&clientBannerWithTitle(title,client);
			result=result&&isElementDisplay(readElement(Elements.BannersPage.iconLockBanner,title));
			clickTo.buttonClear();
			return result;
		}
		public boolean bannerNotCreate(String category,String client) {
			BannersNewPage.getInstance().clickTo.buttonCancel();
			BannersPage.getInstance().selectItemClient(client);
			BannersPage.getInstance().selectItemCategory(category);
			boolean result= isElementDisplay(readElement(Elements.BannersPage.resultSearch));
			return !result;
			
		}
		public boolean numRowInTable(String row) {
			boolean result=true;
			if(Drivers.getInstance().getBrowser().equals("ie")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Drivers.getInstance().waitTo.pageLoad();
			}
			if(row.equals("All")) return !buttonNextEnable();
			while(true) {
				if(check.buttonNextEnable()) {
					result=result&&((count(readElement(Elements.BannersPage.rowInTable)))==Integer.parseInt(row));
					if(!result) break;
					clickTo.buttonNext();
				}
				else {
					result=result&&((count(readElement(Elements.BannersPage.rowInTable)))<=Integer.parseInt(row));
					break;
				}
			}
			return result;
		}
		/**
		 * Check button list limit enable
		 * @return
		 */
		public boolean buttonListLimit() {
			focus(readElement(Elements.BannersPage.btnListLimit));
			return isElementDisplay(readElement(Elements.BannersPage.btnListLimit));
		}
		/**
		 * Check id sort right in 2 row
		 * @param row1
		 * @param row2
		 * @param ascending
		 * @return
		 */
		public boolean idInRowSort(int row1,int row2,boolean ascending) {
			int numRow1= Integer.parseInt(read(readElement(Elements.BannersPage.idInTable,row1+"")).trim());
			int numRow2= Integer.parseInt(read(readElement(Elements.BannersPage.idInTable,row2+"")).trim());
			if(ascending) return numRow1<=numRow2;
			else return numRow1>=numRow2;
		}
		/**
		 * Check banner sort right
		 * @param ascending
		 * @return
		 */
		public boolean bannersSort(boolean ascending) {
			int numRowPrev=-1;
			int numRow=-1;
			if(ascending) selectItemListLimit("All");
			if(Drivers.getInstance().getBrowser().equals("ie")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Drivers.getInstance().waitTo.pageLoad();
			}
			boolean result=true;
			int totalNumRow=count(readElement(Elements.BannersPage.rowInTable));
			if(totalNumRow<=1) return result;
			numRow= Integer.parseInt(read(readElement(Elements.BannersPage.idInTable,1+"")).trim());
			for(int row=1;row<totalNumRow;row++) {
				numRowPrev=numRow;
				numRow= Integer.parseInt(read(readElement(Elements.BannersPage.idInTable,(row+1)+"")).trim());
				result=result&&((!ascending)^(numRow>numRowPrev));
				if(!result) break;
			}
			return result;
			
		}
	}
	/**
	 * Select item status
	 * @param item
	 */
	public void selectItemStatus(String item) {
		clickTo.buttonSearchTools();
		if(item.equals("Trashed")) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Drivers.getInstance().waitTo.pageLoad();
		}
		clickTo.buttonStatus();
		clickTo.listBoxStatus(item);
	}
	/**
	 * Select item category
	 * @param item
	 */
	public void selectItemCategory(String item) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Drivers.getInstance().waitTo.pageLoad();
		check.buttonCategory();
		focus(readElement(Elements.BannersPage.btnCategory));
		clickTo.buttonCategory();
		//clickTo.listBoxCategory(item);
		enterTo.tbCategory(item);
		enterTo.tbCategory(Keys.ENTER);
	}
	/**
	 * Select item client
	 * @param item
	 */
	public void selectItemClient(String item) {
		clickTo.buttonSearchTools();
		check.buttonClient();
		focus(readElement(Elements.BannersPage.btnClient));
		clickTo.buttonClient();
		//clickTo.listBoxClient(item);
		enterTo.tbClient(item);
		enterTo.tbClient(Keys.ENTER);
	}
	/**
	 * Select item list limit
	 * @param item
	 */
	public void selectItemListLimit(String item) {
		check.buttonListLimit();
		focus(readElement(Elements.BannersPage.btnListLimit));
		clickTo.buttonListLimit();
		enterTo.listLimit(item);
		enterTo.listLimit(Keys.ENTER);
		
	}
}
	
