package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.ReloadSheets;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC02_Verify_Reload_Sheets extends AbstractTestNg {
    public PR163_TC02_Verify_Reload_Sheets() throws IOException {
    }
//Done
    @Test
    public void AccessReloadSheets() {
        ReloadSheets reloadSheets = new ReloadSheets(webDriverHandler);
        reloadSheets.accessAdminSettings();
        reloadSheets.accessReloadSheets();
        reloadSheets.verifyReloadSheets();
    }
//Done
    @Test
    public void reloadSelectedSheets() {
        ReloadSheets reloadSheets = new ReloadSheets(webDriverHandler);
        reloadSheets.accessAdminSettings();
        reloadSheets.accessReloadSheets();
        reloadSheets.reloadSheet("Gas", "Axis-G-Axis 2018 Format.xlsx");
    }
}