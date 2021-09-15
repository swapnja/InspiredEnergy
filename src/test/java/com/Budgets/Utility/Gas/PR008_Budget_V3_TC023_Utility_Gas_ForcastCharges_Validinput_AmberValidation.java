//Budget_Electricity_Forcast Charges_Validation:Amber STatus : Passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC023_Utility_Gas_ForcastCharges_Validinput_AmberValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC023_Utility_Gas_ForcastCharges_Validinput_AmberValidation() throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetGas();
		ImportPageHandlerGas importPageHandler = new ImportPageHandlerGas(webDriverHandler, prop);
		importPageHandler.ImportForcastChargesAmberFile();
		WebElement completedImage = importPageHandler.getGreenIcon("GasForecast");
		System.out.println("Forecast Charges Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
