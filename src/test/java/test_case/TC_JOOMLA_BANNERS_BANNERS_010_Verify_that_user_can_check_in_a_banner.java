package test_case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Configure;
import common.Contant;
import page_action.BannersCategoriesNewPage;
import page_action.BannersCategoriesPage;
import page_action.BannersClientsNewPage;
import page_action.BannersClientsPage;
import page_action.BannersNewPage;
import page_action.BannersPage;
import page_action.HomePage;
import page_action.LoginPage;

public class TC_JOOMLA_BANNERS_BANNERS_010_Verify_that_user_can_check_in_a_banner extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER010.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER010.passWord);
		
		Log.info("Step 3. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 4. Select Components -> Banners -> Clients");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER010.clientsPage);
		
		Log.info("Step 5. Click \"New\" button in the right top corner");
		BannersClientsPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 6. Enter valid Client Name to Client Name textbox");
		BannersClientsNewPage.getInstance().enterTo.name(Contant.TCBANNER010.clientsName);
		
		Log.info("Step 7. Enter valid Contact Name to Contact Name textbox");
		BannersClientsNewPage.getInstance().enterTo.contactName(Contant.TCBANNER010.contactName);
		
		Log.info("Step 8. Enter valid Contact Email to Contact Email textbox");
		BannersClientsNewPage.getInstance().enterTo.contactEmail(Contant.TCBANNER010.contactEmail);
		
		Log.info("Step 9. Click \"Save & Close\" button");
		BannersClientsNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Client successfully saved\" shows and new client is created");
		verifyTrue(BannersClientsPage.getInstance().check.messageClient(Contant.TCBANNER010.messageClientSaved));
		verifyTrue(BannersClientsPage.getInstance().check.resultSearch(Contant.TCBANNER010.clientsName));
		
		Log.info("Step 11. Select Components -> Banners -> Categories");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER010.categoriesPage);
		
		Log.info("Step 12. Click \"New\" button in the right top corner");
		BannersCategoriesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 13. Enter valid Category Name to Name textbox");
		BannersCategoriesNewPage.getInstance().enterTo.nameCategory(Contant.TCBANNER010.categoryName);
		
		Log.info("Step 14. Click \"Save & Close\" button");
		BannersCategoriesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Category successfully saved\" shows and new category is created");
		verifyTrue(BannersCategoriesPage.getInstance().check.messageCategory(Contant.TCBANNER010.messageCategorySaved));
		verifyTrue(BannersCategoriesPage.getInstance().check.resultSearch(Contant.TCBANNER010.categoryName));
		
		Log.info("Step 16. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER010.bannersPage);
		
		Log.info("Step 17. Click \"New\" button in the right top corner");
		BannersPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 18. Enter valid Name to Name textbox");
		BannersNewPage.getInstance().enterTo.name(Contant.TCBANNER010.bannerName);
		
		Log.info("Step 19. Select a Category in Category dropdown list");
		BannersNewPage.getInstance().selectItemCategory(Contant.TCBANNER010.categoryName);
		
		Log.info("Step 20. Select a Client in Client dropdown list");
		BannersNewPage.getInstance().selectItemClient(Contant.TCBANNER010.clientsName);
		
		Log.info("Step 21. Click \"Save\" button");
		BannersNewPage.getInstance().clickTo.buttonSave();
		
		Log.info("Verify point. A message : \"Banner successfully saved\" shows and new banner is created");
		verifyTrue(BannersNewPage.getInstance().check.messageBanner(Contant.TCBANNER010.messageBannerSaved));
		
		Log.info("Step 23. Close browser");
		closeBrowser();
		
		Log.info("Step 24. Navigate Joomla login page");
		init();
		navigateToUrl();
		
		Log.info("Step 25. Login with User Name : \"lctp\" and password : \"lctp\"");
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER010.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER010.passWord);
		
		Log.info("Step 26. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 27. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER010.bannersPage);
		
		Log.info("Step 28. Recently created banner displays and locked");
		verifyTrue((BannersPage.getInstance().check.icLockHasInBanner(Contant.TCBANNER010.bannerName,Contant.TCBANNER010.categoryName,Contant.TCBANNER010.clientsName)));
		
		Log.info("Step 29. Check recently created banner");
		BannersPage.getInstance().clickTo.checkBoxTitle(Contant.TCBANNER010.bannerName);
		
		Log.info("Step 30. Click \"Check In\" button");
		BannersPage.getInstance().clickTo.buttonCheckIn();
		
		Log.info("Verify point. A message \"1 banner successfully checked in\" appears and banner is changed to unlock");
		verifyTrue(BannersPage.getInstance().check.messageBanner(Contant.TCBANNER010.messageBannerCheckIn));
		verifyFalse((BannersPage.getInstance().check.icLockHasInBanner(Contant.TCBANNER010.bannerName,Contant.TCBANNER010.categoryName,Contant.TCBANNER010.clientsName)));
		
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
