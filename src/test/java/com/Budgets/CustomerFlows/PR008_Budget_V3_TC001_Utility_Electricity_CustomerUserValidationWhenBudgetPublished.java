package com.Budgets.CustomerFlows;

import com.Base.AbstractCustomer;
import com.Budgets.PageHandlers.CustomersPageHandler;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PR008_Budget_V3_TC001_Utility_Electricity_CustomerUserValidationWhenBudgetPublished extends AbstractCustomer {

    public PR008_Budget_V3_TC001_Utility_Electricity_CustomerUserValidationWhenBudgetPublished() throws IOException {

    }

    @Test
    public void newBudget() throws IOException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(prop.getProperty("BudgetIcon"))).click();
        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.waitLoad();
    }
}