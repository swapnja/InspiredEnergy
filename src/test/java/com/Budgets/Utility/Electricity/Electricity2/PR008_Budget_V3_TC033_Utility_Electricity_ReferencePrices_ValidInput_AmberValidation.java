//Electricity _ Reference Price _ Amber Validation _ Passed
package com.Budgets.Utility.Electricity.Electricity2;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC033_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC033_Utility_Electricity_ReferencePrices_ValidInput_AmberValidation() throws IOException {

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
		importPageHandler.ImportReferencePriceAmberFile();
		WebElement completedImage = importPageHandler.getGreenIcon("ElectricityReferencePrices");
		System.out.println("Reference Prices Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}

}
