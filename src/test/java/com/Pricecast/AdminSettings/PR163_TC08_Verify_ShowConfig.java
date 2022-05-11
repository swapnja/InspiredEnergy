package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.ShowConfig;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC08_Verify_ShowConfig extends AbstractTestNg {


//Done
    public PR163_TC08_Verify_ShowConfig() throws IOException {
    }
  //Done
    @Test
    public void AccessShowConfig() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.verifyShowConfig();
    }
  //Done
    @Test
    public void exportExcel() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.exportExcel();
    }
  //Done
    @Test
    public void uploadConfig() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.uploadConfig();
    }

  //Done
    @Test
    public void errorValidation() {
        ShowConfig showConfig = new ShowConfig(webDriverHandler);
        showConfig.accessAdminSettings();
        showConfig.accessShowConfig();
        showConfig.waitLoad();
        showConfig.errorValidation();
    }
}
