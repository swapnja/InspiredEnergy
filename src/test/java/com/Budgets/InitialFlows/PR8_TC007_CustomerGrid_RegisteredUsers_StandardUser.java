//Test to verify Customer Grid if there are already registered customers for Standard Users

package com.Budgets.InitialFlows;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.WaitWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	WebElement webElement;
	WebDriver driver;
	
	@BeforeMethod
	public void login() throws InterruptedException, IOException 
{
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
	public void test7() throws InterruptedException, IOException {
		//webElement = driver.findElement(By.id("//*[@id='customerTable']"));
		//System.out.println(webElement);		
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", webElement);	
		Thread.sleep(1000);
	//	WaitWebElement.waitTillClickable(By.xpath(prop.getProperty("customerTable")), driver);	
		WebElement w1 = driver.findElement(By.xpath("//table[@id='customerTable']"));
		System.out.println(w1);
		if (w1.isDisplayed())
		{
			System.out.println("Customer grid is showing registered customers for Logged in User");
		} else {
			System.out.println("No Customer is registered at this moment for this Standard User");
		}
		//driver.quit();
	}
}
