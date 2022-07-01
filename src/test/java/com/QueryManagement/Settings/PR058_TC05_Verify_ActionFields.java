package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_Verify_ActionFields extends AbstractTestNg {

    public PR058_TC05_Verify_ActionFields() throws IOException {
    }
//Pass
    @Test
    public void AccessActionFields() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
        //actionConfig.accessSettings();
        actionFields.accessActionField();
        actionFields.columnVerification();
        actionFields.createActionField("Automation Action", "Automation Field", "25", true, true);
    }
//Pass
    @Test
    public void EditActionFields() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
       // actionFields.accessSettings();
        actionFields.accessActionField();
        actionFields.editActionField("Automation Action", "Automation Field",  "3", false, true);
    }
//Pass
    @Test
    public void Validations() {
    	ActionFields actionFields = new ActionFields(webDriverHandler);
       // actionFields.accessSettings();
        actionFields.accessActionField();
        actionFields.errorValidation();
    }
}