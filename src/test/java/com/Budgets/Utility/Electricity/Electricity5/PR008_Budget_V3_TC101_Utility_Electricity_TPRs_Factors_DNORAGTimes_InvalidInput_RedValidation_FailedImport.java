//Budget_TPR factors _Validation   DNO RAG Times  Status: Red: Passed
package com.Budgets.Utility.Electricity.Electricity5;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC101_Utility_Electricity_TPRs_Factors_DNORAGTimes_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC101_Utility_Electricity_TPRs_Factors_DNORAGTimes_InvalidInput_RedValidation_FailedImport()
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
		importPageFailedStatusElectricity.ImportFileFail("ElectricityDNORAGTimes",
				"BudgetTestData/Electricity/DNORAGTimes/PR008_Budget_V3_TC112_Utility_Electricity_TPRs_Factors_DNORAGTimes_InvalidInput_RedValidation_FailedImport.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}

}
