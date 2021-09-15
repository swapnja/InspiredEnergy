package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class PowerQuote {

    WebDriverHandler _webDriverHandler;
    ElementHandler linkPower;
    ElementHandler btnAddnewQuotePower;
    ElementHandler txtMPAN;
    ElementHandler ddPC;
    ElementHandler txtMTC;
    ElementHandler txtLLF;
    ElementHandler txtEAC;
    ElementHandler chkboxDefault;
    ElementHandler ddSupplier;
    ElementHandler ddMeter;
    ElementHandler calendarStartDate;
    ElementHandler radiobtnDirectPaymentType;
    ElementHandler radiobtnCashPaymentType;
    ElementHandler txtQuoteRef;
    ElementHandler btnUpdateQuote;
    ElementHandler btnExcel;
    ElementHandler btnPdf;
    ElementHandler btnGetQuote;
    ElementHandler btnCloseSplits;
    ElementHandler btnCloseCompare;
    ElementHandler msgMPAN;
    ElementHandler msgMTC;
    ElementHandler msgLLF;
    ElementHandler msgEAC;
    ElementHandler msgStartDate;
    ElementHandler msgSupplier;
    ElementHandler btnAddQuote;
    ElementHandler ddQuoteType;
    ElementHandler txtSCharge;
    ElementHandler txtRate1;
    ElementHandler txtRate2;
    ElementHandler txtSplit1;
    ElementHandler txtSplit2;
    ElementHandler ddChargeType1;
    ElementHandler ddChargeType2;
    ElementHandler txtDiscount;
    ElementHandler btnAddToList;
    ElementHandler ddlAddQuoteSupplier;
    ElementHandler ddlDuration;
    ElementHandler txtCommissionAmount;
    ElementHandler CalExpiryDate;
    ElementHandler btnCompareSelected;
    ElementHandler txtFitUplift;

    public PowerQuote(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        linkPower = _webDriverHandler.byXpath("//a[@data-action='Quotes/Power']");
        btnAddnewQuotePower = _webDriverHandler.byXpath("//*[@id='btnNewPowerQuote']");
        btnGetQuote = _webDriverHandler.byXpath("//*[contains(text(),'Get Quote')]");
        txtMPAN = _webDriverHandler.byXpath("//*[@id='MPAN']");
        ddPC = _webDriverHandler.byXpath("//*[@id='ProfileClass']");
        txtMTC = _webDriverHandler.byXpath("//*[@id='MTC']");
        txtLLF = _webDriverHandler.byXpath("//*[@id='LLF']");
        txtEAC = _webDriverHandler.byXpath("//*[@id='EAC']");
        chkboxDefault = _webDriverHandler.byXpath("//*[@id='chkDefaultEAC']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='SupplierId']");
        ddMeter = _webDriverHandler.byXpath("//*[@id='MeterType']");
        calendarStartDate = _webDriverHandler.byXpath("//*[@id='StartDate']");
        radiobtnDirectPaymentType = _webDriverHandler.byXpath("//*[@id='paymentType_0']");
        radiobtnCashPaymentType = _webDriverHandler.byXpath("//*[@id='paymentType_1']");
        txtQuoteRef = _webDriverHandler.byXpath("//*[@id='QuoteRef']");
        btnUpdateQuote = _webDriverHandler.byXpath("//*[@id='UpdateQuote']");
        btnExcel = _webDriverHandler.byXpath("//*[@id='exportExcel']");
        btnPdf = _webDriverHandler.byXpath("//*[@id='exportPDF']");
        btnCloseSplits = _webDriverHandler.byXpath("//div[@id='modalSplitsGrid']//button[contains(text(),'Close')]");
        btnCloseCompare = _webDriverHandler.byXpath("//div[@id='modalComparePowerQuotes']//button[contains(text(),'Close')]");
        msgMPAN = _webDriverHandler.byXpath("//span[@id='MPAN-error']");
        msgMTC = _webDriverHandler.byXpath("//span[@id='MTC-error']");
        msgLLF = _webDriverHandler.byXpath("//span[@id='LLF-error']");
        msgEAC = _webDriverHandler.byXpath("//span[@id='EAC-error']");
        msgStartDate = _webDriverHandler.byXpath("//span[@id='StartDate-error']");
        msgSupplier = _webDriverHandler.byXpath("//span[@id='SupplierId-error']");
        btnAddQuote = _webDriverHandler.byXpath("//button[contains(text(),'Add Quote')]");
        ddQuoteType = _webDriverHandler.byXpath("//*[@id='ddlPowerQuoteType']");
        txtSCharge = _webDriverHandler.byXpath("//*[@id='txtSCharge']");
        ddChargeType1 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[@name='charge-type'])[1]");
        ddChargeType2 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[@name='charge-type'])[2]");
        txtRate1 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[contains(@class, 'rate')])[1]");
        txtRate2 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[contains(@class, 'rate')])[2]");
        txtSplit1 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[contains(@class, 'split numeric')])[1]");
        txtSplit2 = _webDriverHandler.byXpath("(//*[@id='splitFields']//*[contains(@class, 'split numeric')])[2]");
        txtDiscount = _webDriverHandler.byXpath("//*[@id='txtDiscountPer']");
        txtFitUplift = _webDriverHandler.byXpath("//*[@id='txtFitUplift']");
        btnAddToList = _webDriverHandler.byXpath("//button[contains(text(),'Add to list')]");
        ddlAddQuoteSupplier = _webDriverHandler.byXpath("//*[@id='ddlBrokerBespoke']");
        ddlDuration = _webDriverHandler.byXpath("//*[@id='ddlDuration']");
        txtCommissionAmount = _webDriverHandler.byXpath("//*[@id='txtCommission']");
        CalExpiryDate = _webDriverHandler.byXpath("//*[@id='ExpiryDate']");
        btnCompareSelected = _webDriverHandler.byXpath("//button[contains(text(),'Compare Selected')]");
    }

    //Mandatory Message
    String strMandatoryMPAN = "MPAN Field is mandatory";
    String strMandatoryMTC = "MTC Field is mandatory";
    String strMandatoryLLF = "LLF Field is mandatory";
    String strMandatoryEAC = "EAC (kWh) Field is mandatory";
    String strMandatorySupplier = "Supplier Field is mandatory";
    String strMandatoryStartDate = "Start Date Field is mandatory";

    //Character limit validation messages
    String strLimitMPAN = "MPAN should be a 13 digit numeric value";
    String strLimitMTC = "Please enter no more than 5 characters.";
    String strLimitLLF = "Please enter no more than 5 characters.";
    String strLimitEAC = "Please enter no more than 10 characters.";

    //Range validation messages
    String strRangeMPAN = "MPAN should be a 13 digit numeric value";
    String strRangeMTC = "Please enter a non decimal number between 1 and 99999";
    String strRangeLLF = "Please enter a non decimal number between 1 and 99999";
    String strRangeEAC = "Please enter a non decimal number between 1 and 9999999";
    String strRangeEACND = "Please enter a number between 1 and 9999999";
    String strRangeStartDate = "Start Date Field is invalid.";

    public String[] tblPower = new String[]{"QuoteID", "QuoteRef", "QuoteDate", "Supplier", "MPAN", "PC", "MTC", "LLF", "EAC", "METER", "StartDate", "PaymentType", "Agent", "Action"};

    public void powerQuote_MandatoryValidation() {
        Assert.assertEquals(msgMPAN.getText(), strMandatoryMPAN);
        Assert.assertEquals(msgMTC.getText(), strMandatoryMTC);
        Assert.assertEquals(msgLLF.getText(), strMandatoryLLF);
        Assert.assertEquals(msgEAC.getText(), strMandatoryEAC);
        Assert.assertEquals(msgStartDate.getText(), strMandatoryStartDate);
        Assert.assertEquals(msgSupplier.getText(), strMandatorySupplier);
    }

    public void powerQuote_Validation() {
        Assert.assertEquals(msgMPAN.getText(), strRangeMPAN);
        Assert.assertEquals(msgMTC.getText(), strRangeMTC);
        Assert.assertEquals(msgLLF.getText(), strRangeLLF);
        Assert.assertEquals(msgEAC.getText(), strRangeEAC);
        Assert.assertEquals(msgStartDate.getText(), strRangeStartDate);
    }

    public void powerQuote_LimitValidation() {
        Assert.assertEquals(msgMPAN.getText(), strLimitMPAN);
        Assert.assertEquals(msgMTC.getText(), strLimitMTC);
        Assert.assertEquals(msgLLF.getText(), strLimitLLF);
        Assert.assertEquals(msgEAC.getText(), strLimitEAC);
    }

    public void powerQuote_NonDecimalEAC() {
        Assert.assertEquals(msgEAC.getText(), strRangeEACND);
    }

    public void AddNewPowerQuote(String mpan, int pc, int mtc, String llf, int eac, String supplier) throws InterruptedException {
        waitLoad();
        linkPower.click();
        waitLoad();
        btnAddnewQuotePower.waitClickable().click();
        waitLoad();
        txtMPAN.clear().sendKeys(mpan);
        ddPC.selectByValue(pc + "");
        txtMTC.clear().sendKeys(mtc + "");
        txtLLF.clear().sendKeys(llf + "");
        txtEAC.clear().sendKeys(eac + "");
        ddSupplier.selectByText(supplier);
        calendarStartDate.clear().sendKeys("01/01/2022", Keys.ESCAPE);
        btnGetQuote.click();
waitLoad();
btnCloseSplits.click();
    }

    public void AddNewPowerValidation() {
        waitLoad();
        linkPower.click();
        waitLoad();
        btnAddnewQuotePower.waitClickable().click();
        waitLoad();
        txtMPAN.clear().sendKeys("16100R7670402");
        ddPC.selectByValue("2");
        txtMTC.clear().sendKeys("-2");
        txtLLF.clear().sendKeys("4.56");
        txtEAC.clear().sendKeys("15000000.0");
        ddSupplier.selectByText("British Gas");
        calendarStartDate.clear().sendKeys("01/01/201", Keys.ESCAPE);
        btnGetQuote.click();
        powerQuote_Validation();
        txtMPAN.clear().sendKeys("161670402");
        txtMTC.clear().sendKeys("125468");
        txtLLF.clear().sendKeys("12547896");
        txtEAC.clear().sendKeys("15000000000");
        btnGetQuote.click();
        powerQuote_LimitValidation();
        txtEAC.clear().sendKeys("14999980");
        btnGetQuote.click();
        powerQuote_NonDecimalEAC();
    }

    public void AddNewPowerQuoteMandatoryValidation() {
        waitLoad();
        linkPower.click();
        waitLoad();
        btnAddnewQuotePower.waitClickable().click();
        waitLoad();
        txtMPAN.clear();
        txtMTC.clear();
        txtLLF.clear();
        txtEAC.clear();
        calendarStartDate.clear().sendKeys(Keys.ESCAPE);
        btnGetQuote.click();
    }

    public void quoteSelectionUserDefinedQuotes() {
        _webDriverHandler.byXpath("//*[@id='id_10']/td/div/input").waitClickable(15,100).click();
        _webDriverHandler.byXpath("//*[@id='id_12']/td/div/input").waitClickable(15,100).click();
        _webDriverHandler.byXpath("//*[@id='id_16']/td/div/input").waitClickable(15,100).click();
        _webDriverHandler.byXpath("//*[@id='id_14']/td/div/input").waitClickable(15,100).click();
    }

    public void quoteSelection() {
        _webDriverHandler.byXpath("//*[@id='id_10']/td/div/input").click();
        _webDriverHandler.byXpath("//*[@id='id_12']/td/div/input").click();
        _webDriverHandler.byXpath("//*[@id='id_16']/td/div/input").click();
        _webDriverHandler.byXpath("//*[@id='id_14']/td/div/input").click();
        _webDriverHandler.byXpath("//button[contains(text(),'Quote Selected')]").waitClickable(10, 100).click();
    }

    public void addUserDefinedQuote(String quoteType, int sCharge, String chrgType1, String chrgType2, int rate1, int rate2, int split1, int split2, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType);
        txtSCharge.clear().sendKeys(sCharge + "");
        ddChargeType1.selectByValue(chrgType1);
        ddChargeType2.selectByValue(chrgType2);
        txtRate1.clear().sendKeys(rate1+"");
        txtRate2.clear().sendKeys(rate2+"");
        txtSplit1.clear().sendKeys(split1+"");
        txtSplit2.clear().sendKeys(split2+"");
        txtDiscount.clear().sendKeys(discount + "");
        btnAddToList.click();
    }

    public void addUserDefinedQuoteBespoke(String quoteType, String BrokerBespoke, int sCharge, String chrgType1, String chrgType2, int rate1, int rate2, int split1, int split2, int commision, int FitUplift, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType);
        waitLoad();
        ddlAddQuoteSupplier.selectByText(BrokerBespoke);
        ddlDuration.selectByValue("12");
        txtSCharge.clear().sendKeys(sCharge + "");
        ddChargeType1.selectByValue(chrgType1);
        ddChargeType2.selectByValue(chrgType2);
        txtRate1.clear().sendKeys(rate1+"");
        txtRate2.clear().sendKeys(rate2+"");
        txtSplit1.clear().sendKeys(split1+"");
        txtSplit2.clear().sendKeys(split2+"");
        txtCommissionAmount.clear().sendKeys(commision + "");
        txtFitUplift.clear().sendKeys(FitUplift+"");
        txtDiscount.clear().sendKeys(discount + "");
        CalExpiryDate.clear().sendKeys("08/12/2020", Keys.ESCAPE);
        btnAddToList.waitClickable(15, 100).click();
    }

    public void addUserDefinedQuoteCustomer(String quoteType, String customerOther, int sCharge, String chrgType1, String chrgType2, int rate1, int rate2, int split1, int split2, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType);
        waitLoad();
        ddlAddQuoteSupplier.selectByText(customerOther);
        ddlDuration.selectByValue("24");
        txtSCharge.clear().sendKeys(sCharge + "");
        ddChargeType1.selectByValue(chrgType1);
        ddChargeType2.selectByValue(chrgType2);
        txtRate1.clear().sendKeys(rate1+"");
        txtRate2.clear().sendKeys(rate2+"");
        txtSplit1.clear().sendKeys(split1+"");
        txtSplit2.clear().sendKeys(split2+"");
        txtDiscount.clear().sendKeys(discount +"");
        btnAddToList.click();
    }

    public void quoteComparison() {
        btnCompareSelected.click();
        btnCloseCompare.waitClickable().click();
    }

    public void excelFileDownload() {
    	waitLoad();
        btnExcel.waitClickable().click();
    }

    public void pdfFileDownload() {
    
        btnPdf.waitClickable(15,100).waitVisible(15,100).click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15, 100).waitInvisible(20, 100);
    }


}

