package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;


public class PR058_TC02_Verify_Accounting extends AbstractTestNg {

    public PR058_TC02_Verify_Accounting() throws IOException {
    }

    @Test
    public void accessCategory() {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
        accounting.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
        accounting.verifySubCategory("ADR");
        accounting.verifySubCategory("AQ");
        accounting.verifySubCategory("DO");
        accounting.verifySubCategory("PR");
    }
}
