package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.AwaitingEDI;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class TC001_VerifyAwaitingEDI extends AbstractTestNg {
    public TC001_VerifyAwaitingEDI() throws IOException {
    }
//Done
    @Test
    public void AwaitingEDITable() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.loadAwaitingEDI();
        awaitingEDI.columnVerification();
    }
  //Done
    @Test
    public void AwaitingEDIFilterApply() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
      //  awaitingEDI.filterAwaitingEDI("Parent", "Not Applicable");
        awaitingEDI.filterAwaitingEDI("Customer", "123344", "270 meters");
        awaitingEDI.filterAwaitingEDI("Supplier", "Test Chir", "");
    }
  //Done
    @Test
    public void AwaitingEDIFilterReset() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
     //  awaitingEDI.filterAwaitingEDI("Parent", "Not Applicable");
     //   awaitingEDI.filterAwaitingEDI("Customer", "B&M Retail", "Boardlink Ltd.");
     //   awaitingEDI.filterAwaitingEDI("Supplier", "BES", "CNG");
        awaitingEDI.filterAwaitingEDI("Customer", "123344", "270 meters");
        awaitingEDI.filterAwaitingEDI("Supplier", "Test Chir", "");
        awaitingEDI.filterReset();
        awaitingEDI.filterAwaitingEDI("Status", "EDI Chased", "Waiting for EDI");
        awaitingEDI.filterReset();
        awaitingEDI.filterAwaitingEDI("Assigned", "swapnja gudle", "satyajit gudle");
        awaitingEDI.filterReset();
    }
  //Done
    @Test
    public void AwaitingEDISearch() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.searchSchedules("The University of Manchester");
    }
  //Done
    @Test
    public void AwaitingEDIErrorValidations() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("11");
        awaitingEDI.errorValidations();
    }

    @Test
    public void AwaitingEDIVerifyEdit() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("11");
        awaitingEDI.verifyEdit();
    }

    @Test
    public void AwaitingEDIEdit() {
        AwaitingEDI awaitingEDI = new AwaitingEDI(webDriverHandler);
        awaitingEDI.accessAwaitingEDI();
        awaitingEDI.editSchedule("1593");
        awaitingEDI.downloadScanned();
        awaitingEDI.setAction("to@inspiredenergy.com", "cc@inspiredenergy.com", "Subject to be typed.", "Message to Type.");
        awaitingEDI.changeAssignment("Me");
        awaitingEDI.addComment("Comment for Awaiting EDI");
        awaitingEDI.setAction("Mark As Chased", "Chased Message");
        awaitingEDI.checkChaseHistory("Comment");
        awaitingEDI.checkChaseHistory("20/10/2021 10:48", "IP Dev 2", "Email");
    }

    @Test
    public void AwaitingEDIMoveTOmanual() {
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
    public void AwaitingEDIRetryMatch() {
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
        awaitingEDI.editSchedule("1593");
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