package com.AutoII;

import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.FailureUtils;
import com.Budgets.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PR184_TCO5_CustomerLogin {
    public Properties prop;
    public TimeStampPageHandler ts;
    public WebDriver driver;
    public WebDriverHandler webDriverHandler;
    public AutoInstantInsights autoInstantInsights;

    public PR184_TCO5_CustomerLogin() throws IOException {
        prop = ReadPropertyFile.getProperties();
        ts = new TimeStampPageHandler();
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
    }

    @BeforeMethod
    public void launchBrowser() throws IOException{
    	//CICD changes
    	//ChromeOptions chromeOptions = new ChromeOptions();
	//	chromeOptions.setHeadless(true);
	//	chromeOptions.addArguments("--window-size=1920,1080");
	//	driver = new ChromeDriver(chromeOptions);
		
        driver = new ChromeDriver();
        webDriverHandler = new WebDriverHandler(driver);
        driver.manage().window().maximize();
        driver.get("https://testunify.systems-link.com/Core/Home/Login");
        webDriverHandler.byXpath(prop.getProperty("CustomerUserID")).sendKeys("swapnjagudle2@gmail.com");
        webDriverHandler.byXpath(prop.getProperty("CustomerPassword")).sendKeys("Admin@1234");
        webDriverHandler.byXpath(prop.getProperty("CustomerLogin")).waitClickable().click();
        webDriverHandler.byId(prop.getProperty("AllApplications")).waitVisible().waitClickable().click();
        webDriverHandler.byXpath(prop.getProperty("AutoII")).waitClickable().click();
        autoInstantInsights = new AutoInstantInsights(webDriverHandler);
    }
    @AfterMethod
    public void terminateBrowser(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            driver.quit();
        }
        else {
            String name = this.getClass().getSimpleName();
            FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\"+name);
        }
    }

    @Test
    public void verifyCustomer() throws IOException {
        autoInstantInsights.verifyCustomer();
        autoInstantInsights.verifyReplyModal();
        autoInstantInsights.sendMessage();
        autoInstantInsights.sendReply();
    }

    @Test
    public void errorValidation() throws IOException {
        autoInstantInsights.errorValidationsCustomer();
    }

    @Test
    public void verifyCharacterCount() throws IOException {
        autoInstantInsights.verifyCharacterCountMessage();
        autoInstantInsights.verifyCharacterCountReply();
    }
}