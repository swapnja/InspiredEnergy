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
    //Meta Data
    ElementHandler btnEditMeta;
    ElementHandler btnSave;
    ElementHandler btnCancelMeta;
    //rows
    ElementHandler rowInvoiceNumber;
    ElementHandler rowAccountNumber;
    ElementHandler rowMPANMPRN;
    ElementHandler rowParentClient;
    ElementHandler rowClient;
    ElementHandler rowSupplier;
    ElementHandler rowUtilityType;
    ElementHandler rowDueDate;
    //readonly values
    ElementHandler tbInvoiceNumber;
    ElementHandler tbAccountNumber;
    ElementHandler tbMeterNumber;
    ElementHandler tbParentClient;
    ElementHandler tbClient;
    ElementHandler tbSupplier;
    ElementHandler tbUtilityType;
    ElementHandler tbDueDate;
    //edit values
    ElementHandler ddDocumentType;
    ElementHandler tbEditInvoiceNumber;
    ElementHandler tbEditAccountNumber;
    ElementHandler tbEditMPANMPRN;
    ElementHandler ddEditParent;
    ElementHandler ddEditClient;
    ElementHandler ddEditSupplier;
    ElementHandler ddEditUtilityType;

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
        search = _webDriverHandler.byXpath("//input[@type='search']");
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
        tbEmailMessageSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message']");
        messageEmailSCE = _webDriverHandler.byXpath("//*[@id='emailForm']//*[@id='Message-error']");
        btnSend = _webDriverHandler.byXpath("//button[contains(text(),'Send')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        //Metadata
        btnEditMeta = _webDriverHandler.byXpath("//*[@id='btnGetMetadata']");
        btnSave = _webDriverHandler.byXpath("//*[contains(text(), 'Save')]");
        btnCancelMeta = _webDriverHandler.byXpath("//*[@id='editMetadataForm']//*[contains(text(), 'Cancel')]");
        //rows
        rowInvoiceNumber = _webDriverHandler.byXpath("//div[contains(text(),'Invoice Number')]//..");
        rowAccountNumber = _webDriverHandler.byXpath("//div[contains(text(),'Account Number')]//..");
        rowMPANMPRN = _webDriverHandler.byXpath("//div[contains(text(),'MPAN/MPRN')]//..");
        rowParentClient = _webDriverHandler.byXpath("//div[contains(text(),'Parent Client')]//..");
        rowClient = _webDriverHandler.byXpath("//div[contains(text(),'Client')]//..");
        rowSupplier = _webDriverHandler.byXpath("//div[contains(text(),'Supplier')]//..");
        rowUtilityType = _webDriverHandler.byXpath("//div[contains(text(),'Utility Type')]//..");
        rowDueDate = _webDriverHandler.byXpath("//div[contains(text(),'Due Date')]//..");
        //read only values
        tbInvoiceNumber = _webDriverHandler.byXpath("//*[@name='InvoiceNumber']");
        tbAccountNumber = _webDriverHandler.byXpath("//*[@name='AccountNumber']");
        tbMeterNumber = _webDriverHandler.byXpath("//*[@name='MeterNumber']");
        tbParentClient = _webDriverHandler.byXpath("//*[@name='ParentClient']");
        tbClient = _webDriverHandler.byXpath("//*[@name='Client']");
        tbSupplier = _webDriverHandler.byXpath("//*[@name='Supplier']");
        tbUtilityType = _webDriverHandler.byXpath("//*[@name='UtilityType']");
        tbDueDate = _webDriverHandler.byXpath("//*[@id='DueDate']");
        //edit values
        ddDocumentType = _webDriverHandler.byXpath("//*[@id='modalDocumentTypeID']");
        tbEditInvoiceNumber = _webDriverHandler.byXpath("//*[@id='modalInvoiceNumber']");
        tbEditAccountNumber = _webDriverHandler.byXpath("//*[@id='modalAccountNumber']");
        tbEditMPANMPRN = _webDriverHandler.byXpath("//*[@id='modalMeterNumber']");
        ddEditParent = _webDriverHandler.byXpath("//*[@id='ParentClientId']");
        ddEditClient = _webDriverHandler.byXpath("//*[@id='ClientId']");
        ddEditSupplier = _webDriverHandler.byXpath("//*[@id='SupplierId']");
        ddEditUtilityType = _webDriverHandler.byXpath("//*[@id='modalUtilityID']");
    }

    public String[] tblAwaitingEDI = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Due Date", "Status", "Assigned", ""};
    public String[] arrAwaitingEDI = new String[9];

    String strErrorGeneric = "Message cannot be blank";
    String strErrorTo = "To cannot be blank";
    String strErrorSubject = "Subject cannot be blank";

    /**
     * Used to select Awaiting EDI Tab under Postroom Management.
     */
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

    /**
     * This method verifies the column header for the table present on the awaiting  EDI page in a sequential order and matches the column names with the data array {@link AwaitingEDI#tblAwaitingEDI}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrAwaitingEDI.length; i++) {
            arrAwaitingEDI[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblAwaitingEDI[i].equals(arrAwaitingEDI[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
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
				/*
				 * case "Parent": btnDdParentCustomers.waitClickable().click(); for (String t :
				 * text) { _webDriverHandler.
				 * byXpath("//span[select[@id='ParentCustomerId']]//label[contains(text(), ' " +
				 * t + "')]").click(); waitLoad(); }
				
                break; 
                */
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
     * Used to verify the functionality of Bulk actions:
     * <ul>
     *     <li>Bulk Assign</li>
     *     <li>Bulk Retry Match</li>
     * </ul>
     * <p>
     * Note: Need to filter out all required entries, because selectAll is used.
     *
     * @param action Give the action value required for the test.
     * @param user   User on whom you want to assign the selected entries. Provide this parameter only if Bulk Assign is being tested, or pass a blank String "".
     */
    public void setBulkAction(String action, String user) {
        // Use filter function to filter out all required entries.
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText(action);
        if (action.equals("Bulk Assign")) {
            ddUsers.waitClickable().selectByText(user);
        }
        btnProcess.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to verify the functionality of Bulk actions:
     * <ul>
     *     <li>Bulk Assign</li>
     *     <li>Bulk Retry Match</li>
     * </ul>
     *
     * @param action   Give the action value required for the test.
     * @param bulkData A String Vararg, of which the first value will be used to search for a term, the second value should be id for selecting the entry. Do not provide more than 2 values.
     */
    public void setBulkAction(String action, String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText(action);
        if (action.equals("Bulk Assign")) {
            ddUsers.waitClickable().selectByText(bulkData[2]);
        }
        btnProcess.waitClickable().click();
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
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed()
                && btnDownloadScanned.isDisplayed() && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed()
        ) {
            System.out.println("Awaiting EDI edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to verify the functionality of the following action dropdowns once we are on the edit page of an entry:
     * <ul>
     *     <li>Mark As Chased</li>
     *     <li>Retry Match</li>
     *     <li>Move to Manual Entry</li>
     * </ul>
     *
     * @param action Specify the action that you want to test from the actions dropdown.
     * @param message Provide the comment message needed as input for the mark as chased action. This parameter is not required for Retry Match and Move to Manual Entry
     *                actions and can be passed as "" (blank string) in those cases.
     */
    public void setAction(String action, String message) {
        switch (action) {
            case "Mark As Chased":
                ddAction.waitClickable().selectByText("Mark As Chased");
                waitLoad();
                tbChaseMessageMAC.waitClickable().sendKeys(message);
                btnSubmit.waitClickable().click();
                waitLoad();
                break;
            case "Retry Match":
                ddAction.waitClickable().selectByText("Retry Match");
                btnOk.waitClickable().click();
                break;
            case "Move to Manual Entry":
                ddAction.waitClickable().selectByText("Move to Manual Entry");
                btnOk.waitClickable().click();
                break;
            default:
                System.out.println("Please provide valid Action.");
        }
    }

    /**
     * Used to verify the functionality of Send Chase Email action dropdown once we are on the edit page of an entry.
     * @param data A String Vararg, should be of the format: data = {To, CC, Subject, Message}
     */
    public void setAction(String... data) {
        ddAction.waitClickable().selectByText("Send Chase Email");
        waitLoad();
        tbEmailTo.waitClickable().clear().sendKeys(data[0]);
        tbEmailCC.waitClickable().clear().sendKeys(data[1]);
        tbSubject.waitClickable().clear().sendKeys(data[2]);
        tbEmailMessageSCE.waitClickable().clear().sendKeys(data[3]);
        btnSend.waitClickable().click();
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
     * Change the assignment of the current document to a new assignee.
     * @param user Provide the name of the user you want this document to be assigned to.
     */
    public void changeAssignment(String user) {
        if (user.equals("Me")) {
            linkAssignToMe.waitClickable().click();
        } else {
            ddAssignment.waitClickable().selectByText(user);
        }
        try {
            waitLoad();
        } catch (Exception e) {
        }
    }

    /**
     * Used to verify the chase history for comments under chase history. Verifies all the fields and button are available or not and hence the proper loading of the modal.
     * <p>
     * Note: Cannot be used individually, needs to be used after {@link AwaitingEDI#checkChaseHistory(String)}
     */
    public void verifyChaseHistoryComment() {
        if (tbMessageCCH.isDisplayed() && tbMessageCCH.getAttribute("readonly").equalsIgnoreCase("true")) {
            System.out.println("Chase history modal is loaded properly.");
        } else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancelHistory.waitClickable().click();
    }

    /**
     * Used to verify the chase history for emails under chase history. Verifies all the fields and button are available or not and hence the proper loading of the modal.
     * <p>
     * Note: Cannot be used individually, needs to be used after {@link AwaitingEDI#checkChaseHistory(String)}
     */
    public void verifyChaseHistoryEmail() {
        if (tbEmailTo.isDisplayed() && tbEmailTo.getAttribute("readonly").equalsIgnoreCase("true") && tbEmailCC.isDisplayed() && tbEmailCC.getAttribute("readonly").equalsIgnoreCase("true") && tbMessageCCH.isDisplayed() &&
                tbMessageCCH.getAttribute("readonly").equalsIgnoreCase("true") && tbSubject.isDisplayed() && btnCancelHistory.isDisplayed()) {
            System.out.println("Chase history modal is loaded properly.");
        } else {
            Assert.fail("Chase History modal is not proper.");
        }
        btnCancelHistory.waitClickable().click();
    }

    /**
     * Used to select any entry from the Chase History section so that we can verify the chase history for comments or emails.
     * @param date Date when the chase history entry was created.
     * @param user User who created the particular entry.
     * @param type Is the entry we want to select is email or comment.
     *<p>
     *<p>
     *Note: We can use this method to select a particular entry from the chase history section.
     */
    public void checkChaseHistory(String date, String user, String type) {
        do {
            _webDriverHandler.byXpath("//div[div[contains(text(), '" + date + "')]][div[contains(text(), '" + user + "')]][div[contains(text(), '" + type + "')]]//button").sendKeys(Keys.ARROW_DOWN);
        }
        while (_webDriverHandler.byXpath("//div[div[contains(text(), '" + date + "')]][div[contains(text(), '" + user + "')]][div[contains(text(), '" + type + "')]]//button").notPresent());
        do {
            _webDriverHandler.byXpath("//div[div[contains(text(), '" + date + "')]][div[contains(text(), '" + user + "')]][div[contains(text(), '" + type + "')]]//button").waitClickable().click();
        }
        while (!_webDriverHandler.byXpath("//*[@id='overlay']").isDisplayed());
        waitLoad();
        if (type.equalsIgnoreCase("Comment")) {
            verifyChaseHistoryComment();
        } else {
            verifyChaseHistoryEmail();
        }
    }

    /**
     * Used to select the first entry of any type from the Chase History section so that we can verify the chase history for it.
     * @param type Provide the type of entry we want to verify. The first entry of that type would be selected.
     */
    public void checkChaseHistory(String type) {
        do {
            _webDriverHandler.byXpath("(//div[div[contains(text(), '" + type + "')]])[1]//button").sendKeys(Keys.ARROW_DOWN);
        }
        while (_webDriverHandler.byXpath("(//div[div[contains(text(), '" + type + "')]])[1]//button").notPresent());
        do {
            _webDriverHandler.byXpath("(//div[div[contains(text(), '" + type + "')]])[1]//button").waitClickable().click();
        }
        while (!_webDriverHandler.byXpath("//*[@id='overlay']").isDisplayed());
        waitLoad();
        if (type.equalsIgnoreCase("Comment")) {
            verifyChaseHistoryComment();
        } else {
            verifyChaseHistoryEmail();
        }
    }

    /**
     * Used to add a comment in the comment section, verifying the comment sections.
     * @param comment The text we want to put as comment.
     */
    public void addComment(String comment) {
        do {
            btnAddComment.sendKeys(Keys.ARROW_DOWN);
        }
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to generate the error messages on the page and verifying them against the know data.
     */
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
        do {
            btnAddComment.sendKeys(Keys.ARROW_DOWN);
        }
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorGeneric);
        btnCancelComment.waitClickable().click();
    }

    /**
     * Used to verify the presence of all the available metadata fields and if they are read only or not.
     */
    public void verifyMetaData() {
        if (rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowMPANMPRN.isDisplayed() && tbMeterNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowParentClient.isDisplayed() && tbParentClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowUtilityType.isDisplayed() && tbUtilityType.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowDueDate.isDisplayed() && tbDueDate.getAttribute("readonly").equalsIgnoreCase("true")
        ) {
            System.out.println("Meta Data is available.");
        } else {
            Assert.fail("Meta Data not Loaded properly.");
        }
    }

    /**
     * Used to edit the metadata of the entry we are working with, verifying edit metadata.
     * @param metaData A String vararg that is providing data in the sequence of:
     *                 <ol>
     *                 <li>Document Type</li>
     *                 <li>Invoice Number</li>
     *                 <li>Account Number</li>
     *                 <li>Meter Number</li>
     *                 <li>Parent Client</li>
     *                 <li>Client</li>
     *                 <li>Supplier</li>
     *                 <li>Utility</li>
     *                 </ol>
     */
    public void editMetaData(String... metaData) {
        btnEditMeta.waitClickable().click();
        waitLoad();
        ddDocumentType.selectByText(metaData[0]);
        tbEditInvoiceNumber.clear().sendKeys(metaData[1]);
        tbEditAccountNumber.clear().sendKeys(metaData[2]);
        tbEditMPANMPRN.clear().sendKeys(metaData[3]);
        ddEditParent.waitClickable().selectByText(metaData[4]);
        ddEditClient.waitClickable().selectByText(metaData[5]);
        ddEditSupplier.waitClickable().selectByText(metaData[6]);
        ddEditUtilityType.waitClickable().selectByText(metaData[7]);
        //btnSave.waitClickable().click();
        btnCancelMeta.waitClickable().click();
    }

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}