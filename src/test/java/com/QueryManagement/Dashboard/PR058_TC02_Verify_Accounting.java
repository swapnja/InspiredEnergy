package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;


public class PR058_TC02_Verify_Accounting extends AbstractTestNg {

    public PR058_TC02_Verify_Accounting() throws IOException {
    }
//Pass
    @Test
    public void accessCategory() {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
    }
//pass
    @Test
    public void verifyCategory() throws InterruptedException {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
        accounting.verifyCategory();
    }
//Pass
    @Test
    public void verifySubCat() {
        Accounting accounting = new Accounting(webDriverHandler);
        accounting.accessCategory();
        accounting.verifySubCategory("Account2");
        accounting.verifySubCategory("Account3");
        accounting.verifySubCategory("Account Details");

    }
}
