package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class TariffMappingSQL {
    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkTariffMapping;
    ElementHandler btnOk;
    ElementHandler rbutilityGas;
    ElementHandler rbutilityPower;
    ElementHandler searchBox;
    ElementHandler btnAddNew;
    ElementHandler tbSupplier;
    ElementHandler tbTariffMapping;
    ElementHandler tbDescription;
    ElementHandler tbUseTemp;
    ElementHandler tbSQL;
    ElementHandler referenceDatatgl;
    ElementHandler referenceDataCheck;
    ElementHandler isHHtgl;
    ElementHandler isHHCheck;
    ElementHandler isAPISheettgl;
    ElementHandler isAPISheetCheck;
    ElementHandler btnAdd;
    ElementHandler btnDltYes;
    ElementHandler msgSupplier;
    ElementHandler msgMappingName;
    ElementHandler msgDescription;
    ElementHandler msgUseTemp;
    ElementHandler btnCancel;

    public TariffMappingSQL(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[contains(text(),'Admin')]");
        linkTariffMapping = _webDriverHandler.byXpath("//a[@data-action='TariffMappingSQL']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        rbutilityGas = _webDriverHandler.byXpath("//*[@id='energyType_0']");
        rbutilityPower = _webDriverHandler.byXpath("//*[@id='energyType_1']");
        btnAddNew = _webDriverHandler.byXpath("//button[text()='Add New Row']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        tbSupplier = _webDriverHandler.byXpath("//*[@id='Supplier']");
        tbTariffMapping = _webDriverHandler.byXpath("//*[@id='MappingName']");
        tbDescription = _webDriverHandler.byXpath("//*[@id='Description']");
        tbUseTemp = _webDriverHandler.byXpath("//*[@id='UseTemp']");
        tbSQL = _webDriverHandler.byXpath("//textarea[@name='SQL']");
        referenceDatatgl = _webDriverHandler.byXpath("//label[input[@id='ReferenceData']]");
        referenceDataCheck = _webDriverHandler.byXpath("//input[@id='ReferenceData']");
        isHHtgl = _webDriverHandler.byXpath("//label[input[@id='IsHH']]");
        isHHCheck = _webDriverHandler.byXpath("//input[@id='IsHH']");
        isAPISheettgl = _webDriverHandler.byXpath("//label[input[@id='IsAPISheet']]");
        isAPISheetCheck = _webDriverHandler.byXpath("//input[@id='IsAPISheet']");
        btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
        btnDltYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        msgSupplier = _webDriverHandler.byXpath("//*[@id='Supplier-error']");
        msgMappingName = _webDriverHandler.byXpath("//*[@id='MappingName-error']");
        msgDescription = _webDriverHandler.byXpath("//*[@id='Description-error']");
        msgUseTemp = _webDriverHandler.byXpath("//*[@id='UseTemp-error']");
        btnCancel = _webDriverHandler.byXpath("//*[contains(text(),'Cancel')]");
    }

    public String[] tblTariffMapping = new String[] {"Supplier", "Power Type", "Mapping Name", "Description", "Reference Data", "Is HH", "Is API Sheet", "Updated On", "Updated By", "Actions"};
    public  String[] arrTariffMapping = new String[10];

    String strMandatorySupplier = "Supplier is mandatory";
    String strMandatoryMappingName = "Mapping Name is mandaory";
    String strMandatoryDescription  = "Description is mandatory";
    String strMandatoryUseTemp = "The UseTemp field is required.";

    public void search(String term){
        searchBox.clear().sendKeys(term);
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable(15,100).click();
        waitLoad();
    }

    public void accessTariffMapping(){
        linkTariffMapping.waitClickable(15,100).click();
    }

    public void verifyTariffMapping(){
        waitLoad();
        if(
            searchBox.isDisplayed() &&
            btnAddNew.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nTariff Mapping SQL page is loaded properly.");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrTariffMapping.length ; i++) {
            arrTariffMapping[i] = _webDriverHandler.byXpath("//table[@id='tblMappingSQL']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblTariffMapping[i].equals(arrTariffMapping[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void addMappingRow(String Supplier, String Utility, String MappingName, String Description, String UseTemp, boolean ReferenceData, boolean IsHH, boolean IsAPISheet, String SQL) {
        waitLoad();
        btnAddNew.waitClickable(15,100).click();
        tbSupplier.clear().sendKeys(Supplier);
        if(Utility=="Gas"){
            rbutilityGas.waitClickable(15,100).click();
        }
        else {
            rbutilityPower.waitClickable(15,100).click();
        }
        tbTariffMapping.clear().sendKeys(MappingName);
        tbDescription.clear().sendKeys(Description);
        tbUseTemp.clear().sendKeys(UseTemp);
        tbSQL.clear().sendKeys(SQL);
        if(ReferenceData){
            referenceDatatgl.waitClickable(15,100).click();
        }
        if(IsHH){
            isHHtgl.waitClickable(15,100).click();
        }
        if(IsAPISheet){
            isAPISheettgl.waitClickable(15,100).click();
        }
        btnAdd.waitClickable(15,100).click();
        btnOk.waitClickable(15,100).click();
    }

    public void addErrorMappingRow() {
        waitLoad();
        btnAddNew.waitClickable(15,100).click();
        tbSupplier.clear().sendKeys("");
        tbTariffMapping.clear().sendKeys("");
        tbDescription.clear().sendKeys("");
        tbUseTemp.clear().sendKeys("");
        btnAdd.waitClickable(15,100).click();
    }

    public void cancelMapping(){
        btnCancel.waitClickable(15,100).click();
    }

    public void deleteMapping(String Supplier, String Utility){
        search(Supplier);
        _webDriverHandler.byXpath("//*[@id='tblMappingSQL']//tr[td/text()='"+Supplier+"'][td/text()='"+Utility+"']//button[@title='Delete']").waitClickable(15,100).click();
        btnDltYes.waitClickable(15,100).click();
        btnOk.waitClickable(15,100).click();
    }

    public void editMapping(String SupplierOld, String UtilityOld, String Supplier, String Utility, String MappingName, String Description, String UseTemp, boolean ReferenceData, boolean IsHH, boolean IsAPISheet, String SQL){
        search(SupplierOld);
        _webDriverHandler.byXpath("//*[@id='tblMappingSQL']//tr[td/text()='"+SupplierOld+"'][td/text()='"+UtilityOld+"']//button[@title='Edit']").waitClickable(15,100).click();
        waitLoad();
        tbSupplier.clear().sendKeys(Supplier);
        if(Utility=="Gas"){
            rbutilityGas.waitClickable(15,100).click();
        }
        else {
            rbutilityPower.waitClickable(15,100).click();
        }
        tbTariffMapping.clear().sendKeys(MappingName);
        tbDescription.clear().sendKeys(Description);
        tbUseTemp.clear().sendKeys(UseTemp);
        tbSQL.clear().sendKeys(SQL);
        if(ReferenceData){
            referenceDatatgl.waitClickable(15,100).click();
        }
        if(IsHH){
            isHHtgl.waitClickable(15,100).click();
        }
        if(IsAPISheet){
            isAPISheettgl.waitClickable(15,100).click();
        }
        btnAdd.waitClickable(15,100).click();
        btnOk.waitClickable(15,100).click();
    }

    public void mandatoryValidations(){
        Assert.assertEquals(msgSupplier.getText(), strMandatorySupplier);
        Assert.assertEquals(msgMappingName.getText(), strMandatoryMappingName);
        Assert.assertEquals(msgDescription.getText(), strMandatoryDescription);
        Assert.assertEquals(msgUseTemp.getText(), strMandatoryUseTemp);
        System.out.println("\nMandatory validations are passed.");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
    }
}
