//Budget_TPR_RateTImeBAnd_Amber- No AMber validation   passed    Either remove this test case or implement some other functionality
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC053_Electricity_ConsumptionAdjusment_Green extends AbstractTestNg {

	public PR008_Budget_V3_TC053_Electricity_ConsumptionAdjusment_Green() throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetElectricity();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		importPageHandler.ImportConsumptionAdjustmentGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("ConsumptionAdjustment");
		System.out.println("Consumption Adjustment Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
