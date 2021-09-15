//Verify to check all columns on grid is available along with validation 

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

public class PR8_TC013_Dashboard_NewCustomerScreen_AllColumns {
	public PR8_TC013_Dashboard_NewCustomerScreen_AllColumns() throws IOException {
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
		login.accessBudgets();;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

	@Test
	public void test6() {
		String Actual_crmId;
		String Expected_crmId = "CRM Id";
		Actual_crmId = driver.findElement(By.xpath("//table/thead/tr/th[1]")).getText();
		if (Actual_crmId.equalsIgnoreCase(Expected_crmId)) {
			System.out.println(Actual_crmId);
		}

		String Actual_crmInstance;
		String Expected_crmInstance = "CRM Instance";
		Actual_crmInstance = driver.findElement(By.xpath("//table/thead/tr/th[2]")).getText();
		if (Actual_crmInstance.equalsIgnoreCase(Expected_crmInstance)) {
			System.out.println(Actual_crmInstance);
		}

		String Actual_CustomerName;
		String Expected_CustomerName = "Customer Name";
		Actual_CustomerName = driver.findElement(By.xpath("//table/thead/tr/th[3]")).getText();
		if (Actual_CustomerName.equalsIgnoreCase(Expected_CustomerName)) {
			System.out.println(Actual_CustomerName);
		}

		String Actual_BudgetsAvailable;
		String Expected_BudgetsAvailable = "Budgets Available";
		Actual_BudgetsAvailable = driver.findElement(By.xpath("//table/thead/tr/th[4]")).getText();
		if (Actual_BudgetsAvailable.equalsIgnoreCase(Expected_BudgetsAvailable)) {
			System.out.println(Actual_BudgetsAvailable);
		}

		String Actual_LatestBudget;
		String Expected_LatestBudget = "Latest Budget";
		Actual_LatestBudget = driver.findElement(By.xpath("//table/thead/tr/th[5]")).getText();
		if (Actual_LatestBudget.equalsIgnoreCase(Expected_LatestBudget)) {
			System.out.println(Actual_LatestBudget);
		}

		String Actual_LastRun;
		String Expected_LastRun = "Last Run";
		Actual_LastRun = driver.findElement(By.xpath("//table/thead/tr/th[6]")).getText();
		if (Actual_LastRun.equalsIgnoreCase(Expected_LastRun)) {
			System.out.println(Actual_LastRun);
		}

	}
}
