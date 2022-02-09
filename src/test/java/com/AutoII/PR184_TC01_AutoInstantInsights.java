//this is commit from eclipse
package com.AutoII;

import org.testng.annotations.Test;

import com.Base.ChromeDriverOptions;

import java.io.IOException;

public class PR184_TC01_AutoInstantInsights extends AbstractTestNg{
	
    public PR184_TC01_AutoInstantInsights() throws IOException {
     //	ChromeDriverOptions.getHeadlessBrowser();
    }

    @Test
    public void verifyAutoII() throws IOException {
   
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.verifyAutoII();
        autoInstantInsights.verifyPostModal();
    }

    @Test
    public void verifyFunctionality() throws IOException {
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.filterHashtags("bullish");
        autoInstantInsights.postMessage();
        //To Reset hashtag filter
        autoInstantInsights.filterHashtags("bullish");
        autoInstantInsights.verifyNewHashtag("automation");
        autoInstantInsights.deleteMessage();
        autoInstantInsights.searchMessage("Testing");
        autoInstantInsights.clearMessageFilter();
        autoInstantInsights.filterPeriod("Last 3 days");
        autoInstantInsights.filterPeriod("10/09/2020","15/10/2020");
    }

    @Test
    public void errorValidation() throws IOException {
        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
        autoInstantInsights.errorValidations();
    }
    
    //[TestResult name=errorValidation status=SUCCESS method=PR184_TC01_AutoInstantInsights.errorValidation
    	//	[pri:0, instance:com.AutoII.PR184_TC01_AutoInstantInsights@1984b1f] output={null}]  (0 s)
    

//    @Test
//    public void imageCheck() throws IOException {
//        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
//        AutoInstantInsights autoInstantInsights = new AutoInstantInsights(webDriverHandler);
//        autoInstantInsights.postMessage();
//        Assert.fail("Not Null");
//    }
}