package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Visits {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabVisits;
    ElementHandler subTabLV;
    ElementHandler subTabMV;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Visits (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabVisits = _webDriverHandler.byXpath("//a//span[contains(text(), 'Visits')]");
        subTabLV = _webDriverHandler.byXpath("//a[contains(text(), 'Landlord Visit')]");
        subTabMV = _webDriverHandler.byXpath("//a[contains(text(), 'MOP Visit')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    //Landlord Visits
    public String[] tblSubLV = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View", "Visit Details"};
    public  String[] arrSubLV = new String[23];

    //MOP Visits
    public String[] tblSubMV = new String[] {"", "Actions", "ID", "Sub Category Name", "Customer Name", "Supplier Name", "Utility", "Next Action", "Due Date", "Currently Waiting On", "Status", "Owner", "Created Date", "Created By", "Date Closed",
            "Closed By", "Summary", "Estimated Savings", "Actual Savings", "Annualised Savings", "Customer View", "Supplier View"};
    public  String[] arrSubMV = new String[22];

    public void accessCategory() {
        waitLoad();
        tabVisits.waitClickable().click();
    }

    public void verifyCategory() {
        waitExec();
        if(cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed()
                && cardTasksClosed.isDisplayed() && subTabLV.isDisplayed() && subTabMV.isDisplayed()){
            System.out.println("The category is loaded properly.");
        }
        else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerificationLV() {
        for(int i = 0 ; i < arrSubLV.length ; i++) {
            arrSubLV[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubLV[i].equals(arrSubLV[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationMV() {
        for(int i = 0 ; i < arrSubMV.length ; i++) {
            arrSubMV[i] = _webDriverHandler.byXpath("//table[@id='QueryListSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblSubMV[i].equals(arrSubMV[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifySubCategory(String subCat) {
        switch (subCat) {
            case "LV":
                subTabLV.waitClickable().click();
                waitLoad();
                columnVerificationLV();
                break;
            case "MV":
                subTabMV.waitClickable().click();
                waitLoad();
                columnVerificationMV();
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
