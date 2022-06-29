package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.util.Hashtable;

public class SubCategories {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabSubCategories;
    ElementHandler btnNewSubCategory;
    ElementHandler tbSearch;
    ElementHandler tbSubCategoryName;
    ElementHandler ddCategory;
    ElementHandler tglSupplierRequired;
    ElementHandler tglSupplierRequiredCheck;
    ElementHandler tglUtilityRequired;
    ElementHandler tglUtilityRequiredCheck;
    ElementHandler tglCustomerAccess;
    ElementHandler tglCustomerAccessCheck;
    ElementHandler tglSupplierAccess;
    ElementHandler tglSupplierAccessCheck;
    ElementHandler tglLicenseeAccess;
    ElementHandler tglLicenseeAccessCheck;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler ddDefaultAssignment;
    ElementHandler textAreadefaultSummary;
    ElementHandler ddNextStep;
    ElementHandler tbDueDate;
    ElementHandler tglDueWorkDays;
    ElementHandler tglDueWorkDaysCheck;
    ElementHandler ddSLA;
    ElementHandler tbActionDate;
    ElementHandler tglActionWorkDays;
    ElementHandler tglActionWorkDaysCheck;
    ElementHandler tglCopyFields;
    ElementHandler tglCopyFieldsCheck;
    ElementHandler tglCopyActions;
    ElementHandler tglCopyActionsCheck;
    ElementHandler ddToClose;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnEdit;
    ElementHandler btnCopy;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgSubName;
    ElementHandler msgCategory;
    ElementHandler msgDefaultAssignment;
    ElementHandler msgNxtStep;
    ElementHandler msgDueDate;
    ElementHandler msgSLA;
    ElementHandler msgActionDate;
    ElementHandler msgToClose;
    ElementHandler btnOk;
    ElementHandler btnSuccess;

    public SubCategories(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabSubCategories = _webDriverHandler.byXpath("//a[contains(text(), 'Sub-Categories')]");
        //       btnNewSubCategory = _webDriverHandler.byXpath("//button[text() = 'Sub-Categories']");
        btnNewSubCategory = _webDriverHandler.byXpath("//*[@id='partialViewContent']/div[1]/button[contains(text(),' Sub-Category')]");
        
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        tbSubCategoryName = _webDriverHandler.byXpath("//*[@id='Name']");
        ddCategory = _webDriverHandler.byXpath("//*[@id='CategoryId']");
        tglSupplierRequired = _webDriverHandler.byXpath("//label[input[@name='SupplierMandatory']]");
        tglSupplierRequiredCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierMandatory']]//input");
        tglUtilityRequired = _webDriverHandler.byXpath("//label[input[@name='UtilityMandatory']]");
        tglUtilityRequiredCheck = _webDriverHandler.byXpath("//label[input[@name='UtilityMandatory']]//input");
        tglCustomerAccess = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]");
        tglCustomerAccessCheck = _webDriverHandler.byXpath("//label[input[@name='CustomerAccess']]//input");
        tglSupplierAccess = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]");
        tglSupplierAccessCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierAccess']]//input");
        tglLicenseeAccess = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]");
        tglLicenseeAccessCheck = _webDriverHandler.byXpath("//label[input[@name='LicenseeAccess']]//input");
		/*
		 * tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
		 * tglGlobalCheck =
		 * _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
		 */
        ddDefaultAssignment = _webDriverHandler.byXpath("//*[@id='AccManagerRoleId']");
        textAreadefaultSummary = _webDriverHandler.byXpath("//*[@id='DefaultSummary']");
        
        ddNextStep = _webDriverHandler.byXpath("//*[@id='NextStep']");
        tbDueDate = _webDriverHandler.byXpath("//*[@id='DueDateInterval']");
        tglDueWorkDays = _webDriverHandler.byXpath("//label[input[@name='DueInWorkDays']]");
        tglDueWorkDaysCheck = _webDriverHandler.byXpath("//label[input[@name='DueInWorkDays']]//input");
        ddSLA = _webDriverHandler.byXpath("//*[@id='NextActionSlaType']");
        tbActionDate = _webDriverHandler.byXpath("//*[@id='NextActionInterval']");
        tglActionWorkDays = _webDriverHandler.byXpath("//label[input[@name='ActionIntervalInWorkDays']]");
        tglActionWorkDaysCheck = _webDriverHandler.byXpath("//label[input[@name='ActionIntervalInWorkDays']]//input");
       // ddToClose = _webDriverHandler.byXpath("//button[contains(@class, 'multiselect dropdown-toggle')]");
        ddToClose = _webDriverHandler.byXpath(" //div[contains(@class,'btn-group show')]//button[contains(@class, 'multiselect dropdown-toggle')]");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        tglCopyFields = _webDriverHandler.byXpath("//label[input[@name='CopyFields']]");
        tglCopyFieldsCheck = _webDriverHandler.byXpath("//label[input[@name='CopyFields']]//input");
        tglCopyActions = _webDriverHandler.byXpath("//label[input[@name='CopyActions']]");
        tglCopyActionsCheck = _webDriverHandler.byXpath("//label[input[@name='CopyActions']]//input");
        btnEdit = _webDriverHandler.byXpath("//button[@title='Action']//i");
        btnCopy = _webDriverHandler.byXpath("//button[@title='Copy']//i");
        btnCreate = _webDriverHandler.byXpath("//*[@id='modalAddNewSubCategory']//button[@type='submit']");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewSubCategory']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewSubCategory']//*[contains(text(), ' Save')]");
        msgSubName = _webDriverHandler.byXpath("//*[@id='Name-error']");
        msgCategory = _webDriverHandler.byXpath("//*[@id='CategoryId-error']");
        msgDefaultAssignment = _webDriverHandler.byXpath("//*[@id='AccManagerRoleId-error']");
        msgNxtStep = _webDriverHandler.byXpath("//*[@id='NextStep-error']");
        msgDueDate = _webDriverHandler.byXpath("//*[@id='DueDateInterval-error']");
        msgSLA = _webDriverHandler.byXpath("//*[@id='NextActionSlaType-error']");
        msgActionDate = _webDriverHandler.byXpath("//*[@id='NextActionInterval-error']");
        msgToClose = _webDriverHandler.byXpath("//*[@id='SubCategoryRequiredToCloseSelect-error']");
   //     btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    btnOk = _webDriverHandler.byXpath("*//button[@type='submit']");
    btnSuccess=_webDriverHandler.byXpath("*//button[@type='button'][contains(text(),'OK')]");
    }

    public String[] tblSubCategories = new String[]{"Status", "Sub-Category Name", "Category Name",  "Licensee","Customer","Update on Create", "Next Step", "Next Action Days", "Actions"};
    public String[] arrSubCategories = new String[9];

    String strErrorSubName = "The Sub-Category Name: field is required.";
    String strErrorCategory = "The Category Name: field is required.";
    String strErrorDefaultAssignment = "The Default Assignment: field is required.";
    String strErrorNxtStep = "The Next Step: field is required.";
    String strErrorDueDate = "The Default Due Date (Days): field is required.";
    String strErrorSLA = "The Next Action SLA Type: field is required.";
    String strErrorActionDate = "The Next Action Date (Days): field is required.";
    String strErrorToClose = "The Required To Close: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){System.out.println(""+e);}
        }
        while(tabSubCategories.notPresent());
    }

    public void accessSubCategories() {
        tabSubCategories.waitClickable().click();
        waitLoad();
    }

    public void search(String subCategory){
        tbSearch.waitClickable().clear().sendKeys(subCategory);
        waitLoad();
    }
    public void searchName(String name){
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }
    public void subCategoriesTgl (Hashtable<String, Boolean> tglData) {
        if (tglData.get("SR")) {
            if (!tglSupplierRequiredCheck.isSelected()) {
                tglSupplierRequired.waitClickable().click();
            }
        } else {
            if (tglSupplierRequiredCheck.isSelected()) {
                tglSupplierRequired.waitClickable().click();
            }
        }

        if (tglData.get("UR")) {
            if (!tglUtilityRequiredCheck.isSelected()) {
                tglUtilityRequired.waitClickable().click();
            }
        } else {
            if (tglUtilityRequiredCheck.isSelected()) {
                tglUtilityRequired.waitClickable().click();
            }
        }
        if (tglData.get("LA")) {
            if (!tglLicenseeAccessCheck.isSelected()) {
                tglLicenseeAccess.waitClickable().click();
            }
        } else {
            if (tglLicenseeAccessCheck.isSelected()) {
                tglLicenseeAccess.waitClickable().click();
            }
        }

        if (tglData.get("CA")) {
            if (!tglCustomerAccessCheck.isSelected()) {
                tglCustomerAccess.waitClickable().click();
            }
        } else {
            if (tglCustomerAccessCheck.isSelected()) {
                tglCustomerAccess.waitClickable().click();
            }
        }
		/*
		 * if (tglData.get("SA")) { if (!tglSupplierAccessCheck.isSelected()) {
		 * tglSupplierAccess.waitClickable().click(); } } else { if
		 * (tglSupplierAccessCheck.isSelected()) {
		 * tglSupplierAccess.waitClickable().click(); } }
		 */

       

		/*
		 * if (tglData.get("GBL")) { if (!tglGlobalCheck.isSelected()) {
		 * tglGlobal.waitClickable().click(); } } else { if
		 * (tglGlobalCheck.isSelected()) { tglGlobal.waitClickable().click(); } }
		 */

        if (tglData.get("DWD")) {
            if (!tglDueWorkDaysCheck.isSelected()) {
                tglDueWorkDays.waitClickable().click();
            }
        } else {
            if (tglDueWorkDaysCheck.isSelected()) {
                tglDueWorkDays.waitClickable().click();
            }
        }

        if (tglData.get("AWD")) {
            if (!tglActionWorkDaysCheck.isSelected()) {
                tglActionWorkDays.waitClickable().click();
            }
        } else {
            if (tglActionWorkDaysCheck.isSelected()) {
                tglActionWorkDays.waitClickable().click();
            }
        }

        if (tglData.get("Sts")) {
            if (!tglStatusCheck.isSelected()) {
                tglStatus.waitClickable().click();
            }
        } else {
            if (tglStatusCheck.isSelected()) {
                tglStatus.waitClickable().click();
            }
        }
    }

    public void subCategoriesForm (Hashtable<String, String> formData) {
        tbSubCategoryName.waitClickable().clear().sendKeys(formData.get("subCategoryName"));
        ddCategory.selectByText(formData.get("category"));
        textAreadefaultSummary.sendKeys(formData.get("defaultSummary"));
        ddDefaultAssignment.selectByText(formData.get("defaultAssign"));
        ddNextStep.selectByText(formData.get("nextStep"));
        tbDueDate.clear().sendKeys(formData.get("defaultDueDate"));
        ddSLA.selectByText(formData.get("actionSLA"));
        tbActionDate.clear().sendKeys(formData.get("actionDate"));
    }

    public void createSubCategories(Hashtable<String, Boolean> tglData,  Hashtable<String, String> formData, String... toClose) throws InterruptedException {
        btnNewSubCategory.waitClickable(15,100).click();
        subCategoriesTgl(tglData);
        subCategoriesForm(formData);
        ddToClose.waitClickable().click();
        for (String t : toClose) {
            if (!(_webDriverHandler.byXpath("//label[contains(text(), ' " + t + "')]//input").isSelected())) {
                _webDriverHandler.byXpath("//label[contains(text(), ' " + t + "')]").click();
            }
        }
     //  ddToClose.waitClickable(10,100).click();
        btnCreate.click();
        System.out.println("New subcategory is added");
       btnSuccess.waitClickable(15,100).click();
       // btnOk.waitClickable(15,100).click();
    }

    public void editSubCategories(String name, Hashtable<String, Boolean> tglData, Hashtable<String, String> formData)  
    //, String... toClose removed from the definition
    {
        search(name);
        btnEdit.waitClickable().click();
        subCategoriesTgl(tglData);
        subCategoriesForm(formData);
    /*   ddToClose.waitClickable().click();
        for(int i=1; i<5; i++) {
            try {
                if (_webDriverHandler.byXpath("//div//ul[contains(@class, 'multiselect-container')]//li[" + i + "]//label//input").isSelected()) {
                    _webDriverHandler.byXpath("//div//ul[contains(@class, 'multiselect-container')]//li[" + i + "]//label").waitClickable().click();
                }
            } catch (Exception e) {
            }
        }
        
        for (String t : toClose) {
            if (!(_webDriverHandler.byXpath("//label[contains(text(), ' " + t + "')]//input").isSelected())) {
                _webDriverHandler.byXpath("//label[contains(text(), ' " + t + "')]").click();
            }
        }
        ddToClose.waitClickable().click();
        */
        btnSave.waitClickable().click();
        btnOk.waitClickable().click();
        waitLoad();
       /* searchName(formData.get("name"));
        
        if (tglData.get("CA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[4]").getText().equals("Yes"))) {
        	        } else if (!tglData.get("CA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[4]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (tglData.get("SA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[5]").getText().equals("Yes"))) {
        } else if (!tglData.get("SA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[5]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (tglData.get("LA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[6]").getText().equals("Yes"))) {
        } else if (!tglData.get("LA") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[6]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (tglData.get("GBL") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[7]").getText().equals("Yes"))) {
        } else if (!tglData.get("GBL") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[7]").getText().equals("No"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
        if (tglData.get("Sts") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[1]").getText().equals("Active"))) {
        } else if (!tglData.get("Sts") && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + formData.get("name") + "')]]//td[1]").getText().equals("Inactive"))) {
        } else {
            Assert.fail("Not Working Fine.");
        }
    */
    }
  
    public void columnVerification() {
        for (int i = 0; i < arrSubCategories.length; i++) {
            arrSubCategories[i] = _webDriverHandler.byXpath("//table[@id='tblSubCategories']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCategories[i].equals(arrSubCategories[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewSubCategory.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgSubName.getText().equalsIgnoreCase(strErrorSubName) 
        		&& msgCategory.getText().equals(strErrorCategory)
        		&& msgNxtStep.getText().equals(strErrorNxtStep) 
        		&& msgDueDate.getText().equals(strErrorDueDate)
        		&& msgSLA.getText().equals(strErrorSLA)
        		&& msgActionDate.getText().equals(strErrorActionDate) )
        	//&& msgToClose.getText().equals(strErrorToClose) 
    		//&& msgDefaultAssignment.getText().equals(strErrorDefaultAssignment)
    		{
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