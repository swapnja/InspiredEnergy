//Test to verify Customer Grid if there are already registered customers for Standard Users

package com.Budgets.InitialFlows;

import com.Base.LoginPageHandler;
import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PR8_TC014_CustomerGrid_SearchFunctionality {
	public PR8_TC014_CustomerGrid_SearchFunctionality() throws IOException {
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
		LoginPageHandler login = new LoginPageHandler(webDriverHandler, prop);
		login.Login();
		login.accessBudgets();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test14() throws InterruptedException, IOException {
		WebElement input = driver.findElement(By.cssSelector("input[type='search']"));
		input.sendKeys("Swapnja");
		WebElement CustTable = driver.findElement(By.id(prop.getProperty("customerTable")));
		List<WebElement> allCustRows = CustTable.findElements(By.tagName("tr"));
		for (WebElement row : allCustRows) {
			List<WebElement> allCustCells = row.findElements(By.tagName("td"));
			System.out.println("***Search Result :***");
			for (WebElement cell : allCustCells) {
				System.out.println(cell.getText());
			}
		}
		System.out.println("****Search is working fine****");
	}
}
