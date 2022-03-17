package com.CompaniesAndContacts;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_18_TopNavigations extends AbstractTestNg {

    public PR147_18_TopNavigations() throws IOException {
    }

    @Test
    public void TopNavigationButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        driver.findElement(By.xpath("//*[@id='btnApps']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='popoutTray']/div/a")).click();
        driver.findElement(By.xpath("//li[@class='nav-item']/a[@title='Administration']")).click();
        driver.findElement(By.xpath("//li[@class='nav-item']/a[@title='Quick Links']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='DivClose']")).click();
        driver.findElement(By.xpath("//li[@class='nav-item']/a[@title='Your Profile']")).click();
        driver.findElement(By.xpath("//*[@href='#eventSubscriptionContent']")).click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        WebElement w3;
        w3 = driver.findElement(By.xpath("//label[@class='switch']/span[@class='slider round']"));
        Thread.sleep(1000);
        if (w3.isSelected()) {
            wait.until(ExpectedConditions.elementToBeClickable(w3)).click();
            System.out.println("connections");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(w3)).click();
            System.out.println("ELSE");
        }
        //  driver.findElement(By.xpath("//tbody/tr[2]/td[2]/label/span[@class='slider round']")).click();
        driver.findElement(By.xpath("//div[@class='col-12']/button[@class='btn btn-sm btn-primary float-right' and contains(text(),'Save')]")).click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        driver.findElement(By.xpath("//li[@class='nav-item']/a[@title='Logout']")).click();
    }
}
