
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.Data.ValidationHashes.*;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Properties;

public class ImportPageHandlerGas {

	private ValidationPageHandler _validationPageHandler;
	private WebDriverHandler _webDriverHandler;
	private Properties _prop;
	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	private String[] _GMeterHeaders = new String[]{"MeterMLC", "MeterMC", "MeterMMPan", "MeterIMM", "MeterMET", "MeterETI", "MeterKNN", "MeterMVD", "MeterIVT", "MeterSRN", "MeterVSPWVTNSVV",
			"MeterCVPWVTNCVV", "MeterCCAENN", "MeterDM", "MeterIPF", "MeterMSD", "MeterISD", "MeterIED", "MeterIELLR", "MeterMBN", "MeterMKVA"};
	private String[] _GConsumptionHeaders = new String[]{"ConsumptionMMI", "ConsumptionID", "ConsumptionPDNN", "ConsumptionMPDID", "ConsumptionMDISPM", "ConsumptionDDSM", "ConsumptionPE"};
	private String[] _GRateTimeBandHeaders = new String[]{"RTBMCR", "RTBMD", "RTBIST", "RTBIET", "RTBFPCFAR"};
	private String[] _GConsumptionAdjustmentHeaders = new String[]{"CAMMNV", "CAMLC", "CAMCFP", "CADM", "CAISD"};
	private String[] _GContractChargesHeaders = new String[]{"CCDCAM", "CCMMPrn", "CCIMPrn", "CCMCR", "CCIMS", "CCISD", "CCIED", "CCIPM", "CCPTNV", "CCPPNV", "CCRNN", "CCAERM", "CCSCPPNV",
			"CCDMFTSP"};
	private String[] _GForecastHeaders = new String[]{"FCDCAM", "FCMMPan", "FCIMPrn", "FCMCR", "FCIMS", "FCISD", "FCIED", "FCIPM", "FCPTNV", "FCPPNV", "FCRNN", "FCCPAHPM", "FCSCPPNV", "FCDMFTSP"};
	private String[] _GReferencePricesHeaders = new String[]{"RPID", "RPRPNN", "RPDP"};

	public ImportPageHandlerGas(WebDriverHandler webDriverHandler, Properties prop) {
		_validationPageHandler = new ValidationPageHandler(webDriverHandler, prop);
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	// Gas
	// Meter
	public void ImportMeterGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasMeters")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Meters/PR008_Budget_V3_TC001_Utility_Gas_Meters_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasMetersHashTables mht = new GasMetersHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String meterHeader : _GMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.GreenValidation(meterHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportMeterRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasMeters")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Meters/PR008_Budget_V3_TC002_Utility_Gas_Meters_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasMetersHashTables mht = new GasMetersHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String meterHeader : _GMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.RedValidation(meterHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportMeterAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasMeters")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Meters/PR008_Budget_V3_TC003_Utility_Gas_Meters_ValidInput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasMetersHashTables mht = new GasMetersHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String meterHeader : _GMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.AmberValidation(meterHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportMeterAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasMeters")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Meters/PR008_Budget_V3_TC004_Utility_Gas_Meters_InvalidInput_AmberAndRedValidation.xlsx").toAbsolutePath().toString();
		GasMetersHashTables mht = new GasMetersHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String meterHeader : _GMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.AARValidation(meterHeader, ht, 'G');
		}
		importExport();
	}

	// Consumption
	public void ImportConsumptionGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumption")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Consumption/PR008_Budget_V3_TC006_Utility_Gas_Consumption_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasConsumptionHashTables mht = new GasConsumptionHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String consumptionHeader : _GConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.GreenValidation(consumptionHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportConsumptionRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumption")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Consumption/PR008_Budget_V3_TC007_Utility_Gas_Consumption_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasConsumptionHashTables mht = new GasConsumptionHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String consumptionHeader : _GConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.RedValidation(consumptionHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportConsumptionAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumption")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Consumption/PR008_Budget_V3_TC008_Utility_Gas_Consumption_ValidInput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasConsumptionHashTables mht = new GasConsumptionHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String consumptionHeader : _GConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.AmberValidation(consumptionHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportConsumptionAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumption")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/Consumption/PR008_Budget_V3_TC009_Utility_Gas_Consumption_InvalidInput_AmberAndRedValidation.xlsx").toAbsolutePath().toString();
		GasConsumptionHashTables mht = new GasConsumptionHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String consumptionHeader : _GConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.AARValidation(consumptionHeader, ht, 'G');
		}
		importExport();
	}
	// Rate Time Band

	public void ImportRateTimeBandGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasRateTimeBands")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/RateTimeBands/PR008_Budget_V3_TC011_Utility_Gas_RateTimeBand_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasRateTimeBandsHashTables mht = new GasRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String RTBHeader : _GRateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.GreenValidation(RTBHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportRateTimeBandRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasRateTimeBands")).leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/RateTimeBands/PR008_Budget_V3_TC012_Utility_Gas_RateTimeBands_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasRateTimeBandsHashTables mht = new GasRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String RTBHeader : _GRateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.RedValidation(RTBHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportRateTimeBandAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasRateTimeBands")).leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/RateTimeBands/PR008_Budget_V3_TC013_Utility_Gas_RateTimeBand_ValidInput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasRateTimeBandsHashTables mht = new GasRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String RTBHeader : _GRateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.AmberValidation(RTBHeader, ht, 'G');
		}
		importUpload();
	}

	// Contract Charges

	public void ImportContractChargesGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasContractCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC016_Utility_Gas_ContractCharges_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasContractChargesHashTables mht = new GasContractChargesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String contractChargesHeader : _GContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.GreenValidation(contractChargesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportContractChargesRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasContractCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC017_Utility_Gas_ContractCharges_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasContractChargesHashTables mht = new GasContractChargesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String contractChargesHeader : _GContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.RedValidation(contractChargesHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportContractChargesAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasContractCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC018_Utility_Gas_ContractCharges_ValidInput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasContractChargesHashTables mht = new GasContractChargesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String contractChargesHeader : _GContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.AmberValidation(contractChargesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportContractChargesAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasContractCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC019_Utility_Gas_ContractCharges_InvalidInput_AmberAndRedValidation.xlsx").toAbsolutePath().toString();
		GasContractChargesHashTables mht = new GasContractChargesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String contractChargesHeader : _GContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.AARValidation(contractChargesHeader, ht, 'G');
		}
		importExport();
	}
	// Forecast Charges

	public void ImportForcastChargesGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasForcastCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ForcastCharges/PR008_Budget_V3_TC021_Utility_Gas_ForcastCharges_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasForcastChargesHashTables mht = new GasForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _GForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.GreenValidation(forcastChargesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportForcastChargesRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasForcastCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ForcastCharges/PR008_Budget_V3_TC022_Utility_Gas_ForcastCharges_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasForcastChargesHashTables mht = new GasForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _GForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.RedValidation(forcastChargesHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportForcastChargesAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasForcastCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ForcastCharges/PR008_Budget_V3_TC023_Utility_Gas_ForcastCharges_Validinput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasForcastChargesHashTables mht = new GasForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _GForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.AmberValidation(forcastChargesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportForcastChargesAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasForcastCharges")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ForcastCharges/PR008_Budget_V3_TC024_Utility_Gas_ForcastCharges_InvalidInput_AmberAndRedValidation.xlsx").toAbsolutePath().toString();
		GasForcastChargesHashTables mht = new GasForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _GForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.AARValidation(forcastChargesHeader, ht, 'G');
		}
		importExport();
	}
	// Reference Price

	public void ImportReferencePriceGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasReferencePrices")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC026_Utility_Gas_ReferencePrices_ValidInput_GreenValidation.xlsx").toAbsolutePath().toString();
		GasReferencePricesHashTables mht = new GasReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String referencePricesHeader : _GReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.GreenValidation(referencePricesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportReferencePriceRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasReferencePrices")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC027_Utility_Gas_ReferencePrices_InvalidInput_RedValidation.xlsx").toAbsolutePath().toString();
		GasReferencePricesHashTables mht = new GasReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String referencePricesHeader : _GReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.RedValidation(referencePricesHeader, ht, 'G');
		}
		importExport();
	}

	public void ImportReferencePriceAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasReferencePrices")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC028_Utility_Gas_ReferencePrices_ValidInput_AmberValidation.xlsx").toAbsolutePath().toString();
		GasReferencePricesHashTables mht = new GasReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String referencePricesHeader : _GReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.AmberValidation(referencePricesHeader, ht, 'G');
		}
		importUpload();
	}

	public void ImportReferencePriceAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasReferencePrices")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC029_Utility_Gas_ReferencePrices_InvalidInput_AmberAndRedValidation.xlsx").toAbsolutePath().toString();
		GasReferencePricesHashTables mht = new GasReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String referencePricesHeader : _GReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.AARValidation(referencePricesHeader, ht, 'G');
		}
		importExport();
	}
	// Consumption Adjustment

	public void ImportConsumptionAdjustmentGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumptionAdjustment")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ConsumptionAdjustment/PR008_Budget_V3_TC055_Utility_Gas_ConsumptionAdjustment_ValidInput_Green.xlsx").toAbsolutePath().toString();
		GasConsumptionAdjustmentHashTables mht = new GasConsumptionAdjustmentHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String consumptionadjustmentheader : _GConsumptionAdjustmentHeaders) {
			System.out.println(consumptionadjustmentheader);
			_validationPageHandler.GreenValidation(consumptionadjustmentheader, ht, 'G');
		}
		importUpload();
	}

	public void ImportConsumptionAdjustmentRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("GasConsumptionAdjustment")).waitClickable().leftPanelclick();
		String filePath = Paths.get("BudgetTestData/Gas/ConsumptionAdjustment/PR008_Budget_V3_TC056_Utility_Gas_ConsumptionAdjustment_InvalidInput_Red.xlsx").toAbsolutePath().toString();
		GasConsumptionAdjustmentHashTables mht = new GasConsumptionAdjustmentHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String consumptionadjustmentheader : _GConsumptionAdjustmentHeaders) {
			System.out.println(consumptionadjustmentheader);
			_validationPageHandler.RedValidation(consumptionadjustmentheader, ht, 'G');
		}
		importExport();
	}

	public void genericImport(String filePath) throws InterruptedException {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(20, 100).waitInvisible(20, 100);
		_webDriverHandler.byXpath(_prop.getProperty("ImportBtn")).waitClickable().click();
		_webDriverHandler.byXpath(_prop.getProperty("ImportReferenceTxtBox")).waitClickable().sendKeys("Automation Import File " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("importNotes")).sendKeys("Automation Import File" + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ChooseFile")).sendKeys(filePath);
		_webDriverHandler.byXpath(_prop.getProperty("SaveForm")).waitPresence().click();
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(20, 100).waitInvisible(20, 100);
	}

	public void importUpload() {
		_webDriverHandler.byXpath(_prop.getProperty("ImportUpload")).click();
		waitLoad();
		_webDriverHandler.byXpath("//button[contains(text(),'OK')]").click();
	}

	public void importExport() {
		_webDriverHandler.byXpath("//button[@id='btnExportErrors']").waitClickable().click();
		waitLoad();
		_webDriverHandler.byXpath("//button[@id='btnCancel']").waitClickable().click();
	}

	public void verifyImport() {
		_webDriverHandler.byXpath("//input[@type='search']").clear();
		_webDriverHandler.byXpath("//input[@type='search']").sendKeys("Automation Import File " + appendDate);
		waitLoad();
		String strTableMeterLocation = _webDriverHandler.byXpath("//*[@class='col-sm-12']//tbody//tr")
				.getText();
		System.out.println("\n"+strTableMeterLocation);
	}
	
	public WebElement getGreenIcon(String type) {
		WebElement greenIcon = _webDriverHandler.byXpath("//*[@data-importtype='"+type+"']//i").returnElement();
		return greenIcon;
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible().waitInvisible();
	}
}