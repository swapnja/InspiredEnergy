//Budget_ElectricityContract_Contract Charges_Status:Passed  invalid validation
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageCancelledStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC043_Utility_Gas_ContractCharges_ValidInput_GreenValidation_CancelledImport
		extends AbstractTestNg {
	public PR008_Budget_V3_TC043_Utility_Gas_ContractCharges_ValidInput_GreenValidation_CancelledImport()
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
		importCancel.ImportFileCancel("GasContractCharges",
				"BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC016_Utility_Gas_ContractCharges_ValidInput_GreenValidation.xlsx");
		importCancel.verifyImport();
	}

}
