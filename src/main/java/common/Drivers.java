package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drivers {
	public WebDriverWait waitChrome;
	public WebDriverWait waitFirefox;
	public WebDriverWait waitIE;
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
		switch (browser) {
		case "ie":
			String NodeIE= "http://192.168.190.133:5555/wd/hub";
	 		DesiredCapabilities capIE = new DesiredCapabilities();
	 		capIE.setBrowserName("internet explorer");
	 		try {
	 			threadLocal = new ThreadLocal<RemoteWebDriver>();
	            threadLocal.set(new RemoteWebDriver(new URL(NodeIE), capIE));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		waitIE = new WebDriverWait(getDriver(), 30);
			break;
		case "firefox":
	 		//String NodeFirefox = "http://192.168.191.228:5555/wd/hub";
	 		String NodeFirefox = "http://192.168.190.133:5555/wd/hub";
	 		DesiredCapabilities capFirefox = new DesiredCapabilities();
	 		capFirefox.setBrowserName("firefox");
	 		capFirefox.setCapability("marionette", false);
	 		try {
	 			threadLocal = new ThreadLocal<RemoteWebDriver>();
	            threadLocal.set(new RemoteWebDriver(new URL(NodeFirefox), capFirefox));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		waitFirefox = new WebDriverWait(getDriver(), 30);
			break;
		default:
			String NodeChrome = "http://192.168.190.133:5555/wd/hub";
	 		DesiredCapabilities capChrome = new DesiredCapabilities();
	 		capChrome.setBrowserName("chrome");
	 		try {
	 			threadLocal = new ThreadLocal<RemoteWebDriver>();
	            threadLocal.set(new RemoteWebDriver(new URL(NodeChrome), capChrome));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 		waitChrome = new WebDriverWait(getDriver(), 30);
			break;
			
		}
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
	        return threadLocal.get();
	 }
	public WebDriverWait getWait() {
		switch(getBrowser()) {
			case "ie": return waitIE;
			case "firefox": return waitFirefox;
			default : return waitChrome;
		}
 }
	public String getBrowser() {
		if(threadLocal.get().getCapabilities().getBrowserName().equals("internet explorer"))
			return "ie";
        return threadLocal.get().getCapabilities().getBrowserName();
 }
	/**
	 * Quit driver
	 */
	public void quit() {
		getDriver().quit();
	}
	
}
