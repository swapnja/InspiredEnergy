package com.BulkScanning.PageObject.PostRoomManagement;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class MatchedArchive {
    WebDriverHandler _webDriverHandler;
    ElementHandler tabMatchedArchive;
    ElementHandler btnApply;
    ElementHandler btnReset;
    ElementHandler btnExportExcel;
    ElementHandler search;
    ElementHandler btnDdParentCustomers;
    ElementHandler btnDdCustomers;
    ElementHandler btnDdSuppliers;
    ElementHandler ddUsers;
    ElementHandler btnProcess;
    ElementHandler selectAll;
    ElementHandler ddAction;
    ElementHandler btnCancel;
    ElementHandler ddAssignment;
    ElementHandler tbCurrentStatus;
    ElementHandler tbSystemDatabase;
    ElementHandler btnDownloadReport;
    ElementHandler btnAddComment;
    ElementHandler tbCommentMessage;
    ElementHandler btnAdd;
    ElementHandler messageComment;
    ElementHandler btnDownloadReportChase;
    ElementHandler cancelComment;
    ElementHandler tbStatus;
    ElementHandler btnDownloadScanned;
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

    public MatchedArchive(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabMatchedArchive = _webDriverHandler.byXpath("//a[text() = 'Matched Archive']");
        btnExportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
        btnDdParentCustomers = _webDriverHandler.byXpath("//span[select[@id = 'ParentCustomerId']]/div/button");
        btnDdCustomers = _webDriverHandler.byXpath("//span[select[@id = 'CustomerId']]/div/button");
        btnDdSuppliers = _webDriverHandler.byXpath("//span[select[@id = 'SupplierId']]/div/button");
        btnExportExcel = _webDriverHandler.byXpath("//button[contains(text(),'Export Excel')]");
        btnApply = _webDriverHandler.byXpath("//button[text()='Apply']");
        btnReset = _webDriverHandler.byXpath("//button[text()='Reset']");
        search = _webDriverHandler.byXpath("//input[@type='search']");
        ddUsers = _webDriverHandler.byXpath("//*[@id='ddlBulkAssignee']");
        btnProcess = _webDriverHandler.byXpath("//button[text()='Process']");
        selectAll = _webDriverHandler.byXpath("//input[@class = 'check-all']");
        ddAssignment = _webDriverHandler.byXpath("//*[@id='AssignedTo']");
        tbCurrentStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        tbSystemDatabase = _webDriverHandler.byXpath("//*[@id='SystemDatabaseName']");
        ddAction = _webDriverHandler.byXpath("//*[@id='Action']");
        btnAddComment = _webDriverHandler.byXpath("//button[contains(text(),'Add Comment')]");
        tbCommentMessage = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message']");
        messageComment = _webDriverHandler.byXpath("//*[@id='modalComment']//*[@id='Message-error']");
        btnAdd = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Add Comment')]");
        cancelComment = _webDriverHandler.byXpath("//*[@class='modal-content']//button[contains(text(),'Cancel')]");
        btnDownloadReport = _webDriverHandler.byXpath("//*[@id='emailForm']//i");
        btnDownloadReportChase = _webDriverHandler.byXpath("//*[@id='modalChase']//i");
        btnCancel = _webDriverHandler.byXpath("//button[contains(text(),'Cancel')]");
        tbStatus = _webDriverHandler.byXpath("//*[@id='CurrentStatus']");
        btnDownloadScanned = _webDriverHandler.byXpath("//h6[contains(text(), 'Scanned Document')]//a//i");
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
    }

    public String[] tblMatchedArchive = new String[]{"", "Id", "Parent Customer", "Customer", "Supplier", "Received Date", "Days to Match", "Matched Date", ""};
    public String[] arrMatchedArchive = new String[9];

    String strErrorGeneric = "Message cannot be blank";

    public void accessMatchedArchive() {
        do {
            tabMatchedArchive.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (search.notPresent());
    }

    public void columnVerification() {
        for (int i = 0; i < arrMatchedArchive.length; i++) {
            arrMatchedArchive[i] = _webDriverHandler.byXpath("//div[contains (@class, 'dataTables_scrollHeadInner')]//table/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblMatchedArchive[i].equals(arrMatchedArchive[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void loadMatchedArchive() {
        if (btnDdCustomers.isDisplayed() && btnDdSuppliers.isDisplayed() && btnDdParentCustomers.isDisplayed() && search.isDisplayed()
                && btnReset.isDisplayed() && btnApply.isDisplayed() && btnExportExcel.isDisplayed()
        ) {
            System.out.println("Matched Archive page has loaded properly.");
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

    public void filterMatchedArchive(String filterType, String... text) {
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
            default:
                Assert.fail("Proper Filter is not selected.");
        }
        btnApply.waitClickable().click();
        waitLoad();
    }

    public void filterReset() {
        btnReset.waitClickable().click();
        waitLoad();
    }

    public void editSchedule(String id) {
        searchSchedules(id);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + id + "')]]//button").click();
        waitLoad();
    }

    public void verifyEdit() {
        if (tbCurrentStatus.isDisplayed() && tbCurrentStatus.getAttribute("readonly").equals("true") && ddAction.isDisplayed()
                && btnDownloadScanned.isDisplayed() && tbSystemDatabase.isDisplayed() && tbSystemDatabase.getAttribute("readonly").equals("true")
        ) {
            System.out.println("Matched Archive edit page has loaded properly.");
        } else {
            Assert.fail("Page did not load properly.");
        }
    }

    public void setAction(String action) {
        ddAction.waitClickable().selectByText(action);
        waitLoad();
    }

<<<<<<< HEAD
=======
    public void downloadScanned() {
        btnDownloadScanned.waitClickable().click();
        waitLoad();
    }

>>>>>>> f994a02fbb38f9d0e1b587dbedd317a32c117924
    public void verifyMetaData() {
        if (rowInvoiceNumber.isDisplayed() && tbInvoiceNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowAccountNumber.isDisplayed() && tbAccountNumber.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowMPANMPRN.isDisplayed() && tbMPANMPRN.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowClient.isDisplayed() && tbClient.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowSupplier.isDisplayed() && tbSupplier.getAttribute("readonly").equalsIgnoreCase("true") &&
                rowUtilityType.isDisplayed() && ddUtilityType.getAttribute("readonly").equalsIgnoreCase("true") &&
                tbStatus.isDisplayed() && tbStatus.getAttribute("readonly").equalsIgnoreCase("true") && tbStatus.getAttribute("value").equals("Matched")
        ) {
            System.out.println("Meta Data is available.");
        } else {
            Assert.fail("Meta Data not Loaded properly.");
        }
    }


    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30, 100).waitInvisible(10, 100);
    }
}
