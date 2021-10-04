//Meters_Green 		Validation_Green  	 Status:Passed

package com.Budgets.Utility.Electricity.Electricity1;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC001_Utility_Electricity_Meters_ValidInput_GreenValidation extends AbstractTestNg {
	public PR008_Budget_V3_TC001_Utility_Electricity_Meters_ValidInput_GreenValidation() throws IOException {
	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		// budgetPageHandler.waitLoad();
		budgetPageHandler.createBudgetMonthlyElectricity();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		importPageHandler.ImportMeterGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("MeterLocations");
		System.out.println("Meter Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}
}
