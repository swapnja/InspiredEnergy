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

    public String[] tblManualInvoiceEntry = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Received Date", "Status", "Assigned", ""};
    public String[] arrManualInvoiceEntry = new String[9];

    String strErrorGeneric = "Message cannot be blank";

    /**
     * Used to select Manual Invoice Entry Tab under Postroom Management.
     */
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

    /**
     * This method verifies the column header for the table present on the manual invoice entry page in a sequential order and matches the
     column names with the data array {@link ManualInvoiceEntry#tblManualInvoiceEntry}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrManualInvoiceEntry.length; i++) {
            arrManualInvoiceEntry[i] = _webDriverHandler.byXpath("//table[contains (@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblManualInvoiceEntry[i].equals(arrManualInvoiceEntry[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
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
     * @param user   User on whom you want to assign the selected entries.
     */
    public void setBulkAction(String user) {
        // Use filter function to filter out all required entries.
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
            System.out.println("Manual Invoice Entry edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    /**
     * Used to download the scanned copy of the document available, verifying the functionality of the download button.
     */
    public void downloadScanned(){
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to verify the functionality of the following action dropdowns once we are on the edit page of an entry:
     * <ul>
     *     <li>Mark as Done</li>
     *     <li>Set In Progress</li>
     * </ul>
     *
     * @param action Specify the action that you want to test from the actions dropdown.
     */
    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        waitLoad();
        if(action.equals("Mark as Done")){
            btnOk.waitClickable().click();
        }
    }

    /**
     * Used to verify the functionality of the following action dropdowns once we are on the edit page of an entry:
     * <ul>
     *     <li>Send to Can't Input</li>
     *     <li>Refer to Data Analyst</li>
     * </ul>
     *
     * @param action Specify the action that you want to test from the actions dropdown.
     * @param message Comment the reason as to why we are using the action, verifies the text box field.
     */
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
        try{waitLoad();}
        catch (Exception e){}
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
     * Used to generate the error messages on the page and verifying them against the know data.
     */
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
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
