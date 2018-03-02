package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drivers {
	public String browser;
	public WebDriver driver;
	public WebDriverWait wait;
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
		this.browser=browser;
		switch (browser) {
		case "ie":
			System.setProperty("webdriver.ie.driver","./drive/IEDriverServer.exe");
			DesiredCapabilities capss = new DesiredCapabilities();
			capss.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false); // to disable marionette, by default true
			capss.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
			driver = new InternetExplorerDriver(capss);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","./drive/geckodriver.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("marionette", false); // to disable marionette, by default true
			driver = new FirefoxDriver(caps); // to disable marionette, by default truebreak;
			break;
		default:
			System.setProperty("webdriver.chrome.driver","./drive/chromedriver.exe");
			driver = new ChromeDriver();
			this.browser="chrome";
			break;
			
		}
		
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();;

	}
	public class wait{
		/**
		 * Wait pageload with timeout default
		 */
		public void pageLoad() {
			driver.manage().timeouts().pageLoadTimeout(timeOutPageLoad, TimeUnit.SECONDS);
		}

		/**
		 * Wait pageload with param timeout
		 * 
		 * @param timeOut
		 */
		public void pageLoad(int timeOut) {
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		}

		/**
		 * Wait element display with timeout default
		 */
		public void elementDisplay() {
			driver.manage().timeouts().implicitlyWait(timeOutElement, TimeUnit.SECONDS);
		}

		/**
		 * Wait element display with param timeout
		 * 
		 * @param timeOut
		 */
		public void elementDisplay(int timeOut) {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		}

//		/**
//		 * Wait with condition and timeout
//		 * 
//		 * @param timeOut
//		 * @param condition
//		 */
//		@SuppressWarnings("unchecked")
//		public void condition(int timeOut, Object condition) {
//			wait.withTimeout(timeOut, TimeUnit.SECONDS);
//			wait.until((Function<? super WebDriver,ExpectedConditions>)condition);
//		}
	}
	/**
	 * Quit driver
	 */
	public void quit() {
		driver.close();
		driver.quit();
	}
}
