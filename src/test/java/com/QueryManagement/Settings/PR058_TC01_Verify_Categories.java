//QMP TC01->Category test case is passed
package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC01_Verify_Categories extends AbstractTestNg {

    public PR058_TC01_Verify_Categories() throws IOException{
    }
//pass
    @Test
    public void AccessCategories() throws InterruptedException {
        Categories categories = new Categories(webDriverHandler);
     // categories.accessSettings();
        categories.accessCategories();
     
        categories.columnVerification();
        categories.createCategories("Automation Category", true, true, true);
    }
//pass
    @Test
    public void EditCategories() {
        Categories categories = new Categories(webDriverHandler);
    //    categories.accessSettings();
        categories.accessCategories();
        categories.editCategories("Automation Category", "Automation Category New",  true, true, true);
    }
//Pass
    @Test
    public void Validations() {
        Categories categories = new Categories(webDriverHandler);
  
        categories.accessCategories();
        categories.errorValidation();
    }
}