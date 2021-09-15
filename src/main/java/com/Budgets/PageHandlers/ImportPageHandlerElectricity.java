
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.Data.ValidationHashes.*;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Properties;

public class ImportPageHandlerElectricity {

	private ValidationPageHandler _validationPageHandler;
	private WebDriverHandler _webDriverHandler;
	private Properties _prop;
	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	private String[] _EMeterHeaders = new String[] { "MeterMLC", "MeterMC", "MeterMMPan", "MeterIMM", "MeterMET",
			"MeterETI", "MeterKNN", "MeterMVD", "MeterIVT", "MeterSRN", "MeterVSPWVTNSVV", "MeterCVPWVTNCVV",
			"MeterCCAENN", "MeterDM", "MeterIPF", "MeterMSD", "MeterISD", "MeterIED", "MeterIELLR", "MeterMBN", "MeterMKVA"};
	private String[] _EConsumptionHeaders = new String[] { "ConsumptionMMI", "ConsumptionID", "ConsumptionPDNN",
			"ConsumptionMPDID", "ConsumptionMDISPM", "ConsumptionDDSM", "ConsumptionPE" };
	private String[] _ERateTimeBandHeaders = new String[] { "RTBMCR", "RTBMD", "RTBIST", "RTBIET", "RTBFPCFAR" };
	private String[] _EKVAhrhHeaders = new String[] { "KVArhMMI", "KVArhID", "KVArhPDNN", "KVArhMPDID", "KVArhMDISPM",
			"KVArhDDSM", "KVArhPE" };
	private String[] _EConsumptionAdjustmentHeaders = new String[] { "MMNV", "MLC", "MCFP", "DM", "ISD" };
	private String[] _EDNORagTimesHeaders = new String[] { "TAFDRTMD", "TAFDRTML", "TAFDRTRTINV", "TAFDRTIMST",
			"TAFDRTIMET", "TAFDRTIMSD", "TAFDRTIMED" };
	private String[] _EDNOFactorsHeaders = new String[] { "TAFDFMD", "TAFDFML", "TAFDFFNNOM", "TAFDFIMST", "TAFDFIMET",
			"TAFDFIMSD", "TAFDFIMED" };
	private String[] _ETransmissionLossFactorsHeaders = new String[] { "TFTLFGGI", "TFTLFID", "TFTLFPDNN", "TFTLFMPDID",
			"TFTLFMDISPM", "TFTLFDDSGG" };
	private String[] _EContractChargesHeaders = new String[] { "CCDCAM", "CCMMPan", "CCIMPan", "CCMCR", "CCIMS",
			"CCISD", "CCIED", "CCIPM", "CCITPM", "CCPTNV", "CCPPNV", "CCRNN", "CCRNNANPOIV", "CCITMD", "CCAERM", "CCERPPNV",
			"CCSCPPNV", "CCSTCPPNV", "CCIPMR", "CCDMFTSP" };
	private String[] _EForecastHeaders = new String[] { "FCDCAM", "FCMMPan", "FCIMPan", "FCMCR", "FCIMS", "FCISD",
			"FCIED", "FCIPM", "FCITPM", "FCPTNV", "FCPPNV", "FCRNN", "FCRNNANPOIV", "FCCPAHPM", "FCERPPNV", "FCSCPPNV",
			"FCSTCPPNV","FCITMD","FCIPMR", "FCDMFTSP" };
	private String[] _EReferencePricesHeaders = new String[] { "RPID", "RPRPNN", "RPDP" };
	private String[] _EPublishedViewHeaders = new String[] { "PVRNN", "PVISD", "PVIED", "PVDNN", "PVLNAN", "PVMR",
			"PVMD", "PVDDLCFSP" };
	private String[] _EInspiredViewHeaders = new String[] { "IEVRNN", "IEVISD", "IEVIED", "IEVDNN", "IEVLNAN", "IEVMR",
			"IEVMD", "IEVDDLCFSP" };

	public ImportPageHandlerElectricity(WebDriverHandler webDriverHandler, Properties prop) {
		_validationPageHandler = new ValidationPageHandler(webDriverHandler, prop);
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	// Electricity
	// Meter
	public void ImportMeterGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityMeters")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Meters/PR008_Budget_V3_TC001_Utility_Electricity_Meters_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityMetersHashTables mht = new ElectricityMetersHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String meterHeader : _EMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.GreenValidation(meterHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportMeterRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityMeters")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Meters/PR008_Budget_V3_TC002_Utility_Electricity_Meters_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityMetersHashTables mht = new ElectricityMetersHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String meterHeader : _EMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.RedValidation(meterHeader, ht, 'E');
		}
		importExport();
	}
	public void ImportMeterAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityMeters")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Meters/PR008_Budget_V3_TC003_Utility_Electricity_Meters_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityMetersHashTables mht = new ElectricityMetersHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String meterHeader : _EMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.AmberValidation(meterHeader, ht, 'E');
		}
		importUpload();
	}
	public void ImportMeterAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityMeters")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Meters/PR008_Budget_V3_TC004_Utility_Electricity_Meters_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityMetersHashTables mht = new ElectricityMetersHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String meterHeader : _EMeterHeaders) {
			System.out.println(meterHeader);
			_validationPageHandler.AARValidation(meterHeader, ht, 'E');
		}
		importExport();
	}
	// Consumption
	public void ImportConsumptionGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumption")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Consumption/PR008_Budget_V3_TC006_Utility_Electricity_Consumption_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionHashTables mht = new ElectricityConsumptionHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String consumptionHeader : _EConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.GreenValidation(consumptionHeader, ht, 'E');
		}
		importUpload();
	}
	public void ImportConsumptionRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumption")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Consumption/PR008_Budget_V3_TC007_Utility_Electricity_Consumption_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionHashTables mht = new ElectricityConsumptionHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String consumptionHeader : _EConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.RedValidation(consumptionHeader, ht, 'E');
		}
		importExport();
	}
	public void ImportConsumptionAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumption")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Consumption/PR008_Budget_V3_TC008_Utility_Electricity_Consumption_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionHashTables mht = new ElectricityConsumptionHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String consumptionHeader : _EConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.AmberValidation(consumptionHeader, ht, 'E');
		}
		importUpload();
	}
	public void ImportConsumptionAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumption")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/Consumption/PR008_Budget_V3_TC009_Utility_Electricity_Consumption_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionHashTables mht = new ElectricityConsumptionHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String consumptionHeader : _EConsumptionHeaders) {
			System.out.println(consumptionHeader);
			_validationPageHandler.AARValidation(consumptionHeader, ht, 'E');
		}
		importExport();
	}
	// Rate Time Band

	public void ImportRateTimeBandGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityRateTimeBands")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/RateTimeBands/PR008_Budget_V3_TC011_Utility_Electricity_RateTimeBand_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityRateTimeBandsHashTables mht = new ElectricityRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String RTBHeader : _ERateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.GreenValidation(RTBHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportRateTimeBandAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityRateTimeBands")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/RateTimeBands/PR008_Budget_V3_TC013_Utility_Electricity_RateTimeBand_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityRateTimeBandsHashTables mht = new ElectricityRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String RTBHeader : _ERateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.AmberValidation(RTBHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportRateTimeBandRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityRateTimeBands")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/RateTimeBands/PR008_Budget_V3_TC012_Utility_Electricity_RateTimeBand_ValidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityRateTimeBandsHashTables mht = new ElectricityRateTimeBandsHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String RTBHeader : _ERateTimeBandHeaders) {
			System.out.println(RTBHeader);
			_validationPageHandler.RedValidation(RTBHeader, ht, 'E');
		}
		importExport();
	}
	// KVA

	public void ImportKVArhGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityKVArh")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC016_Utility_Electricity_KVArh_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityKVArhHashTables mht = new ElectricityKVArhHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String kvaHeader : _EKVAhrhHeaders) {
			System.out.println(kvaHeader);
			_validationPageHandler.GreenValidation(kvaHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportKVArhRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityKVArh")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC017_Utility_Electricity_KVArh_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityKVArhHashTables mht = new ElectricityKVArhHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String kvaHeader : _EKVAhrhHeaders) {
			System.out.println(kvaHeader);
			_validationPageHandler.RedValidation(kvaHeader, ht, 'E');
		}
		importExport();
	}

	public void ImportKVArhAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityKVArh")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC018_Utility_Electricity_KVArh_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityKVArhHashTables mht = new ElectricityKVArhHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String kvaHeader : _EKVAhrhHeaders) {
			System.out.println(kvaHeader);
			_validationPageHandler.AmberValidation(kvaHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportKVArhAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityKVArh")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC019_Utility_Electricity_KVArh_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityKVArhHashTables mht = new ElectricityKVArhHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String kvaHeader : _EKVAhrhHeaders) {
			System.out.println(kvaHeader);
			_validationPageHandler.AARValidation(kvaHeader, ht, 'E');
		}
		importExport();
	}
	// Contract Charges

	public void ImportContractChargesGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityContractCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ContractCharges/PR008_Budget_V3_TC021_Utility_Electricity_ContractCharges_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityContractChargesHashTables mht = new ElectricityContractChargesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String contractChargesHeader : _EContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.GreenValidation(contractChargesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportContractChargesRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityContractCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ContractCharges/PR008_Budget_V3_TC022_Utility_Electricity_ContractCharges_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityContractChargesHashTables mht = new ElectricityContractChargesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String contractChargesHeader : _EContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.RedValidation(contractChargesHeader, ht, 'E');
		}
		importExport();
	}

	public void ImportContractChargesAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityContractCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ContractCharges/PR008_Budget_V3_TC023_Utility_Electricity_ContractCharges_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityContractChargesHashTables mht = new ElectricityContractChargesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String contractChargesHeader : _EContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.AmberValidation(contractChargesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportContractChargesAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityContractCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ContractCharges/PR008_Budget_V3_TC024_Utility_Electricity_ContractCharges_InvalidInput_AmberAndRed.xlsx")
				.toAbsolutePath().toString();
		ElectricityContractChargesHashTables mht = new ElectricityContractChargesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String contractChargesHeader : _EContractChargesHeaders) {
			System.out.println(contractChargesHeader);
			_validationPageHandler.AARValidation(contractChargesHeader, ht, 'E');
		}
		importExport();
	}
	// Forcast Charges

	public void ImportForcastChargesGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityForcastCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ForcastCharges/PR008_Budget_V3_TC026_Utility_Electricity_ForcastCharges_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityForcastChargesHashTables mht = new ElectricityForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _EForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.GreenValidation(forcastChargesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportForcastChargesRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityForcastCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ForcastCharges/PR008_Budget_V3_TC027_Utility_Electricity_ForcastCharges_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityForcastChargesHashTables mht = new ElectricityForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _EForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.RedValidation(forcastChargesHeader, ht, 'E');
		}
		importExport();
	}

	public void ImportForcastChargesAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityForcastCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ForcastCharges/PR008_Budget_V3_TC028_Utility_Electricity_ForcastCharges_Validinput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityForcastChargesHashTables mht = new ElectricityForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _EForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.AmberValidation(forcastChargesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportForcastChargesAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityForcastCharges")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ForcastCharges/PR008_Budget_V3_TC029_Utility_Electricity_ForcastCharges_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityForcastChargesHashTables mht = new ElectricityForcastChargesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String forcastChargesHeader : _EForecastHeaders) {
			System.out.println(forcastChargesHeader);
			_validationPageHandler.AARValidation(forcastChargesHeader, ht, 'E');
		}
		importExport();
	}
	// Reference Price

	public void ImportReferencePriceGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityReferencePrices")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC031_Utility_Electricity_ReferencePrices_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityReferencePricesHashTables mht = new ElectricityReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String referencePricesHeader : _EReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.GreenValidation(referencePricesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportReferencePriceRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityReferencePrices")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC032_Utility_Electricity_ReferencePrices_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityReferencePricesHashTables mht = new ElectricityReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String referencePricesHeader : _EReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.RedValidation(referencePricesHeader, ht, 'E');
		}
		importExport();
	}

	public void ImportReferencePriceAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityReferencePrices")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC033_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityReferencePricesHashTables mht = new ElectricityReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String referencePricesHeader : _EReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.AmberValidation(referencePricesHeader, ht, 'E');
		}
		importUpload();
	}

	public void ImportReferencePriceAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityReferencePrices")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC034_Utility_Electricity_ReferencePrices_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityReferencePricesHashTables mht = new ElectricityReferencePricesHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String referencePricesHeader : _EReferencePricesHeaders) {
			System.out.println(referencePricesHeader);
			_validationPageHandler.AARValidation(referencePricesHeader, ht, 'E');
		}
		importExport();
	}

	// Published View
	public void ImportPublishedViewGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityPublishedView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/PublishedView/PR008_Budget_V3_TC036_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityPublishedViewHashTables mht = new ElectricityPublishedViewHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String publishedviewheader : _EPublishedViewHeaders) {
			System.out.println(publishedviewheader);
			_validationPageHandler.GreenValidation(publishedviewheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportPublishedViewRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityPublishedView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/PublishedView/PR008_Budget_V3_TC037_Utility_Electricity_PassthroughCharges_PublishedView_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityPublishedViewHashTables mht = new ElectricityPublishedViewHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String publishedviewheader : _EPublishedViewHeaders) {
			System.out.println(publishedviewheader);
			_validationPageHandler.RedValidation(publishedviewheader, ht, 'E');
		}
		importExport();
	}

	public void ImportPublishedViewAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityPublishedView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/PublishedView/PR008_Budget_V3_TC038_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityPublishedViewHashTables mht = new ElectricityPublishedViewHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String publishedviewheader : _EPublishedViewHeaders) {
			System.out.println(publishedviewheader);
			_validationPageHandler.AmberValidation(publishedviewheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportPublishedViewAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityPublishedView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/PublishedView/PR008_Budget_V3_TC039_Utility_Electricity_PassthroughCharges_PublishedView_Combination_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityPublishedViewHashTables mht = new ElectricityPublishedViewHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String publishedviewheader : _EPublishedViewHeaders) {
			System.out.println(publishedviewheader);
			_validationPageHandler.AARValidation(publishedviewheader, ht, 'E');
		}
		importExport();
	}

	// Inspired View
	public void ImportInspiredViewGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityInspiredEnergyView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/InspiredEnergyView/PR008_Budget_V3_TC041_Utility_Electricity_PassthroughCharges_InspiredEnergyView_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityInspiredEnergyViewHashTables mht = new ElectricityInspiredEnergyViewHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String inspiredviewheader : _EInspiredViewHeaders) {
			System.out.println(inspiredviewheader);
			_validationPageHandler.GreenValidation(inspiredviewheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportInspiredViewRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityInspiredEnergyView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/InspiredEnergyView/PR008_Budget_V3_TC042_Utility_Electricity_PassthroughCharges_InspiredEnergyView_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityInspiredEnergyViewHashTables mht = new ElectricityInspiredEnergyViewHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String inspiredviewheader : _EInspiredViewHeaders) {
			System.out.println(inspiredviewheader);
			_validationPageHandler.RedValidation(inspiredviewheader, ht, 'E');
		}
		importExport();
	}

	public void ImportInspiredViewAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityInspiredEnergyView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/InspiredEnergyView/PR008_Budget_V3_TC043_Utility_Electricity_PassthroughCharges_InspiredEnergyView_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityInspiredEnergyViewHashTables mht = new ElectricityInspiredEnergyViewHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String inspiredviewheader : _EInspiredViewHeaders) {
			System.out.println(inspiredviewheader);
			_validationPageHandler.AmberValidation(inspiredviewheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportInspiredViewAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityInspiredEnergyView")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/InspiredEnergyView/PR008_Budget_V3_TC044_Utility_Electricity_PassthroughCharges_InspiredEnergyView_InvalidInput_AmberAndRedVAlidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityInspiredEnergyViewHashTables mht = new ElectricityInspiredEnergyViewHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String inspiredviewheader : _EInspiredViewHeaders) {
			System.out.println(inspiredviewheader);
			_validationPageHandler.AARValidation(inspiredviewheader, ht, 'E');
		}
		importExport();
	}
	// Transmission Loss Factors

	public void ImportTransmissionLossFactorsGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityTransmissionLossFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/TransmissionLossFactors/PR008_Budget_V3_TC051_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityTransmissionLossFactorsHashTables mht = new ElectricityTransmissionLossFactorsHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String transmissionlossfactorsheader : _ETransmissionLossFactorsHeaders) {
			System.out.println(transmissionlossfactorsheader);
			_validationPageHandler.GreenValidation(transmissionlossfactorsheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportTransmissionLossFactorsRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityTransmissionLossFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/TransmissionLossFactors/PR008_Budget_V3_TC052_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityTransmissionLossFactorsHashTables mht = new ElectricityTransmissionLossFactorsHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String transmissionlossfactorsheader : _ETransmissionLossFactorsHeaders) {
			System.out.println(transmissionlossfactorsheader);
			_validationPageHandler.RedValidation(transmissionlossfactorsheader, ht, 'E');
		}
		importExport();
	}

	public void ImportTransmissionLossFactorsAmberFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityTransmissionLossFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/TransmissionLossFactors/PR008_Budget_V3_TC053_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_ValidInput_AmberValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityTransmissionLossFactorsHashTables mht = new ElectricityTransmissionLossFactorsHashTables();
		Hashtable<String, String> ht = mht.getAmberHash();
		genericImport(filePath);
		for (String transmissionlossfactorsheader : _ETransmissionLossFactorsHeaders) {
			System.out.println(transmissionlossfactorsheader);
			_validationPageHandler.AmberValidation(transmissionlossfactorsheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportTransmissionLossFactorsAARFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityTransmissionLossFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/TransmissionLossFactors/PR008_Budget_V3_TC054_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_AmberAndRedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityTransmissionLossFactorsHashTables mht = new ElectricityTransmissionLossFactorsHashTables();
		Hashtable<String, String> ht = mht.getAARHash();
		genericImport(filePath);
		for (String transmissionlossfactorsheader : _ETransmissionLossFactorsHeaders) {
			System.out.println(transmissionlossfactorsheader);
			_validationPageHandler.AARValidation(transmissionlossfactorsheader, ht, 'E');
		}
		importExport();
	}
	// DNO factors

	public void ImportDNOFactorsGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityDNOFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/DNOFactors/PR008_Budget_V3_TC056_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNOFactors_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityDNOFactorsHashTables mht = new ElectricityDNOFactorsHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String ednofactorsheader : _EDNOFactorsHeaders) {
			System.out.println(ednofactorsheader);
			_validationPageHandler.GreenValidation(ednofactorsheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportDNOFactorsRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityDNOFactors")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/DNOFactors/PR008_Budget_V3_TC057_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNOFactors_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityDNOFactorsHashTables mht = new ElectricityDNOFactorsHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String ednofactorsheader : _EDNOFactorsHeaders) {
			System.out.println(ednofactorsheader);
			_validationPageHandler.RedValidation(ednofactorsheader, ht, 'E');
		}
		importExport();
	}
	// DNO factors

	public void ImportDNORAGTimesGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityDNORAGTimes")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/DNORAGTimes/PR008_Budget_V3_TC061_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityDNORAGTimesHashTables mht = new ElectricityDNORAGTimesHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String ednoragheader : _EDNORagTimesHeaders) {
			System.out.println(ednoragheader);
			_validationPageHandler.GreenValidation(ednoragheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportDNORAGTimesRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityDNORAGTimes")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/DNOFactors/PR008_Budget_V3_TC062_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_InvalidInput_RedValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityDNORAGTimesHashTables mht = new ElectricityDNORAGTimesHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String ednoragheader : _EDNORagTimesHeaders) {
			System.out.println(ednoragheader);
			_validationPageHandler.RedValidation(ednoragheader, ht, 'E');
		}
		importExport();
	}
	// Consumption Adjustment

	public void ImportConsumptionAdjustmentGreenFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumptionAdjustment")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ConsumptionAdjustment/PR008_Budget_V3_TC058_Electricity_ConsumptionAdjusment_Green.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionAdjustmentHashTables mht = new ElectricityConsumptionAdjustmentHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		genericImport(filePath);
		for (String consumptionadjustmentheader : _EConsumptionAdjustmentHeaders) {
			System.out.println(consumptionadjustmentheader);
			_validationPageHandler.GreenValidation(consumptionadjustmentheader, ht, 'E');
		}
		importUpload();
	}

	public void ImportConsumptionAdjustmentRedFile() throws InterruptedException, IOException {
		_webDriverHandler.byXpath(_prop.getProperty("ElectricityConsumptionAdjustment")).waitClickable(15,100).leftPanelclick();
		String filePath = Paths.get(
				"BudgetTestData/Electricity/ConsumptionAdjustment/PR008_Budget_V3_TC059_Electricity_ConsumptionAdjusment_Red.xlsx")
				.toAbsolutePath().toString();
		ElectricityConsumptionAdjustmentHashTables mht = new ElectricityConsumptionAdjustmentHashTables();
		Hashtable<String, String> ht = mht.getRedHash();
		genericImport(filePath);
		for (String consumptionadjustmentheader : _EConsumptionAdjustmentHeaders) {
			System.out.println(consumptionadjustmentheader);
			_validationPageHandler.RedValidation(consumptionadjustmentheader, ht, 'E');
		}
		importExport();
	}

	public void genericImport(String filePath) throws InterruptedException {
		waitLoad();
		_webDriverHandler.byXpath(_prop.getProperty("ImportBtn")).waitClickable(10,100).click();
		_webDriverHandler.byXpath(_prop.getProperty("ImportReferenceTxtBox")).waitVisible(15,100).sendKeys("Automation Import File " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("importNotes")).sendKeys("Automation Import File " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ChooseFile")).sendKeys(filePath);
		_webDriverHandler.byXpath(_prop.getProperty("SaveForm")).waitClickable(15,100).click();
		waitLoad();
	}

	public void importUpload() {
		_webDriverHandler.byXpath(_prop.getProperty("ImportUpload")).waitClickable(15, 100).click();
		waitLoad();
		_webDriverHandler.byXpath("//button[contains(text(),'OK')]").click();
	}

	public void importExport() {
		// _webDriverHandler.byXpath("//button[@id='btnExportErrors']").waitClickable(15,100).click();
		_webDriverHandler.byXpath("//button[@id='btnCancel']").waitClickable(15, 100).click();
	}

	public void verifyImport() {
		_webDriverHandler.byXpath("//input[@type='search']").clear();
		_webDriverHandler.byXpath("//input[@type='search']").sendKeys("Automation Import File " + appendDate);
		waitLoad();
		String strTableMeterLocation = _webDriverHandler.byXpath("//*[@class='col-sm-12']//tbody//tr")
				.getText();
		System.out.println(strTableMeterLocation);
	}

	public WebElement getGreenIcon(String type) {
		WebElement greenIcon = _webDriverHandler.byXpath("//*[@data-importtype='"+type+"']//i").returnElement();
		return greenIcon;
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(10,100).waitInvisible(10,100);
	}
}