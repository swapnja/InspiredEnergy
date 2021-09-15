//Budget_Electricity_Forcast Charges_Validation:AAR   status: Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC088_Utility_Electricity_ForcastCharges_InvalidInput_AmberAndRedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC088_Utility_Electricity_ForcastCharges_InvalidInput_AmberAndRedValidation_FailedImport()
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
		importPageFailedStatusElectricity.ImportFileFail("ElectricityForcastCharges",
				"BudgetTestData/Electricity/ForcastCharges/PR008_Budget_V3_TC029_Utility_Electricity_ForcastCharges_InvalidInput_AmberAndRedValidation.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}
}
