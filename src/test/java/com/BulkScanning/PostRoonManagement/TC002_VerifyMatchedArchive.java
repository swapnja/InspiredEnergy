package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.MatchedArchive;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_VerifyMatchedArchive extends AbstractTestNg {
    public TC002_VerifyMatchedArchive() throws IOException {
    }

    @Test
    public void MatchedArchiveTable() {
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.loadMatchedArchive();
        matchedArchive.columnVerification();
    }

    @Test
    public void MatchedArchiveFilterApply() {
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.filterMatchedArchive("Parent", "Not Applicable");
        matchedArchive.filterMatchedArchive("Customer", "Gentoo Group Ltd", "Voyage 1 Ltd");
        matchedArchive.filterMatchedArchive("Supplier", "BES", "CNG");
    }

    @Test
    public void MatchedArchiveFilterReset() {
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.filterMatchedArchive("Parent", "Boardlink Ltd.");
        matchedArchive.filterMatchedArchive("Customer", "Boardlink Ltd.");
        matchedArchive.filterMatchedArchive("Supplier", "BES", "CNG");
        matchedArchive.filterReset();
    }

    @Test
    public void MatchedArchiveSearch() {
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.searchSchedules("B&M Retail");
    }

    @Test
<<<<<<< HEAD
    public void ManualInvoiceEntryEdit() {
=======
    public void MatchedArchiveVerifyEdit() {
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.editSchedule("166");
        matchedArchive.verifyEdit();
    }

    @Test
    public void MatchedArchiveEdit() {
>>>>>>> f994a02fbb38f9d0e1b587dbedd317a32c117924
        MatchedArchive matchedArchive = new MatchedArchive(webDriverHandler);
        matchedArchive.accessMatchedArchive();
        matchedArchive.editSchedule("166");
        matchedArchive.downloadScanned();
        matchedArchive.verifyMetaData();
    }
}
