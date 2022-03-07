//Verify Information tab on Budget Console Screen 

package com.ClientPortal.PageObjects;

import com.Base.ExtentReportBase;
import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.FailureUtils;
import com.Budgets.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractTestNg extends ExtentReportBase{

	public Properties prop;
	public TimeStampPageHandler ts;
	public WebDriver driver;
	public WebDriverHandler webDriverHandler;
	public LoginPageHandler logClientPortal;

	public AbstractTestNg() throws IOException {
		prop = ReadPropertyFile.getProperties();
		ts = new TimeStampPageHandler();
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
	}


	@BeforeClass
	public void launchBrowser() throws IOException, InterruptedException{
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setHeadless(true);
		//chromeOptions.addArguments("--window-size=1920,1080");
		//driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		webDriverHandler = new WebDriverHandler(driver);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		logClientPortal = new LoginPageHandler(webDriverHandler, prop);
		logClientPortal.Login();
	}

	@BeforeMethod
	public void accessAutoII() {
		driver.get(prop.getProperty("url"));
		logClientPortal.accessCP();
	}

	@AfterMethod
	public void handleFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String name = this.getClass().getSimpleName();
//			FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\ClientPortal\\"+name);
		}
	}

	@AfterClass
	public void terminateBrowser() throws IOException {
	//String systype = System.getProperty("os.name").toLowerCase();
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");	
		}
}