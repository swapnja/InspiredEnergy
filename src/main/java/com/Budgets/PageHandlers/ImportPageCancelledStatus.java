
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ImportPageCancelledStatus {

	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	WebDriverHandler _webDriverHandler;
	Properties _prop;

	public ImportPageCancelledStatus(WebDriverHandler webDriverHandler, Properties prop) {
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	public void ImportFileCancel(String section, String path) throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty(section)).waitClickable(10,100).leftPanelclick();
		String filePath = Paths.get(path).toAbsolutePath().toString();
		genericImport(filePath);
		importCancel();
	}

	public void genericImport(String filePath) throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible().waitInvisible();
		_webDriverHandler.byXpath(_prop.getProperty("ImportBtn")).waitClickable().click();
		_webDriverHandler.byXpath(_prop.getProperty("ImportReferenceTxtBox")).waitClickable().sendKeys("Automation Cancelled Status " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("importNotes")).sendKeys("Automation Cancelled Status " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ChooseFile")).sendKeys(filePath);
		_webDriverHandler.byXpath(_prop.getProperty("SaveForm")).waitPresence().click();
	}

	public void importCancel() {
		_webDriverHandler.byXpath(_prop.getProperty("ImportCancel")).waitClickable(15, 100).click();
	}

	public void verifyImport() {
		_webDriverHandler.byXpath("//input[@type='search']").clear();
		_webDriverHandler.byXpath("//input[@type='search']").sendKeys("Automation Cancelled Status " + appendDate);
		waitLoad();
		String strTable = _webDriverHandler.byXpath("//*[@class='col-sm-12']//tbody//tr").getText();
		Assert.assertEquals(_webDriverHandler.byXpath("//*[@class='col-sm-12']//tbody//tr//td[text()='Cancelled']").getText(), "Cancelled");
		System.out.println("Import status verified successfully");
		System.out.println(strTable);
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible().waitInvisible();
	}
}
