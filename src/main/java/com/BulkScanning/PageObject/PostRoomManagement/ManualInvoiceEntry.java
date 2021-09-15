package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ManualInvoiceEntry {
    WebDriverHandler _webDriverHandler;
    ElementHandler tabManualInvoiceEntry;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
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
    ElementHandler tbCantInput;
    ElementHandler messageCantInput;
    ElementHandler btnSubmitCantInput;
    ElementHandler btnSubmitReferData;
    ElementHandler btnCancelReferData;
    ElementHandler btnCancelCantInput;
    ElementHandler btnCancelMeta;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler tbReferData;
    ElementHandler messageReferData;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler ddShow;
    ElementHandler btnOk;
    ElementHandler btnCancelComment;
    ElementHandler btnDownloadScanned;
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
    ElementHandler ddEditClient;
    ElementHandler ddEditSupplier;
    ElementHandler ddEditUtilityType;
    ElementHandler btnEditMeta;
    ElementHandler btnSave;

    public ManualInvoiceEntry(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabManualInvoiceEntry = _webDriverHandler.byXpath("//a[text() = 'Manual Invoice Entry']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
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
        tbCantInput = _webDriverHandler.byXpath("//*[@id='modalCantInput']//*[@id='Message']");
        messageCantInput = _webDriverHandler.byXpath("//*[@id='modalCantInput']//*[@id='Message-error']");
        btnSubmitCantInput = _webDriverHandler.byXpath("//*[@id='modalCantInput']//button[contains(text(),'Submit')]");
        btnSubmitReferData = _webDriverHandler.byXpath("//*[@id='modalRefer']//button[contains(text(),'Submit')]");
        btnCancelReferData = _webDriverHandler.byXpath("//*[@id='modalRefer']//button[contains(text(),'Cancel')]");
        btnCancelCantInput = _webDriverHandler.byXpath("//*[@id='modalCantInput']//button[contains(text(),'Cancel')]");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        btnCancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        tbReferData = _webDriverHandler.byXpath("//*[@id='modalRefer']//*[@id='Message']");
        messageReferData = _webDriverHandler.byXpath("//*[@id='modalRefer']//*[@id='Message-error']");
        ddShow = _webDriverHandler.byXpath("//select[contains (@name, 'DataTables_Table')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        //Metadata
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='modalDocumentTypeID']");
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
        btnSave = _webDriverHandler.byXpath("//*[contains(text(), 'Save')]");
        btnCancelMeta = _webDriverHandler.byXpath("//*[@id='editMetadataForm']//*[contains(text(), 'Cancel')]");
    }

    public String[] tblManualInvoiceEntry = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Received Date", "Status", "Assigned", ""};
    public String[] arrManualInvoiceEntry = new String[9];

    String strErrorGeneric = "Message cannot be blank";

    public void accessManualInvoiceEntry() {
        do {
            tabManualInvoiceEntry.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrManualInvoiceEntry.length; i++) {
            arrManualInvoiceEntry[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblManualInvoiceEntry[i].equals(arrManualInvoiceEntry[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadManualInvoiceEntry() {
        if (btnDdCustomers.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() && dateFrom.isDisplayed() &&
                btnDdAssigned.isDisplayed() && dateTo.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed() && btnDdParentCustomers.isDisplayed()
        ) {
            System.out.println("Manual Invoice Entry page has loaded properly.");
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

    public void filterManualInvoiceEntry(String filterType, String... text) {
        switch (filterType) {
            case "Customer":
                btnDdCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='CustomerId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Parent":
                btnDdParentCustomers.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='ParentCustomerId']]//label[contains(text(), ' " + t + "')]").click();
                    waitLoad();
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

    public void editSchedule(String schedule, String id ) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed() && btnDownloadScanned.isDisplayed()
                && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Manual Invoice Entry edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        waitLoad();
        if(action.equals("Mark as Done")){
            btnOk.waitClickable().click();
        }
    }

    public void setAction(String action, String message) {
        ddAction.waitClickable().selectByText(action);
        if(action.equals("Send to Can't Input")){
            tbCantInput.waitClickable().sendKeys(message);
            //btnSubmitCantInput.waitClickable().click();
            btnCancelCantInput.waitClickable().click();
        }
        else if (action.equals("Refer to Data Analyst")){
            tbReferData.waitClickable().sendKeys(message);
            //btnSubmitReferData.waitClickable().click();
            btnCancelReferData.waitClickable().click();
        }
        else{
            Assert.fail("Please provide a valid Action");
        }
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
        ddAction.waitClickable().selectByText("Send to Can't Input");
        btnSubmitCantInput.waitClickable().click();
        Assert.assertEquals(messageCantInput.getText(), strErrorGeneric);
        btnCancelCantInput.waitClickable().click();
        ddAction.waitClickable().selectByText("Refer to Data Analyst");
        btnSubmitReferData.waitClickable().click();
        Assert.assertEquals(messageReferData.getText(), strErrorGeneric);
        btnCancelReferData.waitClickable().click();
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorGeneric);
        btnCancelComment.waitClickable().click();
    }

    public void verifyMetaData() {
        if(rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
           rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
           rowMPANMPRN.isDisplayed() && tbMPANMPRN.getAttribute("readonly").equalsIgnoreCase("true") &&
           rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
           rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
           rowUtilityType.isDisplayed() && ddUtilityType.getAttribute("readonly").equalsIgnoreCase("true")
        )
        {
            System.out.println("Meta Data is available.");
        }
        else {Assert.fail("Meta Data not Loaded properly.");}
    }

    public void editMetaData(String... mateData) {
        btnEditMeta.waitClickable().click();
        waitLoad();
        ddDocumentType.selectByText(mateData[0]);
        tbEditInvoiceNumber.clear().sendKeys(mateData[1]);
        tbEditAccountNumber.clear().sendKeys(mateData[2]);
        tbEditMPANMPRN.clear().sendKeys(mateData[3]);
        ddEditClient.waitClickable().selectByText(mateData[4]);
        ddEditSupplier.waitClickable().selectByText(mateData[5]);
        ddEditUtilityType.waitClickable().selectByText(mateData[6]);
        //btnSave.waitClickable().click();
        btnCancelMeta.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
