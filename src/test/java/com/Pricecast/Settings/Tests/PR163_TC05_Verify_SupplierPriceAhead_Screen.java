package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierPriceAhead;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC05_Verify_SupplierPriceAhead_Screen extends AbstractTestNg {

    public PR163_TC05_Verify_SupplierPriceAhead_Screen() throws IOException {
    }
//passed
    @Test
    public void SupplierPriceAhead_Gas() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectGasSupplier();
        supplierPriceAhead.SupplierPriceAhead_addNewRow(1, 180, "31/07/2021", "All");
    }
//passed
    @Test
    public void SupplierPriceAhead_columnVerification_Gas() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectGasSupplier();
        supplierPriceAhead.SupplierPriceAhead_ColumnVerification();
    }
//passed
    @Test
    public void SupplierPiceAhead_RangeValidation_Gas() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectGasSupplier();
        supplierPriceAhead.SupplierPriceAhead_Validations(1, "3840.00000", "02/07/2021", "All");
        supplierPriceAhead.SupplierPriceAhead_RangeValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_RangeValidation");
    }
//passed
    @Test
    public void SupplierPiceAhead_NumericValidation_Gas() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectGasSupplier();
        supplierPriceAhead.SupplierPriceAhead_Validations(1, "-211", "02/07/2021", "All");
        supplierPriceAhead.SupplierPriceAhead_NumericValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_NumericValidation");
    }
//passed
    @Test
    public void SupplierPiceAhead_MandatoryValidation_Gas() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectGasSupplier();
        supplierPriceAhead.blankAddNewRow();
        supplierPriceAhead.SupplierPriceAhead_MandatoryValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_MandatoryValidation");
    }

    //passed
    @Test
    public void SupplierPriceAhead_Power() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectPowerSupplier();
        supplierPriceAhead.SupplierPriceAhead_addNewRow(1, 180, "31/07/2021", "All");
    }
//passed
    @Test
    public void SupplierPriceAhead_columnVerification_Power() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectPowerSupplier();
        supplierPriceAhead.SupplierPriceAhead_ColumnVerification();
    }

//passed
    @Test
    public void SupplierPiceAhead_RangeValidation_Power() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectPowerSupplier();
        supplierPriceAhead.SupplierPriceAhead_Validations(1, "3840.00000", "02/07/2021", "All");
        supplierPriceAhead.SupplierPriceAhead_RangeValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_RangeValidation");
    }
    
//passed
    @Test
    public void SupplierPiceAhead_NumericValidation_Power() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectPowerSupplier();
        supplierPriceAhead.SupplierPriceAhead_Validations(1, "-211", "02/07/2021", "All");
        supplierPriceAhead.SupplierPriceAhead_NumericValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_NumericValidation");
    }
//passed
    @Test
    public void SupplierPiceAhead_MandatoryValidation_Power() throws InterruptedException {
        SupplierPriceAhead supplierPriceAhead = new SupplierPriceAhead(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierPriceAhead.selectSettings();
        sas.selectPowerSupplier();
        supplierPriceAhead.blankAddNewRow();
        supplierPriceAhead.SupplierPriceAhead_MandatoryValidation();
        System.out.println("Supplier Price Ahead functionality is working fine: Supplier Price Ahead_MandatoryValidation");
    }

}
