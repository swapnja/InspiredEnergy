package com.Budgets.InitialFlows;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC020_NewBudget_VATEnabled extends AbstractTestNg {

    public PR8_TC020_NewBudget_VATEnabled() throws IOException {
    }

    @Test
    public void VerifyVATEnabled () throws IOException {
        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createBudgetVATElectricity();
        System.out.println("\nBudget created with VAT Enabled for Electricity.");
        if(webDriverHandler.byXpath(prop.getProperty("VATToggleCheck")).isSelected()){
            System.out.println("\nVAT Toggle is enabled on Information page for Electricity.");
        }
        else {
            Assert.fail("\nVAT Toggle is disabled on Information page for Electricity.");
        }
        goBack();
        budgetPageHandler.createBudgetVATGas();
        System.out.println("\nBudget created with VAT Enabled for Gas.");
        if(webDriverHandler.byXpath(prop.getProperty("VATToggleCheck")).isSelected()){
            System.out.println("\b\nVAT Toggle is enabled on Information page for Gas.");
        }
        else {
            Assert.fail("\nVAT Toggle is disabled on Information page for Gas.");
        }
    }

    public void goBack() throws IOException {
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