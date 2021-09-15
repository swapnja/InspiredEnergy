//RTB   Red  Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC113_BudgetConsole_Electricity_InformationTab_Calculate_RedValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC113_BudgetConsole_Electricity_InformationTab_Calculate_RedValidation() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		String xlPathMeter = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/Meter_Red.xlsx").toAbsolutePath().toString();
		String xlPathConsumption = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/Consumption_Red.xlsx").toAbsolutePath().toString();
		String xlPathRTB = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/RateTimeBand_Red.xlsx").toAbsolutePath().toString();
		String xlPathKVA = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/KVA_Red.xlsx").toAbsolutePath().toString();
		String xlPathContractCharges = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/ContractCharges_Red.xlsx").toAbsolutePath().toString();
		String xlPathReference = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/ReferencePrices_Red.xlsx").toAbsolutePath().toString();
		String xlPathPublishedView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/PublishedView_Red.xlsx").toAbsolutePath().toString();
		String xlPathInspiredEnergyView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/InspiredEnergyView_Red.xlsx").toAbsolutePath().toString();
		String xlPathTLF = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/TLF_Red.xlsx").toAbsolutePath().toString();
		String xlPathDNOFactors = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/DNOFactors_Red.xlsx").toAbsolutePath().toString();
		String xlPathDNORAGTimes = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/DNORAGTimes_Red.xlsx").toAbsolutePath().toString();
		String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/ConsumptionAdjustment_Red.xlsx").toAbsolutePath().toString();
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
		System.out.println("TC2");
	}
}