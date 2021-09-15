//Verify Consumption tab : Green validation : Pass
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageCancelledStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC077_Utility_Electricity_KVArh_ValidInput_GreenValidation_CancelledImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC077_Utility_Electricity_KVArh_ValidInput_GreenValidation_CancelledImport()
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
		importPageCancelledStatusElectricity.ImportFileCancel("ElectricityKVArh",
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC016_Utility_Electricity_KVArh_ValidInput_GreenValidation.xlsx");
		importPageCancelledStatusElectricity.verifyImport();
	}

}
