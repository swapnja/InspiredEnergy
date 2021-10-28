//Verify Information tab on Budget Console Screen 

package com.Budgets;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTestNg {
	
	
	public Properties prop;
	public com.Base.TimeStampPageHandler ts;
	public WebDriver driver;
	public WebDriverHandler webDriverHandler;
	public LoginPageHandler loginBud;

	public AbstractTestNg() throws IOException {
		prop = ReadPropertyFile.getProperties();
		ts = new TimeStampPageHandler();
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));
	}

	@BeforeTest
	public void launchBrowser() throws IOException {
	}

	@BeforeClass
	public void LoadUrl() throws InterruptedException {
		/*ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		chromeOptions.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(chromeOptions);
		*/
		driver = new ChromeDriver();
	//	((ChromeDriver) driver).setFileDetector(new LocalFileDetector());
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		webDriverHandler = new WebDriverHandler(driver);
   		driver.manage().window().maximize();
   		driver.get(prop.getProperty("url"));		
		loginBud = new LoginPageHandler(webDriverHandler, prop);
		loginBud.Login();
	}

	@BeforeMethod
	public void accessBud() {
		driver.get(prop.getProperty("url"));
		loginBud.accessBudgets();
	}

	@AfterMethod
	public void handleFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String name = this.getClass().getSimpleName();
			FailureUtils.screenshot(driver, "FailureOutput\\Screenshots\\Budgets\\"+name);
		}
	}

	@AfterClass
	public void terminateBrowser() {
		//driver.quit();
	}
}