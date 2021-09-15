//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC123_BudgetConsole_Electricity_InformationTab_ConditionalInput_Amber extends AbstractTestNg {

	public PR008_Budget_V3_TC123_BudgetConsole_Electricity_InformationTab_ConditionalInput_Amber() throws IOException
	{
		
	}
	
	
@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
	String xlPathMeter = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/Meter_Amber.xlsx").toAbsolutePath().toString();
	String xlPathConsumption = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/Consumption_Amber.xlsx").toAbsolutePath().toString();
	String xlPathRTB= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/RateTimeBand_Amber.xlsx").toAbsolutePath().toString();
	String xlPathKVA= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/KVA_Amber.xlsx").toAbsolutePath().toString();
	String xlPathContractCharges= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/ContractCharges_Amber.xlsx").toAbsolutePath().toString();
	String xlPathReference= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/ReferencePrices_Amber.xlsx").toAbsolutePath().toString();
	String xlPathPublishedView= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/PublishedView_Amber.xlsx").toAbsolutePath().toString(); 
	String xlPathInspiredEnergyView= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/InspiredEnergyView_Amber.xlsx").toAbsolutePath().toString();
	String xlPathTLF= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/TLF_Amber.xlsx").toAbsolutePath().toString();
	String xlPathDNOFactors= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/DNOFactors_Amber.xlsx").toAbsolutePath().toString();
	String xlPathDNORAGTimes= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/DNORAGTimes_Amber.xlsx").toAbsolutePath().toString();
	String xlPathConsumptionAdjustment= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Amber/ConsumptionAdjustment_Amber.xlsx").toAbsolutePath().toString();

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
	iigh.InformationImportFileUpload("ElectricityInspiredEnergyView", xlPathInspiredEnergyView);
	iigh.InformationImportFileUpload("ElectricityTransmissionLossFactors", xlPathTLF);
	iigh.InformationImportFileUpload("ElectricityDNOFactors", xlPathDNOFactors);
	iigh.InformationImportFileUpload("ElectricityDNORAGTimes", xlPathDNORAGTimes);
	iigh.InformationImportFileUpload("ElectricityConsumptionAdjustment", xlPathConsumptionAdjustment);
	InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
	infoHand.InformationVerifyCalculate();
	
	}

}