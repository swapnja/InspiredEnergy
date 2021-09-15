package com.Budgets.InitialFlows;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR8_TC015_Https404PageNotFound {
	public PR8_TC015_Https404PageNotFound() throws IOException {
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}

	Properties prop = ReadPropertyFile.getProperties();

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws IOException {

	}

	@BeforeClass
	public void deleteCookie() {

	}

	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
		LoginPageHandler login = new LoginPageHandler(webDriverHandler, prop);
		login.Login();
		login.accessBudgets();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test15() throws InterruptedException, IOException {
	//HTTP Error 404. The requested resource is not found.
	        driver.get("https://devcumulus.inspiredenergy.co.uk/Budgets/Home/Dashboard");
	        boolean a;
	        try {
	        	a=driver.findElement(By.xpath("//*[contains(text(),'404')]")).isDisplayed();
	        }
	        catch(Exception e) {
	        	a=false;
	        }
	        if(a)
	        {   
	        	System.out.println("There is Systen Outage");
	        }
	        else
	        {
	        	System.out.println("Welcome to Cumulus system");
	        }
}
}
