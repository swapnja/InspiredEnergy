//Verify Information tab on Budget Console Screen 

package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC061_BudgetConsole_Gas_InformationTab_Calculate_AmberValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC061_BudgetConsole_Gas_InformationTab_Calculate_AmberValidation() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		String xlPathMeter = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/Meter_Amber.xlsx").toAbsolutePath().toString();
		String xlPathConsumption = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/Consumption_Amber.xlsx").toAbsolutePath().toString();
		String xlPathRTB = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/RateTimeBand_Amber.xlsx").toAbsolutePath().toString();
		String xlPathContractCharges = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/ContractCharges_Amber.xlsx").toAbsolutePath().toString();
		String xlPathReference = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/ReferencePrices_Amber.xlsx").toAbsolutePath().toString();
		String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Gas/Information/InformationTab_Amber/ConsumptionAdjustment_Amber.xlsx").toAbsolutePath().toString();
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.createBudgetMonthlyGas();
		InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
		iigh.InformationImportFileUpload("GasMeters", xlPathMeter);
		iigh.InformationImportFileUpload("GasConsumption", xlPathConsumption);
		iigh.InformationImportFileUpload("GasRateTimeBands", xlPathRTB);
		iigh.InformationImportFileUpload("GasContractCharges", xlPathContractCharges);
		iigh.InformationImportFileUpload("GasReferencePrices", xlPathReference);
		iigh.InformationImportFileUpload("GasConsumptionAdjustment", xlPathConsumptionAdjustment);
		InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
		infoHand.InformationVerifyCalculate();
		infoHand.InformationTotalCalculate();
	}
}