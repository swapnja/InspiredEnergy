package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

public class PR058_TC02_Verify_Sub_Categories extends AbstractTestNg {

    public PR058_TC02_Verify_Sub_Categories() throws IOException{
    }
//Done
    @Test
    public void AccessSubCategories() throws InterruptedException {
        SubCategories subCategories = new SubCategories(webDriverHandler);
       // subCategories.accessSettings();
        subCategories.accessSubCategories();
        subCategories.columnVerification();

        Hashtable<String, Boolean> tglData = new Hashtable<>();     
        tglData.put("SR", true);
        tglData.put("UR", true);
        tglData.put("CA", true);        
        tglData.put("LA", true);
        tglData.put("DWD", true);
        tglData.put("AWD", true);
        tglData.put("Sts", true);
        	
        Hashtable<String, String> formData = new Hashtable<>();
        //need to change the Sun category every time to avoid the duplication
        formData.put("subCategoryName", "Automation SubCategory 5"); 
        formData.put("category", "Automation Category");   
        formData.put("defaultSummary","Automation test");
        formData.put("defaultAssign", "Test Manager"); 
        formData.put("nextStep", "Licensee");
        formData.put("defaultDueDate","45");
        formData.put("actionSLA", "Days before Due Date"); 
        formData.put("actionDate", "65");
        

        subCategories.createSubCategories(tglData, formData,"Customer");
    }

    @Test
    public void EditSubCategories() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
      //  subCategories.accessSettings();
        subCategories.accessSubCategories();

        Hashtable<String, Boolean> tglData = new Hashtable<>();
        tglData.put("SR", true);
        tglData.put("UR", true);
        tglData.put("CA", true);        
        tglData.put("LA", true);
        tglData.put("DWD", true);
        tglData.put("AWD", true);
        tglData.put("Sts", true);

        Hashtable<String, String> formData = new Hashtable<>();
        //need to change the Sun category every time to avoid the duplication
        formData.put("subCategoryName", "Automation SubCategory Edited"); 
        formData.put("category", "Automation Category");   
        formData.put("defaultSummary","Automation test");
        formData.put("defaultAssign", "Test Manager"); 
        formData.put("nextStep", "Licensee");
        formData.put("defaultDueDate","45");
        formData.put("actionSLA", "Days before Due Date"); 
        formData.put("actionDate", "65");

        subCategories.editSubCategories("Automation SubCategory 55", tglData, formData);
    }

    @Test
    public void Validations() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
      //  subCategories.accessSettings();
        subCategories.accessSubCategories();
        subCategories.errorValidation();
    }
}