package com.BulkScanning.EmailProcessing;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.EmailProcessing.QualityAssurance;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_VerifyQualityAssurance extends AbstractTestNg {

    public TC002_VerifyQualityAssurance() throws IOException {
    }

    @Test
    public void QualityAssuranceTable() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        qualityAssurance.loadQualityAssurance();
        qualityAssurance.columnVerification();
    }

    @Test
    public void QualityAssuranceFilterApply() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        qualityAssurance.filterQualityAssurance("Original Workflow", "2", "27", "48", "63");
        qualityAssurance.filterQualityAssurance("Assigned To", "IP Dev 2", "Rahul Dash", "Ankit Jain");
    }

    @Test
    public void QualityAssuranceFilterReset() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        qualityAssurance.filterQualityAssurance("Original Workflow", "2", "27", "48", "63");
        qualityAssurance.filterQualityAssurance("Assigned To", "IP Dev 2", "Rahul Dash", "Ankit Jain");
        qualityAssurance.filterReset();
    }

    @Test
    public void QualityAssuranceBulkAction() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        //qualityAssurance.setBulkAction("79", "79", "Approve");
    }

    @Test
    public void QualityAssuranceActions() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        qualityAssurance.viewChanges("76", "164");
        webDriverHandler.byXpath("//button[text()=' Back']").waitClickable().click();
        qualityAssurance.viewDocument("76", "164");
        //qualityAssurance.approve("76", "164");
        //qualityAssurance.reject("76", "164");
    }

    @Test
    public void QualityAssuranceEdit() {
        QualityAssurance qualityAssurance = new QualityAssurance(webDriverHandler);
        qualityAssurance.accessQualityAssurance();
        qualityAssurance.viewChanges("76", "164");
        qualityAssurance.editVerify();
        qualityAssurance.columnVerificationPA();
        qualityAssurance.editDownload();
        qualityAssurance.editView();
        qualityAssurance.addComment("Comment For Quality Assurance");
    }
}