package com.ClientPortal;

import com.Base.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR147_08_Customerlogin {

    @Test
    public void CustomerloginCP() throws IOException {
        Properties prop = ReadPropertyFile.getProperties();
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testunify.systems-link.com/Core/Home/Login");
        WebElement w1, w2;
        WebDriverWait wait = new WebDriverWait(driver, 100);
        w1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Email']")));
        w1.sendKeys("swapnjagudle2@gmail.com");
        w2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Password']")));
        w2.sendKeys("Admin@1234");
        driver.findElement(By.xpath("//*[@id='loginForm']/button[@type='submit' and contains(text(),'Login')]")).click();
        driver.quit();
    }
}
