package com.BulkScanning.EmailProcessing;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.EmailProcessing.EmailProcessing;
import com.BulkScanning.PageObject.PostRoomManagement.AwaitingEDI;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC001_VerifyEmailProcessing extends AbstractTestNg {

    public TC001_VerifyEmailProcessing() throws IOException {
    }

    @Test
    public void EmailProcessingTable() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.loadEmailProcessing();
        emailProcessing.columnVerification();
    }

    @Test
    public void EmailProcessingFilterApply() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.filterEmailProcessing("From", "email@email.com", "anisha.mulik@cloudenergysoftware.com");
        emailProcessing.filterEmailProcessing("Priority", "High");
    }

    @Test
    public void EmailProcessingFilterReset() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.filterEmailProcessing("From", "email@email.com", "anisha.mulik@cloudenergysoftware.com");
        emailProcessing.filterEmailProcessing("Assigned", "IP Dev 2", "Ankit Jain", "0Anisha Mulik");
        emailProcessing.filterReset();
        emailProcessing.filterEmailProcessing("Status", "New", "Return To Sender");
        emailProcessing.filterReset();
    }

    @Test
    public void EmailProcessingSearch() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.searchSchedules("ankit.jain@cloudenergysoftware.com");
    }

    @Test
    public void EmailProcessingErrorValidation() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.editSchedule("74");
        emailProcessing.errorValidations();
    }

    @Test
    public void EmailProcessingEdit() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.editSchedule("74");
        emailProcessing.verifyEdit();
        //emailProcessing.setAction("to@inspiredenergy.com", "cc@inspiredenergy.com", "Subject to be typed.", "Message to Type.");
        //emailProcessing.changeAssignment("Me");
        //emailProcessing.addComment("Comment for Email Processing");
        emailProcessing.view("Merged 10-05.pdf");
        emailProcessing.send("Merged 10-10.pdf");
        //emailProcessing.setAction("Mark As Chased", "Chased Message");
    }

    @Test
    public void EmailProcessingReturn() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.editSchedule("74");
        emailProcessing.verifyEdit();
        //emailProcessing.setAction("to@inspiredenergy.com", "cc@inspiredenergy.com", "Subject to be typed.", "Message to Type.");
        //emailProcessing.changeAssignment("Me");
        //emailProcessing.addComment("Comment for Email Processing");
        emailProcessing.view("Merged 10-05.pdf");
        emailProcessing.send("Merged 10-10.pdf");
        //emailProcessing.setAction("Mark As Chased", "Chased Message");
    }

    @Test
    public void EmailProcessingBulkAction() {
        EmailProcessing emailProcessing = new EmailProcessing(webDriverHandler);
        emailProcessing.accessEmailProcessing();
        emailProcessing.setBulkAssignee("ankit.jain@cloudenergysoftware.com", "30", "IP Dev 2");
    }
}