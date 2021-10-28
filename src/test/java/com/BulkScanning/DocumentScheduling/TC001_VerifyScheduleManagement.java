package com.BulkScanning.DocumentScheduling;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.DocumentScheduling.ScheduleManagement;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC001_VerifyScheduleManagement extends AbstractTestNg {

    public TC001_VerifyScheduleManagement() throws IOException {
    }

    //@Test
    public void ScheduleManagementTable() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.columnVerification();
    }

    //@Test
    public void ScheduleManagementDelete() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.deleteSchedules("Automation");
    }

    //@Test
    public void ScheduleManagementFilter() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.filterBySuppliers("EON");
        scheduleManagement.resetSupFilter();
        scheduleManagement.filterByDocument("Invoice");
        scheduleManagement.resetDocFilter();
    }

    //@Test
    public void ScheduleManagementSearch() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.searchSchedules("Automation");
    }

   // @Test
    public void ScheduleManagementEdit() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.editSchedules("For the Edit");
    }

    //@Test
    public void ScheduleManagementEditScheduleTab() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        createEditSchedule();
        scheduleManagement.editSchedules("For the Edit");
        scheduleManagement.editScheduleStart();
        scheduleManagement.deleteSchedules("Edited");
    }

    //@Test
    public void ScheduleManagementEditAssignmentTab() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        createEditSchedule();
        scheduleManagement.editSchedules("For the Edit");
        scheduleManagement.editAssignment();
        scheduleManagement.deleteSchedules("Edited");
    }

    //@Test
    public void ScheduleManagementAddNewSchedule() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.addScheduleStart("Automation", "EON", "Invoice", "IP Dev 2");
        scheduleManagement.patternSingleOccurrence("12/Jun/2021");
        scheduleManagement.assignmentMeter("Arun Estate Agencies Limited", "109 High Street", "676694704", "Gas");
        scheduleManagement.patternMonthly("15", "12/Jun/2021");
        scheduleManagement.selectEnd("Fixed End Date", "1/May/2022");
        scheduleManagement.addScheduleEnd("Notes", "Email", "rahul.dash@cloudenergysoftware.com");
    }

    //@Test
    public void ScheduleManagementErrorValidation() {
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.accessScheduleManagement();
        scheduleManagement.errorValidations("Airtricity", "Runwood Homes Ltd.");
    }

    public void createEditSchedule(){
        ScheduleManagement scheduleManagement = new ScheduleManagement(webDriverHandler);
        scheduleManagement.addScheduleStart("For the Edit", "EON", "Invoice", "IP Dev 2");
        scheduleManagement.patternSingleOccurrence("12/Jun/2021");
        scheduleManagement.assignmentMeter("Arun Estate Agencies Limited", "139 Wickham Road", "571418400", "G");
        scheduleManagement.patternMonthly("15", "12/Jun/2021");
        scheduleManagement.selectEnd("Fixed End Date", "1/May/2022");
        scheduleManagement.addScheduleEnd("Notes", "Email", "rahul.dash@cloudenergysoftware.com");
    }
}