//Electricity				Validation:Red   DNO Factors    Status:Passed 
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC97_Utility_Electricity_TPRs_Factors_DNOFactors_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC97_Utility_Electricity_TPRs_Factors_DNOFactors_InvalidInput_RedValidation_FailedImport()
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
		importPageFailedStatusElectricity.ImportFileFail("ElectricityDNOFactors",
				"BudgetTestData/Electricity/DNOFactors/PR008_Budget_V3_TC110_Utility_Electricity_TPRs_Factors_DNOFactors_InvalidInput_RedValidation_FailedImport.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}

}
