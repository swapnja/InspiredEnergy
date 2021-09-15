package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.DefaultCommission;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC09_Verify_DefaultCommision_Screen extends AbstractTestNg {

    public PR163_TC09_Verify_DefaultCommision_Screen() throws IOException {

    }

    @Test
    public void DefaultCommision_Gas() throws InterruptedException {
        DefaultCommission DefaultCommision = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        DefaultCommision.selectSettings();
        sas.selectGasSupplier();
        DefaultCommision.DefaultCommision_addNewRow(12, 1, 1, 111, 1, 111, 1);
    }

    @Test
    public void DefaultCommision_columnVerification_Gas() throws InterruptedException {
        DefaultCommission defaultCommision = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommision.selectSettings();
        sas.selectGasSupplier();
        defaultCommision.defaultCommision_ColumnVerification();
    }


    @Test
    public void DefaultCommision_MandatoryValidation_Gas() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectGasSupplier();
        defaultCommission.DefaultCommision_blankaddNewRow(1);
        defaultCommission.DefaultCommision_MandatoryRangeValidation();
        System.out.println("Default Commision functionality is working fine:  Default Commision _Mandatory Validation");
    }

    @Test
    public void DefaultCommision_RangeValidation_Gas() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectGasSupplier();
        defaultCommission.DefaultCommision_RangeaddNewRow(222222222, 1, -22222, -2222222, -2222222, -2222098, 1);
        defaultCommission.DefaultCommision_RangeValidation();
        System.out.println("Default Commision functionality is working fine: Default Commision_RangeValidation");
    }

    @Test
    public void DefaultCommision_NumericValidation_Gas() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectGasSupplier();
        defaultCommission.DefaultCommision_NumericaddNewRow(3, 1, 22, 22, 2, 98, 1);
        defaultCommission.DefaultCommision_NumericValidation();
        System.out.println("Default Commision functionality is working fine: Default Commision_NumericValidation");
    }
//Power 

    @Test
    public void DefaultCommision_Power() throws InterruptedException {
        DefaultCommission DefaultCommision = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        DefaultCommision.selectSettings();
        sas.selectPowerSupplier();
        DefaultCommision.DefaultCommision_addNewRow(12, 1, 1, 111, 1, 111, 1);
    }

    @Test
    public void DefaultCommision_columnVerification_Power() throws InterruptedException {
        DefaultCommission defaultCommision = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommision.selectSettings();
        sas.selectPowerSupplier();
        defaultCommision.defaultCommision_ColumnVerification();
    }


    @Test
    public void DefaultCommision_MandatoryValidation_Power() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectPowerSupplier();
        defaultCommission.DefaultCommision_blankaddNewRow(1);
        defaultCommission.DefaultCommision_MandatoryRangeValidation();
        System.out.println("Default Commision functionality is working fine:  Default Commision _Mandatory Validation");
    }


    @Test
    public void DefaultCommision_RangeValidation_Power() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectPowerSupplier();
        defaultCommission.DefaultCommision_RangeaddNewRow(222222222, 1, -22222, -2222222, -2222222, -2222098, 1);
        defaultCommission.DefaultCommision_RangeValidation();
        System.out.println("Default Commision functionality is working fine: Default Commision_RangeValidation");
    }

    @Test
    public void DefaultCommision_NumericValidation_Power() throws InterruptedException {
        DefaultCommission defaultCommission = new DefaultCommission(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        defaultCommission.selectSettings();
        sas.selectPowerSupplier();
        defaultCommission.DefaultCommision_NumericaddNewRow(3, 1, 22, 22, 2, 98, 1);
        defaultCommission.DefaultCommision_NumericValidation();
        System.out.println("Default Commision functionality is working fine: Default Commision_NumericValidation");
    }
}
