//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageCancelledStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC053_Utility_Gas_ReferencePrices_ValidInput_AmberValidation_CancelledImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC053_Utility_Gas_ReferencePrices_ValidInput_AmberValidation_CancelledImport()
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
		ImportPageCancelledStatus importCancel = new ImportPageCancelledStatus(webDriverHandler, prop);
		importCancel.ImportFileCancel("GasReferencePrices",
				"BudgetTestData/Gas/ReferencePrices/PR008_Budget_V3_TC028_Utility_Gas_ReferencePrices_ValidInput_AmberValidation.xlsx");
		importCancel.verifyImport();
	}
}
