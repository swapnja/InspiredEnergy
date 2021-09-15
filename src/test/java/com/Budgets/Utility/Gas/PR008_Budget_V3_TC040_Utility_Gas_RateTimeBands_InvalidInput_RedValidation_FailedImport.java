//Verify Consumption tab on Budget Console Screen: Red : Failed 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC040_Utility_Gas_RateTimeBands_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC040_Utility_Gas_RateTimeBands_InvalidInput_RedValidation_FailedImport()
			throws IOException {

	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetGas();
		ImportPageFailedStatus importFailed = new ImportPageFailedStatus(webDriverHandler, prop);
		importFailed.ImportFileFail("GasRateTimeBands",
				"BudgetTestData/Gas/RateTimeBands/PR008_Budget_V3_TC012_Utility_Gas_RateTimeBands_InvalidInput_RedValidation.xlsx");
		importFailed.verifyImport();
	}
}
