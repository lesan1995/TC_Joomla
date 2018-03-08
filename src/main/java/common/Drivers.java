package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drivers {
	public String browser;
	public WebDriver driver;
	public WebDriverWait wait;
	private static Drivers drivers=null;
	public int timeOutElement;
	public int timeOutPageLoad;
	public wait waitTo;
	protected ThreadLocal<RemoteWebDriver> threadLocal = null;
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
		this.browser=browser;
		switch (browser) {
		case "ie":
//			System.setProperty("webdriver.ie.driver","./drive/IEDriverServer.exe");
//			DesiredCapabilities capss = new DesiredCapabilities();
//			capss.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false); // to disable marionette, by default true
//			capss.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
//			driver = new InternetExplorerDriver(capss);
			String NodeIE= "http://192.168.190.133:5555/wd/hub";
	 		DesiredCapabilities capIE = new DesiredCapabilities();
	 		try {
				driver = new RemoteWebDriver(new URL(NodeIE), capIE);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "firefox":
//			 System.setProperty("webdriver.gecko.driver","./drive/geckodriver.exe");
//			 DesiredCapabilities caps = new DesiredCapabilities();
//			 caps.setCapability("marionette", false); // to disable marionette, by default true
//			 driver = new FirefoxDriver(caps); // to disable marionette, by default truebreak;
	 		String Node = "http://192.168.191.228:5555/wd/hub";
	 		DesiredCapabilities caps = new DesiredCapabilities();
	 		caps.setBrowserName("firefox");
	 		caps.setCapability("marionette", false);
	 		try {
				//driver = new RemoteWebDriver(new URL(Node), caps);
	 			threadLocal = new ThreadLocal<RemoteWebDriver>();
	            threadLocal.set(new RemoteWebDriver(new URL(Node), caps));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
//			System.setProperty("webdriver.chrome.driver","./drive/chromedriver.exe");
//			driver = new ChromeDriver();
			String NodeChrome = "http://192.168.190.133:5555/wd/hub";
	 		DesiredCapabilities capChrome = new DesiredCapabilities();
	 		capChrome.setBrowserName("chrome");
	 		try {
				//driver = new RemoteWebDriver(new URL(NodeChrome), capChrome);
	 			threadLocal = new ThreadLocal<RemoteWebDriver>();
	            threadLocal.set(new RemoteWebDriver(new URL(NodeChrome), capChrome));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.browser="chrome";
			break;
			
		}
		
		wait = new WebDriverWait(getDriver(), 30);
		getDriver().manage().window().maximize();;

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
	        wait.until(pageLoadCondition);
	        wait.withTimeout(timeOutPageLoad,TimeUnit.SECONDS);
	                
			
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
	        return threadLocal.get();
	 }
	/**
	 * Quit driver
	 */
	public void quit() {
		//driver.close();
		//driver.quit();
		getDriver().quit();
	}
	
}
