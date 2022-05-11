package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.HelpText;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC07_Verify_HelpText extends AbstractTestNg {


    public PR163_TC07_Verify_HelpText() throws IOException {
    }

    @Test
    public void AccessHelpText() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.verifyHelpText();
    }
//Done
    @Test
    public void addNewRow() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.addNewRow("Test Key", "Test Text");
    }
//Done
    @Test
    public void deleteRow() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.deleteRow("Test Key");
    }
//Done
    @Test
    public void editRow() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.addNewRow("Test Key", "Test Text");
        helpText.editRow("Test Key", "Test Key Edit","Test Edit");
        helpText.deleteRow("Test Key Edit");
    }
//Done
    @Test
    public void duplicateValidation() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.addDuplicate("Test Key", "Test Text");
    }
//Done
    @Test
    public void errorValidations() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.errorValidations();
    }
//Done
    @Test
    public void mandatoryValidations() {
        HelpText helpText = new HelpText(webDriverHandler);
        helpText.accessAdminSettings();
        helpText.accessHelpText();
        helpText.mandatoryValidations();
    }
}
