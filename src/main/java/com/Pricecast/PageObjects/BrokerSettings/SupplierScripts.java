package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.Properties;

public class SupplierScripts {
    Properties _prop;
    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonAddNewRow;
    private ElementHandler ddSupplier;
    private ElementHandler ddScriptType;
    private ElementHandler btnSelectFile;
    private ElementHandler btnUpload;
    private ElementHandler btnUploadScript;
    private ElementHandler buttonSettings;
    private ElementHandler linkSupplierScripts;
    private ElementHandler rbGas;
    private ElementHandler rbPower;
    private ElementHandler rbAll;
    private ElementHandler btnOk;

    //Mandatory validation messages
    String strMandatorySupplier = "Supplier is mandatory.";
    String strVMandatorySelectFile = "The Select File is required.";

    public SupplierScripts(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierScripts = _webDriverHandler.byXpath("//a[@data-action='SupplierScripts']");
        //Supplier Script
        rbGas = _webDriverHandler.byXpath("//*[@id='energyType_0']");
        rbPower = _webDriverHandler.byXpath("//*[@id='energyType_1']");
        rbAll = _webDriverHandler.byXpath("//*[@id='energyType_2']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='ddlSupplier']");
        ddScriptType = _webDriverHandler.byXpath("//*[@id='ddlScriptType']");
        btnSelectFile = _webDriverHandler.byXpath("//*[@id='txtScriptFile']");
        btnUpload = _webDriverHandler.byXpath("//*[@id='btnUploadSupScript']");
        btnUploadScript = _webDriverHandler.byXpath("//*[@id='btnUploadScript']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblSupplierScript = new String[]{"File Name", "File Date", "Supplier", "Script Type", "Supply Type", "Actions"};
    public String[] arrSupplierScript = new String[6];

    public void SupplierScripts_Columnverification() {
        for (int i = 0; i < arrSupplierScript.length; i++) {
            arrSupplierScript[i] = _webDriverHandler.byXpath("//table[@id='tblSupplierScripts']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSupplierScript[i].equals(arrSupplierScript[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkSupplierScripts.click();
    }

    public void SupplierScripts_addNewRow(String supplyType, String supplier, String scriptType, String FileName) {
        String path = Paths.get("PricecastTestData\\"+FileName).toAbsolutePath().toString();
        waitLoad();
        btnUploadScript.waitClickable(10, 100).click();
        waitLoad();
        switch(supplyType){
            case "Power":
                rbPower.waitClickable().click();
                waitLoad();
                break;
            case "All":
                rbAll.waitClickable().click();
                waitLoad();
                break;
            default:
                rbGas.waitClickable().click();
        }
        ddSupplier.selectByText(supplier + "");
        ddScriptType.selectByText(scriptType + "");
        btnSelectFile.sendKeys(path);
        btnUpload.waitClickable(10, 100).click();
        btnOk.waitClickable().click();
    }

    public void SupplierScripts_Validation(String supplyType, String supplier, String scriptType, String FileName) {
        String path = Paths.get("PricecastTestData\\"+FileName).toAbsolutePath().toString();
        waitLoad();
        btnUploadScript.waitClickable(10, 100).click();
        waitLoad();
        switch(supplyType){
            case "Power":
                rbPower.waitClickable().click();
                waitLoad();
                break;
            case "All":
                rbAll.waitClickable().click();
                waitLoad();
                break;
            default:
                rbGas.waitClickable().click();
        }
        ddSupplier.selectByText(supplier + "");
        ddScriptType.selectByText(scriptType + "");
        btnSelectFile.sendKeys(path);
        String strMessage = _webDriverHandler.byId("swal2-content").waitVisible().getText();
        System.out.println("****************************************\n"
                + strMessage + "\n");
        btnOk.waitClickable().click();
        Assert.assertEquals(strMessage, "Only file type with extension pdf, docx and doc are allowed");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }

}
