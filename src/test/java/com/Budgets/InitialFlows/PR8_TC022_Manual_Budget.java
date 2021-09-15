package com.Budgets.InitialFlows;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC022_Manual_Budget  extends AbstractTestNg {

    CustomersPageHandler customersPageHandler;
    CommonPageHandler budgetPageHandler;

    public PR8_TC022_Manual_Budget() throws IOException {
    }

    @Test
    public void Manual_Electricity (){
        customersPageHandler  = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createManualBudget("Electricity", "15", "54253");
        deleteManual();
    }

    @Test
    public void Manual_Gas (){
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        budgetPageHandler.createManualBudget("Gas", "15", "54253");
        deleteManual();
    }

    @Test
    public void Manual_ElectricityAndGas (){
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        budgetPageHandler.createManualBudget("Electricity and Gas", "15", "54253");
        deleteManual();
    }

    @Test
    public void Manual_Water (){
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        budgetPageHandler.createManualBudget("Water", "15", "54253");
        deleteManual();
    }

    public void deleteManual() {
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        webDriverHandler.byXpath(prop.getProperty("GoBack")).waitClickable().click();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        webDriverHandler.byXpath(prop.getProperty("MyBudgets")).click();
        webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        if(webDriverHandler.byXpath("//tr[td/text() = 'Manual']//button[@title='Delete']").notPresent()){
            webDriverHandler.byXpath("//th[text() = 'Created Date']").click();
            webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
        }
        webDriverHandler.byXpath("//tr[td/text() = 'Manual']//button[@title='Delete']").click();
        webDriverHandler.byXpath("//*[contains(text(), 'Yes')]").click();
    }
}
