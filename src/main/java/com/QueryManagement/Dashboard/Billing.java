package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;


public class Billing {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabBilling;
    ElementHandler subTabAOE;
    ElementHandler subTabBH;
    ElementHandler subTabBQA;
    ElementHandler subTabIR;
    ElementHandler subTabIRT;
    ElementHandler subTabIRE;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Billing(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabBilling = _webDriverHandler.byXpath("//a//span[contains(text(), 'Billing')]");
        subTabAOE = _webDriverHandler.byXpath("//a[contains(text(), 'Added Online/Ebill')]");
        subTabBH = _webDriverHandler.byXpath("//a[contains(text(), 'Bill too high')]");
        subTabBQA = _webDriverHandler.byXpath("//a[contains(text(), 'BQA Test')]");
        subTabIR = _webDriverHandler.byXpath("//a[contains(text(), 'Incorrect Rates')]");
        subTabIRT = _webDriverHandler.byXpath("//a[contains(text(), 'Incorrect Rates (SL Test)')]");
        subTabIRE = _webDriverHandler.byXpath("//a[contains(text(), 'Incorrect Readings')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Added Online/Ebill
    public String[] tblSubAOE = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View",};
    public  String[] arrSubAOE = new String[22];

    //Bill too High
    public String[] tblSubBH = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Text Area", "Text Enter"};
    public  String[] arrSubBH = new String[24];

    //BQA Test
    public String[] tblSubBQA = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public  String[] arrSubBQA = new String[22];

    //Incorrect Rates
    public String[] tblSubIR = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Text Area"};
    public  String[] arrSubIR = new String[23];

    //Incorrect Rates (SL Test)
    public String[] tblSubIRT = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public  String[] arrSubIRT = new String[22];

    //Incorrect Readings
    public String[] tblSubIRE = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name",  "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Numeric Value"};
    public  String[] arrSubIRE = new String[23];

    public void accessCategory() {
        waitLoad();
            tabBilling.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
            if(cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                    subTabAOE.isDisplayed() && subTabBH.isDisplayed() && subTabBQA.isDisplayed() && subTabIR.isDisplayed() && subTabIRE.isDisplayed() && subTabIRT.isDisplayed()){
                System.out.println("The category is loaded properly.");
        }
        else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationAOE() {
        for(int i = 0 ; i < arrSubAOE.length ; i++) {
            arrSubAOE[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubAOE[i].equals(arrSubAOE[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationBH() {
        for(int i = 0 ; i < arrSubBH.length ; i++) {
            arrSubBH[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubBH[i].equals(arrSubBH[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationBQA() {
        for(int i = 0 ; i < arrSubBQA.length ; i++) {
            arrSubBQA[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubBQA[i].equals(arrSubBQA[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationIR() {
        for(int i = 0 ; i < arrSubIR.length ; i++) {
            arrSubIR[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubIR[i].equals(arrSubIR[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationIRT() {
        for(int i = 0 ; i < arrSubIRT.length ; i++) {
            arrSubIRT[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubIRT[i].equals(arrSubIRT[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationIRE() {
        for(int i = 0 ; i < arrSubAOE.length ; i++) {
            arrSubAOE[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubAOE[i].equals(arrSubAOE[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "AOE":
                subTabAOE.waitClickable().click();
                waitLoad();
                columnVerificationAOE();
                break;
            case "BH":
                subTabBH.waitClickable().click();
                waitLoad();
                columnVerificationBH();
                break;
            case "BQA":
                subTabBQA.waitClickable().click();
                waitLoad();
                columnVerificationBQA();
                break;
            case "IR":
                subTabIR.waitClickable().click();
                waitLoad();
                columnVerificationIR();
                break;
            case "IRT":
                subTabIRT.waitClickable().click();
                waitLoad();
                columnVerificationIRT();
                break;
            case "IRE":
                subTabIRE.waitClickable().click();
                waitLoad();
                columnVerificationIRE();
                break;
            default:
                Assert.fail("Select proper sub-category.");
        }
    }

    public void waitExec() {
        cardTotalSavings.isDisplayed(); cardForecastSavings.isDisplayed(); cardTasksOpen.isDisplayed(); cardTasksClosed.isDisplayed();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();;
    }
}
