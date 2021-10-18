package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DocumentHistory {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabDocumentHistory;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatus;
    ElementHandler btnDdWorkFlow;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler btnDownloadScanned;
    ElementHandler ddDocumentType;

    //Metadata
    ElementHandler mdCurrentWorkflow;
    ElementHandler mdDocumentStatus;
    ElementHandler mdId;
    ElementHandler mdParentClient;
    ElementHandler mdClient;
    ElementHandler mdDocumentType;
    ElementHandler mdSupplier;
    ElementHandler mdReceivedOn;

    public DocumentHistory(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabDocumentHistory = _webDriverHandler.byXpath("//a[text() = 'Document History']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
        btnDdWorkFlow = _webDriverHandler.byXpath("//span[select[@id = 'ModelTypeId']]/div/button");
        btnDdStatus = _webDriverHandler.byXpath("//span[select[@id = 'StatusId']]/div/button");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search =  _webDriverHandler.byXpath("//input[@type='search']");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");

        //Metadata
        mdCurrentWorkflow = _webDriverHandler.byId("Workflow");
        mdDocumentStatus = _webDriverHandler.byId("Status");
        mdId = _webDriverHandler.byId("Id");
        mdParentClient = _webDriverHandler.byId("ParentClient");
        mdClient = _webDriverHandler.byId("Customer");
        mdSupplier = _webDriverHandler.byId("Supplier");
        mdReceivedOn = _webDriverHandler.byId("RecievedOn");
    }

    public String[] tblDocumentHistory = new String[]{"", "Id", "Parent Customer", "Customer", "Document Type", "Supplier", "Received Date", "Workflow", "Status", "Last Updated By", "Last Updated On", ""};
    public String[] arrDocumentHistory = new String[12];

    /**
     * Used to select Document History Tab under Postroom Management.
     */
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

    /**
     * This method verifies the column header for the table present on the document history page in a sequential order and matches the column names with the data array {@link DocumentHistory#tblDocumentHistory}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrDocumentHistory.length; i++) {
            arrDocumentHistory[i] = _webDriverHandler.byXpath("//div[contains (@class, 'dataTables_scrollHeadInner')]//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDocumentHistory[i].equals(arrDocumentHistory[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
    public void loadDocumentHistory() {
        if (btnDdCustomers.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() && btnDdWorkFlow.isDisplayed() &&
                search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() && btnExportExcel.isDisplayed()
        ) {
            System.out.println("Document History page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to search an entry from the table and the search term is passed as parameter. Verifying the search functionality.
     * @param term The term we need to input in the search field for filtering.
     */
    public void searchSchedules(String term) {
        search.waitClickable().sendKeys(term);
        waitLoad();
    }

    /**
     * Used to select multiple entries from the awaiting EDI table and then export them to an Excel file, verifying the export functionality, multiselect is possible.
     *
     * @param selection An array of string containing id of the entries we are trying to select.
     */
    public void exportExcel(String[] selection) {
        for (String t : selection) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click();
        }
        btnExportExcel.waitClickable().click();
    }

    /**
     * Used to filter out the entries based on the various filter categories available, multiselect is possible.
     * Verifying the filtering functionality for the application.
     *
     * @param filterType Select what category of filter we need to use.
     * @param text       A Vararg array of Strings, containing value of the selections we are trying to filter.
     */
    public void filterDocumentHistory(String filterType, String... text) {
        switch (filterType) {
            case "Parent":
                btnDdParentCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='ParentCustomerId']]//label[contains(text(), ' " + t + "')]").click();
                    waitLoad();
                }
                break;
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
            case "Workflow":
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

    /**
     * Filtering the contents of Awaiting EDI table by the date of their creation in the DB.
     * Provide a date range and all the creation within that range should be returned, verifying the date filter for the application.
     *
     * @param fromDate Start for the date range.
     * @param toDate   End of the date range.
     */
    public void filterByDate(String toDate, String fromDate) {
        dateTo.waitClickable().sendKeys(toDate);
        dateFrom.waitClickable().sendKeys(fromDate);
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
     * Used to select and edit a particular entry from the table. Verifying the search and edit functionality.
     *
     * @param id The id of the entry we want to edit.
     */
    public void editSchedule(String schedule, String id ) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    /**
     * Used to download the scanned copy of the document available, verifying the functionality of the download button.
     */
    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page after clicking on the edit button, in turn verifying if the page has loaded properly or not.
     */
    public void verifyEditPage(){
        Assert.assertEquals(mdCurrentWorkflow.getAttribute("readonly"), "true");
        Assert.assertEquals(mdDocumentStatus.getAttribute("readonly"), "true");
        Assert.assertEquals(mdId.getAttribute("readonly"), "true");
        Assert.assertEquals(mdParentClient.getAttribute("readonly"), "true");
        Assert.assertEquals(mdClient.getAttribute("readonly"), "true");
        Assert.assertEquals(mdSupplier.getAttribute("readonly"), "true");
        Assert.assertEquals(mdReceivedOn.getAttribute("readonly"), "true");
    }

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
