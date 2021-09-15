//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC066_BudgetConsole_Gas_InformationTab_InvalidInput_Red extends AbstractTestNg {

    public PR008_Budget_V3_TC066_BudgetConsole_Gas_InformationTab_InvalidInput_Red() throws IOException {
    }

    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
        String xlPathMeter = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/Meter_Red.xlsx").toAbsolutePath().toString();
        String xlPathConsumption = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/Consumption_Red.xlsx").toAbsolutePath().toString();
        String xlPathRTB = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/RateTimeBand_Red.xlsx").toAbsolutePath().toString();
        String xlPathContractCharges = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/ContractCharges_Red.xlsx").toAbsolutePath().toString();
        String xlPathReference = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/ReferencePrices_Red.xlsx").toAbsolutePath().toString();
        String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Gas/Information/InformationTab_Red/ConsumptionAdjustment_Red.xlsx").toAbsolutePath().toString();

        CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
        customersPageHandler.waitLoad();
        customersPageHandler.filterCustomers("Automation");
        customersPageHandler.selectFirstCustomer();
        CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
        budgetPageHandler.createBudgetMonthlyGas();
        InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
        iigh.InformationErrorFileUpload("GasMeters", xlPathMeter);
        iigh.InformationErrorFileUpload("GasConsumption", xlPathConsumption);
        iigh.InformationErrorFileUpload("GasRateTimeBands", xlPathRTB);
        iigh.InformationErrorFileUpload("GasContractCharges", xlPathContractCharges);
        iigh.InformationErrorFileUpload("GasReferencePrices", xlPathReference);
        iigh.InformationErrorFileUpload("GasConsumptionAdjustment", xlPathConsumptionAdjustment);
        InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
        infoHand.InformationFailedCalculate();
    }
}