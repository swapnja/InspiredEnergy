//Budget_    Gas		Reference Price_					Validation: Red  				   Status: passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC027_Utility_Gas_ReferencePrices_InvalidInput_RedValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC027_Utility_Gas_ReferencePrices_InvalidInput_RedValidation() throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetGas();
		ImportPageHandlerGas importPageHandler = new ImportPageHandlerGas(webDriverHandler, prop);
		importPageHandler.ImportReferencePriceRedFile();
		importPageHandler.verifyImport();
	}

}
