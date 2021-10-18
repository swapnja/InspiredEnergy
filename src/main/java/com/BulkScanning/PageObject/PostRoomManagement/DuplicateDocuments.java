package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class DuplicateDocuments {
    WebDriverHandler _webDriverHandler;
    ElementHandler tabDuplicateDocuments;
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
    ElementHandler ddNotNeeded;
    ElementHandler ddSetStatus;
    ElementHandler tbNNComment;
    ElementHandler btnNNSave;
    ElementHandler btnNNCancel;
    ElementHandler messageNNStatus;
    ElementHandler messageNNReason;
    ElementHandler messageNNComment;
    ElementHandler tbDIComment;
    ElementHandler btnDISubmit;
    ElementHandler btnDICancel;
    ElementHandler messageDIComment;
    ElementHandler btnCancel;
    ElementHandler ddAssignment;
    ElementHandler linkAssignToMe;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler cancelComment;
    ElementHandler btnDownloadScanned;
    ElementHandler btnDownloadMatched;
    ElementHandler tbStatus;
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

    ElementHandler btnYes;

    public DuplicateDocuments(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabDuplicateDocuments = _webDriverHandler.byXpath("//a[text() = 'Duplicate Documents']");
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
        ddNotNeeded = _webDriverHandler.byXpath("//*[@id='NotNeededReasonId']");
        ddSetStatus = _webDriverHandler.byXpath("//*[@id='Status']");
        tbNNComment = _webDriverHandler.byXpath("//*[@id='Comment']");
        btnNNSave = _webDriverHandler.byXpath("//*[@id='modalSendToNotNeeded']//button[contains(text(), 'Save')]");
        btnNNCancel = _webDriverHandler.byXpath("//*[@id='modalSendToNotNeeded']//button[contains(text(), 'Cancel')]");
        messageNNReason = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='NotNeededReasonId-error']");
        messageNNStatus = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='Status-error']");
        messageNNComment = _webDriverHandler.byXpath("//*[@id='sendToNotNeededForm']//*[@id='Comment-error']");
        tbDIComment = _webDriverHandler.byXpath("//*[@id='Message']");
        btnDISubmit = _webDriverHandler.byXpath("//*[@id='modalDuplicateInvestigationRequired']//button[contains(text(), 'Submit')]");
        btnDICancel = _webDriverHandler.byXpath("//*[@id='modalDuplicateInvestigationRequired']//button[contains(text(), 'Cancel')]");
        messageDIComment = _webDriverHandler.byXpath("//*[@id='duplicateInvestigationRequiredForm']//*[@id='Message-error']");
        btnCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel')]");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
        btnDownloadMatched = _webDriverHandler.byXpath("//h6[contains(text(), 'Matched Document')]//a//i");
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
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
    }

    public String[] tblDuplicateDocuments = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Received Date", "Status", "Assigned", ""};
    public String[] arrDuplicateDocuments = new String[9];

    String strErrorGeneric = "Message cannot be blank";
    String strErrorReason = "Please select Reason";
    String strErrorStatus = "Please select Status";
    String strErrorComment = "Please enter Comment";

    /**
     * Used to select Duplicate Documents Tab under Postroom Management.
     */
    public void accessDuplicateDocuments() {
        do {
            tabDuplicateDocuments.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    /**
     * This method verifies the column header for the table present on the duplicate documents page in a sequential order and matches the column names with the data array {@link DuplicateDocuments#tblDuplicateDocuments}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrDuplicateDocuments.length; i++) {
            arrDuplicateDocuments[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDuplicateDocuments[i].equals(arrDuplicateDocuments[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
    public void loadDuplicateDocuments() {
        if (btnDdCustomers.isDisplayed() && btnDdStatus.isDisplayed() && btnDdSuppliers.isDisplayed() && dateFrom.isDisplayed() &&
                btnDdAssigned.isDisplayed() && dateTo.isDisplayed() && search.isDisplayed() && btnApply.isDisplayed() && btnReset.isDisplayed() &&
                btnExportExcel.isDisplayed() && ddBulkAction.isDisplayed() && btnDdParentCustomers.isDisplayed()
        ) {
            System.out.println("Duplicate Document page has loaded properly.");
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
    public void exportExcel(String... selection) {
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
    public void filterDuplicateDocuments(String filterType, String... text) {
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
     * </ul>
     * <p>
     * Note: Need to filter out all required entries, because selectAll is used.
     *
     * @param user   User on whom you want to assign the selected entries.
     */
    public void setBulkAction(String user) {
        selectAll.waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(user);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to verify the functionality of Bulk actions:
     * <ul>
     *     <li>Bulk Assign</li>
     * </ul>
     *
     * @param bulkData A String Vararg, of which the first value will be used to search for a term, the second value should be id for selecting the entry. Do not provide more than 2 values.
     */
    public void setBulkAction(String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(bulkData[2]);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to select and edit a particular entry from the table. Verifying the search and edit functionality.
     *
     * @param schedule The filtering term we need to search for.
     * @param id The id of the entry we want to edit.
     */
    public void editSchedule(String schedule, String id ) {
        searchSchedules(schedule);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page after clicking on the edit button, in turn verifying if the page has loaded properly or not.
     */
    public void verifyEdit() {
        if (ddAssignment.isDisplayed() && tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed() && btnDownloadScanned.isDisplayed()
                && btnAddComment.isDisplayed() && btnEditMeta.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Duplicate Documents edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to verify the functionality of the following action dropdowns once we are on the edit page of an entry:
     * <ul>
     *     <li>Set In Progress</li>
     *     <li>Archive Scanned Document</li>
     *     <li>Send to Duplicate Investigation</li>
     * </ul>
     *
     * @param action Specify the action that you want to test from the actions dropdown.
     */
    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        if(action.equals("Set In Progress")){waitLoad();}
        if(action.equals("Archive Scanned Document")){btnYes.waitClickable().click();waitLoad();}
        if(action.equals("Send to Duplicate Investigation")){
            tbDIComment.waitClickable().sendKeys("Comment for Send to duplicate investigation.");
            //btnDISubmit.waitClickable().click();
            //waitLoad();
            btnDICancel.waitClickable().click();
        }
    }

    /**
     * Used to verify the action Send to Not Needed.
     * @param notNeeded Provide the (dropdown value) reason for moving to not needed.
     * @param setStatus The initial status for the entry under the not needed subsection.
     * @param comment Comment explaining why it is moved to not needed.
     */
    public void setAction(String notNeeded, String setStatus, String comment) {
        ddAction.waitClickable().selectByText("Send To Not Needed");
        ddNotNeeded.waitClickable().selectByText(notNeeded);
        ddSetStatus.waitClickable().selectByText(setStatus);
        tbNNComment.waitClickable().sendKeys(comment);
        //btnNNSave.waitClickable().click();
        btnNNCancel.waitClickable().click();
        //waitLoad();
    }

    /**
     * Used to download the scanned copy of the document available, verifying the functionality of the download button.
     */
    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
        btnDownloadMatched.waitClickable().click();
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
        waitLoad();
    }

    /**
     * Used to add a comment in the comment section, verifying the comment sections.
     * @param comment The text we want to put as comment.
     */
    public void addComment(String comment) {
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        tbCommentMessage.waitClickable().sendKeys(comment);
        btnAdd.waitClickable().click();
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
                rowUtilityType.isDisplayed() && tbUtilityType.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowDueDate.isDisplayed() && tbDueDate.getAttribute("readonly").equalsIgnoreCase("true")
        )
        {
            System.out.println("Meta Data is available.");
        }
        else {Assert.fail("Meta Data not Loaded properly.");}
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
     * Used to generate the error messages on the page and verifying them against the know data.
     */
    public void errorValidations() {
        ddAction.waitClickable().selectByText("Send to Duplicate Investigation");
        btnDISubmit.waitClickable().click();
        Assert.assertEquals(messageDIComment.getText(), strErrorGeneric);
        btnDICancel.waitClickable().click();
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

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
