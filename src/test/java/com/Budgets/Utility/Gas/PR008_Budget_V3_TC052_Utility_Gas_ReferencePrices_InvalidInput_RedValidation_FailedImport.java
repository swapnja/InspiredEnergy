//Budget_Electricity_Contract_Reference Price_Validation: Red     Status: passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC052_Utility_Gas_ReferencePrices_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC052_Utility_Gas_ReferencePrices_InvalidInput_RedValidation_FailedImport()
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
		ImportPageFailedStatus importFail = new ImportPageFailedStatus(webDriverHandler, prop);
		importFail.ImportFileFail("GasReferencePrices",
				"BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC027_Utility_Gas_ReferencePrices_InvalidInput_RedValidation.xlsx");
		importFail.verifyImport();
	}
}
