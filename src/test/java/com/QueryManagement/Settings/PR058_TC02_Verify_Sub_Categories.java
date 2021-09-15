package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

public class PR058_TC02_Verify_Sub_Categories extends AbstractTestNg {

    public PR058_TC02_Verify_Sub_Categories() throws IOException{
    }

    @Test
    public void AccessSubCategories() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
        subCategories.accessSettings();
        subCategories.accessSubCategories();
        subCategories.columnVerification();

        Hashtable<String, Boolean> tglData = new Hashtable<>();
        tglData.put("SR", true); tglData.put("UR", true); tglData.put("CA", true); tglData.put("SA", true); tglData.put("LA", true);
        tglData.put("GBL", true); tglData.put("DWD", true); tglData.put("AWD", true); tglData.put("Sts", true);

        Hashtable<String, String> formData = new Hashtable<>();
        formData.put("name", "Automation SubCategory"); formData.put("category", "Automation Category"); formData.put("defaultAssign", "Test Lead"); formData.put("nextStep", "Customer");
        formData.put("actionSLA", "Days before Due Date"); formData.put("dueDate", "45"); formData.put("actionDate", "65");

        subCategories.createSubCategories(tglData, formData,"Customer");
    }

    @Test
    public void EditSubCategories() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
        subCategories.accessSettings();
        subCategories.accessSubCategories();

        Hashtable<String, Boolean> tglData = new Hashtable<>();
        tglData.put("SR", false); tglData.put("UR", false); tglData.put("CA", false); tglData.put("SA", false); tglData.put("LA", false);
        tglData.put("GBL", false); tglData.put("DWD", false); tglData.put("AWD", false); tglData.put("Sts", false);

        Hashtable<String, String> formData = new Hashtable<>();
        formData.put("name", "Automation SubCategory"); formData.put("category", "Automation Category"); formData.put("defaultAssign", "Test Manager"); formData.put("nextStep", "Licensee");
        formData.put("actionSLA", "Days before Due Date"); formData.put("dueDate", "58"); formData.put("actionDate", "24");

        subCategories.editSubCategories("Automation SubCategory", tglData, formData,"Supplier", "Customer");
    }

    @Test
    public void CopySubCategories() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
        subCategories.accessSettings();
        subCategories.accessSubCategories();

        Hashtable<String, Boolean> tglData = new Hashtable<>();
        tglData.put("SR", false); tglData.put("UR", false); tglData.put("CA", false); tglData.put("SA", false); tglData.put("LA", false);
        tglData.put("GBL", false); tglData.put("DWD", false); tglData.put("AWD", false); tglData.put("Sts", false);

        Hashtable<String, String> formData = new Hashtable<>();
        formData.put("name", "Copied SubCategory"); formData.put("category", "Automation Category"); formData.put("defaultAssign", "Test Manager"); formData.put("nextStep", "Licensee");
        formData.put("actionSLA", "Days before Due Date"); formData.put("dueDate", "58"); formData.put("actionDate", "24");

        subCategories.copySubCategories("ToCopy SubCategory", tglData, formData,"Supplier", "Customer");
    }

    @Test
    public void Validations() {
        SubCategories subCategories = new SubCategories(webDriverHandler);
        subCategories.accessSettings();
        subCategories.accessSubCategories();
        subCategories.errorValidation();
    }
}