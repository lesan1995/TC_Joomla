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

public class TC_JOOMLA_BANNERS_BANNERS_009_User_can_search_a_banner_by_using_filter_dropdown_lists extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER009.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER009.passWord);
		
		Log.info("Step 3. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 4. Select Components -> Banners -> Clients");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER009.clientsPage);
		
		Log.info("Step 5. Click \"New\" button in the right top corner");
		BannersClientsPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 6. Enter valid Client Name to Client Name textbox");
		BannersClientsNewPage.getInstance().enterTo.name(Contant.TCBANNER009.clientsName);
		
		Log.info("Step 7. Enter valid Contact Name to Contact Name textbox");
		BannersClientsNewPage.getInstance().enterTo.contactName(Contant.TCBANNER009.contactName);
		
		Log.info("Step 8. Enter valid Contact Email to Contact Email textbox");
		BannersClientsNewPage.getInstance().enterTo.contactEmail(Contant.TCBANNER009.contactEmail);
		
		Log.info("Step 9. Click \"Save & Close\" button");
		BannersClientsNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Client successfully saved\" shows and new client is created");
		verifyTrue(BannersClientsPage.getInstance().check.messageClient(Contant.TCBANNER009.messageClientSaved));
		verifyTrue(BannersClientsPage.getInstance().check.resultSearch(Contant.TCBANNER009.clientsName));
		
		Log.info("Step 11. Select Components -> Banners -> Categories");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER009.categoriesPage);
		
		Log.info("Step 12. Click \"New\" button in the right top corner");
		BannersCategoriesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 13. Enter valid Category Name to Name textbox");
		BannersCategoriesNewPage.getInstance().enterTo.nameCategory(Contant.TCBANNER009.categoryName);
		
		Log.info("Step 14. Click \"Save & Close\" button");
		BannersCategoriesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Category successfully saved\" shows and new category is created");
		verifyTrue(BannersCategoriesPage.getInstance().check.messageCategory(Contant.TCBANNER009.messageCategorySaved));
		verifyTrue(BannersCategoriesPage.getInstance().check.resultSearch(Contant.TCBANNER009.categoryName));
		
		Log.info("Step 16. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER009.bannersPage);
		
		Log.info("Step 17. Click \"New\" button in the right top corner");
		BannersPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 18. Enter valid Name to Name textbox");
		BannersNewPage.getInstance().enterTo.name(Contant.TCBANNER009.bannerName);
		
		Log.info("Step 19. Select a Category in Category dropdown list");
		BannersNewPage.getInstance().selectItemCategory(Contant.TCBANNER009.categoryName);
		
		Log.info("Step 20. Select a Client in Client dropdown list");
		BannersNewPage.getInstance().selectItemClient(Contant.TCBANNER009.clientsName);
		
		Log.info("Step 21. Click \"Save & Close\" button");
		BannersNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Banner successfully saved\" shows and new banner is created");
		verifyTrue(BannersPage.getInstance().check.messageBanner(Contant.TCBANNER009.messageBannerSaved));
		verifyTrue(BannersPage.getInstance().check.resultSearch(Contant.TCBANNER009.bannerName,Contant.TCBANNER009.categoryName,Contant.TCBANNER009.clientsName));
		
		Log.info("Step 23. Select Client that banner belong to in \"Client\" dropdown list");
		BannersPage.getInstance().selectItemClient(Contant.TCBANNER009.clientsName);
		
		Log.info("Step 24. Select Category that banner belong to in \"Category\" dropdown list");
		BannersPage.getInstance().selectItemCategory(Contant.TCBANNER009.categoryName);
		
		Log.info("Verify point. Recently created banner displays");
		verifyTrue(BannersPage.getInstance().check.resultAfterSearch(Contant.TCBANNER009.bannerName,Contant.TCBANNER009.categoryName,Contant.TCBANNER009.clientsName));
	
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
