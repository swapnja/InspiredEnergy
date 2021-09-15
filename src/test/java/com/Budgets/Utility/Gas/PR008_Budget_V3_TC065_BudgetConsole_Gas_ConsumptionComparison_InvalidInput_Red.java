//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ElectricitySummaryComparison;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC065_BudgetConsole_Gas_ConsumptionComparison_InvalidInput_Red extends AbstractTestNg {

    public PR008_Budget_V3_TC065_BudgetConsole_Gas_ConsumptionComparison_InvalidInput_Red() throws IOException {

    }

    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.waitLoad();
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        webDriverHandler.byXpath(prop.getProperty("FirstGasSummaryCompleted")).click();
        webDriverHandler.byXpath(prop.getProperty("ConsumptionComparisonTab")).leftPanelclick();
        ElectricitySummaryComparison summaryComp = new ElectricitySummaryComparison(webDriverHandler, prop);
        summaryComp.ImportRedFile(
                "BudgetTestData/Gas/ConsumptionComparison/PR8_TC02_BudgetConsole_Gas_ConsumptionComparison_InvalidInput_Red.xlsx");
        summaryComp.filterImportCC();
    }

}