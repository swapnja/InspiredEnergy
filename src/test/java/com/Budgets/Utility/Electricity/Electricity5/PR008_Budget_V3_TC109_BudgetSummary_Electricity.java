
package com.Budgets.Utility.Electricity.Electricity5;

import com.Base.ReadExcelFileElectricity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR008_Budget_V3_TC109_BudgetSummary_Electricity extends ReadExcelFileElectricity {

	public PR008_Budget_V3_TC109_BudgetSummary_Electricity() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		
		ReadExcelFileElectricity.readSummary("");
		
		String StrActualSites="Sites";
		String StrActualEstConsumption="Est. Consumption (MWh)";
		String StrActualEstAverageRate="Est. Average Rate (p/kWh)";
		String StrActualEstAnnualSpend="Est. Annual Spend (£K)";
		
		double dblActualSites=2.0;
		double dblActualEstConsumption=2014.03849;
		double dblActualEstAverageRate=3.45;
		double dblActualEstAnnualSpend=6954.780940000001;

		//WaitWebElement.waitForGreenElement(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("searchTxtBox"))).sendKeys("Automation CRMId:07/01/2020 03:22:41 pm");
		Thread.sleep(1000);
		//WaitWebElement.waitForGreenElement(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
		driver.findElement(By.xpath(prop.getProperty("SummaryEleCustomer"))));
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("searchTxtBox"))).sendKeys("Automation Final Calculation");
		//WaitWebElement.waitForGreenElement(driver);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();",
		driver.findElement(By.xpath(prop.getProperty("SummaryEleBudgetCompleteIcon"))));
		System.out.println("");
		System.out.println("************************************************************");
		 
		if(StrActualSites.equalsIgnoreCase(strElectricitySites) && dblElectricitySites==dblActualSites)
		{
			System.out.println("Sites Validated Successfully"+ " and the value is  " +strElectricitySites+ "-"+dblActualSites);
		}
		 
		System.out.println("");
		 
		 
		if(StrActualEstConsumption.equalsIgnoreCase(strElectricityEstConsumption) && dblElectricityEstConsumption==dblActualEstConsumption)
		{
			System.out.println("Est. Consumption (MWh) Validated Successfully"+ " and the value is  " +strElectricityEstConsumption+"-"+dblActualEstConsumption);
		}

		 System.out.println("");
		
		 
		 if(StrActualEstAverageRate.equalsIgnoreCase(strElectricityEstAverageRate) && dblActualEstAverageRate==dblActualEstAverageRate)
		{
			System.out.println("Est. Average Rate (p/kWh) Validated Successfully"+ " and the value is  " +strElectricityEstAverageRate+"-"+dblActualEstAverageRate);
		}

		 System.out.println("");
		 
		if(StrActualEstAnnualSpend.equalsIgnoreCase(strElectricityEstAnnualSpend) && dblActualEstAnnualSpend==dblActualEstAnnualSpend)
		{
			System.out.println("Est. Annual Spend (£K) Validated Successfully"+ " and the value is  " +strElectricityEstAnnualSpend+"-"+dblActualEstAnnualSpend);
		}

		 System.out.println("********************************************************");	
			System.out.println("TC4");
			
					
	}

}