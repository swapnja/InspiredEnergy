package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC07_Verify_SubCategoryActions extends AbstractTestNg {

    public PR058_TC07_Verify_SubCategoryActions() throws IOException {
    }

    @Test
    public void AccessSubCategoryActions() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
        subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.columnVerification();
        subCategoryActions.createSubCategoryAction("Automation SubCategory", "Landlord Visit", true, true, true, true, true, true);
    }

    @Test
    public void EditSubCategoryActions() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
        subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.editSubCategoryAction("Automation SubCategory", "Automation SubCategory", "Landlord Visit", false, false, false, false, false, false);
    }

    @Test
    public void Validations() {
        SubCategoryActions subCategoryActions = new SubCategoryActions(webDriverHandler);
        subCategoryActions.accessSettings();
        subCategoryActions.accessSubCategoryActions();
        subCategoryActions.errorValidation();
    }
}