package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_10_LicenseesDashboardTypes extends AbstractTestNg {

    public PR147_10_LicenseesDashboardTypes() throws IOException {
    }

    @Test
    public void LicenDashboardTyeSimAdv() throws IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        driver.findElement(By.xpath("//*[@href='/core/Administration/Dashboard']")).click();
        driver.findElement(By.xpath("//*[@href='/Core/LicenseeAdministration/Licensees']")).click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        driver.findElement(By.xpath("//table[@id='companyTable']/tbody/tr[@id='1']/td[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement DashboardType = driver.findElement(By.xpath("//*[@id='DashboardType']"));
        js.executeScript("arguments[0].scrollIntoView(true);", DashboardType);
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='DashboardType']")));
        dropdown.selectByVisibleText("Advanced");
        driver.findElement(By.xpath("//form[@id='saveCompanyForm']//button[@type='submit']")).click();
        driver.quit();
    }
}
