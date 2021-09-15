package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Disconnections {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabDisconnections;
    ElementHandler subTabLR;
    ElementHandler subTabMC;
    ElementHandler subTabPF;
    ElementHandler subTabSV;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Disconnections(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabDisconnections = _webDriverHandler.byXpath("//a//span[contains(text(), 'Disconnections')]");
        subTabLR = _webDriverHandler.byXpath("//a[contains(text(), 'Letter Received')]");
        subTabMC = _webDriverHandler.byXpath("//a[contains(text(), 'Meter Closed')]");
        subTabPF = _webDriverHandler.byXpath("//a[contains(text(), 'Power Factor')]");
        subTabSV = _webDriverHandler.byXpath("//a[contains(text(), 'Site Visit')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Letter Received
    public String[] tblSubLR = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date"};
    public String[] arrSubLR = new String[23];

    //Meter Closed
    public String[] tblSubMC = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Fault Meter"};
    public String[] arrSubMC = new String[23];

    //Power Factor
    public String[] tblSubPF = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Select Multiselect List"};
    public String[] arrSubPF = new String[23];

    //Site Visit
    public String[] tblSubSV = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Text Area"};
    public String[] arrSubSV = new String[23];

    public void accessCategory() {
        waitLoad();
        tabDisconnections.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabLR.isDisplayed() && subTabPF.isDisplayed() && subTabMC.isDisplayed() && subTabSV.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationLR() {
        for (int i = 0; i < arrSubLR.length; i++) {
            arrSubLR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubLR[i].equals(arrSubLR[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationMC() {
        for (int i = 0; i < arrSubMC.length; i++) {
            arrSubMC[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubMC[i].equals(arrSubMC[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationPF() {
        for (int i = 0; i < arrSubPF.length; i++) {
            arrSubPF[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubPF[i].equals(arrSubPF[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationSV() {
        for (int i = 0; i < arrSubSV.length; i++) {
            arrSubSV[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubSV[i].equals(arrSubSV[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "LR":
                subTabLR.waitClickable().click();
                waitLoad();
                columnVerificationLR();
                break;
            case "MC":
                subTabMC.waitClickable().click();
                waitLoad();
                columnVerificationMC();
                break;
            case "PF":
                subTabPF.waitClickable().click();
                waitLoad();
                columnVerificationPF();
                break;
            case "SV":
                subTabSV.waitClickable().click();
                waitLoad();
                columnVerificationSV();
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