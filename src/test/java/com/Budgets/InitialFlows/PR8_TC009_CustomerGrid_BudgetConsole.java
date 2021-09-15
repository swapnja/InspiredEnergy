//Test to verify  budget console from grid record
package com.Budgets.InitialFlows;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.WaitWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR8_TC009_CustomerGrid_BudgetConsole {
	public PR8_TC009_CustomerGrid_BudgetConsole() throws IOException {
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
	public void login() throws InterruptedException, IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
		LoginPageHandler login =new LoginPageHandler(webDriverHandler, prop);
		login.Login();
		login.accessBudgets();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test9() throws InterruptedException, IOException {
		WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("FirstCustomer")), driver);
		if (driver.findElement(By.id(prop.getProperty("budgetTable"))).isDisplayed()) ;
		System.out.println("You are on Budget console screen");
	}
}
