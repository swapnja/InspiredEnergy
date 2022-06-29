package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Fields {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabFields;
    ElementHandler tbSearch;
    ElementHandler btnNewField;
    ElementHandler tbFieldName;
    ElementHandler ddFieldType;
    ElementHandler tbListValue;
    ElementHandler tbFieldDescription;
    ElementHandler tglGlobal;
    ElementHandler tglGlobalCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgFieldName;
    ElementHandler msgDataType;
    ElementHandler msgListValue;
    ElementHandler btnOk;

    public Fields(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabFields = _webDriverHandler.byXpath("//a[contains(text(), 'Fields')]");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        btnNewField = _webDriverHandler.byXpath("//button[text() = ' Field']");
        tbFieldName = _webDriverHandler.byXpath("//*[@id='Name']");
        ddFieldType = _webDriverHandler.byXpath("//*[@id='DataType']");
        tbListValue = _webDriverHandler.byXpath("//*[@id='txtFieldValues']");
        tbFieldDescription = _webDriverHandler.byXpath("//*[@id='Description']");
        tglGlobal = _webDriverHandler.byXpath("//label[input[@name='Global']]");
        tglGlobalCheck = _webDriverHandler.byXpath("//label[input[@name='Global']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewField']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewField']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewField']//*[contains(text(), ' Save')]");
        msgFieldName = _webDriverHandler.byXpath("//*[@id='Name-error']");
        msgDataType = _webDriverHandler.byXpath("//*[@id='DataType-error']");
        msgListValue = _webDriverHandler.byXpath("//*[@id='errListValues']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

  //  public String[] tblSubCategories = new String[]{"Status", "Field Name", "Field Type", "Field Description", "List Values", "Global", "Actions"};
   // public String[] arrSubCategories = new String[7];

    public String[] tblFields = new String[]{"Status", "Field Name", "Field Type", "Field Description", "List Values","Actions"};
    public String[] arrFields = new String[6];
    
    String strErrorFieldName = "The Field Name: field is required.";
    String strErrorFieldType = "The Field Type: field is required.";
    String strErrorListValue = "List Values field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabFields.notPresent());
    }

    public void accessFields() {
        tabFields.waitClickable().click();
        waitLoad();
    }

    public void search(String name) {
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }

    public void createFields(String name, String dataType, String description, String toolTip, boolean Sts, String... listValues) {
        btnNewField.waitClickable().click();
        tbFieldName.waitClickable().clear().sendKeys(name);
        ddFieldType.selectByText(dataType);
		/*
		 * if (listValues.length == 0) { } else { for (String t : listValues){
		 * tbListValue.waitClickable().sendKeys(t + "\n"); } }
		 */
        tbFieldDescription.waitClickable().clear().sendKeys(description);
		/*
		 * if (Gbl) { tglGlobal.waitClickable().click(); }
		 */
        if (!Sts) {
            tglStatus.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editFields(String name, String newName, String description, String toolTip,  boolean Sts, String... listValues)  {
        _webDriverHandler.byXpath("//a[contains(text(), '2')]").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Action']//i").waitClickable().click();
        tbFieldName.waitClickable().clear().sendKeys(newName);
        tbFieldDescription.waitClickable().clear().sendKeys(description);
		
		  if (listValues.length == 0) { } else {
		  do{_webDriverHandler.byXpath("(//*[contains(@class, 'fas')])[1]").
		  waitClickable().click();}
		  while(!_webDriverHandler.byXpath("(//*[contains(@class, 'fas')])[1]").
		  notPresent()); for (String t : listValues){
		  tbListValue.waitClickable().sendKeys(t + "\n"); } }
		 
		/*
		 * if (Gbl) { if (!tglGlobalCheck.isSelected()) {
		 * tglGlobal.waitClickable().click(); }
		 
        } else {
            if (tglGlobalCheck.isSelected()) {
                tglGlobal.waitClickable().click();
            }
        }*/
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
		/*
		 * _webDriverHandler.byXpath("//a[contains(text(), '2')]").waitClickable().click
		 * (); if (Gbl && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" +
		 * newName + "')]]//td[6]").getText().equals("Yes"))) { } else if (!Gbl &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName +
		 * "')]]//td[6]").getText().equals("No"))) { } else {
		 * Assert.fail("Not Working Fine4"); } if (Sts &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName +
		 * "')]]//td[1]").getText().equals("Active"))) { } else if (!Sts &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newName +
		 * "')]]//td[1]").getText().equals("Inactive"))) { } else {
		 * Assert.fail("Not Working Fine5"); }
		 */
    }

    public void columnVerification() {
        for (int i = 0; i < arrFields.length; i++) {
            arrFields[i] = _webDriverHandler.byXpath("//table[@id='tblFields']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblFields[i].equals(arrFields[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewField.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgFieldName.getText().equalsIgnoreCase(strErrorFieldName)
        		&& msgDataType.getText().equals(strErrorFieldType)) {
            System.out.println("Proper error messages are shown.");
        }
        else{
            Assert.fail();
        }
        btnCancel.waitClickable().click();

        btnNewField.waitClickable().click();
        tbFieldName.waitClickable().sendKeys("Name");
        ddFieldType.waitClickable().selectByText("List");
        btnCreate.waitClickable().click();
        if (msgListValue.getText().equalsIgnoreCase(strErrorListValue)) {
            System.out.println("Proper list error messages are shown.");
        }
        else{
            Assert.fail();
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}