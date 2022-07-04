package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC06_Verify_SubCategoryFields extends AbstractTestNg {

    public PR058_TC06_Verify_SubCategoryFields() throws IOException {
    }
//pass
    @Test
    public void AccessSubCategoryFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
      //  subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.columnVerification();
        subCategoryFields.createSubCategoryField("Automation SubCategory 1", "Automation Field", "3",true, "Read/Write", "Read/Write",  true);
    }

	/*
	 * @Test public void CreateSubCategoryDateFields() { SubCategoryFields
	 * subCategoryFields = new SubCategoryFields(webDriverHandler); //
	 * subCategoryFields.accessSettings();
	 * subCategoryFields.accessSubCategoryFields();
	 * subCategoryFields.columnVerification();
	 * subCategoryFields.createSubCategoryField("Automation SubCategory1",
	 * "Automation Field", "3", true,"Read/Write", "Read/Write",true); }
	 */
//pass
    @Test
    public void EditSubCategoryFields() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
       // subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
  subCategoryFields.editSubCategoryField("Automation SubCategory","Automation SubCategory Edited","Automation Field Edited","33",true,"Read/Write","Read/Write",true);
    }


//Pass
    @Test
    public void Validations() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
     //   subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.errorValidation();
    }
}