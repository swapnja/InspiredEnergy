
package com.AutoII;

import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR184_TC02_AutoInstantInsights_SuperUser extends AbstractTestNg{

    public PR184_TC02_AutoInstantInsights_SuperUser() throws IOException {
    }

    @Test
    public void verifySuperUser() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Super users");
        autoInstantInsights.verifySuper();
        autoInstantInsights.switchUser("(Default)");
    }

    @Test
    public void verifyFunctionality() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Super users");
        autoInstantInsights.stop();
        autoInstantInsights.postMessage();
        autoInstantInsights.deleteMessage();
        autoInstantInsights.searchMessage("Testing");
        autoInstantInsights.filterHashtags("bullish");
        autoInstantInsights.filterPeriod("Last 1 month");
        autoInstantInsights.switchUser("(Default)");
    }

    @Test
    public void verifyPeriodAccess() throws IOException {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.switchUser("Super users");
        autoInstantInsights.stop();
        autoInstantInsights.filterPeriod("01/10/2020", "31/12/2020");
        String errorMessage = webDriverHandler.byXpath("*[@id='messageDateError']").getText();
        if (errorMessage.equals("")){
            System.out.println("There is no restriction for Super User.");
        }
        else{
            Assert.fail("Period filter is not working for Super User.");
        }
        autoInstantInsights.switchUser("(Default)");
    }
}
