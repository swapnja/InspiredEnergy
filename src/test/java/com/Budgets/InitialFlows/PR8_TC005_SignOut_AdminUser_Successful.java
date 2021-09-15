package com.Budgets.InitialFlows;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR8_TC005_SignOut_AdminUser_Successful {
	public PR8_TC005_SignOut_AdminUser_Successful() throws IOException {
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}

	Properties prop = ReadPropertyFile.getProperties();
	WebDriver driver;
	WebDriverHandler webDriverHandler;

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
	public void test5() {
		webDriverHandler.byXpath(prop.getProperty("SignOut")).clickrepeat();
		String act_SignOuttitle = driver.getTitle();
		String exp_SignOuttitle = "Login - Cumulus.Portal";
		if (act_SignOuttitle.equalsIgnoreCase(exp_SignOuttitle)) {
			System.out.println("Sign Out done Successfully for an Admin User");
		} else {
			System.out.println("Oops, There is some Issue");
		}
	}
}
