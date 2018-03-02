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

public class TC_JOOMLA_ARTICLE_016_Verify_user_can_change_the_feature_property_of_articles_using_the_Featured_column extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TC016.userName);
		
		Log.info("Step 3. Enter valid password into Password field ");
		LoginPage.getInstance().enterTo.password(Contant.TC016.passWord);

		Log.info("Step 4. Click on 'Log in' button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 5. Select Content > Article Manager");
		HomePage.getInstance().navigateTo.menuTop(Contant.TC016.articlesPage);
		
		Log.info("Step 6. Click on 'New' icon of the top right toolbar");
		ArticlesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 7. Enter a title on 'Title' field");
		ArticlesNewPage.getInstance().enterTo.title(Contant.TC016.title);
		
		Log.info("Step 8. Select an item from the 'Category' dropdown list");
		ArticlesNewPage.getInstance().selectItemCategory(Contant.TC016.category);
		
		Log.info("Step 9. Select 'Published' item from 'Status' dropdown list");
		ArticlesNewPage.getInstance().selectItemStatus(Contant.TC016.status);
		
		Log.info("Step 10. Enter value on 'Article Text' text area");
		ArticlesNewPage.getInstance().enterTo.content(Contant.TC016.content);
		
		Log.info("Step 11. Click on 'Save & Close' icon of the top right toolbar");
		ArticlesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		
		Log.info("Verify Point. Verify the article is saved successfully");
		verifyTrue(ArticlesPage.getInstance().check.messageArticle(Contant.TC016.messageArticleSaved));
		verifyTrue(ArticlesPage.getInstance().check.resultSearch(Contant.TC016.title));
		
		Log.info("Step 13. Check on the recently added article's checkbox");
		ArticlesPage.getInstance().clickTo.checkBoxTitle(Contant.TC016.title);
		
		Log.info("Step 14. Click on the status icon of the selected article in the Featured column");
		ArticlesPage.getInstance().clickTo.icStatusFeaturedInTableWithTitle(Contant.TC016.title);
		
		Log.info("Verify Point. Verify the article is featured successfully");
		verifyTrue(ArticlesPage.getInstance().check.messageArticle(Contant.TC016.messageArticleFeatured));
		verifyTrue(ArticlesPage.getInstance().check.resultSearch(Contant.TC016.title));
		
		Log.info("Step 16. Check on the recently added article's checkbox");
		ArticlesPage.getInstance().clickTo.checkBoxTitle(Contant.TC016.title);
		
		Log.info("Step 17. Click on the status icon of the selected article in the Featured column");
		ArticlesPage.getInstance().clickTo.icStatusFeaturedInTableWithTitle(Contant.TC016.title);
		
		Log.info("Verify Point. Verify the article is unfeatured successfully");
		verifyTrue(ArticlesPage.getInstance().check.iconUnfeaturedArticleInTable(Contant.TC016.title));
		
		
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
