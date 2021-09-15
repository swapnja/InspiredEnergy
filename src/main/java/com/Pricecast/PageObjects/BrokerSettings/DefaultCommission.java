package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.testng.Assert;

import java.util.Properties;

public class DefaultCommission {
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    Properties _prop;
    private CommonPageHandler cph;
    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonSettings;
    private ElementHandler buttonAddNewRow;
    private ElementHandler linkSupplierVolumeBands;
    private ElementHandler btnAdd;
    private ElementHandler btnOk;
    private ElementHandler txtBoxDefaultCommisionDuration;
    private ElementHandler ddDefaultCommisionRenewalFlag;
    private ElementHandler txtBoxDefaultCommisionMaxVol;
    private ElementHandler txtBoxDefaultCommisionMinVol;
    private ElementHandler txtBoxDefaultCommisionRateUplift;
    private ElementHandler txtBoxDefaultCommisionGrossUplift;
    private ElementHandler ddDefaultCommisionProduct;
    private ElementHandler errorDuration;
    private ElementHandler errorMinVol;
    private ElementHandler errorMaxVol;
    private ElementHandler errorRateUplift;
    private ElementHandler errorGrossUplift;

    //Mandatory
    String strMandatoryDuration = "Duration field is mandatory";
    String strMandatoryMinVol = "Min Vol field is mandatory";
    String strMandatoryMaxVol = "Max Vol field is mandatory";
    String strMandatoryRateUplift = "Rate Uplift field is mandatory";
    String strMandatoryGrossUplift = "Gross Uplift field is mandatory";

    //Range
    String strRangeDuration = "Please enter a number between 0 and 10000";
    String strRangeMinVol = "Please enter a number between 0 and 1000000000";
    String strRangeMaxVol = "Please enter a number between 0 and 1000000000";
    String strRangeRateUplift = "Please enter a number between 0 and 1000000000";
    String strRangeGrossUplift = "Please enter a number between 0 and 1000000000";

    //Numeric
    String strNumericDuration = "Please enter a valid number.";
    String strNumericMinVol = "Please enter a valid number.";
    String strNumericMaxVol = "Please enter a valid number.";
    String strNumericRateUplift = "The field Rate Uplift: must be a number.";
    String strNumericGrossUplift = "The field Gross Uplift: must be a number.";

    public DefaultCommission(WebDriverHandler webDriverHandler) {
        cph = new CommonPageHandler(webDriverHandler, _prop);
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierVolumeBands = _webDriverHandler.byXpath("//a[@data-action='DefaultCommission']");
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddDefaultCommission']");
        btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");

        txtBoxDefaultCommisionDuration = _webDriverHandler.byXpath("//*[@id='Duration']");
        ddDefaultCommisionRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
        txtBoxDefaultCommisionMaxVol = _webDriverHandler.byXpath("//*[@id='MaxVol']");
        txtBoxDefaultCommisionMinVol = _webDriverHandler.byXpath("//*[@id='MinVol']");
        txtBoxDefaultCommisionRateUplift = _webDriverHandler.byXpath("//*[@id='RateUplift']");
        txtBoxDefaultCommisionGrossUplift = _webDriverHandler.byXpath("//*[@id='GrossUplift']");
        ddDefaultCommisionProduct = _webDriverHandler.byXpath("//*[@id='SupplierProductFilterID']");
        errorDuration = _webDriverHandler.byXpath("//*[@id='Duration-error']");
        errorMinVol = _webDriverHandler.byXpath("//*[@id='MinVol-error']");
        errorMaxVol = _webDriverHandler.byXpath("//*[@id='MaxVol-error']");
        errorRateUplift = _webDriverHandler.byXpath("//*[@id='RateUplift-error']");
        errorGrossUplift = _webDriverHandler.byXpath("//*[@id='GrossUplift-error']");

    }
//Default Commision


    public String[] tblDefaultCommission = new String[]{"Duration", "Renewal Flag", "Min Vol", "Max Vol", "Rate Uplift", "Gross Uplift", "Product", "Actions"};
    public String[] arrDefaultCommission = new String[8];

    public void defaultCommision_ColumnVerification() {
        for (int i = 0; i < arrDefaultCommission.length; i++) {
            arrDefaultCommission[i] = _webDriverHandler.byXpath("//table[@id='tblDefaultCommission']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDefaultCommission[i].equals(arrDefaultCommission[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkSupplierVolumeBands.click();
    }

    public void DefaultCommision_addNewRow(int Duration, int RenewalFlag, int MinVol, int MaxVol, int RateUplift, int GrossUplift, int product) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDefaultCommisionDuration.clear().sendKeys(Duration + "");
        ddDefaultCommisionRenewalFlag.selectByIndex(RenewalFlag);
        txtBoxDefaultCommisionMinVol.clear().sendKeys(MinVol + "");
        txtBoxDefaultCommisionMaxVol.clear().sendKeys(MaxVol + "");
        txtBoxDefaultCommisionRateUplift.clear().sendKeys(RateUplift + "");
        txtBoxDefaultCommisionGrossUplift.clear().sendKeys(GrossUplift + "");
        //ddDefaultCommisionProduct.selectByValue(product+"");
        btnAdd.waitClickable(10, 100).click();
        btnOk.waitClickable(10,100).click();
    }

    public void DefaultCommision_RangeaddNewRow(int Duration, int RenewalFlag, int MinVol, int MaxVol, int RateUplift, int GrossUplift, int product) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDefaultCommisionDuration.clear().sendKeys(Duration + "");
        ddDefaultCommisionRenewalFlag.selectByIndex(RenewalFlag);
        txtBoxDefaultCommisionMinVol.clear().sendKeys(MinVol + "");
        txtBoxDefaultCommisionMaxVol.clear().sendKeys(MaxVol + "");
        txtBoxDefaultCommisionRateUplift.clear().sendKeys(RateUplift + "");
        txtBoxDefaultCommisionGrossUplift.clear().sendKeys(GrossUplift + "");
        btnAdd.waitClickable(10, 100).click();
    }

    public void DefaultCommision_NumericaddNewRow(int Duration, int RenewalFlag, int MinVol, int MaxVol, int RateUplift, int GrossUplift, int product) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDefaultCommisionDuration.clear().sendKeys(Duration + "ee");
        ddDefaultCommisionRenewalFlag.selectByIndex(RenewalFlag);
        txtBoxDefaultCommisionMinVol.clear().sendKeys(MinVol + "ee");
        txtBoxDefaultCommisionMaxVol.clear().sendKeys(MaxVol + "ee");
        txtBoxDefaultCommisionRateUplift.clear().sendKeys(RateUplift + "ee");
        txtBoxDefaultCommisionGrossUplift.clear().sendKeys(GrossUplift + "ee");
        //ddDefaultCommisionProduct.selectByValue(product+"");
        btnAdd.waitClickable(10, 100).click();
        //btnOk.waitClickable(10,100).click();
    }

    public void DefaultCommision_NumericValidation() {
        Assert.assertTrue(strNumericDuration.equalsIgnoreCase(errorDuration.getText()));
        System.out.println("Numeric Validation is present for Duration on the Default Commision Screen");
        Assert.assertTrue(strNumericMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Numeric Validation is present for Min Vol on the Default Commision Screen");
        Assert.assertTrue(strNumericMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Numeric Validation is present for Max Vol on the Default Commision Screen");
        Assert.assertTrue(strNumericRateUplift.equalsIgnoreCase(errorRateUplift.getText()));
        System.out.println("Numeric Validation is present for Rate Uplift on the Default Commision Screen");
        Assert.assertTrue(strNumericGrossUplift.equalsIgnoreCase(errorGrossUplift.getText()));
        System.out.println("Numeric Validation is present for Gross Uplift on the Default Commision Screen");

    }

    public void DefaultCommision_MandatoryRangeValidation() throws InterruptedException {
        Assert.assertTrue(strMandatoryDuration.equalsIgnoreCase(errorDuration.getText()));
        System.out.println("Duration is Mandatory fields on Default Commision on the Screen");
        Assert.assertTrue(strMandatoryMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Min Volumne is Mandatory fields on Default Commision on the Screen");
        Assert.assertTrue(strMandatoryMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Max Volumne is Mandatory fields on Default Commision on the Screen");
        Assert.assertTrue(strMandatoryRateUplift.equalsIgnoreCase(errorRateUplift.getText()));
        System.out.println("Rate Uplift is Mandatory fields on Default Commision on the Screen");
        Assert.assertTrue(strMandatoryGrossUplift.equalsIgnoreCase(errorGrossUplift.getText()));
        System.out.println("Gross Uplift is Mandatory fields on Default Commision on the Screen");
    }

    public void DefaultCommision_RangeValidation() throws InterruptedException {
        Assert.assertTrue(strRangeDuration.equalsIgnoreCase(errorDuration.getText()));
        System.out.println("Range Validation is present for Duration on the Default Commision Screen");
        Assert.assertTrue(strRangeMinVol.equalsIgnoreCase(errorMinVol.getText()));
        System.out.println("Range Validation is present for Min Vol on the Default Commision Screen");
        Assert.assertTrue(strRangeMaxVol.equalsIgnoreCase(errorMaxVol.getText()));
        System.out.println("Range Validation is present for Max Vol on the Default Commision Screen");
        Assert.assertTrue(strRangeRateUplift.equalsIgnoreCase(errorRateUplift.getText()));
        System.out.println("Range Validation is present for Rate Uplift on the Default Commision Screen");
        Assert.assertTrue(strRangeGrossUplift.equalsIgnoreCase(errorGrossUplift.getText()));
        System.out.println("Range Validation is present for Gross Uplift on the Default Commision Screen");
    }

    public void DefaultCommision_blankaddNewRow(int RenewalFlag) {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxDefaultCommisionDuration.clear();
        ddDefaultCommisionRenewalFlag.selectByIndex(RenewalFlag);
        txtBoxDefaultCommisionMinVol.clear();
        txtBoxDefaultCommisionMaxVol.clear();
        txtBoxDefaultCommisionRateUplift.clear();
        txtBoxDefaultCommisionGrossUplift.clear();
        //ddDefaultCommisionProduct.selectByValue(product+"");
        btnAdd.waitClickable(10, 100).click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }

}
