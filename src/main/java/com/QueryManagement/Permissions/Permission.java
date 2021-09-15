package com.QueryManagement.Permissions;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;

public class Permission {

    WebDriverHandler _webDriverHandler;
    ElementHandler linkAdministration;
    ElementHandler linkHome;
    ElementHandler linkAllApps;
    ElementHandler cardUseRoles;
    ElementHandler cardQMP;
    ElementHandler tbSearch;
    ElementHandler tabPermissions;
    ElementHandler btnSave;
    ElementHandler btnOK;

    ElementHandler tbFilterID;
    ElementHandler tbFilterUtility;
    ElementHandler tbFilterSubcategory;
    ElementHandler tbFilterNextAction;
    ElementHandler tbFilterDueDate;
    ElementHandler tbFilterStatus;
    ElementHandler tbFilterCWO;
    ElementHandler tbFilterOwner;
    ElementHandler btnEditEntry;

    public Permission (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        linkAdministration = _webDriverHandler.byXpath("//a[@title = 'Administration']");
        linkHome = _webDriverHandler.byXpath("//a[@title = 'Home']");
        linkAllApps = _webDriverHandler.byXpath("//a[@title = 'Apps']");
        cardUseRoles = _webDriverHandler.byXpath("//a[@href = '/Core/UserRoleAdministration/UserRoles']");
        cardQMP = _webDriverHandler.byXpath("//*[@id='appTrayList']//a[@href='/QueryManagement/Home/Dashboard']");
        tbSearch = _webDriverHandler.byXpath("//input[@type = 'search']");
        tabPermissions = _webDriverHandler.byXpath("//a[@href = '#permissionsContent']");
        btnSave = _webDriverHandler.byXpath("//button[@type = 'submit']");
        btnOK = _webDriverHandler.byXpath("//button[text() = 'OK']");


        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        tbFilterUtility = _webDriverHandler.byXpath("//*[@id = 'filterUtility']");
        tbFilterSubcategory = _webDriverHandler.byXpath("//*[@id = 'filterSubCategory']");
        tbFilterNextAction = _webDriverHandler.byXpath("//*[@id = 'filterNext']");
        tbFilterDueDate = _webDriverHandler.byXpath("//*[@id = filterDue");
        tbFilterStatus = _webDriverHandler.byXpath("//*[@id = 'filterStatus']");
        tbFilterCWO = _webDriverHandler.byXpath("//*[@id = 'filterCurrently']");
        tbFilterOwner = _webDriverHandler.byXpath("//*[@id = 'filterOwner']");
        btnEditEntry = _webDriverHandler.byXpath("//button[@title='Edit']");
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

    public void selectEntry(int id) {
        tbFilterID.waitClickable().clear().sendKeys(""+id);
        waitLoad();
        btnEditEntry.waitClickable().click();
        waitLoad();
    }

    public void accessUserRoles() {
        try{waitLoad();} catch (Exception e){}
        linkAdministration.waitClickable().click();
        cardUseRoles.waitClickable().click();
        waitLoad();
    }

    public void search(String userRole) {
        tbSearch.waitClickable().clear().sendKeys(userRole);
        waitLoad();
    }

    public void accessPermissions(String userRole) {
        search(userRole);
        _webDriverHandler.byXpath("//tbody//tr[td[text() = '" + userRole + "']]//button[@title = 'Edit']").waitClickable().click();
        tabPermissions.waitClickable().click();
        waitLoad();
    }

    public void toggleView(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void toggleCreate(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void toggleEdit(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void toggleDelete(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void toggleImport(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void toggleExport(String id, boolean state){
        if (state){
            if (!_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
        else {
            if (_webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label//input").isSelected()){
                _webDriverHandler.byXpath("//tr[@data-appid=8][td//input[@id = '"+ id +"']]//td[2]//label").scrollDown().waitClickable().click();
            }
        }
    }

    public void accessQMP() {
        btnSave.scrollDown().waitClickable().click();
        btnOK.waitClickable().click();
        linkHome.waitClickable().click();
        linkAllApps.waitClickable().click();
        cardQMP.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}