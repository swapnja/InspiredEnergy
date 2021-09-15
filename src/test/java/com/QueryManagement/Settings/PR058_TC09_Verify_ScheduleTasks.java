package com.QueryManagement.Settings;

import com.QueryManagement.AbstractTestNg;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC09_Verify_ScheduleTasks extends AbstractTestNg {

    public PR058_TC09_Verify_ScheduleTasks() throws IOException {
    }

    @Test
    public void AccessScheduleTasks() {
        ScheduleTasks scheduleTasks = new ScheduleTasks(webDriverHandler);
        scheduleTasks.accessSettings();
        scheduleTasks.accessScheduleTasks();
        scheduleTasks.columnVerification();
        String[] data = {"Annual", "July", "Day of the Week", "Last Saturday"};
        scheduleTasks.createScheduleTasks("Automation Schedule", "Billing", "Bill too high", data, "01/01/2021", "01:30", "01/10/2021", "Customer", "Test KT session");
        Assert.fail();
    }

    @Test
    public void EditScheduleTasks() {
        ScheduleTasks scheduleTasks = new ScheduleTasks(webDriverHandler);
        scheduleTasks.accessSettings();
        scheduleTasks.accessScheduleTasks();
        String[] data = {"Monthly", "Day", "12"};
        scheduleTasks.editScheduleTasks("Test", "Test Edit", "Automation Category", "", data, "01/01/2021", "01:30", "01/10/2021");
    }

    @Test
    public void CopyScheduleTasks() {
        ScheduleTasks scheduleTasks = new ScheduleTasks(webDriverHandler);
        scheduleTasks.accessSettings();
        scheduleTasks.accessScheduleTasks();
        String[] data = {"Weekly", "Tuesday"};
        scheduleTasks.copyScheduleTasks("Test", "Test Edit", "Automation Category", "", data, "01/01/2021", "01:30", "01/10/2021");
    }


    @Test
    public void DeleteScheduleTasks() {
        ScheduleTasks scheduleTasks = new ScheduleTasks(webDriverHandler);
        scheduleTasks.accessSettings();
        scheduleTasks.accessScheduleTasks();
        scheduleTasks.deleteScheduleTasks("Automation Schedule");
    }

    @Test
    public void Validations() {
        ScheduleTasks scheduleTasks = new ScheduleTasks(webDriverHandler);
        scheduleTasks.accessSettings();
        scheduleTasks.accessScheduleTasks();
        scheduleTasks.errorValidation();
    }
}