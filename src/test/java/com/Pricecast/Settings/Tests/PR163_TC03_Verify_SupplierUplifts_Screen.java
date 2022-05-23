package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.SupplierUplifts;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC03_Verify_SupplierUplifts_Screen extends AbstractTestNg {

    public PR163_TC03_Verify_SupplierUplifts_Screen() throws IOException {
    }
//Pass
    @Test
    public void SupplierUpliftSuccess_Gas() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectGasSupplier();
        supplierUplifts.addNewRow(12, 1, 11, 1111, 1, 11, "(%AQ%/1000)*%GU%");

    }
//Pass
    @Test
    public void SupplierUpliftSuccess_Power() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectPowerSupplier();
        supplierUplifts.addNewRow(12, 1, 11, 1111, 1, 11, "(%EAC%/1000)*%GU%");
    }

//pass
    @Test
    public void columnVerification_Gas() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectGasSupplier();
        supplierUplifts.SupplierUpliftsColumnVerification();
    }

//pass
    @Test
    public void SupplierUplift_RangeValidation_Gas() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectGasSupplier();
        supplierUplifts.addNewRow(12, 1, -11, -1111, 1, 11, "(%AQ%/1000)*%GU%");
        supplierUplifts.SupplierUplift_RangeValidation();
        System.out.println("Broker Account functionality is working fine: BrokerAccount_RangeValidation");
    }

//pass
    @Test
    public void SupplierUplift_MandatoryValidations_Gas() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectGasSupplier();
        supplierUplifts.blankAddNewRow();
        supplierUplifts.SupplierUplift_MandatoryValidation();
    }
//pass
    @Test
    public void supplierUplift_NumericValidations_Gas() throws Exception {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectGasSupplier();
        supplierUplifts.addNewRowNumeric(12, 1, 6, 4, 1, 11, "(%AQ%/1000)*%GU%");
        supplierUplifts.SupplierUplift_NumericValidation();
    }

//fail
    @Test
    public void columnVerification_Power() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectPowerSupplier();
        supplierUplifts.SupplierUpliftsColumnVerification();
    }

//fail
    @Test
    public void SupplierUplift_RangeValidation_Power() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectPowerSupplier();
        supplierUplifts.addNewRow(12, 1, -11, -1111, 1, 11, "(%AQ%/1000)*%GU%");
        supplierUplifts.SupplierUplift_RangeValidation();
        System.out.println("Broker Account functionality is working fine: BrokerAccount_RangeValidation");
    }

//Pass
    @Test
    public void SupplierUplift_MandatoryValidations_Power() throws InterruptedException {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectPowerSupplier();
        supplierUplifts.blankAddNewRow();
        supplierUplifts.SupplierUplift_MandatoryValidation();
    }
//Pass
    @Test
    public void supplierUplift_NumericValidations_Power() throws Exception {
        SupplierUplifts supplierUplifts = new SupplierUplifts(webDriverHandler);
        supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
        supplierUplifts.selectSettings();
        sas.selectPowerSupplier();
        supplierUplifts.addNewRowNumeric(12, 1, 6, 4, 1, 11, "(%AQ%/1000)*%GU%");
    }
}

