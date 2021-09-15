package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_06_CompanyActivityFeed extends AbstractTestNg {

    public PR147_06_CompanyActivityFeed() throws IOException {
    }

    @Test
    public void CompActivityFeed() throws IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='partnerTable']//tr[5]").click();
        webDriverHandler.byXpath("//*[@href='#activityContent']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='btnAddActivity']").click();
        webDriverHandler.byXpath("//*[@id='ActivityNote']").sendKeys("Automation Customer");
        webDriverHandler.byXpath("//button[@class='btn btn-sm btn-primary'][contains(text(),'Save')]").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[contains(text(),'OK')]").click();
        webDriverHandler.byXpath("//*[@id='activityTable']//tbody//tr[1]").click();
        webDriverHandler.byXpath("//*[@id='btnDelete']").click();
        webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled']").click();

    }
}
