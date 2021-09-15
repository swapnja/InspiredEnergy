package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC03_Verify_Fields extends AbstractTestNg {

    public PR058_TC03_Verify_Fields() throws IOException{
    }

    @Test
    public void AccessFields() {
        Fields fields = new Fields(webDriverHandler);
        fields.accessSettings();
        fields.accessFields();
        fields.columnVerification();
        fields.createFields("Automation Field", "Text", "The description that is required for this TB", true, false);
        Assert.fail();
    }

    @Test
    public void EditFields() {
        Fields fields = new Fields(webDriverHandler);
        fields.accessSettings();
        fields.accessFields();
        fields.editFields("Test Field", "Testdfsdf", "This is the new description for the field we created.", false, false);
    }

    @Test
    public void Validations() {
        Fields fields = new Fields(webDriverHandler);
        fields.accessSettings();
        fields.accessFields();
        fields.errorValidation();
    }
}