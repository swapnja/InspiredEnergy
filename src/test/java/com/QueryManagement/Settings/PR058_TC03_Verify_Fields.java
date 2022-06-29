package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC03_Verify_Fields extends AbstractTestNg {

    public PR058_TC03_Verify_Fields() throws IOException{
    }
//Pass
    @Test
    public void AccessFields() {
        Fields fields = new Fields(webDriverHandler);
      //  fields.accessSettings();
        fields.accessFields();
        fields.columnVerification();
        //fields.createFields("Automation Field", "Text", "The description that is required for to test thh Field functionality",true, false);
        //marking status false to true to make teh status as Active
        fields.createFields("Automation Field", "Text", "The description that is required for to test the Field functionality","Automation Tool-tip", true);
        //Assert.fail();
    }
//Pass
    @Test
    public void EditFields() {
        Fields fields = new Fields(webDriverHandler);
       // fields.accessSettings();
        fields.accessFields();
        fields.editFields("Automation Field", "Automation Field Edited", "This is the new description for the field we created.", "Automation Tool-tip Edit", true);
    }
//Pass
    @Test
    public void Validations() {
        Fields fields = new Fields(webDriverHandler);
       // fields.accessSettings();
        fields.accessFields();
        fields.errorValidation();
    }
}