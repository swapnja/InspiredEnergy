//Verify Consumption tab on Budget Console Screen: Red : Failed 
package com.Budgets.Utility.Electricity.Electricity3;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC067_Utility_Electricity_RateTimeBands_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC067_Utility_Electricity_RateTimeBands_InvalidInput_RedValidation_FailedImport()
			throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.waitLoad();
		budgetPageHandler.selectFirstBudgetElectricity();
		ImportPageFailedStatus importPageFailedStatusElectricity = new ImportPageFailedStatus(webDriverHandler, prop);
		importPageFailedStatusElectricity.ImportFileFail("ElectricityRateTimeBands",
				"BudgetTestData/Electricity/RateTimeBands/PR008_Budget_V3_TC012_Utility_Electricity_RateTimeBand_ValidInput_RedValidation.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}
}