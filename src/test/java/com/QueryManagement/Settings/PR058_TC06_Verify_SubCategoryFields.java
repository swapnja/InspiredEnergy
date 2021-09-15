package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC06_Verify_SubCategoryFields extends AbstractTestNg {

    public PR058_TC06_Verify_SubCategoryFields() throws IOException {
    }

    @Test
    public void AccessSubCategoryFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
        subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.columnVerification();
        subCategoryFields.createSubCategoryField("Automation SubCategory", "ML Test", "3", "None", "Read Only", "Read/Write", true, true, true);
    }

    @Test
    public void CreateSubCategoryDateFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
        subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.columnVerification();
        subCategoryFields.createSubCategoryField("Automation SubCategory", "Enter Date", "3",  "Read Only", "Read/Write", "None", true, true, true, true, true);
    }

    @Test
    public void EditSubCategoryFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
        subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.editSubCategoryField("Automation SubCategory", "Enter Text Area", "Automation SubCategory", "ML Test", "3", "None", "Read Only", "Read/Write", true, true, true);
        //subCategoryFields.editSubCategoryField("Automation SubCategory", "ML Test", "Automation SubCategory", "Enter Text Area", "3", "Read/Write", "None", "Read Only", false, true, false);
    }

    @Test
    public void EditSubCategoryDateFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
        subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.columnVerification();
        //subCategoryFields.editSubCategoryField("Automation SubCategory", "Enter Date Time", "Automation SubCategory", "Enter Date Time", "5", "Read/Write", "Read Only", "None", true, true, true, false, false);
        subCategoryFields.editSubCategoryField("Automation SubCategory", "Enter Date", "Automation SubCategory", "Enter Date Time", "5", "Read/Write", "Read Only", "None", true, true, true, true, false);
    }

    @Test
    public void Validations() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
        subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.errorValidation();
    }
}