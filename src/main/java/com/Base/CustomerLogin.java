
package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class CustomerLogin {

	Properties prop = ReadPropertyFile.getProperties();

	public CustomerLogin(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(prop.getProperty("CustomerUserID"))).sendKeys(prop.getProperty("CustomerUserValue"));
		driver.findElement(By.xpath(prop.getProperty("CustomerPassword"))).sendKeys(prop.getProperty("CustomerPasswordValue"));
		driver.findElement(By.xpath(prop.getProperty("CustomerLogin"))).submit();
	}
}