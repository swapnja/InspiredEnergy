package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC01_Verify_Create_New extends AbstractTestNg {

    public PR058_TC01_Verify_Create_New() throws IOException {
    }

    @Test
    public void VerifyCreateNewTask() {
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.verifyCreateNewModal();
    }

    @Test
    public void CreateNewTask() {
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.createNewTask("Customer", "Billing", "Incorrect Rates", "Opus", "The summary to be put in.", false,
                true, "Electricity");
    }

//    @Test
//    public void EditValidations() {
//        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
//        createNewTask.("IPL", "Missing Data", "Contract issues", "Hudson Energy", "The summary to be put in.", true,
//                true, "Water", "Gas");
//    }

    @Test
    public void ErrorValidations() {
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.errorValidation();
    }
}