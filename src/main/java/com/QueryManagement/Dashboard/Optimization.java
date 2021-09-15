package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Optimization {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabOptimization;
    ElementHandler subTabPA;
    ElementHandler subTabPM;
    ElementHandler subTabPF;
    ElementHandler subTabSS;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Optimization(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabOptimization = _webDriverHandler.byXpath("//a//span[contains(text(), 'Optimization')]");
        subTabPA = _webDriverHandler.byXpath("//a[contains(text(), 'Performance Audit')]");
        subTabPM = _webDriverHandler.byXpath("//a[contains(text(), 'Performance Major')]");
        subTabPF = _webDriverHandler.byXpath("(//a[contains(text(), 'Power Factor')])[2]");
        subTabSS = _webDriverHandler.byXpath("//a[contains(text(), 'Site Survey')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Performance Audit
    public String[] tblSubPA = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public String[] arrSubPA = new String[22];

    //Performance Major
    public String[] tblSubPM = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Text Enter"};
    public String[] arrSubPM = new String[23];

    //Performance Factor
    public String[] tblSubPF = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public String[] arrSubPF = new String[22];

    //Site Survey
    public String[] tblSubSS = new String[]{"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Meter Reading 1", "Meter Reading 2"};
    public String[] arrSubSS = new String[24];

    public void accessCategory() {
        waitLoad();
        tabOptimization.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabPA.isDisplayed() && subTabPM.isDisplayed() && subTabPF.isDisplayed() && subTabSS.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationPA() {
        for (int i = 0; i < arrSubPA.length; i++) {
            arrSubPA[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubPA[i].equals(arrSubPA[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationPM() {
        for (int i = 0; i < arrSubPM.length; i++) {
            arrSubPM[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubPM[i].equals(arrSubPM[i]))) {
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

    public void columnVerificationSS() {
        for (int i = 0; i < arrSubSS.length; i++) {
            arrSubSS[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubSS[i].equals(arrSubSS[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "PA":
                subTabPA.waitClickable().click();
                waitLoad();
                columnVerificationPA();
                break;
            case "PM":
                subTabPM.waitClickable().click();
                waitLoad();
                columnVerificationPM();
                break;
            case "PF":
                subTabPF.waitClickable().click();
                waitLoad();
                columnVerificationPF();
                break;
            case "SS":
                subTabSS.waitClickable().click();
                waitLoad();
                columnVerificationSS();
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
