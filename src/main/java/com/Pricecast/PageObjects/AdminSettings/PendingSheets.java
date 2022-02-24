package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import org.testng.Assert;

public class PendingSheets {
    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkPendingSheets;
    ElementHandler selectchkbox;
    ElementHandler btnOk;
    ElementHandler rbutilityGas;
    ElementHandler rbutilityPower;
    ElementHandler searchBox;
    ElementHandler btnDeleteSelected;
    ElementHandler btnBack;

    public PendingSheets(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[text() = 'Admin Settings']");
        linkPendingSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Pending']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        rbutilityGas = _webDriverHandler.byXpath("//input[@value='0']");
        rbutilityPower = _webDriverHandler.byXpath("//input[@value='1']");
        btnDeleteSelected = _webDriverHandler.byXpath("//button[text()='Delete Selected Sheets']");
        selectchkbox = _webDriverHandler.byXpath("//*[@class='tbl-checkbox']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnBack = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-primary']");
    }

    public String[] tblPendingSheets = new String[] {"Broker", "File Name", "File Date", "Supplier", "Tariffs Used For", "Supply Type", "Start Date", "Sheet Type", "Status", ""};
    public String[] arrPendingSheets = new String[10];

    public void search(String term){
        searchBox.clear().sendKeys(term);
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable().click();
        waitLoad();
    }

    public void accessPendingSheets(){
        linkPendingSheets.waitClickable().click();
    }

    public void verifyPendingSheets(){
        waitLoad();
        if(
            searchBox.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nPending Sheets is loaded properly");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrPendingSheets.length ; i++) {
            arrPendingSheets[i] = _webDriverHandler.byXpath("//table[@id='tblPendingSheet']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblPendingSheets[i].equals(arrPendingSheets[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void checkpendingSheets(String Utility, String Filename) throws InterruptedException{
        Tariff tariff = new Tariff(_webDriverHandler);
        tariff.TariffAccess();
        tariff.reprocessTariff(Utility, Filename);
        accessAdminSettings();
        accessPendingSheets();
        search(Filename);
        
        if(_webDriverHandler.byXpath("//table[@id='tblPendingSheet']//tr[td/text()='"+Filename+"'][td/text()='"+Utility+"']").isDisplayed()){
            System.out.println("\nPending Status is being Updated");
        }

    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
