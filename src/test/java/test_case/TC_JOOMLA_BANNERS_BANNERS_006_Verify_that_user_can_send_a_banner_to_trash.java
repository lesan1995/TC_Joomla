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

public class TC_JOOMLA_BANNERS_BANNERS_006_Verify_that_user_can_send_a_banner_to_trash extends Configure{
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
		LoginPage.getInstance().enterTo.userName(Contant.TCBANNER006.userName);
		LoginPage.getInstance().enterTo.password(Contant.TCBANNER006.passWord);
		
		Log.info("Step 3. Click \"Login in\" button");
		LoginPage.getInstance().clickTo.buttonLogin();
		
		Log.info("Step 4. Select Components -> Banners -> Clients");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER006.clientsPage);
		
		Log.info("Step 5. Click \"New\" button in the right top corner");
		BannersClientsPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 6. Enter valid Client Name to Client Name textbox");
		BannersClientsNewPage.getInstance().enterTo.name(Contant.TCBANNER006.clientsName);
		
		Log.info("Step 7. Enter valid Contact Name to Contact Name textbox");
		BannersClientsNewPage.getInstance().enterTo.contactName(Contant.TCBANNER006.contactName);
		
		Log.info("Step 8. Enter valid Contact Email to Contact Email textbox");
		BannersClientsNewPage.getInstance().enterTo.contactEmail(Contant.TCBANNER006.contactEmail);
		
		Log.info("Step 9. Click \"Save & Close\" button");
		BannersClientsNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Client successfully saved\" shows and new client is created");
		verifyTrue(BannersClientsPage.getInstance().check.messageClient(Contant.TCBANNER006.messageClientSaved));
		verifyTrue(BannersClientsPage.getInstance().check.resultSearch(Contant.TCBANNER006.clientsName));
		
		Log.info("Step 11. Select Components -> Banners -> Categories");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER006.categoriesPage);
		
		Log.info("Step 12. Click \"New\" button in the right top corner");
		BannersCategoriesPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 13. Enter valid Category Name to Name textbox");
		BannersCategoriesNewPage.getInstance().enterTo.nameCategory(Contant.TCBANNER006.categoryName);
		
		Log.info("Step 14. Click \"Save & Close\" button");
		BannersCategoriesNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Category successfully saved\" shows and new category is created");
		verifyTrue(BannersCategoriesPage.getInstance().check.messageCategory(Contant.TCBANNER006.messageCategorySaved));
		verifyTrue(BannersCategoriesPage.getInstance().check.resultSearch(Contant.TCBANNER006.categoryName));
		
		Log.info("Step 16. Select Components -> Banners -> Banners");
		HomePage.getInstance().navigateTo.menuTop(Contant.TCBANNER006.bannersPage);
		
		Log.info("Step 17. Click \"New\" button in the right top corner");
		BannersPage.getInstance().clickTo.buttonNew();
		
		Log.info("Step 18. Enter valid Name to Name textbox");
		BannersNewPage.getInstance().enterTo.name(Contant.TCBANNER006.bannerName);
		
		Log.info("Step 19. Select a Category in Category dropdown list");
		BannersNewPage.getInstance().selectItemCategory(Contant.TCBANNER006.categoryName);
		
		Log.info("Step 20. Select a Client in Client dropdown list");
		BannersNewPage.getInstance().selectItemClient(Contant.TCBANNER006.clientsName);
		
		Log.info("Step 21. Click \"Save & Close\" button");
		BannersNewPage.getInstance().clickTo.buttonSaveAndClose();
		
		Log.info("Verify point. A message : \"Banner successfully saved\" shows and new banner is created");
		verifyTrue(BannersPage.getInstance().check.messageBanner(Contant.TCBANNER006.messageBannerSaved));
		verifyTrue(BannersPage.getInstance().check.resultSearch(Contant.TCBANNER006.bannerName,Contant.TCBANNER006.categoryName,Contant.TCBANNER006.clientsName));
	
		Log.info("Step 23. Check the banner recently created");
		BannersPage.getInstance().clickTo.checkBoxTitle(Contant.TCBANNER006.bannerName);
		
		Log.info("Step 24. Click \"Trash\" button in the right top corner");
		BannersPage.getInstance().clickTo.buttonTrash();
		
		Log.info("Verify point. A message : \"1 banner successfully sent to trash\" shows");
		verifyTrue(BannersPage.getInstance().check.messageBanner(Contant.TCBANNER006.messageBannerTrashed));
		
		Log.info("Step 26. Select \"Trashed\" in Status dropdown list");
		BannersPage.getInstance().selectItemStatus(Contant.TCBANNER006.status);
		
		Log.info("Step 27. Banner is sent to trash");
		verifyTrue(BannersPage.getInstance().check.resultAfterSearch(Contant.TCBANNER006.bannerName,Contant.TCBANNER006.categoryName,Contant.TCBANNER006.clientsName));
	}
	@AfterMethod
	public void afterMethod() {
//		Log.info("Clean. Logout");
//		HomePage.getInstance().logOut();
		Log.info("Clean. Close browser");
		closeBrowser();
	}
}
