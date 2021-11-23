package com.AutoII;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.AbstractTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR184_TC04_AutoInstantInsights_PassiveUser extends AbstractTestNg{

    public PR184_TC04_AutoInstantInsights_PassiveUser() throws IOException {
    }

    @Test
    public void verifyPassiveUser() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Passive Users");
        autoInstantInsights.verifyPassive();
        autoInstantInsights.switchUser("(Default)");
    }

    @Test
    public void verifyFunctionality() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Passive Users");
        autoInstantInsights.stop();
        autoInstantInsights.filterPeriod("Last 1 month");
        autoInstantInsights.searchMessage("Testing");
        autoInstantInsights.filterHashtags("bullish");
        autoInstantInsights.switchUser("(Default)");
    }

    @Test
    public void verifyPeriodAccess() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Passive Users");
        autoInstantInsights.stop();
        autoInstantInsights.filterPeriod("01/09/2020", "31/12/2020");
        String errorMessage = webDriverHandler.byXpath("*[@id='messageDateError']").getText();
        if (errorMessage.equals("Please get in touch with us using the \"message box\" below if you wish to access messages older than 1 month")){
            System.out.println("Active user is restricted to 2 weeks of messages.");
        }
        else{
            Assert.fail("Period filter is not working for Active User.");
        }
        autoInstantInsights.switchUser("(Default)");
    }
}
