package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_19_UnavailableApps extends AbstractTestNg {

    public PR147_19_UnavailableApps() throws IOException {
    }

    @Test
    public void Inactivetile() throws InterruptedException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnApps']")).click();
        Thread.sleep(1000);
     //   driver.findElement(By.xpath("//*[@id='appTrayList']//div[text()= 'SystemsLink Web Portal']//..")).click();
      //  System.out.println("You are not authorised to access the SystemsLink Portal.");
    }
}