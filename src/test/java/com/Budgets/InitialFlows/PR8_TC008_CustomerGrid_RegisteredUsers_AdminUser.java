//Test to verify Customer Grid if there are already registered customers for Admin Users

package com.Budgets.InitialFlows;
import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.WaitWebElement;
import com.Base.SeleniumHandlers.WebDriverHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

	public class PR8_TC008_CustomerGrid_RegisteredUsers_AdminUser {
		Properties prop = ReadPropertyFile.getProperties();
		WebDriver driver;
		WebDriverHandler webDriverHandler;
		
	public PR8_TC008_CustomerGrid_RegisteredUsers_AdminUser() throws IOException {
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
		login.Login();
		login.accessBudgets();
	}
	
	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void customerTableVerification() throws InterruptedException{
		
	//	WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("BudgetIcon")), driver);
		if (driver.findElement(By.xpath("//table[@id='customerTable']")).isDisplayed())
		{
			System.out.println("Customer grid is showing registered customers for Logged in User");
		} else {
			System.out.println("No Customer is registered at this moment for this Standard User");
		}
	}
}