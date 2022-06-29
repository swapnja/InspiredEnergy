package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_Verify_ActionFields extends AbstractTestNg {

    public PR058_TC05_Verify_ActionFields() throws IOException {
    }

    @Test
    public void AccessActionFields() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
        //actionConfig.accessSettings();
        actionFields.accessActionConfig();
        actionFields.columnVerification();
        actionFields.createActionField("Automation Action Edit", "Testdfsdf", "25", true, true);
    }

    @Test
    public void EditActionFields() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
        actionFields.accessSettings();
        actionFields.accessActionConfig();
        actionFields.editActionField("Automation Action Edit", "Assign To Cust", "Enter Text Area", "3", false, true);
    }

    @Test
    public void Validations() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
        actionFields.accessSettings();
        actionFields.accessActionConfig();
        actionFields.errorValidation();
    }
}