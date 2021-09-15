package com.Budgets.InitialFlows;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.AbstractTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC018_My_Budgets extends AbstractTestNg {
    public PR8_TC018_My_Budgets() throws IOException {
    }

    @Test
    public void MyBudgets() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        if(webDriverHandler.byXpath(prop.getProperty("MyBudgets")).isDisplayed())
        {
            System.out.println("My Budgets button is visible.");
            webDriverHandler.byXpath(prop.getProperty("Overlay")).waitVisible().waitInvisible();
            webDriverHandler.byXpath(prop.getProperty("MyBudgets")).click();
            String CreatedBy = webDriverHandler.byXpath(prop.getProperty("BudgetCreatedBy")).getText();
            if (CreatedBy.equalsIgnoreCase(prop.getProperty("value.AdminUser"))){
                System.out.println("\nThe data of the page is correct");
            }
            else
            {
               Assert.fail("\nThe data of the page is incorrect");
            }
        }
        else
            {
                Assert.fail("\nMy Budgets button is not present.");
            }
    }
}
