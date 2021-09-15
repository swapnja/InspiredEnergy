package com.Budgets.InitialFlows;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC019_Verify_New_Budget_My_Budget extends AbstractTestNg {
    public PR8_TC019_Verify_New_Budget_My_Budget() throws IOException {
    }

    @Test
    public void NewBudgetinMyBudget () {
        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createBudgetMonthlyElectricity();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        String newEntry = webDriverHandler.byXpath("//*[@id=\"Reference\"]").getAttribute("value");
        goBack();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        webDriverHandler.byXpath(prop.getProperty("GoBack")).waitClickable().click();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        webDriverHandler.byXpath(prop.getProperty("MyBudgets")).click();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        webDriverHandler.byXpath("//th[text() = 'Created Date']").click();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        String MyBudgetEntry = webDriverHandler.byXpath("//*[@id=\"budgetTable\"]//td[5]").getText();
        if (newEntry.contains(MyBudgetEntry))
        {
            System.out.println("The newly created budget is reflected in My Budgets.");
        }
        else
            {
                Assert.fail("The newly created budget is not present in My Budgets.");
            }
    }

    public void goBack() {
        do{
            try{
                webDriverHandler.byXpath(prop.getProperty("GoBack")).waitClickable().click();
            }
            catch (Exception e){
                webDriverHandler.byXpath(prop.getProperty("GoBack")).waitClickable().click();
            }
        }
        while (!(driver.getTitle().equals("Customer Budgets - Unify")));
    }
}