package com.Budgets.InitialFlows;

import com.Base.TimeStampPageHandler;
import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.NotesHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR8_TC017_Utility_Gas_Notes extends AbstractTestNg {

	public PR8_TC017_Utility_Gas_Notes() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
    String appendDate = TimeStampPageHandler.AppendTimeStamp();

    public PR8_TC017_Utility_Gas_Notes() throws IOException {
    }   
    @Test
    public void GasNotes() throws IOException, InterruptedException {
    	//electricity test for verification
    	        String Modify = "Modified the note " + appendDate;
    	        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
    	        customersPageHandler.selectFirstCustomer();
    	        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
    	        budgetPageHandler.createBudgetMonthlyElectricity();
    	        NotesHandler notesHandler = new NotesHandler(webDriverHandler, prop);
    	        notesHandler.waitLoad();
    	        notesHandler.clearNotes("InformationNotesTB");
    	    //    notesHandler.addNotes("Adding this Note " + appendDate, "InformationNotesTB");
//    	        notesHandler.informationSave();
    	        String CharLimit = notesHandler.getCharLimit("InformationNotesTB");
    	        System.out.println("-------------------------- \n" + CharLimit);
    	        Assert.assertEquals("1000", CharLimit);
    	        notesHandler.testCharlimit("InformationNotesTB");
    	        notesHandler.modifyNotes(Modify, "InformationNotesTB");
    	        notesHandler.informationSave();
    	        webDriverHandler.byXpath(prop.getProperty("ElectricityRateTimeBands")).waitClickable().click();
    	        notesHandler.waitLoad();
    	        webDriverHandler.byXpath(prop.getProperty("ImportBtn")).waitClickable().click();
    	        webDriverHandler.byXpath(prop.getProperty("ImportReferenceTxtBox")).sendKeys("Automation Import File " + appendDate);
    	        notesHandler.addNotes("Adding note import " + appendDate, "importNotes");
    	      //  notesHandler.testCharlimitImport("importNotes");
    	       // webDriverHandler.byXpath(prop.getProperty("ImportModalCancel")).click();
    	        //webDriverHandler.byXpath(prop.getProperty("Back")).waitClickable(10, 100).click();
    	        notesHandler.waitLoad();
    	     //   notesHandler.openNotes("BudgetNotesIcon");
    	       // notesHandler.searchNotes("BudgetModalNotesSearch", Modify);
    			/*
    			 * notesHandler.printSearch();
    			 * notesHandler.addBlankNotes("BudgetConsoleNotesTB");
    			 * webDriverHandler.byXpath(prop.getProperty("BudgetConsoleSave")).waitClickable
    			 * (10, 100).click();
    			 */
    			/*
    			 * String strErrortext =
    			 * webDriverHandler.byId("swal2-content").waitVisible().getText();
    			 * System.out.println("*************************");
    			 * System.out.println("Error message for Invalid header validation is: " +
    			 * strErrortext);
    			 * webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().
    			 * click();
    			 
    	    }*/
}
