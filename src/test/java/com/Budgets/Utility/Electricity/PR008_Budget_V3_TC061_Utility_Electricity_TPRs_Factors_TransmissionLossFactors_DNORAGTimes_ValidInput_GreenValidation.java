//Budget_TPR_DistributionLossFactor_DNO RAG Times    Validation : Green    Status : Passed
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC061_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_ValidInput_GreenValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC061_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_ValidInput_GreenValidation()
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
		importPageHandler.ImportDNORAGTimesGreenFile();
		WebElement completedImage = importPageHandler.getGreenIcon("DNORAGTimes");
		System.out.println("DNORAGTimes Successful Marked: " + completedImage.isDisplayed());
		importPageHandler.verifyImport();
	}

}
