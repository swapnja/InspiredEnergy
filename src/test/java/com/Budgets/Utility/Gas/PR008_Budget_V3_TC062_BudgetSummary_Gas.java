
package com.Budgets.Utility.Gas;

import com.Base.ReadExcelFileGas;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

;

public class PR008_Budget_V3_TC062_BudgetSummary_Gas extends ReadExcelFileGas {


	public PR008_Budget_V3_TC062_BudgetSummary_Gas() throws IOException {
	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		ReadExcelFileGas.readSummary("");
		String StrActualSites = "Sites";
		String StrActualEstConsumption = "Est. Consumption (MWh)";
		String StrActualEstAverageRate = "Est. Average Rate (p/kWh)";
		String StrActualEstAnnualSpend = "Est. Annual Spend (£K)";
		double dblActualSites = 1;
		double dblActualEstConsumption = 3272;
		double dblActualEstAverageRate = 0.06;
		double dblActualEstAnnualSpend = 191;
		driver.findElement(By.xpath(prop.getProperty("searchTxtBox"))).sendKeys("Automation");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("FirstCustomer"))).click();
		Thread.sleep(1000);
		webDriverHandler.byXpath(prop.getProperty("sortByGas")).click().click();
		driver.findElement(By.xpath(prop.getProperty("SummaryGasBudgetCompleteIcon"))).click();
		System.out.println("");
		System.out.println("************************************************************");
		if (StrActualSites.equalsIgnoreCase(strGasSites) && dblGasSites == dblActualSites) {
			System.out.println("Sites Validated Successfully" + " and the value is  " + strGasSites + " " + dblActualSites);
		}
		System.out.println("");
		if (StrActualEstConsumption.equalsIgnoreCase(strGasEstConsumption) && dblGasEstConsumption == dblActualEstConsumption) {
			System.out.println("Est. Consumption (MWh) Validated Successfully" + " and the value is  " + strGasEstConsumption + " " + dblActualEstConsumption);
		}
		System.out.println("");
		if (StrActualEstAverageRate.equalsIgnoreCase(strGasEstAverageRate) && dblActualEstAverageRate == dblActualEstAverageRate) {
			System.out.println("Est. Average Rate (p/kWh) Validated Successfully" + " and the value is  " + strGasEstAverageRate + " " + dblActualEstAverageRate);
		}
		System.out.println("");
		if (StrActualEstAnnualSpend.equalsIgnoreCase(strGasEstAnnualSpend) && dblActualEstAnnualSpend == dblActualEstAnnualSpend) {
			System.out.println("Est. Annual Spend (£K) Validated Successfully" + " and the value is  " + strGasEstAnnualSpend + " " + dblActualEstAnnualSpend);
		}
		System.out.println("********************************************************");
	}
}