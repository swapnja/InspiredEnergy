package com.BulkScanning.DocumentScheduling;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.DocumentScheduling.OverdueEDI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class TC003_VerifyOverdueEDI extends AbstractTestNg {

  public TC003_VerifyOverdueEDI() throws IOException {
  }

  //@Test
    public void OverdueEDIsTable() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.columnVerification();
        overdueEDI.loadOverdueEDIs();
    }

    //@Test
    public void OverdueEDIFilterApply() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.filterOverdueEDI("Customer", "Abbeycroft Leisure", "Avonside");
        overdueEDI.filterOverdueEDI("Supplier", "BES", "CNG");
        overdueEDI.filterOverdueEDI("Assigned To", "Abhay Balgi", "Mayuri Manjrekar");
        overdueEDI.filterOverdueEDI("Status", "Scheduled", "EDI Received");
    }

    //@Test
    public void OverdueEDIFilterReset() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.filterOverdueEDI("Customer", "Abbeycroft Leisure", "Avonside");
        overdueEDI.filterOverdueEDI("Supplier", "BES", "CNG");
        overdueEDI.filterReset();
    }

    //@Test
    public void OverdueEDISearch() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.searchSchedules("SCHEDULE 4");
    }

    //@Test
    public void OverdueEDIExportExcel() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.exportExcel("55", "93", "104");
    }

    //@Test
    public void OverdueEDIBulkAction() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.filterReset();
        overdueEDI.filterOverdueEDI("Assigned To", "IP Dev 2");
        overdueEDI.setBulkAssignee("IP Dev 2");
    }

    //@Test
    public void OverdueEDIErrorValidations() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.editSchedule("Schedule 2", "40");
        overdueEDI.errorValidations();
        Assert.fail();
    }

    //@Test
    public void OverdueEDIEditSchedule() {
        OverdueEDI overdueEDI = new OverdueEDI(webDriverHandler);
        overdueEDI.accessOverdueEDIs();
        overdueEDI.filterReset();
        overdueEDI.editSchedule("Schedule 2", "40");
        String path = Paths.get("BudgetTestResult\\Automation Final Calculation Gas.xls").toAbsolutePath().toString();
        overdueEDI.addAttachment(path);
        overdueEDI.changeAssignment("IP Dev 2");
        overdueEDI.addComment("Adding a comment.");
        overdueEDI.downloadAttachment("Automation Final Calculation Gas.xls");
        overdueEDI.deleteAttachment("Automation Final Calculation Gas.xls");
        overdueEDI.checkChaseHistory("17/02/2021", "IP Dev 2", "Email");
        overdueEDI.checkChaseHistory("17/02/2021", "IP Dev 2", "Comment");
        overdueEDI.selectExport("1200029667285", "16293707", "1900090592020");
        overdueEDI.setAction("Message as Chase Comment");
    }
}
