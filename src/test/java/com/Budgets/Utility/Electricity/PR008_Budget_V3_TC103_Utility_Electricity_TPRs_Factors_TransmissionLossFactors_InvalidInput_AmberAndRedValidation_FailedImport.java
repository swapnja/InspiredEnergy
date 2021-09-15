// TLF  AAR  Validation:AAR                   Status:Passed 

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC103_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_AmberAndRedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC103_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_AmberAndRedValidation_FailedImport()
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
		importPageFailedStatusElectricity.ImportFileFail("ElectricityTransmissionLossFactors",
				"BudgetTestData/Electricity/TransmissionLossFactors/PR008_Budget_V3_TC107_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_InvalidInput_AmberAndRedValidation_FailedImport.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}

}
