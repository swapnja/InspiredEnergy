package com.BulkScanning.PageObject.EmailProcessing;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
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
        btnEditByPage = _webDriverHandler.byXpath("//button[contains(@class, 'edit-by-page')]");
        btnEditByRange = _webDriverHandler.byXpath("//button[contains(@class, 'edit-by-range')]");
        btnCreateOutput = _webDriverHandler.byXpath("//button[contains(@class, 'createOutput')]");
        tbReturnMessage = _webDriverHandler.byXpath("//*[@id='modalEmailProcessing-returnToSender']//*[@id='Message']");
        btnReturnSender = _webDriverHandler.byXpath("//button[contains(@class, 'return-to-sender')]");
        btnReturnCancel = _webDriverHandler.byXpath("//button[contains(@class, 'btn-danger')]");
    }

    public String[] tblEmailProcessing = new String[]{"", "", "Id", "From", "Subject", "Attachments", "Received Date", "Status", "Assigned", ""};
    public String[] arrEmailProcessing = new String[10];

    String strErrorGeneric = "Message cannot be blank";

    /**
     * Used to select Email Processing Tab under Email Processing.
     */
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

    /**
     * This method verifies the column header for the table present on the email processing page in a sequential order and matches the
     column names with the data array {@link EmailProcessing#tblEmailProcessing}.
     */
    public void columnVerification() {
        for (int i = 0; i < arrEmailProcessing.length; i++) {
            arrEmailProcessing[i] = _webDriverHandler.byXpath("//table[contains(@id, 'DataTables_Table')]/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblEmailProcessing[i].equals(arrEmailProcessing[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    /**
     * Verifies the presence of all the essential fields and buttons for the page, in turn verifying if the page has loaded properly or not.
     */
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
    public void setBulkAssignee(String user) {
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
     * @param bulkData A String Vararg, of which the first value will be used to search for a term, the second value should be id for selecting the entry. Do not provide more than 2 values.
     */
    public void setBulkAssignee(String... bulkData) {
        searchSchedules(bulkData[0]);
        _webDriverHandler.byXpath("//tr[@id='" + bulkData[1] + "']//td//input").waitClickable().click();
        ddBulkAction.waitClickable().selectByText("Bulk Assign");
        ddUsers.waitClickable().selectByText(bulkData[2]);
        btnProcess.waitClickable().click();
        waitLoad();
    }

    /**
     * Used to select and edit a particular entry from the table. Verifying the search and edit functionality.
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
        if (tbFrom.isDisplayed() && tbFrom.getAttribute("readonly").equalsIgnoreCase("true") && tbSubject.isDisplayed() && tbSubject.getAttribute("readonly")
                .equalsIgnoreCase("true") && tbMessage.isDisplayed() && tbMessage.getAttribute("readonly").equalsIgnoreCase("true") && tbStatus.isDisplayed()
                && tbStatus.getAttribute("readonly").equalsIgnoreCase("true")
        ) {
            System.out.println("Email Processing edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
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
        waitLoad();
    }

    /**
     * Select a file from the available file for the entry and click on the view button for it. Verifying the view document functionality.
     * @param fileName Exact name of the file you intend to view.
     */
    public void view(String fileName) {
        _webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").waitClickable().click();
        btnViewCancel.waitClickable().click();
    }

    /**
     * After clicking on the view button for a file, use this to verify the send functionality for the file.
     * @param fileName Exact name of the file you intend to view and send.
     */
    public void send(String fileName) {
        _webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").scrollDown().waitClickable().click();
        btnViewSend.waitClickable().click();
        Assert.assertFalse(_webDriverHandler.byXpath("//button[contains(@data-path, '" + fileName + "')]").isDisplayed(),
                "View button is not hidden.");
    }

    /**
     * Used to verify the functionality of the following action dropdowns once we are on the edit page of an entry:
     * <ul>
     *      <li>Edit By Page</li>
     *      <li>Edit By Range</li>
     * </ul>
     * @param action Specify the action that you want to test from the actions dropdown.
     */
    public void setAction(String action){
        ddAction.waitClickable().selectByText(action);
        if (action.equalsIgnoreCase("Edit By Page")) {
            Assert.assertTrue(btnEditByRange.isDisplayed(), "Edit Toggle button is not present.");
        }
        else if (action.equalsIgnoreCase("Edit By Range")) {
            Assert.assertTrue(btnEditByPage.isDisplayed(), "Edit Toggle button is not present.");
        }
        else if (action.equalsIgnoreCase("Mark as Done")) {
            //btnYes.waitClickable().click();
            btnDoneCancel.waitClickable().click();
        }
    }

    /**
     * Used to manipulate the pages within the Edit by modal, and verify the following actions:
     * <ul>
     *     <li>View - Click on the view icon for a page.</li>
     *     <li>Add - Click on the add icon for a page and add it to splits.</li>
     *     <li>Delete - Delete a certain page from the splits created.</li>
     *     <li>Page Up - Move a page up by one page in the splits.</li>
     *     <li>Page Down -  Move a page down by one page in the splits.</li>
     * </ul>
     * @param action To set the action we want to perform in the Edit By modal;
     * @param pageNo The page on which you want the action to be performed.
     */
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

    /**
     * To verify the actions that are present in the Edit by Modal.
     * <ul>
     *     <li>Select All - Selects all pages for split.</li>
     *     <li>Deselect All - Deselects all selected pages, and clears the splits.</li>
     *     <li>Postroom - Selects the option Send document to Postroom.</li>
     *     <li>Return - Selects the option Return To Sender.</li>
     * </ul>
     * @param action provide the action you want to test.
     * @param outputMode Provide the output mode while sending to postroom.
     * @param message Provide the message explaining why it is being returned to sender.
     */
    public void editByActions(String action, String outputMode, String message) {
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
        do{btnAddComment.sendKeys(Keys.ARROW_DOWN);}
        while (btnAddComment.notPresent());
        btnAddComment.waitClickable().click();
        btnAdd.waitClickable().click();
        Assert.assertEquals(messageComment.getText(), strErrorGeneric);
        btnCancelComment.waitClickable().click();
    }

    /**
     * A common waitload function used for handling the loaders throughout the project.
     */
    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
