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

    /**
     * Used to select Split Documents Tab under MI Reports.
     */
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

    /**
     * This method verifies the column header for the table present on the awaiting  EDI page in a sequential order and matches the
     column names with the data array {@link SplitDocuments#tblSplitDocuments}.
     */
    public void columnVerification() {
        for (int i = 0; i < tblSplitDocuments.length; i++) {
            arrSplitDocuments[i] = _webDriverHandler.byXpath("//div[@class = 'dataTables_scrollHead']//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSplitDocuments[i].equals(arrSplitDocuments[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
    public void loadSplitDocuments() {
        if (search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && dateFrom.isDisplayed() && dateTo.isDisplayed()) {
            System.out.println("Document Schedule page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to search an entry from the table and the search term is passed as parameter. Verifying the search functionality.
     * @param term The term we need to input in the search field for filtering.
     */
    public void search(String term) {
        search.waitClickable().sendKeys(term);
        waitLoad();
    }

    /**
     * Used to export all the data available in the Metadata MI table into an Excel file.
     */
    public void exportExcel() {
        btnExportExcel.waitClickable().click();
    }

    /**
     * Filtering the contents of Awaiting EDI table by the date of their creation in the DB.
     * Provide a date range and all the creation within that range should be returned, verifying the date filter for the application.
     *
     * @param fromDate Start for the date range.
     * @param toDate   End of the date range.
     */
    public void filterByDate(String fromDate, String toDate) {
        dateFrom.waitClickable().click();
        dateSelection(fromDate);
        dateTo.waitClickable().click();
        dateSelection(toDate);
        btnApply.waitClickable().click();
        waitLoad();
    }

    /**
     * Resets the applied filter, verifying the reset filter functionality.
     */
    public void filterReset() {
        btnReset.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to properly select date in the date selection dropdown.
     * @param date tha date that is to be selected.
     */
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

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad(int time, int interval) {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(time, interval).waitInvisible(time, interval);
    }

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}