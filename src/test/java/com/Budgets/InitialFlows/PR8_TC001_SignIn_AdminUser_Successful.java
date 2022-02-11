package com.Budgets.InitialFlows;

import com.Base.ExtentReportBase;
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

public class PR8_TC001_SignIn_AdminUser_Successful extends ExtentReportBase{

		
	Properties prop = ReadPropertyFile.getProperties();
	WebDriver driver;
	WebDriverHandler webDriverHandler;

	public PR8_TC001_SignIn_AdminUser_Successful() throws IOException {
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
		webDriverHandler = new WebDriverHandler(driver);
		LoginPageHandler login = new LoginPageHandler(webDriverHandler, prop);
		login.Login();
		login.accessBudgets();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException, IOException {
		String act_title = driver.getTitle();
		String expected_title = prop.getProperty("expectedTitleLogin");
		if (act_title.equalsIgnoreCase(expected_title)) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is Incorrect");
		}
		webDriverHandler.byXpath("//a[@href='/Core/Users/Profile']").clickrepeat();
		String act_UserContent = driver.findElement(By.id("basicContent")).getText();
		String ext_UserContent = "Hi IP Dev TP 2";

		if (act_UserContent.equalsIgnoreCase(ext_UserContent)) {
			System.out.println("This is Admin User");
		} else {
			System.out.println("This is Non Admin User");
		}
		System.out.println("Login is Successful with Admin User ");
	}
}