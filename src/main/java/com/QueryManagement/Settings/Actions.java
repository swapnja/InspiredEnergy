package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Actions {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabActions;
    ElementHandler tbSearch;
    ElementHandler btnNewAction;
    ElementHandler tbActionName;
    ElementHandler ddNxtStep;
    ElementHandler ddNxtSLA;
    ElementHandler tbNxtActionDate;
    ElementHandler ddResolution;
    ElementHandler tglWorkDays;
    ElementHandler tglWorkDaysCheck;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgActionName;
    ElementHandler msgNextStep;
    ElementHandler msgActionSLA;
    ElementHandler msgNextDate;
    ElementHandler msgResolution;
    ElementHandler btnOk;

    public Actions(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabActions = _webDriverHandler.byXpath("//a[contains(text(), 'Actions')]");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        btnNewAction = _webDriverHandler.byXpath("//button[text() = ' Action']");
        tbActionName = _webDriverHandler.byXpath("//*[@id='Name']");
        ddNxtStep = _webDriverHandler.byXpath("//*[@id='NextStep']");
        ddNxtSLA = _webDriverHandler.byXpath("//*[@id='NextActionSlaType']");
        tglWorkDays = _webDriverHandler.byXpath("//label[input[@name='ActionIntervalInWorkDays']]");
        tglWorkDaysCheck = _webDriverHandler.byXpath("//label[input[@name='ActionIntervalInWorkDays']]//input");
        tbNxtActionDate = _webDriverHandler.byXpath("//*[@id='NextActionInterval']");
        ddResolution = _webDriverHandler.byXpath("//*[@id='Resolution']");
        tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
        tglGlobalCheck = _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Save')]");
        msgActionName = _webDriverHandler.byXpath("//*[@id='Name-error']");
        msgNextStep = _webDriverHandler.byXpath("//*[@id='NextStep-error']");
        msgActionSLA = _webDriverHandler.byXpath("//*[@id='NextActionSlaType-error']");
        msgNextDate = _webDriverHandler.byXpath("//*[@id='NextActionInterval-error']");
        msgResolution = _webDriverHandler.byXpath("//*[@id='Resolution-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    //public String[] tblSubCategories = new String[]{"Status", "Action Name", "Next Step", "Next Action Days", "Working Days", "Global", "Actions"};
    public String[] tblSubCategories = new String[]{"Status", "Action Name", "Next Step", "Actions"};
    //changed the array from[7] to [4]
    public String[] arrSubCategories = new String[4];

    String strErrorActionName = "The Action Name: field is required.";
    String strErrorNextStep = "The Next Step: field is required.";
    String strErrorActionSLA = "The Next Action SLA Type: field is required.";
    String strErrorNextDate = "The Next Action Date (Days): field is required.";
    String strErrorResolution = "The Resolution: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabActions.notPresent());
    }

    public void accessActions() {
        tabActions.waitClickable().click();
        waitLoad();
    }

    public void search(String name) {
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }

    public void createAction(String name, String nextStep, String resolution, boolean Sts) {
        btnNewAction.waitClickable().click();
        tbActionName.waitClickable().clear().sendKeys(name);
        ddNxtStep.waitClickable().selectByText(nextStep);
        ddResolution.waitClickable().selectByText(resolution);
         if (!Sts) {
            tglStatus.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editAction(String name, String newName, String nextStep, String resolution,  boolean Sts)  {
        _webDriverHandler.byXpath("//a[contains(text(), '2')]").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Action']//i").waitClickable().click();
        tbActionName.waitClickable().clear().sendKeys(newName);
        ddNxtStep.waitClickable().selectByText(nextStep);
        ddResolution.waitClickable().selectByText(resolution);        
        if (Sts) {
         if (!tglStatusCheck.isSelected()) {
             tglStatus.waitClickable().click();
         }
        } else {
            if (tglStatusCheck.isSelected()) {
                tglStatus.waitClickable().click();
            }
        }
        btnSave.waitClickable().click();
        btnOk.waitClickable().click();
       
    }

    public void columnVerification() {
        for (int i = 0; i < arrSubCategories.length; i++) {
            arrSubCategories[i] = _webDriverHandler.byXpath("//table[@id='tblActions']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCategories[i].equals(arrSubCategories[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewAction.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgActionName.getText().equalsIgnoreCase(strErrorActionName)
        		&& msgNextStep.getText().equals(strErrorNextStep) 
                && msgResolution.getText().equals(strErrorResolution)) {
            System.out.println("Proper error messages are shown.");
        }
        else{
            Assert.fail();
        }
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}