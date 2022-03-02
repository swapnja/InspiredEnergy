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


public class PR8_TC002_SignIn_AdminUser_Failed {
	Properties prop = ReadPropertyFile.getProperties();
	WebDriver driver;
	WebDriverHandler webDriverHandler;
	

	public PR8_TC002_SignIn_AdminUser_Failed() throws IOException {
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}
	@BeforeMethod
	public void login() throws InterruptedException, IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriverHandler = new WebDriverHandler(driver);
		LoginPageHandler login = new LoginPageHandler(webDriverHandler, prop);
		login.LoginWrongPwdAdmin();
		//login.accessBudgets();
		}

	@AfterMethod
	public void terminateBrowser() {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
		String act_title = "Your account or password is incorrect. If you don't remember your password, reset it now.";
		String expected_msg = prop.getProperty("expectedTitleLogin");
		if (act_title.equalsIgnoreCase(expected_msg)) {
			System.out.println("Error message is matched");
		} else {
			System.out.println("Error message is Matched");
		}
		
		
	    }
}