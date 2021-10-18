package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.OtherDocumentEntry;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC004_VerifyOtherDocumentEntry extends AbstractTestNg {

    public TC004_VerifyOtherDocumentEntry() throws IOException {
    }

    @Test
    public void OtherDocumentEntryTable() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.loadOtherDocumentEntry();
        otherDocumentEntry.columnVerification();
    }

    @Test
    public void OtherDocumentEntryFilterApply() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.filterOtherDocumentEntry("Parent", "Not Applicable");
        otherDocumentEntry.filterOtherDocumentEntry("Customer", "B&M Retail", "Emerson Management Services Ltd");
        otherDocumentEntry.filterOtherDocumentEntry("Supplier", "BES", "CNG");
    }

    @Test
    public void OtherDocumentEntryFilterReset() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.filterOtherDocumentEntry("Parent", "Boardlink Ltd.");
        otherDocumentEntry.filterOtherDocumentEntry("Customer", "Boardlink Ltd.");
        otherDocumentEntry.filterOtherDocumentEntry("Supplier", "BES", "CNG");
        otherDocumentEntry.filterReset();
        otherDocumentEntry.filterOtherDocumentEntry("Document", "CHEQUE REFUND", "PAYMENT REMINDER");
        otherDocumentEntry.filterOtherDocumentEntry("Status", "New", "In Progress");
        otherDocumentEntry.filterReset();
        otherDocumentEntry.filterOtherDocumentEntry("Assigned", "Ankit Jain", "Sweta ");
    }

    @Test
    public void OtherDocumentEntrySearch() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.searchSchedules("Boardlink Ltd.");
    }

    @Test
    public void OtherDocumentEntryErrorValidations() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.editSchedule("B&M Retail", "356");
        otherDocumentEntry.errorValidations();
    }

    @Test
    public void OtherDocumentEntryVerifyEdit() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.editSchedule("B&M Retail", "356");
        otherDocumentEntry.verifyEdit();
    }


    @Test
    public void OtherDocumentEntryEdit() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.editSchedule("B&M Retail", "356");
        otherDocumentEntry.changeAssignment("Me");
        otherDocumentEntry.setAction("Set In Progress");
        otherDocumentEntry.addComment("Comment for Awaiting EDI");
        otherDocumentEntry.downloadScanned();
        otherDocumentEntry.setAction("Not our customer", "To Do", "Not Needed comment.");
    }

    @Test
    public void OtherDocumentEntryMeta() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.editSchedule("B&M Retail", "356");
        otherDocumentEntry.verifyMetaData();
        otherDocumentEntry.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void OtherDocumentEntryBulkAction() {
        OtherDocumentEntry otherDocumentEntry = new OtherDocumentEntry(webDriverHandler);
        otherDocumentEntry.accessOtherDocumentEntry();
        otherDocumentEntry.setBulkAction("B&M Retail", "356", "IP Dev 2");
    }
}
