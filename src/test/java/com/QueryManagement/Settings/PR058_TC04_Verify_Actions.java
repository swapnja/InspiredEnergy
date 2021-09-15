package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC04_Verify_Actions extends AbstractTestNg {

    public PR058_TC04_Verify_Actions() throws IOException {
    }

    @Test
    public void AccessActions() {
        Actions actions = new Actions(webDriverHandler);
        actions.accessSettings();
        actions.accessActions();
        actions.columnVerification();
        actions.createAction("Automation Action", "Supplier", "Days from Action", "25", true, "Resolve for Customer", true, false);
    }

    @Test
    public void EditActions() {
        Actions actions = new Actions(webDriverHandler);
        actions.accessSettings();
        actions.accessActions();
        actions.editAction("Automation Action", "Automation Action Edit", "Customer", "Days before Due Date", "6", false, "None", false, true);
    }

    @Test
    public void Validations() {
        Actions actions = new Actions(webDriverHandler);
        actions.accessSettings();
        actions.accessActions();
        actions.errorValidation();
    }
}
