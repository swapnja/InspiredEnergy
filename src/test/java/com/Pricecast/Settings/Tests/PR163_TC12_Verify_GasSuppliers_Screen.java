package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.GasSuppliers;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC012_Verify_GasSuppliers_Screen extends AbstractTestNg {

    public PR163_TC012_Verify_GasSuppliers_Screen() throws IOException {
    }

    @Test
    public void AccessGasSupplier() {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        System.out.println("\nGas Supplier Settings are accessible");
    }

    @Test
    public void GasSupplierPageVerification() {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.columnVerification();
    }

    @Test
    public void EditSupplier() {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.editSupplier("Axis", "AXIS", "0", "1", "0.1", true, true);
    }

    @Test
    public void Mapping() {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.mapSupplier("Corona", "xlsx", true);
    }

    @Test
    public void rangeValidations () {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.editSupplierNoTgl("Axis", "AXIS", "txt", "txt", "txt", "txt");
        gasSuppliers.rangeValidations();
        gasSuppliers.cancelSupplier();
    }

    @Test
    public void mandatoryValidations () {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.editSupplierNoTgl("Axis", "", "", "", "", "");
        gasSuppliers.mandatoryValidations();
        gasSuppliers.cancelSupplier();
    }

    @Test
    public void greaterValidation () {
        GasSuppliers gasSuppliers = new GasSuppliers(webDriverHandler);
        gasSuppliers.selectSettings();
        gasSuppliers.editSupplierNoTgl("Axis", "AXIS", "Quote Text", "10", "2", "0.2");
        gasSuppliers.greaterValidation();
        gasSuppliers.cancelSupplier();
    }
}