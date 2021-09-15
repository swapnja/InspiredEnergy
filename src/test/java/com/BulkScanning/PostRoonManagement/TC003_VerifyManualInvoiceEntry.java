package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.ManualInvoiceEntry;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_VerifyManualInvoiceEntry extends AbstractTestNg {
    public TC003_VerifyManualInvoiceEntry() throws IOException {
    }

    @Test
    public void ManualInvoiceEntryTable() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.loadManualInvoiceEntry();
        manualInvoiceEntry.columnVerification();
    }

    @Test
    public void ManualInvoiceEntryFilterApply() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.filterManualInvoiceEntry("Parent", "Not Applicable");
        manualInvoiceEntry.filterManualInvoiceEntry("Customer", "Emerson Management Services Ltd", "The University of Manchester");
        manualInvoiceEntry.filterManualInvoiceEntry("Supplier", "BES", "CNG");
    }

    @Test
    public void ManualInvoiceEntryFilterReset() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.filterManualInvoiceEntry("Parent", "Boardlink Ltd.");
        manualInvoiceEntry.filterManualInvoiceEntry("Customer", "Boardlink Ltd.");
        manualInvoiceEntry.filterManualInvoiceEntry("Supplier", "BES", "CNG");
        manualInvoiceEntry.filterReset();
        manualInvoiceEntry.filterManualInvoiceEntry("Status", "New", "Done");
        manualInvoiceEntry.filterReset();
        manualInvoiceEntry.filterManualInvoiceEntry("Assigned", "Ankit Jain", "Sweta ");
        manualInvoiceEntry.filterReset();
    }

    @Test
    public void ManualInvoiceEntrySearch() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.searchSchedules("B&M Retail");
    }

    @Test
    public void ManualInvoiceEntryErrorValidations() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.editSchedule("B&M Retail", "333");
        manualInvoiceEntry.errorValidations();
    }

    @Test
    public void ManualInvoiceEntryVerifyEdit() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.editSchedule("B&M Retail", "333");
        manualInvoiceEntry.verifyEdit();
    }

    @Test
    public void ManualInvoiceEntryEdit() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.editSchedule("B&M Retail", "333");
        manualInvoiceEntry.changeAssignment("Ankit Jain");
        manualInvoiceEntry.addComment("Comment for Manual Entry");
        manualInvoiceEntry.downloadScanned();
        manualInvoiceEntry.setAction("Refer to Data Analyst", "Message Refer to Data");
        manualInvoiceEntry.setAction("Send to Can't Input", "Message Can't Input");
        manualInvoiceEntry.setAction("Set In Progress");
    }

    @Test
    public void ManualInvoiceMeta() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.editSchedule("B&M Retail", "333");
        manualInvoiceEntry.verifyMetaData();
        manualInvoiceEntry.editMetaData("INVOICE", "", "", "", "", "", "Water");
    }

    @Test
    public void ManualInvoiceBulkAction() {
        ManualInvoiceEntry manualInvoiceEntry = new ManualInvoiceEntry(webDriverHandler);
        manualInvoiceEntry.accessManualInvoiceEntry();
        manualInvoiceEntry.filterManualInvoiceEntry("Parent", "Not Applicable");
        manualInvoiceEntry.filterManualInvoiceEntry("Customer", "B&M Retail");
        manualInvoiceEntry.filterManualInvoiceEntry("Supplier", "Wave");
        manualInvoiceEntry.setBulkAction("IP Dev 2");
    }
}
