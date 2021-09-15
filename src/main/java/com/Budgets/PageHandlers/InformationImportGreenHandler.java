package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;

import java.nio.file.Paths;
import java.util.Properties;


public class InformationImportGreenHandler {
	WebDriverHandler _webDriverHandler;
	Properties _prop;
	
	
	public InformationImportGreenHandler(WebDriverHandler webDriverHandler, Properties prop) {
		_webDriverHandler = webDriverHandler;
		_prop = prop;
		
	}
	public void ImportGreenFileUpload(String section, String path) throws InterruptedException
    {
        _webDriverHandler.byXpath(_prop.getProperty(section)).waitClickable(12, 100).click();
        String filePath = Paths.get(path).toAbsolutePath().toString();
        ImportPageHandlerElectricity iphe = new ImportPageHandlerElectricity(_webDriverHandler, _prop);
        iphe.genericImport(filePath);
        iphe.importUpload();
     }
	public void InformationCalculate(){
		_webDriverHandler.byXpath(_prop.getProperty("Information")).click();
		_webDriverHandler.byXpath(_prop.getProperty("SaveInformation")).click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).click();
		 String ExpCalBtn="Calculate";
		 String ActCalBtn=_webDriverHandler.byXpath(_prop.getProperty("Calculate")).getText();
		 if(ExpCalBtn.contentEquals(ActCalBtn)) {
			 System.out.println("Calculate button is present on the screen"); 
			 } else
			 {
			 System.out.println("Mandatory import files are missing");
			 }
		_webDriverHandler.byXpath(_prop.getProperty("Calculate")).click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).click();
	}
	}
	
	
	
