package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC06_Verify_MissingData extends AbstractTestNg {

    public PR058_TC06_Verify_MissingData() throws IOException {
    }

    @Test
    public void accessCategory() {
        MissingData missingData = new MissingData(webDriverHandler);
        missingData.accessCategory();
    }

    @Test
    public void verifyCategory() {
        MissingData missingData = new MissingData(webDriverHandler);
        missingData.accessCategory();
        missingData.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        MissingData missingData = new MissingData(webDriverHandler);
        missingData.accessCategory();
        missingData.verifySubCategory("CI");
        missingData.verifySubCategory("EN");
        missingData.verifySubCategory("EC");
        missingData.verifySubCategory("HHD");
        missingData.verifySubCategory("MR");
        missingData.verifySubCategory("MI");
    }
}