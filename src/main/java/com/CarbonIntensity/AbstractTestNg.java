package com.CarbonIntensity;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Base.ExtentReportBase;
import com.Base.ExtentTestManager;
import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.TimeStampPageHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AbstractTestNg extends ExtentReportBase  {
	
    public Properties prop;
    public TimeStampPageHandler ts;
    public WebDriver driver;
    public WebDriverHandler webDriverHandler;
    public LoginPageHandler logCIR;
    public static ExtentSparkReporter  spark ;
    public static ExtentReports extent; 
    public  ExtentTest test;

    public AbstractTestNg() throws IOException {
    	prop = ReadPropertyFile.getProperties();
        ts = new TimeStampPageHandler();       
        System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
        
    }
    /* @BeforeSuite 
    public void setUp()
    {
        spark = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/extentReport.html");
        extent = new ExtentReports();
        test = extent.createTest("CarbonIntensity suite");
        extent.attachReporter(spark);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "Test");
        extent.setSystemInfo("Environment", "QA-Staging Envionment");
        extent.setSystemInfo("User Name", "Swapnja Gudle");

      //  spark.config().setChartVisibilityOnOpen(true);
        spark.config().setDocumentTitle("Extent report");
        spark.config().setReportName("Final Report");
    }
*/
    @BeforeClass
    public void launchBrowser() {
    
        driver = new ChromeDriver();
        webDriverHandler = new WebDriverHandler(driver);
       // webDriverHandler = new WebDriverHandler(ChromeDriverOptions.getHeadlessBrowser());
        driver.manage().window().maximize();
        DesiredCapabilities caps = new DesiredCapabilities(); caps.setCapability("resolution", "1920x1080");
        driver.get(prop.getProperty("url"));
        logCIR = new LoginPageHandler(webDriverHandler, prop);
        logCIR.Login();
    }

    @BeforeMethod
    public void accessCIR() {
      driver.get(prop.getProperty("url"));
       logCIR.accessCIR();
    }
/*
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
*/

    @AfterClass
    public void terminateBrowser() {
       driver.quit();
      
    }
    /* @AfterSuite
    public void tearDown(){
    	 extent.flush();
       }
       */
    }

