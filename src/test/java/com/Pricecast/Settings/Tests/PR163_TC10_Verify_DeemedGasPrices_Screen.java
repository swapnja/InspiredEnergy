package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.DeemedGasPrices;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC10_Verify_DeemedGasPrices_Screen extends AbstractTestNg {

    public PR163_TC10_Verify_DeemedGasPrices_Screen() throws IOException {

    }

    @Test
    public void AccessDeemedGasPrices() throws InterruptedException {
        DeemedGasPrices deemedGasPrices = new DeemedGasPrices(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        deemedGasPrices.selectSettings();
        sas.selectGasSupplier();
        deemedGasPrices.DeemedGasPrices_addNewRow(100, 50000, 10, 25);
    }

    @Test
    public void DeemedGasPrices_columnVerification() throws InterruptedException {
        DeemedGasPrices deemedGasPrices = new DeemedGasPrices(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        deemedGasPrices.selectSettings();
        sas.selectGasSupplier();
        deemedGasPrices.DeemedGasPrices_addNewRow(100, 50000, 10, 25);
        deemedGasPrices.deemedGasPrice_ColumnVerification();
    }


    @Test
    public void DeemedGasPrices_MandatoryValidation() throws InterruptedException {
        DeemedGasPrices deemedGasPrices = new DeemedGasPrices(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        deemedGasPrices.selectSettings();
        sas.selectGasSupplier();
        deemedGasPrices.DeemedGasPrices_blankaddNewRow();
        deemedGasPrices.DeemedGasPrices_MandatoryValidation();
        System.out.println("Deemed Gas Prices functionality is working fine:  Deemed Gas Prices Mandatory Validation");
    }

    @Test
    public void DeemedGasPrices_NumericValidation_Gas() throws InterruptedException {
        DeemedGasPrices deemedGasPrices = new DeemedGasPrices(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        deemedGasPrices.selectSettings();
        sas.selectGasSupplier();
        deemedGasPrices.DeemedGasPrices_Validation("2.3", "356.42", "-26", "-3.265");
        deemedGasPrices.DeemedGasPrices_NumericValidation();
        System.out.println("Deemed Gas Prices functionality is working fine: Deemed Gas prices RangeValidation");
    }

    @Test
    public void DeemedGasPrices_RangeValidation() throws InterruptedException {
        DeemedGasPrices deemedGasPrices = new DeemedGasPrices(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        deemedGasPrices.selectSettings();
        sas.selectGasSupplier();
        deemedGasPrices.DeemedGasPrices_Validation("1111111111", "1111111111", "1111111111", "1111111111");
        deemedGasPrices.DeemedGasPrices_RangeValidation();
        System.out.println("Deemed Gas Prices functionality is working fine: Deemed Gas prices RangeValidation");
    }
}
