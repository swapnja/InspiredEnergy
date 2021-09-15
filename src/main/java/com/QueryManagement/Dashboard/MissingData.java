package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class MissingData {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabMissingData;
    ElementHandler subTabCI;
    ElementHandler subTabEN;
    ElementHandler subTabEC;
    ElementHandler subTabHHD;
    ElementHandler subTabMR;
    ElementHandler subTabMI;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public MissingData(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabMissingData = _webDriverHandler.byXpath("//a//span[contains(text(), 'Missing Data')]");
        subTabCI = _webDriverHandler.byXpath("//a[contains(text(), 'Contract issues')]");
        subTabEN = _webDriverHandler.byXpath("//a[contains(text(), 'Energy')]");
        subTabEC = _webDriverHandler.byXpath("//a[contains(text(), 'Excess Capacity')]");
        subTabHHD = _webDriverHandler.byXpath("//a[contains(text(), 'Half Hourly Data')]");
        subTabMR = _webDriverHandler.byXpath("(//a[contains(text(), 'Meter Reading')])[2]");
        subTabMI = _webDriverHandler.byXpath("//a[contains(text(), 'Missing Invoice')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Contract Issues
    public String[] tblSubCI = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date", "Date"};
    public String[] arrSubCI = new String[24];

    //Energy
    public String[] tblSubEN = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Date"};
    public String[] arrSubEN = new String[23];

    //Excess Capacity
    public String[] tblSubEC = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Select Multiselect List", "Enter Date", "Enter GBP", "Enter List"};
    public String[] arrSubEC = new String[26];

    //Half Hourly Data
    public String[] tblSubHHD = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Text Area", "Text Enter"};
    public String[] arrSubHHD = new String[24];

    //Meter Reading
    public String[] tblSubMR = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public String[] arrSubMR = new String[22];

    //Missing Invoice
    public String[] tblSubMI = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Text Enter"};
    public String[] arrSubMI = new String[23];

    public void accessCategory() {
        waitLoad();
        tabMissingData.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabCI.isDisplayed() && subTabEC.isDisplayed() && subTabHHD.isDisplayed() && subTabEN.isDisplayed() && subTabMI.isDisplayed() && subTabMR.isDisplayed()
        ) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationCI() {
        for (int i = 0; i < arrSubCI.length; i++) {
            arrSubCI[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCI[i].equals(arrSubCI[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }


    public void columnVerificationEN() {
        for (int i = 0; i < arrSubEN.length; i++) {
            arrSubEN[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubEN[i].equals(arrSubEN[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationEC() {
        for (int i = 0; i < arrSubEC.length; i++) {
            arrSubEC[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubEC[i].equals(arrSubEC[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationHHD() {
        for (int i = 0; i < arrSubHHD.length; i++) {
            arrSubHHD[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubHHD[i].equals(arrSubHHD[i]))) {
                System.out.println(tblSubHHD[i]);
                System.out.println(arrSubHHD[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationMR() {
        for (int i = 0; i < arrSubMR.length; i++) {
            arrSubMR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubMR[i].equals(arrSubMR[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationMI() {
        for (int i = 0; i < arrSubMI.length; i++) {
            arrSubMI[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubMI[i].equals(arrSubMI[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) { ;
        switch (subCat) {
            case "CI":
                subTabCI.waitClickable().click();
                waitLoad();
                columnVerificationCI();
                break;
            case "EN":
                subTabEN.waitClickable().click();
                waitLoad();
                columnVerificationEN();
                break;
            case "EC":
                subTabEC.waitClickable().click();
                waitLoad();
                columnVerificationEC();
                break;
            case "HHD":
                subTabHHD.waitClickable().click();
                waitLoad();
                columnVerificationHHD();
                break;
            case "MR":
                subTabMR.waitClickable().click();
                waitLoad();
                columnVerificationMR();
                break;
            case "MI":
                subTabMI.waitClickable().click();
                waitLoad();
                columnVerificationMI();
                break;
            default:
                Assert.fail("Select proper sub-category.");
        }
    }

    public void waitExec() {
        cardTotalSavings.isDisplayed();
        cardForecastSavings.isDisplayed();
        cardTasksOpen.isDisplayed();
        cardTasksClosed.isDisplayed();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
