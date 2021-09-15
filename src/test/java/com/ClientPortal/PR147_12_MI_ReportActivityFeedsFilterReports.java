package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_12_MI_ReportActivityFeedsFilterReports extends AbstractTestNg {

    public PR147_12_MI_ReportActivityFeedsFilterReports() throws IOException {
    }

    @Test
    public void MIReport() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='/CompanyManagement/MI/Index']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@href='#activityFeedContent']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='fa fa-filter']")).click();

        // Filters- Users //
        Thread.sleep(1000);
        WebElement mySelectElement = driver.findElement(By.id("ddlCompany"));
        Thread.sleep(2000);
        Select dropdown = new Select(mySelectElement);
        Thread.sleep(2000);
        dropdown.selectByValue("saha-customer");
        dropdown.selectByValue("TEST_CLOUDENERGY");
        dropdown.selectByValue("Test32");
        dropdown.selectByValue("BUd164");
        dropdown.selectByValue("Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnActivityApplyFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnActivityResetFilter']")).click();


        // Filters- Company Type //
        Thread.sleep(1000);
        WebElement mySelectElement1 = driver.findElement(By.id("ddlCompanyType"));
        Thread.sleep(2000);
        Select dropdown1 = new Select(mySelectElement1);
        Thread.sleep(2000);
        dropdown1.selectByValue("Customer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnActivityApplyFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnActivityResetFilter']")).click();

//        // Filters-RevenueOwner //
//        Thread.sleep(1000);
//        WebElement mySelectElement2 = driver.findElement(By.id("ddlRevenueOwner"));
//        Thread.sleep(1000);
//        Select dropdown2 = new Select(mySelectElement2);
//        Thread.sleep(1000);
//        dropdown.selectByValue("David Moorhouse");
//        driver.findElement(By.xpath("//*[@id='btnActivityApplyFilter']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id='btnActivityResetFilter']")).click();
//
//        // Filters-AccountManager //
//        WebElement mySelectElement3 = driver.findElement(By.id("ddlAccountManager"));
//        Thread.sleep(1000);
//        Select dropdown3 = new Select(mySelectElement3);
//        Thread.sleep(1000);
//        dropdown.selectByValue("David Moorhouse");
//        driver.findElement(By.xpath("//*[@id='btnActivityApplyFilter']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id='btnActivityResetFilter']")).click();

        // Count Logins //
        //driver.findElement(By.xpath("//*[@id='btnActivityResetFilter']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='countEntryMin']")).click();
        Thread.sleep(1000);
        WebElement field = driver.findElement(By.id("countEntryMin"));
        field.sendKeys("6");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='countEntryMax']")).click();
        Thread.sleep(1000);
        WebElement fields = driver.findElement(By.id("countEntryMax"));
        fields.sendKeys("6");
        driver.findElement(By.xpath("//*[@id='btnActivityApplyFilter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='btnReports']")).click();
    }
}
