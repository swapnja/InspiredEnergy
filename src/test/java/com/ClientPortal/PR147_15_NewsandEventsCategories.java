package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_15_NewsandEventsCategories extends AbstractTestNg {

    public PR147_15_NewsandEventsCategories() throws IOException {
    }

    @Test
    public void NewsEventandCategories() throws InterruptedException, IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        driver.findElement(By.xpath("//*[@href='/core/Administration/Dashboard']")).click();
        driver.findElement(By.xpath("//*[@href='/Core/NewsandEventsAdministration/NewsandEvents']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='/Core/NewsandEventsAdministration/EventCategories']")).click();
        System.out.println("Event Categories page should be displayed");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnNewEvent']")).click();
        System.out.println("New News and Event Category popup should be displayed");
        Thread.sleep(1000);
        WebElement w3 = driver.findElement(By.xpath("//*[@id='Title']"));
        w3.sendKeys("Expand your services with Energy Manager");
        driver.findElement(By.xpath("//label[@class='switch']//span[@class='slider round']")).click();
        driver.findElement(By.xpath("//*[@id='btnSaveEventCategory']")).click();
        driver.findElement(By.xpath("//div[@class='swal2-actions']//button[@class='swal2-confirm swal2-styled']")).click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@id='btnDelete']").waitClickable().click();
        driver.findElement(By.xpath("//div[@class='swal2-actions']//button[@class='swal2-confirm swal2-styled']")).click();

    }
}
