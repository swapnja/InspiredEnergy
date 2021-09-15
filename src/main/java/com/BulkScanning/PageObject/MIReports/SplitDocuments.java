package com.BulkScanning.PageObject.MIReports;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.util.Hashtable;

public class SplitDocuments {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabSplitDocuments;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler dateFrom;
    ElementHandler dateTo;

    public SplitDocuments(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabSplitDocuments = _webDriverHandler.byXpath("//a[@data-action = 'MIReports/SplitDocumentsMI/Index']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search =  _webDriverHandler.byXpath("//input[@type='search']");
    }

    public String[] tblSplitDocuments = new String[]{"Original Document ID", "New Document ID", "Original No. of Pages", "Split No.", "Pages", "Created On", "Document Type",
            "Invoice Number", "Account Number", "Meter Number", "Parent Client", "Client", "Supplier", "Utility"};
    public String[] arrSplitDocuments = new String[14];


    public void accessSplitDocuments() {
        do {
            tabSplitDocuments.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < tblSplitDocuments.length; i++) {
            arrSplitDocuments[i] = _webDriverHandler.byXpath("//div[@class = 'dataTables_scrollHead']//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSplitDocuments[i].equals(arrSplitDocuments[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadSplitDocuments() {
        if (search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && dateFrom.isDisplayed() && dateTo.isDisplayed()) {
            System.out.println("Document Schedule page has loaded properly.");
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

    public void filterByDate(String fromDate, String toDate) {
        dateFrom.waitClickable().click();
        dateSelection(fromDate);
        dateTo.waitClickable().click();
        dateSelection(toDate);
        btnApply.waitClickable().click();
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