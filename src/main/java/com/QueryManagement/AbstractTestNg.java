package com.QueryManagement;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.FailureUtils;
import com.Budgets.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public class AbstractTestNg {

    public Properties prop;
    public TimeStampPageHandler ts;
    public WebDriver driver;
    public WebDriverHandler webDriverHandler;
    public LoginPageHandler logQM;

    public AbstractTestNg() throws IOException {
        prop = ReadPropertyFile.getProperties();
        ts = new TimeStampPageHandler();
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
    }

    @BeforeClass
    public void launchBrowser() throws IOException{
        driver = new ChromeDriver();
        webDriverHandler = new WebDriverHandler(driver);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        logQM = new LoginPageHandler(webDriverHandler, prop);
        logQM.Login();
    }

    @BeforeMethod
    public void accessQMP() {
        driver.get(prop.getProperty("url"));
        logQM.accessQueryManagement();
    }
    
    @AfterMethod
    public void handleFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String name = this.getClass().getSimpleName();
            FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\QMP\\"+name);
        }
    }

    @AfterClass
    public void terminateBrowser() {
        //driver.quit();
    }
}
