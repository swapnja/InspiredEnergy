package com.Base;

import com.Base.SeleniumHandlers.WebDriverHandler;

import java.util.Properties;

public class LoginPageHandler {

    private WebDriverHandler _webDriverHandler;
    private Properties _prop;

    public LoginPageHandler(WebDriverHandler webDriverHandler, Properties prop) {
        _webDriverHandler = webDriverHandler;
        _prop = prop;
    }

    public void Login() {
        _webDriverHandler.byXpath(_prop.getProperty("HomeLogin")).waitClickable(15,100).click();
        _webDriverHandler.byId(_prop.getProperty("userName")).sendKeys(_prop.getProperty("AdminUser"));
        _webDriverHandler.byXpath(_prop.getProperty("HomeSignIn")).waitClickable(5,100).click();
        _webDriverHandler.byId(_prop.getProperty("password")).staleElementHandler().sendKeys(_prop.getProperty("AdminPassword"));
        _webDriverHandler.byXpath(_prop.getProperty("HomeSignIn")).waitClickable(15,100).click();	
        _webDriverHandler.byXpath(_prop.getProperty("HomeStaySignedIn")).waitVisible(15,100).waitClickable(15,100).click();
    }

    public void accessBudgets() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("BudgetIcon")).waitClickable(15,  100).click();
    }

    public void accessPriceCast() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("EBSIcon")).waitClickable(15,  100).click();
    }

    public void accessCP() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("ClientPortalIcon")).waitClickable(15,  100).click();
    }

    public void accessCIR() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("CarbonIntensity")).waitClickable(15,  100).click();
    }

    public void accessAutoII() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("AutoII")).waitClickable(15,  100).click();
    }

    public void accessBulkScanning() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("BulkScanning")).waitClickable(15,  100).click();
    }

    public void accessQueryManagement() {
        _webDriverHandler.byId(_prop.getProperty("AllApplications")).waitVisible(15,100).waitClickable(15,100).click();
        _webDriverHandler.byXpath(_prop.getProperty("QueryManagement")).waitClickable(15,  100).click();
    }
}
