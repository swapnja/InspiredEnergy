//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Electricity.Electricity4;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageCancelledStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC082_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation_CancelledImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC082_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation_CancelledImport()
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
		importPageCancelledStatusElectricity.ImportFileCancel("ElectricityReferencePrices",
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC091_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation_CancelledImport.xlsx");
		importPageCancelledStatusElectricity.verifyImport();
	}

}
