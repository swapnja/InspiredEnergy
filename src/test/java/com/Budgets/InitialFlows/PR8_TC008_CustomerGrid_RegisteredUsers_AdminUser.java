//Test to verify Customer Grid if there are already registered customers for Admin Users

package com.Budgets.InitialFlows;

import com.Base.ReadPropertyFile;
import com.Base.WaitWebElement;
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
	public PR8_TC008_CustomerGrid_RegisteredUsers_AdminUser() throws IOException {
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
	public void login() {
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
	public void test8() throws InterruptedException{
		driver.findElement(By.linkText("Sign in with your Microsoft Account")).click();
		WaitWebElement.customWait(By.id(prop.getProperty("key.userName")), driver);
		driver.findElement(By.id(prop.getProperty("key.userName"))).sendKeys(prop.getProperty("value.AdminUser"));
		WaitWebElement.customWait(By.id("idSIButton9"), driver);
		driver.findElement(By.id("idSIButton9")).click();
		WaitWebElement.customWait(By.id(prop.getProperty("key.password")), driver);
		driver.findElement(By.id(prop.getProperty("key.password"))).sendKeys(prop.getProperty("value.AdminPassword"));
		Thread.sleep(2000);
		WebElement w1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]")));
		w1.click();
		driver.findElement(By.id("idBtn_Back")).click();
		WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("BudgetIcon")), driver);
		if (driver.findElement(By.id(prop.getProperty("customerTable"))).isDisplayed())
		{
			System.out.println("Customer grid is showing registered customers for Logged in User");
		} else {
			System.out.println("No Customer is registered at this moment for this Standard User");
		}
	}
}