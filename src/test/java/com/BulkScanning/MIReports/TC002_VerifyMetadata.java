package com.BulkScanning.MIReports;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.MIReports.Metadata;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_VerifyMetadata extends AbstractTestNg {
    public TC002_VerifyMetadata() throws IOException {
    }

    @Test
    public void MetadataTable() {
        Metadata metadata = new Metadata(webDriverHandler);
        metadata.accessMetadata();
        metadata.loadMetadata();
        metadata.columnVerification();
    }

    @Test
    public void MetadataDateFilter() {
        Metadata metadata = new Metadata(webDriverHandler);
        metadata.accessMetadata();
        metadata.filterByDate("1/05/2021", "19/08/2021");
    }

    @Test
    public void MetadataFilterReset() {
        Metadata metadata = new Metadata(webDriverHandler);
        metadata.accessMetadata();
        metadata.filterByDate("1/05/2021", "19/08/2021");
        metadata.filterReset();
    }

    @Test
    public void MetadataSearch() {
        Metadata metadata = new Metadata(webDriverHandler);
        metadata.accessMetadata();
        metadata.search("AG00145160");
    }

    @Test
    public void MetadataExport() {
        Metadata metadata = new Metadata(webDriverHandler);
        metadata.accessMetadata();
        metadata.search("Supplier");
        metadata.exportExcel();
    }
}