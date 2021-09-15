//Budget_Passthough_Published View_Validation_ Validation: Amber  Status:Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC038_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_AmberValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC038_Utility_Electricity_PassthroughCharges_PublishedView_ValidInput_AmberValidation()
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
		importPageHandler.ImportPublishedViewAmberFile();
		WebElement completedImage = importPageHandler.getGreenIcon("PassthroughPublished");
		System.out.println("Passthrough Published View Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
