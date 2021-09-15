//Verify Gas COntract Charges : Red Validation status:  Passed
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC056_Utility_Gas_ConsumptionAdjustment_InvalidInput_Red extends AbstractTestNg {

	public PR008_Budget_V3_TC056_Utility_Gas_ConsumptionAdjustment_InvalidInput_Red() throws IOException {

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
		importPageHandler.ImportConsumptionAdjustmentRedFile();
		WebElement completedImage = importPageHandler.getGreenIcon("ConsumptionAdjustment");
		System.out.println("Meter Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
