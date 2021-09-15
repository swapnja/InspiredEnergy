//Electricity   Validation:Red   Status:Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageFailedStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC067_Utility_Electricity_Meters_InvalidInput_RedValidation_FailedImport
		extends AbstractTestNg {

	public PR008_Budget_V3_TC067_Utility_Electricity_Meters_InvalidInput_RedValidation_FailedImport()
			throws IOException {
	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.waitLoad();
		budgetPageHandler.selectFirstBudgetElectricity();
		ImportPageFailedStatus importPageFailedStatusElectricity = new ImportPageFailedStatus(webDriverHandler, prop);
		importPageFailedStatusElectricity.ImportFileFail("ElectricityMeters",
				"BudgetTestData/Electricity/Meters/PR008_Budget_V3_TC067_Utility_Electricity_Meters_InvalidInput_RedValidation_FailedImport.xlsx");
		importPageFailedStatusElectricity.verifyImport();
	}
}
