package com.BulkScanning.PageObject.EmailProcessing;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class EmailProcessing {
    
    WebDriverHandler _webDriverHandler;
    ElementHandler tabEmailProcessing;
    ElementHandler search;
    ElementHandler btnDdFrom;
    ElementHandler btnDdStatus;
    ElementHandler btnDdAssigned;
    ElementHandler btnDdPriority;
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
    ElementHandler btnYes;
    ElementHandler btnDoneCancel;
    ElementHandler btnOK;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler btnCancelComment;

    ElementHandler tbFrom;
    ElementHandler tbSubject;
    ElementHandler tbMessage;
    ElementHandler tbStatus;
    ElementHandler btnViewSend;
    ElementHandler btnViewCancel;

    //Edit By Page
    ElementHandler ddEditByPageAction;
    ElementHandler ddOutputMode;
    ElementHandler ddDocumentType;
    ElementHandler btnEditByPage;
    ElementHandler btnEditByRange;
    ElementHandler btnCreateOutput;
    ElementHandler tbReturnMessage;
    ElementHandler btnReturnSender;
    ElementHandler btnReturnCancel;

    public EmailProcessing(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabEmailProcessing = _webDriverHandler.byXpath("//a[contains(text(), 'Email Processing')]");
        search = _webDriverHandler.byXpath("//*[contains(@id, 'DataTables_Table')]//input[@type='search']");
        btnDdFrom = _webDriverHandler.byXpath("//span[select[@id = 'FromEmail']]/div/button");
        btnDdStatus = _webDriverHandler.byXpath("//span[select[@id = 'EmailStatus']]/div/button");
        btnDdAssigned = _webDriverHandler.byXpath("//span[select[@id = 'AssignedToId']]/div/button");
        btnDdPriority = _webDriverHandler.byXpath("//span[select[@id = 'Priority']]/div/button");
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
        ddAction = _webDriverHandler.byXpath("//*[@id='Action']");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        btnDoneCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel') and contains(@class,'swal2-cancel')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        btnCancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");

        tbFrom = _webDriverHandler.byXpath("//*[@id='FromEmail']");
        tbSubject = _webDriverHandler.byXpath("//*[@id='Subject']");
        tbMessage = _webDriverHandler.byXpath("//*[@id='Message']");
        tbStatus = _webDriverHandler.byXpath("//*[@id='Status']");
        btnViewSend = _webDriverHandler.byXpath("//div[@id = 'modalEmailProcessing-attachment']//button[text() = 'Send']");
        btnViewCancel = _webDriverHandler.byXpath("//div[@id = 'modalEmailProcessing-attachment']//button[text() = 'Cancel']");

        ddEditByPageAction = _webDriverHandler.byXpath("//*[@id='documentStatus']");
        ddOutputMode = _webDriverHandler.byXpath("//*[@id='outputMode']");
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='documentType']");
        btnEditByPage = _webDriverHandler.byXpath("//button[contains(@class, 'edit-by-page')]");
        btnEditByRange = _webDriverHandler.byXpath("//button[contains(@class, 'edit-by-range')]");
        btnCreateOutput = _webDriverHandler.byXpath("//button[contains(@class, 'createOutput')]");
        tbReturnMessage = _webDriverHandler.byXpath("//*[@id='modalEmailProcessing-returnToSender']//*[@id='Message']");
        btnReturnSender = _webDriverHandler.byXpath("//button[contains(@class, 'return-to-sender')]");
        btnReturnCancel = _webDriverHandler.byXpath("//button[contains(@class, 'btn-danger')]");
    }

    public String[] tblOverdueEDIs = new String[]{"", "", "Id", "From", "Subject", "Attachments", "Received Date", "Status", "Assigned", ""};
    public String[] arrOverdueEDIs = new String[10];

    String strErrorGeneric = "Message cannot be blank";

    public void accessEmailProcessing() {
        do {
            tabEmailProcessing.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrOverdueEDIs.length; i++) {
            arrOverdueEDIs[i] = _webDriverHandler.byXpath("//table[contains(@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblOverdueEDIs[i].equals(arrOverdueEDIs[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadEmailProcessing() {
        if (btnDdFrom.isDisplayed() && btnDdPriority.isDisplayed() && btnDdStatus.isDisplayed() && dateFrom.isDisplayed() &&
                btnDdAssigned.isDisplayed() && dateTo.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed()
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

    public void exportExcel(String[] selection) {
        for (String t : selection) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click();
        }
        btnExportExcel.waitClickable().click();
    }

    public void filterEmailProcessing(String filterType, String... text) {
        switch (filterType) {
            case "From":
                btnDdFrom.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='FromEmail']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Priority":
                btnDdPriority.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='Priority']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Status":
                _webDriverHandler.byXpath("//*[@id='EmailStatus']").waitClickable().deselectAll();
                btnDdStatus.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='EmailStatus']]//label[contains(text(), ' " + t + "')]").click();
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

    public void setBulkAssignee(String user) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(user);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void setBulkAssignee(String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(bulkData[2]);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String id) {
        searchSchedules(id);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (tbFrom.isDisplayed() && tbFrom.getAttribute("readonly").equalsIgnoreCase("true") && tbSubject.isDisplayed() && tbSubject.getAttribute("readonly")
                .equalsIgnoreCase("true") && tbMessage.isDisplayed() && tbMessage.getAttribute("readonly").equalsIgnoreCase("true") && tbStatus.isDisplayed()
                && tbStatus.getAttribute("readonly").equalsIgnoreCase("true")
        ) {
            System.out.println("Email Processing edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void changeAssignment(String user) {
        if (user.equals("Me")) {
            linkAssignToMe.waitClickable().click();
        } else {
            ddAssignment.waitClickable().selectByText(user);
        }
        waitLoad();
    }

    public void view(String fileName) {
        _webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").waitClickable().click();
        btnViewCancel.waitClickable().click();
    }

    public void send(String fileName) {
        _webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").scrollDown().waitClickable().click();
        btnViewSend.waitClickable().click();
        Assert.assertFalse(_webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").isDisplayed(),
                "View button is not hidden.");
    }

    public void setAction(String action){
        ddAction.waitClickable().selectByText(action);
        if (action.equalsIgnoreCase("Edit By Page")) {
            Assert.assertTrue(btnEditByRange.isDisplayed());
        }
        else if (action.equalsIgnoreCase("Edit By Range")) {
            Assert.assertTrue(btnEditByPage.isDisplayed());
        }
        else if (action.equalsIgnoreCase("Mark as Done")) {
            //btnYes.waitClickable().click();
            btnDoneCancel.waitClickable().click();
        }
    }

    public void editBy(String action, int pageNo) {
        switch (action) {
            case "View":
                _webDriverHandler.byXpath("//center[text() = '" + pageNo + "']//button[contains(@class, 'page-view')]").scrollDown().waitClickable().click();
                break;
            case "Add":
                _webDriverHandler.byXpath("//center[text() = '" + pageNo + "']//button[contains(@class, 'page-add')]").scrollDown().waitClickable().click();
                break;
            case "Delete":
                _webDriverHandler.byXpath("//*[@id = 'modalEmailProcessing']//input[@value = '" + pageNo + "']//..//button//i[contains(@class, 'fa-trash-alt')]").waitClickable().click();
                break;
            case "Page Up":
                _webDriverHandler.byXpath("//*[@id = 'modalEmailProcessing']//input[@value = '" + pageNo + "']//..//button//i[contains(@class, 'fa-arrow-down')]").waitClickable().click();
                break;
            case "Page Down":
                _webDriverHandler.byXpath("//*[@id = 'modalEmailProcessing']//input[@value = '" + pageNo + "']//..//button//i[contains(@class, 'fa-arrow-up')]").waitClickable().click();
                break;
        }
    }

    public void editByActions(String action, String outputMode, String documentType, String message) {
        switch (action) {
            case "Select All":
                _webDriverHandler.byXpath("//button[contains(@class, 'select-all')]").waitClickable().click();
                break;
            case "Deselect All":
                _webDriverHandler.byXpath("//button[contains(@class, 'deselect-all')]").waitClickable().click();
                break;
            case "Postroom":
                ddEditByPageAction.waitClickable().selectByText("Send Document to Postroom");
                ddOutputMode.waitClickable().selectByText(outputMode);
                ddDocumentType.waitClickable().selectByText(documentType);
                btnCreateOutput.waitClickable().click();
                break;
            case "Return":
                ddEditByPageAction.waitClickable().selectByText("Return To Sender");
                btnCreateOutput.waitClickable().click();
                tbReturnMessage.waitClickable().sendKeys(message);
                btnReturnSender.waitClickable().click();
                break;
        }
    }

    public void markAsDone(String fileName) {
        _webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").scrollDown().waitClickable().click();
        btnViewSend.waitClickable().click();
        Assert.assertFalse(_webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").isDisplayed(),
                "View button is not hidden.");
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
        btnCancelComment.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
