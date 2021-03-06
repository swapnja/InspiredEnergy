//Electricity  Validation : Invalid header   Status:Passed

package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerGas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC020_Utility_Gas_ContractCharges_InvalidHeader extends AbstractTestNg {

	public PR008_Budget_V3_TC020_Utility_Gas_ContractCharges_InvalidHeader() throws IOException {
	}

	@Test
	public void newBudget() throws InterruptedException, IOException {
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetGas();
		webDriverHandler.byXpath(prop.getProperty("GasContractCharges")).leftPanelclick();
		ImportPageHandlerGas importPageHandler = new ImportPageHandlerGas(webDriverHandler, prop);
		String path = Paths.get("BudgetTestData/Gas/ContractCharges/PR008_Budget_V3_TC020_Utility_Gas_ContractCharges_InvalidHeader.xlsx").toAbsolutePath().toString();
		importPageHandler.genericImport(path);
		System.out.println("*************************************");
		System.out.println("Error message for Invalid header validation is:");
		String strErrortext = webDriverHandler.byId("swal2-content").waitClickable().waitVisible().getText();
		Assert.assertEquals(strErrortext, "Upload template is not valid");
		webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().click();
		System.out.println(strErrortext);
	}
}
