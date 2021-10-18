package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.DuplicateDocuments;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC006_VerifyDuplicateDocuments extends AbstractTestNg {

    public TC006_VerifyDuplicateDocuments() throws IOException {
    }

    @Test
    public void DuplicateDocumentsTable() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.loadDuplicateDocuments();
        duplicateDocuments.columnVerification();
    }

    @Test
    public void DuplicateDocumentsFilterApply() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.filterDuplicateDocuments("Parent", "Not Applicable");
        duplicateDocuments.filterDuplicateDocuments("Customer", "B&M Retail", "Boardlink Ltd.");
        duplicateDocuments.filterDuplicateDocuments("Supplier", "BES", "CNG");
    }

    @Test
    public void DuplicateDocumentsFilterReset() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.filterDuplicateDocuments("Parent", "Not Applicable");
        duplicateDocuments.filterDuplicateDocuments("Customer", "Voyage 1 Ltd", "Sheffield Teaching Hospitals NHS Foundation Trust");
        duplicateDocuments.filterDuplicateDocuments("Supplier", "BES", "CNG");
        duplicateDocuments.filterReset();
        duplicateDocuments.filterDuplicateDocuments("Parent", "Boardlink Ltd.");
        duplicateDocuments.filterDuplicateDocuments("Customer", "Boardlink Ltd.");
        duplicateDocuments.filterReset();
        duplicateDocuments.filterDuplicateDocuments("Status", "In Progress");
        duplicateDocuments.filterDuplicateDocuments("Assigned", "Ankit Jain", "Sweta ");
        duplicateDocuments.filterReset();
    }

    @Test
    public void DuplicateDocumentsSearch() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.searchSchedules("B&M Retail");
    }

    @Test
    public void DuplicateDocumentsErrorValidations() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.editSchedule("B&M Retail", "290");
        duplicateDocuments.errorValidations();
    }

    @Test
    public void DuplicateDocumentsVerifyEdit() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.editSchedule("B&M Retail", "290");
        duplicateDocuments.verifyEdit();
    }

    @Test
    public void DuplicateDocumentsEdit() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.editSchedule("B&M Retail", "290");
        duplicateDocuments.setAction("Set In Progress");
        duplicateDocuments.changeAssignment("Me");
        duplicateDocuments.setAction("Send to Duplicate Investigation");
        duplicateDocuments.addComment("Comment for Duplicate Documents");
        duplicateDocuments.downloadScanned();
        duplicateDocuments.setAction("Not our customer", "To Do", "Not Needed comment.");
    }

    @Test
    public void DuplicateDocumentsMeta() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.editSchedule("B&M Retail", "290");
        duplicateDocuments.verifyMetaData();
        duplicateDocuments.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void DuplicateDocumentsBulkAction() {
        DuplicateDocuments duplicateDocuments = new DuplicateDocuments(webDriverHandler);
        duplicateDocuments.accessDuplicateDocuments();
        duplicateDocuments.setBulkAction("IP Dev 2");
    }
}
