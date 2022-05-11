package com.Pricecast.AdminSettings;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.AdminSettings.AdminSettings;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC01_Verify_Admin_Access extends AbstractTestNg {

    public PR163_TC01_Verify_Admin_Access() throws IOException {
    }
//done
    @Test
    public void AccessAdmin() {
        AdminSettings adminsettings = new AdminSettings(webDriverHandler);
        adminsettings.accessAdminSettings();
    }
}
