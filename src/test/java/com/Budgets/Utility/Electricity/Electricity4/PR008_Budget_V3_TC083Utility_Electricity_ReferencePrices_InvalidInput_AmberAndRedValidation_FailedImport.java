//Budget_Electricity_Contract_Reference Price_Validation: Red     Status: Passed

package com.Budgets.Utility.Electricity.Electricity4;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC083Utility_Electricity_ReferencePrices_InvalidInput_AmberAndRedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC083Utility_Electricity_ReferencePrices_InvalidInput_AmberAndRedValidation_FailedImport()
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
		importPageFailedStatusElectricity.ImportFileFail("ElectricityReferencePrices",
				"BudgetTestData/Electricity/ReferencePrices/PR008_Budget_V3_TC092Utility_Electricity_ReferencePrices_InvalidInput_AmberAndRedValidation_FailedImport.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}

}
