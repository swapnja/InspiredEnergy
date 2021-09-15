package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR058_TC03_Bulk_Actions extends AbstractTestNg {

    public PR058_TC03_Bulk_Actions() throws IOException {
    }

    @Test
    public void BulkAction() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        String path = Paths.get("PricecastTestData\\Tariff\\Gas\\BES-G-.xlsx").toAbsolutePath().toString();
        bulkAction.bulkAction("Resolve for Customer", "Note to be entered", "Supplier", "12/12/21", path, "472", "141");
    }

    @Test
    public void BulkAssign() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        bulkAction.bulkAssign("Rahul Dash");
    }

    @Test
    public void SelectionError() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        bulkAction.selectionError();
    }

    @Test
    public void BulkCreateImport() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        String path = Paths.get("QueryManagementTestData\\Bulk Create Import Template.xlsx").toAbsolutePath().toString();
        bulkAction.bulkCreateImport("References", "Note that's required", path);
    }

    @Test
    public void BulkUpdate() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        String path = Paths.get("QueryManagementTestData\\Bulk Action Update Template.xlsx").toAbsolutePath().toString();
        bulkAction.bulkUpdateImport("References", "Note that's required", path);
    }

    @Test
    public void BulkActionUpdate() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        String path = Paths.get("QueryManagementTestData\\Bulk Import Update Template.xlsx").toAbsolutePath().toString();
        bulkAction.bulkActionImport("References", "Note that's required", path);
    }

    @Test
    public void Export() {
        BulkAction bulkAction = new BulkAction(webDriverHandler);
        bulkAction.accessSubCategory("Billing", "Incorrect Rates");
        bulkAction.Export();
    }
}
