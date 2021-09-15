package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.DeleteSheets;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC03_Verify_Delete_Sheets extends AbstractTestNg {
    public PR163_TC03_Verify_Delete_Sheets() throws IOException {
    }

    @Test
    public void AccessDeleteSheets() {
        DeleteSheets deleteSheets = new DeleteSheets(webDriverHandler);
        deleteSheets.accessAdminSettings();
        deleteSheets.accessDeleteSheets();
        deleteSheets.verifyDeleteSheets();
    }

    @Test
    public void deleteSelectedSheets() {
        DeleteSheets deleteSheets = new DeleteSheets(webDriverHandler);
        deleteSheets.tariffLoad();
        deleteSheets.accessAdminSettings();
        deleteSheets.accessDeleteSheets();
        deleteSheets.deleteSheet("Power", "To_Be_Deleted.xlsx");
        deleteSheets.restoreDeletedFile("Power");
    }
}