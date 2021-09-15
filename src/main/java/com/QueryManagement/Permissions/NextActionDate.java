package com.QueryManagement.Permissions;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.google.j2objc.annotations.RetainedLocalRef;
import org.testng.Assert;

public class NextActionDate {

    WebDriverHandler _webDriverHandler;
    ElementHandler btnCreateNew;
    ElementHandler btnActionDash;
    ElementHandler tbNADCreateNew;
    ElementHandler tbNADAction;
    ElementHandler btnActionEdit;
    ElementHandler btnCreateFrom;
    ElementHandler tbNADCreateFrom;
    ElementHandler tbNADEdit;
    ElementHandler btnCancelNew;
    ElementHandler btnCancelAction;
    ElementHandler btnCancelFrom;
    ElementHandler btnBack;
    ElementHandler cardQMP;
    ElementHandler linkAllApps;

    public NextActionDate(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnCreateNew = _webDriverHandler.byXpath("//button[text() = ' Create New']");
        btnActionDash = _webDriverHandler.byXpath("//button[@title='Quick Action'][1]");
        tbNADCreateNew = _webDriverHandler.byXpath("//*[@id = 'newTaskForm']//input[@id = 'NextActionDateTaskInitial']");
        tbNADAction = _webDriverHandler.byXpath("//*[@id = 'newTaskActionForm']//input[@id = 'NextActionDateOnAction']");
        btnActionEdit = _webDriverHandler.byXpath("//button[@onclick = 'ShowQueryTaskActionForm()']");
        btnCreateFrom = _webDriverHandler.byXpath("//button[text() = ' Create From']");
        tbNADCreateFrom = _webDriverHandler.byXpath("//*[@id = 'createTaskFromForm']//input[@id = 'NextActionDateFromTaskInitial']");
        tbNADEdit = _webDriverHandler.byXpath("//*[@id = 'taskForm']//input[@id = 'NextActionDate']");
        btnCancelNew = _webDriverHandler.byXpath("//*[@id = 'newTaskForm']//button[text() = 'Cancel']");
        btnCancelAction = _webDriverHandler.byXpath("//*[@id = 'newTaskActionForm']//button[text() = 'Cancel']");
        btnCancelFrom = _webDriverHandler.byXpath("//*[@id = 'createTaskFromForm']//button[text() = 'Cancel']");
        btnBack = _webDriverHandler.byXpath("//button[text() = ' Back']");
        cardQMP = _webDriverHandler.byXpath("//*[@id='appTrayList']//a[@href='/QueryManagement/Home/Dashboard']");
        linkAllApps = _webDriverHandler.byXpath("//a[@title = 'Apps']");
    }

    public void verifyView (boolean state) {
        Permission permission = new Permission(_webDriverHandler);
        if (state) {
            Assert.assertTrue(tbNADEdit.isDisplayed(), "Failing at edit page base data.");
            btnCreateNew.waitClickable().click();
            waitLoad();
            Assert.assertTrue(tbNADCreateNew.isDisplayed(), "Failing in Create New form.");
            btnCancelNew.waitClickable().click();
            btnActionEdit.waitClickable().click();
            waitLoad();
            Assert.assertTrue(tbNADAction.isDisplayed(), "Failing in edit page Action.");
            btnCancelAction.waitClickable().click();
            btnCreateFrom.waitClickable().click();
            waitLoad();
            Assert.assertTrue(tbNADCreateFrom.isDisplayed(), "Failing in Create From form.");
            btnCancelFrom.waitClickable().click();
            btnBack.waitClickable().click();
            linkAllApps.waitClickable().click();
            cardQMP.waitClickable().click();
            permission.accessSubCategory("Accounting", "Account Query" );
            btnActionDash.waitClickable().click();
            Assert.assertTrue(tbNADAction.isDisplayed(), "Failing in dashboard Action.");
            btnCancelAction.waitClickable().click();
        }
        else {
            Assert.assertTrue(!tbNADEdit.isDisplayed(), "Failing at edit page base data.");
            btnCreateNew.waitClickable().click();
            waitLoad();
            Assert.assertTrue(!tbNADCreateNew.isDisplayed(), "Failing in Create New form.");
            btnCancelNew.waitClickable().click();
            btnActionEdit.waitClickable().click();
            waitLoad();
            Assert.assertTrue(!tbNADAction.isDisplayed(), "Failing in edit page Action.");
            btnCancelAction.waitClickable().click();
            btnCreateFrom.waitClickable().click();
            waitLoad();
            Assert.assertTrue(!tbNADCreateFrom.isDisplayed(), "Failing in Create From form.");
            btnCancelFrom.waitClickable().click();
            btnBack.waitClickable().click();
            linkAllApps.waitClickable().click();
            cardQMP.waitClickable().click();
            permission.accessSubCategory("Accounting", "Account Query" );
            btnActionDash.waitClickable().click();
            Assert.assertTrue(!tbNADAction.isDisplayed(), "Failing in dashboard Action.");
            btnCancelAction.waitClickable().click();
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}