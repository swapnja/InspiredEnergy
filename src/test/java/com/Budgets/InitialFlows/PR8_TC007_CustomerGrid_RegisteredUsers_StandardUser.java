//Test to verify Customer Grid if there are already registered customers for Standard Users

package com.Budgets.InitialFlows;

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

public class PR8_TC007_CustomerGrid_RegisteredUsers_StandardUser {
	public PR8_TC007_CustomerGrid_RegisteredUsers_StandardUser() throws IOException {
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
		webDriverHandler.byXpath(prop.getProperty("HomeLogin")).waitClickable().click();
		webDriverHandler.byId(prop.getProperty("key.userName")).sendKeys(prop.getProperty("value.StandardUser"));
		webDriverHandler.byXpath(prop.getProperty("HomeSignIn")).waitClickable().click();
		webDriverHandler.byId(prop.getProperty("key.password")).sendKeys(prop.getProperty("value.StandardPassword"));
		webDriverHandler.byXpath(prop.getProperty("HomeSignIn")).staleElementHandler().staleElementHandler().waitClickable().click();
		webDriverHandler.byXpath(prop.getProperty("HomeStaySignedIn")).waitVisible(15,100).waitClickable(10,100).click();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test7() throws InterruptedException, IOException {
		WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("BudgetIcon")), driver);
		if (driver.findElement(By.id(prop.getProperty("customerTable"))).isDisplayed())
		{
			System.out.println("Customer grid is showing registered customers for Logged in User");
		} else {
			System.out.println("No Customer is registered at this moment for this Standard User");
		}
		driver.quit();
	}
}
