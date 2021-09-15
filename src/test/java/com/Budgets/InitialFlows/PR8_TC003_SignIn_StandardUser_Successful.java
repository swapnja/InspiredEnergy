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

public class PR8_TC003_SignIn_StandardUser_Successful {
	public PR8_TC003_SignIn_StandardUser_Successful() throws IOException {
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
	public void test3() {

		String act_title = driver.getTitle();
		String expected_title = prop.getProperty("expectedTitleLogin");
		if (act_title.equalsIgnoreCase(expected_title)) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is Incorrect");
		}
		driver.findElement(By.xpath("//a[@href='/Core/Users/Profile']")).click();
		String act_UserContent = driver.findElement(By.id("basicContent")).getText();
		String ext_UserContent = "Hi IP Dev TP 1";

		if (act_UserContent.equalsIgnoreCase(ext_UserContent)) {
			System.out.println("This is Standard User");
		} else {
			System.out.println("This is Non Standard User");
		}

		System.out.println("Login is Successful with Standard User ");
		driver.quit();

	}
}