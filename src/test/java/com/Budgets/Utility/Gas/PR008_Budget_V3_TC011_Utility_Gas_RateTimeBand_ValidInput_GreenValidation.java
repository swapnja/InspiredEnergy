//Verify Rate time bands tab :  validation :Green     Status: Pass
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC011_Utility_Gas_RateTimeBand_ValidInput_GreenValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC011_Utility_Gas_RateTimeBand_ValidInput_GreenValidation() throws IOException {

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
		importPageHandler.ImportRateTimeBandGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("RateTimeBands");
		System.out.println("Rate Time Bands Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
