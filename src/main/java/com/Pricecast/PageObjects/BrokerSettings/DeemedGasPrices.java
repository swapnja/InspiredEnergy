package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class DeemedGasPrices {

    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonSettings;
    private ElementHandler buttonAddNewRow;
    private ElementHandler linkSupplierDeemedGasPrices;
    private ElementHandler btnAdd;
    private ElementHandler btnOk;
    private ElementHandler txtBoxDeemedGasMaxVol;
    private ElementHandler txtBoxDeemedGasMinVol;
    private ElementHandler txtBoxDeemedGasUnitRate;
    private ElementHandler txtBoxDeemedGasStandingCharge;
    private ElementHandler errorMinVol;
    private ElementHandler errorMaxVol;
    private ElementHandler errorUnitRate;
    private ElementHandler errorStandingCharge;

    //Mandatory
    String strMandatoryMinVol = "Min Volume field is mandatory";
    String strMandatoryMaxVol = "Max Volume field is mandatory";
    String strMandatoryUnitRate = "Unit Rate field is mandatory";
    String strMandatoryStandingCharge = "Standing Charge field is mandatory";

    //Range
    String strRangeMinVol = "Please enter a number between 0 and 1000000000";
    String strRangeMaxVol = "Please enter a number between 0 and 1000000000";
    String strRangeUnitRate = "Please enter a number between 0 and 1000000000";
    String strRangeStandingCharge = "Please enter a number between 0 and 1000000000";

    //Valid
    String strValidMinVol = "Please enter valid Number";
    String strValidMaxVol = "Please enter valid Number";
    String strValidUnitRate = "Please enter a number in between 0 and 1000000000";
    String strValidStandingCharge = "Please enter a number in between 0 and 1000000000";

    public DeemedGasPrices(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierDeemedGasPrices = _webDriverHandler.byXpath("//a[@data-action='SupplierDeemedGasPrices']");
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewBorkerSupplierDeemedGasPrices']");
        btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        //Deemed Gas Prices
        txtBoxDeemedGasMaxVol = _webDriverHandler.byXpath("//*[@id='MaxAQ']");
        txtBoxDeemedGasMinVol = _webDriverHandler.byXpath("//*[@id='MinAQ']");
        txtBoxDeemedGasUnitRate = _webDriverHandler.byXpath("//*[@id='UnitRate']");
        txtBoxDeemedGasStandingCharge = _webDriverHandler.byXpath("//*[@id='StandingCharge']");
        errorMinVol = _webDriverHandler.byXpath("//*[@id='MinAQ-error']");
        errorMaxVol = _webDriverHandler.byXpath("//*[@id='MaxAQ-error']");
        errorUnitRate = _webDriverHandler.byXpath("//*[@id='UnitRate-error']");
        errorStandingCharge = _webDriverHandler.byXpath("//*[@id='StandingCharge-error']");

    }

    public String[] tblDeemedGasPrices = new String[]{"Min Volume", "Max Volume", "Unit Rate", "Standing Charge", "Actions"};
    public String[] arrDeemedGasPrices = new String[5];

    public void deemedGasPrice_ColumnVerification() {
        for (int i = 0; i < arrDeemedGasPrices.length; i++) {
            arrDeemedGasPrices[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerSupplierDeemedGasPrices']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDeemedGasPrices[i].equals(arrDeemedGasPrices[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkSupplierDeemedGasPrices.click();
    }

    public void DeemedGasPrices_addNewRow(int MinVol, int MaxVol, int UnitRate, int StandingCharge) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedGasMinVol.clear().sendKeys(MinVol + "");
        txtBoxDeemedGasMaxVol.clear().sendKeys(MaxVol + "");
        txtBoxDeemedGasUnitRate.clear().sendKeys(UnitRate + "");
        txtBoxDeemedGasStandingCharge.clear().sendKeys(StandingCharge + "");
        btnAdd.waitClickable(10, 100).click();
        waitLoad();
        btnOk.waitClickable(10, 100).click();
    }

    public void DeemedGasPrices_blankaddNewRow() throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedGasMinVol.clear();
        txtBoxDeemedGasMaxVol.clear();
        txtBoxDeemedGasUnitRate.clear();
        txtBoxDeemedGasStandingCharge.clear();
        btnAdd.waitClickable(10, 100).click();
    }

    public void DeemedGasPrices_Validation(String MinVol, String MaxVol, String UnitRate, String StandingCharge) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedGasMinVol.clear().sendKeys(MinVol);
        txtBoxDeemedGasMaxVol.clear().sendKeys(MaxVol);
        txtBoxDeemedGasUnitRate.clear().sendKeys(UnitRate);
        txtBoxDeemedGasStandingCharge.clear().sendKeys(StandingCharge);
        btnAdd.waitClickable(10, 100).click();
    }

    public void DeemedGasPrices_RangeValidation() throws InterruptedException {
        Assert.assertTrue(strRangeMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Range Validation is present for Min Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strRangeMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Range Validation is present for Max Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strRangeUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Range Validation is present for Rate Unit on the Deemed Gas Prices Screen");
        Assert.assertTrue(strRangeStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Range Validation is present for Standing Charge on the Deemed Gas Prices Screen");
    }

    public void DeemedGasPrices_NumericValidation() throws InterruptedException {
        Assert.assertTrue(strValidMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Range Validation is present for Min Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strValidMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Range Validation is present for Max Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strValidUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Range Validation is present for Rate Unit on the Deemed Gas Prices Screen");
        Assert.assertTrue(strValidStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Range Validation is present for Standing Charge on the Deemed Gas Prices Screen");
    }

    public void DeemedGasPrices_MandatoryValidation() throws InterruptedException {
        Assert.assertTrue(strMandatoryMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Mandatory Validation is present for Min Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strMandatoryMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Mandatory Validation is present for Max Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strMandatoryUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Mandatory Validation is present for Rate Unit on the Deemed Gas Prices Screen");
        Assert.assertTrue(strMandatoryStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Mandatory Validation is present for Standing Charge on the Deemed Gas Prices Screen");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}