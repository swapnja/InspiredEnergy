package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierProductFilters;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC08_Verify_SupplierProductFilter_Screen extends AbstractTestNg {

    public PR163_TC08_Verify_SupplierProductFilter_Screen() throws IOException {

    }

    @Test
    public void SupplierProductFilters_Gas() throws InterruptedException {
        SupplierProductFilters SupplierProductFilters = new SupplierProductFilters(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        SupplierProductFilters.selectSettings();
        sas.selectGasSupplier();
        SupplierProductFilters.SupplierProductFilter_addNewRow(1, 1);
    }

    @Test
    public void SupplierProductFilters_columnVerification_Gas() throws InterruptedException {
        SupplierProductFilters supplierVolumeBand = new SupplierProductFilters(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBand.selectSettings();
        sas.selectGasSupplier();
        supplierVolumeBand.SupplierProductFilters_ColumnVerification();
    }

    //Power
    @Test
    public void SupplierProductFilters_Power() throws InterruptedException {
        SupplierProductFilters SupplierProductFilters = new SupplierProductFilters(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        SupplierProductFilters.selectSettings();
        sas.selectPowerSupplier();
        SupplierProductFilters.SupplierProductFilter_addNewRow(1, 1);
    }

    @Test
    public void SupplierProductFilters_columnVerification_Power() throws InterruptedException {
        SupplierProductFilters supplierVolumeBand = new SupplierProductFilters(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierVolumeBand.selectSettings();
        sas.selectPowerSupplier();
        supplierVolumeBand.SupplierProductFilters_ColumnVerification();
    }

}
