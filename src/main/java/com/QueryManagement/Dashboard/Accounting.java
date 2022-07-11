package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Accounting {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabAccounting;
    ElementHandler subTabAccount2;
    ElementHandler subTabAccount3;
    ElementHandler subTabAccountDetailsRequired;


	/*
	 * ElementHandler cardTotalSavings; ElementHandler cardForecastSavings;
	 * ElementHandler cardTasksOpen; ElementHandler cardTasksClosed;
	 */
    ElementHandler cardActualSaving;
    ElementHandler cardEstimatedFutureSavings;
    ElementHandler cardOpenTaskCount;
    ElementHandler cardClosedTaskCount;
    
    public Accounting(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabAccounting = _webDriverHandler.byXpath("//a//span[contains(text(), 'Accounting')]");
		/*
		 * subTabADR =
		 * _webDriverHandler.byXpath("//a[contains(text(), 'Account Details Required')]"
		 * ); subTabAQ =
		 * _webDriverHandler.byXpath("//a[contains(text(), 'Account Query')]"); subTabDO
		 * = _webDriverHandler.byXpath("//a[contains(text(), 'Debt Outstanding')]");
		 * subTabPR =
		 * _webDriverHandler.byXpath("//a[contains(text(), 'Payment Required')]");
		 */
        subTabAccount2= _webDriverHandler.byXpath("//*[@id='82']");
        subTabAccount3=_webDriverHandler.byXpath("//*[@id='84']");
        subTabAccountDetailsRequired=_webDriverHandler.byXpath("//*[@id='1']");
      
        cardActualSaving= _webDriverHandler.byXpath("//*[@id='actualSavingDivId']");
        cardEstimatedFutureSavings = _webDriverHandler.byXpath("//*[@id='forecastSavingDivId']");
        cardOpenTaskCount=_webDriverHandler.byXpath("//*[@id='openTaskCount')]");
      
        cardClosedTaskCount = _webDriverHandler.byXpath("//*[@id='closedTasksCount']");
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

    public void verifyCategory() throws InterruptedException {
        waitExec();
        if(cardActualSaving.isDisplayed() && cardEstimatedFutureSavings.isDisplayed() && cardClosedTaskCount.isDisplayed()
        		&& subTabAccount2.isDisplayed()&& subTabAccount3.isDisplayed() && subTabAccountDetailsRequired.isDisplayed())
        	
        {
			/*
			 * if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() &&
			 * cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
			 * subTabADR.isDisplayed() && subTabAQ.isDisplayed() && subTabDO.isDisplayed()
			 * && subTabPR.isDisplayed()) {
			 */ 
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
            case "Account2":
            	subTabAccount2.waitClickable().click();
                //subTabADR.waitClickable().click();
                waitLoad();
                //columnVerificationADR();
                break;
            case "Account3":
            	subTabAccount3.waitClickable().click();
            	//subTabAQ.waitClickable().click();
                waitLoad();
                //columnVerificationAQ();
                break;
            case "Account Details":
            	subTabAccountDetailsRequired.waitClickable().click();
            	//subTabDO.waitClickable().click();
                waitLoad();
                //columnVerificationDO();
                break;
           
            default:
                Assert.fail("Select proper sub-category.");
        }
    }

    public void waitExec() throws InterruptedException {
        cardActualSaving.isDisplayed();
        cardClosedTaskCount.isDisplayed();
        cardEstimatedFutureSavings.isDisplayed();
        Thread.sleep(1000);
       // cardOpenTaskCount.isDisplayed();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
