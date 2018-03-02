package test_case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Configure;
import common.Contant;
import page_action.ArticlesNewPage;
import page_action.ArticlesPage;
import page_action.HomePage;
import page_action.LoginPage;

public class TC_JOOMLA_ARTICLE_007_Verify_user_an_move_an_article_to_trash_section extends Configure{
	@Parameters({ "browser", "url", "timeOutElement", "timeOutPage" })
	@BeforeMethod
	public void beforeMethod(String browser, String url, String timeOutElement, String timeOutPage) {
		Log.info("Init. Init to test");
		init(browser,url, timeOutElement, timeOutPage);
	}
	@Test
	public void login() {
		
		Log.info("Step 1. Navigate to login page");
		navigateToUrl();
		
		Log.info("Step 2. Enter valid username into Username field");
		LoginPage.getInstance().enterTo.userName(Contant.TC007.userName);
		
		Log.info("Step 3. Enter valid password into Password field ");
		LoginPage.getInstance().enterTo.password(Contant.TC007.passWord);

		Log.info("Step 4. Click on 'Log in' button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 5. Select Content > Article Manager");
		HomePage.getInstance().navigateTo.menuTop(Contant.TC007.articlesPage);
		
		Log.info("Step 6. Click on 'New' icon of the top right toolbar");
		ArticlesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 7. Enter a title on 'Title' field");
		ArticlesNewPage.getInstance().enterTo.title(Contant.TC007.title);
		
		Log.info("Step 8. Select an item from the 'Category' dropdown list");
		ArticlesNewPage.getInstance().selectItemCategory(Contant.TC007.category);
		
		Log.info("Step 9. Enter value on 'Article Text' text area");
		ArticlesNewPage.getInstance().enterTo.content(Contant.TC007.content);
		
		Log.info("Step 10. Click on 'Save & Close' icon of the top right toolbar");
		ArticlesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		
		Log.info("Verify Point. Verify the article is saved successfully");
		verifyTrue(ArticlesPage.getInstance().check.messageArticle(Contant.TC007.messageArticleSaved));
		verifyTrue(ArticlesPage.getInstance().check.resultSearch(Contant.TC007.title));
		
		Log.info("Step 12. Check on the recently added article's checkbox");
		ArticlesPage.getInstance().clickTo.checkBoxTitle(Contant.TC007.title);
		
		Log.info("Step 13. Click on 'Trash' icon of the top right toolbar");
		ArticlesPage.getInstance().clickTo.buttonTrash();
		
		Log.info("Step 14. Verify the confirm message is displayed");
		verifyTrue(ArticlesPage.getInstance().check.messageArticle(Contant.TC007.messageArticleTrash));
		
		Log.info("Step 15. Select 'Trashed' item of 'Status' dropdown list");
		ArticlesPage.getInstance().selectItemStatus(Contant.TC007.status);
		
		Log.info("Step 16. Verify the trashed article is displayed on the table grid");
		verifyTrue(ArticlesPage.getInstance().check.resultSearch(Contant.TC007.title));
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
