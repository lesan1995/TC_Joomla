package test_case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Configure;
import common.Contant;
import page_action.ArticlesPage;
import page_action.HomePage;
import page_action.LoginPage;

public class TC_JOOMLA_ARTICLE_012_Verify_user_can_paging_the_articles_using_the_paging_control extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TC012.userName);
		
		Log.info("Step 3. Enter valid password into Password field ");
		LoginPage.getInstance().enterTo.password(Contant.TC012.passWord);

		Log.info("Step 4. Click on 'Log in' button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 5. Select Content > Article Manager");
		HomePage.getInstance().navigateTo.menuTop(Contant.TC012.articlesPage);
		
		Log.info("Step 6. Select 5 item of the 'Display' dropdown list at the footer section of the article table");
		ArticlesPage.getInstance().selectItemListLimit("5");
		
		Log.info("Verify Point. Verify the article table is paging into 5 articles per page");
		verifyTrue(ArticlesPage.getInstance().check.numRowInTable("5"));
		
		Log.info("Step 8. Select \"All\" item of the 'Display' dropdown list at the footer section of the article table");
		ArticlesPage.getInstance().selectItemListLimit("All");
		
		Log.info("Verify Point. Verify all articles are displayed in one page");
		verifyFalse(ArticlesPage.getInstance().check.buttonNextEnable());
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
