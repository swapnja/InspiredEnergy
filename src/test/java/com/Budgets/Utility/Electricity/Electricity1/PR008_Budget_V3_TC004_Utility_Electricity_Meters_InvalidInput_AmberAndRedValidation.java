//Meters_AAR_ 21Oct 2019_ Completed

package com.Budgets.Utility.Electricity.Electricity1;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC004_Utility_Electricity_Meters_InvalidInput_AmberAndRedValidation extends AbstractTestNg {
	public PR008_Budget_V3_TC004_Utility_Electricity_Meters_InvalidInput_AmberAndRedValidation() throws IOException {
	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.createBudgetMonthlyElectricity();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		importPageHandler.ImportMeterAARFile();
		importPageHandler.verifyImport();	}
}
