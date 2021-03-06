package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC073_Calculate_Budget_VAT_Toggle_Gas extends AbstractTestNg {
    public PR008_Budget_V3_TC073_Calculate_Budget_VAT_Toggle_Gas() throws IOException {
    }
    @Test
    public void VATBudgetCalculate() throws InterruptedException, IOException {
        String xlPathMeter = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/Meter_Green.xlsx").toAbsolutePath().toString();
        String xlPathConsumption = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/Consumption_Green.xlsx").toAbsolutePath().toString();
        String xlPathRTB = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/RateTimeBand_Green.xlsx").toAbsolutePath().toString();
        String xlPathContractCharges = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/ContractCharges_Green.xlsx").toAbsolutePath().toString();
        String xlPathReference = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/ReferencePrices_Green.xlsx").toAbsolutePath().toString();
        String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Gas/Information/InformationTab_Green/ConsumptionAdjustment_Green.xlsx").toAbsolutePath().toString();

        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.waitLoad();
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createBudgetVATGas();
        InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
        iigh.InformationImportFileUpload("GasMeters", xlPathMeter);
        iigh.InformationImportFileUpload("GasConsumption", xlPathConsumption);
        iigh.InformationImportFileUpload("GasRateTimeBands", xlPathRTB);
        iigh.InformationImportFileUpload("GasContractCharges", xlPathContractCharges);
        iigh.InformationImportFileUpload("GasReferencePrices", xlPathReference);
        iigh.InformationImportFileUpload("GasConsumptionAdjustment", xlPathConsumptionAdjustment);
        InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
        infoHand.InformationVerifyCalculate();
        infoHand.InformationTotalCalculate();
        webDriverHandler.byXpath(prop.getProperty("GoBack")).click();
        budgetPageHandler.createBudgetVATGas();
        iigh.InformationImportFileUpload("GasMeters", xlPathMeter);
        iigh.InformationImportFileUpload("GasConsumption", xlPathConsumption);
        iigh.InformationImportFileUpload("GasRateTimeBands", xlPathRTB);
        iigh.InformationImportFileUpload("GasContractCharges", xlPathContractCharges);
        iigh.InformationImportFileUpload("GasReferencePrices", xlPathReference);
        iigh.InformationImportFileUpload("GasConsumptionAdjustment", xlPathConsumptionAdjustment);
        infoHand.InformationVerifyCalculate();
        webDriverHandler.byXpath(prop.getProperty("VATToggle")).click();
        webDriverHandler.byXpath(prop.getProperty("SaveInformation")).click();
        webDriverHandler.byXpath(prop.getProperty("OkInformation")).waitClickable().click();
        infoHand.InformationTotalCalculate();
    }
}
