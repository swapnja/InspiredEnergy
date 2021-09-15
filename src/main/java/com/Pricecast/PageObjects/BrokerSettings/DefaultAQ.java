package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;

import java.util.Properties;

public class DefaultAQ {
	Properties prop;
	private WebDriverHandler _webDriverHandler;
//Default AQ	
	ElementHandler txtBoxDefaultAQDescription = _webDriverHandler.byXpath("//*[@id='Description']");
	ElementHandler txtBoxDefaultAQMaxVol = _webDriverHandler.byXpath("//*[@id='MaxAQ']");
	ElementHandler txtBoxDefaultAQMinVol = _webDriverHandler.byXpath("//*[@id='MinAQ']");
	ElementHandler txtBoxDefaultAQDefaultVol = _webDriverHandler.byXpath("//*[@id='DefaultAQ']");
		
	public String[] tblDefaultAQ = new String[] { "Description","Min AQ","Max AQ","Default AQ","Actions" };
	public ElementHandler[] arrDefaultAQ = new ElementHandler[5];

	public DefaultAQ() {
		for(int i = 0 ; i < arrDefaultAQ.length ; i++) {
			arrDefaultAQ[i] = _webDriverHandler.byXpath("//table[@id='tblDefaultAQ']/thead/tr/th[" + (i + 1) + "]");			
			if(tblDefaultAQ.equals(arrDefaultAQ[i]))
			{
				System.out.println("Column names are matched");
			}			 
		}
	}

}
