package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class AwaitingEDI {

    //SCE - Send Chase Email
    //MAC - Mark as Chased
    //CCH - Check Chase History
    WebDriverHandler _webDriverHandler;
    ElementHandler tabAwaitingEDI;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatuses;
    ElementHandler btnDdAssigned;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler ddBulkAction;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAction;
    ElementHandler tbChaseMessageMAC;
    ElementHandler messageChaseMAC;
    ElementHandler btnSubmit;
    ElementHandler btnCancelChase;
    ElementHandler btnCancelEmail;
    ElementHandler btnCancelComment;
    ElementHandler btnCancelHistory;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler tbCurrentStatus;
    ElementHandler tbEmailTo;
    ElementHandler messageTo;
    ElementHandler tbEmailCC;
    ElementHandler messageCC;
    ElementHandler tbSubject;
    ElementHandler messageSubject;
    //ElementHandler uploadEmail;
    //ElementHandler btnDownloadReport;
    ElementHandler tbEmailMessageSCE;
    ElementHandler messageEmailSCE;
    ElementHandler btnSend;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler tbMessageCCH;
    ElementHandler messageComment;
    //ElementHandler btnDownloadReportChase;
    ElementHandler cancelComment;
    ElementHandler btnOk;
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
    ElementHandler btnCancelMeta;
    ElementHandler btnEditMeta;
    ElementHandler btnSave;
    //ElementHandler logo;
    
    public AwaitingEDI(WebDriverHandler webDriverHandler) {
    	_webDriverHandler = webDriverHandler;
        tabAwaitingEDI = _webDriverHandler.byXpath("//a[text() = 'Awaiting EDI']");
    	btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
        btnDdStatuses = _webDriverHandler.byXpath("//span[select[@id = 'StatusId']]/div/button");
        btnDdAssigned = _webDriverHandler.byXpath("//span[select[@id = 'AssignedToId']]/div/button");
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
        ddAction = _webDriverHandler.byXpath("//*[@id='Action']");
        tbChaseMessageMAC = _webDriverHandler.byXpath("//*[@id='chaseForm']//*[@id='Message']");
        messageChaseMAC = _webDriverHandler.byXpath("//*[@id='chaseForm']//*[@id='Message-error']");
        btnSubmit = _webDriverHandler.byXpath("//button[contains(text(),'Submit')]");
        btnCancelChase = _webDriverHandler.byXpath("//div[div/h5[text() = 'Confirmed Chase']]//button[contains(text(),'Cancel')]");
        btnCancelEmail = _webDriverHandler.byXpath("//div[div/h5[text() = 'Send Chase Email']]//button[contains(text(),'Cancel')]");
        btnCancelComment = _webDriverHandler.byXpath("//div[div/h5[text() = 'Comments']]//button[contains(text(),'Cancel')]");
        btnCancelHistory = _webDriverHandler.byXpath("//*[@id = 'modalChase']//button[contains(text(),'Cancel')]");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        tbMessageCCH = _webDriverHandler.byXpath("//*[@id='modalChase']//*[@id='Message']");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        tbEmailTo = _webDriverHandler.byXpath("//*[@id='To']");
        messageTo = _webDriverHandler.byXpath("//*[@id='To-error']");
        tbEmailCC = _webDriverHandler.byXpath("//*[@id='CC']");
        messageCC = _webDriverHandler.byXpath("//*[@id='CC-error']");
        tbSubject = _webDriverHandler.byXpath("//*[@id='Subject']");
        messageSubject = _webDriverHandler.byXpath("//*[@id='Subject-error']");
        //uploadEmail = _webDriverHandler.byXpath("//*[@id='emailForm']//input[@type='file']");
        //btnDownloadReport = _webDriverHandler.byXpath("//*[@id='emailForm']//i");
        tbEmailMessageSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message']");
        messageEmailSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message-error']");
        btnSend = _webDriverHandler.byXpath("//button[contains(text(),'Send')]");
        //btnDownloadReportChase = _webDriverHandler.byXpath("//*[@id='modalChase']//i");
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
        //logo = _webDriverHandler.byXpath("//a[text() ='Terms of Use']");
    }

    public String[] tblAwaitingEDI = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Status", "Assigned", ""};
    public String[] arrAwaitingEDI = new String[8];

    String strErrorGeneric = "Message cannot be blank";
    String strErrorTo = "To cannot be blank";
    String strErrorSubject = "Subject cannot be blank";

    public void accessAwaitingEDI() {
        do {
            tabAwaitingEDI.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrAwaitingEDI.length; i++) {
            arrAwaitingEDI[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblAwaitingEDI[i].equals(arrAwaitingEDI[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadAwaitingEDI() {
        if (btnDdCustomers.isDisplayed() && btnDdParentCustomers.isDisplayed() && btnDdStatuses.isDisplayed() && btnDdSuppliers.isDisplayed() &&
                btnDdAssigned.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed()
        ) {
            System.out.println("Awaiting EDI page has loaded properly.");
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

    public void filterAwaitingEDI(String filterType, String... text) {
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
            case "Status":
                btnDdStatuses.waitClickable().click();
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

    public void setBulkAction(String action, String user) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText(action);
        if (action.equals("Bulk Assign")){ddUsers.waitClickable().selectByText(user);}
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void setBulkAction(String action, String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText(action);
        if (action.equals("Bulk Assign")){ddUsers.waitClickable().selectByText(bulkData[2]);}
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String id ) {
        searchSchedules(id);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed()
                && btnDownloadScanned.isDisplayed() && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed()
        ) {
            System.out.println("Awaiting EDI edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void setAction(String action, String message) {
        switch (action) {
            case "Mark As Chased" :
                ddAction.waitClickable().selectByText("Mark As Chased");
                waitLoad();
                tbChaseMessageMAC.waitClickable().sendKeys(message);
                btnSubmit.waitClickable().click();
                waitLoad();
                break;
            case "Retry Match" :
                ddAction.waitClickable().selectByText("Retry Match");
                btnOk.waitClickable().click();
                break;
            case "Move to Manual Entry" :
                ddAction.waitClickable().selectByText("Move to Manual Entry");
                btnOk.waitClickable().click();
                break;
            default:
                System.out.println("Please provide valid Action.");
        }
    }

    public void setAction(String... data) {
        //data = {To, CC, Subject, Message}
        ddAction.waitClickable().selectByText("Send Chase Email");
        waitLoad();
        tbEmailTo.waitClickable().clear().sendKeys(data[0]);
        tbEmailCC.waitClickable().clear().sendKeys(data[1]);
        tbSubject.waitClickable().clear().sendKeys(data[2]);
        tbEmailMessageSCE.waitClickable().clear().sendKeys(data[3]);
        btnSend.waitClickable().click();
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

    public void verifyChaseHistoryComment() {
        if (tbMessageCCH.isDisplayed() && tbMessageCCH.getAttribute("readonly").equalsIgnoreCase("true"))
        {
            System.out.println("Chase history modal is loaded properly.");
        }
        else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancelHistory.waitClickable().click();
    }

    public void verifyChaseHistoryEmail() {
        if (tbEmailTo.isDisplayed() && tbEmailTo.getAttribute("readonly").equalsIgnoreCase("true") && tbEmailCC.isDisplayed() && tbEmailCC.getAttribute("readonly").equalsIgnoreCase("true") && tbMessageCCH.isDisplayed() &&
                tbMessageCCH.getAttribute("readonly").equalsIgnoreCase("true") && tbSubject.isDisplayed() && btnCancelHistory.isDisplayed())
        {
            System.out.println("Chase history modal is loaded properly.");
        }
        else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancelHistory.waitClickable().click();
    }

    public void checkChaseHistory(String date, String user, String type) {
        do{_webDriverHandler.byXpath("//div[div[contains(text(), '"+ date +"')]][div[contains(text(), '"+ user +"')]][div[contains(text(), '"+ type +"')]]//button").sendKeys(Keys.ARROW_DOWN);}
        while (_webDriverHandler.byXpath("//div[div[contains(text(), '"+ date +"')]][div[contains(text(), '"+ user +"')]][div[contains(text(), '"+ type +"')]]//button").notPresent());
        do{_webDriverHandler.byXpath("//div[div[contains(text(), '"+ date +"')]][div[contains(text(), '"+ user +"')]][div[contains(text(), '"+ type +"')]]//button").waitClickable().click();}
        while(!_webDriverHandler.byXpath("//*[@id='overlay']").isDisplayed());
        waitLoad();
        if(type.equalsIgnoreCase("Comment")){
            verifyChaseHistoryComment();
        }
        else {
            verifyChaseHistoryEmail();
        }
    }

    public void checkChaseHistory(String type) {
        do{_webDriverHandler.byXpath("(//div[div[contains(text(), '"+ type +"')]])[1]//button").sendKeys(Keys.ARROW_DOWN);}
        while (_webDriverHandler.byXpath("(//div[div[contains(text(), '"+ type +"')]])[1]//button").notPresent());
        do{_webDriverHandler.byXpath("(//div[div[contains(text(), '"+ type +"')]])[1]//button").waitClickable().click();}
        while(!_webDriverHandler.byXpath("//*[@id='overlay']").isDisplayed());
        waitLoad();
        if(type.equalsIgnoreCase("Comment")){
            verifyChaseHistoryComment();
        }
        else {
            verifyChaseHistoryEmail();
        }
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
        ddAction.waitClickable().selectByText("Mark As Chased");
        waitLoad();
        btnSubmit.waitClickable().click();
        Assert.assertEquals(messageChaseMAC.getText(), strErrorGeneric);
        btnCancelChase.waitClickable().click();
        ddAction.waitClickable().selectByText("Send Chase Email");
        waitLoad();
        tbEmailTo.waitClickable().clear();
        btnSend.waitClickable().click();
        Assert.assertEquals(messageTo.getText(), strErrorTo);
        Assert.assertEquals(messageSubject.getText(), strErrorSubject);
        Assert.assertEquals(messageEmailSCE.getText(), strErrorGeneric);
        btnCancelEmail.waitClickable().click();
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