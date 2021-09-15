package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.testng.Assert;

import java.util.Properties;

public class DeemedPowerPrices {
    Properties _prop;
    private WebDriverHandler _webDriverHandler;
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    private CommonPageHandler cph;
    private ElementHandler buttonSettings;
    private ElementHandler buttonAddNewRow;
    private ElementHandler linkSupplierDeemedPowerPrices;
    private ElementHandler btnAdd;
    private ElementHandler btnOk;
    private ElementHandler txtBoxDeemedPowerPC;
    private ElementHandler txtBoxDeemedPowerUnitRate;
    private ElementHandler txtBoxDeemedPowerStandingCharge;
    private ElementHandler errorPC;
    private ElementHandler errorUnitRate;
    private ElementHandler errorStandingCharge;
    private ElementHandler ddSupplier;

    //Mandatory
    String strMandatoryPC = "PC field is mandatory.";
    String strMandatoryUnitRate = "Unit Rate field is mandatory.";
    String strMandatoryStandingCharge = "Standing Charge field is mandatory.";

    //Range
    String strRangePC = "Please enter a number between 0 and 1000000000";
    String strRangeUnitRate = "Please enter a number between 0 and 1000000000";
    String strRangeStandingCharge = "Please enter a number between 0 and 1000000000";

    //Valid
    String strValidPC = "Please enter valid Number";
    String strValidUnitRate = "Please enter a number in between 0 and 1000000000";
    String strValidStandingCharge = "Please enter a number in between 0 and 1000000000";

    public DeemedPowerPrices(WebDriverHandler webDriverHandler) {
        cph = new CommonPageHandler(webDriverHandler, _prop);
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierDeemedPowerPrices = _webDriverHandler.byXpath("//a[@data-action='SupplierDeemedPowerPrices']");
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewBorkerSupplierDeemedPowerPrices']");
        btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        //Deemed Power Prices
        txtBoxDeemedPowerPC = _webDriverHandler.byXpath("//*[@id='PC']");
        txtBoxDeemedPowerUnitRate = _webDriverHandler.byXpath("//*[@id='UnitRate']");
        txtBoxDeemedPowerStandingCharge = _webDriverHandler.byXpath("//*[@id='StandingCharge']");
        errorPC = _webDriverHandler.byXpath("//*[@id='PC-error']");
        errorUnitRate = _webDriverHandler.byXpath("//*[@id='UnitRate-error']");
        errorStandingCharge = _webDriverHandler.byXpath("//*[@id='StandingCharge-error']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='ddlSupplier']");
    }

    public String[] tblDeemedPowerPrices = new String[]{"PC", "Unit Rate", "Standing Charge", "Actions"};
    public String[] arrDeemedPowerPrices = new String[4];

    public void deemedPowerPrice_ColumnVerification() {
        for (int i = 0; i < arrDeemedPowerPrices.length; i++) {
            arrDeemedPowerPrices[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerSupplierDeemedPowerPrices']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDeemedPowerPrices[i].equals(arrDeemedPowerPrices[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkSupplierDeemedPowerPrices.click();
    }

    public void DeemedPowerPrices_addNewRow(String supplier, int PC, int UnitRate, int StandingCharge) throws InterruptedException {
        waitLoad();
        ddSupplier.selectByText(supplier);
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedPowerPC.clear().sendKeys(PC + "");
        txtBoxDeemedPowerUnitRate.clear().sendKeys(UnitRate + "");
        txtBoxDeemedPowerStandingCharge.clear().sendKeys(StandingCharge + "");
        btnAdd.waitClickable(10, 100).click();
        waitLoad();
        btnOk.waitClickable().click();
    }

    public void DeemedPowerPrices_blankaddNewRow() {
        waitLoad();
        ddSupplier.selectByText("British Gas");
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedPowerPC.clear();
        txtBoxDeemedPowerUnitRate.clear();
        txtBoxDeemedPowerStandingCharge.clear();
        btnAdd.waitClickable().click();
    }

    public void DeemedPowerPrices_Validation(String supplier, String  PC, String UnitRate, String StandingCharge) throws InterruptedException {
        waitLoad();
        ddSupplier.selectByText(supplier);
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDeemedPowerPC.clear().sendKeys(PC);
        txtBoxDeemedPowerUnitRate.clear().sendKeys(UnitRate);
        txtBoxDeemedPowerStandingCharge.clear().sendKeys(StandingCharge);
        btnAdd.waitClickable().click();
    }

    public void DeemedPowerPrices_RangeValidation() throws InterruptedException {
        Assert.assertTrue(strRangePC.equalsIgnoreCase(errorPC.getText()));
        System.out.println("Range Validation is present for PC on the Deemed Power Prices Screen");
        Assert.assertTrue(strRangeUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Range Validation is present for Rate Unit on the Deemed Power Prices Screen");
        Assert.assertTrue(strRangeStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Range Validation is present for Standing Charge on the Deemed Power Prices Screen");
    }

    public void DeemedPowerPrices_NumericValidation() throws InterruptedException {
        Assert.assertTrue(strValidPC.equalsIgnoreCase(errorPC.getText()));
        System.out.println("Range Validation is present for Max Vol on the Deemed Gas Prices Screen");
        Assert.assertTrue(strValidUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Range Validation is present for Rate Unit on the Deemed Gas Prices Screen");
        Assert.assertTrue(strValidStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Range Validation is present for Standing Charge on the Deemed Gas Prices Screen");
    }

    public void DeemedPowerPrices_MandatoryValidation() throws InterruptedException {
        Assert.assertTrue(strMandatoryPC.equalsIgnoreCase(errorPC.getText()));
        System.out.println("Mandatory Validation is present for PC on the Deemed Power Prices Screen");
        Assert.assertTrue(strMandatoryUnitRate.equalsIgnoreCase(errorUnitRate.getText()));
        System.out.println("Mandatory Validation is present for Rate Unit on the Deemed Power Prices Screen");
        Assert.assertTrue(strMandatoryStandingCharge.equalsIgnoreCase(errorStandingCharge.getText()));
        System.out.println("Mandatory Validation is present for Standing Charge on the Deemed Power Prices Screen");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
