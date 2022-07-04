package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC07_Verify_SubCategoryActions extends AbstractTestNg {

    public PR058_TC07_Verify_SubCategoryActions() throws IOException {
    }
//pass
    @Test
    public void AccessSubCategoryActions() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
       // subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.columnVerification();
        subCategoryActions.createSubCategoryAction("Automation SubCategory1", "Automation Action", true, "Days from Action" ,"25", true, true, true, true);
    }
//pass
    @Test
    public void EditSubCategoryActions() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
     //   subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.editSubCategoryAction("Automation", "Automation SubCategory Edited", "Automation Action",true, "Days from Action" ,"25", true, true, true, true);
    }
//pass
    @Test
    public void Validations() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
       // subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.errorValidation();
    }
}