package common;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Drivers {
	public WebDriverWait wait;
	public WebDriver driver;
	public String browser;
	private static Drivers drivers=null;
	public int timeOutElement;
	public int timeOutPageLoad;
	public wait waitTo;
	private Drivers() {
	}
	public static Drivers getInstance() {
		if(drivers==null) {
			drivers=new Drivers();
			drivers.initWait();
		}
		return drivers;
	}
	public void initWait() {
		waitTo=new wait();
	}

	/**
	 * Set up test with browser, timeout
	 * @param browser
	 * @param timeOutElement
	 * @param timeOutPageLoad
	 */


	public void setUp(String browser,int timeOutElement,int timeOutPageLoad) {
		this.timeOutElement=timeOutElement;
		this.timeOutPageLoad=timeOutPageLoad;	
		switch (browser) {
		case "ie":
			String NodeIE= "http://192.168.188.150:4444/wd/hub";
	 		DesiredCapabilities capIE = new DesiredCapabilities();
	 		capIE.setBrowserName("internet explorer");
	 		capIE.setPlatform(Platform.WINDOWS);
	 		try {
	 			driver=new RemoteWebDriver(new URL(NodeIE), capIE);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		wait = new WebDriverWait(getDriver(), 30);
			break;
		case "firefox":
	 		String NodeFirefox = "http://192.168.188.150:4444/wd/hub";
	 		DesiredCapabilities capFirefox = new DesiredCapabilities();
	 		capFirefox.setBrowserName("firefox");
	 		capFirefox.setPlatform(Platform.WINDOWS);
	 		try {
	 			driver=new RemoteWebDriver(new URL(NodeFirefox), capFirefox);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		wait = new WebDriverWait(getDriver(), 30);
			break;
		default:
			String NodeChrome = "http://localhost:4444/wd/hub";
			DesiredCapabilities capChrome= new DesiredCapabilities();
			capChrome.setBrowserName("chrome");
			capChrome.setPlatform(Platform.WINDOWS);
	 		try {
	 			driver=new RemoteWebDriver(new URL(NodeChrome), capChrome);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		wait = new WebDriverWait(getDriver(), 30);
	 		browser="chrome";
			break;
			
		}
		this.browser=browser;
		getDriver().manage().window().maximize();

	}
	public class wait{
		/**
		 * Wait pageload with timeout default
		 */
		public void pageLoad() {
			getDriver().manage().timeouts().pageLoadTimeout(timeOutPageLoad, TimeUnit.SECONDS);
			ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	       getWait().until(pageLoadCondition);
	       getWait().withTimeout(timeOutPageLoad,TimeUnit.SECONDS);
	                
			
		}

		/**
		 * Wait pageload with param timeout
		 * 
		 * @param timeOut
		 */
		public void pageLoad(int timeOut) {
			getDriver().manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		}

		/**
		 * Wait element display with timeout default
		 */
		public void elementDisplay() {
			getDriver().manage().timeouts().implicitlyWait(timeOutElement, TimeUnit.SECONDS);
		}

		/**
		 * Wait element display with param timeout
		 * 
		 * @param timeOut
		 */
		public void elementDisplay(int timeOut) {
			getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		}
	}
	public WebDriver getDriver() {
	        return driver;
	 }
	public WebDriverWait getWait() {
		return wait;
	}
	public String getBrowser() {
		return this.browser;
	}
	/**
	 * Quit driver
	 */
	public void quit() {
		getDriver().quit();
	}
	
}
