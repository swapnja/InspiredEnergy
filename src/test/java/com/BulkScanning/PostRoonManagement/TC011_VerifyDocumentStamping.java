package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.AwaitingEDI;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC011_VerifyDocumentStamping extends AbstractTestNg {

    public TC011_VerifyDocumentStamping() throws IOException {
    }

    @Test
    public void AwaitingEDITable() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.loadAwaitingEDI();
        awaitingEDI.columnVerification();
    }

    @Test
    public void AwaitingEDIFilterApply() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.filterAwaitingEDI("Parent", "Not Applicable");
        awaitingEDI.filterAwaitingEDI("Customer", "B&M Retail", "Boardlink Ltd.");
        awaitingEDI.filterAwaitingEDI("Supplier", "BES", "CNG");
    }

    @Test
    public void AwaitingEDIFilterReset() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.filterAwaitingEDI("Parent", "Not Applicable");
        awaitingEDI.filterAwaitingEDI("Customer", "B&M Retail", "Boardlink Ltd.");
        awaitingEDI.filterAwaitingEDI("Supplier", "BES", "CNG");
        awaitingEDI.filterReset();
        awaitingEDI.filterAwaitingEDI("Status", "EDI Chased", "Waiting for EDI");
        awaitingEDI.filterReset();
        awaitingEDI.filterAwaitingEDI("Assigned", "Ankit Jain", "Sweta ");
        awaitingEDI.filterReset();
    }

    @Test
    public void AwaitingEDISearch() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.searchSchedules("The University of Manchester");
    }

    @Test
    public void AwaitingEDIErrorValidations() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("131");
        awaitingEDI.errorValidations();
    }

    @Test
    public void AwaitingEDIVerifyEdit() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("131");
        awaitingEDI.verifyEdit();
    }

    @Test
    public void AwaitingEDIEdit() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("259");
        awaitingEDI.downloadScanned();
        awaitingEDI.setAction("to@inspiredenergy.com", "cc@inspiredenergy.com", "Subject to be typed.", "Message to Type.");
        awaitingEDI.changeAssignment("Me");
        awaitingEDI.addComment("Comment for Awaiting EDI");
        awaitingEDI.setAction("Mark As Chased", "Chased Message");
        awaitingEDI.checkChaseHistory("Comment");
        awaitingEDI.checkChaseHistory("01/08/2021 16:15", "IP Dev 2", "Email");
    }

    @Test
    public void AwaitingEDIMeta() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("259");
        awaitingEDI.verifyMetaData();
        awaitingEDI.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void AwaitingEDIBulkAction() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.setBulkAction("Bulk Retry Match","Hanover (Scotland) Housing Association Ltd", "123");
    }
}
