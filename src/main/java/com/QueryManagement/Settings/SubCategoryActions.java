package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class SubCategoryActions {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabSubCategoryActions;
    ElementHandler btnNewSubCategoryAction;
    ElementHandler ddSubCategoryName;
    ElementHandler ddActionName;
    ElementHandler tglBulkUpdate;
    ElementHandler tglBulkUpdateCheck;
    ElementHandler tglLicenseeAccess;
    ElementHandler tglLicenseeAccessCheck;
    ElementHandler tglCustomerAccess;
    ElementHandler tglCustomerAccessCheck;
    ElementHandler tglSupplierAccess;
    ElementHandler tglSupplierAccessCheck;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgSubCategoryName;
    ElementHandler msgActionName;
    ElementHandler btnOk;

    public SubCategoryActions(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabSubCategoryActions = _webDriverHandler.byXpath("//a[contains(text(), 'Sub-Category Actions')]");
        btnNewSubCategoryAction = _webDriverHandler.byXpath("//button[text() = ' Sub-Category Action']");
        ddSubCategoryName = _webDriverHandler.byXpath("//*[@id='SubCategoryId']");
        ddActionName = _webDriverHandler.byXpath("//*[@id='QueryActionTypeId']");
        tglBulkUpdate = _webDriverHandler.byXpath("//label[input[@name='BulkUpdate']]");
        tglBulkUpdateCheck = _webDriverHandler.byXpath("//label[input[@name='BulkUpdate']]//input");
        tglLicenseeAccess = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]");
        tglLicenseeAccessCheck = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]//input");
        tglCustomerAccess = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]");
        tglCustomerAccessCheck = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]//input");
        tglSupplierAccess = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]");
        tglSupplierAccessCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]//input");
        tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
        tglGlobalCheck = _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewSubCategoriesActionConfig']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewSubCategoriesActionConfig']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewSubCategoriesActionConfig']//*[contains(text(), ' Save')]");
        msgSubCategoryName = _webDriverHandler.byXpath("//*[@id='SubCategoryId-error']");
        msgActionName = _webDriverHandler.byXpath("//*[@id='QueryActionTypeId-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblSubCategories = new String[]{"Status", "Sub-Category Name", "Action Name", "Bulk Update", "Licensee Access", "Customer Access", "Supplier Access", "Global", "Actions"};
    public String[] arrSubCategories = new String[9];

    String strErrorSubCategoryName = "The Sub-Category Name: field is required.";
    String strErrorActionName = "The Action Name: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabSubCategoryActions.notPresent());
    }

    public void accessSubCategoryActions() {
        tabSubCategoryActions.waitClickable().click();
        waitLoad();
    }

    public void createSubCategoryAction(String subCategory, String action, boolean Blk, boolean LA, boolean CA, boolean SA, boolean Gbl, boolean Sts) {
        btnNewSubCategoryAction.waitClickable().click();
        ddSubCategoryName.waitClickable().selectByText(subCategory);
        ddActionName.selectByText(action);
        if (Blk) {
            tglBulkUpdate.waitClickable().click();
        }
        if (LA) {
            tglLicenseeAccess.waitClickable().click();
        }
        if (CA) {
            tglCustomerAccess.waitClickable().click();
        }
        if (SA) {
            tglSupplierAccess.waitClickable().click();
        }
        if (Gbl) {
            tglGlobal.waitClickable().click();
        }
        if (!Sts) {
            tglStatus.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editSubCategoryAction(String subCategory, String newSubCategory, String action, boolean Blk, boolean LA, boolean CA, boolean SA, boolean Gbl, boolean Sts)  {
        _webDriverHandler.byXpath("//a[contains(text(), '5')]").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + subCategory + "')]]//button[@title = 'Action']//i").waitClickable().click();
        ddSubCategoryName.waitClickable().selectByText(newSubCategory);
        ddActionName.waitClickable().selectByText(action);
        if (Blk) {
            if (!tglBulkUpdateCheck.isSelected()) {
                tglBulkUpdate.waitClickable().click();
            }
        } else {
            if (tglBulkUpdateCheck.isSelected()) {
                tglBulkUpdate.waitClickable().click();
            }
        }
        if (LA) {
            if (!tglLicenseeAccessCheck.isSelected()) {
                tglLicenseeAccess.waitClickable().click();
            }
        } else {
            if (tglLicenseeAccessCheck.isSelected()) {
                tglLicenseeAccess.waitClickable().click();
            }
        }
        if (CA) {
            if (!tglCustomerAccessCheck.isSelected()) {
                tglCustomerAccess.waitClickable().click();
            }
        } else {
            if (tglCustomerAccessCheck.isSelected()) {
                tglCustomerAccess.waitClickable().click();
            }
        }
        if (SA) {
            if (!tglSupplierAccessCheck.isSelected()) {
                tglSupplierAccess.waitClickable().click();
            }
        } else {
            if (tglSupplierAccessCheck.isSelected()) {
                tglSupplierAccess.waitClickable().click();
            }
        }
        if (Gbl) {
            if (!tglGlobalCheck.isSelected()) {
                tglGlobal.waitClickable().click();
            }
        } else {
            if (tglGlobalCheck.isSelected()) {
                tglGlobal.waitClickable().click();
            }
        }
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
        waitLoad();
        _webDriverHandler.byXpath("//a[contains(text(), '5')]").waitClickable().click();
        if (Blk && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[4]").getText().equals("Yes"))) {
        } else if (!Blk && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[4]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (LA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[5]").getText().equals("Yes"))) {
        } else if (!LA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[5]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (CA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[6]").getText().equals("Yes"))) {
        } else if (!CA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[6]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (SA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[7]").getText().equals("Yes"))) {
        } else if (!SA && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[7]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[8]").getText().equals("Yes"))) {
        } else if (!Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[8]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Active"))) {
        } else if (!Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Inactive"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
    }

    public void columnVerification() {
        for (int i = 0; i < arrSubCategories.length; i++) {
            arrSubCategories[i] = _webDriverHandler.byXpath("//table[@id='tblSubCategoriesActionConfig']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCategories[i].equals(arrSubCategories[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewSubCategoryAction.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgSubCategoryName.getText().equalsIgnoreCase(strErrorSubCategoryName) && msgActionName.getText().equals(strErrorActionName)) {
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