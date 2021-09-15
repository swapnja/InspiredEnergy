//Budget_Electricity_Forcast Charges_Validation:Red   status:Passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC048_Utility_Gas_ForcastCharges_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC048_Utility_Gas_ForcastCharges_InvalidInput_RedValidation_FailedImport()
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
		importFail.ImportFileFail("GasForcastCharges",
				"BudgetTestData/Gas/ForcastCharges/PR008_Budget_V3_TC022_Utility_Gas_ForcastCharges_InvalidInput_RedValidation.xlsx");
		importFail.verifyImport();
	}

}
