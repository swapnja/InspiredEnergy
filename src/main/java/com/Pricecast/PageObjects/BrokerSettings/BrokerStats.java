package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class BrokerStats {

    WebDriverHandler _webDriverHandler;
    ElementHandler buttonSettings;
    ElementHandler linkBrokerStats;
    ElementHandler btnSave;
    ElementHandler btnOk;
    ElementHandler btnCancel;
    ElementHandler tblBrokerStats;
    ElementHandler tblSuppliersRecommended;
    ElementHandler tblQuoteBreakdown;
    ElementHandler tblRecommendedQuoteStats;
    ElementHandler startDate;
    ElementHandler endDate;
    ElementHandler uniquetgl;
    ElementHandler uniqueCheck;
    ElementHandler teamDD;
    ElementHandler btnShowStats;
    ElementHandler btnExportExcel;

    public BrokerStats (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkBrokerStats = _webDriverHandler.byXpath("//a[@data-action='BrokerStats']");
        btnSave = _webDriverHandler.byXpath("//*[@type='submit']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnCancel = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-danger']"); ////*[@id='editGasSupplierForm']//button[@class='btn btn-sm btn-danger']
        tblSuppliersRecommended = _webDriverHandler.byXpath("//table[@id='tblSupplierRecommended']");
        tblQuoteBreakdown = _webDriverHandler.byXpath("//table[@id='tblQuoteBreakdown']");
        tblRecommendedQuoteStats = _webDriverHandler.byXpath("//table[@id='tblRecommendedQuoteStats']");
        tblBrokerStats = _webDriverHandler.byXpath("//table[@id='tblBrokerStats']");
        uniquetgl = _webDriverHandler.byXpath("//label[input[@id='IsUnique']]");
        uniqueCheck = _webDriverHandler.byXpath("//input[@id='IsUnique']");
        teamDD = _webDriverHandler.byXpath("//*[@id='Team']");
        startDate = _webDriverHandler.byXpath("//*[@id='StartDate']");
        endDate = _webDriverHandler.byXpath("//*[@id='EndDate']");
        btnShowStats = _webDriverHandler.byXpath("//*[@id='btnShowStats']");
        btnExportExcel = _webDriverHandler.byXpath("//*[@id='btnExportBrokerStats']");
    }

    String[] arrTblLabelsBrokerStats = new String[7];
    String[] tblHeadersBrokerStats = new String[] { "User Name", "Team", "Sub-Broker", "Quotes Done", "Quotes Saved", "Average Margin (p/kWh)", "Average Aggregator Margin (p/kWh)"};

    public void selectSettings() {
        waitLoad();
        buttonSettings.waitClickable().click();
        waitLoad();
        linkBrokerStats.waitClickable().click();
    }

    public void verifyBrokerStats(){
        if(
            tblBrokerStats.isDisplayed() &&
            tblQuoteBreakdown.isDisplayed() &&
            tblRecommendedQuoteStats.isDisplayed() &&
            tblSuppliersRecommended.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nBroker Stats is loaded properly");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification(){
        for(int i = 0 ; i < arrTblLabelsBrokerStats.length ; i++) {
            arrTblLabelsBrokerStats[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerStats']/thead/tr/th[" + (i+1) + "]").getText();
            if(!(tblHeadersBrokerStats[i].equals(arrTblLabelsBrokerStats[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void showStats(String StartDate, String EndDate, boolean Unique, String Team) {
        if (StartDate=="" || EndDate=="" || Team=="") {
            waitLoad();
            btnShowStats.waitClickable().click();
            waitLoad();
            btnExportExcel.waitClickable().click();
        }
        else{
            waitLoad();
            startDate.clear().sendKeys(StartDate);
            endDate.clear().sendKeys(EndDate);
            if (Unique) {
                uniquetgl.waitClickable().click();
            }
            teamDD.selectByText(Team);
            btnShowStats.waitClickable().click();
            waitLoad();
            btnExportExcel.waitClickable().click();
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
