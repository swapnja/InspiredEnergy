//Budget_Passthrough_Charges_Inspired View_Validation: Amber and Red   Status:Passed

package com.Budgets.Utility.Electricity.Electricity2;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC044_Utility_Electricity_PassthroughCharges_InspiredEnergyView_InvalidInput_AmberAndRedVAlidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC044_Utility_Electricity_PassthroughCharges_InspiredEnergyView_InvalidInput_AmberAndRedVAlidation()
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
		importPageHandler.ImportInspiredViewAARFile();
		importPageHandler.verifyImport();
	}

}
