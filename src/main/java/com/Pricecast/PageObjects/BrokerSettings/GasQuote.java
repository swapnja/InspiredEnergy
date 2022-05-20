package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.io.IOException;

public class GasQuote {

    WebDriverHandler _webDriverHandler;
    ElementHandler linkGas;
    ElementHandler btnAddnewQuoteGas;
    ElementHandler txtPostCode;
    ElementHandler txtAQ;
    ElementHandler ddSupplier;
    ElementHandler chkboxCot;
    ElementHandler calendarStartDate;
    ElementHandler radiobtnDirectPaymentType;
    ElementHandler radiobtnCashPaymentType;
    ElementHandler txtQuoteRef;
    ElementHandler btnUpdateQuote;
    ElementHandler btnExcel;
    ElementHandler btnPdf;
    ElementHandler btnGetQuote;
    ElementHandler msgPostcode;
    ElementHandler msgAQ;
    ElementHandler msgStartDate;
    ElementHandler btnCompareSelected;
    ElementHandler btnAddQuote;
    ElementHandler ddQuoteType;
    ElementHandler txtSCharge;
    ElementHandler txtUnitPrice;
    ElementHandler txtDiscount;
    ElementHandler btnAddToList;
    ElementHandler ddlBrokerBespoke;
    ElementHandler ddlDuration;
    ElementHandler txtCommissionAmount;
    ElementHandler CalExpiryDate;
    ElementHandler btnClose;


    public GasQuote(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        linkGas = _webDriverHandler.byXpath("//a[@data-action='Quotes/Gas']");
        btnAddnewQuoteGas = _webDriverHandler.byXpath("//*[@id='btnNewGasQuote']");
        btnGetQuote = _webDriverHandler.byXpath("//*[contains(text(),'Get Quote')]");
        txtPostCode = _webDriverHandler.byXpath("//*[@id='PostCode']");
        txtAQ = _webDriverHandler.byXpath("//*[@id='AQ']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='SupplierId']");
        chkboxCot = _webDriverHandler.byXpath("//label[@class='switch'][1]");
        calendarStartDate = _webDriverHandler.byXpath("//*[@id='StartDate']");
        radiobtnDirectPaymentType = _webDriverHandler.byXpath("//*[@id='paymentType_0']");
        radiobtnCashPaymentType = _webDriverHandler.byXpath("//*[@id='paymentType_1']");
        txtQuoteRef = _webDriverHandler.byXpath("//*[@id='QuoteRef']");
        btnUpdateQuote = _webDriverHandler.byXpath("//*[@id='UpdateQuote']");
        btnExcel = _webDriverHandler.byXpath("//*[@id='exportExcel']");
        btnPdf = _webDriverHandler.byXpath("//*[@id='exportPDF']");
        msgPostcode = _webDriverHandler.byXpath("//*[@id='PostCode-error']");
        msgAQ = _webDriverHandler.byXpath("//*[@id='AQ-error']");
        msgStartDate = _webDriverHandler.byXpath("//*[@id='StartDate-error']");
        btnCompareSelected = _webDriverHandler.byXpath("//button[contains(text(),'Compare Selected')]");
        btnAddQuote = _webDriverHandler.byXpath("//button[contains(text(),'Add Quote')]");
        ddQuoteType = _webDriverHandler.byXpath("//*[@id='ddlQuoteType']");
        txtSCharge = _webDriverHandler.byXpath("//*[@id='txtSCharge']");
        txtUnitPrice = _webDriverHandler.byXpath("//*[@id='txtUnitPrice']");
        txtDiscount = _webDriverHandler.byXpath("//*[@id='txtDiscountPer']");
        btnAddToList = _webDriverHandler.byXpath("//button[contains(text(),'Add to list')]");
        ddlBrokerBespoke = _webDriverHandler.byXpath("//*[@id='ddlBrokerBespoke']");
        ddlDuration = _webDriverHandler.byXpath("//*[@id='ddlDuration']");
        txtCommissionAmount = _webDriverHandler.byXpath("//*[@id='txtCommission']");
        CalExpiryDate = _webDriverHandler.byXpath("//*[@id='ExpiryDate']");
        btnClose = _webDriverHandler.byXpath("//div[@class='modal modal-fade modalInput show']//button[@class='btn btn-sm btn-danger']");
    }

    //Mandatory Message
    String strMandatoryPostCode = "Postcode Field is mandatory";
    String strMandatoryAQ = "AQ Field is mandatory";
    String strMandatorySupplier = "Supplier Field is mandatory";
    String strMandatoryStartDate = "Start Date Field is mandatory";

    //Range validation messages
    String strValidationPostCode = "Please enter a valid UK Postcode.";
    String strValidationAQ = "Please enter a number between 1 and 9999999";
    String strValidationStartDate = "Start Date Field is invalid";


    public String[] tblGas = new String[]{"QuoteID", "QuoteRef", "QuoteDate", "Supplier", "Postcode", "AQ", "StartDate", "PaymentType", "Agent", "Action"};
    public ElementHandler[] arrGas = new ElementHandler[10];

    public void gasQuoteColumnVerification() throws IOException {
        for (int i = 0; i < arrGas.length; i++) {
            arrGas[i] = _webDriverHandler.byXpath("//table[@id='gasQuoteTable']/thead/tr/th[\" + (i + 1) + \"]");
            if (tblGas.equals(arrGas[i])) {
                System.out.println("Coloums are matched");
            }
        }
    }

    public void addNewGasQuote(String postcode, int AQ, String supplier) {
        waitLoad();
        btnAddnewQuoteGas.click();
        waitLoad();
        txtPostCode.clear().sendKeys(postcode + "");
        txtAQ.clear().sendKeys(AQ + "");
        ddSupplier.selectByText(supplier);
        calendarStartDate.clear().sendKeys("01/05/2023", Keys.ESCAPE);
        btnGetQuote.click();
        waitLoadLong();
    }

    public void addNewGasQuoteValidation(String postcode, int AQ, String supplier) {
        waitLoad();
        btnAddnewQuoteGas.click();
        waitLoad();
        txtPostCode.clear().sendKeys(postcode);
        txtAQ.clear().sendKeys(AQ + "");
        ddSupplier.selectByText(supplier);
        calendarStartDate.clear().sendKeys("01/05/2023", Keys.ESCAPE);
        btnGetQuote.click();
    }

    public void addNewGasQuoteMandatoryValidation(String supplier) {
        waitLoad();
        btnAddnewQuoteGas.click();
        waitLoad();
        txtPostCode.clear();
        txtAQ.clear();
        ddSupplier.selectByText(supplier);
        calendarStartDate.clear().sendKeys(Keys.ESCAPE);
        btnGetQuote.click();
    }

    public void addUserDefinedQuote(String quoteType, int sCharge, int unitPrice, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType + "");
        txtSCharge.clear().sendKeys(sCharge + "");
        txtUnitPrice.clear().sendKeys(unitPrice + "");
        txtDiscount.clear().sendKeys(discount + "");
        btnAddToList.click();
    }

    public void addUserDefinedQuoteBespoke(String quoteType, String BrokerBespoke, int sCharge, int unitPrice, int commision, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType);
        waitLoad();
        ddlBrokerBespoke.selectByText(BrokerBespoke);
        //ddlDuration.selectByValue(12+"");
        txtSCharge.clear().sendKeys(sCharge + "");
        txtUnitPrice.clear().sendKeys(unitPrice + "");
        txtCommissionAmount.clear().sendKeys(commision + "");
        txtDiscount.clear().sendKeys(discount + "");
        //CalExpiryDate.click();
        btnAddToList.click();
    }

    public void addUserDefinedQuoteCustomer(String quoteType, String customerOther, int sCharge, int unitPrice, int discount) {
        btnAddQuote.click();
        ddQuoteType.selectByText(quoteType);
        waitLoad();
        ddlBrokerBespoke.selectByText(customerOther);
        ddlDuration.selectByValue(24 + "");
        txtSCharge.clear().sendKeys(sCharge + "");
        txtUnitPrice.clear().sendKeys(unitPrice + "");
        txtDiscount.clear().sendKeys(discount + "");
        btnAddToList.click();
    }

    public void quoteComparison() {
        btnCompareSelected.click();
        btnClose.click();
    }

    public void quoteSelectionUserDefinedQuotes() {
        _webDriverHandler.byXpath("//*[@id='id_166']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_219']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_176']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_209']/td/div/input").waitClickable().click();
    }

    public void quoteSelection() {
    	_webDriverHandler.byXpath("//*[@id='id_166']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_219']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_176']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_209']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//button[contains(text(),'Quote Selected')]").waitClickable(10, 100).click();
    }

 //   public void compareQuoteSelection() {
//        _webDriverHandler.byXpath("//*[@id='id_3']/td/div/input").waitClickable().click();
//        _webDriverHandler.byXpath("//*[@id='id_4']/td/div/input").waitClickable().click();
//        _webDriverHandler.byXpath("//*[@id='id_35']/td/div/input").waitClickable().click();
//        _webDriverHandler.byXpath("//*[@id='id_34']/td/div/input").waitClickable().click();
        // Add user defined quotes xpath here and then compare quote
 //       btnCompareSelected.click();
 //       waitLoadLong();
        //	waitLoad();
        //txtQuoteRef.clear().sendKeys("Automation Test : gas Quote" + appendDate);
   // }
    
    public void compareQuoteSelection() {
    	_webDriverHandler.byXpath("//*[@id='id_166']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_219']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_176']/td/div/input").waitClickable().click();
        _webDriverHandler.byXpath("//*[@id='id_209']/td/div/input").waitClickable().click();
       // _webDriverHandler.byXpath("//button[contains(text(),'Quote Selected')]").waitClickable(10, 100).click();
        btnCompareSelected.click();
    }

    public void excelFileDownload() {
        btnExcel.waitClickable(20, 100).click();
        System.out.println("Check for the downloaded file");
        /*
         * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ENTER);
         * robot.keyRelease(KeyEvent.VK_ENTER);
         */
		/*Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
		 */
    }

    public void pdfFileDownload() {
        btnPdf.waitClickable(20, 100).click();
        System.out.println("Check for the downloaded file");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(10, 100).waitInvisible(20, 100);
    }

    public void waitLoadLong() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(10, 100).waitInvisible(20, 100);
    }

    public void gasQuote_Validation() {
        Assert.assertEquals(msgPostcode.getText(), strValidationPostCode);
        Assert.assertEquals(msgAQ.getText(), strValidationAQ);
        Assert.assertEquals(msgStartDate.getText(), strValidationStartDate);
    }

    public void gasQuote_MandatoryValidation() {
        Assert.assertEquals(msgPostcode.getText(), strMandatoryPostCode);
        Assert.assertEquals(msgAQ.getText(), strMandatoryAQ);
        Assert.assertEquals(msgStartDate.getText(), strMandatoryStartDate);
    }
}
