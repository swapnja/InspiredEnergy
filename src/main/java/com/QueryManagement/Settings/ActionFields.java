package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class ActionFields {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabActionField;
    ElementHandler btnNewActionField;
    ElementHandler ddAction;
    ElementHandler ddField;
    ElementHandler tbFieldDescription;
    ElementHandler tbFieldOrder;
    ElementHandler tglMandatory;
    ElementHandler tglMandatoryCheck;
    ElementHandler tglStatus;
    ElementHandler tglStatusCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgAction;
    ElementHandler msgField;
    ElementHandler msgFieldOrder;
    ElementHandler btnOk;

    public ActionFields(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabActionField = _webDriverHandler.byXpath("//a[contains(text(), 'Action Fields')]");
        btnNewActionField = _webDriverHandler.byXpath("//button[text() = ' Action Field']");
        ddAction = _webDriverHandler.byXpath("//*[@id='QueryActionTypeId']");
        ddField = _webDriverHandler.byXpath("//*[@id='FieldIdOnAction']");
        tbFieldDescription = _webDriverHandler.byXpath("//*[@id='FieldDescription']");
        tbFieldOrder = _webDriverHandler.byXpath("//*[@id='FieldOrder']");
        tglMandatory = _webDriverHandler.byXpath("//label[input[@name='Mandatory']]");
        tglMandatoryCheck = _webDriverHandler.byXpath("//label[input[@name='Mandatory']]//input");
        tglStatus = _webDriverHandler.byXpath("//label[input[@name='IsActive']]");
        tglStatusCheck = _webDriverHandler.byXpath("//label[input[@name='IsActive']]//input");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewActionConfig']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewActionConfig']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewActionConfig']//*[contains(text(), ' Save')]");
        msgAction = _webDriverHandler.byXpath("//*[@id='QueryActionTypeId-error']");
        msgField = _webDriverHandler.byXpath("//*[@id='FieldIdOnAction-error']");
        msgFieldOrder = _webDriverHandler.byXpath("//*[@id='FieldOrder-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblActionFields = new String[]{"Status", "Action Name", "Field Name", "Field Description", "Field Order", "Mandatory", "Actions"};
    public String[] arrActionFields = new String[7];

    String strErrorActionName = "The Action: field is required.";
    String strErrorNextStep = "The Field: field is required.";
    String strErrorActionSLA = "The Field Order: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabActionField.notPresent());
    }

    public void accessActionField() {
    	tabActionField.waitClickable().click();
        waitLoad();
    }

    public void createActionField(String action, String field, String fieldOrder, boolean Mnd, boolean Sts) {
        btnNewActionField.waitClickable().click();
        ddAction.waitClickable().selectByText(action);
        ddField.waitClickable().selectByText(field);
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFieldOrder.waitClickable().sendKeys(fieldOrder);
        if (Mnd) {
            tglMandatory.waitClickable().click();
        }
        if (!Sts) {
            tglStatus.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editActionField(String action, String field, String fieldOrder, boolean Mnd, boolean Sts)  {
    // _webDriverHandler.byXpath("//a[contains(text(), '2')]").waitClickable().click();
    	
    	_webDriverHandler.byXpath("//*[@id='tblActionConfig_filter']//input[@type='search']").sendKeys(action);
    	_webDriverHandler.byXpath("//*[@id='1']/td[7]//button[@type='button']").click();
    	//_webDriverHandler.byXpath("//tr[td[contains(text(), '" + action + "')]]//button[@title = 'Action']//i").waitClickable().click();
        ddAction.waitClickable().selectByText(action);
        ddField.waitClickable().selectByText(field);
        if (!tbFieldDescription.getAttribute("disabled").equals("true")){
            Assert.fail("Description does not match");
        }
        tbFieldOrder.waitClickable().clear().sendKeys(fieldOrder);
        if (Mnd) {
            if (!tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
            }
        } else {
            if (tglMandatoryCheck.isSelected()) {
                tglMandatory.waitClickable().click();
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
		/*
		 * _webDriverHandler.byXpath("//a[contains(text(), '2')]").waitClickable().click
		 * (); if (Mnd && (_webDriverHandler.byXpath("//tr[td[contains(text(), '" +
		 * newAction + "')]]//td[6]").getText().equals("Yes"))) { } else if (!Mnd &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newAction +
		 * "')]]//td[6]").getText().equals("No"))) { } else {
		 * Assert.fail("Not Working Fine4"); } if (Sts &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newAction +
		 * "')]]//td[1]").getText().equals("Active"))) { } else if (!Sts &&
		 * (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + newAction +
		 * "')]]//td[1]").getText().equals("Inactive"))) { } else {
		 * Assert.fail("Not Working Fine5"); }
		 */
    }

    public void columnVerification() {
        for (int i = 0; i < arrActionFields.length; i++) {
            arrActionFields[i] = _webDriverHandler.byXpath("//table[@id='tblActionConfig']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblActionFields[i].equals(arrActionFields[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewActionField.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgAction.getText().equalsIgnoreCase(strErrorActionName) && msgField.getText().equals(strErrorNextStep) && msgFieldOrder.getText().equals(strErrorActionSLA)) {
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
