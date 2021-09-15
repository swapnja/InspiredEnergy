
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class ValidationPageHandler {

	private Properties _prop;
	private WebDriverHandler _webDriverHandler;

	public ValidationPageHandler(WebDriverHandler webDriverHandler, Properties prop) {
		_prop = prop;
		_webDriverHandler = webDriverHandler;
	}

	public void GreenValidation(String type, Hashtable<String, String> ht, char Utility) throws IOException {
		String strHeader = _webDriverHandler.byXpath(_prop.getProperty(Utility + "Header" + type)).getText();
		String strGetAttribute = _webDriverHandler.byXpath(_prop.getProperty(Utility + "GreenImage" + type)).getAttribute("Status");
		String strGreenMessage = _webDriverHandler.byXpath(_prop.getProperty(Utility + "GreenMessage" + type)).getText();
		if (ht.containsKey(strHeader) && (ht.get(strHeader).equals(strGetAttribute))) {
			System.out.println("Validation has done successfully for " + strHeader + " and Validation Message is : " + strGreenMessage);
		} else {
			System.out.println(type + "-Condition is getting failed");
		}
	}

	public void RedValidation(String type, Hashtable<String, String> ht, char Utility) throws IOException {
		String strHeader = _webDriverHandler.byXpath(_prop.getProperty(Utility + "Header" + type)).getText();
		String strGetAttribute = _webDriverHandler.byXpath(_prop.getProperty(Utility + "RedImage" + type)).getAttribute("Status");
		String strRedMessage = _webDriverHandler.byXpath(_prop.getProperty(Utility + "RedMessage" + type)).getText();
		if (ht.containsKey(strHeader) && (ht.get(strHeader).equals(strGetAttribute))) {
			System.out.println("Validation has done successfully for " + strHeader + " and Validation Message is : " + strRedMessage);
		} else {
			System.out.println(type + "-Condition is getting failed");
		}
	}

	public void AmberValidation(String type, Hashtable<String, String> ht, char Utility) throws IOException {
		String strHeader = _webDriverHandler.byXpath(_prop.getProperty(Utility + "Header" + type)).getText();
		String strGetAttribute = _webDriverHandler.byXpath(_prop.getProperty(Utility + "AmberImage" + type)).getAttribute("Status");
		String strAmberMessage = _webDriverHandler.byXpath(_prop.getProperty(Utility + "AmberMessage" + type)).getText();
		if (ht.containsKey(strHeader) && (ht.get(strHeader).equals(strGetAttribute))) {
			System.out.println("Validation has done successfully for " + strHeader + " and Validation Message is : " + strAmberMessage);
		} else {
			System.out.println(type + "-Condition is getting failed");
		}
	}

	public void AARValidation(String type, Hashtable<String, String> ht, char Utility) throws IOException {
		String strHeader = _webDriverHandler.byXpath(_prop.getProperty(Utility + "Header" + type)).getText();
		String strGetAttribute = _webDriverHandler.byXpath(_prop.getProperty(Utility + "AARImage" + type)).getAttribute("Status");
		String strAARMessage = _webDriverHandler.byXpath(_prop.getProperty(Utility + "AARMessage" + type)).getText();
		if (ht.containsKey(strHeader) && (ht.get(strHeader).equals(strGetAttribute))) {
			System.out.println("Validation has done successfully for " + strHeader + " and Validation Message is : " + strAARMessage);
		} else {
			System.out.println(type + "-Condition is getting failed");
		}
	}
}
