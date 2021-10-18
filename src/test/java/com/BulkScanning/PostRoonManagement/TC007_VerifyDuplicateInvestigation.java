package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.DuplicateInvestigation;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC007_VerifyDuplicateInvestigation extends AbstractTestNg {

    public TC007_VerifyDuplicateInvestigation() throws IOException {
    }

    @Test
    public void DuplicateInvestigationTable() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.loadDuplicateInvestigation();
        duplicateInvestigation.columnVerification();
    }

    @Test
    public void DuplicateInvestigationFilterApply() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.filterDuplicateInvestigation("Customer", "Ability Tec Ltd", "Airtricity");
        duplicateInvestigation.filterDuplicateInvestigation("Supplier", "BES", "CNG");
    }

    @Test
    public void DuplicateInvestigationFilterReset() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.filterDuplicateInvestigation("Customer", "Ability Tec Ltd", "Airtricity");
        duplicateInvestigation.filterDuplicateInvestigation("Supplier", "BES", "CNG");
        duplicateInvestigation.filterReset();
    }

    @Test
    public void DuplicateInvestigationSearch() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.searchSchedules("Boardlink Ltd.");
    }

    @Test
    public void DuplicateInvestigationErrorValidations() throws InterruptedException {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.editSchedule("Boardlink Ltd.");
        duplicateInvestigation.errorValidations();
    }

    @Test
    public void DuplicateInvestigationVerifyEdit() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.editSchedule("B&M Retail");
        duplicateInvestigation.verifyEdit();
    }

    @Test
    public void DuplicateInvestigationEdit() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.editSchedule("Boardlink Ltd.");
        duplicateInvestigation.changeAssignment("Me");
        duplicateInvestigation.addComment("Comment for Duplicate Documents");
        duplicateInvestigation.downloadScanned();
        //duplicateInvestigation.setAction("Set In Progress");
    }

    @Test
    public void DuplicateInvestigationMeta() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.editSchedule("B&M Retail");
        duplicateInvestigation.verifyMetaData();
        duplicateInvestigation.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void DuplicateInvestigationBulkAction() {
        DuplicateInvestigation duplicateInvestigation = new DuplicateInvestigation(webDriverHandler);
        duplicateInvestigation.accessDuplicateInvestigation();
        duplicateInvestigation.setBulkAction("IP Dev 2");
    }
}
