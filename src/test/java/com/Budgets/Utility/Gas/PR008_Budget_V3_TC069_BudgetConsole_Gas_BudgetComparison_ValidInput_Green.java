//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ElectricitySummaryComparison;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC069_BudgetConsole_Gas_BudgetComparison_ValidInput_Green extends AbstractTestNg {
    public PR008_Budget_V3_TC069_BudgetConsole_Gas_BudgetComparison_ValidInput_Green() throws IOException {

    }

    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
	CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
	customersPageHandler.waitLoad();
	customersPageHandler.filterCustomers("Automation");
	customersPageHandler.selectFirstCustomer();
	webDriverHandler.byXpath(prop.getProperty("FirstGasSummaryCompleted")).click();
	webDriverHandler.byXpath(prop.getProperty("BudgetComparisonTab")).leftPanelclick();
	ElectricitySummaryComparison summaryComp = new ElectricitySummaryComparison(webDriverHandler, prop);
	summaryComp.ImportGreenFile(
		"BudgetTestData/Gas/BudgetComparison/PR8_TC04_BudgetConsole_Gas_BudgetComparison_ValidInput_Green.xlsx");
	summaryComp.filterImportBC();

    }

}