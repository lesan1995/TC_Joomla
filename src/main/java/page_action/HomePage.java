package page_action;
import common.Drivers;
import interfaces.Elements;

public class HomePage extends BasePage {
	private static HomePage homePage=null;
	public Navigate navigateTo;
	public Check check;
	private HomePage() {
		readInterface();
	}
	public static HomePage getInstance() {
		if(homePage==null) {
			homePage=new HomePage();
			homePage.initAction();
			
		}
		return homePage;
	}
	/**
	 * Init action navigate, check
	 */
	public void initAction() {
		navigateTo=new Navigate();
		check=new Check();
	}
	
	public class Navigate{
		/*
		 * Navigate to menu top
		 */
		public void menuTop(String menu) {
			if(menu.split(">").length==2) {
				String lv1=menu.split(">")[0];
				String lv2=menu.split(">")[1];
				click(readElement(Elements.HomePage.menuTopLeftLV1, lv1));
				click(readElement(Elements.HomePage.menuTopLeftLV2, lv2));
			}
			else if(menu.split(">").length==3) {
				String lv1=menu.split(">")[0];
				String lv2=menu.split(">")[1];
				String lv3=menu.split(">")[2];
				if(Drivers.getInstance().browser.equals("ie")) {
					focus(readElement(Elements.HomePage.menuTopLeftLV1, lv1));
					click(readElement(Elements.HomePage.menuTopLeftLV1, lv1));
					focus(readElement(Elements.HomePage.menuTopLeftLV2, lv2));
					String link=Drivers.getInstance().getDriver().
							findElement(readElement(Elements.HomePage.menuTopLeftLV3Link, lv1,lv2,lv3))
							.getAttribute("href");
					Drivers.getInstance().waitTo.pageLoad();
					Drivers.getInstance().getDriver().get(link);
				}
				else {
					click(readElement(Elements.HomePage.menuTopLeftLV1, lv1));
					focus(readElement(Elements.HomePage.menuTopLeftLV2, lv2));
					click(readElement(Elements.HomePage.menuTopLeftLV3,lv3));
					
					
				}
				
				
			}
			
		}
	}
	public class Check{
		/**
		 * Check user logged
		 * @author InternDN18.01.02
		 *
		 */
		public boolean userLogged() {
			return isElementDisplay(readElement(Elements.HomePage.userLogged));
		}
	}
	/**
	 * Logout website
	 */
	public void logOut() {
		if(check.userLogged()) {
			click(readElement(Elements.HomePage.menuUserLV1));
			click(readElement(Elements.HomePage.menuUserLV2,Elements.HomePage.menuLogout));
		}
	}

}
