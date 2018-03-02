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

public class TC_JOOMLA_ARTICLE_011_Verify_user_can_sort_the_article_table_by_ID_column extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TC011.userName);
		
		Log.info("Step 3. Enter valid password into Password field ");
		LoginPage.getInstance().enterTo.password(Contant.TC011.passWord);

		Log.info("Step 4. Click on 'Log in' button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 5. Select Content > Article Manager");
		HomePage.getInstance().navigateTo.menuTop(Contant.TC011.articlesPage);
		
		Log.info("Step 6. Click on the Header link of ID column");
		ArticlesPage.getInstance().clickTo.linkIDColumn();
		
		Log.info("Verify Point. Verify the articles is sorted by ID in ascending order");
		verifyTrue(ArticlesPage.getInstance().check.articlesSort(Contant.TC011.ascending));
		
		Log.info("Step 8. Click on the Header link of ID column");
		ArticlesPage.getInstance().clickTo.linkIDColumn();
		
		Log.info("Verify Point. Verify the articles is sorted by ID in descending order");
		verifyTrue(ArticlesPage.getInstance().check.articlesSort(Contant.TC011.descending));
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
