package com.Budgets.InitialFlows;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC021_Enable_VAT_InformationPage extends AbstractTestNg {
    public PR8_TC021_Enable_VAT_InformationPage() throws IOException {
    }

   @Test
   public void VerifyVATEnabled () throws InterruptedException {
  /*
	   CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createBudgetMonthlyElectricity();
        if(webDriverHandler.byXpath(prop.getProperty("VATToggleCheck")).isSelected()){
            System.out.println("\nVAT Toggle is enabled on Information page.");
            Assert.fail("VAT should not be Enabled.");
        }
        else {
            System.out.println("\nVAT Toggle is disabled for this Electricity budget.");
        }
        waitToggle();
        webDriverHandler.byXpath(prop.getProperty("SaveInformation")).click();
        webDriverHandler.byXpath(prop.getProperty("OkInformation")).waitClickable().click();
        System.out.println("\nVAT Toggle is now enabled for this Electricity budget from Information page.");
        webDriverHandler.byXpath(prop.getProperty("GoBack")).click();
        budgetPageHandler.createBudgetMonthlyGas();
        if(webDriverHandler.byXpath(prop.getProperty("VATToggleCheck")).isSelected()){
            System.out.println("\nVAT Toggle is enabled on Information page.");
            Assert.fail("VAT should not be Enabled.");
        }
        else {
            System.out.println("\nVAT Toggle is disabled for this Gas budget.");
        }
        waitToggle();
        webDriverHandler.byXpath(prop.getProperty("SaveInformation")).click();
        webDriverHandler.byXpath(prop.getProperty("OkInformation")).waitClickable().click();
        System.out.println("\nVAT Toggle is now enabled for this Gas budget from Information page.");
    }

    public void waitToggle() throws InterruptedException {
        String stringRef = webDriverHandler.byXpath(prop.getProperty("Reference")).getText();
        String stringSD = webDriverHandler.byXpath(prop.getProperty("StartDate")).getText();
        String stringED = webDriverHandler.byXpath(prop.getProperty("EndDate")).getText();

        webDriverHandler.byXpath(prop.getProperty("Reference")).staleElementHandler().sendKeys(stringRef);
        webDriverHandler.byXpath(prop.getProperty("Reference")).waitClickable().sendKeys(stringRef);
        webDriverHandler.byXpath(prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
        webDriverHandler.byXpath(prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
        webDriverHandler.byXpath(prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
        webDriverHandler.byXpath(prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
        webDriverHandler.byXpath(prop.getProperty("CalendarOutput")).waitClickable().selectByText("Custom");
        webDriverHandler.byXpath(prop.getProperty("CalendarOutput")).waitClickable().selectByText("Monthly");

        do {
        	//webDriverHandler.byXpath(prop.getProperty("VATToggle")).waitClickable().click();
        	webDriverHandler.byXpath(prop.getProperty("VATToggle")).staleElementHandler().click();
        }
                while (!(webDriverHandler.byXpath(prop.getProperty("VATToggleCheck")).isSelected()));
    }*/
   }
}