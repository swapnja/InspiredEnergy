package com.BulkScanning.PageObject.DocumentScheduling;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.nio.file.Paths;

@Deprecated
public class OverdueEDI {

    //SCE - Send Chase Email
    //MAC - Mark as Chased
    //CCH - Check Chase History
    WebDriverHandler _webDriverHandler;
    ElementHandler tabOverdueEDIs;
    ElementHandler search;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler btnDdStatuses;
    ElementHandler btnDdSchedule;
    ElementHandler btnDdAssigned;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler ddBulkAction;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler ddAction;
    ElementHandler tbChaseMessageMAC;
    ElementHandler messageChaseMAC;
    ElementHandler btnSubmit;
    ElementHandler btnCancel;
    ElementHandler tbEmailTo;
    ElementHandler messageTo;
    ElementHandler tbEmailCC;
    ElementHandler messageCC;
    ElementHandler tbSubject;
    ElementHandler messageSubject;
    ElementHandler uploadEmail;
    ElementHandler btnDownloadReport;
    ElementHandler tbEmailMessageSCE;
    ElementHandler messageEmailSCE;
    ElementHandler btnSend;
    ElementHandler btnYes;
    ElementHandler btnOK;
    ElementHandler chooseAttachment;
    ElementHandler btnAttach;
    ElementHandler messageAttachment;
    ElementHandler tbMessageCCH;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler btnDdSites;
    ElementHandler btnDdUtilities;
    ElementHandler btnDdMeters;
    ElementHandler btnExport;
    ElementHandler btnDownloadReportChase;
    ElementHandler ddShow;

    public OverdueEDI(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabOverdueEDIs = _webDriverHandler.byXpath("//a[contains(text(), 'Overdue EDIs')]");
        search = _webDriverHandler.byXpath("//*[contains(@id, 'DataTables_Table')]//input[@type='search']");
        btnDdCustomers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Customers')]]");
        btnDdSuppliers = _webDriverHandler.byXpath("//button[span[contains(text(), 'Suppliers')]]");
        btnDdStatuses = _webDriverHandler.byXpath("//button[span[contains(text(), '1 selected')]]");
        btnDdSchedule = _webDriverHandler.byXpath("//button[span[contains(text(), 'Schedule')]]");
        btnDdAssigned = _webDriverHandler.byXpath("//button[span[contains(text(), 'Assigned To')]]");
        btnApply = _webDriverHandler.byXpath("//button[contains(text(),'Apply')]");
        btnReset = _webDriverHandler.byXpath("//button[contains(text(),'Reset')]");
        btnExportExcel = _webDriverHandler.byXpath("//button[contains(text(),'Export Excel')]");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        ddBulkAction = _webDriverHandler.byXpath("//*[contains(@class, 'bulk-action')]");
        ddUsers = _webDriverHandler.byXpath("//*[@id='ddlBulkAssignee']");
        btnProcess = _webDriverHandler.byXpath("//*[contains(@class, 'bulk-process')]");
        selectAll = _webDriverHandler.byXpath("//input[@class = 'check-all']");
        ddAssignment = _webDriverHandler.byXpath("//*[@id='AssignedTo']");
        linkAssignToMe = _webDriverHandler.byXpath("//a[@class='assign-to-me']");
        ddAction = _webDriverHandler.byXpath("//*[@id='SchEDI_ActionID']");
        tbChaseMessageMAC = _webDriverHandler.byXpath("//*[@id='chaseForm']//*[@id='Message']");
        messageChaseMAC = _webDriverHandler.byXpath("//*[@id='chaseForm']//*[@id='Message-error']");
        btnSubmit = _webDriverHandler.byXpath("//button[contains(text(),'Submit')]");
        btnCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel')]");
        tbEmailTo = _webDriverHandler.byXpath("//*[@id='To']");
        messageTo = _webDriverHandler.byXpath("//*[@id='To-error']");
        tbEmailCC = _webDriverHandler.byXpath("//*[@id='CC']");
        messageCC = _webDriverHandler.byXpath("//*[@id='CC-error']");
        tbSubject = _webDriverHandler.byXpath("//*[@id='Subject']");
        messageSubject = _webDriverHandler.byXpath("//*[@id='Subject-error']");
        uploadEmail = _webDriverHandler.byXpath("//*[@id='emailForm']//input[@type='file']");
        btnDownloadReport = _webDriverHandler.byXpath("//*[@id='emailForm']//i");
        tbEmailMessageSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message']");
        messageEmailSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message-error']");
        btnSend = _webDriverHandler.byXpath("//button[contains(text(),'Send')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        chooseAttachment = _webDriverHandler.byXpath("//input[@type='file']");
        btnAttach = _webDriverHandler.byXpath("//*[@id='btnAttachFiles']");
        messageAttachment = _webDriverHandler.byXpath("//*[@id='div_attachError']");
        tbMessageCCH = _webDriverHandler.byXpath("//*[@id='modalChase']//*[@id='Message']");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        btnDdSites = _webDriverHandler.byXpath("//button[span[contains(text(), 'Sites')]]");
        btnDdUtilities = _webDriverHandler.byXpath("//button[span[contains(text(), 'Utilities')]]");
        btnDdMeters = _webDriverHandler.byXpath("//button[span[contains(text(), 'Meters')]]");
        btnExport = _webDriverHandler.byXpath("//button[contains(text(),'Export')]");
        btnDownloadReportChase = _webDriverHandler.byXpath("//*[@id='modalChase']//i");
        ddShow = _webDriverHandler.byXpath("//select[contains (@name, 'DataTables_Table')]");
    }

    public String[] tblOverdueEDIs = new String[]{"", "Id", "Schedule", "Supplier", "Customer Count", "Due Date", "Days Overdue", "Last Chased", "Status", "Assigned", ""};
    public String[] arrOverdueEDIs = new String[11];

    String strErrorMessageMAC = "Message cannot be blank";
    String strErrorTo = "To cannot be blank";
    String strErrorSubject = "Subject cannot be blank";
    String strErrorEmailSCE = "Message cannot be blank";
    String strErrorComment = "Message cannot be blank";
    String strErrorAttachment = "Unable to upload the following files as they exceed 10MB or are of the forbidden type (.exe or .js)";

    public void accessOverdueEDIs() {
        do {
            tabOverdueEDIs.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrOverdueEDIs.length; i++) {
            arrOverdueEDIs[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblOverdueEDIs[i].equals(arrOverdueEDIs[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadOverdueEDIs() {
        if (btnDdCustomers.isDisplayed() && btnDdSchedule.isDisplayed() && btnDdStatuses.isDisplayed() && btnDdSuppliers.isDisplayed() && dateFrom.isDisplayed() &&
                btnDdAssigned.isDisplayed() && dateTo.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed() && ddUsers.isDisplayed() && btnProcess.isDisplayed()
        ) {
            System.out.println("Document Schedule page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void searchSchedules(String term) {
        search.waitClickable().sendKeys(term);
        waitLoad();
    }

    public void exportExcel(String... selection) {
        ddShow.waitClickable().selectByText("100");
        waitLoad();
        for (String t : selection) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click().sendKeys(Keys.PAGE_DOWN);
        }
        btnExportExcel.waitClickable().click();
    }

    public void filterOverdueEDI(String filterType, String... text) {
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
            case "Schedule":
                btnDdSchedule.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='ScheduleId']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Status":
                btnDdStatuses.waitClickable().click();
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

    public void setBulkAssignee(String user) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(user);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String schedule, String id) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void setAction(String message) {
        ddAction.waitClickable().selectByText("Mark As Chased");
        waitLoad();
        tbChaseMessageMAC.waitClickable().clear().sendKeys(message);
        btnSubmit.waitClickable().click();
        waitLoad();
    }

    public void setAction(String[] data) {
        //data = {To, CC, Path, Message}
        ddAction.waitClickable().selectByText("Send Chase Email");
        waitLoad();
        tbEmailTo.waitClickable().clear().sendKeys(data[0]);
        tbEmailCC.waitClickable().clear().sendKeys(data[1]);
        uploadEmail.waitClickable().clear().sendKeys(data[2]);
        btnDownloadReport.waitClickable().click();
        tbEmailMessageSCE.waitClickable().clear().sendKeys(data[3]);
        btnSend.waitClickable().click();
        waitLoad();
    }

    public void setAction() {
        ddAction.waitClickable().selectByText("Mark as Received");
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

    public void addAttachment(String path) {
        chooseAttachment.waitClickable().sendKeys(path);
        btnAttach.waitClickable().click();
        waitLoad();
    }

    public void downloadAttachment(String attachment) {
        _webDriverHandler.byXpath("//div[div[label[contains(text(), '"+ attachment +"')]]]//*[contains(@class, 'btnDownloadEDIAttachment')]").waitClickable().click();
    }

    public void deleteAttachment(String attachment) {
        _webDriverHandler.byXpath("//div[div[label[contains(text(), '"+ attachment +"')]]]//*[contains(@class, 'btnDeleteEDIAttachment')]").waitClickable().click();
        waitLoad();
    }

    public void verifyChaseHistoryComment() {
        if (tbMessageCCH.isDisplayed() && tbMessageCCH.getAttribute("readonly").equals("true") && btnSubmit.notPresent())
        {
            System.out.println("Chase history modal is loaded properly.");
        }
        else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancel.waitClickable().click();
    }

    public void verifyChaseHistoryEmail() {
        if (tbEmailTo.isDisplayed() && tbEmailTo.getAttribute("readonly").equals("true") && tbEmailCC.isDisplayed() && tbEmailCC.getAttribute("readonly").equals("true") && tbMessageCCH.isDisplayed() &&
                tbMessageCCH.getAttribute("readonly").equals("true") && btnSend.notPresent() && btnDownloadReportChase.isDisplayed() && btnCancel.isDisplayed())
        {
            System.out.println("Chase history modal is loaded properly.");
        }
        else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancel.waitClickable().click();
    }

    public void checkChaseHistory(String date, String user, String type) {
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
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

    public void addComment(String comment) {
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
        waitLoad();
    }

    public void filterEditExport(String filterType, String[] text) {
        switch (filterType) {
            case "Customer":
                btnDdCustomers.waitClickable().click();
                break;
            case "Supplier":
                btnDdSuppliers.waitClickable().click();
                break;
            case "Schedule":
                btnDdSchedule.waitClickable().click();
                break;
            case "Status":
                btnDdStatuses.waitClickable().click();
                break;
            default:
                Assert.fail("Proper Filter is not selected.");
        }
        for (String t : text) {
            _webDriverHandler.byXpath("//label[contains(text(), ' " + t + "')]").click();
        }
    }

    public void selectExport(String... selection) {
        for (String t : selection) {
            do{btnAddComment.sendKeys(Keys.PAGE_DOWN);}
            while (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").notPresent());
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click();
        }
        btnExport.waitClickable().click();
    }

    public void selectExport() {
        do{btnAddComment.sendKeys(Keys.PAGE_DOWN);}
        while (_webDriverHandler.byXpath("//input[@id='chkParentExpectedInvoices']").notPresent());
        _webDriverHandler.byXpath("//input[@class='chkChildExpectedInvoices']").click();
        btnExport.waitClickable().click();
    }

    public void errorValidations() {
        ddAction.waitClickable().selectByText("Mark As Chased");
        waitLoad();
        btnSubmit.waitClickable().click();
        Assert.assertEquals(messageChaseMAC.getText(), strErrorMessageMAC);
        btnCancel.waitClickable().click();
        ddAction.waitClickable().selectByText("Send Chase Email");
        waitLoad();
        tbEmailTo.waitClickable().clear();
        btnSend.waitClickable().click();
        Assert.assertEquals(messageTo.getText(), strErrorTo);
        Assert.assertEquals(messageSubject.getText(), strErrorSubject);
        Assert.assertEquals(messageEmailSCE.getText(), strErrorEmailSCE);
        btnCancel.waitClickable().click();
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorComment);
        btnCancel.waitClickable().click();
        String path = Paths.get("debug.log").toAbsolutePath().toString();
        addAttachment(path);
        if(messageAttachment.getText().startsWith(strErrorAttachment)){}
        else {Assert.fail();}
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
