//Verify Information tab on Budget Console Screen 

package com.Budgets.Utility.Electricity.Electricity5;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC106_BudgetConsole_Electricity_InformationTab_Calculate_GreenValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC106_BudgetConsole_Electricity_InformationTab_Calculate_GreenValidation() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		String xlPathMeter = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/Meter_Green.xlsx").toAbsolutePath().toString();
		String xlPathConsumption = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/Consumption_Green.xlsx").toAbsolutePath().toString();
		String xlPathRTB = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/RateTimeBand_Green.xlsx").toAbsolutePath().toString();
		String xlPathKVA = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/KVA_Green.xlsx").toAbsolutePath().toString();
		String xlPathContractCharges = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/ContractCharges_Green.xlsx").toAbsolutePath().toString();
		String xlPathReference = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/ReferencePrices_Green.xlsx").toAbsolutePath().toString();
		String xlPathPublishedView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/PublishedView_Green.xlsx").toAbsolutePath().toString();
		String xlPathInspiredEnergyView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/InspiredEnergyView_Green.xlsx").toAbsolutePath().toString();
		String xlPathTLF = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/TLF_Green.xlsx").toAbsolutePath().toString();
		String xlPathDNOFactors = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/DNOFactors_Green.xlsx").toAbsolutePath().toString();
		String xlPathDNORAGTimes = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/DNORAGTimes_Green.xlsx").toAbsolutePath().toString();
		String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/ConsumptionAdjustment_Green.xlsx").toAbsolutePath().toString();
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.createBudgetMonthlyElectricity();
		InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
		iigh.InformationImportFileUpload("ElectricityMeters", xlPathMeter);
		iigh.InformationImportFileUpload("ElectricityConsumption", xlPathConsumption);
		iigh.InformationImportFileUpload("ElectricityRateTimeBands", xlPathRTB);
		iigh.InformationImportFileUpload("ElectricityKVArh", xlPathKVA);
		iigh.InformationImportFileUpload("ElectricityContractCharges", xlPathContractCharges);
		iigh.InformationImportFileUpload("ElectricityReferencePrices", xlPathReference);
		iigh.InformationImportFileUpload("ElectricityPublishedView", xlPathPublishedView);
		iigh.InformationImportFileUpload("ElectricitySoftwareSolutionView", xlPathInspiredEnergyView);
		iigh.InformationImportFileUpload("ElectricityTransmissionLossFactors", xlPathTLF);
		iigh.InformationImportFileUpload("ElectricityDNOFactors", xlPathDNOFactors);
		iigh.InformationImportFileUpload("ElectricityDNORAGTimes", xlPathDNORAGTimes);
		iigh.InformationImportFileUpload("ElectricityConsumptionAdjustment", xlPathConsumptionAdjustment);
		InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
		infoHand.InformationVerifyCalculate();
		infoHand.InformationTotalCalculate();
	}
}