package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierScripts;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC06_Verify_SupplierScript_Screen extends AbstractTestNg {

    public PR163_TC06_Verify_SupplierScript_Screen() throws IOException {
        super();

    }

    @Test
    public void AccessSupplierScreen() throws InterruptedException {
        SupplierScripts supplierScripts = new SupplierScripts(webDriverHandler);
        supplierScripts.selectSettings();
        supplierScripts.SupplierScripts_Columnverification();
    }

    @Test
    public void SupplierScreen_AddNew() throws InterruptedException {
        SupplierScripts supplierScripts = new SupplierScripts(webDriverHandler);
        supplierScripts.selectSettings();
        supplierScripts.SupplierScripts_addNewRow("Gas", "British Gas", "COT","SupplierUplifts.docx");
    }

    @Test
    public void SupplierScreen_Validation() throws InterruptedException {
        SupplierScripts supplierScripts = new SupplierScripts(webDriverHandler);
        supplierScripts.selectSettings();
        supplierScripts.SupplierScripts_Validation("Gas", "British Gas", "COT","TariffBulkUploadData.xlsx");
    }
}
