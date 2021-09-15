
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.Data.ValidationHashes.ElectricityConsumptionComparisonHashTables;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Properties;

public class ElectricitySummaryComparison {

	private ValidationPageHandler _validationPageHandler;
	private WebDriverHandler _webDriverHandler;
	private Properties _prop;
	String appendDate = TimeStampPageHandler.AppendTimeStamp();

	public ElectricitySummaryComparison(WebDriverHandler webDriverHandler, Properties prop) {
		_validationPageHandler = new ValidationPageHandler(webDriverHandler, prop);
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	String[] _EConsumptionComparisonHeaders = new String[]{"MMNV", "MLC", "MCFP", "DM", "ISD"};

	public void ImportGreenFile(String path) throws InterruptedException, IOException {
		String filePath = Paths.get(path).toAbsolutePath().toString();
		ElectricityConsumptionComparisonHashTables mht = new ElectricityConsumptionComparisonHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String meterHeader : _EConsumptionComparisonHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.GreenValidation(meterHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportRedFile(String path) throws InterruptedException, IOException {
		String filePath = Paths.get(path).toAbsolutePath().toString();
		ElectricityConsumptionComparisonHashTables mht = new ElectricityConsumptionComparisonHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String meterHeader : _EConsumptionComparisonHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.RedValidation(meterHeader, ht, 'E');
		}
		importExport();
	}

	public void genericImport(String filePath) throws InterruptedException {
		waitLoad();
		_webDriverHandler.byXpath(_prop.getProperty("ImportBtn")).waitClickable(15,100).click();
		_webDriverHandler.byXpath(_prop.getProperty("ImportReferenceTxtBox")).waitClickable(15,100).sendKeys("Automation Import File" + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("importNotes")).sendKeys("Automation Import File" + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ChooseFile")).sendKeys(filePath);
		_webDriverHandler.byXpath(_prop.getProperty("SaveForm")).waitPresence().click();
		waitLoad();
	}

	public void importUpload() {
		_webDriverHandler.byXpath(_prop.getProperty("ImportUpload")).click();
		waitLoad();
		_webDriverHandler.byXpath("//button[contains(text(),'OK')]").click();
	}

	public void importExport() {
		_webDriverHandler.byXpath("//button[@id='btnExportErrors']").waitClickable(15,100).click();
		waitLoad();
		_webDriverHandler.byXpath("//button[@id='btnCancel']").waitClickable(15,100).click();
	}

	public void filterImportCC() {
		_webDriverHandler.byXpath("//*[@id=\"tableConsumptionComparison_filter\"]/label/input").clear();
		_webDriverHandler.byXpath("//*[@id=\"tableConsumptionComparison_filter\"]/label/input").sendKeys("Automation Import File" + appendDate);
		waitLoad();
		String strTableMeterLocation = _webDriverHandler.byXpath("//*[@id=\"tableConsumptionComparison\"]").getText();
		System.out.println("/n" + strTableMeterLocation + "/n");
	}

	public void filterImportBC() {
		_webDriverHandler.byXpath("//*[@id=\"tableBudgetComparison_filter\"]/label/input").clear();
		_webDriverHandler.byXpath("//*[@id=\"tableBudgetComparison_filter\"]/label/input").sendKeys("Automation Import File" + appendDate);
		waitLoad();
		String strTableMeterLocation = _webDriverHandler.byXpath("//*[@id=\"tableBudgetComparison\"]").getText();
		System.out.println("/n" + strTableMeterLocation + "/n");
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible().waitInvisible();
	}
}