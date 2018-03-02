package page_action;
import org.openqa.selenium.Keys;
import common.Drivers;
import interfaces.Elements;

public class ArticlesPage extends BasePage{
	private static ArticlesPage articlesPage=null;
	public Click clickTo;
	public Enter enterTo;
	public Check check;
	static boolean tempCheckOrder=true;
	private ArticlesPage() {
		readInterface();
	}
	public static ArticlesPage getInstance() {
		if(articlesPage==null) {
			articlesPage=new ArticlesPage();
			articlesPage.initAction();
		}
		return articlesPage;
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
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnNew));
		}
		/**
		 * Click button search
		 */
		public void buttonSearch() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesPage.btnSearch));
			click(readElement(Elements.ArticlesPage.btnSearch));
		}
		/**
		 * Click checkbox with title in table
		 * @param title
		 */
		public void checkBoxArticleInTable(String title) {
			click(readElement(Elements.ArticlesPage.cbArticleInTable,title));
		}
		/**
		 * Click button next page
		 */
		public void buttonNext() {
			click(readElement(Elements.ArticlesPage.btnNext));
		}
		/**
		 * Click button back ward page
		 */
		public void buttonBackWard() {
			click(readElement(Elements.ArticlesPage.btnBackWard));
		}
		/**
		 * Click button edit article
		 */
		public void buttonEdit() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnEdit));
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnEdit));
		}
		/**
		 * Click button clear input search
		 */
		public void buttonClear() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesPage.btnClear));
			click(readElement(Elements.ArticlesPage.btnClear));
		}
		/**
		 * Click button public article
		 */
		public void buttonPublic() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnPublish));
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnPublish));
		}
		/**
		 * Click button unpublic article
		 */
		public void buttonUnpublic() {
			if(Drivers.getInstance().browser.equals("ie"))
				focus(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnUnpublish));
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnUnpublish));
		}
		/**
		 * Click checkbox with title in table
		 * @param title
		 * @return
		 */
		public boolean checkBoxTitle(String title) {
			while(true) {
				if(check.articlesHasInTable(title)) {
					clickTo.checkBoxArticleInTable(title);
					return true;
				}
				if(check.buttonNextEnable()) clickTo.buttonNext();
				else return false;
			}
		}
		/**
		 * Click button archive article
		 */
		public void buttonArchived() {
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnArchive));
		}
		/**
		 * Click button trash article
		 */
		public void buttonTrash() {
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnTrash));
		}
		/**
		 * Click button help
		 */
		public void buttonHelp() {
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnHelp));
		}
		/**
		 * Click button search tool
		 */
		public void buttonSearchTools() {
			click(readElement(Elements.ArticlesPage.btnSearchTools));
		}
		/**
		 * Click button to display drop status
		 */
		public void buttonStatus() {
			click(readElement(Elements.ArticlesPage.btnStatus));
		}
		/**
		 * Click item in dropdow status
		 * @param item
		 */
		public void listBoxStatus(String item) {
			click(readElement(Elements.ArticlesPage.lbStatus,item));
		}
		/**
		 * Click button check in
		 */
		public void buttonCheckIn() {
			click(readElement(Elements.ArticlesPage.toolBar,Elements.ArticlesPage.btnCheckIn));
		}
		/**
		 * Click button to display dropdown category
		 */
		public void buttonCategory() {
			click(readElement(Elements.ArticlesPage.btnCategory));
		}
		/**
		 * Click item in dropdown categoy
		 * @param item
		 */
		public void listBoxCategory(String item) {
			click(readElement(Elements.ArticlesPage.lbCategory,item));
		}
		/**
		 * Click button to display dropdown access
		 */
		public void buttonAccess() {
			click(readElement(Elements.ArticlesPage.btnAccess));
		}
		/**
		 * Click item in dropdown access
		 * @param item
		 */
		public void listBoxAccess(String item) {
			click(readElement(Elements.ArticlesPage.lbAccess,item));
		}
		/**
		 * Click button to display dropdown author
		 */
		public void buttonAuthor() {
			click(readElement(Elements.ArticlesPage.btnAuthor));
		}
		/**
		 * Click item in dropdown author
		 * @param item
		 */
		public void listBoxAuthor(String item) {
			click(readElement(Elements.ArticlesPage.lbAuthor,item));
		}
		/**
		 * Click button to display dropdown list limit
		 */
		public void buttonListLimit() {
			click(readElement(Elements.ArticlesPage.btnListLimit));
		}

		/**
		 * Click to item in dropdown list limit
		 * @param item
		 */
		public void listBoxListLimit(String item) {
			click(readElement(Elements.ArticlesPage.lbListLimit,item));
		}
		/**
		 * Click to link ID in header of table
		 */
		public void linkIDColumn() {
			if(Drivers.getInstance().browser.equals("ie")) scrollToTop();
			isElementDisplay(readElement(Elements.ArticlesPage.linkIDColumn));
			click(readElement(Elements.ArticlesPage.linkIDColumn));
		}
		/**
		 * Click to link ordering column
		 */
		public void linkOrderingColumn() {
			click(readElement(Elements.ArticlesPage.linkOrderingColumn));
		}
		/**
		 * Check to checkbox article in table
		 * @param title1
		 * @param title2
		 */
		public void checkBoxArticleInTableSort(String title1,String title2) {
			selectItemListLimit("All");
			checkBoxArticleInTable(title2);
			int numRow1=count(readElement(Elements.ArticlesPage.rowArticleInTable,title1));
			int numRow2=count(readElement(Elements.ArticlesPage.rowArticleInTable,title2));
			tempCheckOrder=numRow1<numRow2;
		}
		/**
		 * Click icon status article with title article in table
		 * @param title
		 * 
		 */
		public void icStatusInTableWithTitle(String title) {
			click(readElement(Elements.ArticlesPage.icStatusInTableWithTitle,title));
		}
		/**
		 * Click icon status featured article with title article in table
		 * @param title
		 * 
		 */
		public void icStatusFeaturedInTableWithTitle(String title) {
			if(Drivers.getInstance().browser.equals("ie")) 
				focus(readElement(Elements.ArticlesPage.icStatusFeaturedInTableWithTitle,title));
			click(readElement(Elements.ArticlesPage.icStatusFeaturedInTableWithTitle,title));
		}
	}
	public class Enter{
		/**
		 * Type content to textbox search
		 * @param content
		 */
		public void textBoxSearch(String content) {
			type(readElement(Elements.ArticlesPage.tbSearch), content);
		}
		/**
		 * Type content to textbox list limit
		 */
		public void listLimit(String content) {
			type(readElement(Elements.ArticlesPage.inputListLimit), content);
		}
		/**
		 * Type key to textbox list limit
		 * @param content
		 */
		public void listLimit(Keys content) {
			type(readElement(Elements.ArticlesPage.inputListLimit), content);
		}
		
	}
	
	public class Check{
		/**
		 * Check message article saved
		 * @return
		 */
		public boolean messageArticle(String content) {
			return read(readElement(Elements.ArticlesPage.messageArticle)).contains(content);
		}
		/**
		 * Check result search with content
		 * @param content
		 * @return
		 */
		public boolean resultSearch(String content) {
			enterTo.textBoxSearch(content);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.ArticlesPage.resultSearch));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check article with tile has in table
		 * @param title
		 * @return
		 */
		public boolean articlesHasInTable(String title) {
			return isElementDisplay(readElement(Elements.ArticlesPage.cbArticleInTable,title));
		}
		/**
		 * Check button next page enable
		 * @return
		 */
		public boolean buttonNextEnable() {
			return isElementDisplay(readElement(Elements.ArticlesPage.btnNext));
		}
		/**
		 * Check button back ward page enable
		 * @return
		 */
		public boolean buttonBackWardEnable() {
			return isElementDisplay(readElement(Elements.ArticlesPage.btnBackWard));
		}
		/**
		 * Check icon public article with title article in table
		 * @param title
		 * @return
		 */
		public boolean iconPublicArticleInTable(String title) {
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.ArticlesPage.icPublishArticleInTable,title));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check icon unpublic article with title article in table
		 * @param title
		 * @return
		 */
		public boolean iconUnpublicArticleInTable(String title) {
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.ArticlesPage.icUnpublishArticleInTable,title));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check icon public article with title article in table
		 * @param title
		 * @return
		 */
		public boolean iconFeaturedArticleInTable(String title) {
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.ArticlesPage.icFeaturedInTableWithTitle,title));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check icon unpublic article with title article in table
		 * @param title
		 * @return
		 */
		public boolean iconUnfeaturedArticleInTable(String title) {
			enterTo.textBoxSearch(title);
			clickTo.buttonSearch();
			boolean result= isElementDisplay(readElement(Elements.ArticlesPage.icUnfeaturedInTableWithTitle,title));
			clickTo.buttonClear();
			return result;
		}
		/**
		 * Check in icon lock behind article has removed
		 * @param title
		 * @return
		 */
		public boolean icLockArticleHasRemoved(String title) {
			if(articlesHasInTable(title)) {
				if(count(readElement(Elements.ArticlesPage.tagAInTitleTable,title))>1) return false;
			}
			return true;
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
			if(Drivers.getInstance().browser.equals("ie")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Drivers.getInstance().waitTo.pageLoad();
			boolean result=Drivers.getInstance().driver.getTitle().contains("Joomla! Help Screens");
			swithTo.Default();
			return result;
		}
		/**
		 * Check status right in row
		 * @param row
		 * @param status
		 * @return
		 */
		public boolean statusInRow(int row,String status) {
			status=status.substring(0,status.length()-2).toLowerCase();
			return isElementDisplay(readElement(Elements.ArticlesPage.icStatusInTable,row+"",status));
		}
		/**
		 * Check category right in row
		 * @param row
		 * @param category
		 * @return
		 */
		public boolean categoryInRow(int row,String category) {
			return read(readElement(Elements.ArticlesPage.categoryInTable,row+"")).contains(category);
		}
		/**
		 * Check access right in rorw
		 * @param row
		 * @param access
		 * @return
		 */
		public boolean accessInRow(int row,String access) {
			return read(readElement(Elements.ArticlesPage.accessInTable,row+"")).contains(access);
		}
		/**
		 * Chcek author right in row
		 * @param row
		 * @param author
		 * @return
		 */
		public boolean authorInRow(int row,String author) {
			return read(readElement(Elements.ArticlesPage.authorInTable,row+"")).contains(author);
		}
		/**
		 * Check id sort right in 2 row
		 * @param row1
		 * @param row2
		 * @param ascending
		 * @return
		 */
		public boolean idInRowSort(int row1,int row2,boolean ascending) {
			int numRow1= Integer.parseInt(read(readElement(Elements.ArticlesPage.idInTable,row1+"")).trim());
			int numRow2= Integer.parseInt(read(readElement(Elements.ArticlesPage.idInTable,row2+"")).trim());
			if(ascending) return numRow1<=numRow2;
			else return numRow1>=numRow2;
		}
		/**
		 * Check article display right with filter
		 * @param status
		 * @param category
		 * @param access
		 * @param author
		 * @return
		 */
		public boolean articlesDisplayedMatchedFilter(String status,String category,String access,String author) {
			boolean result=true;
			int numRow=count(readElement(Elements.ArticlesPage.rowInTable));
			for(int row=0;row<numRow;row++) {
				result=result&&statusInRow(row+1, status);
				result=result&&categoryInRow(row+1, category);
				result=result&&accessInRow(row+1, access);
				result=result&&authorInRow(row+1, author);
				if(!result) break;
			}
			return result;
		}
		/**
		 * Check article sort right
		 * @param ascending
		 * @return
		 */
		public boolean articlesSort(boolean ascending) {
			int numRowPrev=-1;
			int numRow=-1;
			if(ascending) selectItemListLimit("All");
			if(Drivers.getInstance().browser.equals("ie")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Drivers.getInstance().waitTo.pageLoad();
			}
			boolean result=true;
			int totalNumRow=count(readElement(Elements.ArticlesPage.rowInTable));
			if(totalNumRow<=1) return result;
			numRow= Integer.parseInt(read(readElement(Elements.ArticlesPage.idInTable,1+"")).trim());
			for(int row=1;row<totalNumRow;row++) {
				numRowPrev=numRow;
				numRow= Integer.parseInt(read(readElement(Elements.ArticlesPage.idInTable,(row+1)+"")).trim());
				result=result&&((!ascending)^(numRow>numRowPrev));
				if(!result) break;
			}
			return result;
			
		}
		/**
		 * Check button list limit enable
		 * @return
		 */
		public boolean buttonListLimit() {
			focus(readElement(Elements.ArticlesPage.btnListLimit));
			return isElementDisplay(readElement(Elements.ArticlesPage.btnListLimit));
		}
		public boolean numRowInTable(String row) {
			boolean result=true;
			
			if(Drivers.getInstance().browser.equals("ie")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Drivers.getInstance().waitTo.pageLoad();
			}
			while(true) {
				if(check.buttonNextEnable()) {
					result=result&&((count(readElement(Elements.ArticlesPage.rowInTable)))==Integer.parseInt(row));
					if(!result) break;
					clickTo.buttonNext();
				}
				else {
					result=result&&((count(readElement(Elements.ArticlesPage.rowInTable)))<=Integer.parseInt(row));
					break;
				}
			}
			return result;
		}
		/**
		 * Check article change position 
		 * @param title1
		 * @param title2
		 * @return
		 */
		public boolean articleChangePosition(String title1,String title2) {
			selectItemListLimit("All");
			int numRow1=count(readElement(Elements.ArticlesPage.rowArticleInTable,title1));
			int numRow2=count(readElement(Elements.ArticlesPage.rowArticleInTable,title2));
			return tempCheckOrder!=(numRow1<numRow2);
		}
		/**
		 * Check access right in title
		 * @param row
		 * @param access
		 * @return
		 */
		public boolean accessInRowWithTitle(String title,String access) {
			return read(readElement(Elements.ArticlesPage.accessInTableWithTitle,title)).contains(access);
		}
	}
	/**
	 * Select item status
	 * @param item
	 */
	public void selectItemStatus(String item) {
		clickTo.buttonSearchTools();
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
	/**
	 * Select item category
	 * @param item
	 */
	public void selectItemCategory(String item) {
		clickTo.buttonCategory();
		clickTo.listBoxCategory(item);
	}
	/**
	 * Select item author
	 * @param item
	 */
	public void selectItemAuthor(String item) {
		clickTo.buttonAuthor();
		clickTo.listBoxAuthor(item);
	}
	/**
	 * Select item list limit
	 * @param item
	 */
	public void selectItemListLimit(String item) {
		check.buttonListLimit();
		focus(readElement(Elements.ArticlesPage.btnListLimit));
		clickTo.buttonListLimit();
		enterTo.listLimit(item);
		enterTo.listLimit(Keys.ENTER);
		
	}
	
	

}
