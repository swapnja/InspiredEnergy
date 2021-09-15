package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class OtherDocumentEntry {
    WebDriverHandler _webDriverHandler;
    ElementHandler tabOtherDocumentEntry;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatus;
    ElementHandler btnDdDocument;
    ElementHandler btnDdAssigned;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler ddBulkAction;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAction;
    ElementHandler ddNotNeeded;
    ElementHandler ddSetStatus;
    ElementHandler tbNNComment;
    ElementHandler btnNNSave;
    ElementHandler btnNNCancel;
    ElementHandler messageNNStatus;
    ElementHandler messageNNReason;
    ElementHandler messageNNComment;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler cancelComment;
    ElementHandler tbStatus;
    ElementHandler btnDownloadScanned;
    ElementHandler rowInvoiceNumber;
    ElementHandler rowAccountNumber;
    ElementHandler rowMPANMPRN;
    ElementHandler rowClient;
    ElementHandler rowSupplier;
    ElementHandler rowUtilityType;
    ElementHandler tbInvoiceNumber;
    ElementHandler tbAccountNumber;
    ElementHandler tbMPANMPRN;
    ElementHandler tbClient;
    ElementHandler tbSupplier;
    ElementHandler ddUtilityType;
    ElementHandler tbEditInvoiceNumber;
    ElementHandler tbEditAccountNumber;
    ElementHandler tbEditMPANMPRN;
    ElementHandler ddEditClient;
    ElementHandler ddEditSupplier;
    ElementHandler ddEditUtilityType;
    ElementHandler ddDocumentType;
    ElementHandler btnCancelMeta;
    ElementHandler btnEditMeta;
    ElementHandler btnSave;

    public OtherDocumentEntry(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabOtherDocumentEntry = _webDriverHandler.byXpath("//a[text() = 'Other Document Entry']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
        btnDdDocument = _webDriverHandler.byXpath("//span[select[@id = 'MetaDataDocumentTypeId']]/div/button");
        btnDdStatus = _webDriverHandler.byXpath("//span[select[@id = 'StatusId']]/div/button");
        btnDdAssigned = _webDriverHandler.byXpath("//span[select[@id = 'AssignedToId']]/div/button");
        btnExportExcel = _webDriverHandler.byXpath("//button[contains(text(),'Export Excel')]");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search =  _webDriverHandler.byXpath("//input[@type='search']");
        ddBulkAction = _webDriverHandler.byXpath("//*[contains(@class, 'bulk-action')]");
        ddUsers = _webDriverHandler.byXpath("//*[@id='ddlBulkAssignee']");
        btnProcess = _webDriverHandler.byXpath("//button[text()='Process']");
        selectAll = _webDriverHandler.byXpath("//input[@class = 'check-all']");
        ddAssignment = _webDriverHandler.byXpath("//*[@id='AssignedTo']");
        linkAssignToMe = _webDriverHandler.byXpath("//a[@class='assign-to-me']");
        tbCurrentStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        tbSystemDatabase = _webDriverHandler.byXpath("//*[@id='SystemDatabaseName']");
        ddAction = _webDriverHandler.byXpath("//*[@id='Action']");
        ddNotNeeded = _webDriverHandler.byXpath("//*[@id='NotNeededReasonId']");
        ddSetStatus = _webDriverHandler.byXpath("//*[@id='Status']");
        tbNNComment = _webDriverHandler.byXpath("//*[@id='Comment']");
        btnNNSave = _webDriverHandler.byXpath("//*[@id='modalSendToNotNeeded']//button[contains(text(), 'Save')]");
        btnNNCancel = _webDriverHandler.byXpath("//*[@id='modalSendToNotNeeded']//button[contains(text(), 'Cancel')]");
        messageNNReason = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='NotNeededReasonId-error']");
        messageNNStatus = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='Status-error']");
        messageNNComment = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='Comment-error']");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        tbStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        rowInvoiceNumber = _webDriverHandler.byXpath("//div[contains(text(),'Invoice Number')]//..");
        rowAccountNumber = _webDriverHandler.byXpath("//div[contains(text(),'Account Number')]//..");
        rowMPANMPRN = _webDriverHandler.byXpath("//div[contains(text(),'MPAN/MPRN')]//..");
        rowClient = _webDriverHandler.byXpath("//div[contains(text(),'Client')]//..");
        rowSupplier = _webDriverHandler.byXpath("//div[contains(text(),'Supplier')]//..");
        rowUtilityType = _webDriverHandler.byXpath("//div[contains(text(),'Utility Type')]//..");
        tbInvoiceNumber = _webDriverHandler.byXpath("//*[@name='InvoiceNumber']");
        tbAccountNumber = _webDriverHandler.byXpath("//*[@name='AccountNumber']");
        tbMPANMPRN = _webDriverHandler.byXpath("//*[@name='MeterNumber']");
        tbClient = _webDriverHandler.byXpath("//*[@name='Client']");
        tbSupplier = _webDriverHandler.byXpath("//*[@name='Supplier']");
        ddUtilityType = _webDriverHandler.byXpath("//*[@name='UtilityType']");
        tbEditInvoiceNumber = _webDriverHandler.byXpath("//*[@id='modalInvoiceNumber']");
        tbEditAccountNumber = _webDriverHandler.byXpath("//*[@id='modalAccountNumber']");
        tbEditMPANMPRN = _webDriverHandler.byXpath("//*[@id='modalMeterNumber']");
        ddEditClient = _webDriverHandler.byXpath("//*[@id='ClientId']");
        ddEditSupplier = _webDriverHandler.byXpath("//*[@id='SupplierId']");
        ddEditUtilityType = _webDriverHandler.byXpath("//*[@id='modalUtilityID']");
        btnEditMeta = _webDriverHandler.byXpath("//*[@id='btnGetMetadata']");
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='modalDocumentTypeID']");
        btnSave = _webDriverHandler.byXpath("//*[contains(text(), 'Save')]");
        btnCancelMeta = _webDriverHandler.byXpath("//*[@id='editMetadataForm']//*[contains(text(), 'Cancel')]");
    }

    public String[] tblOtherDocumentEntry = new String[]{"", "Id", "Parent Customer", "Customer", "Document", "Supplier", "Received Date", "Status", "Assigned", ""};
    public String[] arrOtherDocumentEntry = new String[10];

    String strErrorGeneric = "Message cannot be blank";
    String strErrorReason = "Please select Reason";
    String strErrorStatus = "Please select Status";
    String strErrorComment = "Please enter Comment";

    public void accessOtherDocumentEntry() {
        do {
            tabOtherDocumentEntry.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrOtherDocumentEntry.length; i++) {
            arrOtherDocumentEntry[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblOtherDocumentEntry[i].equals(arrOtherDocumentEntry[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadOtherDocumentEntry() {
        if (btnDdCustomers.isDisplayed() && btnDdDocument.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() &&
                dateFrom.isDisplayed() && btnDdAssigned.isDisplayed() && dateTo.isDisplayed() && search.isDisplayed() &&
                btnApply.isDisplayed() && btnReset.isDisplayed() && btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed()
        ) {
            System.out.println("Other Document Entry page has loaded properly.");
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

    public void filterOtherDocumentEntry(String filterType, String... text) {
        switch (filterType) {
            case "Parent":
                btnDdParentCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='ParentCustomerId']]//label[contains(text(), ' " + t + "')]").click();
                }
                waitLoad();
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
            case "Document":
                btnDdDocument.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='MetaDataDocumentTypeId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Status":
                btnDdStatus.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='StatusId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Assigned":
                btnDdAssigned.waitClickable().click();
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

    public void setBulkAction(String user) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(user);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void setBulkAction(String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(bulkData[2]);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String schedule, String id) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed() && btnDownloadScanned.isDisplayed()
                && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Other Document Entry edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        waitLoad();
    }

    public void setAction(String notNeeded, String setStatus, String comment) {
        ddAction.waitClickable().selectByText("Send To Not Needed");
        ddNotNeeded.waitClickable().selectByText(notNeeded);
        ddSetStatus.waitClickable().selectByText(setStatus);
        tbNNComment.waitClickable().sendKeys(comment);
        //btnNNSave.waitClickable().click();
        btnNNCancel.waitClickable().click();
        //waitLoad();
    }

    public void downloadScanned() {
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    public void changeAssignment(String user) {
        if (user.equals("Me")) {
            linkAssignToMe.waitClickable().click();
        } else {
            ddAssignment.waitClickable().selectByText(user);
        }
        waitLoad();
    }

    public void addComment(String comment) {
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
        waitLoad();
    }

    public void verifyMetaData() {
        if (//rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowMPANMPRN.isDisplayed() && tbMPANMPRN.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowUtilityType.isDisplayed() && ddUtilityType.getAttribute("readonly").equalsIgnoreCase("true") &&
                tbStatus.isDisplayed() && tbStatus.getAttribute("readonly").equalsIgnoreCase("true")
        ) {
            System.out.println("Meta Data is available.");
        } else {
            Assert.fail("Meta Data not Loaded properly.");
        }
    }

    public void editMetaData(String... mateData) {
        btnEditMeta.waitClickable().click();
        waitLoad();
        ddDocumentType.selectByText(mateData[0]);
        tbEditInvoiceNumber.clear().sendKeys(mateData[1]);
        tbEditAccountNumber.clear().sendKeys(mateData[2]);
        tbEditMPANMPRN.clear().sendKeys(mateData[3]);
        ddEditClient.selectByText(mateData[4]);
        ddEditSupplier.selectByText(mateData[5]);
        ddEditUtilityType.waitClickable().selectByText(mateData[6]);
        //btnSave.waitClickable().click();
        btnCancelMeta.waitClickable().click();
    }

    public void errorValidations() {
        ddAction.waitClickable().selectByText("Send To Not Needed");
        btnNNSave.waitClickable().click();
        Assert.assertEquals(messageNNReason.getText(), strErrorReason);
        Assert.assertEquals(messageNNStatus.getText(), strErrorStatus);
        Assert.assertEquals(messageNNComment.getText(), strErrorComment);
        btnNNCancel.waitClickable().click();
        do {
            btnAddComment.sendKeys(Keys.ARROW_DOWN);
        }
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorGeneric);
        cancelComment.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}