package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import org.testng.Assert;

import java.nio.file.Paths;

public class MissingSheets {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkMissingSheets;
    ElementHandler selectchkbox;
    ElementHandler btnOk;
    ElementHandler rbutilityGas;
    ElementHandler rbutilityPower;
    ElementHandler searchBox;
    ElementHandler btnReloadSelected;
    ElementHandler btnBack;
    ElementHandler btnCancel;

    public MissingSheets(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[text() = 'Admin Settings']");
        linkMissingSheets = _webDriverHandler.byXpath("//a[@data-action='Sheets/Missing']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        rbutilityGas = _webDriverHandler.byXpath("//input[@value='0']");
        rbutilityPower = _webDriverHandler.byXpath("//input[@value='1']");
        btnReloadSelected = _webDriverHandler.byXpath("//button[text()='Reload Selected Sheets']");
        selectchkbox = _webDriverHandler.byXpath("//*[@class='tbl-checkbox']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnBack = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-primary']");
        btnCancel = _webDriverHandler.byXpath("(//*[contains(text(),'Cancel')])[2]");
    }

    public String[] tblMissingSheets = new String[] {"Broker", "Supplier", "Energy Type"};
    public  String[] arrMissingSheets = new String[3];

    public void search(String term){
        searchBox.clear().sendKeys(term);
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
    }

    public void accessMissingSheets(){
        linkMissingSheets.waitClickable(15,100).click();
    }

    public void verifyMissingSheets(){
        waitLoad();
        if(
            searchBox.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nMissing Sheets is loaded properly");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrMissingSheets.length ; i++) {
            arrMissingSheets[i] = _webDriverHandler.byXpath("//table[@id='tblMissingSheet']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblMissingSheets[i].equals(arrMissingSheets[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public String[] getMissingSheet(){
        String [] data = new String[2];
        for (int i=0; i<=1; i++){
                if(i==0){
                    data[i] =  _webDriverHandler.byXpath("//table[@id='tblMissingSheet']//tr[td/text()='Power']//td["+(i+2)+"]").getText();
                }
                else {
                    data[i] =  _webDriverHandler.byXpath("//table[@id='tblMissingSheet']//tr[td/text()='Gas']//td["+(i+1)+"]").getText();
                }
            }
        return data;
    }

    public void tariffLoad(){
        Tariff tariff = new Tariff(_webDriverHandler);
        tariff.TariffAccess();
        tariff.waitLoad();
        _webDriverHandler.byXpath("//*[@id='btnUploadTariff']").waitClickable(15,100).click();
        String path = Paths.get("PricecastTestData\\Tariff\\Power\\To_Be_Deleted.xlsx").toAbsolutePath().toString();
        _webDriverHandler.byXpath("//*[@id='txtTariffSheet']").sendKeys(path);
        waitLoad();
        try{_webDriverHandler.byXpath("//*[@id='ddlEnergyType1']").selectByText("Power");}
        catch(Exception e){}
        _webDriverHandler.byXpath("(//*[contains(text(),'Cancel')])[2]").waitClickable(15,100).click();
        _webDriverHandler.byXpath("//a[contains(text(),'Tariff')]").waitClickable(15,100).click();
    }

    public void checkMissingSheets() {
        Tariff tariff = new Tariff(_webDriverHandler);
        tariff.TariffAccess();
        waitLoad();
        tariff.deleteTariff("Axis-P-Axis 2018 Format.xlsx");
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
        accessMissingSheets();
        waitLoad();
        search("Axis");
        if(_webDriverHandler.byXpath("//table[@id='tblMissingSheet']//tr[td/text()='Power'][td/text()='Axis']").isDisplayed()){
            System.out.println("\nMissing sheet functionality is working for Gas Tariffs.");
        }
        else {
            Assert.fail("\nMissing sheet functionality is not working for Gas Tariffs.");
        }
        btnBack.waitClickable(15,100).click();
        tariff.TariffAccess();
        waitLoad();
        tariff.deleteTariff("Opus-G-Opus Broker Upload New Format.xlsx");
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
        accessMissingSheets();
        waitLoad();
        search("Opus");
        if(_webDriverHandler.byXpath("//table[@id='tblMissingSheet']//tr[td/text()='Gas'][td/text()='Opus']").isDisplayed()){
            System.out.println("\nMissing sheet functionality is working for Power Tariffs.");
        }
        else {
            Assert.fail("\nMissing sheet functionality is not working for Power Tariffs.");
        }
        btnBack.waitClickable(15,100).click();
        tariff.TariffAccess();
        waitLoad();
        tariff.UploadSheetsExcel("Axis-P-Axis 2018 Format.xlsx", "Power", "Axis", "Acquisition and Renewal", "Axis 2018 Format", "10/01/2019", "", "");
        adminSettings.waitClickable(15,100).click();
        waitLoad();
        btnBack.waitClickable(15,100).click();
        tariff.TariffAccess();
        waitLoad();
        tariff.UploadSheetsExcel("Opus-G-Opus Broker Upload New Format.xlsx", "Gas", "Opus", "Acquisition and Renewal", "Opus Broker Upload New Format", "06/07/2017", "", "");
    }

//    public void checkMissingSheets(){
//        Tariff tariff = new Tariff(_webDriverHandler);
//        String data[] = getMissingSheet();
//        String powerSupplier = data[0];
//        String gasSupplier = data [1];
//        btnBack.waitClickable(15,100).click();
//        tariff.TariffAccess();
//        try{tariff.UploadSheetsExcel("Missing_Upload.xlsx", "Power", powerSupplier, "Acquisition and Renewal", "","01/01/2020","","");}
//        catch (Exception e){
//            btnCancel.waitClickable(15,100).click();
//            System.out.println("Supplier Not Available");
//        }
//        try{tariff.UploadSheetsExcel("Missing_Upload.xlsx", "Power", gasSupplier, "Acquisition and Renewal", "","01/01/2020","","");}
//        catch (Exception e){
//            System.out.println("Supplier Not Available");
//        }
//    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
    }
}
