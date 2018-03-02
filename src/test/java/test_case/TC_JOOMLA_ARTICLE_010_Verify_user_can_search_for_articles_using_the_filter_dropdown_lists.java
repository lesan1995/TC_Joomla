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

public class TC_JOOMLA_ARTICLE_010_Verify_user_can_search_for_articles_using_the_filter_dropdown_lists extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TC010.userName);
		
		Log.info("Step 3. Enter valid password into Password field ");
		LoginPage.getInstance().enterTo.password(Contant.TC010.passWord);

		Log.info("Step 4. Click on 'Log in' button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 5. Select Content > Article Manager");
		HomePage.getInstance().navigateTo.menuTop(Contant.TC010.articlesPage);
		
		Log.info("Step 6. Click on 'New' icon of the top right toolbar");
		ArticlesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 7. Enter a title on 'Title' field");
		ArticlesNewPage.getInstance().enterTo.title(Contant.TC010.title);
		
		Log.info("Step 8. Select an item from the 'Category' dropdown list");
		ArticlesNewPage.getInstance().selectItemCategory(Contant.TC010.category);
		
		Log.info("Step 9. Select 'Published' item from 'Status' dropdown list");
		ArticlesNewPage.getInstance().selectItemStatus(Contant.TC010.status);
		
		Log.info("Step 10. Select an item from the 'Access' dropdown list");
		ArticlesNewPage.getInstance().selectItemAccess(Contant.TC010.access);
		
		Log.info("Step 11. Enter value on 'Article Text' text area");
		ArticlesNewPage.getInstance().enterTo.content(Contant.TC010.content);
		
		Log.info("Step 12. Click on 'Save & Close' icon of the top right toolbar");
		ArticlesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		
		Log.info("Verify Point. Verify the article is saved successfully");
		verifyTrue(ArticlesPage.getInstance().check.messageArticle(Contant.TC010.messageArticleSaved));
		verifyTrue(ArticlesPage.getInstance().check.resultSearch(Contant.TC010.title));
		
		Log.info("Step 14. Select an item from the 'Status' filter dropdown list");
		ArticlesPage.getInstance().selectItemStatus(Contant.TC010.status);
		
		Log.info("Step 15. Select an item from the 'Category' filter dropdown list");
		ArticlesPage.getInstance().selectItemCategory(Contant.TC010.category);
		
		Log.info("Step 16. Select an item from the 'Access' filter dropdown list");
		ArticlesPage.getInstance().selectItemAccess(Contant.TC010.access);
		
		Log.info("Step 17. Select an item from the 'Author' filter dropdown list");
		ArticlesPage.getInstance().selectItemAuthor(Contant.TC010.author);
		
		Log.info("Step 18. Verify the property of displayed articles are matched with the selected criteria from the filter dropdown lists");
		verifyTrue(ArticlesPage.getInstance().check.articlesDisplayedMatchedFilter(Contant.TC010.status,
				Contant.TC010.category,Contant.TC010.access,Contant.TC010.author));
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
