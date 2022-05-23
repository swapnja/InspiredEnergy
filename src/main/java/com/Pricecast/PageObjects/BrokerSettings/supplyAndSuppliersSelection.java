package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;

public class supplyAndSuppliersSelection {
    WebDriverHandler _webDriverHandler;
    ElementHandler radioGasSupplyType;
    ElementHandler radioPowerSupplyType;
    ElementHandler radioAllSupplyType;
    ElementHandler ddCommonSupplier;
    ElementHandler btnSupplierScriptUpload;
    ElementHandler btnSave;

    //Common fields
    public supplyAndSuppliersSelection(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        radioGasSupplyType = _webDriverHandler.byXpath("//*[@id='energyType_0']");
        radioPowerSupplyType = _webDriverHandler.byXpath("//*[@id='energyType_1']");
        radioAllSupplyType = _webDriverHandler.byXpath("//*[@id='energyType_2']");
        ddCommonSupplier = _webDriverHandler.byXpath("//*[@id='ddlSupplier']");
        btnSupplierScriptUpload = _webDriverHandler.byXpath("//*[@id='btnUploadScript']");
        btnSave = _webDriverHandler.byXpath("//button[@type='submit']");

        //btnAddNewBorkerSupplierDeemedPowerPrices
    }

    public void selectGasSupplier() throws InterruptedException {
        //radioGasSupplyType.click();
        Thread.sleep(2000);
        ddCommonSupplier.selectByText("British Gas");
    }

    public void selectPowerSupplier() throws InterruptedException {
        Thread.sleep(2000);
        radioPowerSupplyType.click();
        Thread.sleep(2000);
        ddCommonSupplier.selectByText("CNG");
    }

    public void selectAllSupplier() {
        radioAllSupplyType.click();
        ddCommonSupplier.selectByIndex(2);
    }

}
