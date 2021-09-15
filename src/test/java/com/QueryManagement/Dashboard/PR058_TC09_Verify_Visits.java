package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC09_Verify_Visits extends AbstractTestNg {

    public PR058_TC09_Verify_Visits() throws IOException {
    }

    @Test
    public void accessCategory() {
        Visits visits = new Visits(webDriverHandler);
        visits.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Visits visits = new Visits(webDriverHandler);
        visits.accessCategory();
        visits.verifyCategory();
    }

    @Test
    public void verifySubCat()  {
        Visits visits = new Visits(webDriverHandler);
        visits.accessCategory();
        visits.verifySubCategory("LV");
        visits.verifySubCategory("MV");
    }
}
