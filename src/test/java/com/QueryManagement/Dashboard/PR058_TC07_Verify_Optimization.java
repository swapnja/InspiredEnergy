package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC07_Verify_Optimization extends AbstractTestNg {

    public PR058_TC07_Verify_Optimization() throws IOException {
    }

    @Test
    public void accessCategory() {
        Optimization optimization = new Optimization(webDriverHandler);
        optimization.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Optimization optimization = new Optimization(webDriverHandler);
        optimization.accessCategory();
        optimization.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        Optimization optimization = new Optimization(webDriverHandler);
        optimization.accessCategory();
        optimization.verifySubCategory("PA");
        optimization.verifySubCategory("PM");
        optimization.verifySubCategory("PF");
        optimization.verifySubCategory("SS");
    }
}