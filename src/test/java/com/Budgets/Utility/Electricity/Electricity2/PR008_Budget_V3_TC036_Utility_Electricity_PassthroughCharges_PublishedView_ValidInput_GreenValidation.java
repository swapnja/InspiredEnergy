//Budget_Passthrough CHarges_PublishedView_ Validatin:Green   Status:Passed
package com.Budgets.Utility.Electricity.Electricity2;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC036_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_GreenValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC036_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_GreenValidation()
			throws IOException {

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
		importPageHandler.ImportPublishedViewGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("PassthroughPublished");
		System.out.println("Passthrough Published View Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
