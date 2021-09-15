//Verify Information tab on Budget Console Screen : InProgress  defect is open
//Need to add below points
//change the value of Period data not numeric to Warning Amber validation once bug resolved
//Add the Upload file code
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC008_Utility_Electricity_Consumption_ValidInput_AmberValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC008_Utility_Electricity_Consumption_ValidInput_AmberValidation() throws IOException {

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
		importPageHandler.ImportConsumptionAmberFile();
		WebElement completedImage = importPageHandler.getGreenIcon("Consumption");
		System.out.println("Consumption Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}

}
