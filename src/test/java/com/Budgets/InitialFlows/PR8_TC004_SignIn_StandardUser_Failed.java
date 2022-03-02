//Test to verify StandardUser failed login scenario
package com.Budgets.InitialFlows;

import com.Base.ReadPropertyFile;
import com.Base.WaitWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR8_TC004_SignIn_StandardUser_Failed {

	public PR8_TC004_SignIn_StandardUser_Failed() throws IOException {
		System.setProperty(prop.getProperty("chrome.driver.propName"), prop.getProperty("chrome.driver.path"));

	}

	Properties prop = ReadPropertyFile.getProperties();
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void deleteCookie() {

	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test4() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in with your Microsoft Account")).click();

		WaitWebElement.customWait(By.id(prop.getProperty("userName")), driver);

		driver.findElement(By.id(prop.getProperty("userName"))).sendKeys(prop.getProperty("StandardUser"));
		WaitWebElement.customWait(By.id("idSIButton9"), driver);
		driver.findElement(By.id("idSIButton9")).click();

		WaitWebElement.customWait(By.id(prop.getProperty("password")), driver);
		driver.findElement(By.id(prop.getProperty("password"))).sendKeys(prop.getProperty("wrongvalue.password"));
		try{
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='idSIButton9']"))));
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='idSIButton9']"))));
		}
		catch (Exception e){
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='idSIButton9']"))));
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='idSIButton9']"))));
		}
		WaitWebElement.waitTillClickable(By.xpath("//*[@id=\"idSIButton9\"]"), driver);
		String act_errorMsg = driver.findElement(By.id("passwordError")).getText();
		String exp_errorMsg = "Your account or password is incorrect. If you don't remember your password, reset it now.";
		if (exp_errorMsg.equalsIgnoreCase(act_errorMsg)) {
			System.out.println("Error message is Correct :- \n" + act_errorMsg);
		} else {
			System.out.println("Error message is in-correct");
		}
		driver.quit();
	}


}