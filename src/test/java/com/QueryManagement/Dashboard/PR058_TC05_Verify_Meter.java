package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_Verify_Meter extends AbstractTestNg {

    public PR058_TC05_Verify_Meter() throws IOException {
    }

    @Test
    public void accessCategory() {
        Meter meter = new Meter(webDriverHandler);
        meter.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Meter meter = new Meter(webDriverHandler);
        meter.accessCategory();
        meter.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        Meter meter = new Meter(webDriverHandler);
        meter.accessCategory();
        meter.verifySubCategory("ME");
        meter.verifySubCategory("MR");
        meter.verifySubCategory("MRE");
        meter.verifySubCategory("NMA");
        meter.verifySubCategory("ZU");
    }
}