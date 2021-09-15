package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_01_AccountManagers extends AbstractTestNg {

    public PR147_01_AccountManagers() throws IOException {
    }

    @Test
    public void AccManagersPage() throws IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@href='/CompanyManagement/AccountManager/Index']").waitClickable().click();
        System.out.println("Account Managers page should be displayed");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@href='/CompanyManagement/ManagerRoles/Index']").waitClickable().click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='btnNew']").waitClickable().click();
        webDriverHandler.byXpath("//*[@id='Name']").waitClickable().sendKeys("Delivery Manager");
        webDriverHandler.byXpath("//button[contains(text(),' Save')]").waitClickable().click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitClickable().click();
        webDriverHandler.byXpath("//input[@type='search']").sendKeys("Delivery Manager");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
		webDriverHandler.byXpath("//tr[td/text() = 'Delivery Manager']//button[@title='Delete']").waitClickable().click();
		webDriverHandler.byXpath("//button[contains(text(),'Yes')]").waitClickable().click();
    }
}
