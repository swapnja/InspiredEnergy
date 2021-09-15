package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC03_Verify_Billing extends AbstractTestNg {

    public PR058_TC03_Verify_Billing() throws IOException {
    }

    @Test
    public void accessCategory() {
        Billing billing = new Billing(webDriverHandler);
        billing.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Billing billing = new Billing(webDriverHandler);
        billing.accessCategory();
        billing.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        Billing billing = new Billing(webDriverHandler);
        billing.accessCategory();
        billing.verifySubCategory("AOE");
        billing.verifySubCategory("BH");
        billing.verifySubCategory("BQA");
        billing.verifySubCategory("IR");
        billing.verifySubCategory("IRT");
        billing.verifySubCategory("IRE");
    }
}
