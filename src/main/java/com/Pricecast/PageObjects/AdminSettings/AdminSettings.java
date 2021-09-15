package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;


public class AdminSettings {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkReloadSheets;
    ElementHandler linkDeleteSheets;
    ElementHandler linkPendingSheets;
    ElementHandler linkMissingSheets;
    ElementHandler linkTariffMapping;
    ElementHandler linkHelpText;
    ElementHandler linkShowConfig;

    public AdminSettings(WebDriverHandler webDriverHandler)
    {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[text() = 'Admin Settings']");
        linkReloadSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Reload']");
        linkDeleteSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Delete']");
        linkPendingSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Pending']");
        linkMissingSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Missing']");
        linkTariffMapping = _webDriverHandler.byXpath("//a[@data-action='Sheets/Missing']");
        linkHelpText = _webDriverHandler.byXpath("//a[@data-action='Sheets/Missing']");
        linkShowConfig = _webDriverHandler.byXpath("//a[@data-action='Sheets/Missing']");
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable().click();
        if(
            linkShowConfig.isDisplayed() &&
            linkHelpText.isDisplayed() &&
            linkPendingSheets.isDisplayed() &&
            linkMissingSheets.isDisplayed() &&
            linkDeleteSheets.isDisplayed() &&
            linkReloadSheets.isDisplayed()
        )
        {
         System.out.println("Admin settings page is accessible, with all tabs available");
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
