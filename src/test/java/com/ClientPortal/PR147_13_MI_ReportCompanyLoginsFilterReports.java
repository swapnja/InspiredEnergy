package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;


public class PR147_13_MI_ReportCompanyLoginsFilterReports extends AbstractTestNg {

    public PR147_13_MI_ReportCompanyLoginsFilterReports() throws IOException {
    }

    @Test
    public void MIReport() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='/CompanyManagement/MI/Index']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/div/a[2]")).click();

        // Filters- Users //
        driver.findElement(By.xpath("//*[@id='loginTable']/thead/tr[2]/td/span[2]/span/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id='btnLoginResetFilter']")).click();
        WebElement mySelectElement = driver.findElement(By.id("ddlUsers"));
        Thread.sleep(1000);
        Select dropdown = new Select(mySelectElement);
        Thread.sleep(1000);
        dropdown.selectByValue("Adam Ford");
        Thread.sleep(1000);
        dropdown.selectByValue("anisha.mulik");
        Thread.sleep(1000);
        dropdown.selectByValue("Andrew Jackman");
        Thread.sleep(1000);
        dropdown.selectByValue("Paul Oliver");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnLoginApplyFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnLoginResetFilter']")).click();

        // Filters- User Roles //
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='loginTable']/thead/tr[2]/td/span[3]/span/div/button")).click();
        driver.findElement(By.xpath("//*[@id='btnLoginResetFilter']")).click();
        Thread.sleep(1000);
        WebElement dropdown1 = driver.findElement(By.id("ddlRoles"));
        Select select = new Select(dropdown1);
        Thread.sleep(1000);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnLoginApplyFilter']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnLoginResetFilter']")).click();

        // Count Logins //
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='countLoginMin']")).click();
        Thread.sleep(1000);
        WebElement field = driver.findElement(By.id("countLoginMin"));
        field.clear();
        field.sendKeys("1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='countLoginMax']")).click();
        Thread.sleep(1000);
        WebElement fields = driver.findElement(By.id("countLoginMax"));
        fields.clear();
        fields.sendKeys("100");
        driver.findElement(By.xpath("//*[@id='btnLoginApplyFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnReports']")).click();
    }

}
