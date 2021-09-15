package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class DocumentHistory {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabDocumentHistory;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatus;
    ElementHandler btnDdWorkFlow;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler btnDownloadScanned;
    ElementHandler ddDocumentType;
    //ElementHandler logo;

    public DocumentHistory(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabDocumentHistory = _webDriverHandler.byXpath("//a[text() = 'Document History']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdCustomers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Customers')]]");
        btnDdSuppliers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Suppliers')]]");
        btnDdStatus = _webDriverHandler.byXpath("//button[span[contains(text(), 'Statuses')]]");
        btnDdWorkFlow = _webDriverHandler.byXpath("//button[span[contains(text(), 'Workflow')]]");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search =  _webDriverHandler.byXpath("//input[@type='search']");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        //Metadata
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='modalDocumentTypeID']");
    }

    public String[] tblDocumentHistory = new String[]{"", "Id", "Customer", "Document Type", "Supplier", "Received Date", "Workflow", "Status", "Last Updated By", "Last Updated On", ""};
    public String[] arrDocumentHistory = new String[11];

    public void accessDocumentHistory() {
        do {
            tabDocumentHistory.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrDocumentHistory.length; i++) {
            arrDocumentHistory[i] = _webDriverHandler.byXpath("//div[contains (@class, 'dataTables_scrollHeadInner')]//table/thead/tr/th[" + (i + 1) + "]").getText();
            System.out.println(arrDocumentHistory[i]);
            if (!(tblDocumentHistory[i].equals(arrDocumentHistory[i]))) {
                Assert.fail("\nColumn names do not match.");
                System.out.println(tblDocumentHistory[i]+"if");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadDocumentHistory() {
        if (btnDdCustomers.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() && btnDdWorkFlow.isDisplayed() &&
                search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() && btnExportExcel.isDisplayed()
        ) {
            System.out.println("Document History page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void searchSchedules(String term) {
        search.waitClickable().sendKeys(term);
        waitLoad();
    }

    public void exportExcel(String[] selection) {
        for (String t : selection) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click();
        }
        btnExportExcel.waitClickable().click();
    }

    public void filterDocumentHistory(String filterType, String... text) {
        switch (filterType) {
            case "Customer":
                btnDdCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='CustomerId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Supplier":
                btnDdSuppliers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='SupplierId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Status":
                btnDdStatus.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='StatusId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Assigned To":
                btnDdWorkFlow.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='AssignedToId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            default:
                Assert.fail("Proper Filter is not selected.");
        }
        btnApply.waitClickable().click();
        waitLoad();
    }

    public void filterByDate(String toDate, String fromDate) {
        dateTo.waitClickable().sendKeys(toDate);
        dateFrom.waitClickable().sendKeys(fromDate);
        btnApply.waitClickable().click();
        waitLoad();
    }

    public void filterReset() {
        btnReset.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String schedule, String id ) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
