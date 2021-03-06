//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Electricity.Electricity5;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ElectricitySummaryComparison;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC118_BudgetConsole_Electricity_BudgetComparison_InvalidInput_Red extends AbstractTestNg {

    public PR008_Budget_V3_TC118_BudgetConsole_Electricity_BudgetComparison_InvalidInput_Red() throws IOException {

    }

    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
	CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
	customersPageHandler.waitLoad();
	customersPageHandler.filterCustomers("Automation");
	customersPageHandler.selectFirstCustomer();
	webDriverHandler.byXpath(prop.getProperty("FirstElectricityCompleted")).click();
	webDriverHandler.byXpath(prop.getProperty("BudgetComparisonTab")).leftPanelclick();
	ElectricitySummaryComparison summaryComp = new ElectricitySummaryComparison(webDriverHandler, prop);
	summaryComp.ImportRedFile("BudgetTestData/Electricity/BudgetComparison/PR8_TC080_BudgetConsole_BudgetComparison_InvalidInput_Red.xlsx");
	summaryComp.filterImportBC();
    }
}