//Meters_Amber Validation_21Oct2019_Completed

package com.Budgets.Utility.Electricity.Electricity1;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC003_Utility_Electricity_Meters_ValidInput_AmberValidation extends AbstractTestNg {

	public PR008_Budget_V3_TC003_Utility_Electricity_Meters_ValidInput_AmberValidation() throws IOException {
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
		importPageHandler.ImportMeterAmberFile();
		WebElement completedImage = importPageHandler.getGreenIcon("MeterLocations");
		System.out.println("Meter Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
