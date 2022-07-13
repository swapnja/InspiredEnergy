package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC01_Verify_Create_New extends AbstractTestNg {

    public PR058_TC01_Verify_Create_New() throws IOException {
    }
//Pass
    @Test
    public void VerifyCreateNewTask() {
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.verifyCreateNewModal();
    }
//pass :) // there is "Automation Field:" field coming with the Automation Category and Automation SubCategory1  
    @Test
    public void CreateNewTask() {     
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.createNewTask("Chirayu Cust", "Automation Category", "Automation SubCategory 6",
        		"CNG","Electricity", "Automation test Summary", true,
                true,"Inspired Plc","28/07/2022","28/07/2022","22");
    }
  //form[@id='myForm']/input[@name='version']/@value
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