package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;


public class All {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabAll;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public All(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabAll = _webDriverHandler.byXpath("//a[contains(text(), 'All')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    public String[] tblSub = new String[]{"Actions", "ID", "Utility", "SubCategory", "Customer Name", "Supplier Name", "Next Action", "Due Date", "Status", "Estimated Saving", "Actual Saving", "Annualised Saving", "Currently Waiting On", "Owner"};
    public String[] arrSub = new String[14];

    public void accessCategory() {
        waitLoad();
        tabAll.waitClickable().click();
    }

    public void verifyCategory() {
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerification() {
        for (int i = 0; i < arrSub.length; i++) {
            arrSub[i] = _webDriverHandler.byXpath("//table[@id='QueryListAllSubCategoriesTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSub[i].equals(arrSub[i]))) {
                System.out.println(tblSub[i]);
                System.out.println(arrSub[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
