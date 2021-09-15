package com.BulkScanning.PageObject.MIReports;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.util.Hashtable;

public class EmailProcessingMI {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabEmailProcessing;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdEmailSender;
    ElementHandler btnDdUpdatedBy;
    ElementHandler dateReceivedFrom;
    ElementHandler dateReceivedTo;
    ElementHandler dateUpdatedFrom;
    ElementHandler dateUpdatedTo;
    ElementHandler btnDdPassedQA;
    ElementHandler ddBulkAction;

    public EmailProcessingMI(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabEmailProcessing = _webDriverHandler.byXpath("//a[@data-action = 'MIReports/EmailProcessingMI/Index']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdEmailSender = _webDriverHandler.byXpath("//span[select[@id = 'FromEmail']]/div/button");
        btnDdUpdatedBy = _webDriverHandler.byXpath("//span[select[@id = 'UpdatedBy']]/div/button");
        dateReceivedFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateReceivedTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        dateUpdatedFrom = _webDriverHandler.byXpath("//*[@id='UpdatedFrom']");
        dateUpdatedTo = _webDriverHandler.byXpath("//*[@id='UpdatedTo']");
        btnDdPassedQA = _webDriverHandler.byXpath("//span[select[@id = 'PassedQA']]/div/button");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search =  _webDriverHandler.byXpath("//input[@type='search']");
    }

    public String[] tblEmailProcessingMI = new String[]{"Id", "From", "Subject", "Received", "Attachments", "PDFs", "PDFs Extracted", "Files Converted", "Total Pages", "Non PDFs", "Unsupported Files", "Total Files Created", "Passed QA",
            "First Status Change", "Current Status", "Current Status Date", "Last Updated By", "Last Updated"};
    public String[] arrEmailProcessingMI = new String[18];


    public void accessEmailProcessingMI() {
        do {
            tabEmailProcessing.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < tblEmailProcessingMI.length; i++) {
            arrEmailProcessingMI[i] = _webDriverHandler.byXpath("//div[@class = 'dataTables_scrollHead']//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (arrEmailProcessingMI[i].equalsIgnoreCase("Total Pages")){_webDriverHandler.byXpath("//div[@class = 'dataTables_scrollHead']//table/thead/tr/th[18]").scrollDown();}
            if (!(tblEmailProcessingMI[i].equals(arrEmailProcessingMI[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadEmailProcessingMI() {
        if (btnDdUpdatedBy.isDisplayed() && btnDdEmailSender.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed()
                && btnReset.isDisplayed() && btnExportExcel.isDisplayed() && btnDdPassedQA.isDisplayed() && dateUpdatedFrom.isDisplayed()
                && dateUpdatedTo.isDisplayed() && dateReceivedFrom.isDisplayed() && dateReceivedTo.isDisplayed()
        ) {
            System.out.println("Email Processing MI page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void search(String term) {
        search.waitClickable().sendKeys(term);
        waitLoad();
    }

    public void exportExcel() {
        btnExportExcel.waitClickable().click();
    }

    public void filterEmailProcessingMI(String filterType, String... text) {
        switch (filterType) {
            case "Email":
                btnDdEmailSender.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='FromEmail']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Updated":
                btnDdUpdatedBy.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='UpdatedBy']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Passed":
                btnDdPassedQA.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='PassedQA']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            default:
                Assert.fail("Proper Filter is not selected.");
        }
        btnApply.waitClickable().click();
        waitLoad();
    }

    public void filterByDate(String dateType, String fromDate, String toDate) {
        if (dateType.equalsIgnoreCase("Received")) {
            dateReceivedFrom.waitClickable().click();
            dateSelection(fromDate);
            dateReceivedTo.waitClickable().click();
            dateSelection(toDate);
            btnApply.waitClickable().click();
        }
        else {
            dateUpdatedFrom.waitClickable().click();
            dateSelection(fromDate);
            dateUpdatedTo.waitClickable().click();
            dateSelection(toDate);
            btnApply.waitClickable().click();
        }
        waitLoad();
    }

    public void filterReset() {
        btnReset.waitClickable().click();
        waitLoad();
    }

    public void dateSelection(String date) {

        Hashtable<String, String> htMonth = new Hashtable<String, String>();
        htMonth.put("01", "Jan");
        htMonth.put("02", "Feb");
        htMonth.put("03", "Mar");
        htMonth.put("04", "Apr");
        htMonth.put("05", "May");
        htMonth.put("06", "Jun");
        htMonth.put("07", "Jul");
        htMonth.put("08", "Aug");
        htMonth.put("09", "Sep");
        htMonth.put("10", "Oct");
        htMonth.put("11", "Nov");
        htMonth.put("12", "Dec");

        String splitter[] = date.split("/");
        String year = splitter[2];
        String month = splitter[1];
        String day = splitter[0];
        _webDriverHandler.byXpath("//select[@data-handler = 'selectYear']").selectByText(year);
        _webDriverHandler.byXpath("//select[@data-handler = 'selectMonth']").selectByText(htMonth.get(month));
        _webDriverHandler.byXpath("//table[@class='ui-datepicker-calendar']//a[text()='"+day+"']").click();
    }

    public void waitLoad(int time, int interval) {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(time, interval).waitInvisible(time, interval);
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}