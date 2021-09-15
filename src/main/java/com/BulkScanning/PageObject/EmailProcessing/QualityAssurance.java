package com.BulkScanning.PageObject.EmailProcessing;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class QualityAssurance {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabQualityAssurance;
    ElementHandler search;
    ElementHandler btnDdOGWork;
    ElementHandler btnDdStatuses;
    ElementHandler btnDdAssigned;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler dateFrom;
    ElementHandler dateTo;
    ElementHandler ddBulkAction;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler btnClose;
    ElementHandler headerMessage;
    ElementHandler headerDocuments;
    ElementHandler processedAttachments;
    ElementHandler tbStatus;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler cancelComment;

    public QualityAssurance(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabQualityAssurance = _webDriverHandler.byXpath("//a[contains(text(), 'Quality Assurance')]");
        search = _webDriverHandler.byXpath("//*[contains(@id, 'DataTables_Table')]//input[@type='search']");
        btnDdOGWork = _webDriverHandler.byXpath("//button[span[contains(text(), 'Original Workflow')]]");
        btnDdStatuses = _webDriverHandler.byXpath("//button[span[contains(text(), '1 selected')]]");
        btnDdAssigned = _webDriverHandler.byXpath("//button[span[contains(text(), 'Assigned To')]]");
        btnApply = _webDriverHandler.byXpath("//button[contains(text(),'Apply')]");
        btnReset = _webDriverHandler.byXpath("//button[contains(text(),'Reset')]");
        btnExportExcel = _webDriverHandler.byXpath("//button[contains(text(),'Export Excel')]");
        dateFrom = _webDriverHandler.byXpath("//*[@id='DateFrom']");
        dateTo = _webDriverHandler.byXpath("//*[@id='DateTo']");
        ddBulkAction = _webDriverHandler.byXpath("//*[contains(@class, 'ddl')]");
        btnProcess = _webDriverHandler.byXpath("//*[contains(@class, 'bulk-process')]");
        selectAll = _webDriverHandler.byXpath("//input[@class = 'check-all']");
        btnClose = _webDriverHandler.byXpath("//h5[text()='Document']//..//button");
        headerMessage = _webDriverHandler.byXpath("//h6[text()='Message']");
        headerDocuments = _webDriverHandler.byXpath("//h6[text()='Documents']");
        processedAttachments = _webDriverHandler.byXpath("//h4[text()='Processed Attachments']");
        tbStatus = _webDriverHandler.byXpath("//*[@id='Status']");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
    }

    public String[] tblQualityAssurance = new String[]{"", "Id", "Processed", "Original Workflow", "", "Status", "To Send", "Assigned", "", "", ""};
    public String[] arrQualityAssurance = new String[11];

    public String[] tblProcessedAttachments = new String[]{"Attachment", "Page", "Output", "Status", ""};
    public String[] arrProcessedAttachments = new String[5];

    public void accessQualityAssurance() {
        do {
            tabQualityAssurance.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrQualityAssurance.length; i++) {
            arrQualityAssurance[i] = _webDriverHandler.byXpath("//div[contains (@class, 'dataTables_scrollHeadInner')]//table//th[" + (i + 1) + "]").getText();
            if (!(tblQualityAssurance[i].equals(arrQualityAssurance[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadQualityAssurance() {
        if (btnDdOGWork.isDisplayed() && btnDdAssigned.isDisplayed() && btnDdStatuses.isDisplayed() && dateFrom.isDisplayed() && btnProcess.isDisplayed() &&
                dateTo.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() && btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed()
        ) {
            System.out.println("Document Schedule page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void searchSchedules(String term) {
        search.waitClickable().clear().sendKeys(term);
        waitLoad();
    }

    public void exportExcel(String[] selection) {
        for (String t : selection) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + t + "')]]//input").click();
        }
        btnExportExcel.waitClickable().click();
    }

    public void filterQualityAssurance(String filterType, String... text) {
        switch (filterType) {
            case "Original Workflow":
                btnDdOGWork.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='OriginalWorkFlow']]//label[contains(text(), ' " + t + "')]").click();
                }
                break;
            case "Status":
                btnDdStatuses.waitClickable().click();
                for (String t : text) {
                    _webDriverHandler.byXpath("//span[select[@id='EmailStatus']]//label[contains(text(), ' " + t + "')]").click();
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

    public void viewChanges(String workflow, String id){
        searchSchedules(workflow);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button[@type= 'button']").click();
        waitLoad();
    }

    public void viewChanges(){
        _webDriverHandler.byXpath("//table[contains(@id, 'DataTables')]//tbody//tr[1]//button[@type= 'button']").click();
        waitLoad();
    }

    public void viewDocument(String workflow, String id){
        searchSchedules(workflow);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button[text()]").click();
        waitLoad();
        btnClose.waitClickable().click();
    }

    public void viewDocument(){
        _webDriverHandler.byXpath("//table[contains(@id, 'DataTables')]//tbody//tr[1]//button[text()]").click();
        waitLoad();
        btnClose.waitClickable().click();
    }

    public void approve(String workflow, String id){
        searchSchedules(workflow);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//*[@class='btnApproveEmail']//i").click();
        waitLoad();
    }

    public void approve(){
        _webDriverHandler.byXpath("//table[contains(@id, 'DataTables')]//tbody//tr[1]//*[@class='btnApproveEmail']//i").click();
        waitLoad();
    }

    public void reject(String workflow, String id){
        searchSchedules(workflow);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//*[@class='btnRejectEmail']//i").click();
        waitLoad();
    }

    public void reject(){
        _webDriverHandler.byXpath("//table[contains(@id, 'DataTables')]//tbody//tr[1]//*[@class='btnRejectEmail']//i").click();
        waitLoad();
    }

    public void setBulkAction(String action) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText(action);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void setBulkAction(String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText(bulkData[2]);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    public void editVerify(){
        if (headerDocuments.isDisplayed() && headerMessage.isDisplayed() && processedAttachments.isDisplayed() && tbStatus.isDisplayed() &&
                tbStatus.getAttribute("readonly").equals("true") && tbStatus.getAttribute("value").equals("Awaiting Review")
        ) {
            System.out.println("Document Schedule page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void editDownload(String file) {
     _webDriverHandler.byXpath("//div[contains(@data-path, '" + file + "')]//button").waitClickable().click();
    }

    public void editDownload() {
        _webDriverHandler.byXpath("(//button[contains(@class, 'btnDownloadEmailAttachment')])[1]").waitClickable().click();
    }

    public void editView(String file, String pgNo) {
        _webDriverHandler.byXpath("//div[div/label[text()='" + file + "']][div/label[text()='"+ pgNo +"']]//div//button").waitClickable().click();
    }

    public void editView() {
        _webDriverHandler.byXpath("(//button[contains(@class, 'btnViewOutputDocPage')])[1]").waitClickable().click();
        waitLoad();
        btnClose.waitClickable().click();
    }

    public void columnVerificationPA() {
        for (int i = 0; i < arrProcessedAttachments.length; i++) {
            arrProcessedAttachments[i] = _webDriverHandler.byXpath("//*[@id='divProcessedDocuments']//div//div[@class='row'][1]//div[" + (i + 1) + "]").getText();
            if (!(tblProcessedAttachments[i].equals(arrProcessedAttachments[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void addComment(String comment) {
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
        waitLoad();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}