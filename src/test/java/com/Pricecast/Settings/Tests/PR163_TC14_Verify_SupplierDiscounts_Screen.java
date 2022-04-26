package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierDiscount;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC14_Verify_SupplierDiscounts_Screen extends AbstractTestNg {
    public PR163_TC14_Verify_SupplierDiscounts_Screen() throws IOException {
    }
//Passed
    @Test
    public void SupplierDiscountsSuccess_Gas() throws InterruptedException {
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectGasSupplier();
        supplierDiscount.addNewRow("12", "101", "11");
    }
//Passed
    @Test
    public void SupplierDiscountsSuccess_Power() throws InterruptedException {
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectPowerSupplier();
        supplierDiscount.addNewRow("10", "50", "25");
    }
//Passed
    @Test
    public void columnVerification_Gas() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectGasSupplier();
        supplierDiscount.columnVerification();
    }
//Passed
    @Test
    public void rangeValidation_Gas() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectGasSupplier();
        supplierDiscount.addNewRowValidations("1.2", "-6", "-0.356");
        supplierDiscount.rangeValidations();
    }
//Passed
    @Test
    public void mandatoryValidation_Gas() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectGasSupplier();
        supplierDiscount.addNewRowValidations("", "", "");
        supplierDiscount.mandatoryValidations();
    }
//Passed
    @Test
    public void greaterValidation_Gas() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectGasSupplier();
        supplierDiscount.addNewRowValidations("10", "5", "25");
        supplierDiscount.greaterValidation();
    }

    @Test
    public void columnVerification_Power() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectPowerSupplier();
        supplierDiscount.columnVerification();
    }
//Passed
    @Test
    public void rangeValidation_Power() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectPowerSupplier();
        supplierDiscount.addNewRowValidations("1.2", "-6", "-0.356");
        supplierDiscount.rangeValidations();
    }
//Passed
    @Test
    public void mandatoryValidation_Power() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectPowerSupplier();
        supplierDiscount.addNewRowValidations("", "", "");
        supplierDiscount.mandatoryValidations();
    }
//Passed
    @Test
    public void greaterValidation_Power() throws InterruptedException{
        SupplierDiscount supplierDiscount = new SupplierDiscount(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierDiscount.selectSettings();
        sas.selectPowerSupplier();
        supplierDiscount.addNewRowValidations("10", "5", "25");
        supplierDiscount.greaterValidation();
    }
}
