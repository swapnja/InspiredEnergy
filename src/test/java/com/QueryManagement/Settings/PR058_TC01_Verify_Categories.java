//QMP
package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC01_Verify_Categories extends AbstractTestNg {

    public PR058_TC01_Verify_Categories() throws IOException{
    }

    @Test
    public void AccessCategories() {
        Categories categories = new Categories(webDriverHandler);
        categories.accessSettings();
        categories.accessCategories();
        categories.columnVerification();
        categories.createCategories("Automation Category", false, true, false, true, false);
    }

    @Test
    public void EditCategories() {
        Categories categories = new Categories(webDriverHandler);
        categories.accessSettings();
        categories.accessCategories();
        categories.editCategories("Automation Category", "Automation Category New", false, false, false, false, false);
    }

    @Test
    public void Validations() {
        Categories categories = new Categories(webDriverHandler);
        categories.accessSettings();
        categories.accessCategories();
        categories.errorValidation();
    }
}