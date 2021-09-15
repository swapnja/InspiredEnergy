package com.Budgets.CustomerFlows;

import com.Base.AbstractCustomer;
import com.Budgets.PageHandlers.PartnersPageHandler;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC005_Utility_BusinessPartnerManagement_VerifyLogo_ExportFIle extends AbstractCustomer {

    public PR008_Budget_V3_TC005_Utility_BusinessPartnerManagement_VerifyLogo_ExportFIle() throws IOException {
    }
    @Test
    public void testCase() {
	webDriverHandler.byId(prop.getProperty("AllApplications")).click();
	webDriverHandler.byXpath(prop.getProperty("BusinessPartnerManagement")).waitClickable().click();
	PartnersPageHandler partnersPageHandler = new PartnersPageHandler(webDriverHandler, prop);
	partnersPageHandler.createPartner("jpg");
	partnersPageHandler.validateImage();
    }
}