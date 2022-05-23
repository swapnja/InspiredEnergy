package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import org.testng.Assert;

import java.nio.file.Paths;

public class DeleteSheets {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkDeleteSheets;
    ElementHandler selectchkbox;
    ElementHandler btnOk;
    ElementHandler rbutilityGas;
    ElementHandler rbutilityPower;
    ElementHandler searchBox;
    ElementHandler btnDeleteSelected;
    ElementHandler btnDltYes;
    ElementHandler btnBack;

    public DeleteSheets(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[contains(text(),'Admin')]");
        linkDeleteSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Delete']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        rbutilityGas = _webDriverHandler.byXpath("//input[@value='0']");
        rbutilityPower = _webDriverHandler.byXpath("//input[@value='1']");
        btnDeleteSelected = _webDriverHandler.byXpath("//button[text()='Delete Selected Sheets']");
        selectchkbox = _webDriverHandler.byXpath("//*[@class='tbl-checkbox']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnDltYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        btnBack = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-primary']");
    }

    public String[] tblDeleteSheets = new String[] {"", "Broker", "Supplier", "Sheet Name", "Start Date"};
    public  String[] arrDeleteSheets = new String[5];

    public void search(String term){
        searchBox.clear().sendKeys(term);
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
    }

    public void accessDeleteSheets(){
        linkDeleteSheets.waitClickable(15,100).click();
    }

    public void verifyDeleteSheets(){
        waitLoad();
        if(
                searchBox.isDisplayed() &&
                btnDeleteSelected.isDisplayed() &&
                rbutilityPower.isDisplayed() &&
                rbutilityPower.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nDelete Sheets is loaded properly");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrDeleteSheets.length ; i++) {
            arrDeleteSheets[i] = _webDriverHandler.byXpath("//table[@id='tblDeleteSheet']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblDeleteSheets[i].equals(arrDeleteSheets[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void deleteSheet(String Utility, String Filename){
        waitLoad();
        if(Utility=="Gas"){
            rbutilityGas.waitClickable(15,100).click();
        }
        else{
            rbutilityPower.waitClickable(15,100).click();
        }
        search(Filename);
        selectchkbox.waitClickable(15,100).click();
        btnDeleteSelected.waitClickable(15,100).click();
        btnDltYes.waitClickable(15,100).click();
        String strMesage = _webDriverHandler.byId("swal2-content").waitVisible(15,100).getText();
        System.out.println("****************************************\n"
                + strMesage + "\n");
        btnOk.waitClickable(15,100).click();
    }

    public void tariffLoad(){
        Tariff tariff = new Tariff(_webDriverHandler);
        tariff.TariffAccess();
        tariff.waitLoad();
        _webDriverHandler.byXpath("//*[@id='btnUploadTariff']").waitClickable(15,100).click();
        String path = Paths.get("PricecastTestData\\Tariff\\Gas\\Axis-G-Axis 2018 Format.xlsx").toAbsolutePath().toString();
        _webDriverHandler.byXpath("//*[@id='txtTariffSheet']").sendKeys(path);
        waitLoad();
        try{_webDriverHandler.byXpath("//*[@id='ddlEnergyType1']").selectByText("Gas");}
        catch(Exception e){}
        _webDriverHandler.byXpath("(//*[contains(text(),'Cancel')])[2]").waitClickable(15,100).click();
        _webDriverHandler.byXpath("//a[contains(text(),'Tariff')]").waitClickable(15,100).click();
    }

    public void restoreDeletedFile(String Utility){
        Tariff tariff = new Tariff(_webDriverHandler);
        btnBack.waitClickable(15,100).click();
        tariff.TariffAccess();
        tariff.waitLoad();
        if(Utility.equals("Gas")){
            tariff.UploadSheetsExcel("To_Be_Deleted.xlsx", "Gas", "BES", "Acquisition and Renewal","BESGas", "01/01/2020","","" );
        }
        else{
            tariff.UploadSheetsExcel("Axis-G-Axis 2018 Format.xlsx", "Gas", "Axis", "Acquisition and Renewal","Axis", "01/01/2020","","" );
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
    }
}