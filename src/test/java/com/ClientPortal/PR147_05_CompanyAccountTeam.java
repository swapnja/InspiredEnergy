package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_05_CompanyAccountTeam extends AbstractTestNg {

    public PR147_05_CompanyAccountTeam() throws IOException {
    }

    @Test
    public void ComAccTem() throws InterruptedException, IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='partnerTable']//tr[5]").waitClickable(15,100).click();
        webDriverHandler.byXpath("//*[@href='#accountTeamContent']").click();
        Thread.sleep(1000);
        webDriverHandler.byXpath("//*[@id='btnAddManager']").click();
        webDriverHandler.byId("AccountManagerId").selectByText("Andrew Curry");
        webDriverHandler.byId("TeamMemberRoleId").selectByText("Billing");
        webDriverHandler.byXpath("(//*[@id='newUserForm']//*[contains(text(),' Save')])[2]").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled']").click();
        // thumbs-up//
        webDriverHandler.byXpath("//tr[td/text() = 'Andrew Curry']//i[@class='fas fa-thumbs-up']").click();
        webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        System.out.println("The contact should be made the primary contact and display on Dashboard");
        // eye button //
        webDriverHandler.byXpath("//tr[td/text() = 'Andrew Curry']//i[@class='fas fa-eye']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        System.out.println("Toggle Show Contact on Dashboard");
        // Move Member Up //
        webDriverHandler.byXpath("//tr[td/text() = 'Andrew Curry']//i[@class='fas fa-long-arrow-alt-up']").click();
        System.out.println("Move Member Up");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        // Move Member Down //
        webDriverHandler.byXpath("//tr[td/text() = 'Andrew Curry']//i[@class='fas fa-long-arrow-alt-down']").click();
        System.out.println("Move Member Down");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        // delete record
        webDriverHandler.byXpath("//tr[td/text() = 'Andrew Curry']//i[@class='fas fa-minus-circle']").click();
        webDriverHandler.byXpath("//button[contains(text(),'Yes')]").click();
    }
}
