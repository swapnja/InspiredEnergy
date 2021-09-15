//Verify Information tab on Budget Console Screen 

package com.Base;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class AbstractCustomer {

	public Properties prop;
	public TimeStampPageHandler ts;
	public WebDriver driver;
	public WebDriverHandler webDriverHandler;

	public AbstractCustomer() throws IOException {
		prop = ReadPropertyFile.getProperties();
		ts = new TimeStampPageHandler();
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}

	@BeforeTest
	public void launchBrowser() throws IOException {

	}

	@BeforeClass
	public void deleteCookie() {
	}

	@BeforeMethod
	public void login() throws InterruptedException, IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("CustomerLoginURL"));
		webDriverHandler = new WebDriverHandler(driver);
		CustomerLogin custlogin = new CustomerLogin(driver);
	}

	@AfterMethod
	public void terminateBrowser(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			driver.quit();
		}
	}
}