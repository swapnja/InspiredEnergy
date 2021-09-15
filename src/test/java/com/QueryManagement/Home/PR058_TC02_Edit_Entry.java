package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;


public class PR058_TC02_Edit_Entry extends AbstractTestNg {

    public PR058_TC02_Edit_Entry() throws IOException {
    }

    @Test
    public void EditEntry() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
    }

    @Test
    public void EditBase() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.editBaseData("Customer", "30.65", "25.48", "-95.455");
    }

    @Test
    public void ExitValidation() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        webDriverHandler.byXpath("//*[@id='Summary']").waitClickable().sendKeys("Editing the Summary.");
        webDriverHandler.byXpath("//*[contains(@id, 'EnterTextArea')]").waitClickable().sendKeys("Editing the Text Area.");
        editEntry.exitValidation("Cancel", "30.65", "25.48", "-95.46");
        editEntry.exitValidation("Yes", "30.65", "25.48", "-95.46");
        editEntry.exitValidation("Save", "30.65", "25.48", "-95.46");
    }

    @Test
    public void ErrorValidations() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.errorValidation();
    }

    @Test
    public void AddNote() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.addNote("Adding a note automation", "Supplier");
    }

    @Test
    public void EditNote() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.editNote("Adding a note automation", false, false, false);
        editEntry.editNote("Adding a note automation", true, true, true);
    }

    @Test
    public void AddAction() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        String path = Paths.get("PricecastTestData\\Tariff\\Gas\\BES-G-.xlsx").toAbsolutePath().toString();
        editEntry.addAction("Resolve for Supplier", "The Note to put inside the Action Note.", path, true);
    }

    @Test
    public void EditAction() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.editAction("The Note to put inside the Action Note.", true, true, true, true);
        editEntry.waitLoad();
        editEntry.editAction("The Note to put inside the Action Note again.", true, true, true, true);
    }

    @Test
    public void AddDocuments() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        String path = Paths.get("PricecastTestData\\Tariff\\Gas\\BES-G-.xlsx").toAbsolutePath().toString();
        editEntry.scrollToDocument();
        editEntry.newDocument("New Document Automation", "LOA", path, true, true, false);
        editEntry.waitLoad();
        editEntry.existingDocument("Office work", true, true, false);
    }

    @Test
    public void EditDocuments() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.scrollToDocument();
        editEntry.accessDocument("New Document Automation", "Download");
        editEntry.accessDocument("New Document Automation", "Delete");
        editEntry.accessDocument("Office work", "Download");
        editEntry.accessDocument("Office work", "Delete");
    }

    @Test
    public void AddContacts() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.scrollToContact();
        editEntry.newContact("Automation Contact", "Developer", "rahul.dash@colud.com", "457821369", "Automation Test note for Contact.");
        editEntry.waitLoad();
        editEntry.existingContact("Satyajeet", "Automation Test note for existing Contact.");
    }

    @Test
    public void EditContacts() {
        EditEntry editEntry = new EditEntry(webDriverHandler);
        editEntry.accessSubCategory("Billing", "Bill too high");
        editEntry.selectEntry(15);
        editEntry.scrollToContact();
        editEntry.accessContact("Automation Contact", "Toggle");
        editEntry.accessContact("Automation Contact", "Delete");
        editEntry.accessContact("Satyajeet", "Toggle");
        editEntry.accessContact("Satyajeet", "Delete");
    }
}