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
     //   subCategoryFields.createSubCategoryField("Automation SubCategory", "Automation Field Edited", "3", true,"Read/Write", "Read/Write",true);
       //subCategoryFields.editSubCategoryField("Automation SubCategory", "ML Test", "Automation SubCategory", "Enter Text Area", "3", "Read/Write", "None", "Read Only", false, true, false);
       subCategoryFields.editSubCategoryField("Automation SubCategory","Automation SubCategory Edited","Automation Field Edited","33",true,"Read/Write","Read/Write",true);
    }

	/*
	 * @Test public void EditSubCategoryDateFields() { SubCategoryFields
	 * subCategoryFields = new SubCategoryFields(webDriverHandler);
	 * subCategoryFields.accessSettings();
	 * subCategoryFields.accessSubCategoryFields();
	 * subCategoryFields.columnVerification();
	 * //subCategoryFields.editSubCategoryField("Automation SubCategory",
	 * "Enter Date Time", "Automation SubCategory", "Enter Date Time", "5",
	 * "Read/Write", "Read Only", "None", true, true, true, false, false);
	 * subCategoryFields.editSubCategoryField("Automation SubCategory",
	 * "Enter Date", "Automation SubCategory", "Enter Date Time", "5", "Read/Write",
	 * "Read Only", "None", true, true, true, true, false); }
	 */
//Pass
    @Test
    public void Validations() {
        SubCategoryFields subCategoryFields = new SubCategoryFields(webDriverHandler);
     //   subCategoryFields.accessSettings();
        subCategoryFields.accessSubCategoryFields();
        subCategoryFields.errorValidation();
    }
}