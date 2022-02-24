package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.PendingSheets;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC04_Verify_Pending_Sheets extends AbstractTestNg {

    public PR163_TC04_Verify_Pending_Sheets() throws IOException {
    }

    @Test
    public void AccessPendingSheets() {
        PendingSheets pendingSheets = new PendingSheets(webDriverHandler);
        pendingSheets.accessAdminSettings();
        pendingSheets.accessPendingSheets();
        pendingSheets.verifyPendingSheets();
    }

    @Test
    public void checkPendingSheets() throws InterruptedException {
        PendingSheets pendingSheets = new PendingSheets(webDriverHandler);
        pendingSheets.checkpendingSheets("Power", "To_Be_Deleted.xlsx");
    }
}