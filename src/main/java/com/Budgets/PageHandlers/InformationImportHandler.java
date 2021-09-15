
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.Properties;

public class InformationImportHandler {

	WebDriverHandler _webDriverHandler;
	Properties _prop;

	public InformationImportHandler(WebDriverHandler webDriverHandler, Properties prop) {
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	public void InformationImportFileUpload(String section, String path) throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty(section)).waitClickable(15, 100).leftPanelclick();
		String filePath = Paths.get(path).toAbsolutePath().toString();
		ImportPageHandlerElectricity iphe = new ImportPageHandlerElectricity(_webDriverHandler, _prop);
		iphe.genericImport(filePath);
		iphe.importUpload();
	}

	public void InformationErrorFileUpload(String section, String path) throws InterruptedException {
		waitLoad();
		_webDriverHandler.byXpath(_prop.getProperty(section)).waitClickable(15, 100).leftPanelclick();
		String filePath = Paths.get(path).toAbsolutePath().toString();
		ImportPageHandlerElectricity iphe = new ImportPageHandlerElectricity(_webDriverHandler, _prop);
		iphe.genericImport(filePath);
		iphe.importExport();
	}

	public void InformationVerifyCalculate() throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty("Information")).waitClickable(15,100).click();
		_webDriverHandler.byId("StartDate").waitClickable(15,100).clear().sendKeys("01/09/2018").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byId("EndDate").waitClickable(15,100).clear().sendKeys("31/08/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("SaveInformation")).click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).waitClickable(30,100).click();
		if(_webDriverHandler.byXpath(_prop.getProperty("Calculate")).isDisplayed())
		{
			System.out.println("There is Calculate button on Information Tab");
		}
		else{
			Assert.fail("There should be Calculate button on Information Tab");
		}
	}

	public void InformationTotalCalculate() throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty("Calculate")).waitClickable(8, 100).click();
		_webDriverHandler.byXpath(_prop.getProperty("TotalCalculate")).waitClickable(6, 100).click();
		_webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().click();
	}

	public void InformationCancelFileUpload(String section, String path) throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty(section)).waitClickable(15, 100).click();
		String filePath = Paths.get(path).toAbsolutePath().toString();
		ImportPageHandlerElectricity iphe = new ImportPageHandlerElectricity(_webDriverHandler, _prop);
		iphe.genericImport(filePath);
		iphe.importExport();
	}

	public void InformationFailedCalculate() {
		waitLoad();
		_webDriverHandler.byXpath(_prop.getProperty("Information")).waitClickable(15,100).click();
		_webDriverHandler.byXpath(_prop.getProperty("SaveInformation")).waitClickable(15,100).click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).waitClickable(20, 100).click();
		String ExpCalBtn = "Calculate";
		String ActualCalBtn = _webDriverHandler.byXpath(_prop.getProperty("Calculate")).getText();
		if (ExpCalBtn.contentEquals(ActualCalBtn)) {
			System.out.println("Calculate button is present on the screen");
		} else {
			System.out.println("There is no Calculate button on Information tab for Red validation Imports");
		}
	}
	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(15,100).waitInvisible();
	}
}
