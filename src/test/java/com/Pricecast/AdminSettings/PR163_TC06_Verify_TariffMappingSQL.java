package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.TariffMappingSQL;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC06_Verify_TariffMappingSQL extends AbstractTestNg {

    public PR163_TC06_Verify_TariffMappingSQL() throws IOException {
    }

    @Test
    public void AccessTariffMapping() {
        TariffMappingSQL tariffMapping = new TariffMappingSQL(webDriverHandler);
        tariffMapping.accessAdminSettings();
        tariffMapping.accessTariffMapping();
        tariffMapping.verifyTariffMapping();
    }

    @Test
    public void addMapping() {
        TariffMappingSQL tariffMapping = new TariffMappingSQL(webDriverHandler);
        tariffMapping.accessAdminSettings();
        tariffMapping.accessTariffMapping();
        tariffMapping.addMappingRow("Test", "Gas", "TestMapping", "TestDescription", "1", true, false, true, "SQL Query");
        tariffMapping.deleteMapping("Test", "Gas");
    }

    @Test
    public void deleteMapping() {
        TariffMappingSQL tariffMapping = new TariffMappingSQL(webDriverHandler);
        tariffMapping.accessAdminSettings();
        tariffMapping.accessTariffMapping();
        tariffMapping.addMappingRow("Test", "Gas", "TestMapping", "TestDescription", "1", true, false, true, "SQL Query");
        tariffMapping.deleteMapping("Test", "Gas");
    }

    @Test
    public void editMapping() {
        TariffMappingSQL tariffMapping = new TariffMappingSQL(webDriverHandler);
        tariffMapping.accessAdminSettings();
        tariffMapping.accessTariffMapping();
        tariffMapping.addMappingRow("Test", "Gas", "TestMapping", "TestDescription", "1", true, false, true, "SQL Query");
        tariffMapping.editMapping("Test", "Gas","TestEdit","Power", "TestMappingEdit", "TestDescriptionEdit", "0", false, true, true, "SQL Query Edit");
        tariffMapping.deleteMapping("TestEdit", "Power");
    }

    @Test
    public void errorValidations() {
        TariffMappingSQL tariffMapping = new TariffMappingSQL(webDriverHandler);
        tariffMapping.accessAdminSettings();
        tariffMapping.accessTariffMapping();
        tariffMapping.addErrorMappingRow();
        tariffMapping.mandatoryValidations();
        tariffMapping.cancelMapping();
    }
}
