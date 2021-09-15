package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_07_CompanyBasicInfo extends AbstractTestNg {

    public PR147_07_CompanyBasicInfo() throws IOException {
    }

    @Test
    public void CompBasicInfo() throws InterruptedException, IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='partnerTable']//tr[5]").click();
        webDriverHandler.byXpath("(//label[@class='switch'])[1]").click();
//        Thread.sleep(1000);
//        webDriverHandler.byXpath("(//label[@class='switch'])[2]").click();
//        webDriverHandler.byXpath("(//label[@class='switch'])[3]").click();
//        webDriverHandler.byXpath("(//label[@class='switch'])[4]").click();
//        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement save = driver.findElement(By.xpath("//*[@id='btnSave']"));
        js.executeScript("arguments[0].scrollIntoView(true);", save);
        webDriverHandler.byXpath("//*[@id='btnSave']").click();
        Thread.sleep(1000);
        webDriverHandler.byXpath("//*[contains(text(),'OK')]").click();
    }
}