//Verify Information tab on Budget Console Screen 

package com.Pricecast;

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

public abstract class AbstractTestNg {

	public Properties prop;
	public TimeStampPageHandler ts;
	public WebDriver driver;
	public WebDriverHandler webDriverHandler;
	public LoginPageHandler logPriceCast;

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
		logPriceCast = new LoginPageHandler(webDriverHandler, prop);
		logPriceCast.Login();
	}
	

	@BeforeMethod
	public void accessAutoII() {
		driver.get(prop.getProperty("url"));
		logPriceCast.accessPriceCast();
	}

	@AfterMethod
	public void handleFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String name = this.getClass().getSimpleName();
			FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\PriceCast\\"+name);
		}
	}

	@AfterClass
	public void terminateBrowser() {
		//driver.quit();
	}
}