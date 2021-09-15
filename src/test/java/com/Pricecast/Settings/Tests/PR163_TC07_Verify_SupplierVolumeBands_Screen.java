package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierVoulumeBands;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC07_Verify_SupplierVolumeBands_Screen extends AbstractTestNg {

    public PR163_TC07_Verify_SupplierVolumeBands_Screen() throws IOException {

    }

    @Test
    public void SupplierVolumeBands_Gas() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectGasSupplier();
        supplierVolumeBands.SupplierVolumeBands_addNewRow(1, 1, 11, 1);
    }

    @Test
    public void SupplierVolumeBands_columnVerification_Gas() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBand = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBand.selectSettings();
        sas.selectGasSupplier();
        supplierVolumeBand.SupplierVolumeBands_ColumnVerification();
    }


    @Test
    public void SupplierVolumeBands_RangeValidation_Gas() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectGasSupplier();
        supplierVolumeBands.SupplierVolumeBands_addNewRow(1, 1333537333, 1337775331, 1);
        supplierVolumeBands.SupplierVolumeBands_RangeValidation();
        System.out.println("Supplier Volume Band functionality is working fine: Supplier Volume Bands_RangeValidation");
    }

    @Test
    public void SupplierVolumeBands_NumericValidation_Gas() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectGasSupplier();
        supplierVolumeBands.SupplierVolumeBands_NumericaddNewRow(1, 33, 44, 52);
        supplierVolumeBands.SupplierVolumeBands_NumericValidation();
        System.out.println("Supplier Volume Band functionality is working fine: Supplier Volume Bands_NumericValidation");
    }

    //Power
    @Test
    public void SupplierVolumeBands_Power() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectPowerSupplier();
        supplierVolumeBands.SupplierVolumeBands_addNewRow(1, 1, 11, 1);
    }

    @Test
    public void SupplierVolumeBands_columnVerification_Power() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBand = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBand.selectSettings();
        sas.selectPowerSupplier();
        supplierVolumeBand.SupplierVolumeBands_ColumnVerification();
    }

    @Test
    public void SupplierVolumeBands_RangeValidation_Power() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectPowerSupplier();
        supplierVolumeBands.SupplierVolumeBands_addNewRow(1, 1333537333, 1337775331, 1);
        supplierVolumeBands.SupplierVolumeBands_RangeValidation();
        System.out.println("Supplier Volume Band functionality is working fine: Supplier Volume Bands_RangeValidation");
    }

    @Test
    public void SupplierVolumeBands_NumericValidation_Power() throws InterruptedException {
        SupplierVoulumeBands supplierVolumeBands = new SupplierVoulumeBands(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBands.selectSettings();
        sas.selectPowerSupplier();
        supplierVolumeBands.SupplierVolumeBands_NumericaddNewRow(1, 33, 44, 52);
        supplierVolumeBands.SupplierVolumeBands_NumericValidation();
        System.out.println("Supplier Volume Band functionality is working fine: Supplier Volume Bands_NumericValidation");
    }
}
