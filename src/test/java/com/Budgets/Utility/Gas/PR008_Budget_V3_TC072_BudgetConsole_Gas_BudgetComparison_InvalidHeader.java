//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Base.FIleImportUpload;
import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC072_BudgetConsole_Gas_BudgetComparison_InvalidHeader extends AbstractTestNg {

    public PR008_Budget_V3_TC072_BudgetConsole_Gas_BudgetComparison_InvalidHeader() throws IOException {

    }

    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.waitLoad();
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
    	webDriverHandler.byXpath(prop.getProperty("sortByGas")).click().click();
        webDriverHandler.byXpath(prop.getProperty("FirstGasSummaryCompleted")).click();
        webDriverHandler.byXpath(prop.getProperty("BudgetComparisonTab")).leftPanelclick();
        String xlPathMeter = Paths.get(
                "BudgetTestData/Gas/BudgetComparison/PR8_TC06_BudgetConsole_Gas_BudgetComparison_InvalidHeader.xlsx")
                .toAbsolutePath().toString();
        webDriverHandler.byXpath(prop.getProperty("ImportBtn")).click();
        customersPageHandler.waitLoad();
        FIleImportUpload fim = new FIleImportUpload(driver, xlPathMeter);
        
        System.out.println("Error message for Invalid header validation is:");
        //String strErrortext = webDriverHandler.byXpath("ErrorMsg").waitClickable().waitVisible().getText();
        String strErrortext = webDriverHandler.byId("swal2-content").getText();
       // String strErrortext = webDriverHandler.byXpath(prop.getProperty("ErrorMsg")).waitClickable().getText();
        System.out.println(strErrortext);
        Assert.assertEquals(strErrortext, "Upload template is not valid");
        webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().click();
        System.out.println(strErrortext);
    }
}