package com.BulkScanning.MIReports;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.MIReports.EmailProcessingMI;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC001_VerifyEmailProcessingMI extends AbstractTestNg {
    public TC001_VerifyEmailProcessingMI() throws IOException {
    }

    @Test
    public void EmailProcessingMITable() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.loadEmailProcessingMI();
        emailProcessingMI.columnVerification();
    }

    @Test
    public void EmailProcessingMIFilterApply() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.filterEmailProcessingMI("Email", "anisha.mulik@cloudenergysoftware.com", "ankit.jain@cloudenergysoftware.com" );
        emailProcessingMI.filterEmailProcessingMI("Passed", "Y", "N");
    }

    @Test
    public void EmailProcessingMIFilterReset() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.filterEmailProcessingMI("Email", "anisha.mulik@cloudenergysoftware.com", "ankit.jain@cloudenergysoftware.com" );
        emailProcessingMI.filterEmailProcessingMI("Passed", "Y", "N");
        emailProcessingMI.filterReset();
        emailProcessingMI.filterEmailProcessingMI("Updated", "Anisha Mulik", "IP Dev 2");
        emailProcessingMI.filterByDate("Received", "1/05/2021", "19/08/2021");
        emailProcessingMI.filterReset();
        emailProcessingMI.filterByDate("Updated", "1/05/2021", "19/08/2021");
        emailProcessingMI.filterReset();
    }

    @Test
    public void EmailProcessingMIDateFilter() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.filterByDate("Received", "1/05/2021", "19/08/2021");
        emailProcessingMI.filterByDate("Updated", "1/05/2021", "19/08/2021");
    }

    @Test
    public void EmailProcessingMISearch() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.search("cloudenergysoftware");
    }

    @Test
    public void EmailProcessingMIExport() {
        EmailProcessingMI emailProcessingMI = new EmailProcessingMI(webDriverHandler);
        emailProcessingMI.accessEmailProcessingMI();
        emailProcessingMI.search("abhay.balgi@cloudenergysoftware.com");
        emailProcessingMI.exportExcel();
    }
}