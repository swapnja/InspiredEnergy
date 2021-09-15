package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC11_Verify_All extends AbstractTestNg {

    public PR058_TC11_Verify_All() throws IOException {
    }

    @Test
    public void accessCategory() {
        All all = new All(webDriverHandler);
        all.accessCategory();
    }

    @Test
    public void verifyCategory() {
        All all = new All(webDriverHandler);
        all.accessCategory();
        all.columnVerification();
    }
}