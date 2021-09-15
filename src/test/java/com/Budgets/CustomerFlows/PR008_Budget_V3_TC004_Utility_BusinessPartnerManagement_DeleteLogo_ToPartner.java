package com.Budgets.CustomerFlows;

import com.Base.AbstractCustomer;
import com.Budgets.PageHandlers.PartnersPageHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PR008_Budget_V3_TC004_Utility_BusinessPartnerManagement_DeleteLogo_ToPartner extends AbstractCustomer {

    public PR008_Budget_V3_TC004_Utility_BusinessPartnerManagement_DeleteLogo_ToPartner() throws IOException {
    }
    @Test
    public void testCase() {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	webDriverHandler.byId(prop.getProperty("AllApplications")).click();
	webDriverHandler.byXpath(prop.getProperty("BusinessPartnerManagement")).click();
	PartnersPageHandler partnersPageHandler = new PartnersPageHandler(webDriverHandler, prop);
	partnersPageHandler.createPartner("jpg");
	partnersPageHandler.validateImage();
    }
}