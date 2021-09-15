//Electricity TPRS and Fcators  DNO RAG Times  Validation: Invalid Header   Status : Passed

package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC065_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_InvalidHeader extends AbstractTestNg {

	public PR008_Budget_V3_TC065_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_InvalidHeader() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.createBudgetMonthlyElectricity();
		webDriverHandler.byXpath(prop.getProperty("ElectricityDNORAGTimes")).leftPanelclick();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		String path = Paths.get("BudgetTestData/Electricity/DNORAGTimes/PR008_Budget_V3_TC065_Utility_Electricity_TPRs_Factors_TransmissionLossFactors_DNORAGTimes_InvalidHeader.xlsx").toAbsolutePath()
				.toString();
		importPageHandler.genericImport(path);
		System.out.println("*************************************");
		System.out.println("Error message for Invalid header validation is:");
		String strErrortext = webDriverHandler.byId("swal2-content").waitClickable().waitVisible().getText();
		Assert.assertEquals(strErrortext, "Upload template is not valid");
		webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().click();
		System.out.println(strErrortext);
	}
}
