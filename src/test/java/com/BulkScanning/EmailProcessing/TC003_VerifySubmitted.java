package com.BulkScanning.EmailProcessing;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.EmailProcessing.Submitted;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_VerifySubmitted extends AbstractTestNg {

    public TC003_VerifySubmitted() throws IOException {
    }

    @Test
    public void SubmittedTable() {
        Submitted submitted = new Submitted(webDriverHandler);
        submitted.accessSubmitted();
        submitted.loadSubmitted();
        submitted.columnVerification();
    }

    @Test
    public void SubmittedFilterApply() {
        Submitted submitted = new Submitted(webDriverHandler);
        submitted.accessSubmitted();
        submitted.filterSubmitted("Original Workflow", "2", "27", "63", "43");
        submitted.filterSubmitted("Assigned To", "IP Dev 2", "Rahul Dash", "Ankit Jain");
    }

    @Test
    public void SubmittedFilterReset() {
        Submitted submitted = new Submitted(webDriverHandler);
        submitted.accessSubmitted();
        submitted.filterSubmitted("Original Workflow", "2", "27", "63", "43");
        submitted.filterSubmitted("Assigned To", "IP Dev 2", "Rahul Dash", "Ankit Jain");
        submitted.filterReset();
    }

    @Test
    public void SubmittedActions() {
        Submitted submitted = new Submitted(webDriverHandler);
        submitted.accessSubmitted();
        submitted.viewChanges("27", "32");
        webDriverHandler.byXpath("//button[text()=' Back']").waitClickable().click();
        submitted.viewDocument("27", "32");
    }

    @Test
    public void SubmittedEdit() {
        Submitted submitted = new Submitted(webDriverHandler);
        submitted.accessSubmitted();
        submitted.viewChanges("27", "32");
        submitted.editVerify();
        submitted.columnVerificationPA();
        submitted.editDownload();
        submitted.editView();
        submitted.addComment("Comment For Submitted");
    }
}