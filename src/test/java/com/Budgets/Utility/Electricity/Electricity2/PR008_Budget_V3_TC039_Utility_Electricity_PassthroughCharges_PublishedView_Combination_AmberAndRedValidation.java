//Budget_Passthrough Chatges_Published View  Validation:AAR  Status:Passed

package com.Budgets.Utility.Electricity.Electricity2;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC039_Utility_Electricity_PassthroughCharges_PublishedView_Combination_AmberAndRedValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC039_Utility_Electricity_PassthroughCharges_PublishedView_Combination_AmberAndRedValidation()
			throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetElectricity();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		importPageHandler.ImportPublishedViewAARFile();
		importPageHandler.verifyImport();
	}

}
