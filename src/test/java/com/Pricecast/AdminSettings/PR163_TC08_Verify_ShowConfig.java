package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.ShowConfig;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC08_Verify_ShowConfig extends AbstractTestNg {



    public PR163_TC08_Verify_ShowConfig() throws IOException {
    }

    @Test
    public void AccessShowConfig() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.verifyShowConfig();
    }

    @Test
    public void exportExcel() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.exportExcel();
    }

    @Test
    public void uploadConfig() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.uploadConfig();
    }

    @Test
    public void errorValidation() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.errorValidation();
    }
}
