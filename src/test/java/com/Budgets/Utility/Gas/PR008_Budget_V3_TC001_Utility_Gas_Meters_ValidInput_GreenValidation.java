//PR8_TC074_BudgetConsole_NewBudgetCreation_Gas_4_4_5    completed Passed

package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC001_Utility_Gas_Meters_ValidInput_GreenValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC001_Utility_Gas_Meters_ValidInput_GreenValidation() throws IOException {
	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		// budgetPageHandler.waitLoad();
		budgetPageHandler.selectFirstBudgetGas();
		ImportPageHandlerGas importPageHandler = new ImportPageHandlerGas(webDriverHandler, prop);
		importPageHandler.ImportMeterGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("MeterLocations");
		System.out.println("\nMeter Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}