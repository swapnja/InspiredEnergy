//AutoII Abstract
package com.AutoII;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Base.ExtentReportBase;
import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.FailureUtils;
import com.Budgets.TimeStampPageHandler;

public class AbstractTestNg extends ExtentReportBase {

    public Properties prop;
    public TimeStampPageHandler ts;
    public WebDriver driver;
    public WebDriverHandler webDriverHandler;
    public LoginPageHandler logAuto;

    public AbstractTestNg() throws IOException {
    	prop = ReadPropertyFile.getProperties();
        ts = new TimeStampPageHandler();
       
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
        
    }

    @BeforeClass
    public void launchBrowser() throws InterruptedException {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        webDriverHandler = new WebDriverHandler(driver);
       // webDriverHandler = new WebDriverHandler(ChromeDriverOptions.getHeadlessBrowser());
        driver.manage().window().maximize();
        DesiredCapabilities caps = new DesiredCapabilities(); caps.setCapability("resolution", "1920x1080");
        driver.get(prop.getProperty("url"));
        logAuto = new LoginPageHandler(webDriverHandler, prop);
        logAuto.Login();
    }

    @BeforeMethod
    public void accessCIR() {
        driver.get(prop.getProperty("url"));
        logAuto.accessAutoII();
    }

    @AfterMethod
    public void handleFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String name = this.getClass().getSimpleName();
            FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\CIR\\"+name);
        }
    }

    @AfterClass
    public void terminateBrowser()  {
    	//String systype = System.getProperty("os.name").toLowerCase();
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }
}
