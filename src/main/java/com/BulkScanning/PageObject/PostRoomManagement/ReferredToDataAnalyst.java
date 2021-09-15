package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ReferredToDataAnalyst {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabReferredToDataAnalyst;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatus;
    ElementHandler btnDdAssigned;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler ddBulkAction;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAction;
    ElementHandler btnSubmit;
    ElementHandler btnCancel;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler btnDownloadReportChase;
    ElementHandler cancelComment;
    ElementHandler btnOk;
    ElementHandler btnDownloadScanned;
    ElementHandler headerIssueDetails;
    ElementHandler tbIssueDetails;
    ElementHandler ddDocumentType;
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
    ElementHandler tbEditClient;
    ElementHandler tbEditSupplier;
    ElementHandler ddEditUtilityType;
    ElementHandler btnCancelMeta;
    ElementHandler btnEditMeta;
    ElementHandler btnSave;
    //ElementHandler logo;

    public ReferredToDataAnalyst(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabReferredToDataAnalyst = _webDriverHandler.byXpath("//a[text() = 'Referred To Data Analyst']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdCustomers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Customers')]]");
        btnDdSuppliers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Suppliers')]]");
        btnDdStatus = _webDriverHandler.byXpath("//button[span[contains(text(), 'Status')]]");
        btnDdAssigned = _webDriverHandler.byXpath("//button[span[contains(text(), 'Assigned To')]]");
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
        btnSubmit = _webDriverHandler.byXpath("//button[contains(text(),'Submit')]");
        btnCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel')]");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        //Metadata
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='modalDocumentTypeID']");
        headerIssueDetails = _webDriverHandler.byXpath("//h6[text() = 'Input Issue Details']");
        tbIssueDetails = _webDriverHandler.byXpath("//*[@id='InputIssueDetails']");
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
        tbEditClient = _webDriverHandler.byXpath("//*[@id='modalClient']");
        tbEditSupplier = _webDriverHandler.byXpath("//*[@id='modalSupplier']");
        ddEditUtilityType = _webDriverHandler.byXpath("//*[@id='modalUtilityID']");
        btnEditMeta = _webDriverHandler.byXpath("//*[@id='btnGetMetadata']");
        btnSave = _webDriverHandler.byXpath("//*[contains(text(), 'Save')]");
        btnCancelMeta = _webDriverHandler.byXpath("//*[@id='editMetadataForm']//*[contains(text(), 'Cancel')]");
        //logo = _webDriverHandler.byXpath("//a[text() ='Terms of Use']");
    }

    public String[] tblReferredToDataAnalyst = new String[]{"", "Id", "Customer", "Supplier", "Received Date", "Status", "Assigned", ""};
    public String[] arrReferredToDataAnalyst = new String[8];

    String strErrorGeneric = "Message cannot be blank";

    public void accessReferredToDataAnalyst() {
        do {
            tabReferredToDataAnalyst.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrReferredToDataAnalyst.length; i++) {
            arrReferredToDataAnalyst[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblReferredToDataAnalyst[i].equals(arrReferredToDataAnalyst[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadReferredToDataAnalyst() {
        if (btnDdCustomers.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() &&
                btnDdAssigned.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed()
        ) {
            System.out.println("Referred to data analyst page has loaded properly.");
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

    public void filterReferredToDataAnalyst(String filterType, String... text) {
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

    public void editSchedule(String schedule, String id ) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed() && btnDownloadScanned.isDisplayed()
                && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Referred to data Analysts edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        if(action.equals("Mark as Done")){btnOk.waitClickable().click();}
        waitLoad();
    }

    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    public void changeAssignment(String user) {
        if (user.equals("Me")) {
            linkAssignToMe.waitClickable().click();
        } else {
            ddAssignment.waitClickable().selectByText(user);
        }
        try{waitLoad();}
        catch (Exception e){}
    }

    public void addComment(String comment) {
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
        waitLoad();
    }

    public void errorValidations() {
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorGeneric);
        btnCancel.waitClickable().click();
    }

    public void verifyMetaData() {
        if (rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowMPANMPRN.isDisplayed() && tbMPANMPRN.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowUtilityType.isDisplayed() && ddUtilityType.getAttribute("readonly").equalsIgnoreCase("true") &&
                headerIssueDetails.isDisplayed() && tbIssueDetails.isDisplayed() && tbIssueDetails.getAttribute("readonly").equals("true")
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
        tbEditClient.clear().sendKeys(mateData[4]);
        tbEditSupplier.clear().sendKeys(mateData[5]);
        ddEditUtilityType.waitClickable().selectByText(mateData[6]);
        //btnSave.waitClickable().click();
        btnCancelMeta.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
