package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.nio.file.Paths;

public class ShowConfig {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkShowConfig;
    ElementHandler btnExportExcel;
    ElementHandler btnChooseFile;
    ElementHandler btnUpload;
    ElementHandler btnOk;

    public ShowConfig(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[contains(text(),'Admin')]");
        linkShowConfig = _webDriverHandler.byXpath("//a[@data-action='ShowConfig']");
        btnExportExcel = _webDriverHandler.byXpath("//*[@id='btnExportBrokerconfig']");
        btnChooseFile = _webDriverHandler.byXpath("//*[@id='brokerConfigFileId']");
        btnUpload = _webDriverHandler.byXpath("//*[@id='btnImportBrokerConfig']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblBrokerSettings = new String[] {"Gas Quote Header Text", "Power Quote Header Text", "Gas Quote Footer Text", "Power Quote Footer Text", "Default Price Ahead Days"};
    public  String[] arrBrokerSettings = new String[5];

    public String[] tblSupplierSettings = new String[] {"Quote Text", "Allow Bespoke Quotes?", "Maximum Uplift", "Uplift Increment"};
    public  String[] arrSupplierSettings = new String[4];

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable().click();
        waitLoad();
    }

    public void accessShowConfig(){
        linkShowConfig.waitClickable().click();
    }

    public void verifyShowConfig(){
        waitLoad();
        if(
                btnExportExcel.isDisplayed() &&
                btnChooseFile.isDisplayed() &&
                btnUpload.isDisplayed()
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
        for(int i = 0 ; i < arrBrokerSettings.length ; i++) {
            arrBrokerSettings[i] = _webDriverHandler.byXpath("//table[1]/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblBrokerSettings[i].equals(arrBrokerSettings[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }

        for(int i = 0 ; i < arrSupplierSettings.length ; i++) {
            arrSupplierSettings[i] = _webDriverHandler.byXpath("//table[2]/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSupplierSettings[i].equals(arrSupplierSettings[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void exportExcel(){
        btnExportExcel.waitClickable().click();
    }

    public void uploadConfig(){
        String path = Paths.get("PricecastTestData\\testebs_broker_config.xlsx").toAbsolutePath().toString();
        btnChooseFile.sendKeys(path);
        //btnUpload.waitClickable().click();
    }

    public void errorValidation(){
        btnUpload.waitClickable().click();
        String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
        System.out.println("**********************************\n" + "Error message is: \n"
                + strErrortext + "\n");
        btnOk.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(10,100).waitInvisible(15,100);
    }
}