package com.BulkScanning.MIReports;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.MIReports.SplitDocuments;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_SplitDocuments extends AbstractTestNg {
    public TC003_SplitDocuments() throws IOException {
    }

    @Test
    public void SplitDocumentsTable() {
        SplitDocuments splitDocuments = new SplitDocuments(webDriverHandler);
        splitDocuments.accessSplitDocuments();
        splitDocuments.loadSplitDocuments();
        splitDocuments.columnVerification();
    }

    @Test
    public void SplitDocumentsDateFilter() {
        SplitDocuments splitDocuments = new SplitDocuments(webDriverHandler);
        splitDocuments.accessSplitDocuments();
        splitDocuments.filterByDate("1/05/2021", "19/08/2021");
    }

    @Test
    public void SplitDocumentsFilterReset() {
        SplitDocuments splitDocuments = new SplitDocuments(webDriverHandler);
        splitDocuments.accessSplitDocuments();
        splitDocuments.filterByDate("1/05/2021", "19/08/2021");
        splitDocuments.filterReset();
    }

    @Test
    public void SplitDocumentsSearch() {
        SplitDocuments splitDocuments = new SplitDocuments(webDriverHandler);
        splitDocuments.accessSplitDocuments();
        splitDocuments.search("LGWJQMSM");
    }

    @Test
    public void SplitDocumentsExport() {
        SplitDocuments splitDocuments = new SplitDocuments(webDriverHandler);
        splitDocuments.accessSplitDocuments();
        splitDocuments.search("STATEMENT OF ACCOUNT");
        splitDocuments.exportExcel();
    }
}