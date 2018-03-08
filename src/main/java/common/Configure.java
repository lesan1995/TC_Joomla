package common;

import java.util.logging.Logger;
import org.testng.Assert;
/**
 * Read file config for test
 * 
 * @author InternDN18.01.02
 *
 */
public class Configure {
	public String browser;
	public int timeOutElement,timeOutPageLoad;
	public static String url;
	public static Logger Log= Logger.getLogger("");
	/**
	 * Init configure
	 */
	public void init(String browser,String url, String timeOutElement, String timeOutPageLoad) {
		int element,pageLoad;
		try {
			element = Integer.valueOf(timeOutElement);
			pageLoad = Integer.parseInt(timeOutPageLoad);
		}
		catch (Exception e) {
			element = 30;
			pageLoad = 30;
		}
		Configure.url=url;
		this.browser=browser;
		this.timeOutElement=element;this.timeOutPageLoad=pageLoad;
		Drivers.getInstance().setUp(browser,element,pageLoad);
	}
	/**
	 * Init configure default
	 */
	public void init() {
		Drivers.getInstance().setUp(this.browser,this.timeOutElement,this.timeOutPageLoad);
	}
	/**
	 * Navigate to url
	 */
	public void navigateToUrl(String url) {
		Drivers.getInstance().waitTo.pageLoad();
		Drivers.getInstance().getDriver().get(url);
	}
	/**
	 * Navigate to url default
	 */
	public void navigateToUrl() {
		Drivers.getInstance().waitTo.pageLoad();
		Drivers.getInstance().getDriver().get(Configure.url);
	}
	/**
	 * Close Browser
	 */
	public void closeBrowser() {
		Drivers.getInstance().quit();
	}
	/**
	 * Verify condition true with assert TestNG
	 * @param condition
	 * @return
	 */
	public boolean verifyTrue(Boolean condition) {
		try {
			Assert.assertTrue(condition);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	/**
	 * Verify condition false with assert TestNG
	 * @param condition
	 * @return
	 */
	public boolean verifyFalse(Boolean condition) {
		try {
			Assert.assertFalse(condition);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}
