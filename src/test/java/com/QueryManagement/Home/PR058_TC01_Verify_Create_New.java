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
//pass 
// there is "Automation Field:" field coming with the Automation Category and Automation SubCategory1  
   
    @Test
    public void CreateNewTaskElectricity() {     
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.createNewTaskElectricity("Chirayu Cust", "Automation Category", "Automation SubCategory 6",
        		"CNG","Electricity", "Automation test Summary for Electricity Query", true,
                true,"Inspired Plc","28/12/2022","28/12/2022","22");
    }
    //Pass
    @Test
    public void CreateNewTaskGas() {     
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.createNewTaskGas("Chirayu Cust", "Automation Category", "Automation SubCategory 5",
        		"Crown Gas","Gas", "Automation test Summary forGas query ", true,
                true,"Inspired Plc","28/07/2023","28/07/2023","12");
    }
    
    @Test
    public void CreateNewTaskWater() {     
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.createNewTaskWater("Chirayu Cust", "Automation Category", "Automation SubCategory 5",
        		"Crown water","Water", "Automation test Summary forGas query ", true,
                true,"Inspired Plc","28/07/2023","28/07/2023","12");
    }
    
//    @Test
//    public void EditValidations() {
//        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
//        createNewTask.("IPL", "Missing Data", "Contract issues", "Hudson Energy", "The summary to be put in.", true,
//                true, "Water", "Gas");
//    }

    //Pass
    @Test
    public void ErrorValidations() {
        CreateNewTask createNewTask = new CreateNewTask(webDriverHandler);
        createNewTask.accessCreateNew();
        createNewTask.errorValidation();
    }
}