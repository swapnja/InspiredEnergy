package com.BulkScanning.CommonMethods;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.FailureUtils;
import com.Budgets.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.Properties;

public class AbstractTestNg {

    public Properties prop;
    public TimeStampPageHandler ts;
    public WebDriver driver;
    public WebDriverHandler webDriverHandler;
    public  LoginPageHandler logBS;

    public AbstractTestNg() throws IOException {
        prop = ReadPropertyFile.getProperties();
        ts = new TimeStampPageHandler();
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
        ChromeOptions chromeOptions = new ChromeOptions();
    }

    @BeforeClass
    public void launchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverHandler = new WebDriverHandler(driver);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        logBS = new LoginPageHandler(webDriverHandler, prop);
        logBS.Login();
    }

    @BeforeMethod
    public void accessBulk() {
        driver.get(prop.getProperty("url"));
        logBS.accessBulkScanning();
    }

    @AfterMethod
    public void handleFailure(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            String name = this.getClass().getSimpleName();
            FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\BulkScanning\\"+name);
        }
    }

    @AfterClass
    public void terminateBrowser(ITestContext result) {
        if (result.getFailedTests().size()==0 && result.getSkippedTests().size()==0) {
            driver.quit();
        }
    }
}
