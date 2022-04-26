package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.DeemedPowerPrices;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC11_Verify_DeemedPowerPrices_Screen extends AbstractTestNg {

    public PR163_TC11_Verify_DeemedPowerPrices_Screen() throws IOException {

    }
//Passed
    @Test
    public void AccessDeemedPowerPrices() throws InterruptedException {
        DeemedPowerPrices deemedPowerPrices = new DeemedPowerPrices(webDriverHandler);
        deemedPowerPrices.selectSettings();
        deemedPowerPrices.DeemedPowerPrices_addNewRow("CNG", 1, 10, 25);
    }
//Passed
    @Test
    public void DeemedPowerPrices_columnVerification() throws InterruptedException {
        DeemedPowerPrices deemedPowerPrices = new DeemedPowerPrices(webDriverHandler);
        deemedPowerPrices.selectSettings();
        deemedPowerPrices.DeemedPowerPrices_addNewRow("CNG", 1, 10, 25);
        deemedPowerPrices.deemedPowerPrice_ColumnVerification();
    }
    //Passed
    @Test
    public void DeemedPowerPrices_MandatoryValidation() throws InterruptedException {
        DeemedPowerPrices deemedPowerPrices = new DeemedPowerPrices(webDriverHandler);
        deemedPowerPrices.selectSettings();
        deemedPowerPrices.DeemedPowerPrices_blankaddNewRow();
        deemedPowerPrices.DeemedPowerPrices_MandatoryValidation();
        System.out.println("Deemed Power Prices functionality is working fine:  Deemed Power Prices Mandatory Validation");
    }
    //Passed
    @Test
    public void DeemedPowerPrices_NumericValidation_Power() throws InterruptedException {
        DeemedPowerPrices deemedPowerPrices = new DeemedPowerPrices(webDriverHandler);
        deemedPowerPrices.selectSettings();
        deemedPowerPrices.DeemedPowerPrices_Validation("CNG", "2.3", "-356.42", "-26");
        deemedPowerPrices.DeemedPowerPrices_NumericValidation();
        System.out.println("Deemed Power Prices functionality is working fine: Deemed Power prices RangeValidation");
    }
//Passed
    @Test
    public void DeemedPowerPrices_RangeValidation() throws InterruptedException {
        DeemedPowerPrices deemedPowerPrices = new DeemedPowerPrices(webDriverHandler);
        deemedPowerPrices.selectSettings();
        deemedPowerPrices.DeemedPowerPrices_Validation("OVO", "1111111111", "1111111111",  "1111111111");
        deemedPowerPrices.DeemedPowerPrices_RangeValidation();
        System.out.println("Deemed Power Prices functionality is working fine: Deemed Power prices RangeValidation");
    }
}
