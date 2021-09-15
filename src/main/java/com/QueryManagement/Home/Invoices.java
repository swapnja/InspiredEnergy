package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Invoices {

    WebDriverHandler _webDriverHandler;
    ElementHandler tbFilterID;
    ElementHandler tbFilterUtility;
    ElementHandler tbFilterSubcategory;
    ElementHandler tbFilterNextAction;
    ElementHandler tbFilterDueDate;
    ElementHandler tbFilterStatus;
    ElementHandler tbFilterCWO;
    ElementHandler tbFilterOwner;
    ElementHandler btnEditEntry;
    ElementHandler headerQueryLinks;
    ElementHandler tabInvoices;

    ElementHandler btnInvoices;
    ElementHandler ddBatchId;
    ElementHandler ddSupplier;
    ElementHandler ddUtility;
    ElementHandler ddStatus;
    ElementHandler btnBatchId;
    ElementHandler btnSupplier;
    ElementHandler btnUtility;
    ElementHandler btnStatus;
    ElementHandler tbDateFrom;
    ElementHandler tbDateTo;
    ElementHandler btnApplyFilters;
    ElementHandler tbSearch;
    ElementHandler btnConfirm;
    ElementHandler btnCancel;
    ElementHandler btnYes;
    ElementHandler btnOK;

    public Invoices(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        tbFilterUtility = _webDriverHandler.byXpath("//*[@id = 'filterUtility']");
        tbFilterSubcategory = _webDriverHandler.byXpath("//*[@id = 'filterSubCategory']");
        tbFilterNextAction = _webDriverHandler.byXpath("//*[@id = 'filterNext']");
        tbFilterDueDate = _webDriverHandler.byXpath("//*[@id = filterDue");
        tbFilterStatus = _webDriverHandler.byXpath("//*[@id = 'filterStatus']");
        tbFilterCWO = _webDriverHandler.byXpath("//*[@id = 'filterCurrently']");
        tbFilterOwner = _webDriverHandler.byXpath("//*[@id = 'filterOwner']");
        btnEditEntry = _webDriverHandler.byXpath("//button[@title='Edit']");
        headerQueryLinks =  _webDriverHandler.byXpath("//*[@id = 'partialViewContent']/div/div/h4[contains(text(), 'Query Links')]");
        tabInvoices = _webDriverHandler.byXpath("//a[@href = '#InvoicesDiv']");

        btnInvoices = _webDriverHandler.byXpath("//*[@onclick = 'ShowInvoiceForm()']");
        ddBatchId = _webDriverHandler.byXpath("//*[@id = 'BatchIds']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id = 'SupplierIds']");
        ddUtility = _webDriverHandler.byXpath("//*[@id = 'UtilityTypes']");
        ddStatus = _webDriverHandler.byXpath("//*[@id = 'StatusList']");
        btnBatchId = _webDriverHandler.byXpath("//*[@id = 'BatchIds']//../div/button");
        btnSupplier = _webDriverHandler.byXpath("//*[@id = 'SupplierIds']//../div/button");
        btnUtility = _webDriverHandler.byXpath("//*[@id = 'UtilityTypes']//../div/button");
        btnStatus = _webDriverHandler.byXpath("//*[@id = 'StatusList']//../div/button");
        tbDateFrom = _webDriverHandler.byXpath("//*[@id = 'StartDate']");
        tbDateTo = _webDriverHandler.byXpath("//*[@id = 'EndDate']");
        btnApplyFilters = _webDriverHandler.byXpath("//button[@onclick = 'bindInvoiceLinksTable()']");
        tbSearch = _webDriverHandler.byXpath("//input[@type = 'search']");
        btnConfirm = _webDriverHandler.byXpath("//form[@id = 'queryLinkForm']//button[contains(text(), 'Confirm')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'queryLinkForm']//button[contains(text(), 'Cancel')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(), 'Yes')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(), 'OK')]");
    }

    public String[] tblInvoices = new String[]{"Added date", "Added By", "Invoice Number", "Batch ID", "Start Date", "End Date", "Consumption", "VAT", "Net", "Gross", "Link Status", "Actions"};
    public String[] arrInvoices = new String[12];

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
        waitLoad();
    }

    public void filter(String type, String data) {
        switch (type){
            case "Id" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "Utility" :
                tbFilterUtility.waitClickable().clear().sendKeys(data);
            case "Sub Category" :
                tbFilterSubcategory.waitClickable().clear().sendKeys(data);
            case "Next Action" :
                tbFilterNextAction.waitClickable().clear().sendKeys(data);
            case "Due Date" :
                tbFilterDueDate.waitClickable().clear().sendKeys(data);
            case "Status" :
                tbFilterStatus.waitClickable().clear().sendKeys(data);
            case "CWO" :
                tbFilterCWO.waitClickable().clear().sendKeys(data);
            case "Owner" :
                tbFilterOwner.waitClickable().clear().sendKeys(data);
        }
    }

    public void clearFilter() {
        tbFilterID.waitClickable().clear();
        tbFilterID.waitClickable().clear();
        tbFilterUtility.waitClickable().clear();
        tbFilterSubcategory.waitClickable().clear();
        tbFilterNextAction.waitClickable().clear();
        tbFilterDueDate.waitClickable().clear();
        tbFilterStatus.waitClickable().clear();
        tbFilterCWO.waitClickable().clear();
        tbFilterOwner.waitClickable().clear();
    }

    public void selectEntry(int id) {
        tbFilterID.waitClickable().clear().sendKeys(""+id);
        waitLoad();
        btnEditEntry.waitClickable().click();
        waitLoad();
    }

    public void scrollToInvoices() {
        headerQueryLinks.scrollDown();
        tabInvoices.waitClickable().click();
        waitLoad();
    }

    public void accessAddInvoices() {
        btnInvoices.waitClickable().click();
        waitLoad();
    }

    public void columnVerification() {
        for (int i = 0; i < arrInvoices.length; i++) {
            arrInvoices[i] = _webDriverHandler.byXpath("//table[@id='InvoiceTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblInvoices[i].equals(arrInvoices[i]))) {
                System.out.println(tblInvoices[i]);
                System.out.println(arrInvoices[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void invoiceFilters(String type, String... data) {
        switch (type) {
            case "BatchID":
                for (String text : data) {
                    ddBatchId.waitClickable().selectByText(text);
                }
                btnBatchId.waitClickable().click();
                btnBatchId.waitClickable().click();
                break;
            case "Supplier":
                for (String text : data) {
                    ddSupplier.waitClickable().selectByText(text);
                }
                btnSupplier.waitClickable().click();
                btnSupplier.waitClickable().click();
                break;
            case "Utility":
                for (String text : data) {
                    ddUtility.waitClickable().selectByText(text);
                }
                btnUtility.waitClickable().click();
                btnUtility.waitClickable().click();
                break;
            case "Status":
                for (String text : data) {
                    ddStatus.waitClickable().selectByText(text);
                }
                btnStatus.waitClickable().click();
                btnStatus.waitClickable().click();
                break;
        }
        btnApplyFilters.waitClickable().click();
        waitLoad();
    }

    public void dateFilters(String from, String to) {
        tbDateFrom.waitClickable().clear().sendKeys(from);
        tbDateTo.waitClickable().clear().sendKeys(to);
        btnApplyFilters.waitClickable().click();
        waitLoad();
    }

    public void invoiceFiltersReset() {
        ddBatchId.waitClickable().deselectAll();
        ddSupplier.waitClickable().deselectAll();
        ddUtility.waitClickable().deselectAll();
        ddStatus.waitClickable().deselectAll();
        tbDateFrom.waitClickable().clear();
        tbDateTo.waitClickable().clear();
        btnApplyFilters.waitClickable().click();
    }

    public void invoiceSearch(String invoiceID) {
        tbSearch.waitClickable().clear().sendKeys(invoiceID);
        waitLoad();
    }

    public void addInvoice(String invoiceID) {
        invoiceSearch(invoiceID);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '"+ invoiceID +"')]]//input").waitClickable().click();
        btnConfirm.waitClickable().click();
        btnOK.waitClickable().click();
        waitLoad();
    }

    public void verifySelection(String invoiceID) {
        btnInvoices.waitClickable().click();
        addInvoice(invoiceID);
        btnInvoices.waitClickable().click();
        invoiceSearch(invoiceID);
        Assert.assertTrue(_webDriverHandler.byXpath("//tr[td[contains(text(), '"+ invoiceID +"')]]//input").notPresent(), "Already selected entries are not shown.");
    }

    public void actionInvoice(String actionType, String invoiceID) {
        if (actionType.equalsIgnoreCase("Delete")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + invoiceID + "')]]//button[@title = '']").waitClickable().click();
        } else if (actionType.equalsIgnoreCase("Completed")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + invoiceID + "')]]//button[@title = 'Mark Completed']").waitClickable().click();
        }
        else{
            Assert.fail("No proper action was provided.");
        }
        btnYes.waitClickable().click();
        waitLoad();
    }

    public void errorValidation() {
        btnInvoices.waitClickable().click();
        waitLoad();
        btnConfirm.waitClickable().click();
        String errorMsg = _webDriverHandler.byXpath("//*[@id='swal2-content']").waitClickable().getText();
        Assert.assertEquals("Please select invoices to link.", errorMsg);
        btnOK.waitClickable().click();
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15, 100).waitInvisible(15, 100);
    }
}