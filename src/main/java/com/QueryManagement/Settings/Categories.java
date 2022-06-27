package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Categories {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabCategories;
    ElementHandler tbSearch;
    ElementHandler btnNewCategory;
    ElementHandler tbCategoryName;
    ElementHandler tglCustomerAccess;
    ElementHandler tglCustomerAccessCheck;
    ElementHandler tglSupplierAccess;
    ElementHandler tglSupplierAccessCheck;
    ElementHandler tglLicenseeAccess;
    ElementHandler tglLicenseeAccessCheck;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgName;
    ElementHandler btnOk;

    public Categories(WebDriverHandler webDriverHandler){
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabCategories = _webDriverHandler.byXpath("//a[contains(text(), 'Categories')]");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        btnNewCategory = _webDriverHandler.byXpath("//*[@id='NewCategoriesButton']");
        tbCategoryName = _webDriverHandler.byXpath("//*[@id='Name']");
        tglCustomerAccess = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]");
        tglCustomerAccessCheck = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]//input");
        tglSupplierAccess = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]");
        tglSupplierAccessCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]//input");
        tglLicenseeAccess = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]");
        tglLicenseeAccessCheck = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]//input");
        tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
        tglGlobalCheck = _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewCategory']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewCategory']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewCategory']//*[contains(text(), ' Save')]");
        msgName = _webDriverHandler.byXpath("//*[@id='Name-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblCategories = new String[]{"Status", "Category Name", "Licensee", "Customer","Actions"};
    public String[] arrCategories = new String[5];

    String strErrorName = "The Category Name: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable(15,100).click();
            try{
            	waitLoad();}
            catch (Exception e){}
        }
        while(tabCategories.notPresent());
    }

    public void accessCategories() {
      //  tabCategories.waitClickable(15,100).click();
     //   waitLoad();
    }

    public void search(String name) {
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }

    public void createCategories(String name, boolean LicAccess, boolean CustAccess, boolean Status) {
        btnNewCategory.waitClickable().click();
        tbCategoryName.waitClickable().sendKeys(name);
        if(CustAccess){
            tglCustomerAccess.waitClickable().click();
        }
       
        if(LicAccess){
            tglLicenseeAccess.waitClickable().click();
        }
        
        if(!Status){
            tglStatus.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editCategories(String name, String newName,boolean CustAccess, boolean LicAccess, boolean Status) {
        //_webDriverHandler.byXpath("//a[contains(text(), '4')]").waitClickable().click();
    	_webDriverHandler.byXpath("//*[@id='tblCategories_filter' ]/label/input").waitClickable(15,100).sendKeys("Automation Category");
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Action']//i").waitClickable(15,100).click();
        tbCategoryName.waitClickable().clear().sendKeys(newName);
        if (CustAccess) 
        {
            if (!tglCustomerAccessCheck.isSelected())
            {
                tglCustomerAccess.waitClickable().click();
            }
        } else {
            if (tglCustomerAccessCheck.isSelected()) {
                tglCustomerAccess.waitClickable().click();
            }
        }
        if (LicAccess) 
        {
            if (!tglLicenseeAccessCheck.isSelected())
            {
            	tglLicenseeAccess.waitClickable().click();
            }
        } else {
            if (tglLicenseeAccessCheck.isSelected()) {
            	tglLicenseeAccess.waitClickable().click();
            }
        }

        if (Status) {
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
        waitLoad();
      
        //_webDriverHandler.byXpath("//a[contains(text(), '4')]").waitClickable().click();
        if (CustAccess && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName + "')]]//td[3]").getText().equals("Yes"))) {
        } else if (!CustAccess && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName + "')]]//td[3]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        
        if (LicAccess) {
        } else if (!LicAccess && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName + "')]]//td[5]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        if (Status && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName + "')]]//td[1]").getText().equals("Active"))) {
        } else if (!Status && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName + "')]]//td[1]").getText().equals("Inactive"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
    }

    public void columnVerification() {
        for (int i = 0; i < arrCategories.length; i++) {
            arrCategories[i] = _webDriverHandler.byXpath("//table[@id='tblCategories']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblCategories[i].equals(arrCategories[i]))) {
                System.out.println(arrCategories[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewCategory.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgName.getText().equalsIgnoreCase(strErrorName)) {
            System.out.println("Proper error message is shown.");
        }
        else{
            Assert.fail();
        }
    }

    public void waitLoad(){
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}