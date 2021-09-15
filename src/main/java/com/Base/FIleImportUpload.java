
package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

public class FIleImportUpload {

	Properties prop = ReadPropertyFile.getProperties();

	public FIleImportUpload(WebDriver driver, String filePath) throws IOException, InterruptedException {
		WebElement EImportTxtBox = driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
		WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("ImportReferenceTxtBox")), driver);
		EImportTxtBox.click();
		EImportTxtBox.sendKeys("Automation Import File");
		driver.findElement(By.id(prop.getProperty("ImportNotes"))).sendKeys("Notes for an Automation Tests");
		WebElement EChooseFile = driver.findElement(By.xpath(prop.getProperty("ChooseFile")));
		EChooseFile.sendKeys(filePath);
		driver.findElement(By.xpath(prop.getProperty("Save"))).click();
	}
}