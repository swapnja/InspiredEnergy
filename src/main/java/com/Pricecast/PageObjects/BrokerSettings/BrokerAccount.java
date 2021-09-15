package com.Pricecast.PageObjects.BrokerSettings;


import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.Properties;

public class BrokerAccount {
    //WebDriverHandler webDriverHandler;
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    Properties _prop;
    private CommonPageHandler cph;

    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonSettings;
    private ElementHandler txtBoxGasQuote;
    private ElementHandler txtBoxGasFooter;
    private ElementHandler txtBoxPowerQuote;
    private ElementHandler txtBoxPowerFooter;
    private ElementHandler txtBoxBulkSliderIncrement;
    private ElementHandler txtBoxBulkSliderMaxUplift;
    private ElementHandler btnOk;
    private ElementHandler msgSuccess;
    private ElementHandler btnSave;
    private ElementHandler togbtnCurrentRenewalQuote;
    private ElementHandler togbtnShowFiTQuote;
    private ElementHandler togbtnShowEndDate;
    private ElementHandler togbtnLowestQuoteFirst;
    private ElementHandler togbtnPowerRatesInGrid;
    private ElementHandler togbtnShowLogoOnQuote;
    private ElementHandler togbtnUseLogoOnLogin;
    private ElementHandler togbtnUseKWhforsplits;
    private ElementHandler togbtnShowToplineOnQuote;
    private ElementHandler msgLocationBulkSliderIncrement;
    private ElementHandler msgLocationBulkSliderMaxUplift;
    private ElementHandler linkBrokerAccount;

    private ElementHandler sliderCurrentRenewalQuote;
    private ElementHandler sliderShowFiTQuote;
    private ElementHandler sliderShowEndDate;
    private ElementHandler sliderLowestQuoteFirst;
    private ElementHandler sliderPowerRatesInGrid;
    private ElementHandler sliderShowLogoOnQuote;
    private ElementHandler slideUseLogoOnLogin;
    private ElementHandler sliderUseKWhforsplits;
    private ElementHandler sliderShowToplineOnQuote;

    public BrokerAccount(WebDriverHandler webDriverHandler) {
        cph = new CommonPageHandler(webDriverHandler, _prop);
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkBrokerAccount = _webDriverHandler.byXpath("//a[@data-action='BrokerAccount']");
        txtBoxGasQuote = _webDriverHandler.byXpath("//*[@id='GasQuoteText']");
        txtBoxGasFooter = _webDriverHandler.byXpath("//*[@id='GasFooterText']");
        txtBoxPowerQuote = _webDriverHandler.byXpath("//*[@id='PowerQuoteText']");
        txtBoxPowerFooter = _webDriverHandler.byXpath("//*[@id='PowerFooterText']");
        txtBoxBulkSliderIncrement = _webDriverHandler.byXpath("//*[@id='BulkSliderIncrement']");
        txtBoxBulkSliderMaxUplift = _webDriverHandler.byXpath("//*[@id='BulkSliderMaxUplift']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        msgSuccess = _webDriverHandler.byXpath("//*[@id='swal2-title']");
        btnSave = _webDriverHandler.byXpath("//*[@type='submit']");
        togbtnCurrentRenewalQuote = _webDriverHandler.byXpath("//input[@id='CurrentRenewalQuote']");
        togbtnShowFiTQuote = _webDriverHandler.byXpath("//input[@id='ShowFiTQuote']");
        togbtnShowEndDate = _webDriverHandler.byXpath("//input[@id='ShowEndDate']");
        togbtnLowestQuoteFirst = _webDriverHandler.byXpath("//input[@id='LowestQuoteFirst']");
        togbtnPowerRatesInGrid = _webDriverHandler.byXpath("//input[@id='PowerRatesInGrid']");
        togbtnShowLogoOnQuote = _webDriverHandler.byXpath("//input[@id='ShowLogoOnQuote']");
        togbtnUseLogoOnLogin = _webDriverHandler.byXpath("//input[@id='UseLogoOnLogin']");
        togbtnUseKWhforsplits = _webDriverHandler.byXpath("//input[@id='UseKWhforsplits']");
        togbtnShowToplineOnQuote = _webDriverHandler.byXpath("//input[@id='ShowToplineOnQuote']");

        msgLocationBulkSliderIncrement = _webDriverHandler.byXpath("//*[@id='BulkSliderIncrement-error']");
        msgLocationBulkSliderMaxUplift = _webDriverHandler.byXpath("//*[@id='BulkSliderMaxUplift-error']");

        //sliders
        sliderCurrentRenewalQuote = _webDriverHandler.byXpath("//*[@id='CurrentRenewalQuote']");
        sliderShowFiTQuote = _webDriverHandler.byXpath("//*[@id='ShowFiTQuote']");
        sliderShowEndDate = _webDriverHandler.byXpath("//*[@id='ShowEndDate']");
        sliderLowestQuoteFirst = _webDriverHandler.byXpath("//*[@id='LowestQuoteFirst']");
        sliderPowerRatesInGrid = _webDriverHandler.byXpath("//*[@id='PowerRatesInGrid']");
        sliderShowLogoOnQuote = _webDriverHandler.byXpath("//*[@id='ShowLogoOnQuote']");
        slideUseLogoOnLogin = _webDriverHandler.byXpath("//*[@id='UseLogoOnLogin']");
        sliderUseKWhforsplits = _webDriverHandler.byXpath("//*[@id='UseKWhforsplits']");
        sliderShowToplineOnQuote = _webDriverHandler.byXpath("//*[@id='ShowToplineOnQuote']");

    }

    //Mandatory messages
    String strMandatoryBulkSliderIncrement = "Bulk Slider Increment field is mandatory";
    String strMandatoryBulkSliderMaxUplift = "Bulk Slider Max Uplift field is mandatory";
    //Range validation messages
    String strRangeBulkSliderIncrement = "Please enter a number in between 0 and 1000000000";
    String strRangeBulkSliderMaxUplift = "Please enter a number in between 0 and 1000000000";
    //Numeric validation messages
    String strNumericBulkSliderIncrement = "Please enter a number in between 0 and 1000000000";
    String strNumericBulkSliderMaxUplift = "Please enter a number in between 0 and 1000000000";
    //Validation message xpath

    public void formFillup(String strGasQuoteText, String strGasFooterText, String strPowerQuoteText, String strPowerFooterText, String dblTxtBoxBulkSliderIncrement, String dblTxtBoxBulkSliderMaxUplift) throws InterruptedException {
        Thread.sleep(3000);
        buttonSettings.click();
        Thread.sleep(3000);
        txtBoxGasQuote.clear().sendKeys(strGasQuoteText);
        txtBoxGasFooter.clear().sendKeys(strGasFooterText);
        txtBoxPowerQuote.clear().waitVisible(10, 100).sendKeys(strPowerQuoteText);
        txtBoxPowerFooter.clear().sendKeys(strGasFooterText);
        txtBoxBulkSliderIncrement.clear().sendKeys(dblTxtBoxBulkSliderIncrement, Keys.TAB);
        txtBoxBulkSliderMaxUplift.clear().sendKeys(dblTxtBoxBulkSliderMaxUplift, Keys.TAB);
        //sliderCurrentRenewalQuote.selectSlider(true);
        sliderShowFiTQuote.selectSlider(true);
        sliderShowEndDate.selectSlider(false);
        sliderLowestQuoteFirst.selectSlider(true);
        sliderPowerRatesInGrid.selectSlider(true);
        sliderShowLogoOnQuote.selectSlider(false);
        //slideUseLogoOnLogin.selectSlider(true);
        sliderUseKWhforsplits.selectSlider(false);
        sliderShowToplineOnQuote.selectSlider(true);
        btnSave.scrollDown().click();
    }

    public void BrokerAccount_RangeValidation() {
        Assert.assertTrue(msgLocationBulkSliderIncrement.isDisplayed() && msgLocationBulkSliderMaxUplift.isDisplayed());
        System.out.println("Bulk Slider Increment is present on the screen");
        Assert.assertEquals(msgLocationBulkSliderIncrement.getText(), strRangeBulkSliderIncrement);
        Assert.assertEquals(msgLocationBulkSliderMaxUplift.getText(), strRangeBulkSliderMaxUplift);
        System.out.println("Range Validation for Bulk Slider Increment and BulkSliderMaxUplift are Passed");
    }

    public void BrokerAccount_NumericValidation() throws Exception {
        if (msgLocationBulkSliderIncrement.getText().equalsIgnoreCase(strNumericBulkSliderIncrement)
                && msgLocationBulkSliderMaxUplift.getText().equalsIgnoreCase(strNumericBulkSliderMaxUplift)) {

            System.out.println("Range Validation for Bulk Slider Increment and BulkSliderMaxUplift are failed");
        } else {
            throw new Exception("Manual Exception");
        }
    }

    public void BrokerAccount_MandatoryValidation() {
        if (msgLocationBulkSliderIncrement.getText().equalsIgnoreCase(strMandatoryBulkSliderIncrement)
                && msgLocationBulkSliderMaxUplift.getText().equalsIgnoreCase(strMandatoryBulkSliderMaxUplift)) {
            System.out.println("Bulk Slider Increment and BulkSliderMaxUplift are Mandatory fields on Broker Account Screen");
        }
    }

    public void BrokerAccount_DefaultValidation() {

    }

}
