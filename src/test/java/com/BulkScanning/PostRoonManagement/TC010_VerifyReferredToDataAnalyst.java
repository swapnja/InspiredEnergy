package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.ReferredToDataAnalyst;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC010_VerifyReferredToDataAnalyst extends AbstractTestNg {

    public TC010_VerifyReferredToDataAnalyst() throws IOException {
    }

    @Test
    public void ReferredToDataAnalystTable() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.loadReferredToDataAnalyst();
        referredToDataAnalyst.columnVerification();
    }

    @Test
    public void ReferredToDataAnalystFilterApply() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.filterReferredToDataAnalyst("Customer", "Ability Tec Ltd", "Airtricity");
        referredToDataAnalyst.filterReferredToDataAnalyst("Supplier", "BES", "CNG");
    }

    @Test
    public void ReferredToDataAnalystFilterReset() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.filterReferredToDataAnalyst("Customer", "Ability Tec Ltd", "Airtricity");
        referredToDataAnalyst.filterReferredToDataAnalyst("Supplier", "BES", "CNG");
        referredToDataAnalyst.filterReset();
    }

    @Test
    public void ReferredToDataAnalystSearch() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.searchSchedules("B&M Retail");
    }

    @Test
    public void ReferredToDataAnalystErrorValidations() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.editSchedule("B&M Retail", "1011");
        referredToDataAnalyst.errorValidations();
    }

    @Test
    public void ReferredToDataAnalystVerifyEdit() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.editSchedule("B&M Retail", "69");
        referredToDataAnalyst.verifyEdit();
    }

    @Test
    public void ReferredToDataAnalystEdit() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.editSchedule("B&M Retail", "1011");
        referredToDataAnalyst.changeAssignment("Me");
        referredToDataAnalyst.addComment("Comment for Referred to Data Analysts");
        referredToDataAnalyst.downloadScanned();
        referredToDataAnalyst.setAction("Set In Progress");
    }

    @Test
    public void ReferredToDataAnalystMeta() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.editSchedule("B&M Retail", "69");
        referredToDataAnalyst.verifyMetaData();
        referredToDataAnalyst.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void ReferredToDataAnalystBulkAction() {
        ReferredToDataAnalyst referredToDataAnalyst = new ReferredToDataAnalyst(webDriverHandler);
        referredToDataAnalyst.accessReferredToDataAnalyst();
        referredToDataAnalyst.setBulkAction("B&M Retail", "1011", "IP Dev 2");
    }
}
