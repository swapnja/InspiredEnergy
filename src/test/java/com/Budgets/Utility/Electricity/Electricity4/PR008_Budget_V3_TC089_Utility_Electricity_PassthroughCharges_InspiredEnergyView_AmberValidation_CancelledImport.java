//Budget_PassthroughCHarges_InspiredEnergy_Validation:Amber  Status:Passed
package com.Budgets.Utility.Electricity.Electricity4;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageCancelledStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC089_Utility_Electricity_PassthroughCharges_InspiredEnergyView_AmberValidation_CancelledImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC089_Utility_Electricity_PassthroughCharges_InspiredEnergyView_AmberValidation_CancelledImport()
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
		ImportPageCancelledStatus importPageCancelledStatusElectricity = new ImportPageCancelledStatus(webDriverHandler,
				prop);
		importPageCancelledStatusElectricity.ImportFileCancel("ElectricityInspiredEnergyView",
				"BudgetTestData/Electricity/InspiredEnergyView/PR008_Budget_V3_TC099_Utility_Electricity_PassthroughCharges_InspiredEnergyView_AmberValidation_CancelledImport.xlsx");
		importPageCancelledStatusElectricity.verifyImport();
	}

}
