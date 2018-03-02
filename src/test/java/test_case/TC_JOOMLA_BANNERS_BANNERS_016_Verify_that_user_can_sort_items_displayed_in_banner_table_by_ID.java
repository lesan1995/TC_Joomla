package test_case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Configure;
import common.Contant;
import page_action.BannersPage;
import page_action.HomePage;
import page_action.LoginPage;

public class TC_JOOMLA_BANNERS_BANNERS_016_Verify_that_user_can_sort_items_displayed_in_banner_table_by_ID extends Configure{
	@Parameters({ "browser", "url", "timeOutElement", "timeOutPage" })
	@BeforeMethod
	public void beforeMethod(String browser, String url, String timeOutElement, String timeOutPage) {
		Log.info("Init. Init to test");
		init(browser,url, timeOutElement, timeOutPage);
	}
	@Test
	public void login() {
		
		Log.info("Step 1. Navigate Joomla login page");
		navigateToUrl();
		
		Log.info("Step 2. Login with User Name and password ");
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER016.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER016.passWord);
		
		Log.info("Step 3. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 4. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER016.bannersPage);
		
		Log.info("Step 5. Click \"ID\" link in the top of table");
		BannersPage.getInstance().clickTo.linkIDColumn();
		
		Log.info("Verify point. Items are sorted ascending by ID in banner table");
		verifyTrue(BannersPage.getInstance().check.bannersSort(Contant.TCBANNER016.ascending));
		
		Log.info("Step 7. Click \"ID\" link in the top of table");
		BannersPage.getInstance().clickTo.linkIDColumn();
		
		Log.info("Verify point. Items are sorted decending by ID in banner table");
		verifyTrue(BannersPage.getInstance().check.bannersSort(Contant.TCBANNER016.descending));
		
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
