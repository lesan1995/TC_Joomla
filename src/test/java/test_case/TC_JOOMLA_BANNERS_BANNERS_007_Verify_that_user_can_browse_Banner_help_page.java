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

public class TC_JOOMLA_BANNERS_BANNERS_007_Verify_that_user_can_browse_Banner_help_page extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER007.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER007.passWord);
		
		Log.info("Step 3. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 4. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER007.bannersPage);
		
		Log.info("Step 5. Click \"Help\" button in the right top corner");
		BannersPage.getInstance().clickTo.buttonHelp();
		
		Log.info("Verify point. \"Banner help\" page appears");
		verifyTrue(BannersPage.getInstance().check.titleHelpPage());
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
