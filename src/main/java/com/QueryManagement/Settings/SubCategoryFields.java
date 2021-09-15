package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class SubCategoryFields {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabSubCategoryFields;
    ElementHandler btnNewSubCategoryField;
    ElementHandler tbSearch;
    ElementHandler ddSubCategory;
    ElementHandler ddField;
    ElementHandler tbFieldDescription;
    ElementHandler tbFiledOrder;
    ElementHandler ddCustomerAccess;
    ElementHandler ddSupplierAccess;
    ElementHandler ddLicenseeAccess;
    ElementHandler tglMandatory;
    ElementHandler tglMandatoryCheck;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler tglSetDateToday;
    ElementHandler tglSetDateTodayCheck;
    ElementHandler tglAllowPastDate;
    ElementHandler tglAllowPastDateCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgSubCat;
    ElementHandler msgField;
    ElementHandler msgFieldOrder;
    ElementHandler msgLA;
    ElementHandler msgCA;
    ElementHandler msgSA;
    ElementHandler btnOk;

    public SubCategoryFields(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabSubCategoryFields = _webDriverHandler.byXpath("//a[contains(text(), 'Sub-Category Fields')]");
        btnNewSubCategoryField = _webDriverHandler.byXpath("//button[text() = ' Sub-Category Field']");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        ddSubCategory = _webDriverHandler.byXpath("//*[@id='SubCategoryId']");
        ddField = _webDriverHandler.byXpath("//*[@id='FieldIdOnSubCat']");
        tbFieldDescription = _webDriverHandler.byXpath("//*[@id='FieldDescription']");
        tbFiledOrder = _webDriverHandler.byXpath("//*[@id='Order']");
        ddCustomerAccess = _webDriverHandler.byXpath("//*[@id='CustomerAccess']");
        ddSupplierAccess = _webDriverHandler.byXpath("//*[@id='SupplierAccess']");
        ddLicenseeAccess = _webDriverHandler.byXpath("//*[@id='LicenseeAccess']");
        tglMandatory = _webDriverHandler.byXpath("//label[input[@name='Mandatory']]");
        tglMandatoryCheck = _webDriverHandler.byXpath("//label[input[@name='Mandatory']]//input");
        tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
        tglGlobalCheck = _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        tglSetDateToday = _webDriverHandler.byXpath("//label[input[@name='SetDateAsToday']]");
        tglSetDateTodayCheck = _webDriverHandler.byXpath("//label[input[@name='SetDateAsToday']]//input");
        tglAllowPastDate = _webDriverHandler.byXpath("//label[input[@name='AllowPastDate']]");
        tglAllowPastDateCheck = _webDriverHandler.byXpath("//label[input[@name='AllowPastDate']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Save')]");
        msgSubCat = _webDriverHandler.byXpath("//*[@id='SubCategoryId-error']");
        msgField = _webDriverHandler.byXpath("//*[@id='FieldIdOnSubCat-error']");
        msgFieldOrder = _webDriverHandler.byXpath("//*[@id='Order-error']");
        msgLA = _webDriverHandler.byXpath("//*[@id='LicenseeAccess-error']");
        msgCA = _webDriverHandler.byXpath("//*[@id='CustomerAccess-error']");
        msgSA = _webDriverHandler.byXpath("//*[@id='SupplierAccess-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblSubCategories = new String[]{"Status", "Sub-Category Name", "Field Name", "Field Description", "Field Order", "Licensee Access", "Customer Access", "Supplier Access", "Mandatory", "Global", "Actions"};
    public String[] arrSubCategories = new String[11];

    String strErrorSubCategory = "The Sub-Category: field is required.";
    String strErrorField = "The Field: field is required.";
    String strErrorFieldOrder = "The Field Order: field is required.";
    String strErrorLicenseeAccess = "The Licensee Access: field is required.";
    String strErrorCustomerAccess = "The Customer Access: field is required.";
    String strErrorSupplierAccess = "The Supplier Access: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabSubCategoryFields.notPresent());
    }

    public void accessSubCategoryFields() {
        tabSubCategoryFields.waitClickable().click();
        waitLoad();
    }

    public void search(String name) {
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }

    public void createSubCategoryField(String subCategory, String field, String fieldOrder, String licenseeAccess, String customerAccess, String supplierAccess, boolean Mnd, boolean Gbl, boolean Sts) {
        btnNewSubCategoryField.waitClickable().click();
        ddSubCategory.waitClickable().selectByText(subCategory);
        ddField.waitClickable().selectByText(field);
        waitLoad();
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFiledOrder.waitClickable().sendKeys(fieldOrder);
        ddLicenseeAccess.waitClickable().selectByText(licenseeAccess);
        ddSupplierAccess.waitClickable().selectByText(supplierAccess);
        ddCustomerAccess.waitClickable().selectByText(customerAccess);
        if (Mnd) {
            tglMandatory.waitClickable().click();
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

    public void createSubCategoryField(String subCategory, String field, String fieldOrder, String licenseeAccess, String customerAccess, String supplierAccess, boolean Mnd, boolean Gbl, boolean Sts, boolean SDT, boolean APD) {
        btnNewSubCategoryField.waitClickable().click();
        ddSubCategory.waitClickable().selectByText(subCategory);
        ddField.waitClickable().selectByText(field);
        waitLoad();
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFiledOrder.waitClickable().sendKeys(fieldOrder);
        ddLicenseeAccess.waitClickable().selectByText(licenseeAccess);
        ddSupplierAccess.waitClickable().selectByText(supplierAccess);
        ddCustomerAccess.waitClickable().selectByText(customerAccess);
        if (SDT) {
            tglSetDateToday.waitClickable().click();
        }
        if (APD) {
            tglAllowPastDate.waitClickable().click();
        }
        if (Mnd) {
            tglMandatory.waitClickable().click();
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

    public void editSubCategoryField(String subCategory, String fieldName, String newSubCategory, String field, String fieldOrder, String licenseeAccess, String customerAccess, String supplierAccess, boolean Mnd, boolean Gbl, boolean Sts)  {
        search(subCategory);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + fieldName + "')]]//button[@title = 'Action']//i").waitClickable().click();
        ddSubCategory.waitClickable().selectByText(newSubCategory);
        ddField.waitClickable().selectByText(field);
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFiledOrder.waitClickable().sendKeys(fieldOrder);
        ddLicenseeAccess.waitClickable().selectByText(licenseeAccess);
        ddSupplierAccess.waitClickable().selectByText(supplierAccess);
        ddCustomerAccess.waitClickable().selectByText(customerAccess);
        if (Mnd) {
            if (!tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
            }
        } else {
            if (tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
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
        search(newSubCategory);
        if (Mnd && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[9]").getText().equals("Yes"))) {
        } else if (!Mnd && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[9]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        if (Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[10]").getText().equals("Yes"))) {
        } else if (!Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[10]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        if (Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Active"))) {
        } else if (!Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Inactive"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
    }

    public void editSubCategoryField(String subCategory, String fieldName, String newSubCategory, String field, String fieldOrder, String licenseeAccess, String customerAccess, String supplierAccess, boolean Mnd, boolean Gbl, boolean Sts, boolean SDT, boolean APD)  {
        search(subCategory);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + fieldName + "')]]//button[@title = 'Action']//i").waitClickable().click();
        ddSubCategory.waitClickable().selectByText(newSubCategory);
        ddField.waitClickable().selectByText(field);
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFiledOrder.waitClickable().sendKeys(fieldOrder);
        ddLicenseeAccess.waitClickable().selectByText(licenseeAccess);
        ddSupplierAccess.waitClickable().selectByText(supplierAccess);
        ddCustomerAccess.waitClickable().selectByText(customerAccess);
        if (SDT) {
            if (!tglSetDateTodayCheck.isSelected()) {
                tglSetDateToday.waitClickable().click();
            }
        } else {
            if (tglSetDateTodayCheck.isSelected()) {
                tglSetDateToday.waitClickable().click();
            }
        }
        if (APD) {
            if (!tglAllowPastDateCheck.isSelected()) {
                tglAllowPastDate.waitClickable().click();
            }
        } else {
            if (tglAllowPastDateCheck.isSelected()) {
                tglAllowPastDate.waitClickable().click();
            }
        }
        if (Mnd) {
            if (!tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
            }
        } else {
            if (tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
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
        search(newSubCategory);
        if (Mnd && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[9]").getText().equals("Yes"))) {
        } else if (!Mnd && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[9]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        if (Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[10]").getText().equals("Yes"))) {
        } else if (!Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[10]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
        if (Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Active"))) {
        } else if (!Sts && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newSubCategory + "')]]//td[1]").getText().equals("Inactive"))) {
        } else {
            Assert.fail("Not Working Fine");
        }
    }

    public void columnVerification() {
        for (int i = 0; i < arrSubCategories.length; i++) {
            arrSubCategories[i] = _webDriverHandler.byXpath("//table[@id='tblSubcategoryField']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCategories[i].equals(arrSubCategories[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewSubCategoryField.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgSubCat.getText().equalsIgnoreCase(strErrorSubCategory) && msgField.getText().equals(strErrorField) && msgLA.getText().equals(strErrorLicenseeAccess) &&
                msgCA.getText().equals(strErrorCustomerAccess) && msgSA.getText().equals(strErrorSupplierAccess) && msgFieldOrder.getText().equals(strErrorFieldOrder)) {
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