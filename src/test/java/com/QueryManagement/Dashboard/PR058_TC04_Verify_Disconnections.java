package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC04_Verify_Disconnections extends AbstractTestNg {

    public PR058_TC04_Verify_Disconnections() throws IOException {
    }

    @Test
    public void accessCategory() {
        Disconnections Disconnections = new Disconnections(webDriverHandler);
        Disconnections.accessCategory();
    }

    @Test
    public void verifyCategory() {
        Disconnections Disconnections = new Disconnections(webDriverHandler);
        Disconnections.accessCategory();
        Disconnections.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        Disconnections Disconnections = new Disconnections(webDriverHandler);
        Disconnections.accessCategory();
        Disconnections.verifySubCategory("LR");
        Disconnections.verifySubCategory("MC");
        Disconnections.verifySubCategory("PF");
        Disconnections.verifySubCategory("SV");
    }
}
