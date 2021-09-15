package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Meter {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabMeter;
    ElementHandler subTabME;
    ElementHandler subTabMR;
    ElementHandler subTabMRE;
    ElementHandler subTabNMA;
    ElementHandler subTabZU;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Meter(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabMeter = _webDriverHandler.byXpath("//a//span[contains(text(), 'Meter')]");
        subTabME = _webDriverHandler.byXpath("//a[contains(text(), 'Meter Exchange')]");
        subTabMR = _webDriverHandler.byXpath("//a[contains(text(), 'Meter Reading')]");
        subTabMRE = _webDriverHandler.byXpath("//a[contains(text(), 'Meter Removal')]");
        subTabNMA = _webDriverHandler.byXpath("//a[contains(text(), 'New Meter Added')]");
        subTabZU = _webDriverHandler.byXpath("//a[contains(text(), 'Zero usage')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Meter Exchange
    public String[] tblSubME = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Select Multiselect List"};
    public String[] arrSubME = new String[23];

    //Meter Reading
    public String[] tblSubMR = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public String[] arrSubMR = new String[22];

    //Meter Removal
    public String[] tblSubMRE = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date"};
    public String[] arrSubMRE = new String[23];

    //New Meter Added
    public String[] tblSubNMA = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date"};
    public String[] arrSubNMA = new String[23];

    //Zero Usage
    public String[] tblSubZU = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public String[] arrSubZU = new String[22];

    public void accessCategory() {
        waitLoad();
        tabMeter.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabME.isDisplayed() && subTabMR.isDisplayed() && subTabMRE.isDisplayed() && subTabNMA.isDisplayed() && subTabZU.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationME() {
        for (int i = 0; i < arrSubME.length; i++) {
            arrSubME[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubME[i].equals(arrSubME[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationMR() {
        for (int i = 0; i < arrSubMR.length; i++) {
            arrSubMR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubMR[i].equals(arrSubMR[i]))) {
                Assert.fail("\nColumn naMRs do not match.");
            }
        }
        System.out.println("\nColumn naMRs match.");
    }

    public void columnVerificationMRE() {
        for (int i = 0; i < arrSubMRE.length; i++) {
            arrSubMRE[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubMRE[i].equals(arrSubMRE[i]))) {
                Assert.fail("\nColumn naMREs do not match.");
            }
        }
        System.out.println("\nColumn naMREs match.");
    }

    public void columnVerificationNMA() {
        for (int i = 0; i < arrSubNMA.length; i++) {
            arrSubNMA[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubNMA[i].equals(arrSubNMA[i]))) {
                Assert.fail("\nColumn naNMAs do not match.");
            }
        }
        System.out.println("\nColumn naNMAs match.");
    }

    public void columnVerificationZU() {
        for (int i = 0; i < arrSubZU.length; i++) {
            arrSubZU[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubZU[i].equals(arrSubZU[i]))) {
                Assert.fail("\nColumn naZUs do not match.");
            }
        }
        System.out.println("\nColumn naZUs match.");
    }

    public void verifySubCategory(String subCat) {
        tabMeter.waitClickable().click();
        switch (subCat) {
            case "ME":
                subTabME.waitClickable().click();
                waitLoad();
                columnVerificationME();
                break;
            case "MR":
                subTabMR.waitClickable().click();
                waitLoad();
                columnVerificationMR();
                break;
            case "MRE":
                subTabMRE.waitClickable().click();
                waitLoad();
                columnVerificationMRE();
                break;
            case "NMA":
                subTabNMA.waitClickable().click();
                waitLoad();
                columnVerificationNMA();
                break;
            case "ZU":
                subTabZU.waitClickable().click();
                waitLoad();
                columnVerificationZU();
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
