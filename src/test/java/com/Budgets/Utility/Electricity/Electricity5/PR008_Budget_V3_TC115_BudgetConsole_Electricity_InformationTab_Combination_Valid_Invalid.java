//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Electricity.Electricity5;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC115_BudgetConsole_Electricity_InformationTab_Combination_Valid_Invalid extends AbstractTestNg {

	public PR008_Budget_V3_TC115_BudgetConsole_Electricity_InformationTab_Combination_Valid_Invalid() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		String xlPathMeter = Paths.get("BudgetTestData/Electricity/Information/InformationTab_AAR/Meter_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathConsumption = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/Consumption_AAR.xlsx").toAbsolutePath()
				.toString();
		String xlPathRTB = Paths.get("BudgetTestData/Electricity/Information/InformationTab_AAR/RateTimeBand_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathKVA = Paths.get("BudgetTestData/Electricity/Information/InformationTab_AAR/KVA_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathContractCharges = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/ContractCharges_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathReference = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/ReferencePrices_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathPublishedView = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/PublishedView_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathInspiredEnergyView = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/InspiredEnergyView_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathTLF = Paths.get("BudgetTestData/Electricity/Information/InformationTab_AAR/TLF_AAR.xlsx")
				.toAbsolutePath().toString();
		String xlPathDNOFactors = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/DNOFactors_AAR.xlsx").toAbsolutePath()
				.toString();
		String xlPathDNORAGTimes = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/DNORAGTimes_AAR.xlsx").toAbsolutePath()
				.toString();
		String xlPathConsumptionAdjustment = Paths
				.get("BudgetTestData/Electricity/Information/InformationTab_AAR/ConsumptionAdjustment_AAR.xlsx")
				.toAbsolutePath().toString();
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.createBudgetMonthlyElectricity();
		InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
		iigh.InformationErrorFileUpload("ElectricityMeters", xlPathMeter);
		iigh.InformationErrorFileUpload("ElectricityConsumption", xlPathConsumption);
		iigh.InformationErrorFileUpload("ElectricityRateTimeBands", xlPathRTB);
		iigh.InformationErrorFileUpload("ElectricityKVArh", xlPathKVA);
		iigh.InformationErrorFileUpload("ElectricityContractCharges", xlPathContractCharges);
		iigh.InformationErrorFileUpload("ElectricityReferencePrices", xlPathReference);
		iigh.InformationErrorFileUpload("ElectricityPublishedView", xlPathPublishedView);
		iigh.InformationErrorFileUpload("ElectricityInspiredEnergyView", xlPathInspiredEnergyView);
		iigh.InformationErrorFileUpload("ElectricityTransmissionLossFactors", xlPathTLF);
		iigh.InformationErrorFileUpload("ElectricityDNOFactors", xlPathDNOFactors);
		iigh.InformationErrorFileUpload("ElectricityDNORAGTimes", xlPathDNORAGTimes);
		iigh.InformationErrorFileUpload("ElectricityConsumptionAdjustment", xlPathConsumptionAdjustment);
		InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
		infoHand.InformationFailedCalculate();
	}
}