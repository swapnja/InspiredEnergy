package com.BulkScanning.DocumentScheduling;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.DocumentScheduling.DocumentSchedule;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class TC002_VerifyDocumentSchedule extends AbstractTestNg {

    public TC002_VerifyDocumentSchedule() throws IOException {
    }

    @Test
    public void DocumentScheduleTable() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.columnVerification();
        documentScheduling.loadDocumentSchedule();
    }

    @Test
    public void DocumentScheduleManagementFilterApply() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.filterDocumentSchedule("Customer", "Abbeycroft Leisure", "Avonside");
        documentScheduling.filterDocumentSchedule("Supplier", "BES", "CNG");
    }

    @Test
    public void DocumentScheduleManagementFilterReset() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.filterDocumentSchedule("Customer", "Abbeycroft Leisure", "Avonside");
        documentScheduling.filterDocumentSchedule("Supplier", "BES", "CNG");
        documentScheduling.filterReset();
    }

    @Test
    public void DocumentScheduleManagementSearch() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.searchSchedules("Test Delete Schedule");
    }

    @Test
    public void DocumentScheduleExportExcel() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.exportExcel("16", "31", "91");
    }

    @Test
    public void DocumentScheduleErrorValidations() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.editSchedule("AB test","8");
        documentScheduling.errorValidations();
    }

    @Test
    public void DocumentScheduleEditSchedule() {
        DocumentSchedule documentScheduling = new DocumentSchedule(webDriverHandler);
        documentScheduling.accessDocumentSchedule();
        documentScheduling.editSchedule("AB test","8");
        String path = Paths.get("BudgetTestResult\\Automation Final Calculation Gas.xls").toAbsolutePath().toString();
        documentScheduling.addAttachment(path);
        documentScheduling.changeAssignment("IP Dev 2");
        documentScheduling.addComment("Adding a comment.");
        documentScheduling.downloadAttachment("Automation Final Calculation Gas.xls");
        documentScheduling.deleteAttachment("Automation Final Calculation Gas.xls");
        documentScheduling.checkChaseHistory("12/02/2021", "IP Dev 2", "Email");
        documentScheduling.checkChaseHistory("03/02/2021", "Abhay Balgi", "Comment");
        documentScheduling.selectExport();
        documentScheduling.setAction("to@inspiredenergy.com", "cc@inspiredenergy.com", "Subject to be typed.", path, "Message to Type.");
    }
}
