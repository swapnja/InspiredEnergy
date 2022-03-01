
package com.Base.SeleniumHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverHandler {

	private WebDriver _driver;

//	public WebDriverHandler() throws IOException {
//		_driver = new ChromeDriver();
//	}

	public WebDriverHandler(WebDriver driver) {
		_driver = driver;
	}

	public ElementHandler byXpath(String xpathExpression) {
		
		By by = By.xpath(xpathExpression);
		ElementHandler elementManager = new ElementHandler(_driver, by);
		return elementManager;
		
	}
		
	public ElementHandler byId(String id) {
		By by = By.id(id);
		ElementHandler elementManager = new ElementHandler(_driver, by);
		return elementManager;
	}
	
}