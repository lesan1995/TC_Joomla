package common;

import java.io.File;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Control {
	public Document interfaceFile;
	/**
	 * Find element with location
	 * @param location
	 * @return
	 */
	public WebElement findElement(By location) {
		WebElement element;
		try {
			Drivers.getInstance().waitTo.pageLoad();
			Drivers.getInstance().waitTo.elementDisplay();
			element = Drivers.getInstance().getDriver().findElement(location);
		}
		catch (Exception e) {
			// TODO: handle exception
			Drivers.getInstance().waitTo.pageLoad();
			Drivers.getInstance().waitTo.elementDisplay();
			element = Drivers.getInstance().getDriver().findElement(location);
		}
		
		return element;
	}
	/**
	 * Read interface of page
	 */
	public void readInterface() {
		Class<?> enclosingClass = getClass().getEnclosingClass();
		String className="";
		if (enclosingClass != null) {
			className=enclosingClass.getName();
		} else {
			className=getClass().getName();
		}
		className=className.split("\\.")[1];
		try {
			File configFile = new File("src/main/java/interfaces/" + className + ".xml");
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
			this.interfaceFile= dBuilder.parse(configFile);
		} catch (Exception e) {
			this.interfaceFile= null;
		}
	}
	/**
	 * Read element in page
	 * @param name
	 * @param var
	 * @return
	 */
	public By readElement(String name,String...var) {
		try {
			
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();
			XPathExpression expr = xpath.compile("//Element[@id=\"" + name + "\"]");
			Element nNode = (Element) expr.evaluate(interfaceFile, XPathConstants.NODE);
			
			String type = nNode.getElementsByTagName("By").item(0).getTextContent();
			String content = nNode.getElementsByTagName("Address").item(0).getTextContent();
			for(int i=0;i<var.length;i++) {
				content=content.replace("{"+i+"}", var[i]);
			}
			
			Class<?> classBy = Class.forName("org.openqa.selenium.By");
			Method method = classBy.getMethod(type, String.class);
			Object o = method.invoke(null, content);
			
			return (By) o;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
