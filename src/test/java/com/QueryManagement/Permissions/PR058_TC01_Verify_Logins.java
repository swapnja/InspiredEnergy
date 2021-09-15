package com.QueryManagement.Permissions;

import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PR058_TC01_Verify_Logins {

    Properties prop = ReadPropertyFile.getProperties();
    WebDriver driver;
    WebDriverHandler webDriverHandler;

    public PR058_TC01_Verify_Logins() throws IOException {
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
    }

    @BeforeClass
    public void launchBrowser() throws IOException{
        driver = new ChromeDriver();
        webDriverHandler = new WebDriverHandler(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyCustomerLogin () {
        driver.get("https://testcumulus7.cloudenergysoftware.com/Core/Home/Login");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("gsatyajit86@gmail.com");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id='loginForm']/button")).submit();
        webDriverHandler.byId(prop.getProperty("AllApplications")).waitVisible().waitClickable().click();
        webDriverHandler.byXpath(prop.getProperty("QueryManagement")).waitClickable().click();
        Logins login = new Logins(webDriverHandler);
        login.accessSubCategory("Billing", "Incorrect Rates");
        login.verifyImports();
        login.verifyBulk();
    }

    @Test
    public void verifySupplierLogin () {
        driver.get("https://testcumulus7.cloudenergysoftware.com/Core/Home/Login");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("sattugudle09@gmail.com");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id='loginForm']/button")).submit();
        webDriverHandler.byId(prop.getProperty("AllApplications")).waitVisible().waitClickable().click();
        webDriverHandler.byXpath(prop.getProperty("QueryManagement")).waitClickable().click();
        Logins login = new Logins(webDriverHandler);
        login.accessSubCategory("Billing", "Incorrect Rates");
        login.verifyImports();
        login.verifyBulk();
    }
}
