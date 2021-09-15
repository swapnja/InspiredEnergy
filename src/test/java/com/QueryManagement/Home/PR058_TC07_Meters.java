package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC07_Meters extends AbstractTestNg {
    public PR058_TC07_Meters() throws IOException {
    }

    @Test
    public void AccessMeters() {
        Meters meters = new Meters(webDriverHandler);
        meters.accessSubCategory("Billing", "Bill too high");
        meters.selectEntry(15);
        meters.scrollToMeters();
        meters.columnVerification();
    }

    @Test
    public void QueryFilters() {
        Meters meters = new Meters(webDriverHandler);
        meters.accessSubCategory("Billing", "Bill too high");
        meters.selectEntry(15);
        meters.scrollToMeters();
        meters.accessAddMeters();
        meters.meterFilters("Supplier", "Avanti Gas", "EDF", "Crown");
        meters.meterFilters("Utility", "Electricity", "Water");
        meters.meterFiltersReset();
    }

    @Test
    public void AddMeter() {
        Meters meters = new Meters(webDriverHandler);
        meters.accessSubCategory("Billing", "Bill too high");
        meters.selectEntry(15);
        meters.scrollToMeters();
        meters.accessAddMeters();
        meters.addMeter("3002847496W14");
        meters.accessAddMeters();
        meters.addMeter("1300035373622");
        meters.verifySelection("9096615904");
    }

    @Test
    public void EditMeter() {
        Meters meters = new Meters(webDriverHandler);
        meters.accessSubCategory("Billing", "Bill too high");
        meters.selectEntry(15);
        meters.scrollToMeters();
        meters.actionMeter("Completed", "3002847496W14");
        meters.actionMeter("Delete", "3002847496W14");
        meters.actionMeter("Completed", "1300035373622");
        meters.actionMeter("Delete", "1300035373622");
        meters.actionMeter("Completed", "9096615904");
        meters.actionMeter("Delete", "9096615904");
    }

    @Test
    public void ErrorValidation() {
        Meters meters = new Meters(webDriverHandler);
        meters.accessSubCategory("Billing", "Bill too high");
        meters.selectEntry(15);
        meters.scrollToMeters();
        meters.errorValidation();
    }
}