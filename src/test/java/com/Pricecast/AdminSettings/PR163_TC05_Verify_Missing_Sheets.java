package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.MissingSheets;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC05_Verify_Missing_Sheets extends AbstractTestNg {

    public PR163_TC05_Verify_Missing_Sheets() throws IOException {
    }
//Done
    @Test
    public void AccessMissingSheets() {
        MissingSheets missingSheets = new MissingSheets(webDriverHandler);
        missingSheets.accessAdminSettings();
        missingSheets.accessMissingSheets();
        missingSheets.verifyMissingSheets();
    }
//Done
    @Test
    public void checkMissingSheets() {
        MissingSheets missingSheets = new MissingSheets(webDriverHandler);
     //   missingSheets.tariffLoad();
    //   missingSheets.checkMissingSheets();
    }
}
