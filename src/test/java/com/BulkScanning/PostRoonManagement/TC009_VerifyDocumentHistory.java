package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.DocumentHistory;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC009_VerifyDocumentHistory extends AbstractTestNg {
    
    public TC009_VerifyDocumentHistory() throws IOException {
    }

    @Test
    public void DocumentHistoryTable() {
        DocumentHistory documentHistory = new DocumentHistory(webDriverHandler);
        documentHistory.accessDocumentHistory();
        documentHistory.loadDocumentHistory();
        documentHistory.columnVerification();
    }

    @Test
    public void DocumentHistoryFilterApply() {
        DocumentHistory documentHistory = new DocumentHistory(webDriverHandler);
        documentHistory.accessDocumentHistory();
        documentHistory.filterDocumentHistory("Parent", "Not Applicable");
        documentHistory.filterDocumentHistory("Customer", "Ability Tec Ltd", "Airtricity");
        documentHistory.filterDocumentHistory("Supplier", "BES", "CNG");
    }

    @Test
    public void DocumentHistoryFilterReset() {
        DocumentHistory documentHistory = new DocumentHistory(webDriverHandler);
        documentHistory.accessDocumentHistory();
        documentHistory.filterDocumentHistory("Parent", "Not Applicable");
        documentHistory.filterDocumentHistory("Customer", "Ability Tec Ltd", "Airtricity");
        documentHistory.filterDocumentHistory("Supplier", "BES", "CNG   ");
        documentHistory.filterReset();
    }

    @Test
    public void DocumentHistorySearch() {
        DocumentHistory documentHistory = new DocumentHistory(webDriverHandler);
        documentHistory.accessDocumentHistory();
        documentHistory.searchSchedules("B&M Retail");
    }

    @Test
    public void DocumentHistoryEdit() {
        DocumentHistory documentHistory = new DocumentHistory(webDriverHandler);
        documentHistory.accessDocumentHistory();
        documentHistory.editSchedule("BPG Energy", "1390");
        documentHistory.downloadScanned();
        documentHistory.verifyEditPage();
    }
}