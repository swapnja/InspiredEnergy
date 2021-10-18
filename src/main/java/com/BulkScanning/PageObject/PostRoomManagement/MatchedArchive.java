package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class MatchedArchive {
    WebDriverHandler _webDriverHandler;
    ElementHandler tabMatchedArchive;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAction;
    ElementHandler btnCancel;
    ElementHandler ddAssignment;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler btnDownloadReport;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler btnDownloadReportChase;
    ElementHandler cancelComment;
    ElementHandler tbStatus;
    ElementHandler btnDownloadScanned;
    //Meta Data
    //rows
    ElementHandler rowInvoiceNumber;
    ElementHandler rowAccountNumber;
    ElementHandler rowMPANMPRN;
    ElementHandler rowParentClient;
    ElementHandler rowClient;
    ElementHandler rowSupplier;
    ElementHandler rowUtilityType;
    //readonly values
    ElementHandler tbInvoiceNumber;
    ElementHandler tbAccountNumber;
    ElementHandler tbMeterNumber;
    ElementHandler tbParentClient;
    ElementHandler tbClient;
    ElementHandler tbSupplier;
    ElementHandler tbUtilityType;

    public MatchedArchive(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabMatchedArchive = _webDriverHandler.byXpath("//a[text() = 'Matched Archive']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
        btnExportExcel = _webDriverHandler.byXpath("//button[contains(text(),'Export Excel')]");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search = _webDriverHandler.byXpath("//input[@type='search']");
        ddUsers = _webDriverHandler.byXpath("//*[@id='ddlBulkAssignee']");
        btnProcess = _webDriverHandler.byXpath("//button[text()='Process']");
        selectAll = _webDriverHandler.byXpath("//input[@class = 'check-all']");
        ddAssignment = _webDriverHandler.byXpath("//*[@id='AssignedTo']");
        tbCurrentStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        tbSystemDatabase = _webDriverHandler.byXpath("//*[@id='SystemDatabaseName']");
        ddAction = _webDriverHandler.byXpath("//*[@id='Action']");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        btnDownloadReport = _webDriverHandler.byXpath("//*[@id='emailForm']//i");
        btnDownloadReportChase = _webDriverHandler.byXpath("//*[@id='modalChase']//i");
        btnCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel')]");
        tbStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        //Metadata
        //rows
        rowInvoiceNumber = _webDriverHandler.byXpath("//div[contains(text(),'Invoice Number')]//..");
        rowAccountNumber = _webDriverHandler.byXpath("//div[contains(text(),'Account Number')]//..");
        rowMPANMPRN = _webDriverHandler.byXpath("//div[contains(text(),'MPAN/MPRN')]//..");
        rowParentClient = _webDriverHandler.byXpath("//div[contains(text(),'Parent Client')]//..");
        rowClient = _webDriverHandler.byXpath("//div[contains(text(),'Client')]//..");
        rowSupplier = _webDriverHandler.byXpath("//div[contains(text(),'Supplier')]//..");
        rowUtilityType = _webDriverHandler.byXpath("//div[contains(text(),'Utility Type')]//..");
        //read only values
        tbInvoiceNumber = _webDriverHandler.byXpath("//*[@name='InvoiceNumber']");
        tbAccountNumber = _webDriverHandler.byXpath("//*[@name='AccountNumber']");
        tbMeterNumber = _webDriverHandler.byXpath("//*[@name='MeterNumber']");
        tbParentClient = _webDriverHandler.byXpath("//*[@name='ParentClient']");
        tbClient = _webDriverHandler.byXpath("//*[@name='Client']");
        tbSupplier = _webDriverHandler.byXpath("//*[@name='Supplier']");
        tbUtilityType = _webDriverHandler.byXpath("//*[@name='UtilityType']");
    }

    public String[] tblMatchedArchive = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Received Date", "Days to Match", "Matched Date", ""};
    public String[] arrMatchedArchive = new String[9];

    String strErrorGeneric = "Message cannot be blank";

    /**
     * Used to select Matched Archive Tab under Postroom Management.
     */
    public void accessMatchedArchive() {
        do {
            tabMatchedArchive.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    /**
     * This method verifies the column header for the table present on the matched archive page in a sequential order and matches the
     column names with the data array {@link MatchedArchive#tblMatchedArchive}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrMatchedArchive.length; i++) {
            arrMatchedArchive[i] = _webDriverHandler.byXpath("//div[contains (@class, 'dataTables_scrollHeadInner')]//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblMatchedArchive[i].equals(arrMatchedArchive[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
    public void loadMatchedArchive() {
        if (btnDdCustomers.isDisplayed() && btnDdSuppliers.isDisplayed() && btnDdParentCustomers.isDisplayed() && search.isDisplayed()
                && btnReset.isDisplayed() && btnApply.isDisplayed() && btnExportExcel.isDisplayed()
        ) {
            System.out.println("Matched Archive page has loaded properly.");
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
    public void filterMatchedArchive(String filterType, String... text) {
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
            case "Parent":
                btnDdParentCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='ParentCustomerId']]//label[contains(text(), ' " + t + "')]").click();
                    waitLoad();
                }
                break;
            default:
                Assert.fail("Proper Filter is not selected.");
        }
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
    public void editSchedule(String id) {
        searchSchedules(id);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page after clicking on the edit button, in turn verifying if the page has loaded properly or not.
     */
    public void verifyEdit() {
        if (tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed()
                && btnDownloadScanned.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Matched Archive edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to verify the functionality of Send Chase Email action dropdown once we are on the edit page of an entry.
     * @param action Specify the action that you want to test from the actions dropdown.
     */
    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        waitLoad();
    }

    /**
     * Used to download the scanned copy of the document available, verifying the functionality of the download button.
     */
    public void downloadScanned() {
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to verify the presence of all the available metadata fields and if they are read only or not.
     */
    public void verifyMetaData() {
        if(rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowMPANMPRN.isDisplayed() && tbMeterNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowParentClient.isDisplayed() && tbParentClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowUtilityType.isDisplayed() && tbUtilityType.getAttribute("readonly").equalsIgnoreCase("true")
        )
        {
            System.out.println("Meta Data is available.");
        }
        else {Assert.fail("Meta Data not Loaded properly.");}
    }

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
