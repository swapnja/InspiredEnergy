package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC09_Verify_Create_From extends AbstractTestNg {

    public PR058_TC09_Verify_Create_From() throws IOException {
    }

    @Test
    public void SelectCreateFrom() {
        CreateFrom createFrom = new CreateFrom(webDriverHandler);
        createFrom.accessSubCategory("Billing", "Bill too high");
        createFrom.selectEntry(15);
    }

    @Test
    public void VerifyCreateFrom() {
        CreateFrom createFrom = new CreateFrom(webDriverHandler);
        createFrom.accessSubCategory("Billing", "Bill too high");
        createFrom.selectEntry(1);
        createFrom.getBaseData();
        createFrom.verifyCreateFrom();
    }

    @Test
    public void CreateFrom() {
        CreateFrom createFrom = new CreateFrom(webDriverHandler);
        createFrom.accessSubCategory("Billing", "Bill too high");
        createFrom.selectEntry(1);
        createFrom.btnCreateFrom.waitClickable().click();
        createFrom.waitLoad();
        createFrom.linkActions("Adding action for Automation");
        //createFrom.linkDocuments();
        //createFrom.linkContacts();
        createFrom.linkQueryLinks();
        //createFrom.linkInvoices();
        //createFrom.linkLocations();
        //createFrom.linkMeters();
        //createFrom.linkAccounts();
        createFrom.btnCreate.waitClickable().click();
    }
}