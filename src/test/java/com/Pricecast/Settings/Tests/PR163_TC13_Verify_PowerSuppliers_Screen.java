package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.PowerSuppliers;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC13_Verify_PowerSuppliers_Screen extends AbstractTestNg {

    public PR163_TC13_Verify_PowerSuppliers_Screen() throws IOException {
    }

    @Test
    public void AccessPowerSupplier() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        System.out.println("\nPower Supplier Settings are accessible");
    }

    @Test
    public void PowerSupplierPageVerification() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.columnVerification();
    }
//Passed
    @Test
    public void EditSupplier() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplier("Engie", "CNG", "0", "1", "0.1", true, true);
       // powerSuppliers.editSupplier("OVO", "CNG", "0", "1", "0.1", true, true);
    }
//Passed
    @Test
    public void Mapping() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.mapSupplier("OVO", "OVO", true);
    }
//Passed
    @Test
    public void rangeValidations () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("TOTAL", "", "TOTAL", "TOTAL", "TOTAL", "TOTAL");
        powerSuppliers.rangeValidations();
        powerSuppliers.cancelSupplier();
    }
//Passed
    @Test
    public void mandatoryValidations () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("Eon Next", "", "", "", "", "");
        powerSuppliers.mandatoryValidations();
        powerSuppliers.cancelSupplier();
    }

    @Test
    public void greaterValidation () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("Engie", "Engie", "Automation Quote Text", "10", "2", "0.2");
        powerSuppliers.greaterValidation();
        powerSuppliers.cancelSupplier();
    }
}
