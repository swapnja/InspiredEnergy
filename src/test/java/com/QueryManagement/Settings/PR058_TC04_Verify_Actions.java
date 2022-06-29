package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC04_Verify_Actions extends AbstractTestNg {

    public PR058_TC04_Verify_Actions() throws IOException {
    }
//Pass
    @Test
    public void AccessActions() {
        Actions actions = new Actions(webDriverHandler);
        //actions.accessSettings();
        actions.accessActions();
        actions.columnVerification();
        //actions.createAction("Automation Action", "Supplier", "Days from Action", "25", true, "Resolve for Customer", true, false);
       actions.createAction("Automation Action", "Licensee","Resolve for Customer", true);
    }
//pass
    @Test
    public void EditActions() {
        Actions actions = new Actions(webDriverHandler);
        //actions.accessSettings();
        actions.accessActions();
        actions.editAction("Automation Action", "Automation Action Edited", "Customer","Resolve for Customer", true);
    }
//Pass
    @Test
    public void Validations() {
        Actions actions = new Actions(webDriverHandler);
        //actions.accessSettings();
        actions.accessActions();
        actions.errorValidation();
    }
}
