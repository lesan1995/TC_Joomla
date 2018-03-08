package page_action;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import common.Control;
import common.Drivers;

public class BasePage extends Control {
	Switch swithTo=new Switch();
	WebElement element;
	/**
	 * Click to element by location
	 * @param location
	 */
	public void click(By location) {
		element=findElement(location);
		try {
			element.click();
		}
		catch (Exception e) {
			focus(location);
			scrollElement();
			try {
				element.click();
			}
			catch (Exception ee) {
				clickJavacript(location);
			}
			
			// TODO: handle exception
		}
		finally {
			
		}
		
	}
	public void clickJavacript(By location) {
		element=findElement(location);
		JavascriptExecutor executor = (JavascriptExecutor)Drivers.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	/**
	 * Focus to element by location
	 * @param location
	 */
	public void focus(By location) {
		element=findElement(location);
		try {
			new Actions(Drivers.getInstance().getDriver()).moveToElement(element).build().perform();
		}
		catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor)Drivers.getInstance().getDriver();
			executor.executeScript("arguments[0].focus();", element);
			// TODO: handle exception
		}
		
	}
	/**
	 * UnFocus to element by location
	 * @param location
	 */
	public void unFocus(By location) {
		element=findElement(location);
		new Actions(Drivers.getInstance().getDriver()).release(element).build().perform();
	}
	/**
	 * Type to element by location
	 * @param location
	 * @param text
	 */
	public void type(By location, String text) {
		element=findElement(location);
		element.clear();
		element.sendKeys(text);
	}
	public void type(By location, Keys key) {
		element=findElement(location);
		element.sendKeys(key);
	}
	/**
	 * Count number of element
	 * @param location
	 * @return
	 */
	public int count(By location) {
		Drivers.getInstance().waitTo.elementDisplay();
		int size = Drivers.getInstance().getDriver().findElements(location).size();
		return size;
		
	}
	/**
	 * Read text of element
	 * @param location
	 * @return
	 */
	public String read(By location) {
		element=findElement(location);
		String text = element.getText();
		return text;
	}
	/**
	 * Read text of element
	 * @param location
	 * @return
	 */
	public String read(By location,String attribute) {
		element=findElement(location);
		String text = element.getAttribute(attribute);
		return text;
	}
	/**
	 * Get color element
	 * @param location
	 * @return
	 */
	public String getColorValue(By location) {
		element=findElement(location);
		return element.getCssValue("background-color");
	}
	/**
	 * Check element display
	 * @param location
	 * @return
	 */
	public boolean isElementDisplay(By location) {
		try {
			//if(Drivers.getInstance().browser.equals("ie")) Thread.sleep(3000);
			findElement(location);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	/**
	 * Scroll to top page
	 */
	public void scrollToTop() {
		((JavascriptExecutor) Drivers.getInstance().getDriver()).executeScript("window.scrollBy(0,-1000)", "");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * Scroll to bottom page
	 */
	public void scrollToBottom() {
		((JavascriptExecutor) Drivers.getInstance().getDriver()).executeScript("window.scrollBy(0,1000)", "");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * Scroll to element
	 */
	public void scrollElement() {
		((JavascriptExecutor) Drivers.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView();", element);
	}
	public class Switch{
		/**
		 * Switch to frame
		 * @param location
		 * @return
		 */
		public Switch frame(By location) {
			findElement(location);
			//Drivers.getInstance().waitTo.condition(Drivers.getInstance().timeOutPageLoad, ExpectedConditions.frameToBeAvailableAndSwitchToIt(location));
			Drivers.getInstance().getDriver().switchTo().frame(element);
			return this;
		}
		/**
		 * Switch to default
		 * @return
		 */
		public Switch Default() {
			Drivers.getInstance().getDriver().switchTo().defaultContent();
			return this;
			
		}
		/**
		 * Switch to popup
		 * @return
		 */
		public Switch popUp() {
			if(Drivers.getInstance().browser.equals("ie"))
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			String subWindowHandler = null;
			Set<String> handles = Drivers.getInstance().getDriver().getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			Drivers.getInstance().getDriver().switchTo().window(subWindowHandler);
			Drivers.getInstance().waitTo.pageLoad();
			return this;
		}
	}
}
