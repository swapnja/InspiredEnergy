package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;


public class PortfolioAdmin {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabPortfolioAdmin;
    ElementHandler subTabLOA;
    ElementHandler subTabNS;
    ElementHandler subTabVATD;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public PortfolioAdmin(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabPortfolioAdmin = _webDriverHandler.byXpath("//a//span[contains(text(), 'Portfolio Admin')]");
        subTabLOA = _webDriverHandler.byXpath("//a[contains(text(), 'LOA')]");
        subTabNS = _webDriverHandler.byXpath("//a[contains(text(), 'New Sites')]");
        subTabVATD = _webDriverHandler.byXpath("//a[contains(text(), 'VAT Declaration')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //LOA
    public String[] tblSubLOA = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Text Enter"};
    public  String[] arrSubLOA = new String[23];

    //New Sites
    public String[] tblSubNS = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Enter Date Time"};
    public  String[] arrSubNS = new String[23];

    //VAT Declaration
    public String[] tblSubVATD = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public  String[] arrSubVATD = new String[22];

    public void accessCategory() {
        waitLoad();
        tabPortfolioAdmin.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if(cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                subTabLOA.isDisplayed() && subTabNS.isDisplayed() && subTabVATD.isDisplayed()){
            System.out.println("The category is loaded properly.");
        }
        else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationLOA() {
        for(int i = 0 ; i < arrSubLOA.length ; i++) {
            arrSubLOA[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubLOA[i].equals(arrSubLOA[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationNS() {
        for(int i = 0 ; i < arrSubNS.length ; i++) {
            arrSubNS[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubNS[i].equals(arrSubNS[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationVATD() {
        for(int i = 0 ; i < arrSubVATD.length ; i++) {
            arrSubVATD[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubVATD[i].equals(arrSubVATD[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }
    
    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "LOA":
                subTabLOA.waitClickable().click();
                waitLoad();
                columnVerificationLOA();
                break;
            case "NS":
                subTabNS.waitClickable().click();
                waitLoad();
                columnVerificationNS();
                break;
            case "VATD":
                subTabVATD.waitClickable().click();
                waitLoad();
                columnVerificationVATD();
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
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();;
    }

}
