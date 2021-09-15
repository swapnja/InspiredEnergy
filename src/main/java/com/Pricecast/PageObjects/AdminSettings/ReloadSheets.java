package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class ReloadSheets {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkReloadSheets;
    ElementHandler selectchkbox;
    ElementHandler btnOk;
    ElementHandler rbutilityGas;
    ElementHandler rbutilityPower;
    ElementHandler searchBox;
    ElementHandler btnReloadSelected;

    public ReloadSheets(WebDriverHandler webDriverHandler) {

        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[text() = 'Admin Settings']");
        linkReloadSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Reload']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        rbutilityGas = _webDriverHandler.byXpath("//input[@value='0']");
        rbutilityPower = _webDriverHandler.byXpath("//input[@value='1']");
        btnReloadSelected = _webDriverHandler.byXpath("//button[text()='Reload Selected Sheets']");
        selectchkbox = _webDriverHandler.byXpath("//*[@class='tbl-checkbox']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblReloadSheets = new String[] {"", "Broker", "Supplier", "Sheet Name"};
    public  String[] arrReloadSheets = new String[4];

    public void search(String term){
        searchBox.clear().sendKeys(term);
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
    }

    public void accessReloadSheets(){
        linkReloadSheets.waitClickable(15,100).click();
    }

    public void verifyReloadSheets(){
        waitLoad();
        if(
                searchBox.isDisplayed() &&
                btnReloadSelected.isDisplayed() &&
                rbutilityPower.isDisplayed() &&
                rbutilityPower.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("Reload Sheets is loaded properly.");
        }
        else {
            Assert.fail("Page is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrReloadSheets.length ; i++) {
            arrReloadSheets[i] = _webDriverHandler.byXpath("//table[@id='tblReloadSheet']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblReloadSheets[i].equals(arrReloadSheets[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void reloadSheet(String Utility, String Filename){
        waitLoad();
        if(Utility=="Gas"){
            rbutilityGas.waitClickable(15,100).click();
        }
        else{
            rbutilityPower.waitClickable(15,100).click();
        }
        search(Filename);
        selectchkbox.waitClickable(15,100).click();
        btnReloadSelected.waitClickable(15,100).click();
        String strMesage = _webDriverHandler.byId("swal2-content").waitVisible(10,100).getText();
        System.out.println("****************************************\n"
                + strMesage + "\n");
        btnOk.waitClickable(15,100).click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
    }
}
