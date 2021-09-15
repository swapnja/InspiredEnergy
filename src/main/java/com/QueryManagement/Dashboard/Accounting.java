package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Accounting {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabAccounting;
    ElementHandler subTabADR;
    ElementHandler subTabAQ;
    ElementHandler subTabDO;
    ElementHandler subTabPR;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Accounting(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabAccounting = _webDriverHandler.byXpath("//a//span[contains(text(), 'Accounting')]");
        subTabADR = _webDriverHandler.byXpath("//a[contains(text(), 'Account Details Required')]");
        subTabAQ = _webDriverHandler.byXpath("//a[contains(text(), 'Account Query')]");
        subTabDO = _webDriverHandler.byXpath("//a[contains(text(), 'Debt Outstanding')]");
        subTabPR = _webDriverHandler.byXpath("//a[contains(text(), 'Payment Required')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Account Details Required
    public String[] tblSubADR = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings",  "Customer View", "Supplier View", "Enter Date Time", "Enter Text Area", "Enter Date", "Meter Reading 1"};
    public String[] arrSubADR = new String[26];

    //Account Query
    public String[] tblSubAQ = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date", "Enter Date Time", "Enter Text Area", "Select Multiselect List"};
    public String[] arrSubAQ = new String[26];

    //Debt Outstanding
    public String[] tblSubDO = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter List", "Date", "Enter Date", "Meter Reading 1", "Visit Details", "Meter Reading 2"};
    public String[] arrSubDO = new String[28];

    //Payment Reminder
    public String[] tblSubPR = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter GBP"};
    public String[] arrSubPR = new String[23];

    public void accessCategory() {
        waitLoad();
        tabAccounting.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabADR.isDisplayed() && subTabAQ.isDisplayed() && subTabDO.isDisplayed() && subTabPR.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationADR() {
        for (int i = 0; i < arrSubADR.length; i++) {
            arrSubADR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubADR[i].equals(arrSubADR[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationAQ() {
        for (int i = 0; i < arrSubAQ.length; i++) {
            arrSubAQ[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubAQ[i].equals(arrSubAQ[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationDO() {
        for (int i = 0; i < arrSubDO.length; i++) {
            arrSubDO[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubDO[i].equals(arrSubDO[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationPR() {
        for (int i = 0; i < arrSubPR.length; i++) {
            arrSubPR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubPR[i].equals(arrSubPR[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "ADR":
                subTabADR.waitClickable().click();
                waitLoad();
                columnVerificationADR();
                break;
            case "AQ":
                subTabAQ.waitClickable().click();
                waitLoad();
                columnVerificationAQ();
                break;
            case "DO":
                subTabDO.waitClickable().click();
                waitLoad();
                columnVerificationDO();
                break;
            case "PR":
                subTabPR.waitClickable().click();
                waitLoad();
                columnVerificationPR();
                break;
            default:
                Assert.fail("Select proper sub-category.");
        }
    }

    public void waitExec() {
        cardTotalSavings.isDisplayed(); cardForecastSavings.isDisplayed(); cardTasksOpen.isDisplayed(); cardTasksClosed.isDisplayed();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
