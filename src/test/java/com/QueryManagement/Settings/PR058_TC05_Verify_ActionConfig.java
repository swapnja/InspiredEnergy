package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_Verify_ActionConfig extends AbstractTestNg {

    public PR058_TC05_Verify_ActionConfig() throws IOException {
    }

    @Test
    public void AccessActionConfig() {
        ActionConfig actionConfig = new ActionConfig(webDriverHandler);
        actionConfig.accessSettings();
        actionConfig.accessActionConfig();
        actionConfig.columnVerification();
        actionConfig.createActionField("Automation Action Edit", "Testdfsdf", "25", true, true);
    }

    @Test
    public void EditActionConfig() {
        ActionConfig actionConfig = new ActionConfig(webDriverHandler);
        actionConfig.accessSettings();
        actionConfig.accessActionConfig();
        actionConfig.editActionField("Automation Action Edit", "Assign To Cust", "Enter Text Area", "3", false, true);
    }

    @Test
    public void Validations() {
        ActionConfig actionConfig = new ActionConfig(webDriverHandler);
        actionConfig.accessSettings();
        actionConfig.accessActionConfig();
        actionConfig.errorValidation();
    }
}