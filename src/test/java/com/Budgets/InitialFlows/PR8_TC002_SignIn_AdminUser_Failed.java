package com.Budgets.InitialFlows;

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

	public PR8_TC002_SignIn_AdminUser_Failed() throws IOException {
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}

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
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
		webDriverHandler.byXpath(prop.getProperty("HomeLogin")).waitClickable().click();
		webDriverHandler.byId(prop.getProperty("key.userName")).sendKeys(prop.getProperty("value.AdminUser"));
		webDriverHandler.byXpath(prop.getProperty("HomeSignIn")).waitClickable().click();
		webDriverHandler.byId(prop.getProperty("key.password")).sendKeys(prop.getProperty("wrongvalue.password"));
		webDriverHandler.byXpath(prop.getProperty("HomeSignIn")).staleElementHandler().staleElementHandler().waitClickable().click();
        String act_errorMsg=driver.findElement(By.id("passwordError")).getText();
		String exp_errorMsg="Your account or password is incorrect. If you don't remember your password, reset it now.";
		if(exp_errorMsg.equalsIgnoreCase(act_errorMsg)) 
		{
		System.out.println("Error message is Correct :- \n"+ act_errorMsg);
		}
		else
		{
		System.out.println("Error message is in-correct");
		}
    }
}