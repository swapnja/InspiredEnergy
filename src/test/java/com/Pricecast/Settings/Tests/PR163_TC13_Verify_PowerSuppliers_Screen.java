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

    @Test
    public void EditSupplier() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplier("Axis", "AXIS", "0", "1", "0.1", true, true);
    }

    @Test
    public void Mapping() {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.mapSupplier("BG Lite", "BGLiteVPP", true);
    }

    @Test
    public void rangeValidations () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("Axis", "AXIS", "txt", "txt", "txt", "txt");
        powerSuppliers.rangeValidations();
        powerSuppliers.cancelSupplier();
    }

    @Test
    public void mandatoryValidations () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("Axis", "", "", "", "", "");
        powerSuppliers.mandatoryValidations();
        powerSuppliers.cancelSupplier();
    }

    @Test
    public void greaterValidation () {
        PowerSuppliers powerSuppliers = new PowerSuppliers(webDriverHandler);
        powerSuppliers.selectSettings();
        powerSuppliers.editSupplierNoTgl("Axis", "AXIS", "Quote Text", "10", "2", "0.2");
        powerSuppliers.greaterValidation();
        powerSuppliers.cancelSupplier();
    }
}
