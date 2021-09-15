//package com.AutoII;
//
//import com.Base.SeleniumHandlers.WebDriverHandler;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class PR184_TC03_AutoInstantInsights_ActiveUser extends AbstractTestNg {
//
//    public PR184_TC03_AutoInstantInsights_ActiveUser() throws IOException {
//    }
//
//    @Test
//    public void verifyActiveUser() throws IOException {
//        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
//        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
//        autoInstantInsights.switchUser("Active Users");
//        autoInstantInsights.verifyActive();
//        autoInstantInsights.switchUser("(Default)");
//    }
//
//    @Test
//    public void verifyFunctionality() throws IOException {
//        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
//        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
//        autoInstantInsights.switchUser("Active Users");
//        autoInstantInsights.stop();
//        autoInstantInsights.sendMessage();
//        autoInstantInsights.filterPeriod("Last 14 days");
//        autoInstantInsights.sendReply();
//        autoInstantInsights.searchMessage("Testing");
//        autoInstantInsights.filterHashtags("bullish");
//        autoInstantInsights.switchUser("(Default)");
//    }
//
//    @Test
//    public void verifyPeriodAccess() throws IOException {
//        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
//        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
//        autoInstantInsights.switchUser("Active Users");
//        autoInstantInsights.stop();
//        autoInstantInsights.filterPeriod("01/10/2020", "31/12/2020");
//        String errorMessage = webDriverHandler.byXpath("//*[@id='messageDateError']").getText();
//        if (errorMessage.equals("Please get in touch with us using the \"message box\" below if you wish to access messages older than 2 weeks")){
//            System.out.println("Active user is restricted to 2 weeks of messages.");
//        }
//        else{
//            Assert.fail("Period filter is not working for Active User.");
//        }
//        autoInstantInsights.switchUser("(Default)");
//    }
//}
