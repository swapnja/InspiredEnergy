package com.QueryManagement.Permissions;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Logins {

    WebDriverHandler _webDriverHandler;
    ElementHandler tbFilterID;
    ElementHandler tbFilterUtility;
    ElementHandler tbFilterSubcategory;
    ElementHandler tbFilterNextAction;
    ElementHandler tbFilterDueDate;
    ElementHandler tbFilterStatus;
    ElementHandler tbFilterCWO;
    ElementHandler tbFilterOwner;
    ElementHandler btnEditEntry;
    ElementHandler btnImport;
    ElementHandler btnCreateImport;
    ElementHandler btnUpdateImport;
    ElementHandler btnActionImport;
    ElementHandler ddBulkProcess;
    ElementHandler bulkAssign;
    ElementHandler bulkAction;

    public Logins (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        tbFilterUtility = _webDriverHandler.byXpath("//*[@id = 'filterUtility']");
        tbFilterSubcategory = _webDriverHandler.byXpath("//*[@id = 'filterSubCategory']");
        tbFilterNextAction = _webDriverHandler.byXpath("//*[@id = 'filterNext']");
        tbFilterDueDate = _webDriverHandler.byXpath("//*[@id = filterDue");
        tbFilterStatus = _webDriverHandler.byXpath("//*[@id = 'filterStatus']");
        tbFilterCWO = _webDriverHandler.byXpath("//*[@id = 'filterCurrently']");
        tbFilterOwner = _webDriverHandler.byXpath("//*[@id = 'filterOwner']");
        btnEditEntry = _webDriverHandler.byXpath("//button[@title='Edit']");
        btnImport  = _webDriverHandler.byXpath("//button//i[@class='fa fa-upload']");
        btnCreateImport = _webDriverHandler.byXpath("//a[text() = 'Create Import']");
        btnUpdateImport = _webDriverHandler.byXpath("//a[text() = 'Update Import']");
        btnActionImport = _webDriverHandler.byXpath("//a[text() = 'Action Import']");

        ddBulkProcess = _webDriverHandler.byXpath("//*[@id = 'ddlBulkActions']");
        bulkAssign = _webDriverHandler.byXpath("//*[@id = 'ddlBulkActions']//option[text() = 'Bulk Assign']");
        bulkAction = _webDriverHandler.byXpath("//*[@id = 'ddlBulkActions']//option[text() = 'Bulk Action']");
    }

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
        waitLoad();
    }

    public void filter(String type, String data) {
        switch (type){
            case "Id" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "Utility" :
                tbFilterUtility.waitClickable().clear().sendKeys(data);
            case "Sub Category" :
                tbFilterSubcategory.waitClickable().clear().sendKeys(data);
            case "Next Action" :
                tbFilterNextAction.waitClickable().clear().sendKeys(data);
            case "Due Date" :
                tbFilterDueDate.waitClickable().clear().sendKeys(data);
            case "Status" :
                tbFilterStatus.waitClickable().clear().sendKeys(data);
            case "CWO" :
                tbFilterCWO.waitClickable().clear().sendKeys(data);
            case "Owner" :
                tbFilterOwner.waitClickable().clear().sendKeys(data);
        }
    }

    public void clearFilter() {
        tbFilterID.waitClickable().clear();
        tbFilterID.waitClickable().clear();
        tbFilterUtility.waitClickable().clear();
        tbFilterSubcategory.waitClickable().clear();
        tbFilterNextAction.waitClickable().clear();
        tbFilterDueDate.waitClickable().clear();
        tbFilterStatus.waitClickable().clear();
        tbFilterCWO.waitClickable().clear();
        tbFilterOwner.waitClickable().clear();
    }

    public void selectEntry(int id) {
        tbFilterID.waitClickable().clear().sendKeys(""+id);
        waitLoad();
        btnEditEntry.waitClickable().click();
        waitLoad();
    }

    public void verifyImports(){
        btnImport.waitClickable().click();
        if (btnCreateImport.notPresent() && btnUpdateImport.notPresent() && btnActionImport.isDisplayed()){
            System.out.println("Permissions are working.");
        }
        else {
            Assert.fail("Permissions are not working.");
        }
    }

    public void verifyBulk(){
        btnImport.waitClickable().click();
        if (bulkAssign.notPresent() &&  bulkAction.isDisplayed()){
            System.out.println("Bulk permissions are working.");
        }
        else {
            Assert.fail("Bulk permissions are not working.");
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15, 100).waitInvisible(15, 100);
    }
}