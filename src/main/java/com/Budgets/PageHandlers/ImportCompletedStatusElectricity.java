package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

	public class ImportCompletedStatusElectricity {
		WebDriverHandler _webDriverHandler;
		Properties _prop;
		WebDriver driver;
	public ImportCompletedStatusElectricity() throws IOException {
		super();
	}

	public void ImportStatusElectricity() {	
		
		_webDriverHandler.byXpath(_prop.getProperty("ImportImage")).waitVisible();
		System.out.println("****************");
		//WebElement we=driver.findElement(By.xpath(_prop.getProperty("ImportImage")));
		//we.isDisplayed();
			}

	}
