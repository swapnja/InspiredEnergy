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

public class PR8_TC006_SignOut_StandardUser_Successful {
	Properties prop = ReadPropertyFile.getProperties();
	WebDriver driver;
	WebDriverHandler webDriverHandler;
	public PR8_TC006_SignOut_StandardUser_Successful() throws IOException {
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
		login.LoginStandardUser();
		login.accessBudgets();
	}
	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test6() throws InterruptedException, IOException {
		driver.findElement(By.xpath(prop.getProperty("SignOut"))).click();
		String act_SignOuttitle = driver.getTitle();
		String exp_SignOuttitle = "Login - Unify";
		if (act_SignOuttitle.equalsIgnoreCase(exp_SignOuttitle)) {
			System.out.println("Sign Out done Successfully for Standard User");
		} else {
			System.out.println("Oops, There is some Issue");
		}
		//driver.quit();
	}

}
