package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.InvoiceEntryIssues;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC005_VerifyInvoiceEntryIssues extends AbstractTestNg {

    public TC005_VerifyInvoiceEntryIssues() throws IOException {
    }

    @Test
    public void InvoiceEntryIssuesTable() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.loadInvoiceEntryIssues();
        invoiceEntryIssues.columnVerification();
    }

    @Test
    public void InvoiceEntryIssuesFilterApply() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.filterInvoiceEntryIssues("Parent", "Not Applicable");
        invoiceEntryIssues.filterInvoiceEntryIssues("Customer", "Voyage 1 Ltd", "Sheffield Teaching Hospitals NHS Foundation Trust");
        invoiceEntryIssues.filterInvoiceEntryIssues("Supplier", "BES", "CNG");
    }

    @Test
    public void InvoiceEntryIssuesFilterReset() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.filterInvoiceEntryIssues("Parent", "Boardlink Ltd.");
        invoiceEntryIssues.filterInvoiceEntryIssues("Customer", "Boardlink Ltd.");
        invoiceEntryIssues.filterInvoiceEntryIssues("Supplier", "BES", "CNG");
        invoiceEntryIssues.filterReset();
        invoiceEntryIssues.filterInvoiceEntryIssues("Status", "In Progress");
        invoiceEntryIssues.filterInvoiceEntryIssues("Assigned", "Ankit Jain", "Sweta ");
        invoiceEntryIssues.filterReset();
    }

    @Test
    public void InvoiceEntryIssuesSearch() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.searchSchedules("B&M Retail");
    }

    @Test
    public void InvoiceEntryIssuesErrorValidations() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.editSchedule("B&M Retail", "152");
        invoiceEntryIssues.errorValidations();
    }

    @Test
    public void InvoiceEntryIssuesVerifyEdit() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.editSchedule("B&M Retail", "151");
        invoiceEntryIssues.verifyEdit();
    }

    @Test
    public void InvoiceEntryIssuesEdit() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.editSchedule("B&M Retail", "152");
        invoiceEntryIssues.setAction("Set In Progress");
        invoiceEntryIssues.changeAssignment("Me");
        invoiceEntryIssues.addComment("Comment for Awaiting EDI");
        invoiceEntryIssues.setAction("Move to Manual Entry");
        invoiceEntryIssues.downloadScanned();
        invoiceEntryIssues.setAction("Not our customer", "To Do", "Not Needed comment.");
    }

    @Test
    public void InvoiceEntryIssuesMeta() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.editSchedule("B&M Retail", "151");
        invoiceEntryIssues.verifyMetaData();
        invoiceEntryIssues.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void InvoiceEntryIssuesBulkAction() {
        InvoiceEntryIssues invoiceEntryIssues = new InvoiceEntryIssues(webDriverHandler);
        invoiceEntryIssues.accessInvoiceEntryIssues();
        invoiceEntryIssues.setBulkAction("B&M Retail", "152", "IP Dev 2");
    }
}