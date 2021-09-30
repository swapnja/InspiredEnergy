//Verify Information tab on Budget Console Screen : InProgress  defect is open
//Need to add below points
//change the value of Period data not numeric to Warning Amber validation once bug resolved
//Add the Upload file code
package com.Budgets.Utility.Electricity;

import com.Budgets.AbstractTestNg;
import com.Budgets.Data.ValidationHashes.ElectricityKVArhHashTables;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.ImportPageHandlerElectricity;
import com.Budgets.PageHandlers.ValidationPageHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Hashtable;

public class PR008_Budget_V3_TC058_Utility_Electricity_UserDefinedVolumeExceptionMorethanNormal_KVArh_InvalidInput_RedValidation
		extends AbstractTestNg {

	public PR008_Budget_V3_TC058_Utility_Electricity_UserDefinedVolumeExceptionMorethanNormal_KVArh_InvalidInput_RedValidation()
			throws IOException {

	}

	@Test
	public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {
		String[] _EKVAhrhHeaders = { "KVArhMMI", "KVArhID", "KVArhPDNN", "KVArhMPDID", "KVArhMDISPM", "KVArhDDSM",
				"KVArhPE" };
		CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
		customersPageHandler.waitLoad();
		customersPageHandler.filterCustomers("Automation");
		customersPageHandler.selectFirstCustomer();
		CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
		budgetPageHandler.selectFirstBudgetElectricity();
		waitInformation();
		webDriverHandler.byXpath(prop.getProperty("PeriodException")).clear().sendKeys("2.5");
		webDriverHandler.byId(prop.getProperty("BudgetSave")).click();
		webDriverHandler.byXpath("//button[contains(text(),'OK')]").waitVisible().click();
		ImportPageHandlerElectricity importPageHandler = new ImportPageHandlerElectricity(webDriverHandler, prop);
		webDriverHandler.byXpath(prop.getProperty("ElectricityKVArh")).waitClickable().click();
		ValidationPageHandler validationPageHandler = new ValidationPageHandler(webDriverHandler, prop);
		String filePath = Paths.get(
				"BudgetTestData/Electricity/KVArh/PR008_Budget_V3_TC013_Utility_Electricity_UserDefinedVolumeExceptionMorethanNormal_KVArh_ValidInput_GreenValidation.xlsx")
				.toAbsolutePath().toString();
		ElectricityKVArhHashTables mht = new ElectricityKVArhHashTables();
		Hashtable<String, String> ht = mht.getGreenHash();
		importPageHandler.genericImport(filePath);
		for (String kvaHeader : _EKVAhrhHeaders) {
			System.out.println(kvaHeader);
			validationPageHandler.GreenValidation(kvaHeader, ht, 'E');
		}
		importPageHandler.importExport();
		importPageHandler.verifyImport();
	}

	public void waitInformation() {
		String stringRef = webDriverHandler.byXpath(prop.getProperty("Reference")).getText();
		String stringSD = webDriverHandler.byXpath(prop.getProperty("StartDate")).getText();
		String stringED = webDriverHandler.byXpath(prop.getProperty("EndDate")).getText();

		webDriverHandler.byXpath(prop.getProperty("Reference")).waitClickable().sendKeys(stringRef);
		webDriverHandler.byXpath(prop.getProperty("Reference")).waitClickable().sendKeys(stringRef);
		webDriverHandler.byXpath(prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
		webDriverHandler.byXpath(prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
		webDriverHandler.byXpath(prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
		webDriverHandler.byXpath(prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
		webDriverHandler.byXpath(prop.getProperty("CalendarOutput")).waitClickable().selectByText("Custom");
		webDriverHandler.byXpath(prop.getProperty("CalendarOutput")).waitClickable().selectByText("Monthly");
	}

}
