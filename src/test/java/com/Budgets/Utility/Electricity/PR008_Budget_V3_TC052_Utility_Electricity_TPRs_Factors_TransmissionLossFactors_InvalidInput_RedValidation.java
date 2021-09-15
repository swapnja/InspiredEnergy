// //Budget_TPR_Transmission Factor    Validation:Invalid Input Red       Status: Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC052_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_RedValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC052_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_RedValidation()
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
		importPageHandler.ImportTransmissionLossFactorsRedFile();
		importPageHandler.verifyImport();
	}

}
