//Budget_Electricity_Contract Charges_Validation:Red   status:Passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC044_Utility_Gas_ContractCharges_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC044_Utility_Gas_ContractCharges_InvalidInput_RedValidation_FailedImport()
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
		importFailed.ImportFileFail("GasContractCharges",
				"BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC017_Utility_Gas_ContractCharges_InvalidInput_RedValidation.xlsx");
		importFailed.verifyImport();
	}
}
